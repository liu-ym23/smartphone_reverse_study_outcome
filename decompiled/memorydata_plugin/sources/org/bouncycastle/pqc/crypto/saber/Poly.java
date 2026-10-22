package org.bouncycastle.pqc.crypto.saber;

/* JADX INFO: loaded from: classes7.dex */
class Poly {
    private static int SCHB_N = 16;
    private final int N_RES;
    private final int N_SB;
    private final int N_SB_RES;
    private final int SABER_L;
    private final int SABER_N;
    private final SABEREngine engine;
    private final Utils utils;

    static {
    }

    public Poly(SABEREngine r3) {
        this.engine = r3;
        this.SABER_L = r3.getSABER_L();
        int r0 = r3.getSABER_N();
        this.SABER_N = r0;
        this.N_RES = r0 << 1;
        int r1 = r0 >> 2;
        this.N_SB = r1;
        this.N_SB_RES = (r1 * 2) - 1;
        this.utils = r3.getUtils();
    }
}
