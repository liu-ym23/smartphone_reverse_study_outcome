package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes7.dex */
public class Certificate extends ASN1Object {
    ASN1Sequence seq;
    ASN1BitString sig;
    AlgorithmIdentifier sigAlgId;
    TBSCertificate tbsCert;

    private Certificate(ASN1Sequence r3) {
        this.seq = r3;
        if (r3.size() != 3) goto L7;
        this.tbsCert = TBSCertificate.getInstance(r3.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(r3.getObjectAt(1));
        this.sig = ASN1BitString.getInstance(r3.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    public static Certificate getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Certificate.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new Certificate(ASN1Sequence.getInstance(r2));
    L5:
        return (Certificate) ZeusTransformUtils.preCheckCast(r2, Certificate.class, "com.obric.memorydata.plugin");
    }

    public Time getEndDate() {
        return this.tbsCert.getEndDate();
    }

    public X500Name getIssuer() {
        return this.tbsCert.getIssuer();
    }

    public ASN1Integer getSerialNumber() {
        return this.tbsCert.getSerialNumber();
    }

    public ASN1BitString getSignature() {
        return this.sig;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public Time getStartDate() {
        return this.tbsCert.getStartDate();
    }

    public X500Name getSubject() {
        return this.tbsCert.getSubject();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.tbsCert.getSubjectPublicKeyInfo();
    }

    public TBSCertificate getTBSCertificate() {
        return this.tbsCert;
    }

    public int getVersionNumber() {
        return this.tbsCert.getVersionNumber();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
