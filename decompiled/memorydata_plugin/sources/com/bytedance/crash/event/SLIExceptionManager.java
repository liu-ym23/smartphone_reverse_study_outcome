package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SLIExceptionManager {
    private static String TAG = "SLIExceptionManager";
    private static SLIExceptionManager sInstance;
    private String mSceneInfo;

    static {
        sInstance = new SLIExceptionManager();
    }

    public SLIExceptionManager() {
    }

    private String getCurrentJavaStack(StackTraceElement[] r2, int r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length <= 0) goto L15;
        StringBuilder r1 = new StringBuilder();
    L8:
        if (r3 >= r2.length) goto L11;
        Stack.getStackTraceElementInfo(r2[r3], r1);
        r3 = r3 + 1;
        goto L8
    L11:
        return r1.toString();
    L15:
        return null;
    }

    public static SLIExceptionManager getInstance() {
        return sInstance;
    }

    private boolean upload(EnsureReportData r7, File r8) {
        long r0 = System.currentTimeMillis();
        int r3 = Process.myPid();     // Catch: Exception -> L12
        AppMonitor r4 = MonitorManager.getAppMonitor();     // Catch: Exception -> L12
        JSONObject r1 = Header.createEventHeader(r4, r0, CrashType.NATIVE_CUSTOMIZE, r3).getJson();     // Catch: Exception -> L12
        JSONArray r2 = new JSONArray();     // Catch: Exception -> L12
        r2.put(r7.toJsonObject(r4));     // Catch: Exception -> L12
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L12
        r9.put("data", r2);     // Catch: Exception -> L12
        r9.put("header", r1);     // Catch: Exception -> L12
        if (this.mSceneInfo != null) goto L6;
    L8:
        boolean r6 = CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r1), r9.toString(), new File[]{r8});     // Catch: Exception -> L12
        if (r6 == false) goto L11;
        NpthLog.d(TAG + "upload success");     // Catch: Exception -> L12
        FileUtils.deleteFile(r8);     // Catch: Exception -> L12
    L11:
        return r6;
    L6:
        if (AppMonitorConfigService.enable_scene_exception() == false) goto L8;
        r9.put("app_scene_info", this.mSceneInfo);     // Catch: Exception -> L12
    L12:
        return false;
    }

    public void reportException(Throwable r12, String r13, String r14, boolean r15, Map<String, String> r16, String r17, String r18, File r19) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin");
    L22:
        th = move-exception;
        NpthLog.w(th);
        return;
    L4:
        if (TextUtils.isEmpty(r18) == false) goto L6;
        String r1 = "core_exception_monitor";
    L8:
        if (AppMonitorConfigService.enable_SLI_exception() == true) goto L11;
        NpthLog.i("exception has been discard due to not sampled: " + r1);     // Catch: Throwable -> L22
        return;
    L11:
        this.mSceneInfo = r14;     // Catch: Throwable -> L22
        StackTraceElement[] r2 = r12.getStackTrace();     // Catch: Throwable -> L22
        if (r2[0] != null) goto L14;
        return;
    L14:
        if (r12 == null) goto L16;
        String r3 = Stack.getExceptionStack(r12);     // Catch: Throwable -> L22
    L17:
        String r4 = r3;
        if (TextUtils.isEmpty(r4) == false) goto L20;
        return;
    L20:
        upload(new EnsureReportData(r4, r17, r13, r6, Thread.currentThread().getName(), "1", "native_exception", Process.myPid()), r19);     // Catch: Throwable -> L22
        return;
    L16:
        r3 = getCurrentJavaStack(r2, 0);     // Catch: Throwable -> L22
        goto L17
    L6:
        r1 = r18;
        goto L8
    }
}
