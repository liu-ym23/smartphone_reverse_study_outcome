package org.bouncycastle.math.raw;

import androidx.core.view.MotionEventCompat;

/* JADX INFO: loaded from: classes7.dex */
public class Interleave {
    public static long expand32to64(int r6) {
        int r7 = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r6, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 8), 15728880, 4), 202116108, 2), 572662306, 1);
        return ((((long) (r7 >>> 1)) & 1431655765) << 32) | (1431655765 & ((long) r7));
    }

    public static void expand64To128(long r5, long[] r7, int r8) {
        long r6 = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r5, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        r7[r8] = r6 & 6148914691236517205L;
        r7[r8 + 1] = (r6 >>> 1) & 6148914691236517205L;
    }

    public static void expand64To128(long[] r3, int r4, int r5, long[] r6, int r7) {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        expand64To128(r3[r4 + r0], r6, r7);
        r7 = r7 + 2;
        r0 = r0 + 1;
        goto L3
    }

    public static int expand8to16(int r1) {
        int r2 = r1 & 255;
        int r3 = (r2 | (r2 << 4)) & 3855;
        int r4 = (r3 | (r3 << 2)) & 13107;
        return (r4 | (r4 << 1)) & 21845;
    }

    public static int shuffle2(int r2) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r2, 11141290, 7), 52428, 14), 15728880, 4), MotionEventCompat.ACTION_POINTER_INDEX_MASK, 8);
    }

    public static long unshuffle(long r3) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r3, 2459565876494606882L, 1), 868082074056920076L, 2), 67555025218437360L, 4), 280375465148160L, 8), 4294901760L, 16);
    }
}
