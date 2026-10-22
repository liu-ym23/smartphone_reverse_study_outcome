package org.bouncycastle.math.ec.custom.sec;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

/* JADX INFO: loaded from: classes7.dex */
public class SecT571Field {
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};
    }

    private static void add(long[] r6, int r7, long[] r8, int r9, long[] r10, int r11) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        r10[r11 + r0] = r6[r7 + r0] ^ r8[r9 + r0];
        r0 = r0 + 1;
        goto L4
    }

    public static void add(long[] r5, long[] r6, long[] r7) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        r7[r0] = r5[r0] ^ r6[r0];
        r0 = r0 + 1;
        goto L4
    }

    private static void addBothTo(long[] r8, int r9, long[] r10, int r11, long[] r12, int r13) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        int r1 = r13 + r0;
        r12[r1] = r12[r1] ^ (r8[r9 + r0] ^ r10[r11 + r0]);
        r0 = r0 + 1;
        goto L4
    }

    public static void addBothTo(long[] r7, long[] r8, long[] r9) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        r9[r0] = r9[r0] ^ (r7[r0] ^ r8[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public static void addExt(long[] r5, long[] r6, long[] r7) {
        int r0 = 0;
    L4:
        if (r0 >= 18) goto L6;
        r7[r0] = r5[r0] ^ r6[r0];
        r0 = r0 + 1;
        goto L4
    }

    public static void addOne(long[] r5, long[] r6) {
        r6[0] = r5[0] ^ 1;
        int r0 = 1;
    L4:
        if (r0 >= 9) goto L6;
        r6[r0] = r5[r0];
        r0 = r0 + 1;
        goto L4
    }

    private static void addTo(long[] r5, long[] r6) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        r6[r0] = r6[r0] ^ r5[r0];
        r0 = r0 + 1;
        goto L4
    }

    public static long[] fromBigInteger(BigInteger r1) {
        return Nat.fromBigInteger64(571, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat576.createExt64();
        Nat576.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 571) goto L6;
        implSquare(r4, r0);
        reduce(r0, r4);
        implSquare(r4, r0);
        reduce(r0, r4);
        addTo(r3, r4);
        r1 = r1 + 2;
        goto L4
    }

    public static void implMultiply(long[] r25, long[] r26, long[] r27) {
        long[] r8 = new long[16];
        int r10 = 0;
    L4:
        if (r10 >= 9) goto L6;
        implMulwAcc(r8, r25[r10], r26[r10], r27, r10 << 1);
        r10 = r10 + 1;
        goto L4
    L6:
        long r1 = r27[0];
        long r3 = r27[1];
        long r2 = r1 ^ r27[2];
        r27[1] = r2 ^ r3;
        long r4 = r3 ^ r27[3];
        long r5 = r2 ^ r27[4];
        r27[2] = r5 ^ r4;
        long r6 = r4 ^ r27[5];
        long r7 = r5 ^ r27[6];
        r27[3] = r7 ^ r6;
        long r9 = r6 ^ r27[7];
        long r11 = r7 ^ r27[8];
        r27[4] = r11 ^ r9;
        long r12 = r9 ^ r27[9];
        long r13 = r11 ^ r27[10];
        r27[5] = r13 ^ r12;
        long r14 = r12 ^ r27[11];
        long r15 = r13 ^ r27[12];
        r27[6] = r15 ^ r14;
        long r16 = r14 ^ r27[13];
        long r17 = r15 ^ r27[14];
        r27[7] = r17 ^ r16;
        long r18 = r16 ^ r27[15];
        long r19 = r17 ^ r27[16];
        r27[8] = r19 ^ r18;
        long r20 = r19 ^ (r18 ^ r27[17]);
        r27[9] = r27[0] ^ r20;
        r27[10] = r27[1] ^ r20;
        r27[11] = r27[2] ^ r20;
        r27[12] = r27[3] ^ r20;
        r27[13] = r27[4] ^ r20;
        r27[14] = r27[5] ^ r20;
        r27[15] = r27[6] ^ r20;
        r27[16] = r27[7] ^ r20;
        r27[17] = r27[8] ^ r20;
        implMulwAcc(r8, r25[0] ^ r25[1], r26[0] ^ r26[1], r27, 1);
        implMulwAcc(r8, r25[0] ^ r25[2], r26[0] ^ r26[2], r27, 2);
        implMulwAcc(r8, r25[0] ^ r25[3], r26[0] ^ r26[3], r27, 3);
        implMulwAcc(r8, r25[1] ^ r25[2], r26[1] ^ r26[2], r27, 3);
        implMulwAcc(r8, r25[0] ^ r25[4], r26[0] ^ r26[4], r27, 4);
        implMulwAcc(r8, r25[1] ^ r25[3], r26[1] ^ r26[3], r27, 4);
        implMulwAcc(r8, r25[0] ^ r25[5], r26[0] ^ r26[5], r27, 5);
        implMulwAcc(r8, r25[1] ^ r25[4], r26[1] ^ r26[4], r27, 5);
        implMulwAcc(r8, r25[2] ^ r25[3], r26[2] ^ r26[3], r27, 5);
        implMulwAcc(r8, r25[0] ^ r25[6], r26[0] ^ r26[6], r27, 6);
        implMulwAcc(r8, r25[1] ^ r25[5], r26[1] ^ r26[5], r27, 6);
        implMulwAcc(r8, r25[2] ^ r25[4], r26[2] ^ r26[4], r27, 6);
        implMulwAcc(r8, r25[0] ^ r25[7], r26[0] ^ r26[7], r27, 7);
        implMulwAcc(r8, r25[1] ^ r25[6], r26[1] ^ r26[6], r27, 7);
        implMulwAcc(r8, r25[2] ^ r25[5], r26[2] ^ r26[5], r27, 7);
        implMulwAcc(r8, r25[3] ^ r25[4], r26[3] ^ r26[4], r27, 7);
        implMulwAcc(r8, r25[0] ^ r25[8], r26[0] ^ r26[8], r27, 8);
        implMulwAcc(r8, r25[1] ^ r25[7], r26[1] ^ r26[7], r27, 8);
        implMulwAcc(r8, r25[2] ^ r25[6], r26[2] ^ r26[6], r27, 8);
        implMulwAcc(r8, r25[3] ^ r25[5], r26[3] ^ r26[5], r27, 8);
        implMulwAcc(r8, r25[1] ^ r25[8], r26[1] ^ r26[8], r27, 9);
        implMulwAcc(r8, r25[2] ^ r25[7], r26[2] ^ r26[7], r27, 9);
        implMulwAcc(r8, r25[3] ^ r25[6], r26[3] ^ r26[6], r27, 9);
        implMulwAcc(r8, r25[4] ^ r25[5], r26[4] ^ r26[5], r27, 9);
        implMulwAcc(r8, r25[2] ^ r25[8], r26[2] ^ r26[8], r27, 10);
        implMulwAcc(r8, r25[3] ^ r25[7], r26[3] ^ r26[7], r27, 10);
        implMulwAcc(r8, r25[4] ^ r25[6], r26[4] ^ r26[6], r27, 10);
        implMulwAcc(r8, r25[3] ^ r25[8], r26[3] ^ r26[8], r27, 11);
        implMulwAcc(r8, r25[4] ^ r25[7], r26[4] ^ r26[7], r27, 11);
        implMulwAcc(r8, r25[5] ^ r25[6], r26[5] ^ r26[6], r27, 11);
        implMulwAcc(r8, r25[4] ^ r25[8], r26[4] ^ r26[8], r27, 12);
        implMulwAcc(r8, r25[5] ^ r25[7], r26[5] ^ r26[7], r27, 12);
        implMulwAcc(r8, r25[5] ^ r25[8], r26[5] ^ r26[8], r27, 13);
        implMulwAcc(r8, r25[6] ^ r25[7], r26[6] ^ r26[7], r27, 13);
        implMulwAcc(r8, r25[6] ^ r25[8], r26[6] ^ r26[8], r27, 14);
        implMulwAcc(r8, r25[7] ^ r25[8], r26[7] ^ r26[8], r27, 15);
    }

    public static void implMultiplyPrecomp(long[] r12, long[] r13, long[] r14) {
        int r0 = 56;
        int r1 = 56;
    L4:
        if (r1 < 0) goto L9;
        int r3 = 1;
    L6:
        if (r3 >= 9) goto L8;
        int r4 = (int) (r12[r3] >>> r1);
        addBothTo(r13, (r4 & 15) * 9, r13, (((r4 >>> 4) & 15) + 16) * 9, r14, r3 - 1);
        r3 = r3 + 2;
        goto L6
    L8:
        Nat.shiftUpBits64(16, r14, 0, 8, 0);
        r1 = r1 - 8;
    L9:
        if (r0 < 0) goto L16;
        int r2 = 0;
    L11:
        if (r2 >= 9) goto L13;
        int r5 = (int) (r12[r2] >>> r0);
        addBothTo(r13, (r5 & 15) * 9, r13, (((r5 >>> 4) & 15) + 16) * 9, r14, r2);
        r2 = r2 + 2;
        goto L11
    L13:
        if (r0 <= 0) goto L15;
        Nat.shiftUpBits64(18, r14, 0, 8, 0);
    L15:
        r0 = r0 - 8;
        goto L9
    }

    public static void implMulwAcc(long[] r14, long r15, long r17, long[] r19, int r20) {
        long r0 = r15;
        r14[1] = r17;
        int r3 = 2;
    L4:
        if (r3 >= 16) goto L6;
        r14[r3] = r14[r3 >>> 1] << 1;
        r14[r3 + 1] = r14[r3] ^ r17;
        r3 = r3 + 2;
        goto L4
    L6:
        int r4 = (int) r0;
        long r5 = 0;
        long r6 = r14[r4 & 15] ^ (r14[(r4 >>> 4) & 15] << 4);
        int r7 = 56;
    L7:
        int r9 = (int) (r0 >>> r7);
        long r10 = r14[r9 & 15] ^ (r14[(r9 >>> 4) & 15] << 4);
        r6 = r6 ^ (r10 << r7);
        r5 = r5 ^ (r10 >>> (-r7));
        r7 = r7 - 8;
        if (r7 > 0) goto L7;
        int r8 = 0;
    L11:
        if (r8 >= 7) goto L13;
        r0 = (r0 & (-72340172838076674L)) >>> 1;
        r5 = r5 ^ (((r17 << r8) >> 63) & r0);
        r8 = r8 + 1;
        goto L11
    L13:
        r19[r20] = r19[r20] ^ r6;
        int r1 = r20 + 1;
        r19[r1] = r19[r1] ^ r5;
    }

    public static void implSquare(long[] r2, long[] r3) {
        Interleave.expand64To128(r2, 0, 9, r3, 0);
    }

    public static void invert(long[] r3, long[] r4) {
        if (Nat576.isZero64(r3) == true) goto L7;
        long[] r0 = Nat576.create64();
        long[] r1 = Nat576.create64();
        long[] r2 = Nat576.create64();
        square(r3, r2);
        square(r2, r0);
        square(r0, r1);
        multiply(r0, r1, r0);
        squareN(r0, 2, r1);
        multiply(r0, r1, r0);
        multiply(r0, r2, r0);
        squareN(r0, 5, r1);
        multiply(r0, r1, r0);
        squareN(r1, 5, r1);
        multiply(r0, r1, r0);
        squareN(r0, 15, r1);
        multiply(r0, r1, r2);
        squareN(r2, 30, r0);
        squareN(r0, 30, r1);
        multiply(r0, r1, r0);
        squareN(r0, 60, r1);
        multiply(r0, r1, r0);
        squareN(r1, 60, r1);
        multiply(r0, r1, r0);
        squareN(r0, SubsamplingScaleImageView.ORIENTATION_180, r1);
        multiply(r0, r1, r0);
        squareN(r1, SubsamplingScaleImageView.ORIENTATION_180, r1);
        multiply(r0, r1, r0);
        multiply(r0, r2, r4);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat576.createExt64();
        implMultiply(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat576.createExt64();
        implMultiply(r1, r2, r0);
        addExt(r3, r0, r3);
    }

    public static void multiplyPrecomp(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat576.createExt64();
        implMultiplyPrecomp(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyPrecompAddToExt(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat576.createExt64();
        implMultiplyPrecomp(r1, r2, r0);
        addExt(r3, r0, r3);
    }

    public static long[] precompMultiplicand(long[] r9) {
        long[] r0 = new long[288];
        int r1 = 0;
        System.arraycopy(r9, 0, r0, 9, 9);
        int r10 = 7;
    L3:
        if (r10 <= 0) goto L5;
        int r8 = r1 + 18;
        Nat.shiftUpBit64(9, r0, r8 >>> 1, 0, r0, r8);
        reduce5(r0, r8);
        add(r0, 9, r0, r8, r0, r8 + 9);
        r10 = r10 - 1;
        r1 = r8;
        goto L3
    L5:
        Nat.shiftUpBits64(144, r0, 0, 4, 0, r0, 144);
        return r0;
    }

    public static void reduce(long[] r19, long[] r20) {
        long r0 = r19[9];
        long r2 = r19[17];
        long r1 = (((r0 ^ (r2 >>> 59)) ^ (r2 >>> 57)) ^ (r2 >>> 54)) ^ (r2 >>> 49);
        long r3 = (r2 << 15) ^ (((r19[8] ^ (r2 << 5)) ^ (r2 << 7)) ^ (r2 << 10));
        int r9 = 16;
    L3:
        if (r9 < 10) goto L5;
        long r15 = r19[r9];
        r20[r9 - 8] = (((r3 ^ (r15 >>> 59)) ^ (r15 >>> 57)) ^ (r15 >>> 54)) ^ (r15 >>> 49);
        r3 = (((r19[r9 - 9] ^ (r15 << 5)) ^ (r15 << 7)) ^ (r15 << 10)) ^ (r15 << 15);
        r9 = r9 - 1;
        goto L3
    L5:
        r20[1] = (((r3 ^ (r1 >>> 59)) ^ (r1 >>> 57)) ^ (r1 >>> 54)) ^ (r1 >>> 49);
        long r4 = (r1 << 15) ^ (((r19[0] ^ (r1 << 5)) ^ (r1 << 7)) ^ (r1 << 10));
        long r5 = r20[8];
        long r6 = r5 >>> 59;
        r20[0] = (((r4 ^ r6) ^ (r6 << 2)) ^ (r6 << 5)) ^ (r6 << 10);
        r20[8] = 576460752303423487L & r5;
    }

    public static void reduce5(long[] r11, int r12) {
        int r0 = r12 + 8;
        long r1 = r11[r0];
        long r3 = r1 >>> 59;
        long r7 = ((r3 << 2) ^ r3) ^ (r3 << 5);
        long r4 = (r3 << 10) ^ r7;
        r11[r12] = r4 ^ r11[r12];
        r11[r0] = r1 & 576460752303423487L;
    }

    public static void sqrt(long[] r14, long[] r15) {
        long[] r0 = Nat576.create64();
        long[] r1 = Nat576.create64();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= 4) goto L6;
        int r7 = r3 + 1;
        long r8 = Interleave.unshuffle(r14[r3]);
        r3 = r7 + 1;
        long r10 = Interleave.unshuffle(r14[r7]);
        r0[r2] = (4294967295L & r8) | (r10 << 32);
        r1[r2] = (r8 >>> 32) | ((-4294967296L) & r10);
        r2 = r2 + 1;
        goto L4
    L6:
        long r4 = Interleave.unshuffle(r14[r3]);
        r0[4] = 4294967295L & r4;
        r1[4] = r4 >>> 32;
        multiply(r1, ROOT_Z, r15);
        add(r15, r0, r15);
    }

    public static void square(long[] r1, long[] r2) {
        long[] r0 = Nat576.createExt64();
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat576.createExt64();
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat576.createExt64();
        implSquare(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        implSquare(r3, r0);
        goto L3
    }

    public static int trace(long[] r6) {
        return ((int) ((r6[0] ^ (r6[8] >>> 49)) ^ (r6[8] >>> 57))) & 1;
    }
}
