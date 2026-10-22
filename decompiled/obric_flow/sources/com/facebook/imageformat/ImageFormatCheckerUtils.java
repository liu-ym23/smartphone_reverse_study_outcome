package com.facebook.imageformat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImageFormatCheckerUtils {
    public static byte[] a(String r5) {
        return r5.getBytes("ASCII");
    L4:
        e = move-exception;
        throw new RuntimeException("ASCII not found!", e);
    }

    public static boolean a(byte[] r5, byte[] r10, int r11) {
        r10.getClass();
        if ((r10.length + r11) <= r5.length) goto L5;
        return false;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L12;
        if (r5[r11 + r12] != r10[r12]) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }
}
