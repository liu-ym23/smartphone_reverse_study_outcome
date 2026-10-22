package org.bouncycastle.pqc.legacy.crypto.mceliece;

import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes7.dex */
public class McEliecePublicKeyParameters extends McElieceKeyParameters {
    private GF2Matrix g;
    private int n;
    private int t;

    public McEliecePublicKeyParameters(int r3, int r4, GF2Matrix r5) {
        super(false, null);
        this.n = r3;
        this.t = r4;
        this.g = new GF2Matrix(r5);
    }

    public GF2Matrix getG() {
        return this.g;
    }

    public int getK() {
        return this.g.getNumRows();
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }
}
