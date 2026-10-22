package com.bytedance.crash.asan;

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

/* JADX INFO: loaded from: classes2.dex */
public class AsanReport {
    private static final String DIR_NAME = "asan";

    public AsanReport() {
    }

    public static void upload() {
        AppMonitor r1 = MonitorManager.getAppMonitor();
        if (r1 != null) goto L5;
        return;
    L5:
        File r2 = new File(LogPathConfig.getNpthRootPath(), DIR_NAME);
        if (r2.exists() == true) goto L8;
        return;
    L8:
        File[] r3 = r2.listFiles();
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.length == 0) goto L47;
        Pattern r4 = Pattern.compile("^asan_report\\.(\\d{1,5})$");
        int r5 = r3.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L48;
        File r7 = r3[r6];
        Matcher r8 = r4.matcher(r7.getName());     // Catch: Throwable -> L31
        if (r8.find() == false) goto L33;
        if (r8.groupCount() != 1) goto L33;
        int r9 = Integer.parseInt(r8.group(1));     // Catch: Throwable -> L31
        long r11 = new Date(r7.lastModified()).getTime();     // Catch: Throwable -> L31
        CrashBody r10 = new CrashBody();     // Catch: Throwable -> L31
        String r13 = FileSystemUtils.readUtf8File(r7);     // Catch: Throwable -> L31
        if (r13 != null) goto L23;
    L24:
        r13 = "AsanReport is Null";
    L25:
        r10.put("data", r13);     // Catch: Throwable -> L31
        r10.put("crash_time", Long.valueOf(r11));     // Catch: Throwable -> L31
        r10.put(Header.KEY_CRASH_TYPE, DIR_NAME);     // Catch: Throwable -> L31
        r10.put(CrashBody.IS_NATIVE_CRASH, 1);     // Catch: Throwable -> L31
        r10.put("commit_id", "1");     // Catch: Throwable -> L31
        r10.put("jenkins_job_id", "1");     // Catch: Throwable -> L31
        BuildId.putAsanBuildIdToJson(r10.getJson(), r7);     // Catch: Throwable -> L31
        r10.setHeader(Header.createEventHeader(r1, r11, CrashType.ASAN, r9));     // Catch: Throwable -> L31
        Response r12 = CrashUploader.uploadCrashLogWithAttachment(DIR_NAME, UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.ASAN, r10.getHeader().getJson()), r10.getJson().toString(), new ArrayList());     // Catch: Throwable -> L31
        StringBuilder r14 = new StringBuilder().append(r7.getName()).append("upload ");     // Catch: Throwable -> L31
        if (r12.isSuccess() == false) goto L28;
        String r15 = "success";
    L29:
        NpthLog.i(r14.append(r15).toString());     // Catch: Throwable -> L31
        goto L33
    L28:
        r15 = "fail";
        goto L29
    L23:
        if (r13.length() != 0) goto L25;
    L33:
        FileUtils.deleteFile(r7);
        r6 = r6 + 1;
    L31:
        th = move-exception;
        NpthLog.i(th);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        FileUtils.deleteFile(r7);
        throw th;
    L48:
        return;
    }
}
