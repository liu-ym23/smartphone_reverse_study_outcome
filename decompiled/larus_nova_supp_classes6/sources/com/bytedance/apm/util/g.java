package com.bytedance.apm.util;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class g {
    public g() {
    }

    static {
    }

    public static File c(Context r2) {
        File r0 = null;
        if (r2 != null) goto L10;
        return null;
    L10:
        r0 = r2.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L6:
        r0 = r0.getParentFile();     // Catch: Throwable -> L9
        if (r0.getAbsolutePath().contains("/Android") == true) goto L6;
    L8:
        return r0;
    }

    public static String d(PolarisFileWrapper r2) {
        String[] r3 = r2.getName().split("\\.");
        if (r3.length > 1) goto L7;
        return "";
    L7:
        return r3[r3.length - 2];
    }

    public static long e(File r6) {
        long r1 = -1;
        if (r6.exists() == true) goto L6;
        return -1;
    L6:
        if (r6.isFile() == false) goto L10;
        return r6.length();
    L10:
        if (r6.isDirectory() == false) goto L14;
        File[] r7 = r6.listFiles();
        int r0 = r7.length;
        r1 = 0;
        int r3 = 0;
    L12:
        if (r3 >= r0) goto L14;
        r1 = r1 + e(r7[r3]);
        r3 = r3 + 1;
    L14:
        return r1;
    }

    public static void b(String r7, String... r8) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r7);
        PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r0);     // Catch: Throwable -> L25 Exception -> L28
        r0 = new CheckedOutputStream(r1, new CRC32());     // Catch: Throwable -> L21 Exception -> L23
    L42:
        ZipOutputStream r2 = new ZipOutputStream(r0);     // Catch: Throwable -> L17 Exception -> L19
        int r9 = r8.length;     // Catch: Exception -> L15 Throwable -> L33
        int r3 = 0;
    L7:
        if (r3 >= r9) goto L13;
        String r4 = r8[r3];     // Catch: Exception -> L15 Throwable -> L33
        PolarisFileWrapper r5 = new PolarisFileWrapper(r4);     // Catch: Exception -> L15 Throwable -> L33
        if (r5.exists() == false) goto L12;
        a(r5, r2, "");     // Catch: Exception -> L15 Throwable -> L33
        r3 = r3 + 1;     // Catch: Exception -> L15 Throwable -> L33
        goto L7
    L12:
        throw new RuntimeException(r4 + "not exist！");     // Catch: Exception -> L15 Throwable -> L33
    L13:
        d27.d.a(r2);
        d27.d.a(r0);
        d27.d.a(r1);
        return;
    L15:
        Exception e = e;
    L32:
        throw new RuntimeException(e);     // Catch: Throwable -> L33
    L19:
        e = e;
    L30:
        e = e;
    L17:
        th = th;
        Closeable r6 = null;
    L27:
        th = th;
    L34:
        d27.d.a(r6);
        d27.d.a(r0);
        d27.d.a(r1);
        throw th;
    L23:
        e = e;
    L21:
        th = th;
        r0 = null;
        r6 = null;
        goto L27
    L33:
        th = th;
    L28:
        e = e;
    L25:
        th = th;
        r0 = null;
        r1 = null;
        r6 = null;
        goto L27
    }

    public static void a(File r5, ZipOutputStream r6, String r7) {
        int r1 = 0;
        if (r5.isDirectory() == false) goto L11;
        String r8 = r7 + r5.getName() + File.separator;
        if (r5.exists() == false) goto L53;
        File[] r9 = r5.listFiles();
    L9:
        if (r1 >= r9.length) goto L55;
        a(r9[r1], r6, r8);
        r1 = r1 + 1;
        goto L9
    L55:
        return;
    L53:
        return;
    L11:
        System.out.println("compress：" + r7 + r5.getName());
        if (r5.exists() == false) goto L54;
        BufferedInputStream r0 = null;
        BufferedInputStream r2 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L32 Exception -> L34
        BufferedInputStream r3 = new BufferedInputStream(r2);     // Catch: Throwable -> L28 Exception -> L30
        r6.putNextEntry(new ZipEntry(r7 + r5.getName()));     // Catch: Throwable -> L24 Exception -> L26
        byte[] r10 = new byte[8192];     // Catch: Throwable -> L24 Exception -> L26
    L18:
        int r4 = r3.read(r10, 0, 8192);     // Catch: Throwable -> L24 Exception -> L26
        if (r4 == (-1)) goto L22;
        r6.write(r10, 0, r4);     // Catch: Throwable -> L24 Exception -> L26
    L22:
        d27.d.a(r3);
        d27.d.a(r2);
        return;
    L26:
        e = e;
        r0 = r3;
    L31:
        BufferedInputStream r11 = r0;
        r0 = r2;
    L42:
    L38:
        th = th;
        r2 = r0;
        r0 = r11;
    L40:
        d27.d.a(r0);
        d27.d.a(r2);
        throw th;
    L37:
        throw new RuntimeException(e);     // Catch: Throwable -> L38
    L24:
        th = th;
        r0 = r3;
        goto L40
    L30:
        e = e;
    L28:
        th = th;
        goto L40
    L34:
        e = e;
        r11 = null;
    L32:
        th = th;
        r2 = null;
        goto L40
    }
}
