package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SNTRUPrimePrivateKeyParameters extends SNTRUPrimeKeyParameters {
    private final byte[] f;
    private final byte[] ginv;
    private final byte[] hash;
    private final byte[] pk;
    private final byte[] rho;

    public SNTRUPrimePrivateKeyParameters(SNTRUPrimeParameters r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6, byte[] r7) {
        super(true, r2);
        this.f = Arrays.clone(r3);
        this.ginv = Arrays.clone(r4);
        this.pk = Arrays.clone(r5);
        this.rho = Arrays.clone(r6);
        this.hash = Arrays.clone(r7);
    }

    public byte[] getEncoded() {
        byte[] r0 = new byte[getParameters().getPrivateKeyBytes()];
        byte[] r1 = this.f;
        System.arraycopy(r1, 0, r0, 0, r1.length);
        byte[] r2 = this.ginv;
        System.arraycopy(r2, 0, r0, this.f.length, r2.length);
        byte[] r3 = this.pk;
        System.arraycopy(r3, 0, r0, this.f.length + this.ginv.length, r3.length);
        byte[] r4 = this.rho;
        System.arraycopy(r4, 0, r0, (this.f.length + this.ginv.length) + this.pk.length, r4.length);
        byte[] r5 = this.hash;
        System.arraycopy(r5, 0, r0, ((this.f.length + this.ginv.length) + this.pk.length) + this.rho.length, r5.length);
        return r0;
    }

    public byte[] getF() {
        return Arrays.clone(this.f);
    }

    public byte[] getGinv() {
        return Arrays.clone(this.ginv);
    }

    public byte[] getHash() {
        return Arrays.clone(this.hash);
    }

    public byte[] getPk() {
        return Arrays.clone(this.pk);
    }

    public byte[] getRho() {
        return Arrays.clone(this.rho);
    }
}
