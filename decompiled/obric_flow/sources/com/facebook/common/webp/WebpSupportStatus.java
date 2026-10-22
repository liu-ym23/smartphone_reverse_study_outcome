package com.facebook.common.webp;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebpSupportStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f7700a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f7701b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f7702c = null;
    public static final byte[] d = null;
    public static final byte[] e = null;
    public static final byte[] f = null;

    static {
        f7700a = false;
        f7701b = a("RIFF");
        f7702c = a("WEBP");
        d = a("VP8 ");
        e = a("VP8L");
        f = a("VP8X");
    }

    public static byte[] a(String r5) {
        return r5.getBytes("ASCII");
    L4:
        e = move-exception;
        throw new RuntimeException("ASCII not found!", e);
    }

    public static boolean a(byte[] r5, int r10, byte[] r11) {
        if (r11 != null) goto L5;
        return false;
    L5:
        if ((r11.length + r10) <= r5.length) goto L7;
        return false;
    L7:
        int r12 = 0;
    L9:
        if (r12 >= r11.length) goto L14;
        if (r5[r12 + r10] != r11[r12]) goto L12;
        r12 = r12 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    }
}
