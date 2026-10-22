package org.bouncycastle.pqc.crypto.cmce;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes7.dex */
class CMCEEngine {
    private int COND_BYTES;
    private int GFBITS;
    private int GFMASK;
    private int IRR_BYTES;
    private int PK_NCOLS;
    private int PK_NROWS;
    private int PK_ROW_BYTES;
    private int SYND_BYTES;
    private int SYS_N;
    private int SYS_T;
    private BENES benes;
    private boolean countErrorIndices;
    private final int defaultKeySize;
    private GF gf;
    private int[] poly;
    private boolean usePadding;
    private boolean usePivots;

    public CMCEEngine(int r1, int r2, int r3, int[] r4, boolean r5, int r6) {
        this.usePivots = r5;
        this.SYS_N = r2;
        this.SYS_T = r3;
        this.GFBITS = r1;
        this.poly = r4;
        this.defaultKeySize = r6;
        this.IRR_BYTES = r3 * 2;
        boolean r7 = true;
        this.COND_BYTES = (1 << (r1 - 4)) * ((r1 * 2) - 1);
        int r8 = r3 * r1;
        this.PK_NROWS = r8;
        int r9 = r2 - r8;
        this.PK_NCOLS = r9;
        this.PK_ROW_BYTES = (r9 + 7) / 8;
        this.SYND_BYTES = (r8 + 7) / 8;
        this.GFMASK = (1 << r1) - 1;
        if (r1 != 12) goto L5;
        this.gf = new GF12(this.GFBITS);
        BENES r10 = new BENES12(this.SYS_N, this.SYS_T, this.GFBITS);
    L6:
        this.benes = r10;
        if ((this.SYS_T % 8) == 0) goto L9;
        boolean r11 = true;
    L10:
        this.usePadding = r11;
        if ((1 << this.GFBITS) > this.SYS_N) goto L14;
        r7 = false;
    L14:
        this.countErrorIndices = r7;
        return;
    L9:
        r11 = false;
        goto L10
    L5:
        this.gf = new GF13(this.GFBITS);
        r10 = new BENES13(this.SYS_N, this.SYS_T, this.GFBITS);
        goto L6
    }

    private static int ctz(long r7) {
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0 >= 64) goto L6;
        int r3 = (int) ((r7 >> r0) & 1);
        r2 = r2 | r3;
        r1 = r1 + ((r3 ^ 1) & (r2 ^ 1));
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    private short eval(short[] r5, short r6) {
        int r0 = this.SYS_T;
        short r1 = r5[r0];
        int r2 = r0 - 1;
    L3:
        if (r2 < 0) goto L5;
        r1 = this.gf.gf_add(this.gf.gf_mul(r1, r6), r5[r2]);
        r2 = r2 - 1;
        goto L3
    L5:
        return r1;
    }

    private int mov_columns(byte[][] r27, short[] r28, long[] r29) {
        long[] r2 = new long[64];
        int r3 = 32;
        long[] r4 = new long[32];
        byte[] r6 = new byte[9];
        int r7 = this.PK_NROWS - 32;
        int r8 = r7 / 8;
        int r9 = r7 % 8;
        if (this.usePadding == false) goto L13;
        int r10 = 0;
    L5:
        if (r10 >= 32) goto L16;
        int r13 = 0;
    L7:
        if (r13 >= 9) goto L9;
        r6[r13] = r27[r7 + r10][r8 + r13];
        r13 = r13 + 1;
        goto L7
    L9:
        int r14 = 0;
    L10:
        if (r14 >= 8) goto L12;
        int r15 = r14 + 1;
        r6[r14] = (byte) (((r6[r14] & 255) >> r9) | (r6[r15] << (8 - r9)));
        r14 = r15;
        goto L10
    L12:
        r2[r10] = Utils.load8(r6, 0);
        r10 = r10 + 1;
    L16:
        long r16 = 0;
        r29[0] = 0;
        int r11 = 0;
    L18:
        if (r11 >= 32) goto L33;
        long r17 = r2[r11];
        int r19 = r11 + 1;
        int r12 = r19;
    L20:
        if (r12 >= 32) goto L23;
        r17 = r17 | r2[r12];
        r12 = r12 + 1;
        goto L20
    L23:
        if (r17 == r16) goto L24;
        int r18 = ctz(r17);
        r4[r11] = r18;
        byte[] r21 = r6;
        r29[0] = (1 << ((int) r4[r11])) | r29[0];
        int r5 = r19;
    L27:
        if (r5 >= 32) goto L29;
        r2[r11] = r2[r11] ^ (r2[r5] & (((r2[r11] >> r18) & 1) - 1));
        r5 = r5 + 1;
        goto L27
    L29:
        int r20 = r19;
    L30:
        if (r20 >= 32) goto L32;
        r2[r20] = r2[r20] ^ (r2[r11] & (-((r2[r20] >> r18) & 1)));
        r20 = r20 + 1;
        goto L30
    L32:
        r11 = r19;
        r6 = r21;
        r16 = 0;
        goto L18
    L24:
        return -1;
    L33:
        byte[] r22 = r6;
        int r23 = 0;
    L34:
        if (r23 >= 32) goto L39;
        int r24 = r23 + 1;
        int r25 = r24;
    L36:
        if (r25 >= 64) goto L38;
        int r110 = r7 + r23;
        int r111 = r7 + r25;
        long r112 = ((long) (r28[r110] ^ r28[r111])) & same_mask64((short) r25, (short) r4[r23]);
        r28[r110] = (short) (((long) r28[r110]) ^ r112);
        r28[r111] = (short) (((long) r28[r111]) ^ r112);
        r25 = r25 + 1;
        goto L36
    L38:
        r23 = r24;
        goto L34
    L39:
        int r1 = 0;
    L41:
        if (r1 >= this.PK_NROWS) goto L63;
        if (this.usePadding == false) goto L51;
        int r113 = 0;
    L45:
        if (r113 >= 9) goto L47;
        r22[r113] = r27[r1][r8 + r113];
        r113 = r113 + 1;
        goto L45
    L47:
        int r114 = 0;
    L48:
        if (r114 >= 8) goto L50;
        int r26 = r114 + 1;
        r22[r114] = (byte) (((r22[r114] & 255) >> r9) | (r22[r26] << (8 - r9)));
        r114 = r26;
        goto L48
    L50:
        byte[] r30 = r22;
        long r115 = Utils.load8(r30, 0);
    L52:
        int r31 = 0;
    L53:
        if (r31 >= r3) goto L56;
        long r32 = ((r115 >> ((int) r4[r31])) ^ (r115 >> r31)) & 1;
        r115 = (r115 ^ (r32 << ((int) r4[r31]))) ^ (r32 << r31);
        r31 = r31 + 1;
        r3 = 32;
        goto L53
    L56:
        if (this.usePadding == false) goto L61;
        Utils.store8(r30, 0, r115);
        int r33 = r8 + 8;
        int r116 = 7;
        int r117 = 8 - r9;
        r27[r1][r33] = (byte) ((((r27[r1][r33] & 255) >>> r9) << r9) | ((r30[7] & 255) >>> r117));
        r27[r1][r8 + 0] = (byte) (((r30[0] & 255) << r9) | (((r27[r1][r8] & 255) << r117) >>> r117));
    L59:
        if (r116 < 1) goto L62;
        r27[r1][r8 + r116] = (byte) (((r30[r116] & 255) << r9) | ((r30[r116 - 1] & 255) >>> r117));
        r116 = r116 - 1;
    L62:
        r1 = r1 + 1;
        r22 = r30;
        r3 = 32;
        goto L41
    L61:
        Utils.store8(r27[r1], r8, r115);
        goto L62
    L51:
        r30 = r22;
        r115 = Utils.load8(r27[r1], r8);
        goto L52
    L63:
        return 0;
    L13:
        int r118 = 0;
    L14:
        if (r118 >= 32) goto L16;
        r2[r118] = Utils.load8(r27[r7 + r118], r8);
        r118 = r118 + 1;
        goto L14
    }

    private int pk_gen(byte[] r18, byte[] r19, int[] r20, short[] r21, long[] r22) {
        int r2 = this.SYS_T;
        short[] r3 = new short[r2 + 1];
        r3[r2] = 1;
        int r5 = 0;
    L4:
        if (r5 >= this.SYS_T) goto L6;
        r3[r5] = Utils.load_gf(r19, (r5 * 2) + 40, this.GFMASK);
        r5 = r5 + 1;
        goto L4
    L6:
        int r6 = 1 << this.GFBITS;
        long[] r7 = new long[r6];
        int r8 = 0;
    L8:
        if (r8 >= (1 << this.GFBITS)) goto L10;
        r7[r8] = r20[r8];
        r7[r8] = r7[r8] << 31;
        r7[r8] = r7[r8] | ((long) r8);
        r7[r8] = r7[r8] & Long.MAX_VALUE;
        r8 = r8 + 1;
        goto L8
    L10:
        sort64(r7, 0, r6);
        int r9 = 1;
    L12:
        if (r9 >= (1 << this.GFBITS)) goto L17;
        if ((r7[r9 - 1] >> 31) == (r7[r9] >> 31)) goto L15;
        r9 = r9 + 1;
        goto L12
    L15:
        return -1;
    L17:
        short[] r10 = new short[this.SYS_N];
        int r11 = 0;
    L19:
        if (r11 >= (1 << this.GFBITS)) goto L21;
        r21[r11] = (short) (r7[r11] & ((long) this.GFMASK));
        r11 = r11 + 1;
        goto L19
    L21:
        int r12 = 0;
    L22:
        int r13 = this.SYS_N;
        if (r12 >= r13) goto L25;
        r10[r12] = Utils.bitrev(r21[r12], this.GFBITS);
        r12 = r12 + 1;
        goto L22
    L25:
        short[] r14 = new short[r13];
        root(r14, r3, r10);
        int r4 = 0;
    L26:
        int r15 = this.SYS_N;
        if (r4 >= r15) goto L29;
        r14[r4] = this.gf.gf_inv(r14[r4]);
        r4 = r4 + 1;
        goto L26
    L29:
        byte[][] r16 = (byte[][]) Array.newInstance(byte.class, new int[]{this.PK_NROWS, r15 / 8});
        int r17 = 0;
    L31:
        if (r17 >= this.PK_NROWS) goto L37;
        int r110 = 0;
    L34:
        if (r110 >= (this.SYS_N / 8)) goto L36;
        r16[r17][r110] = 0;
        r110 = r110 + 1;
        goto L34
    L36:
        r17 = r17 + 1;
        goto L31
    L37:
        int r23 = 0;
    L39:
        if (r23 >= this.SYS_T) goto L53;
        int r111 = 0;
    L42:
        if (r111 >= this.SYS_N) goto L48;
        int r112 = 0;
    L44:
        int r113 = this.GFBITS;
        if (r112 >= r113) goto L47;
        r16[(r113 * r23) + r112][r111 / 8] = (byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) ((r14[r111 + 7] >>> r112) & 1)) << 1)) | ((r14[r111 + 6] >>> r112) & 1))) << 1)) | ((r14[r111 + 5] >>> r112) & 1))) << 1)) | ((r14[r111 + 4] >>> r112) & 1))) << 1)) | ((r14[r111 + 3] >>> r112) & 1))) << 1)) | ((r14[r111 + 2] >>> r112) & 1))) << 1)) | ((r14[r111 + 1] >>> r112) & 1))) << 1)) | ((r14[r111 + 0] >>> r112) & 1));
        r112 = r112 + 1;
        goto L44
    L47:
        r111 = r111 + 8;
        goto L42
    L48:
        int r114 = 0;
    L50:
        if (r114 >= this.SYS_N) goto L52;
        r14[r114] = this.gf.gf_mul(r14[r114], r10[r114]);
        r114 = r114 + 1;
        goto L50
    L52:
        r23 = r23 + 1;
        goto L39
    L53:
        int r24 = 0;
    L54:
        int r25 = this.PK_NROWS;
        if (r24 >= ((r25 + 7) / 8)) goto L91;
        int r26 = 0;
    L57:
        if (r26 >= 8) goto L90;
        int r27 = (r24 * 8) + r26;
        int r115 = this.PK_NROWS;
        if (r27 >= r115) goto L90;
        if (this.usePivots == false) goto L69;
        if (r27 != (r115 - 32)) goto L69;
        if (mov_columns(r16, r21, r22) == 0) goto L69;
        return -1;
    L69:
        int r116 = r27 + 1;
    L71:
        if (r116 >= this.PK_NROWS) goto L78;
        byte r117 = (byte) (-((byte) (((byte) (((byte) (r16[r27][r24] ^ r16[r116][r24])) >> r26)) & 1)));
        int r118 = 0;
    L74:
        if (r118 >= (this.SYS_N / 8)) goto L76;
        byte[] r119 = r16[r27];
        r119[r118] = (byte) (r119[r118] ^ (r16[r116][r118] & r117));
        r118 = r118 + 1;
        goto L74
    L76:
        r116 = r116 + 1;
        goto L71
    L78:
        if (((r16[r27][r24] >> r26) & 1) == 0) goto L79;
        int r120 = 0;
    L82:
        if (r120 >= this.PK_NROWS) goto L89;
        if (r120 == r27) goto L88;
        byte r121 = (byte) (-((byte) (((byte) (r16[r120][r24] >> r26)) & 1)));
        int r122 = 0;
    L86:
        if (r122 >= (this.SYS_N / 8)) goto L88;
        byte[] r123 = r16[r120];
        r123[r122] = (byte) (r123[r122] ^ (r16[r27][r122] & r121));
        r122 = r122 + 1;
    L88:
        r120 = r120 + 1;
        goto L82
    L89:
        r26 = r26 + 1;
        goto L57
    L79:
        return -1;
    L90:
        r24 = r24 + 1;
        goto L54
    L91:
        if (r18 != null) goto L93;
    L110:
        return 0;
    L93:
        if (this.usePadding == false) goto L102;
        int r28 = r25 % 8;
        int r1 = 0;
        int r29 = 0;
    L95:
        int r30 = this.PK_NROWS;
        if (r1 >= r30) goto L110;
        int r31 = (r30 - 1) / 8;
    L99:
        if (r31 >= ((this.SYS_N / 8) - 1)) goto L101;
        int r124 = (r16[r1][r31] & 255) >>> r28;
        r31 = r31 + 1;
        r18[r29] = (byte) (r124 | (r16[r1][r31] << (8 - r28)));
        r29 = r29 + 1;
        goto L99
    L101:
        r18[r29] = (byte) ((r16[r1][r31] & 255) >>> r28);
        r1 = r1 + 1;
        r29 = r29 + 1;
        goto L95
    L102:
        int r32 = 0;
    L104:
        if (r32 >= this.PK_NROWS) goto L110;
        int r33 = 0;
        int r34 = 0;
    L106:
        int r35 = this.SYS_N;
        int r36 = this.PK_NROWS;
        if (r33 >= (((r35 - r36) + 7) / 8)) goto L109;
        r18[((((r35 - r36) + 7) / 8) * r32) + r34] = r16[r32][(r36 / 8) + r33];
        r34 = r34 + 1;
        r33 = r33 + 1;
        goto L106
    L109:
        r32 = r32 + 1;
        goto L104
    }

    private void root(short[] r3, short[] r4, short[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.SYS_N) goto L6;
        r3[r0] = eval(r4, r5[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private static long same_mask64(short r2, short r3) {
        return -((((long) (r2 ^ r3)) - 1) >>> 63);
    }

    private static void sort64(long[] r16, int r17, int r18) {
        int r0 = r18 - r17;
        if (r0 >= 2) goto L5;
        return;
    L5:
        int r1 = 1;
    L7:
        if (r1 >= (r0 - r1)) goto L9;
        r1 = r1 + r1;
        goto L7
    L9:
        int r2 = r1;
    L10:
        if (r2 <= 0) goto L31;
        int r3 = 0;
        int r4 = 0;
    L13:
        if (r4 >= (r0 - r2)) goto L18;
        if ((r4 & r2) != 0) goto L17;
        int r5 = r17 + r4;
        int r7 = r5 + r2;
        long r8 = (-((r16[r7] - r16[r5]) >>> 63)) & (r16[r5] ^ r16[r7]);
        r16[r5] = r16[r5] ^ r8;
        r16[r7] = r16[r7] ^ r8;
    L17:
        r4 = r4 + 1;
        goto L13
    L18:
        int r6 = r1;
    L19:
        if (r6 <= r2) goto L30;
    L21:
        if (r3 >= (r0 - r6)) goto L29;
        if ((r3 & r2) != 0) goto L28;
        int r9 = r17 + r3;
        int r10 = r9 + r2;
        long r11 = r16[r10];
        int r12 = r6;
    L25:
        if (r12 <= r2) goto L27;
        int r13 = r9 + r12;
        long r14 = (-((r16[r13] - r11) >>> 63)) & (r16[r13] ^ r11);
        r11 = r11 ^ r14;
        r16[r13] = r14 ^ r16[r13];
        r12 = r12 >>> 1;
        goto L25
    L27:
        r16[r10] = r11;
    L28:
        r3 = r3 + 1;
        goto L21
    L29:
        r6 = r6 >>> 1;
        goto L19
    L30:
        r2 = r2 >>> 1;
        goto L10
    }

    public byte[] generate_public_key_from_private_key(byte[] r12) {
        byte[] r0 = new byte[getPublicKeySize()];
        int r1 = this.GFBITS;
        short[] r5 = new short[1 << r1];
        int r7 = 0;
        long[] r6 = {0};
        int[] r4 = new int[1 << r1];
        int r3 = (this.SYS_N / 8) + ((1 << r1) * 4);
        byte[] r8 = new byte[r3];
        int r9 = ((r3 - 32) - this.IRR_BYTES) - ((1 << r1) * 4);
        SHAKEDigest r2 = new SHAKEDigest(256);
        r2.update((byte) 64);
        r2.update(r12, 0, 32);
        r2.doFinal(r8, 0, r3);
    L4:
        if (r7 >= (1 << this.GFBITS)) goto L6;
        r4[r7] = Utils.load4(r8, (r7 * 4) + r9);
        r7 = r7 + 1;
        goto L4
    L6:
        pk_gen(r0, r12, r4, r5, r6);
        return r0;
    }

    public int getPublicKeySize() {
        if (this.usePadding == false) goto L7;
        int r0 = this.PK_NROWS;
        return r0 * ((this.SYS_N / 8) - ((r0 - 1) / 8));
    L7:
        return (this.PK_NROWS * this.PK_NCOLS) / 8;
    }
}
