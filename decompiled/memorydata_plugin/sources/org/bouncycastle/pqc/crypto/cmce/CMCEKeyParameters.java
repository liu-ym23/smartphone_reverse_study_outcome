package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class CMCEKeyParameters extends AsymmetricKeyParameter {
    private CMCEParameters params;

    public CMCEKeyParameters(boolean r1, CMCEParameters r2) {
        super(r1);
        this.params = r2;
    }

    public CMCEParameters getParameters() {
        return this.params;
    }
}
