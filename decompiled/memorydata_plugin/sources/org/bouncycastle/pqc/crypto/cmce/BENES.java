package org.bouncycastle.pqc.crypto.cmce;

/* JADX INFO: loaded from: classes7.dex */
abstract class BENES {
    protected final int GFBITS;
    protected final int SYS_N;
    protected final int SYS_T;

    public BENES(int r1, int r2, int r3) {
        this.SYS_N = r1;
        this.SYS_T = r2;
        this.GFBITS = r3;
    }
}
