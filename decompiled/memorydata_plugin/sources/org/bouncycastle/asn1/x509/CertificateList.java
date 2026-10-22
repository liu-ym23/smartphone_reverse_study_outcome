package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes7.dex */
public class CertificateList extends ASN1Object {
    int hashCodeValue;
    boolean isHashCodeSet;
    ASN1BitString sig;
    AlgorithmIdentifier sigAlgId;
    TBSCertList tbsCertList;

    private CertificateList(ASN1Sequence r4) {
        this.isHashCodeSet = false;
        if (r4.size() != 3) goto L7;
        this.tbsCertList = TBSCertList.getInstance(r4.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(r4.getObjectAt(1));
        this.sig = DERBitString.getInstance(r4.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("sequence wrong size for CertificateList");
    }

    public static CertificateList getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, CertificateList.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new CertificateList(ASN1Sequence.getInstance(r2));
    L5:
        return (CertificateList) ZeusTransformUtils.preCheckCast(r2, CertificateList.class, "com.obric.memorydata.plugin");
    }

    public X500Name getIssuer() {
        return this.tbsCertList.getIssuer();
    }

    public Time getNextUpdate() {
        return this.tbsCertList.getNextUpdate();
    }

    public Enumeration getRevokedCertificateEnumeration() {
        return this.tbsCertList.getRevokedCertificateEnumeration();
    }

    public TBSCertList.CRLEntry[] getRevokedCertificates() {
        return this.tbsCertList.getRevokedCertificates();
    }

    public ASN1BitString getSignature() {
        return this.sig;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public TBSCertList getTBSCertList() {
        return this.tbsCertList;
    }

    public Time getThisUpdate() {
        return this.tbsCertList.getThisUpdate();
    }

    public int getVersionNumber() {
        return this.tbsCertList.getVersionNumber();
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeSet == true) goto L6;
        this.hashCodeValue = super.hashCode();
        this.isHashCodeSet = true;
    L6:
        return this.hashCodeValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.tbsCertList);
        r0.add(this.sigAlgId);
        r0.add(this.sig);
        return new DERSequence(r0);
    }
}
