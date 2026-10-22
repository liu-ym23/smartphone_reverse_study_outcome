package com.bytedance.crash.event;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.NpthLog;
import com.obric.aikernel.request.track.ApiPerfDetails;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ProtectorManager {
    private static final String TAG = "ProtectorManager";

    public ProtectorManager() {
    }

    private static List<File> getAttachmentFileList(File r6) {
        ArrayList r0 = new ArrayList();
        File[] r7 = r6.listFiles();
        if (r7 == null) goto L15;
        int r1 = r7.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        File r3 = r7[r2];
        String r4 = r3.getName();
        if (r4.endsWith(".summary") == true) goto L14;
        if (r4.endsWith(".json") == true) goto L14;
        if (r4.endsWith(".inf") == true) goto L14;
        r0.add(r3);
    L14:
        r2 = r2 + 1;
    L15:
        return r0;
    }

    public static void upload() {
        File r0 = new File(Global.getRootDirectory(), "protector");
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r1 = r0.listFiles();
        if (r1 == null) goto L10;
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L12;
        uploadOne(r1[r3]);
        r3 = r3 + 1;
        goto L8
    L12:
        return;
    }

    private static boolean uploadOne(File r11) {
        long r3 = System.currentTimeMillis();
        NpthLog.i(TAG, "upload " + r11.getAbsolutePath());     // Catch: Exception -> L20
        AppMonitor r6 = MonitorManager.getAppMonitor();     // Catch: Exception -> L20
        if (r6 != null) goto L6;
        return false;
    L6:
        JSONObject r4 = Header.createEventHeader(r6, r3, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).getJson();     // Catch: Exception -> L20
        CrashSummary r5 = CrashSummary.loadFromDirectory(r11);     // Catch: Exception -> L20
        if (r5 != null) goto L10;
        NpthLog.w(TAG, "upload delete dir" + r11.getAbsolutePath());     // Catch: Exception -> L20
        FileSystemUtils.deleteAll(r11);     // Catch: Exception -> L20
        return false;
    L10:
        JSONObject r7 = r5.assemblyCrashBody(r6).getJson();     // Catch: Exception -> L20
        r7.put(Constants.EVENT_TYPE, "native_exception");     // Catch: Exception -> L20
        r7.put("message", "protector");     // Catch: Exception -> L20
        r7.put("log_type", "1");     // Catch: Exception -> L20
        r7.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L20
        r7.put(ApiPerfDetails.exceptionType, 1);     // Catch: Exception -> L20
        String r8 = r5.getStackTrace();     // Catch: Exception -> L20
        if (r8 == null) goto L13;
        r7.put(EnsureReportData.CLASS_REF, "Native");     // Catch: Exception -> L20
        r7.put("method", "Native");     // Catch: Exception -> L20
        r7.put("is_core", 1);     // Catch: Exception -> L20
        r7.put(EnsureReportData.LINE_NUM, -1);     // Catch: Exception -> L20
        r7.put(EnsureReportData.ENSURE_TYPE, EnsureDeliverer.ENSURE_NOT_REACH_HERE);     // Catch: Exception -> L20
        r7.put(CrashBody.CRASH_LIB_UUID, NativeTools.get().getSoUUID(r8));     // Catch: Exception -> L20
        r7.put("stack", r8);     // Catch: Exception -> L20
        r7.put(Constants.HAS_DUMP, "true");     // Catch: Exception -> L20
    L13:
        JSONObject r0 = r7.optJSONObject("filters");     // Catch: Exception -> L20
        if (r0 != null) goto L16;
        r0 = new JSONObject();     // Catch: Exception -> L20
        r7.put("filters", r0);     // Catch: Exception -> L20
    L16:
        CoredumpAdapter.upload(r6, r5, r11, r0);     // Catch: Exception -> L20
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L20
        r1.put(r7);     // Catch: Exception -> L20
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L20
        r2.put("data", r1);     // Catch: Exception -> L20
        r2.put("header", r4);     // Catch: Exception -> L20
        boolean r9 = CrashUploader.uploadCrashLogWithAttachment("ensure_zip", UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r4), r2.toString(), getAttachmentFileList(r11)).isSuccess();     // Catch: Exception -> L20
        if (r9 == false) goto L19;
        NpthLog.d(TAG, "upload success");     // Catch: Exception -> L20
        FileUtils.deleteFile(r11);     // Catch: Exception -> L20
    L19:
        return r9;
    L20:
        return false;
    }
}
