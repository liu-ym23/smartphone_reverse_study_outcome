package org.bouncycastle.pqc.crypto.sike;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SIKEPrivateKeyParameters extends SIKEKeyParameters {
    private byte[] privateKey;

    public SIKEPrivateKeyParameters(SIKEParameters r2, byte[] r3) {
        super(true, r2);
        this.privateKey = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.privateKey);
    }
}
