package com.bytedance.frameworks.encryptor;

/* JADX INFO: loaded from: classes.dex */
public class EncryptorUtil {
    static {
        System.loadLibrary("Encryptor");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public EncryptorUtil() {
    }

    public static byte[] a(byte[] r10, int r11) {
        if (r10 == null) goto L10;
        if (r11 <= 0) goto L10;
        if (r10.length != r11) goto L10;
        return ttEncrypt(r10, r11);
    L10:
        return null;
    }

    private static native byte[] ttEncrypt(byte[] r10, int r11);
}
