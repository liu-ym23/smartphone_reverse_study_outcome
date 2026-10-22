package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class SNTRUPrimeKeyParameters extends AsymmetricKeyParameter {
    private final SNTRUPrimeParameters params;

    public SNTRUPrimeKeyParameters(boolean r1, SNTRUPrimeParameters r2) {
        super(r1);
        this.params = r2;
    }

    public SNTRUPrimeParameters getParameters() {
        return this.params;
    }
}
