package org.bouncycastle.math.ec.rfc7748;

import androidx.core.view.ViewCompat;
import org.bouncycastle.math.raw.Mod;

/* JADX INFO: loaded from: classes7.dex */
public abstract class X25519Field {
    private static final int[] P32 = null;
    private static final int[] ROOT_NEG_ONE = null;

    static {
        P32 = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
        ROOT_NEG_ONE = new int[]{34513072, 59165138, 4688974, 3500415, 6194736, 33281959, 54535759, 32551604, 163342, 5703241};
    }

    public static void add(int[] r3, int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        r5[r0] = r3[r0] + r4[r0];
        r0 = r0 + 1;
        goto L4
    }

    public static void addOne(int[] r2) {
        r2[0] = r2[0] + 1;
    }

    public static void apm(int[] r4, int[] r5, int[] r6, int[] r7) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        int r1 = r4[r0];
        int r2 = r5[r0];
        r6[r0] = r1 + r2;
        r7[r0] = r1 - r2;
        r0 = r0 + 1;
        goto L4
    }

    public static void carry(int[] r23) {
        int r1 = r23[0];
        int r3 = r23[1];
        int r5 = r23[2];
        int r7 = r23[3];
        int r9 = r23[4];
        int r11 = r23[5];
        int r13 = r23[6];
        int r15 = r23[7];
        int r17 = r23[8];
        int r6 = r5 + (r3 >> 26);
        int r10 = r9 + (r7 >> 26);
        int r16 = r15 + (r13 >> 26);
        int r19 = r23[9] + (r17 >> 26);
        int r8 = (r7 & 67108863) + (r6 >> 25);
        int r12 = r11 + (r10 >> 25);
        int r18 = (r17 & 67108863) + (r16 >> 25);
        int r2 = r1 + ((r19 >> 25) * 38);
        int r4 = (r3 & 67108863) + (r2 >> 26);
        int r14 = (r13 & 67108863) + (r12 >> 26);
        int r20 = (r6 & 33554431) + (r4 >> 26);
        int r21 = (r10 & 33554431) + (r8 >> 26);
        int r110 = (r16 & 33554431) + (r14 >> 26);
        int r111 = (r19 & 33554431) + (r18 >> 26);
        r23[0] = r2 & 67108863;
        r23[1] = r4 & 67108863;
        r23[2] = r20;
        r23[3] = r8 & 67108863;
        r23[4] = r21;
        r23[5] = r12 & 67108863;
        r23[6] = r14 & 67108863;
        r23[7] = r110;
        r23[8] = r18 & 67108863;
        r23[9] = r111;
    }

    public static void cmov(int r4, int[] r5, int r6, int[] r7, int r8) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        int r1 = r8 + r0;
        int r2 = r7[r1];
        r7[r1] = r2 ^ ((r5[r6 + r0] ^ r2) & r4);
        r0 = r0 + 1;
        goto L4
    }

    public static void cnegate(int r2, int[] r3) {
        int r0 = 0;
        int r4 = 0 - r2;
    L4:
        if (r0 >= 10) goto L6;
        r3[r0] = (r3[r0] ^ r4) - r4;
        r0 = r0 + 1;
        goto L4
    }

    public static void copy(int[] r3, int r4, int[] r5, int r6) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        r5[r6 + r0] = r3[r4 + r0];
        r0 = r0 + 1;
        goto L4
    }

    public static int[] create() {
        return new int[10];
    }

    public static int[] createTable(int r0) {
        return new int[r0 * 10];
    }

    public static void decode(int[] r1, int r2, int[] r3) {
        decode128(r1, r2, r3, 0);
        decode128(r1, r2 + 4, r3, 5);
        r3[9] = r3[9] & ViewCompat.MEASURED_SIZE_MASK;
    }

    private static void decode128(int[] r5, int r6, int[] r7, int r8) {
        int r0 = r5[r6 + 0];
        int r1 = r5[r6 + 1];
        int r2 = r5[r6 + 2];
        int r9 = r5[r6 + 3];
        r7[r8 + 0] = r0 & 67108863;
        int r3 = r0 >>> 26;
        r7[r8 + 1] = (r3 | (r1 << 6)) & 67108863;
        r7[r8 + 2] = ((r2 << 12) | (r1 >>> 20)) & 33554431;
        r7[r8 + 3] = ((r9 << 19) | (r2 >>> 13)) & 67108863;
        r7[r8 + 4] = r9 >>> 7;
    }

    public static void encode(int[] r1, byte[] r2, int r3) {
        encode128(r1, 0, r2, r3);
        encode128(r1, 5, r2, r3 + 16);
    }

    public static void encode(int[] r1, int[] r2, int r3) {
        encode128(r1, 0, r2, r3);
        encode128(r1, 5, r2, r3 + 4);
    }

    private static void encode128(int[] r4, int r5, byte[] r6, int r7) {
        int r0 = r4[r5 + 0];
        int r1 = r4[r5 + 1];
        int r2 = r4[r5 + 2];
        int r3 = r4[r5 + 3];
        int r8 = r4[r5 + 4];
        encode32((r1 << 26) | r0, r6, r7 + 0);
        encode32((r1 >>> 6) | (r2 << 20), r6, r7 + 4);
        encode32((r2 >>> 12) | (r3 << 13), r6, r7 + 8);
        int r9 = r8 << 7;
        encode32(r9 | (r3 >>> 19), r6, r7 + 12);
    }

    private static void encode128(int[] r5, int r6, int[] r7, int r8) {
        int r0 = r5[r6 + 0];
        int r1 = r5[r6 + 1];
        int r2 = r5[r6 + 2];
        int r3 = r5[r6 + 3];
        int r9 = r5[r6 + 4];
        r7[r8 + 0] = r0 | (r1 << 26);
        r7[r8 + 1] = (r1 >>> 6) | (r2 << 20);
        r7[r8 + 2] = (r2 >>> 12) | (r3 << 13);
        int r10 = r9 << 7;
        r7[r8 + 3] = r10 | (r3 >>> 19);
    }

    private static void encode32(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) r1;
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >>> 8);
        int r5 = r4 + 1;
        r2[r5] = (byte) (r1 >>> 16);
        r2[r5 + 1] = (byte) (r1 >>> 24);
    }

    public static void inv(int[] r3, int[] r4) {
        int[] r0 = create();
        int[] r1 = new int[8];
        copy(r3, 0, r0, 0);
        normalize(r0);
        encode(r0, r1, 0);
        Mod.modOddInverse(P32, r1, r1);
        decode(r1, 0, r4);
    }

    public static void invVar(int[] r3, int[] r4) {
        int[] r0 = create();
        int[] r1 = new int[8];
        copy(r3, 0, r0, 0);
        normalize(r0);
        encode(r0, r1, 0);
        Mod.modOddInverseVar(P32, r1, r1);
        decode(r1, 0, r4);
    }

    public static int isZero(int[] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 10) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void mul(int[] r73, int[] r74, int[] r75) {
        int r1 = r73[0];
        int r2 = r74[0];
        int r4 = r73[1];
        int r5 = r74[1];
        int r7 = r73[2];
        int r8 = r74[2];
        int r10 = r73[3];
        int r11 = r74[3];
        int r13 = r73[4];
        int r14 = r74[4];
        int r12 = r73[5];
        int r9 = r74[5];
        int r15 = r73[6];
        int r6 = r74[6];
        int r0 = r73[7];
        int r3 = r74[7];
        int r16 = r73[8];
        int r17 = r74[8];
        int r18 = r73[9];
        int r19 = r74[9];
        long r110 = r1;
        long r20 = r2;
        long r28 = r110 * r20;
        long r21 = r5;
        long r22 = r4;
        long r32 = (r110 * r21) + (r22 * r20);
        long r111 = r8;
        long r23 = r7;
        long r38 = ((r110 * r111) + (r22 * r21)) + (r23 * r20);
        long r42 = ((r22 * r111) + (r23 * r21)) << 1;
        long r24 = r11;
        long r46 = r110 * r24;
        long r25 = r10;
        long r43 = r42 + (r46 + (r25 * r20));
        long r47 = (r23 * r111) << 1;
        long r112 = r14;
        long r113 = ((r110 * r112) + (r22 * r24)) + (r25 * r21);
        long r26 = r13;
        long r48 = r47 + (r113 + (r20 * r26));
        long r27 = ((((r22 * r112) + (r23 * r24)) + (r25 * r111)) + (r26 * r21)) << 1;
        long r29 = (((r23 * r112) + (r26 * r111)) << 1) + (r25 * r24);
        long r114 = (r25 * r112) + (r26 * r24);
        long r30 = (r26 * r112) << 1;
        long r115 = r12;
        long r116 = r9;
        long r44 = r115 * r116;
        long r31 = r6;
        long r33 = r15;
        long r51 = (r115 * r31) + (r33 * r116);
        long r117 = r3;
        long r34 = r0;
        long r57 = ((r115 * r117) + (r33 * r31)) + (r34 * r116);
        long r35 = r17;
        long r36 = r16;
        long r61 = (((r33 * r117) + (r34 * r31)) << 1) + ((r115 * r35) + (r36 * r116));
        long r65 = (r34 * r117) << 1;
        long r118 = r19;
        long r119 = ((r115 * r118) + (r33 * r35)) + (r36 * r31);
        long r37 = r18;
        long r66 = r65 + (r119 + (r116 * r37));
        long r39 = (((r33 * r118) + (r34 * r35)) + (r36 * r117)) + (r37 * r31);
        long r210 = r28 - (r39 * 76);
        long r310 = r32 - (((((r34 * r118) + (r37 * r117)) << 1) + (r36 * r35)) * 38);
        long r311 = r38 - (((r36 * r118) + (r35 * r37)) * 38);
        long r45 = r43 - ((r37 * r118) * 76);
        long r40 = r27 - r44;
        long r41 = r29 - r51;
        long r120 = r114 - r57;
        long r49 = r30 - r61;
        int r50 = r1 + r12;
        int r121 = r4 + r15;
        int r122 = r7 + r0;
        int r52 = r8 + r3;
        int r53 = r10 + r16;
        int r123 = r13 + r18;
        long r54 = r50;
        long r55 = r2 + r9;
        long r211 = r54 * r55;
        long r56 = r5 + r6;
        long r124 = r121;
        long r312 = (r54 * r56) + (r124 * r55);
        long r125 = r52;
        long r58 = r122;
        long r410 = ((r54 * r125) + (r124 * r56)) + (r58 * r55);
        long r411 = ((r124 * r125) + (r58 * r56)) << 1;
        long r59 = r11 + r17;
        long r60 = r53;
        long r412 = r411 + ((r54 * r59) + (r60 * r55));
        long r126 = r14 + r19;
        long r127 = r123;
        long r510 = ((r58 * r125) << 1) + ((((r54 * r126) + (r124 * r59)) + (r60 * r56)) + (r55 * r127));
        long r62 = ((((r124 * r126) + (r58 * r59)) + (r60 * r125)) + (r127 * r56)) << 1;
        long r63 = (((r58 * r126) + (r127 * r125)) << 1) + (r60 * r59);
        long r64 = r49 + (r412 - r45);
        int r67 = ((int) r64) & 67108863;
        long r68 = (r64 >> 26) + ((r510 - r48) - r66);
        int r128 = ((int) r68) & 33554431;
        long r69 = r210 + ((((r68 >> 25) + r62) - r40) * 38);
        r75[0] = ((int) r69) & 67108863;
        long r70 = (r69 >> 26) + (r310 + ((r63 - r41) * 38));
        r75[1] = ((int) r70) & 67108863;
        long r71 = (r70 >> 26) + (r311 + ((((r60 * r126) + (r127 * r59)) - r120) * 38));
        r75[2] = ((int) r71) & 33554431;
        long r72 = (r71 >> 25) + (r45 + ((((r127 * r126) << 1) - r49) * 38));
        r75[3] = ((int) r72) & 67108863;
        long r76 = (r72 >> 26) + (r48 + (r66 * 38));
        r75[4] = ((int) r76) & 33554431;
        long r77 = (r76 >> 25) + (r40 + (r211 - r210));
        r75[5] = ((int) r77) & 67108863;
        long r78 = (r77 >> 26) + (r41 + (r312 - r310));
        r75[6] = ((int) r78) & 67108863;
        long r79 = (r78 >> 26) + (r120 + (r410 - r311));
        r75[7] = ((int) r79) & 33554431;
        long r80 = (r79 >> 25) + ((long) r67);
        r75[8] = ((int) r80) & 67108863;
        r75[9] = r128 + ((int) (r80 >> 26));
    }

    public static void negate(int[] r2, int[] r3) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        r3[r0] = -r2[r0];
        r0 = r0 + 1;
        goto L4
    }

    public static void normalize(int[] r1) {
        int r0 = (r1[9] >>> 23) & 1;
        reduce(r1, r0);
        reduce(r1, -r0);
    }

    public static void one(int[] r3) {
        int r1 = 1;
        r3[0] = 1;
    L4:
        if (r1 >= 10) goto L6;
        r3[r1] = 0;
        r1 = r1 + 1;
        goto L4
    }

    private static void reduce(int[] r10, int r11) {
        int r1 = r10[9];
        int r2 = 16777215 & r1;
        long r3 = ((long) (((r1 >> 24) + r11) * 19)) + ((long) r10[0]);
        r10[0] = ((int) r3) & 67108863;
        long r4 = (r3 >> 26) + ((long) r10[1]);
        r10[1] = ((int) r4) & 67108863;
        long r5 = (r4 >> 26) + ((long) r10[2]);
        r10[2] = ((int) r5) & 33554431;
        long r6 = (r5 >> 25) + ((long) r10[3]);
        r10[3] = ((int) r6) & 67108863;
        long r7 = (r6 >> 26) + ((long) r10[4]);
        r10[4] = ((int) r7) & 33554431;
        long r8 = (r7 >> 25) + ((long) r10[5]);
        r10[5] = ((int) r8) & 67108863;
        long r9 = (r8 >> 26) + ((long) r10[6]);
        r10[6] = ((int) r9) & 67108863;
        long r12 = (r9 >> 26) + ((long) r10[7]);
        r10[7] = 33554431 & ((int) r12);
        long r13 = (r12 >> 25) + ((long) r10[8]);
        r10[8] = 67108863 & ((int) r13);
        r10[9] = r2 + ((int) (r13 >> 26));
    }

    public static void sqr(int[] r55, int[] r56) {
        int r1 = r55[0];
        int r3 = r55[1];
        int r5 = r55[2];
        int r7 = r55[3];
        int r9 = r55[4];
        int r11 = r55[5];
        int r13 = r55[6];
        int r15 = r55[7];
        int r14 = r55[8];
        int r12 = r55[9];
        long r2 = r1;
        long r19 = r2 * r2;
        long r0 = r3 * 2;
        long r22 = r2 * r0;
        long r10 = r5 * 2;
        long r16 = r3;
        long r25 = (r2 * r10) + (r16 * r16);
        long r17 = r7 * 2;
        long r28 = (r0 * r10) + (r2 * r17);
        long r4 = r9 * 2;
        long r8 = ((((long) r5) * r10) + (r2 * r4)) + (r16 * r17);
        long r6 = (r0 * r4) + (r17 * r10);
        long r18 = r7;
        long r110 = (r10 * r4) + (r18 * r18);
        long r20 = r18 * r4;
        long r111 = ((long) r9) * r4;
        int r21 = r12 * 2;
        long r23 = r11;
        long r35 = r23 * r23;
        long r24 = r13 * 2;
        long r39 = r23 * r24;
        long r112 = r15 * 2;
        long r26 = r13;
        long r43 = (r23 * r112) + (r26 * r26);
        long r113 = r14 * 2;
        long r47 = (r24 * r112) + (r23 * r113);
        long r27 = r21;
        long r114 = ((((long) r15) * r112) + (r23 * r27)) + (r26 * r113);
        long r29 = (r24 * r27) + (r113 * r112);
        long r30 = r14;
        long r115 = r19 - (r29 * 38);
        long r210 = r22 - (((r112 * r27) + (r30 * r30)) * 38);
        long r211 = r25 - ((r30 * r27) * 38);
        long r212 = r28 - ((((long) r12) * r27) * 38);
        long r31 = r6 - r35;
        long r32 = r110 - r39;
        long r33 = r20 - r43;
        long r116 = r111 - r47;
        int r117 = r3 + r13;
        int r34 = r5 + r15;
        int r36 = r7 + r14;
        int r37 = r9 + r12;
        long r38 = r1 + r11;
        long r41 = r38 * r38;
        long r118 = r117 * 2;
        long r45 = r38 * r118;
        long r40 = r34 * 2;
        long r119 = r117;
        long r48 = (r38 * r40) + (r119 * r119);
        long r120 = r36 * 2;
        long r49 = (r118 * r40) + (r38 * r120);
        long r42 = r37 * 2;
        long r44 = ((((long) r34) * r40) + (r38 * r42)) + (r119 * r120);
        long r121 = (r118 * r42) + (r120 * r40);
        long r46 = r36;
        long r50 = (r40 * r42) + (r46 * r46);
        long r51 = r46 * r42;
        long r122 = ((long) r37) * r42;
        long r52 = r116 + (r49 - r212);
        int r53 = ((int) r52) & 67108863;
        long r54 = (r52 >> 26) + ((r44 - r8) - r114);
        int r57 = ((int) r54) & 33554431;
        long r58 = r115 + ((((r54 >> 25) + r121) - r31) * 38);
        r56[0] = ((int) r58) & 67108863;
        long r59 = (r58 >> 26) + (r210 + ((r50 - r32) * 38));
        r56[1] = ((int) r59) & 67108863;
        long r60 = (r59 >> 26) + (r211 + ((r51 - r33) * 38));
        r56[2] = ((int) r60) & 33554431;
        long r61 = (r60 >> 25) + (r212 + ((r122 - r116) * 38));
        r56[3] = ((int) r61) & 67108863;
        long r62 = (r61 >> 26) + (r8 + (38 * r114));
        r56[4] = ((int) r62) & 33554431;
        long r63 = (r62 >> 25) + (r31 + (r41 - r115));
        r56[5] = ((int) r63) & 67108863;
        long r64 = (r63 >> 26) + (r32 + (r45 - r210));
        r56[6] = ((int) r64) & 67108863;
        long r65 = (r64 >> 26) + (r33 + (r48 - r211));
        r56[7] = ((int) r65) & 33554431;
        long r66 = (r65 >> 25) + ((long) r53);
        r56[8] = ((int) r66) & 67108863;
        r56[9] = r57 + ((int) (r66 >> 26));
    }

    public static void sub(int[] r3, int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        r5[r0] = r3[r0] - r4[r0];
        r0 = r0 + 1;
        goto L4
    }

    public static void zero(int[] r3) {
        int r1 = 0;
    L4:
        if (r1 >= 10) goto L6;
        r3[r1] = 0;
        r1 = r1 + 1;
        goto L4
    }
}
