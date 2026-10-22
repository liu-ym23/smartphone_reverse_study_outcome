package org.bouncycastle.pqc.crypto.saber;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class SABERKeyParameters extends AsymmetricKeyParameter {
    private SABERParameters params;

    public SABERKeyParameters(boolean r1, SABERParameters r2) {
        super(r1);
        this.params = r2;
    }

    public SABERParameters getParameters() {
        return this.params;
    }
}
