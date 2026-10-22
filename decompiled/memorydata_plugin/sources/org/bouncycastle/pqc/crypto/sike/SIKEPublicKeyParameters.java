package org.bouncycastle.pqc.crypto.sike;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SIKEPublicKeyParameters extends SIKEKeyParameters {
    private final byte[] publicKey;

    public SIKEPublicKeyParameters(SIKEParameters r2, byte[] r3) {
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
