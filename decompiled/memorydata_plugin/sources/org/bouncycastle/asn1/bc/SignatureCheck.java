package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SignatureCheck extends ASN1Object {
    private final ASN1Sequence certificates;
    private final AlgorithmIdentifier signatureAlgorithm;
    private final ASN1BitString signatureValue;

    private SignatureCheck(ASN1Sequence r4) {
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(r4.getObjectAt(0));
        int r0 = 1;
        if (ZeusTransformUtils.instanceOf(r4.getObjectAt(1), ASN1TaggedObject.class) == false) goto L5;
        this.certificates = ASN1Sequence.getInstance(ASN1TaggedObject.getInstance(r4.getObjectAt(1)).getObject());
        r0 = 2;
    L6:
        this.signatureValue = DERBitString.getInstance(r4.getObjectAt(r0));
        return;
    L5:
        this.certificates = null;
        goto L6
    }

    public SignatureCheck(AlgorithmIdentifier r1, byte[] r2) {
        this.signatureAlgorithm = r1;
        this.certificates = null;
        this.signatureValue = new DERBitString(Arrays.clone(r2));
    }

    public SignatureCheck(AlgorithmIdentifier r1, Certificate[] r2, byte[] r3) {
        this.signatureAlgorithm = r1;
        this.certificates = new DERSequence(r2);
        this.signatureValue = new DERBitString(Arrays.clone(r3));
    }

    public static SignatureCheck getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SignatureCheck.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new SignatureCheck(ASN1Sequence.getInstance(r2));
    L5:
        return (SignatureCheck) ZeusTransformUtils.preCheckCast(r2, SignatureCheck.class, "com.obric.memorydata.plugin");
    }

    public Certificate[] getCertificates() {
        ASN1Sequence r0 = this.certificates;
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.size();
        Certificate[] r2 = new Certificate[r1];
        int r3 = 0;
    L7:
        if (r3 == r1) goto L9;
        r2[r3] = Certificate.getInstance(this.certificates.getObjectAt(r3));
        r3 = r3 + 1;
        goto L7
    L9:
        return r2;
    }

    public ASN1BitString getSignature() {
        return new DERBitString(this.signatureValue.getBytes(), this.signatureValue.getPadBits());
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.signatureAlgorithm);
        if (this.certificates == null) goto L5;
        r0.add(new DERTaggedObject(0, this.certificates));
    L5:
        r0.add(this.signatureValue);
        return new DERSequence(r0);
    }
}
