package org.bouncycastle.pqc.crypto.hqc;

import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes7.dex */
class HQCEngine {
    private byte G_FCT_DOMAIN;
    private byte H_FCT_DOMAIN;
    private int K_BYTE;
    private int K_BYTE_64;
    private byte K_FCT_DOMAIN;
    private int N1N2_BYTE;
    private int N1N2_BYTE_64;
    private int N1_BYTE;
    private int N1_BYTE_64;
    private int N_BYTE;
    private int N_BYTE_64;
    private int SEED_SIZE;
    private int SHA512_BYTES;
    private int delta;
    private int fft;
    private GF2mField field;
    private int g;
    private int[] generatorPoly;
    private int k;
    private int mulParam;
    private int n;
    private int n1;
    private int n1n2;
    private int n2;
    private PolynomialGF2mSmallM reductionPoly;
    private int rejectionThreshold;
    private int w;
    private int we;
    private int wr;

    public HQCEngine(int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int[] r13) {
        this.SEED_SIZE = 40;
        this.G_FCT_DOMAIN = 3;
        this.H_FCT_DOMAIN = 4;
        this.K_FCT_DOMAIN = 5;
        this.SHA512_BYTES = 64;
        this.n = r2;
        this.k = r5;
        this.delta = r7;
        this.w = r8;
        this.wr = r9;
        this.we = r10;
        this.n1 = r3;
        this.n2 = r4;
        int r14 = r3 * r4;
        this.n1n2 = r14;
        this.generatorPoly = r13;
        this.g = r6;
        this.rejectionThreshold = r11;
        this.fft = r12;
        this.mulParam = (int) Math.ceil(r4 / 128);
        this.N_BYTE = Utils.getByteSizeFromBitSize(r2);
        this.K_BYTE = r5;
        this.N_BYTE_64 = Utils.getByte64SizeFromBitSize(r2);
        this.K_BYTE_64 = Utils.getByteSizeFromBitSize(r5);
        this.N1_BYTE_64 = Utils.getByteSizeFromBitSize(r3);
        this.N1N2_BYTE_64 = Utils.getByte64SizeFromBitSize(r14);
        this.N1N2_BYTE = Utils.getByteSizeFromBitSize(r14);
        this.N1_BYTE = Utils.getByteSizeFromBitSize(r3);
        GF2mField r15 = new GF2mField(1);
        this.field = r15;
        this.reductionPoly = new PolynomialGF2mSmallM(r15, r2).addMonomial(0);
    }
}
