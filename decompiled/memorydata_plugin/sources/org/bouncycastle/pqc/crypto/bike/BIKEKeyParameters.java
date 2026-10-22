package org.bouncycastle.pqc.crypto.bike;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class BIKEKeyParameters extends AsymmetricKeyParameter {
    private BIKEParameters params;

    public BIKEKeyParameters(boolean r1, BIKEParameters r2) {
        super(r1);
        this.params = r2;
    }

    public BIKEParameters getParameters() {
        return this.params;
    }
}
