package com.bytedance.crash.crash;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.Storage;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CustomJavaHandler {
    private static final int MAX_COUNT = 3;
    private static final String TAG = "CustomJavaHandler";
    private static boolean sIsDropData;
    private volatile int mCount;
    private File mRootDir;

    CustomJavaHandler(File r2) {
        this.mCount = 0;
        this.mRootDir = r2;
    }

    static /* synthetic */ File access$000(CustomJavaHandler r0) {
        return r0.mRootDir;
    }

    static /* synthetic */ boolean access$100(File r0, JSONObject r1) {
        return dumpLogcat(r0, r1);
    }

    private static void appendCustomData(JSONObject r6) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L6;
        return;
    L6:
        AppMonitor r1 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L18
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L18
        if (r1 == null) goto L15;
        Map<String, String> r3 = r1.getUserDataCenter().getAttachUserDataToMap(CrashType.JAVA);     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L18
    L12:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        r2.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), r5.getValue());     // Catch: Throwable -> L18
    L15:
        if (JSONUtils.isEmpty(r2) == true) goto L22;
        r6.put("custom", r2);     // Catch: Throwable -> L18
        return;
    L22:
        return;
    }

    private static void appendFilters(JSONObject r2) {
        JSONObject r1 = r2.optJSONObject("filters");     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        r1 = new JSONObject();     // Catch: Throwable -> L8
        r2.put("filters", r1);     // Catch: Throwable -> L8
    L6:
        r1.put(Constants.FROM_CUSTOM, "1");     // Catch: Throwable -> L8
        r1.put("storage_free_range", Storage.getInnerFreeSizeRange());     // Catch: Throwable -> L8
        r1.put("alog_inited", AlogManager.isInit());     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        NpthLog.e("EnsureReportData", th);
    }

    private static boolean dumpLogcat(File r4, JSONObject r5) {
        Logcat.npthDump(r4, true);     // Catch: Throwable -> L16
        if (Logcat.isLogcatExists(r4) == false) goto L14;
        String r6 = FileUtils.readFile(new File(r4, "logcat.txt"));     // Catch: Throwable -> L16
        JSONArray r2 = new JSONArray();     // Catch: Throwable -> L16
        r2.put(r6);     // Catch: Throwable -> L16
        r5.put(Constants.LOGCAT, r2);     // Catch: Throwable -> L16
        if (r6.isEmpty() == false) goto L8;
        return false;
    L8:
        if (r6.length() <= 10) goto L20;
        JSONObject r7 = r5.optJSONObject("filters");     // Catch: Throwable -> L16
        if (r7 != null) goto L12;
        r7 = new JSONObject();     // Catch: Throwable -> L16
        r5.put("filters", r7);     // Catch: Throwable -> L16
    L12:
        JSONUtils.put(r7, "has_logcat", "true");     // Catch: Throwable -> L16
        return true;
    L20:
        return false;
    L14:
        return false;
    L21:
        return false;
    }

    public static void setDropData(boolean r0) {
        sIsDropData = r0;
    }

    public static JSONObject toJsonObject(Throwable r7, Thread r8) {
        JSONObject r0 = new JSONObject();
        StackTraceElement[] r9 = r7.getStackTrace();     // Catch: Exception -> L15
        if (r9.length != 0) goto L6;
        return r0;
    L6:
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L15
        StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L15
        int r5 = 0;
    L8:
        if (r5 >= r9.length) goto L10;
        Stack.getStackTraceElementInfo(r9[r5], r3);     // Catch: Exception -> L15
        r5 = r5 + 1;     // Catch: Exception -> L15
        goto L8
    L10:
        String r10 = r3.toString();     // Catch: Exception -> L15
        JSONUtils.put(r0, "data", r10);     // Catch: Exception -> L15
        r0.put("crash_time", r1);     // Catch: Exception -> L15
        r0.put(CrashBody.CRASH_THREAD_NAME, r8.getName());     // Catch: Exception -> L15
        r0.put("crash_md5", Digest.getMD5(r10));     // Catch: Exception -> L15
        r0.put("process_name", App.getProcessName());     // Catch: Exception -> L15
        r0.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L15
        r0.put(CrashBody.PID, Process.myPid());     // Catch: Exception -> L15
        r0.put("isJava", 1);     // Catch: Exception -> L15
        r0.put("isOOM", false);     // Catch: Exception -> L15
        String r11 = Global.getBusiness();     // Catch: Exception -> L15
        if (r11 == null) goto L13;
        r0.put("business", r11);     // Catch: Exception -> L15
    L13:
        appendCustomData(r0);     // Catch: Exception -> L15
        appendFilters(r0);     // Catch: Exception -> L15
        Scraps.pushTo(r0);     // Catch: Exception -> L15
        SdkInfo.pushTo(r0);     // Catch: Exception -> L15
        r0.put("is_background", ActivityLifecycle.isBackground());     // Catch: Exception -> L15
        ActivityLifecycle.loadActivityTrace(r0);     // Catch: Exception -> L15
        ActivityLifecycle.loadActivityTrack(r0);     // Catch: Exception -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        NpthLog.e("EnsureReportData", e);
        goto L17
    }

    public void handleCustomException(Thread r2, Throwable r3) {
        handleCustomException(r2, r3, false);
    }

    public void handleCustomException(final Thread r3, final Throwable r4, final boolean r5) {
        if (sIsDropData == false) goto L5;
        return;
    L5:
        if (MonitorManager.getAppMonitor() != null) goto L8;
        return;
    L8:
        if (this.mCount <= 3) goto L10;
        return;
    L10:
        this.mCount++;
        DefaultWorkThread.post(new AnonymousClass1(this, r4, r3, r5));
    }
}
