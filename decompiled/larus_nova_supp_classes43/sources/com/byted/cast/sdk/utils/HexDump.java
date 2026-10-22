package com.byted.cast.sdk.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class HexDump {
    private static final char[] HEX_DIGITS = null;
    private static final char[] HEX_LOWER_CASE_DIGITS = null;

    public HexDump() {
    }

    public static byte[] toByteArray(byte r10) {
        return new byte[]{r10};
    }

    public static byte[] toByteArray(int r10) {
        return new byte[]{(byte) ((r10 >> 24) & 255), (byte) ((r10 >> 16) & 255), (byte) ((r10 >> 8) & 255), (byte) (r10 & 255)};
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        HEX_LOWER_CASE_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String dumpHexString(byte[] r10) {
        if (r10 != null) goto L6;
        return "(null)";
    L6:
        return dumpHexString(r10, 0, r10.length);
    }

    public static byte[] hexStringToByteArray(String r10) {
        int r0 = r10.length();
        byte[] r1 = new byte[r0 / 2];
        int r11 = 0;
    L3:
        if (r11 >= r0) goto L5;
        r1[r11 / 2] = (byte) ((toByte(r10.charAt(r11)) << 4) | toByte(r10.charAt(r11 + 1)));
        r11 = r11 + 2;
        goto L3
    L5:
        return r1;
    }

    private static int toByte(char r10) {
        if (r10 >= '0') goto L5;
    L8:
        char r0 = 'A';
        if (r10 >= 'A') goto L11;
    L14:
        r0 = 'a';
        if (r10 < 'a') goto L20;
        if (r10 > 'f') goto L20;
    L13:
        return (r10 - r0) + 10;
    L20:
        throw new RuntimeException("Invalid hex char '" + r10 + "'");
    L11:
        if (r10 > 'F') goto L14;
    L5:
        if (r10 > '9') goto L8;
        return r10 - '0';
    }

    public static String toHexString(byte r0) {
        return toHexString(toByteArray(r0));
    }

    public static String toHexString(int r0) {
        return toHexString(toByteArray(r0));
    }

    public static String toHexString(byte[] r10) {
        return toHexString(r10, 0, r10.length, true);
    }

    public static String toHexString(byte[] r10, boolean r11) {
        return toHexString(r10, 0, r10.length, r11);
    }

    public static StringBuilder appendByteAsHex(StringBuilder r1, byte r10, boolean r11) {
        if (r11 == false) goto L4;
        char[] r12 = HEX_DIGITS;
    L5:
        r1.append(r12[(r10 >> 4) & 15]);
        r1.append(r12[r10 & 15]);
        return r1;
    L4:
        r12 = HEX_LOWER_CASE_DIGITS;
        goto L5
    }

    public static String dumpHexString(byte[] r13, int r14, int r15) {
        if (r13 != null) goto L5;
        return "(null)";
    L5:
        StringBuilder r0 = new StringBuilder("\n0x");
        byte[] r10 = new byte[16];
        r0.append(toHexString(r14));
        int r11 = 0;
        int r12 = r14;
        int r16 = 0;
    L7:
        if (r12 >= (r14 + r15)) goto L19;
        if (r16 != 16) goto L18;
        r0.append(" ");
        int r17 = 0;
    L10:
        if (r17 >= 16) goto L17;
        byte r18 = r10[r17];
        if (r18 <= 32) goto L15;
        if (r18 >= 126) goto L15;
        r0.append(new String(r10, r17, 1));
    L16:
        r17 = r17 + 1;
    L15:
        r0.append(".");
        goto L16
    L17:
        r0.append("\n0x");
        r0.append(toHexString(r12));
        r16 = 0;
    L18:
        byte r19 = r13[r12];
        r0.append(" ");
        char[] r20 = HEX_DIGITS;
        r0.append(r20[(r19 >>> 4) & 15]);
        r0.append(r20[r19 & 15]);
        r10[r16] = r19;
        r12 = r12 + 1;
        r16 = r16 + 1;
        goto L7
    L19:
        if (r16 == 16) goto L31;
        int r110 = ((16 - r16) * 3) + 1;
        int r111 = 0;
    L21:
        if (r111 >= r110) goto L23;
        r0.append(" ");
        r111 = r111 + 1;
    L23:
        if (r11 >= r16) goto L31;
        byte r112 = r10[r11];
        if (r112 <= 32) goto L28;
        if (r112 >= 126) goto L28;
        r0.append(new String(r10, r11, 1));
    L29:
        r11 = r11 + 1;
    L28:
        r0.append(".");
    L31:
        return r0.toString();
    }

    public static String toHexString(byte[] r1, int r10, int r11) {
        return toHexString(r1, r10, r11, true);
    }

    public static String toHexString(byte[] r10, int r11, int r12, boolean r13) {
        if (r13 == false) goto L4;
        char[] r14 = HEX_DIGITS;
    L5:
        char[] r0 = new char[r12 * 2];
        int r1 = 0;
        int r15 = r11;
    L7:
        if (r15 >= (r11 + r12)) goto L10;
        byte r16 = r10[r15];
        int r17 = r1 + 1;
        r0[r1] = r14[(r16 >>> 4) & 15];
        r1 = r17 + 1;
        r0[r17] = r14[r16 & 15];
        r15 = r15 + 1;
        goto L7
    L10:
        return new String(r0);
    L4:
        r14 = HEX_LOWER_CASE_DIGITS;
        goto L5
    }
}
