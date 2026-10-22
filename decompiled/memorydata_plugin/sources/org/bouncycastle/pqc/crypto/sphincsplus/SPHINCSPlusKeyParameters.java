package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class SPHINCSPlusKeyParameters extends AsymmetricKeyParameter {
    final SPHINCSPlusParameters parameters;

    public SPHINCSPlusKeyParameters(boolean r1, SPHINCSPlusParameters r2) {
        super(r1);
        this.parameters = r2;
    }

    public SPHINCSPlusParameters getParameters() {
        return this.parameters;
    }
}
