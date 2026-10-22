package org.bouncycastle.pqc.crypto.picnic;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class PicnicKeyParameters extends AsymmetricKeyParameter {
    final PicnicParameters parameters;

    public PicnicKeyParameters(boolean r1, PicnicParameters r2) {
        super(r1);
        this.parameters = r2;
    }

    public PicnicParameters getParameters() {
        return this.parameters;
    }
}
