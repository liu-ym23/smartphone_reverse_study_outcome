package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SNTRUPrimePublicKeyParameters extends SNTRUPrimeKeyParameters {
    private final byte[] encH;

    public SNTRUPrimePublicKeyParameters(SNTRUPrimeParameters r2, byte[] r3) {
        super(false, r2);
        this.encH = Arrays.clone(r3);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.encH);
    }
}
