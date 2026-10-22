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

    public static byte[] a(int r8, byte[] r10) {
        if (r10 == null) goto L10;
        if (r8 <= 0) goto L10;
        if (r10.length != r8) goto L10;
        return ttEncrypt(r10, r8);
    L10:
        return null;
    }

    private static native byte[] ttEncrypt(byte[] r8, int r10);
}
