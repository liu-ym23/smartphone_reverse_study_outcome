package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EvilDumpFile {
    private static CrashInfoCallback sCallback;

    public EvilDumpFile() {
    }

    public static void dump(File r6) {
        CrashInfoCallback r0 = sCallback;
        if (r0 == null) goto L14;
        File[] r1 = r0.crashFileList(CrashType.ANR);
        if (r1 != null) goto L7;
        return;
    L7:
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L18;
        File r4 = r1[r3];
        File r5 = new File(r6, r4.getName());
        if (r5.exists() == true) goto L13;
        FileUtils.copy(r4, r5);
    L13:
        r3 = r3 + 1;
        goto L8
    L18:
        return;
    }

    public static void push(File r1, final JSONObject r2) {
        r1.listFiles(new AnonymousClass1(r2));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthMonitor.directReportInnerException("pushEvilFile", th);
    }

    public static void setANRCallback(CrashInfoCallback r0) {
        sCallback = r0;
    }
}
