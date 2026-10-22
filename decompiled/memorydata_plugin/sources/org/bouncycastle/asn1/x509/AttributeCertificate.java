package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class AttributeCertificate extends ASN1Object {
    AttributeCertificateInfo acinfo;
    AlgorithmIdentifier signatureAlgorithm;
    ASN1BitString signatureValue;

    private AttributeCertificate(ASN1Sequence r3) {
        if (r3.size() != 3) goto L7;
        this.acinfo = AttributeCertificateInfo.getInstance(r3.getObjectAt(0));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(r3.getObjectAt(1));
        this.signatureValue = DERBitString.getInstance(r3.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public static AttributeCertificate getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, AttributeCertificate.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new AttributeCertificate(ASN1Sequence.getInstance(r2));
    L5:
        return (AttributeCertificate) ZeusTransformUtils.preCheckCast(r2, AttributeCertificate.class, "com.obric.memorydata.plugin");
    }

    public AttributeCertificateInfo getAcinfo() {
        return this.acinfo;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public ASN1BitString getSignatureValue() {
        return this.signatureValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.acinfo);
        r0.add(this.signatureAlgorithm);
        r0.add(this.signatureValue);
        return new DERSequence(r0);
    }
}
