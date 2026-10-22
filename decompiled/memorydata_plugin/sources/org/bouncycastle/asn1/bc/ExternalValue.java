package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes7.dex */
public class ExternalValue extends ASN1Object {
    private final AlgorithmIdentifier hashAlg;
    private final ASN1BitString hashVal;
    private final GeneralName location;

    public ExternalValue(GeneralName r1, AlgorithmIdentifier r2, byte[] r3) {
        this.location = r1;
        this.hashAlg = r2;
        this.hashVal = new DERBitString(r3);
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.hashAlg;
    }

    public ASN1BitString getHashVal() {
        return this.hashVal;
    }

    public GeneralName getLocation() {
        return this.location;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(this.location);
        r0.add(this.hashAlg);
        r0.add(this.hashVal);
        return new DERSequence(r0);
    }
}
