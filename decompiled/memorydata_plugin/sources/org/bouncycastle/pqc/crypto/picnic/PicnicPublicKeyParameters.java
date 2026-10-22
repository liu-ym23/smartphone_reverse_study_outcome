package org.bouncycastle.pqc.crypto.picnic;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class PicnicPublicKeyParameters extends PicnicKeyParameters {
    private final byte[] publicKey;

    public PicnicPublicKeyParameters(PicnicParameters r2, byte[] r3) {
        super(false, r2);
        this.publicKey = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.publicKey);
    }
}
