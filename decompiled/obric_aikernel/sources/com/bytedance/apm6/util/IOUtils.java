package com.bytedance.apm6.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class IOUtils {
    public IOUtils() {
    }

    public static void closeQuietly(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static boolean mkdir(String r10) {
        return new File(r10).mkdirs();
    }

    public static void safeClose(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void safeClose(ZipFile r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.close();     // Catch: Throwable -> L6
        return;
    }

    public static byte[] toByteArray(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[8192];
    L3:
        int r13 = r10.read(r12);
        if ((-1) == r13) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    L6:
        r10.close();
        return r11.toByteArray();
    }
}
