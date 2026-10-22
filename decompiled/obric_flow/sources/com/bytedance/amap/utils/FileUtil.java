package com.bytedance.amap.utils;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FileUtil {
    public static byte[] a(Context r5, String r10) {
        InputStream r11 = r5.getResources().getAssets().open(r10);
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: Throwable -> L9
        byte[] r13 = new byte[4096];     // Catch: Throwable -> L9
    L4:
        int r14 = r11.read(r13);     // Catch: Throwable -> L9
        if (r14 == (-1)) goto L6;
        r12.write(r13, 0, r14);     // Catch: Throwable -> L9
        goto L4
    L6:
        byte[] r15 = r12.toByteArray();     // Catch: Throwable -> L9
        r11.close();
        return r15;
    L9:
        th = move-exception;
        r11.close();
        throw th;
    }
}
