package org.bouncycastle.pqc.crypto.crystals.kyber;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class KyberKeyParameters extends AsymmetricKeyParameter {
    private KyberParameters params;

    public KyberKeyParameters(boolean r1, KyberParameters r2) {
        super(r1);
        this.params = r2;
    }

    public KyberParameters getParameters() {
        return this.params;
    }
}
