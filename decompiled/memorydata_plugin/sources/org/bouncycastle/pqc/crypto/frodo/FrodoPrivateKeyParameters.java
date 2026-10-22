package org.bouncycastle.pqc.crypto.frodo;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class FrodoPrivateKeyParameters extends FrodoKeyParameters {
    private byte[] privateKey;

    public FrodoPrivateKeyParameters(FrodoParameters r2, byte[] r3) {
        super(true, r2);
        this.privateKey = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.privateKey);
    }
}
