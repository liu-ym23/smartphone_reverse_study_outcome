package com.tom_roush.pdfbox.io;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static long a(InputStream r5, OutputStream r6) {
        byte[] r0 = new byte[4096];
        long r1 = 0;
    L3:
        int r4 = r5.read(r0);
        if ((-1) == r4) goto L6;
        r6.write(r0, 0, r4);
        r1 = r1 + ((long) r4);
        goto L3
    L6:
        return r1;
    }

    public static long a(InputStream r2, byte[] r3) {
        int r0 = r3.length;
    L3:
        if (r0 <= 0) goto L9;
        int r1 = r2.read(r3, r3.length - r0, r0);
        if (r1 < 0) goto L9;
        r0 = r0 - r1;
    L9:
        return r3.length - r0;
    }

    public static IOException a(Closeable r2, String r3, IOException r4) {
        ((Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin")).close();     // Catch: IOException -> L5
    L9:
        return r4;
    L5:
        e = move-exception;
        Log.w("PdfBox-Android", "Error closing " + r3, e);
        if (r4 != null) goto L9;
        return e;
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public static byte[] a(InputStream r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        a(r1, r0);
        return r0.toByteArray();
    }
}
