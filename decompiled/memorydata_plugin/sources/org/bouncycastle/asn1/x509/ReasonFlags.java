package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.DERBitString;

/* JADX INFO: loaded from: classes7.dex */
public class ReasonFlags extends DERBitString {
    public ReasonFlags(ASN1BitString r2) {
        super(r2.getBytes(), r2.getPadBits());
    }
}
