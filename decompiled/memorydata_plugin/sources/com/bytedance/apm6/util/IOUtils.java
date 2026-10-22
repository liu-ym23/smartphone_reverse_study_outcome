package com.bytedance.apm6.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class IOUtils {
    public IOUtils() {
    }

    public static void closeQuietly(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static boolean mkdir(String r1) {
        return new File(r1).mkdirs();
    }

    public static void safeClose(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void safeClose(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: Throwable -> L6
        return;
    }

    public static byte[] toByteArray(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r3 = r4.read(r1);
        if ((-1) == r3) goto L6;
        r0.write(r1, 0, r3);
        goto L3
    L6:
        if (r4 == null) goto L9;
        r4.close();
    L9:
        return r0.toByteArray();
    }
}
