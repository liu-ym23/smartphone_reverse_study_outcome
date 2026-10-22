package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.DERIA5String;

/* JADX INFO: loaded from: classes7.dex */
public class VerisignCzagExtension extends DERIA5String {
    public VerisignCzagExtension(ASN1IA5String r1) {
        super(r1.getString());
    }

    @Override // org.bouncycastle.asn1.ASN1IA5String
    public String toString() {
        return "VerisignCzagExtension: " + getString();
    }
}
