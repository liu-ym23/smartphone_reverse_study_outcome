package com.monitor.cloudmessage.c.b.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static File a(Context r4, JSONObject r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        BufferedWriter r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        String r7 = com.monitor.cloudmessage.utils.c.a(r6).getAbsolutePath();
        String r1 = r7 + File.separator + "stats.txt";
        File r2 = new File(r7);     // Catch: Throwable -> L27 IOException -> L29
        if (r2.exists() == true) goto L9;
        r2.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L9:
        FileWriter r8 = new FileWriter(r1);     // Catch: Throwable -> L27 IOException -> L29
        BufferedWriter r3 = new BufferedWriter(r8);     // Catch: Throwable -> L22 IOException -> L24
    L62:
        r3.write(r5.toString());     // Catch: Throwable -> L18 IOException -> L20
        r3.close();     // Catch: IOException -> L14
        r8.close();     // Catch: IOException -> L14
    L17:
        return new File(r1);
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
    L56:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r3 != null) goto L58;
    L36:
        if (r10 == null) goto L40;
        r10.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L58:
        r3.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r0 = r3;
    L43:
        if (r0 != null) goto L54;
    L47:
        if (r10 == null) goto L51;
        r10.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L54:
        r0.close();     // Catch: IOException -> L45
    L18:
        th = th;
        r0 = r3;
    L23:
        Throwable r11 = th;
        r10 = r8;
        th = r11;
    L24:
        e = e;
        r3 = null;
    L22:
        th = th;
        goto L23
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
