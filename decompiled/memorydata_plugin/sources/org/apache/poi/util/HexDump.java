package org.apache.poi.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.UShort;

/* JADX INFO: loaded from: classes7.dex */
public final class HexDump {
    public static final String EOL = null;
    public static final Charset UTF8 = null;

    static {
        EOL = System.getProperty("line.separator");
        UTF8 = StandardCharsets.UTF_8;
    }

    public static String dump(byte[] r1, long r2, int r4) {
        return dump(r1, r2, r4, Integer.MAX_VALUE);
    }

    public static String dump(byte[] r9, long r10, int r12, int r13) {
        if (r9 == null) goto L37;
        if (r9.length == 0) goto L37;
        if (r13 == Integer.MAX_VALUE) goto L13;
        if (r13 < 0) goto L13;
        int r14 = r13 + r12;
        if (r14 < 0) goto L13;
        int r15 = Math.min(r9.length, r14);
    L14:
        if (r12 < 0) goto L35;
        if (r12 >= r9.length) goto L35;
        long r11 = r10 + ((long) r12);
        StringBuilder r0 = new StringBuilder(74);
    L18:
        if (r12 >= r15) goto L33;
        int r1 = r15 - r12;
        if (r1 <= 16) goto L22;
        r1 = 16;
    L22:
        writeHex(r0, r11, 8, "");
        int r3 = 0;
        int r4 = 0;
    L23:
        if (r4 >= 16) goto L28;
        if (r4 >= r1) goto L26;
        writeHex(r0, r9[r4 + r12], 2, " ");
    L27:
        r4 = r4 + 1;
        goto L23
    L26:
        r0.append("   ");
        goto L27
    L28:
        r0.append(' ');
    L29:
        if (r3 >= r1) goto L31;
        r0.append(toAscii(r9[r3 + r12]));
        r3 = r3 + 1;
        goto L29
    L31:
        r0.append(EOL);
        r11 = r11 + ((long) r1);
        r12 = r12 + 16;
        goto L18
    L33:
        return r0.toString();
    L35:
        throw new ArrayIndexOutOfBoundsException("illegal index: " + r12 + " into array of length " + r9.length);
    L13:
        r15 = r9.length;
    L37:
        return "No Data" + EOL;
    }

    public static String longToHex(long r3) {
        StringBuilder r0 = new StringBuilder(18);
        writeHex(r0, r3, 16, "0x");
        return r0.toString();
    }

    public static char toAscii(int r3) {
        char r4 = (char) (r3 & 255);
        if (Character.isISOControl(r4) == false) goto L6;
        return '.';
    L6:
        if (r4 == 221) goto L10;
        if (r4 == 255) goto L10;
        return r4;
    L10:
        return '.';
    }

    public static String toHex(byte r4) {
        StringBuilder r0 = new StringBuilder(2);
        writeHex(r0, r4 & 255, 2, "");
        return r0.toString();
    }

    public static String toHex(int r6) {
        StringBuilder r0 = new StringBuilder(8);
        writeHex(r0, ((long) r6) & 4294967295L, 8, "");
        return r0.toString();
    }

    public static String toHex(long r3) {
        StringBuilder r0 = new StringBuilder(16);
        writeHex(r0, r3, 16, "");
        return r0.toString();
    }

    public static String toHex(short r4) {
        StringBuilder r0 = new StringBuilder(4);
        writeHex(r0, r4 & UShort.MAX_VALUE, 4, "");
        return r0.toString();
    }

    public static String toHex(byte[] r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append('[');
        if (r3 != null) goto L5;
    L12:
        r0.append(']');
        return r0.toString();
    L5:
        if (r3.length <= 0) goto L12;
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L12;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        r0.append(toHex(r3[r1]));
        r1 = r1 + 1;
        goto L8
    }

    private static void writeHex(StringBuilder r2, long r3, int r5, String r6) {
        r2.append(r6);
        char[] r7 = new char[r5];
        int r8 = r5 - 1;
    L3:
        if (r8 < 0) goto L9;
        int r0 = Math.toIntExact(15 & r3);
        if (r0 >= 10) goto L7;
        int r1 = r0 + 48;
    L8:
        r7[r8] = (char) r1;
        r3 = r3 >>> 4;
        r8 = r8 - 1;
        goto L3
    L7:
        r1 = (r0 + 65) - 10;
        goto L8
    L9:
        r2.append(r7);
    }
}
