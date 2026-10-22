package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes7.dex */
public interface KeyAgreeRecipient extends Recipient {
    AlgorithmIdentifier getPrivateKeyAlgorithmIdentifier();

    RecipientOperator getRecipientOperator(AlgorithmIdentifier r1, AlgorithmIdentifier r2, SubjectPublicKeyInfo r3, ASN1OctetString r4, byte[] r5);
}
