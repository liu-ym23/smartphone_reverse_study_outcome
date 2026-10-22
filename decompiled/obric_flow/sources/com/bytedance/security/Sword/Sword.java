package com.bytedance.security.Sword;

/* JADX INFO: loaded from: classes2.dex */
public class Sword {
    static {
        System.loadLibrary("bdsword");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static native byte[] GenKeySeed();

    public static native int GetCryptoMethod();

    public static native int IsSupportedMethod(int r5);

    public static native byte[] WBCKGenKeySeed();

    public static native int WBCKGetCryptoMethod();

    public static native byte[] WBCKPacked(byte[] r5, int r10, byte[] r11, int r12);

    public static native byte[] WBCKPackedNaked(byte[] r5, int r10, byte[] r11, int r12);

    public static native byte[] WBCKUnpacked(byte[] r5, int r10, byte[] r11);

    public static native byte[] clientPacked(byte[] r5, int r10);

    public static native String clientPackedBase64(byte[] r5, int r10);

    public static native byte[] clientPackedNaked(byte[] r5, int r10, int r11, byte[] r12);

    public static native String clientPackedNakedBase64(byte[] r5, int r10, int r11, byte[] r12);

    public static native byte[] clientUnpacked(byte[] r5, int r10);

    public static native byte[] clientUnpackedBase64(String r5);

    public static native byte[] clientUnpackedNaked(byte[] r5, int r10, int r11, byte[] r12);

    public static native byte[] clientUnpackedNakedBase64(String r5, int r10, String r11);
}
