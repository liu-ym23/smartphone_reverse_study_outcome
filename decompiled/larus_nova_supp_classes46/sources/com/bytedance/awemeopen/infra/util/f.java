package com.bytedance.awemeopen.infra.util;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static void a(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String b(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L9 Exception -> L12
        byte[] r1 = new byte[1024];     // Catch: Throwable -> L9 Exception -> L12
    L3:
        int r2 = r4.read(r1);     // Catch: Throwable -> L9 Exception -> L12
        if (r2 == (-1)) goto L6;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L9 Exception -> L12
        goto L3
    L6:
        String r3 = r0.toString("UTF-8");     // Catch: Throwable -> L9 Exception -> L12
        a(r4);
        return r3;
    L12:
        a(r4);
        return "";
    L9:
        th = move-exception;
        a(r4);
        throw th;
    }

    public static byte[] c(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L28:
        return null;
    L5:
        if (new PolarisFileWrapper(r6).exists() == false) goto L28;
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(r6);     // Catch: Throwable -> L22 Throwable -> L26
    L34:
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();     // Catch: Throwable -> L19 Throwable -> L21
    L32:
        byte[] r2 = new byte[1024];     // Catch: Throwable -> L17 Throwable -> L29
    L11:
        int r3 = r0.read(r2);     // Catch: Throwable -> L17 Throwable -> L29
        if (r3 == (-1)) goto L14;
        r7.write(r2, 0, r3);     // Catch: Throwable -> L17 Throwable -> L29
        goto L11
    L14:
        byte[] r1 = r7.toByteArray();     // Catch: Throwable -> L17 Throwable -> L29
        a(r0);
        a(r7);
        return r1;
    L17:
        Throwable th = th;
    L24:
        a(r0);
        a(r7);
        throw th;
    L27:
        a(r0);
        a(r7);
    L21:
        r7 = null;
    L19:
        th = move-exception;
        th = th;
        r7 = null;
    L26:
        r7 = null;
        r0 = null;
    L22:
        th = move-exception;
        r0 = null;
        th = th;
        r7 = null;
        goto L24
    }

    public static void delete(File r3) {
        if (r3.isFile() == false) goto L7;
        r3.delete();
        return;
    L7:
        if (r3.isDirectory() == false) goto L21;
        File[] r0 = r3.listFiles();
        if (r0 != null) goto L11;
    L18:
        r3.delete();
        return;
    L11:
        if (r0.length == 0) goto L18;
        int r1 = 0;
    L15:
        if (r1 >= r0.length) goto L17;
        delete(r0[r1]);
        r1 = r1 + 1;
        goto L15
    L17:
        r3.delete();
        return;
    }

    public static boolean d(String r2, String r3) throws IOException {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        if (r0.exists() == true) goto L9;
        r0.createNewFile();
    L9:
        BufferedWriter r4 = new BufferedWriter(new PolarisFileWriterWrapper(r0));
        r4.write(r3);
        r4.flush();
        r4.close();
        return true;
    }
}
