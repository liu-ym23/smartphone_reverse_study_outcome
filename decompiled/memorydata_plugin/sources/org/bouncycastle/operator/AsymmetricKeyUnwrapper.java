package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AsymmetricKeyUnwrapper {
    private AlgorithmIdentifier algorithmId;

    public AsymmetricKeyUnwrapper(AlgorithmIdentifier r1) {
        this.algorithmId = r1;
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algorithmId;
    }
}
