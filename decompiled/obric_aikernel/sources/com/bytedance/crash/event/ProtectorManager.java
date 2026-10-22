package com.bytedance.crash.event;

import android.os.Process;
import com.bytedance.apm6.util.constant.NetConst;
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

/* JADX INFO: loaded from: classes.dex */
public class ProtectorManager {
    private static final String TAG = "ProtectorManager";

    public ProtectorManager() {
    }

    private static List<File> getAttachmentFileList(File r10) {
        ArrayList r11 = new ArrayList();
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L15;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L15;
        File r15 = r12[r14];
        String r16 = r15.getName();
        if (r16.endsWith(".summary") == true) goto L14;
        if (r16.endsWith(".json") == true) goto L14;
        if (r16.endsWith(".inf") == true) goto L14;
        r11.add(r15);
    L14:
        r14 = r14 + 1;
    L15:
        return r11;
    }

    public static void upload() {
        File r10 = new File(Global.getRootDirectory(), "protector");
        if (r10.exists() == true) goto L5;
        return;
    L5:
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L12;
        uploadOne(r11[r13]);
        r13 = r13 + 1;
        goto L8
    L12:
        return;
    }

    private static boolean uploadOne(File r11) {
        long r10 = System.currentTimeMillis();
        NpthLog.i(TAG, "upload " + r11.getAbsolutePath());     // Catch: Exception -> L20
        AppMonitor r12 = MonitorManager.getAppMonitor();     // Catch: Exception -> L20
        if (r12 != null) goto L6;
        return false;
    L6:
        JSONObject r13 = Header.createEventHeader(r12, r10, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).getJson();     // Catch: Exception -> L20
        CrashSummary r14 = CrashSummary.loadFromDirectory(r11);     // Catch: Exception -> L20
        if (r14 != null) goto L10;
        NpthLog.w(TAG, "upload delete dir" + r11.getAbsolutePath());     // Catch: Exception -> L20
        FileSystemUtils.deleteAll(r11);     // Catch: Exception -> L20
        return false;
    L10:
        JSONObject r15 = r14.assemblyCrashBody(r12).getJson();     // Catch: Exception -> L20
        r15.put(Constants.EVENT_TYPE, "native_exception");     // Catch: Exception -> L20
        r15.put("message", "protector");     // Catch: Exception -> L20
        r15.put("log_type", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Exception -> L20
        r15.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L20
        r15.put(ApiPerfDetails.exceptionType, 1);     // Catch: Exception -> L20
        String r16 = r14.getStackTrace();     // Catch: Exception -> L20
        if (r16 == null) goto L13;
        r15.put(EnsureReportData.CLASS_REF, "Native");     // Catch: Exception -> L20
        r15.put(EnsureReportData.METHOD, "Native");     // Catch: Exception -> L20
        r15.put("is_core", 1);     // Catch: Exception -> L20
        r15.put(EnsureReportData.LINE_NUM, -1);     // Catch: Exception -> L20
        r15.put(EnsureReportData.ENSURE_TYPE, EnsureDeliverer.ENSURE_NOT_REACH_HERE);     // Catch: Exception -> L20
        r15.put(CrashBody.CRASH_LIB_UUID, NativeTools.get().getSoUUID(r16));     // Catch: Exception -> L20
        r15.put("stack", r16);     // Catch: Exception -> L20
        r15.put(Constants.HAS_DUMP, "true");     // Catch: Exception -> L20
    L13:
        JSONObject r17 = r15.optJSONObject("filters");     // Catch: Exception -> L20
        if (r17 != null) goto L16;
        r17 = new JSONObject();     // Catch: Exception -> L20
        r15.put("filters", r17);     // Catch: Exception -> L20
    L16:
        CoredumpAdapter.upload(r12, r14, r11, r17);     // Catch: Exception -> L20
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L20
        r18.put(r15);     // Catch: Exception -> L20
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L20
        r19.put("data", r18);     // Catch: Exception -> L20
        r19.put("header", r13);     // Catch: Exception -> L20
        boolean r20 = CrashUploader.uploadCrashLogWithAttachment("ensure_zip", UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r13), r19.toString(), getAttachmentFileList(r11)).isSuccess();     // Catch: Exception -> L20
        if (r20 == false) goto L19;
        NpthLog.d(TAG, "upload success");     // Catch: Exception -> L20
        FileUtils.deleteFile(r11);     // Catch: Exception -> L20
    L19:
        return r20;
    L20:
        return false;
    }
}
