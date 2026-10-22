package org.bouncycastle.pqc.crypto.hqc;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class HQCKeyParameters extends AsymmetricKeyParameter {
    private HQCParameters params;

    public HQCKeyParameters(boolean r1, HQCParameters r2) {
        super(r1);
        this.params = r2;
    }

    public HQCParameters getParameters() {
        return this.params;
    }
}
