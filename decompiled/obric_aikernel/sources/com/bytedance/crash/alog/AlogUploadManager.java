package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.UploadRequest;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploadManager;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

    public static UploadRequest buildUploadRequest(List<String> r10, String r11) {
        UploadRequest r12 = new UploadRequest();
        AppMonitor r13 = MonitorManager.getAppMonitor();
        String r14 = "4444";
        String r15 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        if (r13 == null) goto L5;
        String r16 = r13.getAppId();
        String r17 = r13.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE);
    L6:
        if (r16 == null) goto L9;
        r14 = r16;
    L9:
        if (r17 == null) goto L12;
        r15 = r17;
    L12:
        r12.setAid(r14);
        r12.setDid(r15);
        r12.setProcessName(r11);
        r12.setAlogFiles(r10);
        return r12;
    L5:
        r16 = "4444";
        r17 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        goto L6
    }

    private static String checkParamsForUploadRequest(UploadRequest r10) {
        if (TextUtils.isEmpty(r10.getAid()) == false) goto L7;
        return "no_aid";
    L7:
        if (TextUtils.isEmpty(r10.getDid()) == false) goto L11;
        return "no_did";
    L11:
        if (TextUtils.isEmpty(r10.getProcessName()) == false) goto L15;
        return ERR_NO_PROCESS;
    L15:
        if (r10.getAlogFiles() != null) goto L17;
        return ERR_NO_ALOG_FILES;
    L17:
        if (r10.getAlogFiles().size() == 0) goto L23;
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

    public static String uploadAlog(List<String> r10, String r11) {
        NpthLog.i("npth", "upload alog " + r11 + ": " + r10);
        UploadRequest r12 = buildUploadRequest(r10, r11);     // Catch: Throwable -> L9
        String r13 = checkParamsForUploadRequest(r12);     // Catch: Throwable -> L9
        if (r13.equals("normal") == true) goto L6;
        return r13;
    L6:
        if (CrashUploadManager.getInstance().uploadAlogFile(r12.getAid(), r12.getDid(), r12.getProcessName(), r12.getAlogFiles()) == false) goto L15;
        return "normal";
    L15:
        return "unknown";
    L9:
        th = move-exception;
        Ensure.getInstance().ensureNotReachHereForce(Constants.NPTH_CATCH, th);
        return "unknown";
    }

    public List<String> collectAlog(long r10, String r11) {
        return AlogManager.collectAlog(r10, r11);
    }

    public List<String> collectAlog(long r10, String r11, String r12) {
        return AlogManager.collectAlog(r10, r11);
    }

    public List<String> collectAlog(String r10, long r11, String r12, IAlogUploadStrategy r13) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        if (new File(r10).exists() == true) goto L8;
        return null;
    L8:
        if (r13 != null) goto L10;
        return null;
    L10:
        return r13.getUploadAlogFiles(r10, r11);
    }

    public void flushData() {
        AlogManager.flushData();
    }

    public boolean isInit() {
        return AlogManager.isInit();
    }
}
