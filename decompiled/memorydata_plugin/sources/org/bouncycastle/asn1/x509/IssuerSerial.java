package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class IssuerSerial extends ASN1Object {
    GeneralNames issuer;
    ASN1BitString issuerUID;
    ASN1Integer serial;

    private IssuerSerial(ASN1Sequence r4) {
        if (r4.size() != 2) goto L5;
    L9:
        this.issuer = GeneralNames.getInstance(r4.getObjectAt(0));
        this.serial = ASN1Integer.getInstance(r4.getObjectAt(1));
        if (r4.size() != 3) goto L13;
        this.issuerUID = DERBitString.getInstance(r4.getObjectAt(2));
        return;
    L13:
        return;
    L5:
        if (r4.size() == 3) goto L9;
        throw new IllegalArgumentException("Bad sequence size: " + r4.size());
    }

    public static IssuerSerial getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, IssuerSerial.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new IssuerSerial(ASN1Sequence.getInstance(r2));
    L5:
        return (IssuerSerial) ZeusTransformUtils.preCheckCast(r2, IssuerSerial.class, "com.obric.memorydata.plugin");
    }

    public static IssuerSerial getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public GeneralNames getIssuer() {
        return this.issuer;
    }

    public ASN1Integer getSerial() {
        return this.serial;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.issuer);
        r0.add(this.serial);
        ASN1BitString r2 = this.issuerUID;
        if (r2 == null) goto L6;
        r0.add(r2);
    L6:
        return new DERSequence(r0);
    }
}
