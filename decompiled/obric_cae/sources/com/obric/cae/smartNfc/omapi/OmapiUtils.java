package com.obric.cae.smartNfc.omapi;

/* JADX INFO: loaded from: classes2.dex */
public final class OmapiUtils {
    private OmapiUtils() {
    }

    public static boolean isSuccessSw(byte[] r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.length < 2) goto L15;
        int r10 = r8[r8.length - 2] & 255;
        int r11 = r8[r8.length - 1] & 255;
        if (r10 != 144) goto L13;
        if (r11 == 0) goto L11;
        return false;
    L11:
        return true;
    L13:
        return false;
    L15:
        return false;
    }

    public static String swToString(byte[] r8) {
        if (r8 != null) goto L4;
        return "invalid";
    L4:
        if (r8.length >= 2) goto L7;
        return "invalid";
    L7:
        return Integer.toHexString(r8[r8.length - 2] & 255) + Integer.toHexString(r8[r8.length - 1] & 255);
    }

    public static String toHex(byte[] r8, int r10) {
        char[] r11 = new char[r10 * 2];
        char[] r12 = "0123456789ABCDEF".toCharArray();
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L6;
        int r14 = r8[r13] & 255;
        int r15 = r13 * 2;
        r11[r15] = r12[r14 >>> 4];
        r11[r15 + 1] = r12[r14 & 15];
        r13 = r13 + 1;
        goto L3
    L6:
        return new String(r11);
    }
}
