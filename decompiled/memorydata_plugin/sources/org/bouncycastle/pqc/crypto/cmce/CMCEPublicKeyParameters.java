package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class CMCEPublicKeyParameters extends CMCEKeyParameters {
    private final byte[] publicKey;

    public CMCEPublicKeyParameters(CMCEParameters r2, byte[] r3) {
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
