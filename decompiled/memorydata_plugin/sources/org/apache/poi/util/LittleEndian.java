package org.apache.poi.util;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class LittleEndian {

    public static final class BufferUnderrunException extends IOException {
        private static final long serialVersionUID = 8736973884877006145L;

        BufferUnderrunException() {
            super("buffer underrun");
        }
    }

    public static int getInt(byte[] r1) {
        return getInt(r1, 0);
    }

    public static int getInt(byte[] r3, int r4) {
        int r0 = r4 + 1;
        int r5 = r3[r4] & 255;
        int r1 = r0 + 1;
        int r2 = r3[r0] & 255;
        int r6 = r1 + 1;
        int r7 = r3[r1] & 255;
        return ((((r3[r6] & 255) << 24) + (r7 << 16)) + (r2 << 8)) + r5;
    }

    public static long getLong(byte[] r2) {
        return getLong(r2, 0);
    }

    public static long getLong(byte[] r5, int r6) {
        long r0 = r5[r6 + 7] & 255;
        int r2 = (r6 + 8) - 1;
    L3:
        if (r2 < r6) goto L5;
        r0 = (r0 << 8) | ((long) (r5[r2] & 255));
        r2 = r2 - 1;
        goto L3
    L5:
        return r0;
    }

    public static short getShort(byte[] r1) {
        return getShort(r1, 0);
    }

    public static short getShort(byte[] r1, int r2) {
        int r0 = r1[r2] & 255;
        return (short) (((r1[r2 + 1] & 255) << 8) + r0);
    }

    public static short[] getShortArray(byte[] r3, int r4, int r5) {
        int r6 = r5 / 2;
        short[] r0 = new short[r6];
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r0[r1] = getShort(r3, (r1 * 2) + r4);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static short getUByte(byte[] r1) {
        return (short) (r1[0] & 255);
    }

    public static short getUByte(byte[] r0, int r1) {
        return (short) (r0[r1] & 255);
    }

    public static long getUInt(byte[] r2, int r3) {
        return ((long) getInt(r2, r3)) & 4294967295L;
    }

    public static int getUShort(byte[] r1) {
        return getUShort(r1, 0);
    }

    public static int getUShort(byte[] r1, int r2) {
        int r0 = r1[r2] & 255;
        return ((r1[r2 + 1] & 255) << 8) + r0;
    }

    public static void putByte(byte[] r0, int r1, int r2) {
        r0[r1] = (byte) r2;
    }

    public static void putInt(int r1, OutputStream r2) {
        r2.write((byte) (r1 & 255));
        r2.write((byte) ((r1 >>> 8) & 255));
        r2.write((byte) ((r1 >>> 16) & 255));
        r2.write((byte) ((r1 >>> 24) & 255));
    }

    public static void putInt(byte[] r2, int r3, int r4) {
        int r0 = r3 + 1;
        r2[r3] = (byte) (r4 & 255);
        int r5 = r0 + 1;
        r2[r0] = (byte) ((r4 >>> 8) & 255);
        r2[r5] = (byte) ((r4 >>> 16) & 255);
        r2[r5 + 1] = (byte) ((r4 >>> 24) & 255);
    }

    public static void putLong(byte[] r5, int r6, long r7) {
        r5[r6] = (byte) (r7 & 255);
        r5[r6 + 1] = (byte) ((r7 >>> 8) & 255);
        r5[r6 + 2] = (byte) ((r7 >>> 16) & 255);
        r5[r6 + 3] = (byte) ((r7 >>> 24) & 255);
        r5[r6 + 4] = (byte) ((r7 >>> 32) & 255);
        r5[r6 + 5] = (byte) ((r7 >>> 40) & 255);
        r5[r6 + 6] = (byte) ((r7 >>> 48) & 255);
        r5[r6 + 7] = (byte) ((r7 >>> 56) & 255);
    }

    public static void putShort(byte[] r2, int r3, short r4) {
        r2[r3] = (byte) (r4 & 255);
        r2[r3 + 1] = (byte) ((r4 >>> 8) & 255);
    }

    public static void putUByte(byte[] r0, int r1, short r2) {
        r0[r1] = (byte) (r2 & 255);
    }

    public static void putUInt(long r4, OutputStream r6) {
        r6.write((byte) (r4 & 255));
        r6.write((byte) ((r4 >>> 8) & 255));
        r6.write((byte) ((r4 >>> 16) & 255));
        r6.write((byte) ((r4 >>> 24) & 255));
    }

    public static void putUInt(byte[] r5, int r6, long r7) {
        int r0 = r6 + 1;
        r5[r6] = (byte) (r7 & 255);
        int r8 = r0 + 1;
        r5[r0] = (byte) ((r7 >>> 8) & 255);
        r5[r8] = (byte) ((r7 >>> 16) & 255);
        r5[r8 + 1] = (byte) ((r7 >>> 24) & 255);
    }

    public static void putUShort(int r1, OutputStream r2) {
        r2.write((byte) (r1 & 255));
        r2.write((byte) ((r1 >>> 8) & 255));
    }

    public static void putUShort(byte[] r2, int r3, int r4) {
        r2[r3] = (byte) (r4 & 255);
        r2[r3 + 1] = (byte) ((r4 >>> 8) & 255);
    }
}
