package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface DigestCalculatorProvider {
    DigestCalculator get(AlgorithmIdentifier r1);
}
