package org.bouncycastle.math.ec.custom.sec;

import com.obric.aikernel.core.data.IdlErrors;
import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes7.dex */
public class SecT239Field {
    public static void add(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        long r1 = r5[3];
        r7[3] = r6[3] ^ r1;
    }

    public static void addExt(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        r7[3] = r5[3] ^ r6[3];
        r7[4] = r5[4] ^ r6[4];
        r7[5] = r5[5] ^ r6[5];
        r7[6] = r5[6] ^ r6[6];
        long r1 = r5[7];
        r7[7] = r6[7] ^ r1;
    }

    public static void addOne(long[] r5, long[] r6) {
        r6[0] = r5[0] ^ 1;
        r6[1] = r5[1];
        r6[2] = r5[2];
        r6[3] = r5[3];
    }

    private static void addTo(long[] r5, long[] r6) {
        r6[0] = r6[0] ^ r5[0];
        r6[1] = r6[1] ^ r5[1];
        r6[2] = r6[2] ^ r5[2];
        r6[3] = r6[3] ^ r5[3];
    }

    public static long[] fromBigInteger(BigInteger r1) {
        return Nat.fromBigInteger64(239, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat256.createExt64();
        Nat256.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 239) goto L6;
        implSquare(r4, r0);
        reduce(r0, r4);
        implSquare(r4, r0);
        reduce(r0, r4);
        addTo(r3, r4);
        r1 = r1 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r26) {
        long r1 = r26[0];
        long r4 = r26[1];
        long r7 = r26[2];
        long r10 = r26[3];
        long r13 = r26[4];
        long r16 = r26[5];
        long r19 = r26[6];
        long r22 = r26[7];
        r26[0] = r1 ^ (r4 << 60);
        r26[1] = (r4 >>> 4) ^ (r7 << 56);
        r26[2] = (r7 >>> 8) ^ (r10 << 52);
        r26[3] = (r10 >>> 12) ^ (r13 << 48);
        r26[4] = (r13 >>> 16) ^ (r16 << 44);
        r26[5] = (r16 >>> 20) ^ (r19 << 40);
        r26[6] = (r19 >>> 24) ^ (r22 << 36);
        r26[7] = r22 >>> 28;
    }

    public static void implExpand(long[] r16, long[] r17) {
        long r1 = r16[0];
        long r4 = r16[1];
        long r7 = r16[2];
        long r10 = r16[3];
        r17[0] = r1 & 1152921504606846975L;
        r17[1] = ((r1 >>> 60) ^ (r4 << 4)) & 1152921504606846975L;
        r17[2] = ((r4 >>> 56) ^ (r7 << 8)) & 1152921504606846975L;
        r17[3] = (r7 >>> 52) ^ (r10 << 12);
    }

    public static void implMultiply(long[] r24, long[] r25, long[] r26) {
        long[] r8 = new long[4];
        long[] r9 = new long[4];
        implExpand(r24, r8);
        implExpand(r25, r9);
        long[] r15 = new long[8];
        implMulwAcc(r15, r8[0], r9[0], r26, 0);
        implMulwAcc(r15, r8[1], r9[1], r26, 1);
        implMulwAcc(r15, r8[2], r9[2], r26, 2);
        implMulwAcc(r15, r8[3], r9[3], r26, 3);
        int r0 = 5;
    L3:
        if (r0 <= 0) goto L5;
        r26[r0] = r26[r0] ^ r26[r0 - 1];
        r0 = r0 - 1;
        goto L3
    L5:
        implMulwAcc(r15, r8[0] ^ r8[1], r9[0] ^ r9[1], r26, 1);
        implMulwAcc(r15, r8[2] ^ r8[3], r9[2] ^ r9[3], r26, 3);
        int r1 = 7;
    L6:
        if (r1 <= 1) goto L8;
        r26[r1] = r26[r1] ^ r26[r1 - 2];
        r1 = r1 - 1;
        goto L6
    L8:
        long r11 = r8[0] ^ r8[2];
        long r20 = r8[1] ^ r8[3];
        long r22 = r9[0] ^ r9[2];
        long r10 = r9[1] ^ r9[3];
        implMulwAcc(r15, r11 ^ r20, r22 ^ r10, r26, 3);
        long[] r2 = new long[3];
        implMulwAcc(r15, r11, r22, r2, 0);
        implMulwAcc(r15, r20, r10, r2, 1);
        long r3 = r2[0];
        long r5 = r2[1];
        long r12 = r2[2];
        r26[2] = r26[2] ^ r3;
        r26[3] = (r3 ^ r5) ^ r26[3];
        r26[4] = r26[4] ^ (r12 ^ r5);
        r26[5] = r26[5] ^ r12;
        implCompactExt(r26);
    }

    public static void implMulwAcc(long[] r17, long r18, long r20, long[] r22, int r23) {
        r17[1] = r20;
        r17[2] = r17[1] << 1;
        r17[3] = r17[2] ^ r20;
        r17[4] = r17[2] << 1;
        r17[5] = r17[4] ^ r20;
        r17[6] = r17[3] << 1;
        r17[7] = r17[6] ^ r20;
        int r3 = (int) r18;
        long r4 = (r17[(r3 >>> 3) & 7] << 3) ^ r17[r3 & 7];
        long r9 = 0;
        int r11 = 54;
    L3:
        int r12 = (int) (r18 >>> r11);
        long r13 = r17[r12 & 7] ^ (r17[(r12 >>> 3) & 7] << 3);
        r4 = r4 ^ (r13 << r11);
        r9 = r9 ^ (r13 >>> (-r11));
        r11 = r11 - 6;
        if (r11 > 0) goto L3;
        r22[r23] = r22[r23] ^ (1152921504606846975L & r4);
        int r2 = r23 + 1;
        r22[r2] = ((((((r18 & 585610922974906400L) & ((r20 << 4) >> 63)) >>> 5) ^ r9) << 4) ^ (r4 >>> 60)) ^ r22[r2];
    }

    public static void implSquare(long[] r2, long[] r3) {
        Interleave.expand64To128(r2, 0, 4, r3, 0);
    }

    public static void invert(long[] r3, long[] r4) {
        if (Nat256.isZero64(r3) == true) goto L7;
        long[] r0 = Nat256.create64();
        long[] r1 = Nat256.create64();
        square(r3, r0);
        multiply(r0, r3, r0);
        square(r0, r0);
        multiply(r0, r3, r0);
        squareN(r0, 3, r1);
        multiply(r1, r0, r1);
        square(r1, r1);
        multiply(r1, r3, r1);
        squareN(r1, 7, r0);
        multiply(r0, r1, r0);
        squareN(r0, 14, r1);
        multiply(r1, r0, r1);
        square(r1, r1);
        multiply(r1, r3, r1);
        squareN(r1, 29, r0);
        multiply(r0, r1, r0);
        square(r0, r0);
        multiply(r0, r3, r0);
        squareN(r0, 59, r1);
        multiply(r1, r0, r1);
        square(r1, r1);
        multiply(r1, r3, r1);
        squareN(r1, IdlErrors.E_RejectInferDeviceOverheat, r0);
        multiply(r0, r1, r0);
        square(r0, r4);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat256.createExt64();
        implMultiply(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat256.createExt64();
        implMultiply(r1, r2, r0);
        addExt(r3, r0, r3);
    }

    public static void reduce(long[] r24, long[] r25) {
        long r1 = r24[0];
        long r4 = r24[1];
        long r7 = r24[2];
        long r10 = r24[3];
        long r12 = r24[4];
        long r14 = r24[5];
        long r16 = r24[6];
        long r18 = r24[7];
        long r11 = r10 ^ (r18 << 17);
        long r13 = r12 ^ (r18 >>> 47);
        long r15 = r14 ^ (r18 << 47);
        long r17 = r16 ^ (r18 >>> 17);
        long r8 = r7 ^ (r17 << 17);
        long r19 = r11 ^ (r17 >>> 47);
        long r110 = r13 ^ (r17 << 47);
        long r111 = r15 ^ (r17 >>> 17);
        long r5 = r4 ^ (r111 << 17);
        long r9 = r8 ^ (r111 >>> 47);
        long r112 = r19 ^ (r111 << 47);
        long r113 = r110 ^ (r111 >>> 17);
        long r2 = r1 ^ (r113 << 17);
        long r6 = r5 ^ (r113 >>> 47);
        long r20 = r9 ^ (r113 << 47);
        long r114 = r112 ^ (r113 >>> 17);
        long r115 = r114 >>> 47;
        r25[0] = r2 ^ r115;
        r25[1] = r6;
        r25[2] = (r115 << 30) ^ r20;
        r25[3] = 140737488355327L & r114;
    }

    public static void sqrt(long[] r27, long[] r28) {
        int r1 = 0;
        long r2 = Interleave.unshuffle(r27[0]);
        long r5 = Interleave.unshuffle(r27[1]);
        long r9 = (r2 & 4294967295L) | (r5 << 32);
        long r3 = (r2 >>> 32) | (r5 & (-4294967296L));
        int r6 = 2;
        long r14 = Interleave.unshuffle(r27[2]);
        long r16 = Interleave.unshuffle(r27[3]);
        long r7 = (r14 & 4294967295L) | (r16 << 32);
        long r11 = r16 & (-4294967296L);
        long r12 = r11 | (r14 >>> 32);
        long r13 = r12 >>> 49;
        long r15 = (r3 >>> 49) | (r12 << 15);
        long r17 = r12 ^ (r3 << 15);
        long[] r8 = Nat256.createExt64();
        int[] r4 = {39, 120};
    L3:
        if (r1 >= r6) goto L5;
        int r19 = r4[r1] >>> 6;
        int r10 = r4[r1] & 63;
        r8[r19] = r8[r19] ^ (r3 << r10);
        int r20 = r19 + 1;
        int[] r29 = r4;
        int r18 = -r10;
        r8[r20] = r8[r20] ^ ((r17 << r10) | (r3 >>> r18));
        int r21 = r19 + 2;
        r8[r21] = r8[r21] ^ ((r15 << r10) | (r17 >>> r18));
        int r22 = r19 + 3;
        r8[r22] = r8[r22] ^ ((r13 << r10) | (r15 >>> r18));
        int r110 = r19 + 4;
        r8[r110] = r8[r110] ^ (r13 >>> r18);
        r1 = r1 + 1;
        r6 = 2;
        r4 = r29;
        goto L3
    L5:
        reduce(r8, r28);
        r28[0] = r28[0] ^ r9;
        r28[1] = r28[1] ^ r7;
    }

    public static void square(long[] r1, long[] r2) {
        long[] r0 = Nat256.createExt64();
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat256.createExt64();
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat256.createExt64();
        implSquare(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        implSquare(r3, r0);
        goto L3
    }

    public static int trace(long[] r6) {
        return ((int) ((r6[0] ^ (r6[1] >>> 17)) ^ (r6[2] >>> 34))) & 1;
    }
}
