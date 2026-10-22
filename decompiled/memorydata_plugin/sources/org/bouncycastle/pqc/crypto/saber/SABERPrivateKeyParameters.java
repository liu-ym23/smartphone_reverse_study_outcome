package org.bouncycastle.pqc.crypto.saber;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SABERPrivateKeyParameters extends SABERKeyParameters {
    private byte[] privateKey;

    public SABERPrivateKeyParameters(SABERParameters r2, byte[] r3) {
        super(true, r2);
        this.privateKey = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.privateKey);
    }
}
