package org.bouncycastle.math.ec.rfc7748;

import org.bouncycastle.math.raw.Mod;

/* JADX INFO: loaded from: classes7.dex */
public abstract class X448Field {
    private static final int[] P32 = null;

    static {
        P32 = new int[]{-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    }

    public static void add(int[] r3, int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= 16) goto L6;
        r5[r0] = r3[r0] + r4[r0];
        r0 = r0 + 1;
        goto L4
    }

    public static void carry(int[] r34) {
        int r1 = r34[0];
        int r3 = r34[1];
        int r5 = r34[2];
        int r7 = r34[3];
        int r9 = r34[4];
        int r11 = r34[5];
        int r13 = r34[6];
        int r15 = r34[7];
        int r17 = r34[8];
        int r19 = r34[9];
        int r21 = r34[10];
        int r23 = r34[11];
        int r25 = r34[12];
        int r27 = r34[13];
        int r29 = r34[14];
        int r4 = r3 + (r1 >>> 28);
        int r12 = r11 + (r9 >>> 28);
        int r110 = r19 + (r17 >>> 28);
        int r28 = r27 + (r25 >>> 28);
        int r6 = r5 + (r4 >>> 28);
        int r14 = r13 + (r12 >>> 28);
        int r22 = r21 + (r110 >>> 28);
        int r210 = r29 + (r28 >>> 28);
        int r8 = r7 + (r6 >>> 28);
        int r16 = r15 + (r14 >>> 28);
        int r24 = r23 + (r22 >>> 28);
        int r31 = r34[15] + (r210 >>> 28);
        int r33 = r31 >>> 28;
        int r2 = (r1 & 268435455) + r33;
        int r18 = (r17 & 268435455) + r33;
        int r10 = (r9 & 268435455) + (r8 >>> 28);
        int r111 = r18 + (r16 >>> 28);
        int r26 = (r25 & 268435455) + (r24 >>> 28);
        int r20 = (r4 & 268435455) + (r2 >>> 28);
        int r112 = (r12 & 268435455) + (r10 >>> 28);
        int r113 = (r110 & 268435455) + (r111 >>> 28);
        int r211 = (r28 & 268435455) + (r26 >>> 28);
        r34[0] = r2 & 268435455;
        r34[1] = r20;
        r34[2] = r6 & 268435455;
        r34[3] = r8 & 268435455;
        r34[4] = r10 & 268435455;
        r34[5] = r112;
        r34[6] = r14 & 268435455;
        r34[7] = r16 & 268435455;
        r34[8] = r111 & 268435455;
        r34[9] = r113;
        r34[10] = r22 & 268435455;
        r34[11] = r24 & 268435455;
        r34[12] = r26 & 268435455;
        r34[13] = r211;
        r34[14] = r210 & 268435455;
        r34[15] = r31 & 268435455;
    }

    public static void cmov(int r4, int[] r5, int r6, int[] r7, int r8) {
        int r0 = 0;
    L4:
        if (r0 >= 16) goto L6;
        int r1 = r8 + r0;
        int r2 = r7[r1];
        r7[r1] = r2 ^ ((r5[r6 + r0] ^ r2) & r4);
        r0 = r0 + 1;
        goto L4
    }

    public static void cnegate(int r2, int[] r3) {
        int[] r0 = create();
        sub(r0, r3, r0);
        cmov(-r2, r0, 0, r3, 0);
    }

    public static void copy(int[] r3, int r4, int[] r5, int r6) {
        int r0 = 0;
    L4:
        if (r0 >= 16) goto L6;
        r5[r6 + r0] = r3[r4 + r0];
        r0 = r0 + 1;
        goto L4
    }

    public static int[] create() {
        return new int[16];
    }

    public static int[] createTable(int r0) {
        return new int[r0 * 16];
    }

    public static void decode(int[] r1, int r2, int[] r3) {
        decode224(r1, r2, r3, 0);
        decode224(r1, r2 + 7, r3, 8);
    }

    private static void decode224(int[] r8, int r9, int[] r10, int r11) {
        int r0 = r8[r9 + 0];
        int r1 = r8[r9 + 1];
        int r2 = r8[r9 + 2];
        int r3 = r8[r9 + 3];
        int r4 = r8[r9 + 4];
        int r5 = r8[r9 + 5];
        int r12 = r8[r9 + 6];
        r10[r11 + 0] = r0 & 268435455;
        r10[r11 + 1] = ((r0 >>> 28) | (r1 << 4)) & 268435455;
        r10[r11 + 2] = ((r1 >>> 24) | (r2 << 8)) & 268435455;
        r10[r11 + 3] = ((r2 >>> 20) | (r3 << 12)) & 268435455;
        r10[r11 + 4] = ((r3 >>> 16) | (r4 << 16)) & 268435455;
        r10[r11 + 5] = ((r4 >>> 12) | (r5 << 20)) & 268435455;
        r10[r11 + 6] = ((r5 >>> 8) | (r12 << 24)) & 268435455;
        r10[r11 + 7] = r12 >>> 4;
    }

    public static void encode(int[] r2, byte[] r3, int r4) {
        encode56(r2, 0, r3, r4);
        encode56(r2, 2, r3, r4 + 7);
        encode56(r2, 4, r3, r4 + 14);
        encode56(r2, 6, r3, r4 + 21);
        encode56(r2, 8, r3, r4 + 28);
        encode56(r2, 10, r3, r4 + 35);
        encode56(r2, 12, r3, r4 + 42);
        encode56(r2, 14, r3, r4 + 49);
    }

    public static void encode(int[] r1, int[] r2, int r3) {
        encode224(r1, 0, r2, r3);
        encode224(r1, 8, r2, r3 + 7);
    }

    private static void encode224(int[] r8, int r9, int[] r10, int r11) {
        int r0 = r8[r9 + 0];
        int r1 = r8[r9 + 1];
        int r2 = r8[r9 + 2];
        int r3 = r8[r9 + 3];
        int r4 = r8[r9 + 4];
        int r5 = r8[r9 + 5];
        int r6 = r8[r9 + 6];
        int r12 = r8[r9 + 7];
        r10[r11 + 0] = r0 | (r1 << 28);
        r10[r11 + 1] = (r1 >>> 4) | (r2 << 24);
        r10[r11 + 2] = (r2 >>> 8) | (r3 << 20);
        r10[r11 + 3] = (r3 >>> 12) | (r4 << 16);
        r10[r11 + 4] = (r4 >>> 16) | (r5 << 12);
        r10[r11 + 5] = (r5 >>> 20) | (r6 << 8);
        int r13 = r12 << 4;
        r10[r11 + 6] = r13 | (r6 >>> 24);
    }

    private static void encode24(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) r1;
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >>> 8);
        r2[r4 + 1] = (byte) (r1 >>> 16);
    }

    private static void encode32(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) r1;
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >>> 8);
        int r5 = r4 + 1;
        r2[r5] = (byte) (r1 >>> 16);
        r2[r5 + 1] = (byte) (r1 >>> 24);
    }

    private static void encode56(int[] r1, int r2, byte[] r3, int r4) {
        int r0 = r1[r2];
        int r5 = r1[r2 + 1];
        encode32((r5 << 28) | r0, r3, r4);
        encode24(r5 >>> 4, r3, r4 + 4);
    }

    public static void inv(int[] r3, int[] r4) {
        int[] r0 = create();
        int[] r1 = new int[14];
        copy(r3, 0, r0, 0);
        normalize(r0);
        encode(r0, r1, 0);
        Mod.modOddInverse(P32, r1, r1);
        decode(r1, 0, r4);
    }

    public static void invVar(int[] r3, int[] r4) {
        int[] r0 = create();
        int[] r1 = new int[14];
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
        if (r0 >= 16) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void mul(int[] r36, int r37, int[] r38) {
        int r1 = r36[0];
        int r3 = r36[1];
        int r5 = r36[2];
        int r7 = r36[3];
        int r9 = r36[4];
        int r11 = r36[5];
        int r13 = r36[6];
        int r15 = r36[7];
        int r10 = r36[8];
        int r2 = r36[9];
        int r0 = r36[10];
        int r8 = r36[11];
        int r14 = r36[12];
        int r6 = r36[13];
        int r12 = r36[14];
        int r4 = r36[15];
        long r16 = r3;
        long r17 = r37;
        long r18 = r16 * r17;
        int r19 = ((int) r18) & 268435455;
        long r110 = ((long) r11) * r17;
        int r111 = ((int) r110) & 268435455;
        long r20 = ((long) r2) * r17;
        int r112 = ((int) r20) & 268435455;
        long r21 = ((long) r6) * r17;
        long r22 = (r18 >>> 28) + (((long) r5) * r17);
        r38[2] = ((int) r22) & 268435455;
        long r23 = r22 >>> 28;
        long r113 = (r110 >>> 28) + (((long) r13) * r17);
        r38[6] = ((int) r113) & 268435455;
        long r24 = (r20 >>> 28) + (((long) r0) * r17);
        r38[10] = ((int) r24) & 268435455;
        long r114 = (r21 >>> 28) + (((long) r12) * r17);
        r38[14] = ((int) r114) & 268435455;
        long r25 = r23 + (((long) r7) * r17);
        r38[3] = ((int) r25) & 268435455;
        long r26 = (r113 >>> 28) + (((long) r15) * r17);
        r38[7] = ((int) r26) & 268435455;
        long r27 = (r24 >>> 28) + (((long) r8) * r17);
        r38[11] = ((int) r27) & 268435455;
        long r115 = (r114 >>> 28) + (((long) r4) * r17);
        r38[15] = ((int) r115) & 268435455;
        long r28 = r115 >>> 28;
        long r29 = (r25 >>> 28) + (((long) r9) * r17);
        r38[4] = ((int) r29) & 268435455;
        long r30 = ((r26 >>> 28) + r28) + (((long) r10) * r17);
        r38[8] = ((int) r30) & 268435455;
        long r31 = (r27 >>> 28) + (((long) r14) * r17);
        r38[12] = ((int) r31) & 268435455;
        long r32 = r28 + (((long) r1) * r17);
        r38[0] = ((int) r32) & 268435455;
        r38[1] = r19 + ((int) (r32 >>> 28));
        r38[5] = r111 + ((int) (r29 >>> 28));
        r38[9] = r112 + ((int) (r30 >>> 28));
        r38[13] = (((int) r21) & 268435455) + ((int) (r31 >>> 28));
    }

    public static void mul(int[] r141, int[] r142, int[] r143) {
        int r1 = r141[0];
        int r3 = r141[1];
        int r5 = r141[2];
        int r7 = r141[3];
        int r9 = r141[4];
        int r11 = r141[5];
        int r13 = r141[6];
        int r15 = r141[7];
        int r14 = r141[8];
        int r12 = r141[9];
        int r10 = r141[10];
        int r8 = r141[11];
        int r6 = r141[12];
        int r4 = r141[13];
        int r2 = r141[14];
        int r16 = r141[15];
        int r17 = r142[0];
        int r0 = r142[1];
        int r18 = r142[2];
        int r19 = r142[3];
        int r20 = r142[4];
        int r21 = r142[5];
        int r22 = r142[6];
        int r23 = r142[7];
        int r24 = r142[8];
        int r25 = r142[9];
        int r26 = r142[10];
        int r27 = r142[11];
        int r28 = r142[12];
        int r29 = r142[13];
        int r30 = r142[14];
        int r31 = r142[15];
        int r32 = r1 + r14;
        int r33 = r5 + r10;
        int r34 = r7 + r8;
        int r35 = r9 + r6;
        int r36 = r11 + r4;
        int r37 = r13 + r2;
        int r38 = r17 + r24;
        int r39 = r0 + r25;
        int r40 = r18 + r26;
        int r41 = r19 + r27;
        int r42 = r20 + r28;
        int r43 = r21 + r29;
        int r44 = r22 + r30;
        int r45 = r23 + r31;
        long r46 = r1;
        long r110 = r17;
        long r63 = r46 * r110;
        long r47 = r15;
        long r111 = r0;
        long r69 = r47 * r111;
        long r48 = r13;
        long r112 = r18;
        long r610 = r69 + (r48 * r112);
        long r49 = r11;
        long r113 = r19;
        long r611 = r610 + (r49 * r113);
        long r50 = r9;
        long r114 = r20;
        long r612 = r611 + (r50 * r114);
        long r51 = r7;
        long r115 = r21;
        long r613 = r612 + (r51 * r115);
        long r52 = r5;
        long r116 = r22;
        long r614 = r613 + (r52 * r116);
        long r53 = r3;
        long r117 = r23;
        long r615 = r614 + (r53 * r117);
        long r118 = r14;
        long r54 = r24;
        long r91 = r118 * r54;
        long r119 = r16;
        long r55 = r25;
        long r97 = r119 * r55;
        long r56 = r2;
        long r120 = r26;
        long r98 = r97 + (r56 * r120);
        long r57 = r4;
        long r58 = r27;
        long r99 = r98 + (r57 * r58);
        long r59 = r6;
        long r60 = r28;
        long r910 = r99 + (r59 * r60);
        long r61 = r8;
        long r62 = r29;
        long r911 = r910 + (r61 * r62);
        long r121 = r10;
        long r64 = r30;
        long r912 = r911 + (r121 * r64);
        long r122 = r12;
        long r65 = r31;
        long r913 = r912 + (r122 * r65);
        long r66 = r32;
        long r67 = r38;
        long r109 = r66 * r67;
        long r68 = r15 + r16;
        long r70 = r39;
        long r1110 = r68 * r70;
        long r71 = r37;
        long r72 = r40;
        long r1111 = r1110 + (r71 * r72);
        long r73 = r36;
        long r74 = r41;
        long r1112 = r1111 + (r73 * r74);
        long r75 = r35;
        long r76 = r42;
        long r1113 = r1112 + (r75 * r76);
        long r77 = r34;
        long r78 = r43;
        long r1114 = r1113 + (r77 * r78);
        long r79 = r33;
        long r80 = r44;
        long r1115 = r1114 + (r79 * r80);
        long r81 = r3 + r12;
        long r82 = r45;
        long r1116 = r1115 + (r81 * r82);
        long r83 = ((r63 + r91) + r1116) - r615;
        int r123 = ((int) r83) & 268435455;
        long r84 = r83 >>> 28;
        long r85 = ((r913 + r109) - r63) + r1116;
        int r124 = ((int) r85) & 268435455;
        long r616 = (r53 * r110) + (r46 * r111);
        long r1010 = (((((r119 * r120) + (r56 * r58)) + (r57 * r60)) + (r59 * r62)) + (r61 * r64)) + (r121 * r65);
        long r1117 = (r81 * r67) + (r66 * r70);
        long r127 = (((((r68 * r72) + (r71 * r74)) + (r73 * r76)) + (r75 * r78)) + (r77 * r80)) + (r79 * r82);
        long r86 = r84 + (((r616 + ((r122 * r54) + (r118 * r55))) + r127) - ((((((r47 * r112) + (r48 * r113)) + (r49 * r114)) + (r50 * r115)) + (r51 * r116)) + (r52 * r117)));
        int r125 = ((int) r86) & 268435455;
        long r87 = (r85 >>> 28) + (((r1010 + r1117) - r616) + r127);
        int r126 = ((int) r87) & 268435455;
        long r617 = ((r52 * r110) + (r53 * r111)) + (r46 * r112);
        long r1118 = ((((r119 * r58) + (r56 * r60)) + (r57 * r62)) + (r59 * r64)) + (r61 * r65);
        long r128 = ((r79 * r67) + (r81 * r70)) + (r66 * r72);
        long r129 = ((((r68 * r74) + (r71 * r76)) + (r73 * r78)) + (r75 * r80)) + (r77 * r82);
        long r88 = (r86 >>> 28) + (((r617 + (((r121 * r54) + (r122 * r55)) + (r118 * r120))) + r129) - (((((r47 * r113) + (r48 * r114)) + (r49 * r115)) + (r50 * r116)) + (r51 * r117)));
        int r130 = ((int) r88) & 268435455;
        long r89 = (r87 >>> 28) + (((r1118 + r128) - r617) + r129);
        int r131 = ((int) r89) & 268435455;
        long r1011 = (((r51 * r110) + (r52 * r111)) + (r53 * r112)) + (r46 * r113);
        long r1210 = (((r119 * r60) + (r56 * r62)) + (r57 * r64)) + (r59 * r65);
        long r132 = (((r77 * r67) + (r79 * r70)) + (r81 * r72)) + (r66 * r74);
        long r133 = (((r68 * r76) + (r71 * r78)) + (r73 * r80)) + (r75 * r82);
        long r90 = (r88 >>> 28) + (((r1011 + ((((r61 * r54) + (r121 * r55)) + (r122 * r120)) + (r118 * r58))) + r133) - ((((r47 * r114) + (r48 * r115)) + (r49 * r116)) + (r50 * r117)));
        int r134 = ((int) r90) & 268435455;
        long r92 = (r89 >>> 28) + (((r1210 + r132) - r1011) + r133);
        int r135 = ((int) r92) & 268435455;
        long r1012 = ((((r50 * r110) + (r51 * r111)) + (r52 * r112)) + (r53 * r113)) + (r46 * r114);
        long r1211 = ((r119 * r62) + (r56 * r64)) + (r57 * r65);
        long r136 = ((((r75 * r67) + (r77 * r70)) + (r79 * r72)) + (r81 * r74)) + (r66 * r76);
        long r137 = ((r68 * r78) + (r71 * r80)) + (r73 * r82);
        long r93 = (r90 >>> 28) + (((r1012 + (((((r59 * r54) + (r61 * r55)) + (r121 * r120)) + (r122 * r58)) + (r118 * r60))) + r137) - (((r47 * r115) + (r48 * r116)) + (r49 * r117)));
        int r138 = ((int) r93) & 268435455;
        long r94 = (r92 >>> 28) + (((r1211 + r136) - r1012) + r137);
        int r139 = ((int) r94) & 268435455;
        long r1212 = (((((r49 * r110) + (r50 * r111)) + (r51 * r112)) + (r52 * r113)) + (r53 * r114)) + (r46 * r115);
        long r1310 = (r119 * r64) + (r56 * r65);
        long r1311 = (((((r73 * r67) + (r75 * r70)) + (r77 * r72)) + (r79 * r74)) + (r81 * r76)) + (r66 * r78);
        long r1312 = (r68 * r80) + (r71 * r82);
        long r95 = (r93 >>> 28) + (((r1212 + ((((((r57 * r54) + (r59 * r55)) + (r61 * r120)) + (r121 * r58)) + (r122 * r60)) + (r118 * r62))) + r1312) - ((r47 * r116) + (r48 * r117)));
        int r140 = ((int) r95) & 268435455;
        long r96 = (r94 >>> 28) + (((r1310 + r1311) - r1212) + r1312);
        int r144 = ((int) r96) & 268435455;
        long r1213 = ((((((r48 * r110) + (r49 * r111)) + (r50 * r112)) + (r51 * r113)) + (r52 * r114)) + (r53 * r115)) + (r46 * r116);
        long r1313 = r119 * r65;
        long r1314 = ((((((r71 * r67) + (r73 * r70)) + (r75 * r72)) + (r77 * r74)) + (r79 * r76)) + (r81 * r78)) + (r66 * r80);
        long r1315 = r68 * r82;
        long r100 = (r95 >>> 28) + (((r1213 + (((((((r56 * r54) + (r57 * r55)) + (r59 * r120)) + (r61 * r58)) + (r121 * r60)) + (r122 * r62)) + (r118 * r64))) + r1315) - (r47 * r117));
        int r145 = ((int) r100) & 268435455;
        long r101 = (r96 >>> 28) + (((r1313 + r1314) - r1213) + r1315);
        int r146 = ((int) r101) & 268435455;
        long r618 = (((((((r110 * r47) + (r111 * r48)) + (r49 * r112)) + (r50 * r113)) + (r51 * r114)) + (r52 * r115)) + (r53 * r116)) + (r46 * r117);
        long r310 = (((((((r119 * r54) + (r55 * r56)) + (r57 * r120)) + (r59 * r58)) + (r61 * r60)) + (r121 * r62)) + (r122 * r64)) + (r118 * r65);
        long r102 = (((((((r68 * r67) + (r71 * r70)) + (r73 * r72)) + (r75 * r74)) + (r77 * r76)) + (r79 * r78)) + (r81 * r80)) + (r66 * r82);
        long r103 = (r100 >>> 28) + (r618 + r310);
        long r104 = (r101 >>> 28) + (r102 - r618);
        long r105 = r104 >>> 28;
        long r106 = ((r103 >>> 28) + r105) + ((long) r124);
        long r107 = r105 + ((long) r123);
        r143[0] = ((int) r107) & 268435455;
        r143[1] = r125 + ((int) (r107 >>> 28));
        r143[2] = r130;
        r143[3] = r134;
        r143[4] = r138;
        r143[5] = r140;
        r143[6] = r145;
        r143[7] = ((int) r103) & 268435455;
        r143[8] = ((int) r106) & 268435455;
        r143[9] = r126 + ((int) (r106 >>> 28));
        r143[10] = r131;
        r143[11] = r135;
        r143[12] = r139;
        r143[13] = r144;
        r143[14] = r146;
        r143[15] = ((int) r104) & 268435455;
    }

    public static void negate(int[] r1, int[] r2) {
        sub(create(), r1, r2);
    }

    public static void normalize(int[] r1) {
        reduce(r1, 1);
        reduce(r1, -1);
    }

    public static void one(int[] r3) {
        int r1 = 1;
        r3[0] = 1;
    L4:
        if (r1 >= 16) goto L6;
        r3[r1] = 0;
        r1 = r1 + 1;
        goto L4
    }

    private static void reduce(int[] r13, int r14) {
        int r1 = r13[15];
        int r3 = r1 & 268435455;
        long r5 = (r1 >>> 28) + r14;
        int r15 = 0;
        long r7 = r5;
    L3:
        int r2 = 8;
        if (r15 >= 8) goto L6;
        long r8 = r7 + (4294967295L & ((long) r13[r15]));
        r13[r15] = ((int) r8) & 268435455;
        r7 = r8 >> 28;
        r15 = r15 + 1;
        goto L3
    L6:
        long r9 = r7 + r5;
    L7:
        if (r2 >= 15) goto L9;
        long r10 = r9 + (((long) r13[r2]) & 4294967295L);
        r13[r2] = ((int) r10) & 268435455;
        r9 = r10 >> 28;
        r2 = r2 + 1;
        goto L7
    L9:
        r13[15] = r3 + ((int) r9);
    }

    public static void sqr(int[] r110, int[] r111) {
        int r1 = r110[0];
        int r3 = r110[1];
        int r5 = r110[2];
        int r7 = r110[3];
        int r9 = r110[4];
        int r11 = r110[5];
        int r13 = r110[6];
        int r15 = r110[7];
        int r14 = r110[8];
        int r12 = r110[9];
        int r10 = r110[10];
        int r8 = r110[11];
        int r6 = r110[12];
        int r4 = r110[13];
        int r2 = r110[14];
        int r0 = r110[15];
        int r16 = r1 * 2;
        int r17 = r3 * 2;
        int r18 = r5 * 2;
        int r19 = r7 * 2;
        int r20 = r9 * 2;
        int r21 = r11 * 2;
        int r22 = r13 * 2;
        int r23 = r14 * 2;
        int r24 = r12 * 2;
        int r25 = r10 * 2;
        int r26 = r8 * 2;
        int r27 = r6 * 2;
        int r28 = r4 * 2;
        int r29 = r2 * 2;
        int r30 = r1 + r14;
        int r112 = r3 + r12;
        int r113 = r5 + r10;
        int r114 = r7 + r8;
        int r31 = r9 + r6;
        int r32 = r11 + r4;
        int r33 = r13 + r2;
        int r34 = r15 + r0;
        int r35 = r30 * 2;
        int r36 = r112 * 2;
        int r115 = r113 * 2;
        int r116 = r114 * 2;
        int r117 = r32 * 2;
        long r37 = r1;
        long r38 = r37 * r37;
        long r39 = r15;
        long r118 = r17;
        long r56 = r39 * r118;
        long r119 = r13;
        long r40 = r18;
        long r57 = r56 + (r119 * r40);
        long r120 = r11;
        long r121 = r19;
        long r41 = r9;
        long r58 = (r57 + (r120 * r121)) + (r41 * r41);
        long r42 = r14;
        long r122 = r0;
        long r43 = r24;
        long r70 = r122 * r43;
        long r44 = r2;
        long r45 = r25;
        long r71 = r70 + (r44 * r45);
        long r46 = r4;
        long r47 = r26;
        long r72 = r71 + (r46 * r47);
        long r48 = r6;
        long r49 = r30;
        long r50 = r34;
        long r51 = ((long) r36) & 4294967295L;
        long r84 = r50 * r51;
        long r52 = r33;
        long r53 = ((long) r115) & 4294967295L;
        long r85 = r84 + (r52 * r53);
        long r54 = r32;
        long r123 = ((long) r116) & 4294967295L;
        long r86 = r85 + (r54 * r123);
        long r55 = r31;
        long r87 = r86 + (r55 * r55);
        long r59 = ((r38 + (r42 * r42)) + r87) - r58;
        int r124 = ((int) r59) & 268435455;
        long r60 = (((r72 + (r48 * r48)) + (r49 * r49)) - r38) + r87;
        int r125 = ((int) r60) & 268435455;
        long r61 = r60 >>> 28;
        long r62 = r3;
        long r63 = r16;
        long r510 = r62 * r63;
        long r64 = r20;
        long r73 = ((r39 * r40) + (r119 * r121)) + (r120 * r64);
        long r65 = r12;
        long r66 = r23;
        long r94 = r65 * r66;
        long r96 = (r122 * r45) + (r44 * r47);
        long r126 = r27;
        long r97 = r96 + (r46 * r126);
        long r127 = r112;
        long r67 = ((long) r35) & 4294967295L;
        long r104 = (r50 * r53) + (r52 * r123);
        long r68 = ((long) (r31 * 2)) & 4294967295L;
        long r105 = r104 + (r54 * r68);
        long r69 = (r59 >>> 28) + (((r510 + r94) + r105) - r73);
        int r128 = ((int) r69) & 268435455;
        long r74 = r61 + (((r97 + (r127 * r67)) - r510) + r105);
        int r129 = ((int) r74) & 268435455;
        long r75 = r74 >>> 28;
        long r76 = r5;
        long r77 = (r76 * r63) + (r62 * r62);
        long r88 = ((r39 * r121) + (r119 * r64)) + (r120 * r120);
        long r78 = r10;
        long r95 = (r78 * r66) + (r65 * r65);
        long r410 = ((r122 * r47) + (r44 * r126)) + (r46 * r46);
        long r79 = r113;
        long r102 = (r79 * r67) + (r127 * r127);
        long r130 = ((r50 * r123) + (r52 * r68)) + (r54 * r54);
        long r131 = (r69 >>> 28) + (((r77 + r95) + r130) - r88);
        int r132 = ((int) r131) & 268435455;
        long r133 = r75 + (((r410 + r102) - r77) + r130);
        int r134 = ((int) r133) & 268435455;
        long r135 = r7;
        long r136 = (r135 * r63) + (r76 * r118);
        long r137 = r21;
        long r511 = (r39 * r64) + (r119 * r137);
        long r138 = r8;
        long r90 = (r138 * r66) + (r78 * r43);
        long r139 = r28;
        long r98 = (r122 * r126) + (r44 * r139);
        long r140 = r114;
        long r411 = (r140 * r67) + (r79 * r51);
        long r80 = r68 * r50;
        long r81 = ((long) r117) & 4294967295L;
        long r82 = r80 + (r52 * r81);
        long r141 = (r131 >>> 28) + (((r136 + r90) + r82) - r511);
        int r83 = ((int) r141) & 268435455;
        long r89 = (r133 >>> 28) + (((r98 + r411) - r136) + r82);
        int r91 = ((int) r89) & 268435455;
        long r142 = ((r41 * r63) + (r135 * r118)) + (r76 * r76);
        long r412 = ((r48 * r66) + (r138 * r43)) + (r78 * r78);
        long r512 = ((r55 * r67) + (r140 * r51)) + (r79 * r79);
        long r92 = (r50 * r81) + (r52 * r52);
        long r143 = (r141 >>> 28) + (((r142 + r412) + r92) - ((r39 * r137) + (r119 * r119)));
        int r93 = ((int) r143) & 268435455;
        long r99 = (r89 >>> 28) + (((((r122 * r139) + (r44 * r44)) + r512) - r142) + r92);
        int r100 = ((int) r99) & 268435455;
        long r144 = ((r120 * r63) + (r41 * r118)) + (r135 * r40);
        long r310 = ((r46 * r66) + (r48 * r43)) + (r138 * r45);
        long r413 = ((r54 * r67) + (r55 * r51)) + (r140 * r53);
        long r145 = (((long) (r33 * 2)) & 4294967295L) * r50;
        long r146 = (r143 >>> 28) + (((r144 + r310) + r145) - (((long) r22) * r39));
        long r101 = (r99 >>> 28) + ((((((long) r29) * r122) + r413) - r144) + r145);
        int r103 = ((int) r101) & 268435455;
        long r147 = (((r119 * r63) + (r120 * r118)) + (r41 * r40)) + (r135 * r135);
        long r414 = r50 * r50;
        long r106 = (r146 >>> 28) + (((r147 + ((((r44 * r66) + (r46 * r43)) + (r48 * r45)) + (r138 * r138))) + r414) - (r39 * r39));
        int r107 = ((int) r106) & 268435455;
        long r108 = (r101 >>> 28) + ((((r122 * r122) + ((((r52 * r67) + (r54 * r51)) + (r55 * r53)) + (r140 * r140))) - r147) + r414);
        int r148 = ((int) r108) & 268435455;
        long r149 = (((r39 * r63) + (r119 * r118)) + (r120 * r40)) + (r41 * r121);
        long r109 = (r106 >>> 28) + (((((r66 * r122) + (r44 * r43)) + (r46 * r45)) + (r48 * r47)) + r149);
        int r150 = ((int) r109) & 268435455;
        long r151 = (r108 >>> 28) + (((((r67 * r50) + (r52 * r51)) + (r54 * r53)) + (r55 * r123)) - r149);
        int r152 = ((int) r151) & 268435455;
        long r153 = r151 >>> 28;
        long r154 = ((r109 >>> 28) + r153) + ((long) r125);
        long r155 = r153 + ((long) r124);
        r111[0] = ((int) r155) & 268435455;
        r111[1] = r128 + ((int) (r155 >>> 28));
        r111[2] = r132;
        r111[3] = r83;
        r111[4] = r93;
        r111[5] = ((int) r146) & 268435455;
        r111[6] = r107;
        r111[7] = r150;
        r111[8] = ((int) r154) & 268435455;
        r111[9] = r129 + ((int) (r154 >>> 28));
        r111[10] = r134;
        r111[11] = r91;
        r111[12] = r100;
        r111[13] = r103;
        r111[14] = r148;
        r111[15] = r152;
    }

    public static void sub(int[] r49, int[] r50, int[] r51) {
        int r1 = r49[0];
        int r3 = r49[1];
        int r5 = r49[2];
        int r7 = r49[3];
        int r9 = r49[4];
        int r11 = r49[5];
        int r13 = r49[6];
        int r15 = r49[7];
        int r17 = r49[8];
        int r19 = r49[9];
        int r21 = r49[10];
        int r23 = r49[11];
        int r25 = r49[12];
        int r27 = r49[13];
        int r29 = r49[14];
        int r31 = r49[15];
        int r32 = r50[0];
        int r33 = r50[1];
        int r34 = r50[2];
        int r35 = r50[3];
        int r36 = r50[4];
        int r37 = r50[5];
        int r38 = r50[6];
        int r39 = r50[7];
        int r40 = r50[8];
        int r41 = r50[9];
        int r42 = r50[10];
        int r43 = r50[11];
        int r44 = r50[12];
        int r45 = r50[13];
        int r46 = r50[14];
        int r2 = (r1 + 536870910) - r32;
        int r4 = (r3 + 536870910) - r33;
        int r12 = (r11 + 536870910) - r37;
        int r110 = (r19 + 536870910) - r41;
        int r28 = (r27 + 536870910) - r45;
        int r310 = r31 + 536870910;
        int r6 = ((r5 + 536870910) - r34) + (r4 >>> 28);
        int r14 = ((r13 + 536870910) - r38) + (r12 >>> 28);
        int r22 = ((r21 + 536870910) - r42) + (r110 >>> 28);
        int r210 = ((r29 + 536870910) - r46) + (r28 >>> 28);
        int r8 = ((r7 + 536870910) - r35) + (r6 >>> 28);
        int r16 = ((r15 + 536870910) - r39) + (r14 >>> 28);
        int r24 = ((r23 + 536870910) - r43) + (r22 >>> 28);
        int r311 = (r310 - r50[15]) + (r210 >>> 28);
        int r312 = r311 >>> 28;
        int r10 = r2 + r312;
        int r18 = ((r17 + 536870908) - r40) + r312;
        int r20 = ((r9 + 536870910) - r36) + (r8 >>> 28);
        int r111 = r18 + (r16 >>> 28);
        int r26 = ((r25 + 536870910) - r44) + (r24 >>> 28);
        int r30 = (r4 & 268435455) + (r10 >>> 28);
        int r112 = (r12 & 268435455) + (r20 >>> 28);
        int r113 = (r110 & 268435455) + (r111 >>> 28);
        int r211 = (r28 & 268435455) + (r26 >>> 28);
        r51[0] = r10 & 268435455;
        r51[1] = r30;
        r51[2] = r6 & 268435455;
        r51[3] = r8 & 268435455;
        r51[4] = r20 & 268435455;
        r51[5] = r112;
        r51[6] = r14 & 268435455;
        r51[7] = r16 & 268435455;
        r51[8] = r111 & 268435455;
        r51[9] = r113;
        r51[10] = r22 & 268435455;
        r51[11] = r24 & 268435455;
        r51[12] = r26 & 268435455;
        r51[13] = r211;
        r51[14] = r210 & 268435455;
        r51[15] = r311 & 268435455;
    }

    public static void subOne(int[] r3) {
        int[] r0 = create();
        r0[0] = 1;
        sub(r3, r0, r3);
    }

    public static void zero(int[] r3) {
        int r1 = 0;
    L4:
        if (r1 >= 16) goto L6;
        r3[r1] = 0;
        r1 = r1 + 1;
        goto L4
    }
}
