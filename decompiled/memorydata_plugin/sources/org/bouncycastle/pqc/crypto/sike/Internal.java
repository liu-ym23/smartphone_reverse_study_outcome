package org.bouncycastle.pqc.crypto.sike;

import java.lang.reflect.Array;
import java.util.Properties;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
abstract class Internal {
    protected int ALICE;
    protected long[] A_basis_zero;
    protected long[] A_gen;
    protected long[] Alice_order;
    protected int BOB;
    protected long[] B_basis_zero;
    protected long[] B_gen;
    protected long[] B_gen_3_tors;
    protected long[] Bob_order;
    protected boolean COMPRESS;
    protected int COMPRESSED_CHUNK_CT;
    protected int CRYPTO_BYTES;
    protected int CRYPTO_CIPHERTEXTBYTES;
    protected int CRYPTO_PUBLICKEYBYTES;
    protected int CRYPTO_SECRETKEYBYTES;
    protected int DLEN_2;
    protected int DLEN_3;
    protected int ELL2_EMODW;
    protected int ELL2_W;
    protected int ELL3_EMODW;
    protected int ELL3_W;
    protected int FP2_ENCODED_BYTES;
    protected int MASK2_BOB;
    protected int MASK3_BOB;
    protected int MASK_ALICE;
    protected int MASK_BOB;
    protected int MAXBITS_FIELD;
    protected int MAXBITS_ORDER;
    protected int MAXWORDS_FIELD;
    protected int MAX_Alice;
    protected int MAX_Bob;
    protected int MAX_INT_POINTS_ALICE;
    protected int MAX_INT_POINTS_BOB;
    protected int MSG_BYTES;
    protected long[] Montgomery_R;
    protected long[] Montgomery_R2;
    protected long[] Montgomery_RB1;
    protected long[] Montgomery_RB2;
    protected long[] Montgomery_one;
    protected int NBITS_FIELD;
    protected int NBITS_ORDER;
    protected int NWORDS64_FIELD;
    protected int NWORDS64_ORDER;
    protected int NWORDS_FIELD;
    protected int NWORDS_ORDER;
    protected int OALICE_BITS;
    protected int OBOB_BITS;
    protected int OBOB_EXPON;
    protected int ORDER_A_ENCODED_BYTES;
    protected int ORDER_B_ENCODED_BYTES;
    protected int PARAM_A;
    protected int PARAM_C;
    protected int PARTIALLY_COMPRESSED_CHUNK_CT;
    protected int PLEN_2;
    protected int PLEN_3;
    protected long[] PRIME;
    protected int PRIME_ZERO_WORDS;
    protected long[] PRIMEp1;
    protected long[] PRIMEp1x64;
    protected long[] PRIMEx16p;
    protected long[] PRIMEx2;
    protected long[] PRIMEx4;
    protected int SECRETKEY_A_BYTES;
    protected int SECRETKEY_B_BYTES;
    protected int TABLE_R_LEN;
    protected int TABLE_V3_LEN;
    protected int TABLE_V_LEN;
    protected long[] T_tate2_P;
    protected long[] T_tate2_Q;
    protected long[] T_tate2_firststep_P;
    protected long[] T_tate2_firststep_Q;
    protected long[] T_tate3;
    protected int UNCOMPRESSEDPK_BYTES;
    protected int W_2;
    protected int W_3;
    protected long[] XQB3;
    protected long[] g_R_S_im;
    protected long[] g_phiR_phiS_im;
    protected long[] g_phiR_phiS_re;
    protected long[] ph2_T;
    protected long[] ph2_T1;
    protected long[] ph2_T2;
    protected int[] ph2_path;
    protected long[] ph3_T;
    protected long[] ph3_T1;
    protected long[] ph3_T2;
    protected int[] ph3_path;
    protected int[] strat_Alice;
    protected int[] strat_Bob;
    protected long[][] table_r_qnr;
    protected long[][] table_r_qr;
    protected long[][] table_v_qnr;
    protected long[][] table_v_qr;
    protected long[] threeinv;
    protected long[] u0_entang;
    protected long[] u_entang;
    protected long[][][] v_3_torsion;

    Internal() {
    }

    public static long[] ReadFromProperty(Properties r2, String r3, int r4) {
        byte[] r5 = Hex.decode(r2.getProperty(r3).replaceAll(",", ""));
        long[] r6 = new long[r4];
        int r7 = 0;
    L4:
        if (r7 >= (r5.length / 8)) goto L6;
        r6[r7] = Pack.bigEndianToLong(r5, r7 * 8);
        r7 = r7 + 1;
        goto L4
    L6:
        return r6;
    }

    public static long[][] ReadFromProperty(Properties r4, String r5, int r6, int r7) {
        byte[] r8 = Hex.decode(r4.getProperty(r5).replaceAll(",", ""));
        int r0 = 0;
        long[][] r9 = (long[][]) Array.newInstance(long.class, new int[]{r6, r7});
    L4:
        if (r0 >= (r8.length / 8)) goto L6;
        r9[r0 / r7][r0 % r7] = Pack.bigEndianToLong(r8, r0 * 8);
        r0 = r0 + 1;
        goto L4
    L6:
        return r9;
    }

    public static long[][][] ReadFromProperty(Properties r5, String r6, int r7, int r8, int r9) {
        byte[] r10 = Hex.decode(r5.getProperty(r6).replaceAll(",", ""));
        int r0 = 0;
        long[][][] r11 = (long[][][]) Array.newInstance(long.class, new int[]{r7, r8, r9});
    L4:
        if (r0 >= (r10.length / 8)) goto L6;
        int r12 = r8 * r9;
        r11[r0 / r12][(r0 % r12) / r9][r0 % r9] = Pack.bigEndianToLong(r10, r0 * 8);
        r0 = r0 + 1;
        goto L4
    L6:
        return r11;
    }

    public static int[] ReadIntsFromProperty(Properties r1, String r2, int r3) {
        int[] r4 = new int[r3];
        String[] r5 = r1.getProperty(r2).split(",");
        int r6 = 0;
    L4:
        if (r6 == r5.length) goto L6;
        r4[r6] = Integer.parseInt(r5[r6]);
        r6 = r6 + 1;
        goto L4
    L6:
        return r4;
    }
}
