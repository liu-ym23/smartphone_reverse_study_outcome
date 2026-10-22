package com.obric.assistant;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.larus.common.apphost.AppHost;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class r1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public /* synthetic */ r1(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        String r1 = this.b;
        List r2 = ObricRequestSettingsServiceImpl.a;
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L16
        r3.append(AppHost.a.getApplication().getFilesDir());     // Catch: Throwable -> L16
        String r4 = File.separator;     // Catch: Throwable -> L16
        r3.append(r4);     // Catch: Throwable -> L16
        r3.append("logs");     // Catch: Throwable -> L16
        r3.append(r4);     // Catch: Throwable -> L16
        r3.append(r0);     // Catch: Throwable -> L16
        r3.append(".json");     // Catch: Throwable -> L16
        PolarisFileWrapper r5 = new PolarisFileWrapper(r3.toString());     // Catch: Throwable -> L16
        m5.a(r5);     // Catch: Throwable -> L16
        if (r5.exists() == true) goto L11;
        File r6 = r5.getParentFile();     // Catch: Throwable -> L16
        if (r6 != null) goto L8;
    L10:
        r5.createNewFile();     // Catch: Throwable -> L16
        goto L11
    L8:
        if (r6.exists() == true) goto L10;
        r6.mkdirs();     // Catch: Throwable -> L16
    L11:
        BufferedWriter r7 = new BufferedWriter(new PolarisFileWriterWrapper(r5, true));     // Catch: Throwable -> L16
        r7.write(r1);     // Catch: Throwable -> L14
    L38:
        r7.close();     // Catch: IOException -> L22
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        Throwable th = th;
    L36:
        th.printStackTrace();     // Catch: Throwable -> L25
        if (r7 != null) goto L38;
        return;
    L25:
        th = move-exception;
        if (r7 != null) goto L40;
    L31:
        throw th;
    L40:
        r7.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L16:
        th = move-exception;
        th = th;
        r7 = null;
        goto L36
    }
}
