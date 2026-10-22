package org.bouncycastle.pqc.crypto.bike;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BIKEPrivateKeyParameters extends BIKEKeyParameters {
    private byte[] h0;
    private byte[] h1;
    private byte[] sigma;

    public BIKEPrivateKeyParameters(BIKEParameters r2, byte[] r3, byte[] r4, byte[] r5) {
        super(true, r2);
        this.h0 = Arrays.clone(r3);
        this.h1 = Arrays.clone(r4);
        this.sigma = Arrays.clone(r5);
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(Arrays.concatenate(this.h0, this.h1), this.sigma);
    }
}
