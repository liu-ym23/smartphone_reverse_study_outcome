package org.bouncycastle.pqc.crypto.frodo;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class FrodoKeyParameters extends AsymmetricKeyParameter {
    private FrodoParameters params;

    public FrodoKeyParameters(boolean r1, FrodoParameters r2) {
        super(r1);
        this.params = r2;
    }

    public FrodoParameters getParameters() {
        return this.params;
    }
}
