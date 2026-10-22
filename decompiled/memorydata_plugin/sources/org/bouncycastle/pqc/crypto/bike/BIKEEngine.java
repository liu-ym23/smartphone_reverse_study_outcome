package org.bouncycastle.pqc.crypto.bike;

import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes7.dex */
class BIKEEngine {
    private int L_BYTE;
    private int R_BYTE;
    private GF2mField field;
    private int hw;
    private int l;
    private int nbIter;
    private int r;
    private final PolynomialGF2mSmallM reductionPoly;
    private int t;
    private int tau;
    private int w;

    public BIKEEngine(int r1, int r2, int r3, int r4, int r5, int r6) {
        this.r = r1;
        this.w = r2;
        this.t = r3;
        this.l = r4;
        this.nbIter = r5;
        this.tau = r6;
        this.hw = r2 / 2;
        this.L_BYTE = r4 / 8;
        this.R_BYTE = (r1 + 7) / 8;
        GF2mField r7 = new GF2mField(1);
        this.field = r7;
        this.reductionPoly = new PolynomialGF2mSmallM(r7, r1).addMonomial(0);
    }
}
