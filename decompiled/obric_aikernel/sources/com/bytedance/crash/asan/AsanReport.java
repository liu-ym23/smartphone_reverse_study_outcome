package com.bytedance.crash.asan;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.Response;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class AsanReport {
    private static final String DIR_NAME = "asan";

    public AsanReport() {
    }

    public static void upload() {
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L5;
        return;
    L5:
        File r11 = new File(LogPathConfig.getNpthRootPath(), DIR_NAME);
        if (r11.exists() == true) goto L8;
        return;
    L8:
        File[] r12 = r11.listFiles();
        if (r12 != null) goto L11;
        return;
    L11:
        if (r12.length == 0) goto L47;
        Pattern r13 = Pattern.compile("^asan_report\\.(\\d{1,5})$");
        int r14 = r12.length;
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L48;
        File r16 = r12[r15];
        Matcher r17 = r13.matcher(r16.getName());     // Catch: Throwable -> L31
        if (r17.find() == false) goto L33;
        if (r17.groupCount() != 1) goto L33;
        int r18 = Integer.parseInt(r17.group(1));     // Catch: Throwable -> L31
        long r19 = new Date(r16.lastModified()).getTime();     // Catch: Throwable -> L31
        CrashBody r20 = new CrashBody();     // Catch: Throwable -> L31
        String r110 = FileSystemUtils.readUtf8File(r16);     // Catch: Throwable -> L31
        if (r110 != null) goto L23;
    L24:
        r110 = "AsanReport is Null";
    L25:
        r20.put("data", r110);     // Catch: Throwable -> L31
        r20.put("crash_time", Long.valueOf(r19));     // Catch: Throwable -> L31
        r20.put(Header.KEY_CRASH_TYPE, DIR_NAME);     // Catch: Throwable -> L31
        r20.put(CrashBody.IS_NATIVE_CRASH, 1);     // Catch: Throwable -> L31
        r20.put("commit_id", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L31
        r20.put("jenkins_job_id", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L31
        BuildId.putAsanBuildIdToJson(r20.getJson(), r16);     // Catch: Throwable -> L31
        CrashType r111 = CrashType.ASAN;     // Catch: Throwable -> L31
        r20.setHeader(Header.createEventHeader(r10, r19, r111, r18));     // Catch: Throwable -> L31
        Response r21 = CrashUploader.uploadCrashLogWithAttachment(DIR_NAME, UploaderUrl.getUrlByCrashTypeAndHeader(r111, r20.getHeader().getJson()), r20.getJson().toString(), new ArrayList());     // Catch: Throwable -> L31
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L31
        r22.append(r16.getName());     // Catch: Throwable -> L31
        r22.append("upload ");     // Catch: Throwable -> L31
        if (r21.isSuccess() == false) goto L28;
        String r23 = "success";
    L29:
        r22.append(r23);     // Catch: Throwable -> L31
        NpthLog.i(r22.toString());     // Catch: Throwable -> L31
        goto L33
    L28:
        r23 = "fail";
        goto L29
    L23:
        if (r110.length() != 0) goto L25;
    L33:
        FileUtils.deleteFile(r16);
        r15 = r15 + 1;
    L31:
        th = move-exception;
        NpthLog.i(th);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        FileUtils.deleteFile(r16);
        throw th;
    L48:
        return;
    }
}
