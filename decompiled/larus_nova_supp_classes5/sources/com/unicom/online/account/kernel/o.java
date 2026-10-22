package com.unicom.online.account.kernel;

import java.io.ByteArrayOutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class o {
    private static char[] a;
    private static byte[] b;

    static {
        a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static String a(String r2) {
        return r2.replaceAll("\\+", "%2B");
    }

    public static String a(byte[] r8) {
        StringBuffer r0 = new StringBuffer();
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        int r3 = r2 + 1;
        int r4 = r8[r2] & UByte.MAX_VALUE;
        if (r3 == r1) goto L6;
        int r5 = r3 + 1;
        int r6 = r8[r3] & UByte.MAX_VALUE;
        if (r5 == r1) goto L10;
        int r7 = r5 + 1;
        int r9 = r8[r5] & UByte.MAX_VALUE;
        r0.append(a[r4 >>> 2]);
        r0.append(a[((r4 & 3) << 4) | ((r6 & 240) >>> 4)]);
        r0.append(a[((r6 & 15) << 2) | ((r9 & 192) >>> 6)]);
        r0.append(a[r9 & 63]);
        r2 = r7;
        goto L3
    L10:
        r0.append(a[r4 >>> 2]);
        r0.append(a[((r4 & 3) << 4) | ((r6 & 240) >>> 4)]);
        r0.append(a[(r6 & 15) << 2]);
        String r10 = "=";
    L7:
        r0.append(r10);
        goto L13
    L6:
        r0.append(a[r4 >>> 2]);
        r0.append(a[(r4 & 3) << 4]);
        r10 = "==";
    L13:
        return r0.toString();
    }

    public static byte[] b(String r8) {
        byte[] r9 = r8.getBytes();
        int r0 = r9.length;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L40;
    L4:
        int r4 = r2 + 1;
        byte r3 = b[r9[r2]];
        if (r4 >= r0) goto L9;
        if (r3 != (-1)) goto L9;
        r2 = r4;
    L9:
        if (r3 == (-1)) goto L40;
    L10:
        int r6 = r4 + 1;
        byte r5 = b[r9[r4]];
        if (r6 >= r0) goto L15;
        if (r5 != (-1)) goto L15;
        r4 = r6;
    L15:
        if (r5 == (-1)) goto L40;
        r1.write((r3 << 2) | ((r5 & 48) >>> 4));
    L17:
        int r7 = r6 + 1;
        byte r10 = r9[r6];
        if (r10 == 61) goto L20;
        byte r11 = b[r10];
        if (r7 >= r0) goto L26;
        if (r11 != (-1)) goto L26;
        r6 = r7;
    L26:
        if (r11 == (-1)) goto L40;
        r1.write(((r5 & 15) << 4) | ((r11 & 60) >>> 2));
    L28:
        int r12 = r7 + 1;
        byte r13 = r9[r7];
        if (r13 == 61) goto L31;
        byte r14 = b[r13];
        if (r12 >= r0) goto L37;
        if (r14 != (-1)) goto L37;
        r7 = r12;
    L37:
        if (r14 == (-1)) goto L40;
        r1.write(r14 | ((r11 & 3) << 6));
        r2 = r12;
        goto L3
    L31:
        return r1.toByteArray();
    L20:
        return r1.toByteArray();
    L40:
        return r1.toByteArray();
    }
}
