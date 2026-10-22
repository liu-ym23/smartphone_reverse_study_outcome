package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class TBSCertificate extends ASN1Object {
    Time endDate;
    Extensions extensions;
    X500Name issuer;
    ASN1BitString issuerUniqueId;
    ASN1Sequence seq;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;
    Time startDate;
    X500Name subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    ASN1BitString subjectUniqueId;
    ASN1Integer version;

    private TBSCertificate(ASN1Sequence r11) {
        this.seq = r11;
        if (ZeusTransformUtils.instanceOf(r11.getObjectAt(0), ASN1TaggedObject.class) == false) goto L5;
        this.version = ASN1Integer.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r11.getObjectAt(0), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), true);
        int r1 = 0;
    L7:
        if (this.version.hasValue(0) == false) goto L10;
        boolean r6 = false;
        boolean r4 = true;
    L15:
        this.serialNumber = ASN1Integer.getInstance(r11.getObjectAt(r1 + 1));
        this.signature = AlgorithmIdentifier.getInstance(r11.getObjectAt(r1 + 2));
        this.issuer = X500Name.getInstance(r11.getObjectAt(r1 + 3));
        ASN1Sequence r7 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r11.getObjectAt(r1 + 4), ASN1Sequence.class, "com.obric.memorydata.plugin");
        this.startDate = Time.getInstance(r7.getObjectAt(0));
        this.endDate = Time.getInstance(r7.getObjectAt(1));
        this.subject = X500Name.getInstance(r11.getObjectAt(r1 + 5));
        int r2 = r1 + 6;
        this.subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(r11.getObjectAt(r2));
        int r8 = (r11.size() - r2) - 1;
        if (r8 == 0) goto L21;
        if (r4 == false) goto L21;
        throw new IllegalArgumentException("version 1 certificate contains extra data");
    L21:
        if (r8 <= 0) goto L36;
        ASN1TaggedObject r5 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r11.getObjectAt(r2 + r8), ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        int r9 = r5.getTagNo();
        if (r9 == 1) goto L34;
        if (r9 != 2) goto L26;
        this.subjectUniqueId = DERBitString.getInstance(r5, false);
    L35:
        r8 = r8 - 1;
        goto L21
    L26:
        if (r9 != 3) goto L32;
        if (r6 == true) goto L30;
        this.extensions = Extensions.getInstance(ASN1Sequence.getInstance(r5, true));
        goto L35
    L30:
        throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
    L32:
        throw new IllegalArgumentException("Unknown tag encountered in structure: " + r5.getTagNo());
    L34:
        this.issuerUniqueId = DERBitString.getInstance(r5, false);
        goto L35
    L36:
        return;
    L10:
        if (this.version.hasValue(1) == false) goto L13;
        r4 = false;
        r6 = true;
        goto L15
    L13:
        if (this.version.hasValue(2) == false) goto L38;
        r4 = false;
        r6 = false;
        goto L15
    L38:
        throw new IllegalArgumentException("version number not recognised");
    L5:
        this.version = new ASN1Integer(0);
        r1 = -1;
        goto L7
    }

    public static TBSCertificate getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, TBSCertificate.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new TBSCertificate(ASN1Sequence.getInstance(r2));
    L5:
        return (TBSCertificate) ZeusTransformUtils.preCheckCast(r2, TBSCertificate.class, "com.obric.memorydata.plugin");
    }

    public Time getEndDate() {
        return this.endDate;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public ASN1BitString getIssuerUniqueId() {
        return this.issuerUniqueId;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getStartDate() {
        return this.startDate;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public ASN1BitString getSubjectUniqueId() {
        return this.subjectUniqueId;
    }

    public int getVersionNumber() {
        return this.version.intValueExact() + 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (Properties.getPropertyValue("org.bouncycastle.x509.allow_non-der_tbscert") == null) goto L27;
        if (Properties.isOverrideSet("org.bouncycastle.x509.allow_non-der_tbscert") == true) goto L7;
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        if (this.version.hasValue(0) == true) goto L11;
        r0.add(new DERTaggedObject(true, 0, this.version));
    L11:
        r0.add(this.serialNumber);
        r0.add(this.signature);
        r0.add(this.issuer);
        ASN1EncodableVector r1 = new ASN1EncodableVector(2);
        r1.add(this.startDate);
        r1.add(this.endDate);
        r0.add(new DERSequence(r1));
        ASN1Encodable r2 = this.subject;
        if (r2 != null) goto L15;
        r2 = new DERSequence();
    L15:
        r0.add(r2);
        r0.add(this.subjectPublicKeyInfo);
        if (this.issuerUniqueId == null) goto L19;
        r0.add(new DERTaggedObject(false, 1, this.issuerUniqueId));
    L19:
        if (this.subjectUniqueId == null) goto L22;
        r0.add(new DERTaggedObject(false, 2, this.subjectUniqueId));
    L22:
        if (this.extensions == null) goto L25;
        r0.add(new DERTaggedObject(true, 3, this.extensions));
    L25:
        return new DERSequence(r0);
    L7:
        return this.seq;
    L27:
        return this.seq;
    }
}
