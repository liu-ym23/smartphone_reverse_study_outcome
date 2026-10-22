package com.bytedance.frameworks.encryptor;

/* JADX INFO: loaded from: classes2.dex */
public class EncryptorUtil {
    static {
        System.loadLibrary("Encryptor");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static byte[] a(int r5, byte[] r10) {
        if (r10 == null) goto L10;
        if (r5 <= 0) goto L10;
        if (r10.length != r5) goto L10;
        return ttEncrypt(r10, r5);
    L10:
        return null;
    }

    private static native byte[] ttEncrypt(byte[] r5, int r10);
}
