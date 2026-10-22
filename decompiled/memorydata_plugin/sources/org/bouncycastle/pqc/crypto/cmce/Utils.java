package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    static short bitrev(short r2, int r3) {
        int r0 = (r2 & 255) << 8;
        short r4 = (short) (((r2 & 65280) >> 8) | r0);
        int r1 = (r4 & 3855) << 4;
        short r5 = (short) (((r4 & 61680) >> 4) | r1);
        int r6 = (r5 & 13107) << 2;
        short r7 = (short) (((r5 & 52428) >> 2) | r6);
        int r8 = (r7 & 21845) << 1;
        short r9 = (short) (((r7 & 43690) >> 1) | r8);
        if (r3 != 12) goto L7;
        int r10 = r9 >> 4;
    L6:
        return (short) r10;
    L7:
        r10 = r9 >> 3;
        goto L6
    }

    static int load4(byte[] r0, int r1) {
        return Pack.littleEndianToInt(r0, r1);
    }

    static long load8(byte[] r0, int r1) {
        return Pack.littleEndianToLong(r0, r1);
    }

    static short load_gf(byte[] r0, int r1, int r2) {
        return (short) (Pack.littleEndianToShort(r0, r1) & r2);
    }

    static void store8(byte[] r5, int r6, long r7) {
        r5[r6 + 0] = (byte) ((r7 >> 0) & 255);
        r5[r6 + 1] = (byte) ((r7 >> 8) & 255);
        r5[r6 + 2] = (byte) ((r7 >> 16) & 255);
        r5[r6 + 3] = (byte) ((r7 >> 24) & 255);
        r5[r6 + 4] = (byte) ((r7 >> 32) & 255);
        r5[r6 + 5] = (byte) ((r7 >> 40) & 255);
        r5[r6 + 6] = (byte) ((r7 >> 48) & 255);
        r5[r6 + 7] = (byte) ((r7 >> 56) & 255);
    }
}
