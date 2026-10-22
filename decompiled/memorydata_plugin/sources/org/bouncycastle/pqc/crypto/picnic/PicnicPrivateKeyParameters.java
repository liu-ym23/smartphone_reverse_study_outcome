package org.bouncycastle.pqc.crypto.picnic;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class PicnicPrivateKeyParameters extends PicnicKeyParameters {
    private final byte[] privateKey;

    public PicnicPrivateKeyParameters(PicnicParameters r2, byte[] r3) {
        super(true, r2);
        this.privateKey = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.privateKey);
    }
}
