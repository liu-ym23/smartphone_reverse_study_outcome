package com.bytedance.common.utility;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f1258a = null;

    static {
        f1258a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(String r10) {
        if (r10 != null) goto L11;
    L9:
        return null;
    L11:
        if (r10.length() == 0) goto L9;
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r11.update(r10.getBytes("UTF-8"));     // Catch: Exception -> L10
        return c(r11.digest());
    }

    public static String b(byte[] r10) {
        if (r10 != null) goto L11;
    L9:
        return null;
    L11:
        if (r10.length == 0) goto L9;
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r11.update(r10);     // Catch: Exception -> L10
        return c(r11.digest());
    }

    public static String c(byte[] r10) {
        Objects.requireNonNull(r10, "bytes is null");
        return d(r10, 0, r10.length);
    }

    public static String d(byte[] r10, int r11, int r12) {
        Objects.requireNonNull(r10, "bytes is null");
        if (r11 < 0) goto L12;
        if ((r11 + r12) > r10.length) goto L12;
        int r13 = r12 * 2;
        char[] r14 = new char[r13];
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r12) goto L10;
        int r17 = r10[r15 + r11] & 255;
        int r18 = r16 + 1;
        char[] r19 = f1258a;
        r14[r16] = r19[r17 >> 4];
        r16 = r18 + 1;
        r14[r18] = r19[r17 & 15];
        r15 = r15 + 1;
        goto L7
    L10:
        return new String(r14, 0, r13);
    L12:
        throw new IndexOutOfBoundsException();
    }
}
