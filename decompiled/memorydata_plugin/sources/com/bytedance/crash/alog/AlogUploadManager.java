package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.UploadRequest;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploadManager;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class AlogUploadManager {
    public static final String ERR_NORMAL = "normal";
    public static final String ERR_NO_AID = "no_aid";
    public static final String ERR_NO_ALOG_FILES = "no_files";
    public static final String ERR_NO_DID = "no_did";
    public static final String ERR_NO_PROCESS = "no_process";
    public static final String ERR_UNKNOWN = "unknown";
    private static volatile AlogUploadManager sInstance;

    public AlogUploadManager() {
    }

    public static UploadRequest buildUploadRequest(List<String> r5, String r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        UploadRequest r0 = new UploadRequest();
        AppMonitor r1 = MonitorManager.getAppMonitor();
        String r2 = "4444";
        String r3 = "0";
        if (r1 == null) goto L5;
        String r4 = r1.getAppId();
        String r8 = r1.getDeviceId("0");
    L6:
        if (r4 == null) goto L9;
        r2 = r4;
    L9:
        if (r8 == null) goto L12;
        r3 = r8;
    L12:
        r0.setAid(r2);
        r0.setDid(r3);
        r0.setProcessName(r6);
        r0.setAlogFiles(r7);
        return r0;
    L5:
        r4 = "4444";
        r8 = "0";
        goto L6
    }

    private static String checkParamsForUploadRequest(UploadRequest r1) {
        if (TextUtils.isEmpty(r1.getAid()) == false) goto L7;
        return "no_aid";
    L7:
        if (TextUtils.isEmpty(r1.getDid()) == false) goto L11;
        return "no_did";
    L11:
        if (TextUtils.isEmpty(r1.getProcessName()) == false) goto L15;
        return ERR_NO_PROCESS;
    L15:
        if (r1.getAlogFiles() != null) goto L17;
        return ERR_NO_ALOG_FILES;
    L17:
        if (r1.getAlogFiles().size() == 0) goto L23;
        return "normal";
    L23:
        return ERR_NO_ALOG_FILES;
    }

    public static AlogUploadManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(AlogUploadManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AlogUploadManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AlogUploadManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static String uploadAlog(List<String> r4, String r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        NpthLog.i("npth", "upload alog " + r5 + ": " + r6);
        UploadRequest r7 = buildUploadRequest(r6, r5);     // Catch: Throwable -> L9
        String r8 = checkParamsForUploadRequest(r7);     // Catch: Throwable -> L9
        if (r8.equals("normal") == true) goto L6;
        return r8;
    L6:
        if (CrashUploadManager.getInstance().uploadAlogFile(r7.getAid(), r7.getDid(), r7.getProcessName(), r7.getAlogFiles()) == false) goto L15;
        return "normal";
    L15:
        return "unknown";
    L9:
        th = move-exception;
        Ensure.getInstance().ensureNotReachHereForce(Constants.NPTH_CATCH, th);
        return "unknown";
    }

    public List<String> collectAlog(long r1, String r3) {
        return AlogManager.collectAlog(r1, r3);
    }

    public List<String> collectAlog(long r1, String r3, String r4) {
        return AlogManager.collectAlog(r1, r3);
    }

    public List<String> collectAlog(String r1, long r2, String r4, IAlogUploadStrategy r5) {
        IAlogUploadStrategy r0 = (IAlogUploadStrategy) ZeusTransformUtils.wrapperContextForParams(r5, IAlogUploadStrategy.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        if (new File(r1).exists() == true) goto L8;
        return null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getUploadAlogFiles(r1, r2);
    }

    public void flushData() {
        AlogManager.flushData();
    }

    public boolean isInit() {
        return AlogManager.isInit();
    }
}
