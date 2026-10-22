package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Bits {
    public static int bitPermuteStep(int r1, int r2, int r3) {
        int r4 = r2 & ((r1 >>> r3) ^ r1);
        return r1 ^ (r4 ^ (r4 << r3));
    }

    public static long bitPermuteStep(long r2, long r4, int r6) {
        long r5 = r4 & ((r2 >>> r6) ^ r2);
        return r2 ^ (r5 ^ (r5 << r6));
    }
}
