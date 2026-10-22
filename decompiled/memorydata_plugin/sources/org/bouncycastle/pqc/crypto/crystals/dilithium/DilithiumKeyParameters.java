package org.bouncycastle.pqc.crypto.crystals.dilithium;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class DilithiumKeyParameters extends AsymmetricKeyParameter {
    private final DilithiumParameters params;

    public DilithiumKeyParameters(boolean r1, DilithiumParameters r2) {
        super(r1);
        this.params = r2;
    }

    public DilithiumParameters getParameters() {
        return this.params;
    }
}
