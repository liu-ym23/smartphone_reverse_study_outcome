package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.DERBitString;

/* JADX INFO: loaded from: classes7.dex */
public class NetscapeCertType extends DERBitString {
    public NetscapeCertType(ASN1BitString r2) {
        super(r2.getBytes(), r2.getPadBits());
    }

    @Override // org.bouncycastle.asn1.ASN1BitString
    public String toString() {
        return "NetscapeCertType: 0x" + Integer.toHexString(intValue());
    }
}
