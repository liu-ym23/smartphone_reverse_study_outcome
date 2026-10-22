package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class NTRULPRimeKeyParameters extends AsymmetricKeyParameter {
    private final NTRULPRimeParameters params;

    public NTRULPRimeKeyParameters(boolean r1, NTRULPRimeParameters r2) {
        super(r1);
        this.params = r2;
    }

    public NTRULPRimeParameters getParameters() {
        return this.params;
    }
}
