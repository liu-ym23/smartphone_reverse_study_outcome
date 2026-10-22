package org.bouncycastle.math.ec.custom.sec;

import androidx.core.app.FrameMetricsAggregator;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat512;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP521R1Field {
    static final int[] P = null;

    static {
        P = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, FrameMetricsAggregator.EVERY_DURATION};
    }

    public static void add(int[] r2, int[] r3, int[] r4) {
        int r1 = (Nat.add(16, r2, r3, r4) + r2[16]) + r3[16];
        if (r1 > 511) goto L7;
        if (r1 == 511) goto L6;
    L8:
        r4[16] = r1;
        return;
    L6:
        if (Nat.eq(16, r4, P) == false) goto L8;
    L7:
        r1 = (r1 + Nat.inc(16, r4)) & FrameMetricsAggregator.EVERY_DURATION;
        goto L8
    }

    public static void addOne(int[] r3, int[] r4) {
        int r1 = Nat.inc(16, r3, r4) + r3[16];
        if (r1 > 511) goto L7;
        if (r1 == 511) goto L6;
    L8:
        r4[16] = r1;
        return;
    L6:
        if (Nat.eq(16, r4, P) == false) goto L8;
    L7:
        r1 = (r1 + Nat.inc(16, r4)) & FrameMetricsAggregator.EVERY_DURATION;
        goto L8
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat.fromBigInteger(521, r2);
        if (Nat.eq(17, r3, P) == false) goto L5;
        Nat.zero(17, r3);
    L5:
        return r3;
    }

    public static void implMultiply(int[] r9, int[] r10, int[] r11) {
        Nat512.mul(r9, r10, r11);
        int r8 = r9[16];
        int r0 = r10[16];
        r11[32] = Nat.mul31BothAdd(16, r8, r10, r0, r9, r11, 16) + (r8 * r0);
    }

    public static void implSquare(int[] r7, int[] r8) {
        Nat512.square(r7, r8);
        int r0 = r7[16];
        r8[32] = Nat.mulWordAddTo(16, r0 << 1, r7, 0, r8, 16) + (r0 * r0);
    }

    public static void inv(int[] r1, int[] r2) {
        Mod.checkedModOddInverse(P, r1, r2);
    }

    public static int isZero(int[] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 17) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r1, int[] r2, int[] r3) {
        int[] r0 = Nat.create(33);
        implMultiply(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiply(int[] r0, int[] r1, int[] r2, int[] r3) {
        implMultiply(r0, r1, r3);
        reduce(r3, r2);
    }

    public static void negate(int[] r2, int[] r3) {
        if (isZero(r2) == 0) goto L5;
        int[] r4 = P;
        Nat.sub(17, r4, r4, r3);
        return;
    L5:
        Nat.sub(17, P, r2, r3);
    }

    public static void random(SecureRandom r4, int[] r5) {
        byte[] r0 = new byte[68];
    L3:
        r4.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r5, 0, 17);
        r5[16] = r5[16] & FrameMetricsAggregator.EVERY_DURATION;
        if (Nat.lessThan(17, r5, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r8, int[] r9) {
        int r0 = r8[32];
        int r1 = ((Nat.shiftDownBits(16, r8, 16, 9, r0, r9, 0) >>> 23) + (r0 >>> 9)) + Nat.addTo(16, r8, r9);
        if (r1 > 511) goto L7;
        if (r1 == 511) goto L6;
    L8:
        r9[16] = r1;
        return;
    L6:
        if (Nat.eq(16, r9, P) == false) goto L8;
    L7:
        r1 = (r1 + Nat.inc(16, r9)) & FrameMetricsAggregator.EVERY_DURATION;
        goto L8
    }

    public static void reduce23(int[] r4) {
        int r1 = r4[16];
        int r2 = Nat.addWordTo(16, r1 >>> 9, r4) + (r1 & FrameMetricsAggregator.EVERY_DURATION);
        if (r2 > 511) goto L7;
        if (r2 == 511) goto L6;
    L8:
        r4[16] = r2;
        return;
    L6:
        if (Nat.eq(16, r4, P) == false) goto L8;
    L7:
        r2 = (r2 + Nat.inc(16, r4)) & FrameMetricsAggregator.EVERY_DURATION;
        goto L8
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat.create(33);
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void square(int[] r0, int[] r1, int[] r2) {
        implSquare(r0, r2);
        reduce(r2, r1);
    }

    public static void squareN(int[] r0, int r1, int[] r2, int[] r3) {
        implSquare(r0, r3);
    L3:
        reduce(r3, r2);
        r1 = r1 - 1;
        if (r1 <= 0) goto L6;
        implSquare(r2, r3);
        goto L3
    }

    public static void subtract(int[] r2, int[] r3, int[] r4) {
        int r1 = (Nat.sub(16, r2, r3, r4) + r2[16]) - r3[16];
        if (r1 >= 0) goto L5;
        r1 = (r1 + Nat.dec(16, r4)) & FrameMetricsAggregator.EVERY_DURATION;
    L5:
        r4[16] = r1;
    }

    public static void twice(int[] r3, int[] r4) {
        int r1 = r3[16];
        r4[16] = (Nat.shiftUpBit(16, r3, r1 << 23, r4) | (r1 << 1)) & FrameMetricsAggregator.EVERY_DURATION;
    }
}
