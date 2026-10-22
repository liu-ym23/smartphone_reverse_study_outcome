package org.bouncycastle.pqc.crypto.hqc;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class HQCPrivateKeyParameters extends HQCKeyParameters {
    private byte[] sk;

    public HQCPrivateKeyParameters(HQCParameters r2, byte[] r3) {
        super(true, r2);
        this.sk = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.sk);
    }

    public byte[] getPrivateKey() {
        return Arrays.clone(this.sk);
    }
}
