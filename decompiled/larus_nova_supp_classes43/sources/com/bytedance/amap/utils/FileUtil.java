package com.bytedance.amap.utils;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class FileUtil {
    public FileUtil() {
    }

    public static byte[] readAllBytes(InputStream r1) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copyAllBytes(r1, r0);
        return r0.toByteArray();
    }

    public static int copyAllBytes(InputStream r10, OutputStream r11) throws IOException {
        byte[] r0 = new byte[4096];
        int r12 = 0;
    L3:
        int r13 = r10.read(r0);
        if (r13 == (-1)) goto L5;
        r11.write(r0, 0, r13);
        r12 = r12 + r13;
        goto L3
    L5:
        return r12;
    }

    public static byte[] readFileFromAssets(Context r0, String r1) throws IOException {
        if (r0 == null) goto L12;
        if (r1 == null) goto L16;
        InputStream r10 = r0.getResources().getAssets().open(r1);
        byte[] r11 = readAllBytes(r10);     // Catch: Throwable -> L9
        r10.close();
        return r11;
    L9:
        th = move-exception;
        r10.close();
        throw th;
    L16:
        return null;
    L12:
        return null;
    }
}
