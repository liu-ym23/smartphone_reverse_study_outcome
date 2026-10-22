package org.bouncycastle.jce.interfaces;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface PKCS12BagAttributeCarrier {
    ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r1);

    Enumeration getBagAttributeKeys();

    void setBagAttribute(ASN1ObjectIdentifier r1, ASN1Encodable r2);
}
