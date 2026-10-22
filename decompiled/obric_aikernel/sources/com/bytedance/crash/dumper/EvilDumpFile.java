package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EvilDumpFile {
    private static CrashInfoCallback sCallback;

    public EvilDumpFile() {
    }

    public static void dump(File r10) {
        CrashInfoCallback r11 = sCallback;
        if (r11 == null) goto L14;
        File[] r12 = r11.crashFileList(CrashType.ANR);
        if (r12 != null) goto L7;
        return;
    L7:
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L18;
        File r15 = r12[r14];
        File r16 = new File(r10, r15.getName());
        if (r16.exists() == true) goto L13;
        FileUtils.copy(r15, r16);
    L13:
        r14 = r14 + 1;
        goto L8
    L18:
        return;
    }

    public static void push(File r10, final JSONObject r11) {
        r10.listFiles(new AnonymousClass1(r11));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthMonitor.directReportInnerException("pushEvilFile", th);
    }

    public static void setANRCallback(CrashInfoCallback r10) {
        sCallback = r10;
    }
}
