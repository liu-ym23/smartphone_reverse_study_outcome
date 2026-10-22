package org.bouncycastle.pqc.crypto.falcon;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class FalconKeyParameters extends AsymmetricKeyParameter {
    private final FalconParameters params;

    public FalconKeyParameters(boolean r1, FalconParameters r2) {
        super(r1);
        this.params = r2;
    }

    public FalconParameters getParameters() {
        return this.params;
    }
}
