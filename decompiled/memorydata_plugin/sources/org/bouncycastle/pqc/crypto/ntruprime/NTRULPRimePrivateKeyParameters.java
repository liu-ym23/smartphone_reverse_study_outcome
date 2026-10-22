package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class NTRULPRimePrivateKeyParameters extends NTRULPRimeKeyParameters {
    private final byte[] enca;
    private final byte[] hash;
    private final byte[] pk;
    private final byte[] rho;

    public NTRULPRimePrivateKeyParameters(NTRULPRimeParameters r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6) {
        super(true, r2);
        this.enca = Arrays.clone(r3);
        this.pk = Arrays.clone(r4);
        this.rho = Arrays.clone(r5);
        this.hash = Arrays.clone(r6);
    }

    public byte[] getEnca() {
        return Arrays.clone(this.enca);
    }

    public byte[] getEncoded() {
        byte[] r0 = new byte[getParameters().getPrivateKeyBytes()];
        byte[] r1 = this.enca;
        System.arraycopy(r1, 0, r0, 0, r1.length);
        byte[] r2 = this.pk;
        System.arraycopy(r2, 0, r0, this.enca.length, r2.length);
        byte[] r3 = this.rho;
        System.arraycopy(r3, 0, r0, this.enca.length + this.pk.length, r3.length);
        byte[] r4 = this.hash;
        System.arraycopy(r4, 0, r0, (this.enca.length + this.pk.length) + this.rho.length, r4.length);
        return r0;
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
