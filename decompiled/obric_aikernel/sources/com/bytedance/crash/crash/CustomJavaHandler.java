package com.bytedance.crash.crash;

import android.os.Process;
import com.bytedance.apm6.util.constant.NetConst;
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
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomJavaHandler {
    private static final int MAX_COUNT = 3;
    private static final String TAG = "CustomJavaHandler";
    private static boolean sIsDropData;
    private volatile int mCount;
    private File mRootDir;

    CustomJavaHandler(File r10) {
        this.mCount = 0;
        this.mRootDir = r10;
    }

    static /* synthetic */ File access$000(CustomJavaHandler r10) {
        return r10.mRootDir;
    }

    static /* synthetic */ boolean access$100(File r10, JSONObject r11) {
        return dumpLogcat(r10, r11);
    }

    private static void appendCustomData(JSONObject r10) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L5;
        return;
    L5:
        AppMonitor r11 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L17
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L17
        if (r11 == null) goto L14;
        Map<String, String> r13 = r11.getUserDataCenter().getAttachUserDataToMap(CrashType.JAVA);     // Catch: Throwable -> L17
        if (r13 == null) goto L14;
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();     // Catch: Throwable -> L17
    L11:
        if (r14.hasNext() == false) goto L14;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Throwable -> L17
        r12.put(r15.getKey(), r15.getValue());     // Catch: Throwable -> L17
    L14:
        if (JSONUtils.isEmpty(r12) == true) goto L21;
        r10.put("custom", r12);     // Catch: Throwable -> L17
        return;
    L21:
        return;
    }

    private static void appendFilters(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("filters");     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
        r11 = new JSONObject();     // Catch: Throwable -> L8
        r10.put("filters", r11);     // Catch: Throwable -> L8
    L6:
        r11.put(Constants.FROM_CUSTOM, NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L8
        r11.put("storage_free_range", Storage.getInnerFreeSizeRange());     // Catch: Throwable -> L8
        r11.put("alog_inited", AlogManager.isInit());     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        NpthLog.e("EnsureReportData", th);
    }

    private static boolean dumpLogcat(File r10, JSONObject r11) {
        Logcat.npthDump(r10, true);     // Catch: Throwable -> L16
        if (Logcat.isLogcatExists(r10) == false) goto L14;
        String r12 = FileUtils.readFile(new File(r10, "logcat.txt"));     // Catch: Throwable -> L16
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L16
        r13.put(r12);     // Catch: Throwable -> L16
        r11.put(Constants.LOGCAT, r13);     // Catch: Throwable -> L16
        if (r12.isEmpty() == false) goto L8;
        return false;
    L8:
        if (r12.length() <= 10) goto L20;
        JSONObject r14 = r11.optJSONObject("filters");     // Catch: Throwable -> L16
        if (r14 != null) goto L12;
        r14 = new JSONObject();     // Catch: Throwable -> L16
        r11.put("filters", r14);     // Catch: Throwable -> L16
    L12:
        JSONUtils.put(r14, "has_logcat", "true");     // Catch: Throwable -> L16
        return true;
    L20:
        return false;
    L14:
        return false;
    L21:
        return false;
    }

    public static void setDropData(boolean r10) {
        sIsDropData = r10;
    }

    public static JSONObject toJsonObject(Throwable r10, Thread r11) {
        JSONObject r12 = new JSONObject();
        StackTraceElement[] r13 = r10.getStackTrace();     // Catch: Exception -> L15
        if (r13.length != 0) goto L6;
        return r12;
    L6:
        long r14 = System.currentTimeMillis();     // Catch: Exception -> L15
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L15
        int r16 = 0;
    L8:
        if (r16 >= r13.length) goto L10;
        Stack.getStackTraceElementInfo(r13[r16], r15);     // Catch: Exception -> L15
        r16 = r16 + 1;     // Catch: Exception -> L15
        goto L8
    L10:
        String r17 = r15.toString();     // Catch: Exception -> L15
        JSONUtils.put(r12, "data", r17);     // Catch: Exception -> L15
        r12.put("crash_time", r14);     // Catch: Exception -> L15
        r12.put(CrashBody.CRASH_THREAD_NAME, r11.getName());     // Catch: Exception -> L15
        r12.put("crash_md5", Digest.getMD5(r17));     // Catch: Exception -> L15
        r12.put("process_name", App.getProcessName());     // Catch: Exception -> L15
        r12.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L15
        r12.put("pid", Process.myPid());     // Catch: Exception -> L15
        r12.put("isJava", 1);     // Catch: Exception -> L15
        r12.put("isOOM", false);     // Catch: Exception -> L15
        String r18 = Global.getBusiness();     // Catch: Exception -> L15
        if (r18 == null) goto L13;
        r12.put("business", r18);     // Catch: Exception -> L15
    L13:
        appendCustomData(r12);     // Catch: Exception -> L15
        appendFilters(r12);     // Catch: Exception -> L15
        Scraps.pushTo(r12);     // Catch: Exception -> L15
        SdkInfo.pushTo(r12);     // Catch: Exception -> L15
        r12.put(Constants.IS_BACKGROUND, ActivityLifecycle.isBackground());     // Catch: Exception -> L15
        ActivityLifecycle.loadActivityTrace(r12);     // Catch: Exception -> L15
        ActivityLifecycle.loadActivityTrack(r12);     // Catch: Exception -> L15
    L17:
        return r12;
    L15:
        e = move-exception;
        NpthLog.e("EnsureReportData", e);
        goto L17
    }

    public void handleCustomException(Thread r10, Throwable r11) {
        handleCustomException(r10, r11, false);
    }

    public void handleCustomException(final Thread r10, final Throwable r11, final boolean r12) {
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
        DefaultWorkThread.post(new AnonymousClass1(this, r11, r10, r12));
    }
}
