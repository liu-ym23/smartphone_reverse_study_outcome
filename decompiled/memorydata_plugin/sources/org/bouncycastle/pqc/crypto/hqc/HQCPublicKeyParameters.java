package org.bouncycastle.pqc.crypto.hqc;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class HQCPublicKeyParameters extends HQCKeyParameters {
    private byte[] pk;

    public HQCPublicKeyParameters(HQCParameters r2, byte[] r3) {
        super(true, r2);
        this.pk = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return Arrays.clone(this.pk);
    }
}
