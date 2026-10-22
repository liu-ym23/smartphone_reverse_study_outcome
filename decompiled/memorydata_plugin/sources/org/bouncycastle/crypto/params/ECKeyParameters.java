package org.bouncycastle.crypto.params;

import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class ECKeyParameters extends AsymmetricKeyParameter {
    private final ECDomainParameters parameters;

    public ECKeyParameters(boolean r1, ECDomainParameters r2) {
        super(r1);
        Objects.requireNonNull(r2, "'parameters' cannot be null");
        this.parameters = r2;
    }

    public ECDomainParameters getParameters() {
        return this.parameters;
    }
}
