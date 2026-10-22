package com.ss.android.socialbase.downloader.cleaner;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class CleanerConfig {
    private static final int FORCE_CLEAN_ID = -1;
    private static final String KEY_CLEAN_FINISH = "key_clean_finish";
    private static final String KEY_CLEAN_TIME = "key_clean_time";
    private static final String KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY = "key_download_cache_clean_strategy";
    private static final String KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME = "key_download_cache_last_directory_clean_time";
    private static final String KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME = "key_download_cache_last_report_time";
    private static final String KEY_UPDATE_SP_INFO_TIME = "key_update_sp_info_time";
    private static final String TAG = "CleanerConfig";
    private volatile Map<Integer, List<Integer>> mCleanCacheKeyMaps;
    private volatile Set<Integer> mCleanDownloadIdSet;
    private volatile Map<Integer, CleanItem> mCleanItemMaps;
    private volatile Map<Integer, String> mFileDirPathMap;
    private volatile Map<Integer, String> mFileNameMap;
    private volatile boolean mFinish;
    private volatile Map<Integer, CleanItem> mNeedCleanItemMaps;
    private volatile Set<Integer> mOnlyCleanFileSet;
    private String mPackageName;
    private volatile Map<Integer, String> mTempSavePath;

    public void finish() {
        this.mFinish = true;
        this.mCleanItemMaps.clear();
        this.mNeedCleanItemMaps.clear();
        clearData();
    }

    public void clearData() {
        this.mCleanCacheKeyMaps.clear();
        this.mFileDirPathMap.clear();
        this.mFileNameMap.clear();
        this.mTempSavePath.clear();
        this.mOnlyCleanFileSet.clear();
        this.mCleanDownloadIdSet.clear();
    }

    public long getCacheLastReportTime() {
        return getLong(KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME);
    }

    public long getLastCleanDirectoryTime() {
        return getLong(KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME);
    }

    public boolean isNeedClean() {
        return !this.mNeedCleanItemMaps.isEmpty();
    }

    public boolean isNoCacheNeedClean() {
        return this.mCleanDownloadIdSet.isEmpty();
    }

    public void updateCacheReportTime() {
        putLong(KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME, System.currentTimeMillis());
    }

    public void updateCleanDirectoryTime() {
        putLong(KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME, System.currentTimeMillis());
    }

    public CleanerConfig() {
        this.mCleanItemMaps = new HashMap();
        this.mNeedCleanItemMaps = new HashMap();
        this.mCleanCacheKeyMaps = new HashMap();
        this.mCleanDownloadIdSet = new CopyOnWriteArraySet();
        this.mFileDirPathMap = new HashMap();
        this.mFileNameMap = new HashMap();
        this.mTempSavePath = new HashMap();
        this.mOnlyCleanFileSet = new HashSet();
        this.mFinish = false;
    }

    private SharedPreferences getDownloadCacheSp() {
        return DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0);
    }

    public boolean checkTimeInterval() {
        int r0 = DownloadSetting.obtainGlobal().optInt("clean_interval_d");
        if (r0 > 0) goto L5;
        return true;
    L5:
        long r3 = getLong(KEY_CLEAN_TIME);
        if (r3 > 0) goto L8;
    L14:
        putLong(KEY_CLEAN_TIME, System.currentTimeMillis());
        return true;
    L8:
        if ((System.currentTimeMillis() - r3) >= (((long) r0) * DownloadConstants.DAY)) goto L14;
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "start", "It has already been clean, lastCleanTime:" + r3);
        return false;
    L16:
        return false;
    }

    public boolean checkUpdateSPInfoTimeInterval() {
        int r0 = DownloadSetting.obtainGlobal().optInt("update_download_sp_info_interval_d");
        if (r0 > 0) goto L5;
        return true;
    L5:
        long r3 = getLong(KEY_UPDATE_SP_INFO_TIME);
        if (r3 > 0) goto L8;
    L14:
        putLong(KEY_UPDATE_SP_INFO_TIME, System.currentTimeMillis());
        return true;
    L8:
        if ((System.currentTimeMillis() - r3) >= (((long) r0) * DownloadConstants.DAY)) goto L14;
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "checkUpdateSPInfoTimeInterval", "It has already updated sp info, lastUpdateTime:" + r3);
        return false;
    L16:
        return false;
    }

    public void init() {
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (DownloadComponentManager.getAppContext() != null) goto L5;
        return;
    L5:
        String r0 = DownloadComponentManager.getAppContext().getPackageName();     // Catch: Throwable -> L19
        this.mPackageName = r0;     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r0) == false) goto L8;
        return;
    L8:
        parseCleanSetting(getString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY));     // Catch: Throwable -> L19
        parseCleanSetting(DownloadSetting.getGlobalSettings());     // Catch: Throwable -> L19
        DirectoryCleaner.init(this);     // Catch: Throwable -> L19
        if (this.mCleanItemMaps.isEmpty() == false) goto L11;
        return;
    L11:
        Iterator<Map.Entry<Integer, CleanItem>> r1 = this.mCleanItemMaps.entrySet().iterator();     // Catch: Throwable -> L19
    L13:
        if (r1.hasNext() == false) goto L30;
        Map.Entry<Integer, CleanItem> r2 = r1.next();     // Catch: Throwable -> L19
        CleanItem r3 = r2.getValue();     // Catch: Throwable -> L19
        if (r3.finish == true) goto L13;
        this.mNeedCleanItemMaps.put(r2.getKey(), r3);     // Catch: Throwable -> L19
        goto L13
    }

    public boolean isCacheCleanEnabled() {
        if (checkTimeInterval() == true) goto L5;
    L9:
        return false;
    L5:
        if (isNoCacheNeedClean() == true) goto L7;
    L8:
        return true;
    L7:
        if (DirectoryCleaner.isEnabled() == false) goto L9;
        goto L8
    }

    public Map<Integer, List<Integer>> getCleanCacheKeyMaps() {
        return this.mCleanCacheKeyMaps;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    private void addToCleanDownloadIdSet(int r2) {
        if (this.mFinish == false) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        return;
    L7:
        this.mCleanDownloadIdSet.add(Integer.valueOf(r2));
    }

    private long getLong(String r5) {
        return getDownloadCacheSp().getLong(r5, 0);
    L5:
        th = move-exception;
        Logger.globalError(TAG, "getLong", "Error:" + th);
        return 0;
    }

    private String getString(String r4) {
        return getDownloadCacheSp().getString(r4, "");
    L5:
        th = move-exception;
        Logger.globalError(TAG, "getString", "Error:" + th);
        return "";
    }

    private void parseCleanSetting(JSONObject r12) throws Throwable {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "parseCleanSetting", "Run");
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        JSONArray r13 = r12.optJSONArray("clean_group");
        if (r13 != null) goto L10;
        return;
    L10:
        if (r13.length() <= 0) goto L82;
        int r3 = 0;
    L14:
        if (r3 >= r13.length()) goto L63;
        JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r13, r3);
        int r5 = r4.optInt("clean_id");
        if (this.mCleanItemMaps.containsKey(Integer.valueOf(r5)) == true) goto L61;
        CleanItem r6 = new CleanItem(this, null);
        boolean r7 = r4.optBoolean(KEY_CLEAN_FINISH);
        r6.finish = r7;
        if (r7 == false) goto L21;
        this.mCleanItemMaps.put(Integer.valueOf(r5), r6);
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r5), new ArrayList());
        goto L61
    L21:
        JSONArray r8 = r4.optJSONArray("monitor_scene_list");
        if (r8 != null) goto L24;
    L32:
        JSONArray r9 = r4.optJSONArray("url_prefix_list");
        if (r9 != null) goto L35;
    L43:
        JSONArray r10 = r4.optJSONArray("save_path_list");
        if (r10 == null) goto L55;
        if (r10.length() <= 0) goto L55;
        int r11 = 0;
    L49:
        if (r11 >= r10.length()) goto L55;
        String r14 = r10.optString(r11);
        if (TextUtils.isEmpty(r14) == true) goto L53;
        r6.savePaths.add(r14);
    L53:
        r11 = r11 + 1;
    L55:
        if (r6.scenes.isEmpty() == true) goto L57;
    L60:
        this.mCleanItemMaps.put(Integer.valueOf(r5), r6);
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r5), new ArrayList());
        goto L61
    L57:
        if (r6.prefixUrls.isEmpty() == false) goto L60;
        if (r6.savePaths.isEmpty() == true) goto L61;
    L35:
        if (r9.length() <= 0) goto L43;
        int r15 = 0;
    L38:
        if (r15 >= r9.length()) goto L43;
        String r16 = r9.optString(r15);
        if (TextUtils.isEmpty(r16) == true) goto L42;
        r6.prefixUrls.add(r16);
    L42:
        r15 = r15 + 1;
        goto L38
    L24:
        if (r8.length() <= 0) goto L32;
        int r17 = 0;
    L27:
        if (r17 >= r8.length()) goto L32;
        String r18 = r8.optString(r17);
        if (TextUtils.isEmpty(r18) == true) goto L31;
        r6.scenes.add(r18);
    L31:
        r17 = r17 + 1;
    L61:
        r3 = r3 + 1;
        goto L14
    L63:
        if (Logger.debug() == false) goto L81;
        Logger.globalDebug(TAG, "parseCleanSetting", "Result: " + this.mCleanItemMaps);
        return;
    L81:
        return;
    }

    private void saveFilePath(CleanDownloadInfo r4) {
        if (TextUtils.isEmpty(r4.getSavePath()) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.getName()) == true) goto L11;
        this.mFileDirPathMap.put(Integer.valueOf(r4.getId()), r4.getSavePath());
        this.mFileNameMap.put(Integer.valueOf(r4.getId()), r4.getName());
        if (TextUtils.isEmpty(r4.getTempPath()) == true) goto L12;
        this.mTempSavePath.put(Integer.valueOf(r4.getId()), r4.getTempPath());
        return;
    L12:
        return;
    }

    public String getName(int r2) {
        return this.mFileNameMap.get(Integer.valueOf(r2));
    }

    public String getSavePath(int r2) {
        return this.mFileDirPathMap.get(Integer.valueOf(r2));
    }

    public String getTempSavePath(int r2) {
        return this.mTempSavePath.get(Integer.valueOf(r2));
    }

    public boolean isExistInCleanSet(int r2) {
        if (this.mFinish == false) goto L5;
        return false;
    L5:
        if (this.mCleanDownloadIdSet.isEmpty() == false) goto L8;
        return false;
    L8:
        return this.mCleanDownloadIdSet.contains(Integer.valueOf(r2));
    }

    public boolean isOnlyCleanFile(int r2) {
        return this.mOnlyCleanFileSet.contains(Integer.valueOf(r2));
    }

    public void removeFromCleanDownloadIdSet(int r2) {
        this.mCleanDownloadIdSet.remove(Integer.valueOf(r2));
    }

    public boolean updateCleanDownloadId(CleanDownloadInfo r5) {
        Iterator<Map.Entry<Integer, CleanItem>> r0 = this.mNeedCleanItemMaps.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Integer, CleanItem> r1 = r0.next();
        if (matchCleanItem(r1.getValue(), r5) == false) goto L4;
        addCleanDownloadItem(r1.getKey().intValue(), r5, false);
        return true;
    L9:
        return false;
    }

    public void updateCleanSetting(int r11) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "updateCleanSetting", "Run:" + r11);
    L6:
        if (this.mCleanItemMaps.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mCleanItemMaps.get(Integer.valueOf(r11)) != null) goto L10;
        return;
    L10:
        if (this.mCleanItemMaps.get(Integer.valueOf(r11)).finish == true) goto L56;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L40
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<Map.Entry<Integer, CleanItem>> r4 = this.mCleanItemMaps.entrySet().iterator();     // Catch: Throwable -> L40
    L14:
        if (r4.hasNext() == false) goto L38;
        Map.Entry<Integer, CleanItem> r5 = r4.next();     // Catch: Throwable -> L40
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L40
        r6.put("clean_id", r5.getKey());     // Catch: Throwable -> L40
        CleanItem r7 = r5.getValue();     // Catch: Throwable -> L40
        if (r7.finish == false) goto L18;
    L21:
        boolean r8 = true;
    L22:
        r7.finish = r8;     // Catch: Throwable -> L40
        r6.put(KEY_CLEAN_FINISH, r8);     // Catch: Throwable -> L40
        if (r7.finish == true) goto L24;
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L40
        Iterator r10 = r7.scenes.iterator();     // Catch: Throwable -> L40
    L27:
        if (r10.hasNext() == false) goto L29;
        r9.put((String) r10.next());     // Catch: Throwable -> L40
        goto L27
    L29:
        r6.put("monitor_scene_list", r9);     // Catch: Throwable -> L40
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L40
        Iterator r13 = r7.prefixUrls.iterator();     // Catch: Throwable -> L40
    L31:
        if (r13.hasNext() == false) goto L33;
        r12.put((String) r13.next());     // Catch: Throwable -> L40
        goto L31
    L33:
        r6.put("url_prefix_list", r12);     // Catch: Throwable -> L40
        JSONArray r14 = new JSONArray();     // Catch: Throwable -> L40
        Iterator r15 = r7.savePaths.iterator();     // Catch: Throwable -> L40
    L35:
        if (r15.hasNext() == false) goto L37;
        r14.put((String) r15.next());     // Catch: Throwable -> L40
        goto L35
    L37:
        r6.put("save_path_list", r14);     // Catch: Throwable -> L40
        r3.put(r6);     // Catch: Throwable -> L40
        goto L14
    L24:
        r3.put(r6);     // Catch: Throwable -> L40
        goto L14
    L18:
        if (r5.getKey().intValue() == r11) goto L21;
        r8 = false;
        goto L22
    L38:
        r0.put("clean_group", r3);     // Catch: Throwable -> L40
        putString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY, r0.toString());     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "updateCleanSetting", "Error:" + th);
        return;
    }

    private void parseCleanSetting(String r2) throws Throwable {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        parseCleanSetting(new JSONObject(r2));
    }

    public static File getRealExternalFile(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L19:
        return null;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        String r6 = "Android/data/" + r5;
        int r0 = r6.length();
        if (r4.length() > r0) goto L10;
        return null;
    L10:
        File r2 = DownloadDirUtils.getExternalCacheDir(DownloadComponentManager.getAppContext(), false);
        if (r2 != null) goto L13;
        return null;
    L13:
        String r3 = r2.getParent();
        if (r4.startsWith(r6) == false) goto L19;
        if (TextUtils.isEmpty(r3) == true) goto L19;
        return new PolarisFileWrapper(r3, r4.substring(r0));
    }

    public static File getRealInternalFile(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        int r0 = r5.length();
        if (r4.length() > r0) goto L8;
        return null;
    L8:
        File r2 = DownloadDirUtils.getFilesDir(DownloadComponentManager.getAppContext(), false);
        if (r2 != null) goto L11;
        return null;
    L11:
        String r3 = r2.getParent();
        if (r4.startsWith(r5) == true) goto L14;
    L17:
        return null;
    L14:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        return new PolarisFileWrapper(r3, r4.substring(r0));
    }

    private boolean matchCleanItem(CleanItem r6, CleanDownloadInfo r7) {
        if (r6 == null) goto L42;
        if (r7 == null) goto L42;
        if (TextUtils.isEmpty(r7.getSavePath()) == true) goto L42;
        if (r6.scenes.isEmpty() == true) goto L16;
        if (TextUtils.isEmpty(r7.getMonitorScene()) == true) goto L16;
        if (r6.scenes.contains(r7.getMonitorScene()) == false) goto L16;
        return true;
    L16:
        if (r6.prefixUrls.isEmpty() == true) goto L27;
        String r1 = r7.getUrl();
        if (TextUtils.isEmpty(r1) == false) goto L20;
        return false;
    L20:
        Iterator r3 = r6.prefixUrls.iterator();
    L22:
        if (r3.hasNext() == false) goto L27;
        if (r1.startsWith((String) r3.next()) == false) goto L22;
        return true;
    L27:
        if (r6.savePaths.isEmpty() == true) goto L42;
        if (TextUtils.isEmpty(this.mPackageName) == true) goto L42;
        String r8 = r7.getSavePath();
        if (TextUtils.isEmpty(r8) == false) goto L34;
        return false;
    L34:
        if (r8.indexOf(this.mPackageName) > 0) goto L37;
        return false;
    L37:
        if (r8.endsWith("/") == false) goto L40;
        r8 = r8.substring(0, r8.length() - 1);
    L40:
        if (r6.savePaths.contains(r8) == false) goto L42;
        return true;
    L42:
        return false;
    }

    private void putLong(String r2, long r3) {
        getDownloadCacheSp().edit().putLong(r2, r3).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.globalError(TAG, "putLong", "Error:" + th);
    }

    private void putString(String r2, String r3) {
        getDownloadCacheSp().edit().putString(r2, r3).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.globalError(TAG, "putString", "Error:" + th);
    }

    public boolean forceUpdateCleanDownloadId(CleanDownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        addCleanDownloadItem(-1, r2, r3);
        return true;
    }

    private void addCleanDownloadItem(int r3, CleanDownloadInfo r4, boolean r5) {
        List<Integer> r0 = this.mCleanCacheKeyMaps.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        r0.add(Integer.valueOf(r4.getId()));
        addToCleanDownloadIdSet(r4.getId());
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r3), r0);
        saveFilePath(r4);
        if (r5 == false) goto L9;
        this.mOnlyCleanFileSet.add(Integer.valueOf(r4.getId()));
        return;
    }
}
