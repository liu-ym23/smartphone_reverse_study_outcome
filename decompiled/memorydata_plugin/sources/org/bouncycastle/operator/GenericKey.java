package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class GenericKey {
    private AlgorithmIdentifier algorithmIdentifier;
    private Object representation;

    public GenericKey(AlgorithmIdentifier r1, Object r2) {
        this.algorithmIdentifier = r1;
        this.representation = r2;
    }

    public Object getRepresentation() {
        return this.representation;
    }
}
