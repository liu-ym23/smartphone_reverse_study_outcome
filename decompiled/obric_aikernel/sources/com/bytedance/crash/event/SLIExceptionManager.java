package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
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
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SLIExceptionManager {
    private static String TAG = "SLIExceptionManager";
    private static SLIExceptionManager sInstance;
    private String mSceneInfo;

    static {
        sInstance = new SLIExceptionManager();
    }

    public SLIExceptionManager() {
    }

    private String getCurrentJavaStack(StackTraceElement[] r10, int r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length <= 0) goto L15;
        StringBuilder r12 = new StringBuilder();
    L8:
        if (r11 >= r10.length) goto L11;
        Stack.getStackTraceElementInfo(r10[r11], r12);
        r11 = r11 + 1;
        goto L8
    L11:
        return r12.toString();
    L15:
        return null;
    }

    public static SLIExceptionManager getInstance() {
        return sInstance;
    }

    private boolean upload(EnsureReportData r10, File r11) {
        long r12 = System.currentTimeMillis();
        int r13 = Process.myPid();     // Catch: Exception -> L12
        AppMonitor r14 = MonitorManager.getAppMonitor();     // Catch: Exception -> L12
        JSONObject r15 = Header.createEventHeader(r14, r12, CrashType.NATIVE_CUSTOMIZE, r13).getJson();     // Catch: Exception -> L12
        JSONArray r16 = new JSONArray();     // Catch: Exception -> L12
        r16.put(r10.toJsonObject(r14));     // Catch: Exception -> L12
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L12
        r17.put("data", r16);     // Catch: Exception -> L12
        r17.put("header", r15);     // Catch: Exception -> L12
        if (this.mSceneInfo != null) goto L6;
    L8:
        boolean r18 = CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r15), r17.toString(), new File[]{r11});     // Catch: Exception -> L12
        if (r18 == false) goto L11;
        NpthLog.d(TAG + "upload success");     // Catch: Exception -> L12
        FileUtils.deleteFile(r11);     // Catch: Exception -> L12
    L11:
        return r18;
    L6:
        if (AppMonitorConfigService.enable_scene_exception() == false) goto L8;
        r17.put("app_scene_info", this.mSceneInfo);     // Catch: Exception -> L12
    L12:
        return false;
    }

    public void reportException(Throwable r12, String r13, String r14, boolean r15, Map<String, String> r16, String r17, @Nullable String r18, File r19) {
    L19:
        th = move-exception;
        NpthLog.w(th);
        return;
    L4:
        if (TextUtils.isEmpty(r18) == false) goto L6;
        String r10 = "core_exception_monitor";
    L8:
        if (AppMonitorConfigService.enable_SLI_exception() == true) goto L11;
        NpthLog.i("exception has been discard due to not sampled: " + r10);     // Catch: Throwable -> L19
        return;
    L11:
        this.mSceneInfo = r14;     // Catch: Throwable -> L19
        if (r12.getStackTrace()[0] != null) goto L14;
        return;
    L14:
        String r11 = Stack.getExceptionStack(r12);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r11) == false) goto L17;
        return;
    L17:
        upload(new EnsureReportData(r11, r17, r13, r16, Thread.currentThread().getName(), NetConst.ENCRYPT_VERISON_CODE, "native_exception", Process.myPid()), r19);     // Catch: Throwable -> L19
        return;
    L6:
        r10 = r18;
        goto L8
    }
}
