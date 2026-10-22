package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Certificate;

/* JADX INFO: loaded from: classes7.dex */
public class IssuerAndSerialNumber extends ASN1Object {
    private X500Name name;
    private ASN1Integer serialNumber;

    public IssuerAndSerialNumber(ASN1Sequence r3) {
        this.name = X500Name.getInstance(r3.getObjectAt(0));
        this.serialNumber = (ASN1Integer) ZeusTransformUtils.preCheckCast(r3.getObjectAt(1), ASN1Integer.class, "com.obric.memorydata.plugin");
    }

    public IssuerAndSerialNumber(Certificate r2) {
        this.name = r2.getIssuer();
        this.serialNumber = r2.getSerialNumber();
    }

    public static IssuerAndSerialNumber getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, IssuerAndSerialNumber.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new IssuerAndSerialNumber(ASN1Sequence.getInstance(r2));
    L5:
        return (IssuerAndSerialNumber) ZeusTransformUtils.preCheckCast(r2, IssuerAndSerialNumber.class, "com.obric.memorydata.plugin");
    }

    public X500Name getName() {
        return this.name;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.name);
        r0.add(this.serialNumber);
        return new DERSequence(r0);
    }
}
