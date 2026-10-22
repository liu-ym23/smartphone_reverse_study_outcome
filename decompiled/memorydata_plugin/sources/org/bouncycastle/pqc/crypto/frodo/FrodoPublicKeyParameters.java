package org.bouncycastle.pqc.crypto.frodo;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class FrodoPublicKeyParameters extends FrodoKeyParameters {
    public byte[] publicKey;

    public FrodoPublicKeyParameters(FrodoParameters r2, byte[] r3) {
        super(false, r2);
        this.publicKey = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return Arrays.clone(this.publicKey);
    }
}
