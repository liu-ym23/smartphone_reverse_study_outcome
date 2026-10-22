package com.monitor.cloudmessage.c.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static File a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        BufferedWriter r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        String r7 = com.monitor.cloudmessage.utils.c.a(r6).getAbsolutePath();
        String r0 = r7 + File.separator + "template.txt";
        File r2 = new File(r7);     // Catch: Throwable -> L27 IOException -> L29
        if (r2.exists() == true) goto L9;
        r2.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L9:
        FileWriter r8 = new FileWriter(r0);     // Catch: Throwable -> L27 IOException -> L29
    L64:
        BufferedWriter r3 = new BufferedWriter(r8);     // Catch: Throwable -> L22 IOException -> L24
        r3.write(r5);     // Catch: Throwable -> L18 IOException -> L20
        r3.close();     // Catch: IOException -> L14
        r8.close();     // Catch: IOException -> L14
    L17:
        return new File(r0);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L20:
        e = e;
    L26:
        IOException r9 = e;
        FileWriter r10 = r8;
        e = r9;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r3 != null) goto L56;
    L36:
        if (r10 == null) goto L40;
        r10.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L56:
        r3.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r1 = r3;
    L43:
        if (r1 != null) goto L54;
    L47:
        if (r10 == null) goto L51;
        r10.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L54:
        r1.close();     // Catch: IOException -> L45
    L18:
        th = th;
        r1 = r3;
    L23:
        Throwable r11 = th;
        r10 = r8;
        th = r11;
        goto L43
    L24:
        e = e;
        r3 = null;
    L22:
        th = th;
    L29:
        e = e;
        r10 = null;
        r3 = null;
    L27:
        th = th;
        r10 = null;
        goto L43
    }
}
