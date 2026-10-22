package org.bouncycastle.pqc.legacy.crypto.mceliece;

import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.legacy.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.legacy.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.legacy.math.linearalgebra.PolynomialRingGF2m;

/* JADX INFO: loaded from: classes7.dex */
public class McElieceCCA2PrivateKeyParameters extends McElieceCCA2KeyParameters {
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;
    private GF2Matrix h;
    private int k;
    private int n;
    private Permutation p;
    private PolynomialGF2mSmallM[] qInv;

    public McElieceCCA2PrivateKeyParameters(int r2, int r3, GF2mField r4, PolynomialGF2mSmallM r5, GF2Matrix r6, Permutation r7, String r8) {
        super(true, r8);
        this.n = r2;
        this.k = r3;
        this.field = r4;
        this.goppaPoly = r5;
        this.h = r6;
        this.p = r7;
        this.qInv = new PolynomialRingGF2m(r4, r5).getSquareRootMatrix();
    }

    public McElieceCCA2PrivateKeyParameters(int r9, int r10, GF2mField r11, PolynomialGF2mSmallM r12, Permutation r13, String r14) {
        this(r9, r10, r11, r12, GoppaCode.createCanonicalCheckMatrix(r11, r12), r13, r14);
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.h;
    }

    public int getK() {
        return this.k;
    }

    public int getN() {
        return this.n;
    }

    public Permutation getP() {
        return this.p;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }
}
