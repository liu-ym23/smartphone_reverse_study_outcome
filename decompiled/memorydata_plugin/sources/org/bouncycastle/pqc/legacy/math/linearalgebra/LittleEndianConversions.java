package org.bouncycastle.pqc.legacy.math.linearalgebra;

/* JADX INFO: loaded from: classes7.dex */
public final class LittleEndianConversions {
    public static void I2OSP(int r2, byte[] r3, int r4) {
        int r0 = r4 + 1;
        r3[r4] = (byte) r2;
        int r5 = r0 + 1;
        r3[r0] = (byte) (r2 >>> 8);
        r3[r5] = (byte) (r2 >>> 16);
        r3[r5 + 1] = (byte) (r2 >>> 24);
    }

    public static void I2OSP(int r2, byte[] r3, int r4, int r5) {
        int r6 = r5 - 1;
    L3:
        if (r6 < 0) goto L5;
        r3[r4 + r6] = (byte) (r2 >>> (r6 * 8));
        r6 = r6 - 1;
        goto L3
    }

    public static byte[] I2OSP(int r3) {
        return new byte[]{(byte) r3, (byte) (r3 >>> 8), (byte) (r3 >>> 16), (byte) (r3 >>> 24)};
    }

    public static int OS2IP(byte[] r2) {
        int r0 = ((r2[0] & 255) | ((r2[1] & 255) << 8)) | ((r2[2] & 255) << 16);
        return ((r2[3] & 255) << 24) | r0;
    }

    public static int OS2IP(byte[] r2, int r3) {
        int r0 = r3 + 1;
        int r1 = r0 + 1;
        int r4 = (r2[r3] & 255) | ((r2[r0] & 255) << 8);
        int r5 = r1 + 1;
        int r6 = r4 | ((r2[r1] & 255) << 16);
        return ((r2[r5] & 255) << 24) | r6;
    }

    public static int OS2IP(byte[] r3, int r4, int r5) {
        int r6 = r5 - 1;
        int r0 = 0;
    L3:
        if (r6 < 0) goto L5;
        r0 = r0 | ((r3[r4 + r6] & 255) << (r6 * 8));
        r6 = r6 - 1;
        goto L3
    L5:
        return r0;
    }
}
