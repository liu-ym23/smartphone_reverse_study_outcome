package org.bouncycastle.pqc.crypto.falcon;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class FalconPrivateKeyParameters extends FalconKeyParameters {
    private final byte[] F;
    private final byte[] f;
    private final byte[] g;
    private final byte[] pk;

    public FalconPrivateKeyParameters(FalconParameters r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6) {
        super(true, r2);
        this.f = Arrays.clone(r3);
        this.g = Arrays.clone(r4);
        this.F = Arrays.clone(r5);
        this.pk = Arrays.clone(r6);
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(this.f, this.g, this.F);
    }

    public byte[] getG() {
        return Arrays.clone(this.g);
    }

    public byte[] getPublicKey() {
        return Arrays.clone(this.pk);
    }

    public byte[] getSpolyF() {
        return Arrays.clone(this.F);
    }

    public byte[] getSpolyf() {
        return Arrays.clone(this.f);
    }
}
