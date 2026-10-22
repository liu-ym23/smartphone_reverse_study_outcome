package com.bytedance.applog.compress;

import com.bytedance.applog.log.q;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static byte[] a(byte[] r7) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L14
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L12
        if (r7 != null) goto L24;
    L10:
        d.a(r2);
        d.a(r1);
        return r1.toByteArray();
    L24:
        r2.write(r7);     // Catch: Throwable -> L8
    L8:
        th = th;
    L28:
        q.a().a(14, "compress with gzip failed", th, new Object[0]);     // Catch: Throwable -> L19
        d.a(r2);
        d.a(r1);
        return null;
    L19:
        th = move-exception;
        d.a(r2);
        d.a(r1);
        throw th;
    L12:
        th = th;
        r2 = null;
    L14:
        th = th;
        r1 = null;
        r2 = null;
        goto L28
    }
}
