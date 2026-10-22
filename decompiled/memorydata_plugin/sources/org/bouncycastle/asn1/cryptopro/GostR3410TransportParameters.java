package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class GostR3410TransportParameters extends ASN1Object {
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final SubjectPublicKeyInfo ephemeralPublicKey;
    private final byte[] ukm;

    private GostR3410TransportParameters(ASN1Sequence r6) {
        if (r6.size() != 2) goto L6;
        this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(r6.getObjectAt(0));
        this.ukm = ASN1OctetString.getInstance(r6.getObjectAt(1)).getOctets();
        this.ephemeralPublicKey = null;
        return;
    L6:
        if (r6.size() != 3) goto L10;
        this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(r6.getObjectAt(0));
        this.ephemeralPublicKey = SubjectPublicKeyInfo.getInstance(ASN1TaggedObject.getInstance(r6.getObjectAt(1)), false);
        this.ukm = ASN1OctetString.getInstance(r6.getObjectAt(2)).getOctets();
        return;
    L10:
        throw new IllegalArgumentException("unknown sequence length: " + r6.size());
    }

    public static GostR3410TransportParameters getInstance(ASN1TaggedObject r1, boolean r2) {
        return new GostR3410TransportParameters(ASN1Sequence.getInstance(r1, r2));
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public SubjectPublicKeyInfo getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public byte[] getUkm() {
        return Arrays.clone(this.ukm);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.encryptionParamSet);
        if (this.ephemeralPublicKey == null) goto L5;
        r0.add(new DERTaggedObject(false, 0, this.ephemeralPublicKey));
    L5:
        r0.add(new DEROctetString(this.ukm));
        return new DERSequence(r0);
    }
}
