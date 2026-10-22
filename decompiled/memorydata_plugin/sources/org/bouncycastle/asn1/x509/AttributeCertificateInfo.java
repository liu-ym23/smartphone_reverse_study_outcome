package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class AttributeCertificateInfo extends ASN1Object {
    private AttCertValidityPeriod attrCertValidityPeriod;
    private ASN1Sequence attributes;
    private Extensions extensions;
    private Holder holder;
    private AttCertIssuer issuer;
    private ASN1BitString issuerUniqueID;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signature;
    private ASN1Integer version;

    private AttributeCertificateInfo(ASN1Sequence r6) {
        if (r6.size() < 6) goto L24;
        if (r6.size() > 9) goto L24;
        int r0 = 0;
        if (ZeusTransformUtils.instanceOf(r6.getObjectAt(0), ASN1Integer.class) == false) goto L9;
        this.version = ASN1Integer.getInstance(r6.getObjectAt(0));
        r0 = 1;
    L10:
        this.holder = Holder.getInstance(r6.getObjectAt(r0));
        this.issuer = AttCertIssuer.getInstance(r6.getObjectAt(r0 + 1));
        this.signature = AlgorithmIdentifier.getInstance(r6.getObjectAt(r0 + 2));
        this.serialNumber = ASN1Integer.getInstance(r6.getObjectAt(r0 + 3));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(r6.getObjectAt(r0 + 4));
        this.attributes = ASN1Sequence.getInstance(r6.getObjectAt(r0 + 5));
        int r1 = r0 + 6;
    L12:
        if (r1 >= r6.size()) goto L22;
        ASN1Encodable r2 = r6.getObjectAt(r1);
        if (ZeusTransformUtils.instanceOf(r2, ASN1BitString.class) == false) goto L17;
        this.issuerUniqueID = ASN1BitString.getInstance(r6.getObjectAt(r1));
    L21:
        r1 = r1 + 1;
        goto L12
    L17:
        if (ZeusTransformUtils.instanceOf(r2, ASN1Sequence.class) == false) goto L19;
    L20:
        this.extensions = Extensions.getInstance(r6.getObjectAt(r1));
        goto L21
    L19:
        if (ZeusTransformUtils.instanceOf(r2, Extensions.class) == false) goto L21;
    L22:
        return;
    L9:
        this.version = new ASN1Integer(0);
    L24:
        throw new IllegalArgumentException("Bad sequence size: " + r6.size());
    }

    public static AttributeCertificateInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, AttributeCertificateInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new AttributeCertificateInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (AttributeCertificateInfo) ZeusTransformUtils.preCheckCast(r2, AttributeCertificateInfo.class, "com.obric.memorydata.plugin");
    }

    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        return this.attrCertValidityPeriod;
    }

    public ASN1Sequence getAttributes() {
        return this.attributes;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public Holder getHolder() {
        return this.holder;
    }

    public AttCertIssuer getIssuer() {
        return this.issuer;
    }

    public ASN1BitString getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(9);
        if (this.version.hasValue(0) == true) goto L5;
        r0.add(this.version);
    L5:
        r0.add(this.holder);
        r0.add(this.issuer);
        r0.add(this.signature);
        r0.add(this.serialNumber);
        r0.add(this.attrCertValidityPeriod);
        r0.add(this.attributes);
        ASN1BitString r1 = this.issuerUniqueID;
        if (r1 == null) goto L8;
        r0.add(r1);
    L8:
        Extensions r3 = this.extensions;
        if (r3 == null) goto L12;
        r0.add(r3);
    L12:
        return new DERSequence(r0);
    }
}
