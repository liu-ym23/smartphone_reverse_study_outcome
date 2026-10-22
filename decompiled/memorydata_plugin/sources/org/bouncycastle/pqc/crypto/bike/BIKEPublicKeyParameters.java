package org.bouncycastle.pqc.crypto.bike;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BIKEPublicKeyParameters extends BIKEKeyParameters {
    byte[] publicKey;

    public BIKEPublicKeyParameters(BIKEParameters r2, byte[] r3) {
        super(false, r2);
        this.publicKey = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.publicKey);
    }
}
