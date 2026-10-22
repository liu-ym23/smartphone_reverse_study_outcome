package org.bouncycastle.pqc.legacy.crypto.mceliece;

import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes7.dex */
public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters {
    private GF2Matrix matrixG;
    private int n;
    private int t;

    public McElieceCCA2PublicKeyParameters(int r2, int r3, GF2Matrix r4, String r5) {
        super(false, r5);
        this.n = r2;
        this.t = r3;
        this.matrixG = new GF2Matrix(r4);
    }

    public GF2Matrix getG() {
        return this.matrixG;
    }

    public int getK() {
        return this.matrixG.getNumRows();
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }
}
