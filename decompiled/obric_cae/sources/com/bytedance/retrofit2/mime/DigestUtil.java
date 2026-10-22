package com.bytedance.retrofit2.mime;

import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class DigestUtil {
    private static final char[] DIGITS_UPPER = null;
    private static final int STREAM_BUFFER_LENGTH = 1024;

    static {
        DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public DigestUtil() {
    }

    private static char[] encodeHex(byte[] r8, char[] r10) {
        int r11 = r8.length;
        char[] r12 = new char[r11 << 1];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L5;
        int r15 = r14 + 1;
        byte r16 = r8[r13];
        r12[r14] = r10[(r16 & 240) >>> 4];
        r14 = r15 + 1;
        r12[r15] = r10[r16 & 15];
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public static String md5Hex(InputStream r8) {
        MessageDigest r10 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L8
        byte[] r11 = new byte[1024];     // Catch: Throwable -> L8
        int r12 = r8.read(r11, 0, 1024);     // Catch: Throwable -> L8
    L4:
        if (r12 <= (-1)) goto L6;
        r10.update(r11, 0, r12);     // Catch: Throwable -> L8
        r12 = r8.read(r11, 0, 1024);     // Catch: Throwable -> L8
        goto L4
    L6:
        return new String(encodeHex(r10.digest(), DIGITS_UPPER));
    L8:
        return null;
    }

    public static String md5Hex(byte[] r8) {
        return new String(encodeHex(MessageDigest.getInstance("MD5").digest(r8), DIGITS_UPPER));
    L4:
        return null;
    }
}
