package com.bytedance.common.utility;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f1975a = null;

    static {
        f1975a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] r2) {
        Objects.requireNonNull(r2, "bytes is null");
        return a(r2, 0, r2.length);
    }

    public static String a(byte[] r9, int r10, int r11) {
        Objects.requireNonNull(r9, "bytes is null");
        if (r10 < 0) goto L12;
        if ((r10 + r11) > r9.length) goto L12;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r11) goto L10;
        int r5 = r9[r3 + r10] & 255;
        int r6 = r4 + 1;
        char[] r7 = f1975a;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1, 0, r0);
    L12:
        throw new IndexOutOfBoundsException();
    }

    public static byte[] a(String r7) {
        if (r7 == null) goto L10;
        if ((r7.length() % 2) == 1) goto L10;
        char[] r8 = r7.toCharArray();
        int r0 = r8.length;
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2 / 2] = (byte) ((Character.digit(r8[r2], 16) << 4) + Character.digit(r8[r2 + 1], 16));
        r2 = r2 + 2;
        goto L6
    L8:
        return r1;
    L10:
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + r7);
    }

    public static String b(byte[] r2) {
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        if (r2.length == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r1.update(r2);     // Catch: Exception -> L10
        return a(r1.digest());
    }
}
