package org.bouncycastle.math.raw;

import java.util.Random;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Mod {
    private static int add30(int r4, int[] r5, int[] r6) {
        int r7 = r4 - 1;
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r7) goto L5;
        int r2 = r1 + (r5[r0] + r6[r0]);
        r5[r0] = 1073741823 & r2;
        r1 = r2 >> 30;
        r0 = r0 + 1;
        goto L3
    L5:
        int r3 = r1 + (r5[r7] + r6[r7]);
        r5[r7] = r3;
        return r3 >> 30;
    }

    public static void checkedModOddInverse(int[] r0, int[] r1, int[] r2) {
        if (modOddInverse(r0, r1, r2) == 0) goto L6;
        return;
    L6:
        throw new ArithmeticException("Inverse does not exist.");
    }

    private static void cnegate30(int r3, int r4, int[] r5) {
        int r6 = r3 - 1;
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r6) goto L5;
        int r2 = r1 + ((r5[r0] ^ r4) - r4);
        r5[r0] = 1073741823 & r2;
        r1 = r2 >> 30;
        r0 = r0 + 1;
        goto L3
    L5:
        r5[r6] = r1 + ((r5[r6] ^ r4) - r4);
    }

    private static void cnormalize30(int r7, int r8, int[] r9, int[] r10) {
        int r11 = r7 - 1;
        int r0 = r9[r11] >> 31;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r11) goto L6;
        int r4 = r3 + (((r9[r2] + (r10[r2] & r0)) ^ r8) - r8);
        r9[r2] = 1073741823 & r4;
        r3 = r4 >> 30;
        r2 = r2 + 1;
        goto L4
    L6:
        r9[r11] = r3 + (((r9[r11] + (r0 & r10[r11])) ^ r8) - r8);
        int r12 = r9[r11] >> 31;
        int r5 = 0;
    L7:
        if (r1 >= r11) goto L9;
        int r6 = r5 + (r9[r1] + (r10[r1] & r12));
        r9[r1] = r6 & 1073741823;
        r5 = r6 >> 30;
        r1 = r1 + 1;
        goto L7
    L9:
        r9[r11] = r5 + (r9[r11] + (r12 & r10[r11]));
    }

    private static void decode30(int r6, int[] r7, int r8, int[] r9, int r10) {
        int r0 = 0;
        long r1 = 0;
    L3:
        if (r6 <= 0) goto L8;
    L5:
        if (r0 >= Math.min(32, r6)) goto L7;
        r1 = r1 | (((long) r7[r8]) << r0);
        r0 = r0 + 30;
        r8 = r8 + 1;
        goto L5
    L7:
        r9[r10] = (int) r1;
        r1 = r1 >>> 32;
        r0 = r0 - 32;
        r6 = r6 - 32;
        r10 = r10 + 1;
        goto L3
    }

    private static int divsteps30(int r12, int r13, int r14, int[] r15) {
        int r0 = 1073741824;
        int r2 = 1073741824;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3 >= 30) goto L6;
        int r6 = r12 >> 31;
        int r8 = -(r14 & 1);
        int r16 = r14 - ((r13 ^ r6) & r8);
        int r7 = r5 - ((r0 ^ r6) & r8);
        int r9 = r2 - ((r4 ^ r6) & r8);
        int r10 = (~r6) & r8;
        r12 = (r12 ^ r10) - (r10 - 1);
        r13 = r13 + (r16 & r10);
        r0 = r0 + (r7 & r10);
        r4 = r4 + (r10 & r9);
        r14 = r16 >> 1;
        r5 = r7 >> 1;
        r2 = r9 >> 1;
        r3 = r3 + 1;
        goto L4
    L6:
        r15[0] = r0;
        r15[1] = r4;
        r15[2] = r5;
        r15[3] = r2;
        return r12;
    }

    private static int divsteps30Var(int r17, int r18, int r19, int[] r20) {
        int r3 = r18;
        int r4 = r19;
        int r7 = 0;
        int r8 = 0;
        int r6 = 1;
        int r9 = 1;
        int r5 = 30;
        int r2 = r17;
    L3:
        int r11 = Integers.numberOfTrailingZeros(((-1) << r5) | r4);
        int r10 = r4 >> r11;
        r6 = r6 << r11;
        r7 = r7 << r11;
        r2 = r2 - r11;
        r5 = r5 - r11;
        if (r5 <= 0) goto L5;
        if (r2 >= 0) goto L12;
        r2 = -r2;
        int r12 = -r3;
        int r13 = -r6;
        int r14 = -r7;
        int r15 = r2 + 1;
        if (r15 <= r5) goto L11;
        r15 = r5;
    L11:
        int r16 = (((-1) >>> (32 - r15)) & 63) & ((r10 * r12) * ((r10 * r10) - 2));
        r10 = r12;
        r3 = r10;
        int r110 = r8;
        r8 = r13;
        r6 = r110;
        int r111 = r9;
        r9 = r14;
        r7 = r111;
    L16:
        r4 = r10 + (r3 * r16);
        r8 = r8 + (r6 * r16);
        r9 = r9 + (r16 * r7);
        goto L3
    L12:
        int r112 = r2 + 1;
        if (r112 <= r5) goto L15;
        r112 = r5;
    L15:
        r16 = (((-1) >>> (32 - r112)) & 15) & ((-((((r3 + 1) & 4) << 1) + r3)) * r10);
        goto L16
    L5:
        r20[0] = r6;
        r20[1] = r7;
        r20[2] = r8;
        r20[3] = r9;
        return r2;
    }

    private static void encode30(int r9, int[] r10, int r11, int[] r12, int r13) {
        int r0 = 0;
        long r1 = 0;
    L3:
        if (r9 <= 0) goto L8;
        if (r0 >= Math.min(30, r9)) goto L7;
        r1 = r1 | ((((long) r10[r11]) & 4294967295L) << r0);
        r0 = r0 + 32;
        r11 = r11 + 1;
    L7:
        r12[r13] = ((int) r1) & 1073741823;
        r1 = r1 >>> 30;
        r0 = r0 - 30;
        r9 = r9 - 30;
        r13 = r13 + 1;
        goto L3
    }

    private static int getMaximumDivsteps(int r2) {
        int r0 = r2 * 49;
        if (r2 >= 46) goto L5;
        int r3 = 80;
    L7:
        return (r0 + r3) / 17;
    L5:
        r3 = 47;
        goto L7
    }

    public static int inverse32(int r2) {
        int r0 = (2 - (r2 * r2)) * r2;
        int r1 = r0 * (2 - (r2 * r0));
        int r3 = r1 * (2 - (r2 * r1));
        return r3 * (2 - (r2 * r3));
    }

    public static int modOddInverse(int[] r19, int[] r20, int[] r21) {
        int r1 = r19.length;
        int r2 = (r1 << 5) - Integers.numberOfLeadingZeros(r19[r1 - 1]);
        int r3 = (r2 + 29) / 30;
        int[] r10 = new int[4];
        int[] r11 = new int[r3];
        int[] r12 = new int[r3];
        int[] r13 = new int[r3];
        int[] r14 = new int[r3];
        int[] r15 = new int[r3];
        int r9 = 0;
        r12[0] = 1;
        encode30(r2, r20, 0, r14, 0);
        encode30(r2, r19, 0, r15, 0);
        System.arraycopy(r15, 0, r13, 0, r3);
        int r0 = inverse32(r15[0]);
        int r8 = getMaximumDivsteps(r2);
        int r4 = 0;
        int r7 = 0;
    L3:
        if (r7 >= r8) goto L5;
        int r16 = divsteps30(r4, r13[r9], r14[r9], r10);
        updateDE30(r3, r11, r12, r10, r0, r15);
        updateFG30(r3, r13, r14, r10);
        r7 = r7 + 30;
        r9 = r9;
        r4 = r16;
        r8 = r8;
        goto L3
    L5:
        int r5 = r9;
        int r6 = r13[r3 - 1] >> 31;
        cnegate30(r3, r6, r13);
        cnormalize30(r3, r6, r11, r15);
        decode30(r2, r11, r5, r21, r5);
        return Nat.equalTo(r3, r13, 1) & Nat.equalToZero(r3, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public static boolean modOddInverseVar(int[] r21, int[] r22, int[] r23) {
        int r1 = r21.length;
        int r2 = (r1 << 5) - Integers.numberOfLeadingZeros(r21[r1 - 1]);
        int r3 = (r2 + 29) / 30;
        int[] r10 = new int[4];
        int[] r11 = new int[r3];
        int[] r12 = new int[r3];
        int[] r13 = new int[r3];
        int[] r14 = new int[r3];
        int[] r15 = new int[r3];
        ?? r9 = 0;
        r12[0] = 1;
        encode30(r2, r22, 0, r14, 0);
        encode30(r2, r21, 0, r15, 0);
        System.arraycopy(r15, 0, r13, 0, r3);
        int r0 = r3 - 1;
        int r4 = (-1) - (Integers.numberOfLeadingZeros(r14[r0] | 1) - (((r3 * 30) + 2) - r2));
        int r16 = inverse32(r15[0]);
        int r8 = getMaximumDivsteps(r2);
        int r7 = r3;
        int r5 = 0;
    L4:
        if (Nat.isZero(r7, r14) == true) goto L12;
        if (r5 >= r8) goto L6;
        int r17 = r5 + 30;
        int r18 = divsteps30Var(r4, r13[r9], r14[r9], r10);
        int[] r6 = r12;
        int r19 = r7;
        int r110 = r8;
        int[] r20 = r12;
        ?? r111 = r9;
        updateDE30(r3, r11, r6, r10, r16, r15);
        updateFG30(r19, r13, r14, r10);
        int r24 = r19 - 1;
        int r25 = r13[r24];
        int r26 = r14[r24];
        int r27 = r19 - 2;
        if ((((r27 >> 31) | ((r25 >> 31) ^ r25)) | ((r26 >> 31) ^ r26)) != 0) goto L10;
        r13[r27] = (r25 << 30) | r13[r27];
        r14[r27] = r14[r27] | (r26 << 30);
        r7 = r19 - 1;
    L11:
        r9 = r111 == true ? 1 : 0;
        r5 = r17;
        r4 = r18;
        r8 = r110;
        r12 = r20;
        goto L4
    L10:
        r7 = r19;
        goto L11
    L6:
        return r9;
    L12:
        int r28 = r7;
        ?? r112 = r9;
        int r29 = r13[r28 - 1] >> 31;
        int r30 = r11[r0] >> 31;
        if (r30 >= 0) goto L15;
        r30 = add30(r3, r11, r15);
    L15:
        if (r29 >= 0) goto L18;
        r30 = negate30(r3, r11);
        negate30(r28, r13);
    L18:
        if (Nat.isOne(r28, r13) == true) goto L20;
        return r112;
    L20:
        if (r30 >= 0) goto L22;
        add30(r3, r11, r15);
    L22:
        decode30(r2, r11, r112 == true ? 1 : 0, r23, r112 == true ? 1 : 0);
        return true;
    }

    private static int negate30(int r3, int[] r4) {
        int r5 = r3 - 1;
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r5) goto L5;
        int r2 = r1 - r4[r0];
        r4[r0] = 1073741823 & r2;
        r1 = r2 >> 30;
        r0 = r0 + 1;
        goto L3
    L5:
        int r6 = r1 - r4[r5];
        r4[r5] = r6;
        return r6 >> 30;
    }

    public static int[] random(int[] r7) {
        int r0 = r7.length;
        Random r1 = new Random();
        int[] r2 = Nat.create(r0);
        int r3 = r0 - 1;
        int r4 = r7[r3];
        int r5 = r4 | (r4 >>> 1);
        int r6 = r5 | (r5 >>> 2);
        int r8 = r6 | (r6 >>> 4);
        int r9 = r8 | (r8 >>> 8);
        int r10 = r9 | (r9 >>> 16);
    L3:
        int r11 = 0;
    L4:
        if (r11 == r0) goto L6;
        r2[r11] = r1.nextInt();
        r11 = r11 + 1;
        goto L4
    L6:
        r2[r3] = r2[r3] & r10;
        if (Nat.gte(r0, r2, r7) == true) goto L3;
        return r2;
    }

    private static void updateDE30(int r30, int[] r31, int[] r32, int[] r33, int r34, int[] r35) {
        int r0 = r30;
        int r2 = r33[0];
        int r4 = r33[1];
        int r5 = r33[2];
        int r6 = r33[3];
        int r7 = r0 - 1;
        int r8 = r31[r7] >> 31;
        int r9 = r32[r7] >> 31;
        int r10 = (r2 & r8) + (r4 & r9);
        int r11 = (r8 & r5) + (r9 & r6);
        int r12 = r35[0];
        long r13 = r2;
        long r14 = r31[0];
        long r3 = r4;
        long r1 = r32[0];
        long r15 = (r13 * r14) + (r3 * r1);
        long r16 = r5;
        long r17 = r6;
        long r18 = (r14 * r16) + (r1 * r17);
        long r19 = r12;
        long r20 = r10 - (((((int) r15) * r34) + r10) & 1073741823);
        int r21 = r7;
        long r22 = r11 - (((((int) r18) * r34) + r11) & 1073741823);
        long r110 = (r18 + (r19 * r22)) >> 30;
        long r23 = (r15 + (r19 * r20)) >> 30;
        int r24 = 1;
    L3:
        if (r24 >= r0) goto L5;
        int r111 = r35[r24];
        long r25 = r110;
        long r112 = r31[r24];
        int r26 = r24;
        long r27 = r32[r24];
        long r28 = r22;
        long r29 = r111;
        long r36 = r23 + (((r13 * r112) + (r3 * r27)) + (r29 * r20));
        long r113 = r25 + (((r112 * r16) + (r27 * r17)) + (r29 * r28));
        int r37 = r26 - 1;
        r31[r37] = ((int) r36) & 1073741823;
        r23 = r36 >> 30;
        r32[r37] = ((int) r113) & 1073741823;
        r110 = r113 >> 30;
        r24 = r26 + 1;
        r0 = r30;
        r21 = r21;
        r22 = r28;
        goto L3
    L5:
        int r114 = r21;
        r31[r114] = (int) r23;
        r32[r114] = (int) r110;
    }

    private static void updateFG30(int r24, int[] r25, int[] r26, int[] r27) {
        int r2 = r27[0];
        int r3 = 1;
        int r4 = r27[1];
        int r5 = r27[2];
        int r6 = r27[3];
        long r8 = r2;
        long r10 = r25[0];
        long r14 = r4;
        long r1 = r26[0];
        long r7 = r5;
        long r9 = r6;
        long r12 = ((r8 * r10) + (r14 * r1)) >> 30;
        long r11 = ((r10 * r7) + (r1 * r9)) >> 30;
        int r13 = 1;
    L3:
        if (r13 >= r24) goto L5;
        int r15 = r25[r13];
        int r16 = r26[r13];
        int r17 = r13;
        long r18 = r15;
        long r19 = r8 * r18;
        long r20 = r8;
        long r21 = r16;
        long r110 = r12 + (r19 + (r14 * r21));
        long r111 = r11 + ((r18 * r7) + (r21 * r9));
        int r22 = r17 - 1;
        r25[r22] = ((int) r110) & 1073741823;
        r12 = r110 >> 30;
        r26[r22] = 1073741823 & ((int) r111);
        r11 = r111 >> 30;
        r13 = r17 + 1;
        r8 = r20;
        r3 = 1;
        goto L3
    L5:
        int r0 = r24 - r3;
        r25[r0] = (int) r12;
        r26[r0] = (int) r11;
    }
}
