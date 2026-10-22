package org.bouncycastle.pqc.crypto.ntru;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class NTRUKeyParameters extends AsymmetricKeyParameter {
    private final NTRUParameters params;

    NTRUKeyParameters(boolean r1, NTRUParameters r2) {
        super(r1);
        this.params = r2;
    }

    public NTRUParameters getParameters() {
        return this.params;
    }
}
