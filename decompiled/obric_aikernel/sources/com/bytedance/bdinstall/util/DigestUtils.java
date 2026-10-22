package com.bytedance.bdinstall.util;

import com.bytedance.crypto.utils.CryptoConst;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DigestUtils {
    private static final char[] HEX_CHARS = null;

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public DigestUtils() {
    }

    public static byte[] hexStringToBytes(String r10) {
        if (r10 == null) goto L10;
        if ((r10.length() % 2) == 1) goto L10;
        char[] r11 = r10.toCharArray();
        int r12 = r11.length;
        byte[] r13 = new byte[r12 / 2];
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L8;
        r13[r14 / 2] = (byte) ((Character.digit(r11[r14], 16) << 4) + Character.digit(r11[r14 + 1], 16));
        r14 = r14 + 2;
        goto L6
    L8:
        return r13;
    L10:
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + r10);
    }

    public static String md5Hex(File r10) {
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L12
        if (r11 != null) goto L6;
        return null;
    L6:
        FileInputStream r12 = new FileInputStream(r10);     // Catch: Exception -> L12
        byte[] r13 = new byte[8192];     // Catch: Exception -> L12
    L7:
        int r14 = r12.read(r13, 0, 8192);     // Catch: Exception -> L12
        if (r14 <= 0) goto L10;
        r11.update(r13, 0, r14);     // Catch: Exception -> L12
        goto L7
    L10:
        r12.close();     // Catch: Exception -> L12
        return toHexString(r11.digest());
    L12:
        return null;
    }

    public static String md5Hex(String r10) {
        if (r10 != null) goto L11;
    L9:
        return null;
    L11:
        if (r10.length() == 0) goto L9;
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r11.update(r10.getBytes("UTF-8"));     // Catch: Exception -> L10
        return toHexString(r11.digest());
    }

    public static String md5Hex(byte[] r10) {
        if (r10 != null) goto L11;
    L9:
        return null;
    L11:
        if (r10.length == 0) goto L9;
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r11.update(r10);     // Catch: Exception -> L10
        return toHexString(r11.digest());
    }

    public static String md5Hex(byte[] r10, int r11, int r12) {
        if (r10 == null) goto L12;
        if (r11 < 0) goto L12;
        if (r12 <= 0) goto L12;
        if ((r11 + r12) > r10.length) goto L12;
        MessageDigest r13 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L13
        r13.update(r10, r11, r12);     // Catch: Exception -> L13
        return toHexString(r13.digest());
    L12:
        return null;
    }

    public static String toHexString(byte[] r10) {
        Objects.requireNonNull(r10, "bytes is null");
        return toHexString(r10, 0, r10.length);
    }

    public static String toHexString(byte[] r10, int r11, int r12) {
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
        char[] r19 = HEX_CHARS;
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
