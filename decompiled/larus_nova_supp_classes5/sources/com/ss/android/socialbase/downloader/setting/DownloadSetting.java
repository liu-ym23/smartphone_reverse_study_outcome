package com.ss.android.socialbase.downloader.setting;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadSetting {
    private static final int POOL_SIZE = 16;
    private static final String TAG = "DownloadSetting";
    private static final LruCache<Integer, DownloadSetting> sCache = null;
    private static JSONObject sDisabledTaskKeys;
    private static final DownloadSetting sGlobal = null;
    private static Boolean sGlobalBugFixDefault;
    private static JSONObject sGlobalBugFixSetting;
    private static JSONObject sGlobalTaskSetting;
    private static DownloadSetting sLastSetting;
    private static boolean sTaskSettingDisabled;
    private final Boolean mBugFixDefault;
    private final JSONObject mBugFixSetting;
    private int mDownloadId;
    private final JSONObject mTaskSetting;

    static {
        sCache = new LruCache(16, 16);
        sGlobal = new DownloadSetting(null);
        boolean r0 = DownloadUtils.isEnableDownloadSettingInit();
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "construct", "EnableDownloadSettingInit:" + r0);
    L5:
        if (r0 == false) goto L8;
        init();
        return;
    }

    public static JSONObject getGlobalSettings() {
        return ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadSetting();
    }

    public static void init() {
        JSONObject r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadSetting();
        boolean r2 = false;
        if (r0.optInt("disable_task_setting", 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        sTaskSettingDisabled = r1;
        sDisabledTaskKeys = r0.optJSONObject("disabled_task_keys");
        sGlobalTaskSetting = r0.optJSONObject("global_task_setting");
        JSONObject r3 = r0.optJSONObject("bugfix");
        if (r3 != null) goto L9;
    L14:
        Boolean r4 = null;
    L15:
        sGlobalBugFixSetting = r3;
        sGlobalBugFixDefault = r4;
        if (Logger.debug() == false) goto L19;
        Logger.globalDebug(TAG, "init", "SettingUpdate:" + r0.toString());
        return;
    L19:
        return;
    L9:
        if (r3.has("default") == false) goto L14;
        if (r3.optInt("default", 0) != 1) goto L13;
        r2 = true;
    L13:
        r4 = Boolean.valueOf(r2);
        goto L15
    L5:
        r1 = false;
        goto L6
    }

    public String toString() {
        return "DownloadSetting{mTaskSetting=" + this.mTaskSetting + ", mBugFixSetting=" + this.mBugFixSetting + ", mBugFixDefault=" + this.mBugFixDefault + ", mDownloadId=" + this.mDownloadId + ", globalSetting=" + getGlobalSettings() + '}';
    L5:
        th = move-exception;
        Logger.globalError(TAG, "toString", "Error:" + th);
        return "DownloadSetting Error";
    }

    public static JSONObject getGlobalTaskSettings() {
        return sGlobalTaskSetting;
    }

    public static DownloadSetting obtainGlobal() {
        return sGlobal;
    }

    private DownloadSetting(JSONObject r5) {
        this.mTaskSetting = r5;
        JSONObject r0 = null;
        Boolean r1 = null;
        r1 = null;
        r1 = null;
        if (r5 != null) goto L5;
    L17:
        Boolean r6 = null;
    L18:
        this.mBugFixSetting = r0;
        this.mBugFixDefault = r6;
        return;
    L5:
        if (isTaskKeyDisabled("bugfix") == true) goto L17;
        JSONObject r7 = r5.optJSONObject("bugfix");
        if (r7 != null) goto L9;
    L16:
        Boolean r3 = r1;
        r0 = r7;
        r6 = r3;
        goto L18
    L9:
        if (r7.has("default") == false) goto L16;
        if (isTaskKeyDisabled("default") == true) goto L16;
        boolean r2 = false;
        if (r7.optInt("default", 0) != 1) goto L15;
        r2 = true;
    L15:
        r1 = Boolean.valueOf(r2);
        goto L16
    }

    private static DownloadSetting create(DownloadInfo r2) {
        if (sTaskSettingDisabled == true) goto L5;
        String r0 = r2.getDownloadSettingString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r0) == true) goto L9;
        JSONObject r1 = new JSONObject(r0);     // Catch: Throwable -> L14
    L10:
        JSONObject r3 = mergeGlobalTaskSetting(r1, r2.getMonitorScene());     // Catch: Throwable -> L14
        if (r3 == null) goto L17;
        return new DownloadSetting(r3);
    L17:
        return sGlobal;
    L9:
        r1 = null;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L5:
        return sGlobal;
    }

    public static boolean isTaskKeyDisabled(String r2) {
        JSONObject r0 = sDisabledTaskKeys;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.optInt(r2, 0) != 1) goto L7;
        return true;
    }

    private static boolean matchSceneTaskSetting(String r1) {
        if (sGlobalTaskSetting != null) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (sGlobalTaskSetting.has(r1) == false) goto L9;
        return true;
    }

    public static DownloadSetting obtain(JSONObject r4) {
        if (r4 == null) goto L30;
        if (r4 == getGlobalSettings()) goto L30;
        if (sTaskSettingDisabled == true) goto L30;
        DownloadSetting r0 = sLastSetting;
        if (r0 != null) goto L11;
    L13:
        LruCache<Integer, DownloadSetting> r1 = sCache;
        monitor-enter(r1);
        Iterator<DownloadSetting> r2 = r1.values().iterator();     // Catch: Throwable -> L26
    L17:
        if (r2.hasNext() == false) goto L23;
        DownloadSetting r3 = r2.next();     // Catch: Throwable -> L26
        if (r3.mTaskSetting != r4) goto L17;
        sLastSetting = r3;     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        return r3;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L26
        DownloadSetting r5 = new DownloadSetting(r4);
        sLastSetting = r5;
        return r5;
    L26:
        th = move-exception;
        throw th;
    L11:
        if (r0.mTaskSetting != r4) goto L13;
        return r0;
    L30:
        return sGlobal;
    }

    public static void removeTaskDownloadSetting(int r1) {
        DownloadSetting r0 = sLastSetting;
        if (r0 != null) goto L5;
    L7:
        LruCache<Integer, DownloadSetting> r2 = sCache;
        monitor-enter(r2);
        r2.remove(Integer.valueOf(r1));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r0.mDownloadId != r1) goto L7;
        sLastSetting = null;
        goto L7
    }

    public boolean has(String r2) {
        if (this.mTaskSetting == null) goto L9;
        if (isTaskKeyDisabled(r2) == true) goto L9;
        return this.mTaskSetting.has(r2);
    L9:
        return getGlobalSettings().has(r2);
    }

    public Object opt(String r2) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.opt(r2);
    L11:
        return getGlobalSettings().opt(r2);
    }

    public boolean optBoolean(String r2) {
        return optBoolean(r2, false);
    }

    public boolean optBugFix(String r2) {
        return optBugFix(r2, false);
    }

    public double optDouble(String r3) {
        return optDouble(r3, Double.NaN);
    }

    public int optInt(String r2) {
        return optInt(r2, 0);
    }

    public JSONArray optJSONArray(String r2) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optJSONArray(r2);
    L11:
        return getGlobalSettings().optJSONArray(r2);
    }

    public JSONObject optJSONObject(String r2) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optJSONObject(r2);
    L11:
        return getGlobalSettings().optJSONObject(r2);
    }

    public long optLong(String r3) {
        return optLong(r3, 0);
    }

    public String optString(String r2) {
        return optString(r2, "");
    }

    private static DownloadSetting create(int r1) {
        if (sTaskSettingDisabled == false) goto L7;
        return sGlobal;
    L7:
        if (((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext() == null) goto L13;
        DownloadInfo r2 = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getDownloadInfo(r1);
        if (r2 == null) goto L13;
        return create(r2);
    L13:
        return sGlobal;
    }

    public static DownloadSetting obtain(DownloadInfo r1) {
        if (r1 != null) goto L6;
        return sGlobal;
    L6:
        return obtain(r1.getId(), r1);
    }

    public static DownloadSetting obtain(int r1) {
        return obtain(r1, null);
    }

    public static void addTaskDownloadSetting(int r1, JSONObject r2) {
        addTaskDownloadSetting(r1, null, r2);
    }

    private static JSONObject mergeGlobalTaskSetting(JSONObject r5, String r6) {
    L18:
        th = move-exception;
        Logger.globalError(TAG, "mergeGlobalTaskSetting", "Error:" + th + " " + r6);
    L20:
        return null;
    L4:
        if (matchSceneTaskSetting(r6) == false) goto L6;
        JSONObject r1 = sGlobalTaskSetting.optJSONObject(r6);     // Catch: Throwable -> L18
    L7:
        if (r5 == null) goto L14;
        if (r1 == null) goto L14;
        Iterator<String> r2 = r1.keys();     // Catch: Throwable -> L18
    L10:
        if (r2.hasNext() == false) goto L14;
        String r3 = r2.next();     // Catch: Throwable -> L18
        r5.put(r3, r1.get(r3));     // Catch: Throwable -> L18
    L14:
        if (r5 == null) goto L16;
        return r5;
    L16:
        if (r1 == null) goto L20;
        return r1;
    L6:
        r1 = null;
        goto L7
    }

    private static DownloadSetting obtain(int r2, DownloadInfo r3) {
        DownloadSetting r0 = sLastSetting;
        if (r0 != null) goto L5;
    L7:
        LruCache<Integer, DownloadSetting> r1 = sCache;
        monitor-enter(r1);
        DownloadSetting r4 = r1.get(Integer.valueOf(r2));     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        if (r4 != null) goto L23;
        if (r3 != null) goto L14;
        DownloadSetting r5 = create(r2);
    L15:
        r4 = r5;
        monitor-enter(r1);
        r1.put(Integer.valueOf(r2), r4);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L14:
        r5 = create(r3);
    L23:
        r4.mDownloadId = r2;
        sLastSetting = r4;
        return r4;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r0.mDownloadId != r2) goto L7;
        return r0;
    }

    public static void setGlobalBugFix(String r1, boolean r2) {
        if (sGlobalBugFixSetting != null) goto L5;
        sGlobalBugFixSetting = new JSONObject();     // Catch: JSONException -> L11
    L5:
        JSONObject r0 = sGlobalBugFixSetting;     // Catch: JSONException -> L11
        if (r2 == false) goto L8;
        int r3 = 1;
    L9:
        r0.put(r1, r3);     // Catch: JSONException -> L11
        return;
    L8:
        r3 = 0;
    }

    public boolean optBoolean(String r2, boolean r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optBoolean(r2, r3);
    L11:
        return getGlobalSettings().optBoolean(r2, r3);
    }

    public boolean optBugFix(String r4, boolean r5) {
        if (this.mBugFixSetting != null) goto L5;
    L16:
        JSONObject r0 = sGlobalBugFixSetting;
        if (r0 != null) goto L19;
    L28:
        return r5;
    L19:
        if (r0.has(r4) == true) goto L21;
        Boolean r6 = sGlobalBugFixDefault;
        if (r6 == null) goto L28;
        return r6.booleanValue();
    L21:
        if (sGlobalBugFixSetting.optInt(r4, r5 ? 1 : 0) != 1) goto L30;
        return true;
    L30:
        return false;
    L5:
        if (isTaskKeyDisabled(r4) == true) goto L16;
        if (this.mBugFixSetting.has(r4) == true) goto L9;
        Boolean r1 = this.mBugFixDefault;
        if (r1 == null) goto L16;
        return r1.booleanValue();
    L9:
        if (this.mBugFixSetting.optInt(r4, r5 ? 1 : 0) != 1) goto L29;
        return true;
    L29:
        return false;
    }

    public double optDouble(String r2, double r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optDouble(r2, r3);
    L11:
        return getGlobalSettings().optDouble(r2, r3);
    }

    public int optInt(String r2, int r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optInt(r2, r3);
    L11:
        return getGlobalSettings().optInt(r2, r3);
    }

    public long optLong(String r2, long r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optLong(r2, r3);
    L11:
        return getGlobalSettings().optLong(r2, r3);
    }

    public String optString(String r2, String r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optString(r2, r3);
    L11:
        return getGlobalSettings().optString(r2, r3);
    }

    public static void addTaskDownloadSetting(int r3, String r4, JSONObject r5) {
        JSONObject r6 = mergeGlobalTaskSetting(r5, r4);
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6 != getGlobalSettings()) goto L7;
        return;
    L7:
        if (sTaskSettingDisabled == true) goto L40;
        LruCache<Integer, DownloadSetting> r7 = sCache;
        monitor-enter(r7);
        DownloadSetting r0 = sLastSetting;     // Catch: Throwable -> L30
        if (r0 != null) goto L14;
    L16:
        Iterator<DownloadSetting> r1 = r7.values().iterator();     // Catch: Throwable -> L30
    L18:
        if (r1.hasNext() == false) goto L22;
        DownloadSetting r2 = r1.next();     // Catch: Throwable -> L30
        if (r2.mTaskSetting != r6) goto L18;
        r2.mDownloadId = r3;     // Catch: Throwable -> L30
    L23:
        if (r2 != null) goto L25;
        r0 = new DownloadSetting(r6);     // Catch: Throwable -> L30
        r0.mDownloadId = r3;     // Catch: Throwable -> L30
    L26:
        sLastSetting = r0;     // Catch: Throwable -> L30
    L27:
        sCache.put(Integer.valueOf(r3), r0);     // Catch: Throwable -> L30
        monitor-exit(r7);     // Catch: Throwable -> L30
        return;
    L25:
        r0 = r2;
        goto L26
    L22:
        r2 = null;
        goto L23
    L14:
        if (r0.mTaskSetting != r6) goto L16;
        r0.mDownloadId = r3;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }
}
