package org.bouncycastle.util;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Pack {
    public static int bigEndianToInt(byte[] r2, int r3) {
        int r0 = r2[r3] << 24;
        int r4 = r3 + 1;
        int r1 = r0 | ((r2[r4] & 255) << 16);
        int r5 = r4 + 1;
        int r6 = r1 | ((r2[r5] & 255) << 8);
        return (r2[r5 + 1] & 255) | r6;
    }

    public static long bigEndianToLong(byte[] r4, int r5) {
        int r0 = bigEndianToInt(r4, r5);
        long r6 = ((long) bigEndianToInt(r4, r5 + 4)) & 4294967295L;
        return r6 | ((((long) r0) & 4294967295L) << 32);
    }

    public static void intToBigEndian(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) (r1 >>> 24);
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >>> 16);
        int r5 = r4 + 1;
        r2[r5] = (byte) (r1 >>> 8);
        r2[r5 + 1] = (byte) r1;
    }

    public static void intToBigEndian(int[] r2, byte[] r3, int r4) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L6;
        intToBigEndian(r2[r0], r3, r4);
        r4 = r4 + 4;
        r0 = r0 + 1;
        goto L4
    }

    public static byte[] intToBigEndian(int r2) {
        byte[] r0 = new byte[4];
        intToBigEndian(r2, r0, 0);
        return r0;
    }

    public static void intToLittleEndian(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) r1;
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >>> 8);
        int r5 = r4 + 1;
        r2[r5] = (byte) (r1 >>> 16);
        r2[r5 + 1] = (byte) (r1 >>> 24);
    }

    public static void intToLittleEndian(int[] r2, byte[] r3, int r4) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L6;
        intToLittleEndian(r2[r0], r3, r4);
        r4 = r4 + 4;
        r0 = r0 + 1;
        goto L4
    }

    public static int littleEndianToInt(byte[] r2, int r3) {
        int r0 = r2[r3] & 255;
        int r4 = r3 + 1;
        int r1 = r0 | ((r2[r4] & 255) << 8);
        int r5 = r4 + 1;
        int r6 = r1 | ((r2[r5] & 255) << 16);
        return (r2[r5 + 1] << 24) | r6;
    }

    public static void littleEndianToInt(byte[] r2, int r3, int[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r4[r0] = littleEndianToInt(r2, r3);
        r3 = r3 + 4;
        r0 = r0 + 1;
        goto L4
    }

    public static void littleEndianToInt(byte[] r3, int r4, int[] r5, int r6, int r7) {
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r5[r6 + r0] = littleEndianToInt(r3, r4);
        r4 = r4 + 4;
        r0 = r0 + 1;
        goto L3
    }

    public static int[] littleEndianToInt(byte[] r3, int r4, int r5) {
        int[] r0 = new int[r5];
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r0[r1] = littleEndianToInt(r3, r4);
        r4 = r4 + 4;
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static long littleEndianToLong(byte[] r5, int r6) {
        int r0 = littleEndianToInt(r5, r6);
        return ((((long) littleEndianToInt(r5, r6 + 4)) & 4294967295L) << 32) | (((long) r0) & 4294967295L);
    }

    public static short littleEndianToShort(byte[] r1, int r2) {
        int r0 = r1[r2] & 255;
        return (short) (((r1[r2 + 1] & 255) << 8) | r0);
    }

    public static void longToBigEndian(long r2, byte[] r4, int r5) {
        intToBigEndian((int) (r2 >>> 32), r4, r5);
        intToBigEndian((int) (r2 & 4294967295L), r4, r5 + 4);
    }

    public static byte[] longToBigEndian(long r2) {
        byte[] r0 = new byte[8];
        longToBigEndian(r2, r0, 0);
        return r0;
    }

    public static void longToLittleEndian(long r2, byte[] r4, int r5) {
        intToLittleEndian((int) (4294967295L & r2), r4, r5);
        intToLittleEndian((int) (r2 >>> 32), r4, r5 + 4);
    }

    public static void longToLittleEndian(long[] r3, int r4, int r5, byte[] r6, int r7) {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        longToLittleEndian(r3[r4 + r0], r6, r7);
        r7 = r7 + 8;
        r0 = r0 + 1;
        goto L3
    }

    public static byte[] longToLittleEndian(long r2) {
        byte[] r0 = new byte[8];
        longToLittleEndian(r2, r0, 0);
        return r0;
    }

    public static void shortToBigEndian(short r1, byte[] r2, int r3) {
        r2[r3] = (byte) (r1 >>> 8);
        r2[r3 + 1] = (byte) r1;
    }

    public static void shortToLittleEndian(short r1, byte[] r2, int r3) {
        r2[r3] = (byte) r1;
        r2[r3 + 1] = (byte) (r1 >>> 8);
    }
}
