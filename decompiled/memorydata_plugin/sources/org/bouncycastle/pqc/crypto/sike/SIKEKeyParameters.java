package org.bouncycastle.pqc.crypto.sike;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class SIKEKeyParameters extends AsymmetricKeyParameter {
    private SIKEParameters params;

    public SIKEKeyParameters(boolean r1, SIKEParameters r2) {
        super(r1);
        this.params = r2;
    }

    public SIKEParameters getParameters() {
        return this.params;
    }
}
