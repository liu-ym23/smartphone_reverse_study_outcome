package com.monitor.cloudmessage.c.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static File a(Context r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        BufferedWriter r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        String r8 = com.monitor.cloudmessage.utils.c.a(r7).getAbsolutePath();
        String r9 = r8 + File.separator + r6 + ".txt";
        File r0 = new File(r8);     // Catch: Throwable -> L27 IOException -> L29
        if (r0.exists() == true) goto L9;
        r0.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L9:
        FileWriter r10 = new FileWriter(r9);     // Catch: Throwable -> L27 IOException -> L29
    L64:
        BufferedWriter r2 = new BufferedWriter(r10);     // Catch: Throwable -> L22 IOException -> L24
        r2.write(r5);     // Catch: Throwable -> L18 IOException -> L20
        r2.close();     // Catch: IOException -> L14
        r10.close();     // Catch: IOException -> L14
    L17:
        return new File(r9);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L20:
        e = e;
    L26:
        IOException r3 = e;
        FileWriter r11 = r10;
        e = r3;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r2 != null) goto L56;
    L36:
        if (r11 == null) goto L40;
        r11.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L56:
        r2.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r1 = r2;
    L43:
        if (r1 != null) goto L54;
    L47:
        if (r11 == null) goto L51;
        r11.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L54:
        r1.close();     // Catch: IOException -> L45
    L18:
        th = th;
        r1 = r2;
    L23:
        Throwable r12 = th;
        r11 = r10;
        th = r12;
        goto L43
    L24:
        e = e;
        r2 = null;
    L22:
        th = th;
    L29:
        e = e;
        r11 = null;
        r2 = null;
    L27:
        th = th;
        r11 = null;
        goto L43
    }
}
