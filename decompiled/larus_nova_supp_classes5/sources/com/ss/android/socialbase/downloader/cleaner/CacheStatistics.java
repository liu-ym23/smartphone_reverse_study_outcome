package com.ss.android.socialbase.downloader.cleaner;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class CacheStatistics {
    private static final String CACHE_NAME = "name";
    private static final String CACHE_SIZE = "size";
    private static final String COUNT = "count";
    private static final String DURATION = "duration";
    private static final String NO_MATCH_DB = "NoMatchDB";
    private static final String TAG = "CleanerStatistics";
    private static final String TEMP_CACHE_SIZE = "tpSize";
    private static final String TEMP_SUFFIX = ".tp";
    private static final int TEMP_SUFFIX_LENGTH = 3;
    private static final String TOP_CACHE = "topCache";
    private static final String TOTAL_CACHE = "totalCache";
    private static final String UNKNOWN = "UNKNOWN";
    private Map<String, Map<String, DownloadDiskInfo>> mPathDiskInfoMap;
    private int mTopCacheCount;

    private void report() throws Throwable {
        if (this.mPathDiskInfoMap.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, Map<String, DownloadDiskInfo>>> r2 = this.mPathDiskInfoMap.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L24;
        Map.Entry<String, Map<String, DownloadDiskInfo>> r3 = r2.next();
        String r4 = r3.getKey();
        Map<String, DownloadDiskInfo> r5 = r3.getValue();
        if (r5.isEmpty() == true) goto L7;
        JSONObject r6 = new JSONObject();
        Iterator<Map.Entry<String, DownloadDiskInfo>> r7 = r5.entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L22;
        Map.Entry<String, DownloadDiskInfo> r8 = r7.next();
        String r9 = r8.getKey();
        DownloadDiskInfo r10 = r8.getValue();
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        r12.put(CACHE_SIZE, r10.mTotalCache.mSize);
        r12.put(TEMP_CACHE_SIZE, r10.mTotalCache.mTpSize);
        r12.put(DURATION, r10.mTotalCache.mDuration);
        r12.put("count", r10.mTotalCache.mCount);
        r11.put(TOTAL_CACHE, r12);
        JSONArray r13 = new JSONArray();
        Iterator r14 = r10.mTopCache.iterator();
        int r15 = 0;
    L16:
        if (r14.hasNext() == false) goto L21;
        CacheSize r16 = (CacheSize) r14.next();
        r15 = r15 + 1;
        if (r15 > this.mTopCacheCount) goto L21;
        JSONObject r17 = new JSONObject();
        Iterator<Map.Entry<String, Map<String, DownloadDiskInfo>>> r18 = r2;
        Iterator<Map.Entry<String, DownloadDiskInfo>> r19 = r7;
        r17.put(CACHE_SIZE, r16.mSize);
        r17.put(TEMP_CACHE_SIZE, r16.mTpSize);
        r17.put("name", r16.mName);
        r17.put(DURATION, r16.mDuration);
        r13.put(r17);
        r2 = r18;
        r7 = r19;
    L21:
        r11.put(TOP_CACHE, r13);
        r6.put(r9, r11);
        r2 = r2;
        r7 = r7;
        goto L13
    L22:
        r1.put(r4, r6);
        goto L7
    L24:
        if (r1.length() > 0) goto L26;
        return;
    L26:
        DownloadMonitorHelper.monitorDownloadDiskCache(r1);
    }

    public CacheStatistics() {
        this.mPathDiskInfoMap = new HashMap();
    }

    private void handleCachePath(File r8) {
        Map<String, DownloadDiskInfo> r0 = this.mPathDiskInfoMap.get(r8.getAbsolutePath());
        if (r0 != null) goto L5;
        r0 = new HashMap();
        this.mPathDiskInfoMap.put(r8.getAbsolutePath(), r0);
    L5:
        List r1 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfosBySavePath(r8.getAbsolutePath() + "%");
        HashMap r2 = new HashMap();
        if (r1 != null) goto L8;
    L13:
        handleCacheSize(r8, r0, r2);
        return;
    L8:
        if (r1.isEmpty() == true) goto L13;
        Iterator r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        DownloadInfo r4 = (DownloadInfo) r3.next();
        r2.put(new DownloadFile(r4.getSavePath(), r4.getName()).getAbsolutePath(), r4);
        goto L11
    }

    private void runImpl(CleanerConfig r4) throws Throwable {
        this.mTopCacheCount = DownloadSetting.obtainGlobal().optInt("monitor_cache_top_count");
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "run", "TopCacheCount:" + this.mTopCacheCount);
    L6:
        if (this.mTopCacheCount > 0) goto L8;
        return;
    L8:
        handleCachePath(r4);
        report();
    }

    public static void start(CleanerConfig r12) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "start", "Run");
    L5:
        int r0 = DownloadSetting.obtainGlobal().optInt("monitor_cache_delay_time_s");
        if (r0 > 0) goto L8;
        return;
    L8:
        int r3 = DownloadSetting.obtainGlobal().optInt("monitor_cache_interval_d");
        if (r3 <= 0) goto L20;
        long r4 = r12.getCacheLastReportTime();
        if (r4 > 0) goto L13;
    L18:
        r12.updateCacheReportTime();
        goto L20
    L13:
        if ((System.currentTimeMillis() - r4) >= (((long) r3) * DownloadConstants.DAY)) goto L18;
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "start", "It has already been reported, lastReportTime:" + r4);
        return;
    L24:
        return;
    L20:
        if (DownloadComponentManager.getAppContext() != null) goto L22;
        return;
    L22:
        DownloadComponentManager.submitScheduleTask(new 1(r12), r0, TimeUnit.SECONDS);
    }

    private void handleCachePath(CleanerConfig r6) {
        if (TextUtils.isEmpty(DownloadComponentManager.getAppContext().getPackageName()) == false) goto L5;
        return;
    L5:
        JSONArray r0 = DownloadSetting.obtainGlobal().optJSONArray("monitor_cache_path_list");
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length() <= 0) goto L30;
        int r1 = 0;
    L12:
        if (r1 >= r0.length()) goto L31;
        String r2 = r0.optString(r1);
        File r3 = CleanerConfig.getRealExternalFile(r2, r6.getPackageName());
        if (r3 != null) goto L16;
    L18:
        File r4 = CleanerConfig.getRealInternalFile(r2, r6.getPackageName());
        if (r4 == null) goto L23;
        if (r4.isDirectory() == false) goto L23;
        handleCachePath(r4);
    L23:
        r1 = r1 + 1;
        goto L12
    L16:
        if (r3.isDirectory() == false) goto L18;
        handleCachePath(r3);
        goto L23
    L31:
        return;
    }

    public static /* synthetic */ void access$100(CacheStatistics r0, CleanerConfig r1) throws Throwable {
        r0.runImpl(r1);
    }

    private void handleCacheSize(File r8, Map<String, DownloadDiskInfo> r9, Map<String, DownloadInfo> r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.exists() == false) goto L46;
        int r1 = 0;
        if (r8.isFile() == false) goto L33;
        String r0 = r8.getAbsolutePath();
        if (TextUtils.isEmpty(r0) == false) goto L12;
        return;
    L12:
        if (r0.endsWith(TEMP_SUFFIX) == false) goto L16;
        int r2 = r0.length();
        int r4 = TEMP_SUFFIX_LENGTH;
        if (r2 <= r4) goto L16;
        r0 = r0.substring(0, r0.length() - r4);
    L17:
        DownloadInfo r11 = r10.get(r0);
        if (r11 != null) goto L20;
        String r12 = NO_MATCH_DB;
    L23:
        DownloadDiskInfo r3 = r9.get(r12);
        if (r3 != null) goto L26;
        r3 = new DownloadDiskInfo(this, null);
    L26:
        CacheSize r5 = new CacheSize(this, null);
        if (r1 == 0) goto L29;
        r5.mSize = r8.length();
    L30:
        r5.mDuration = System.currentTimeMillis() - r8.lastModified();
        r5.mName = r8.getName();
        r3.mTopCache.add(r5);
        CacheSize r13 = r3.mTotalCache;
        r13.mSize += r5.mSize;
        r13.mTpSize += r5.mTpSize;
        r13.mDuration += r5.mDuration;
        r13.mCount++;
        r9.put(r12, r3);
        return;
    L29:
        r5.mTpSize = r8.length();
        goto L30
    L20:
        r12 = r11.getMonitorScene();
        if (TextUtils.isEmpty(r12) == false) goto L23;
        r12 = UNKNOWN;
    L16:
        r1 = 1;
        goto L17
    L33:
        if (r8.isDirectory() == true) goto L35;
        return;
    L35:
        File[] r14 = r8.listFiles();
        if (r14 != null) goto L38;
        return;
    L38:
        if (r14.length > 0) goto L41;
        return;
    L41:
        if (r1 >= r14.length) goto L48;
        handleCacheSize(r14[r1], r9, r10);
        r1 = r1 + 1;
        goto L41
    L48:
        return;
    }
}
