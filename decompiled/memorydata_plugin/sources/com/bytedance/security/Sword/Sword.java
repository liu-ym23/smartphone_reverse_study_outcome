package com.bytedance.security.Sword;

/* JADX INFO: loaded from: classes2.dex */
public class Sword {
    public static final int BC_METHOD_AES_CBC_KS_v1 = 1;
    public static final int BC_METHOD_AES_CBC_KS_v2 = 20;
    public static final int BC_METHOD_RC4_KS = 3;

    static {
        System.loadLibrary("bdsword");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public Sword() {
    }

    public static native byte[] GenKeySeed();

    public static native int GetCryptoMethod();

    public static native int IsSupportedMethod(int r0);

    public static native byte[] WBCKGenKeySeed();

    public static native int WBCKGetCryptoMethod();

    public static native byte[] WBCKPacked(byte[] r0, int r1, byte[] r2, int r3);

    public static native byte[] WBCKPackedNaked(byte[] r0, int r1, byte[] r2, int r3);

    public static native byte[] WBCKUnpacked(byte[] r0, int r1, byte[] r2);

    public static native byte[] clientPacked(byte[] r0, int r1);

    public static native String clientPackedBase64(byte[] r0, int r1);

    public static native byte[] clientPackedNaked(byte[] r0, int r1, int r2, byte[] r3);

    public static native String clientPackedNakedBase64(byte[] r0, int r1, int r2, byte[] r3);

    public static native byte[] clientUnpacked(byte[] r0, int r1);

    public static native byte[] clientUnpackedBase64(String r0);

    public static native byte[] clientUnpackedNaked(byte[] r0, int r1, int r2, byte[] r3);

    public static native byte[] clientUnpackedNakedBase64(String r0, int r1, String r2);
}
