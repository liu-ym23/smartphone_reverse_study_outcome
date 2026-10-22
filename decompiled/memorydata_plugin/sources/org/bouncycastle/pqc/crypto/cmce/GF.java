package org.bouncycastle.pqc.crypto.cmce;

/* JADX INFO: loaded from: classes7.dex */
abstract class GF {
    protected final int GFBITS;
    protected final int GFMASK;

    public GF(int r2) {
        this.GFBITS = r2;
        this.GFMASK = (1 << r2) - 1;
    }

    short gf_add(short r1, short r2) {
        return (short) (r1 ^ r2);
    }

    public abstract short gf_inv(short r1);

    public abstract short gf_mul(short r1, short r2);
}
