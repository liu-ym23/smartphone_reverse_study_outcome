package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class DistributionPoint extends ASN1Object {
    GeneralNames cRLIssuer;
    DistributionPointName distributionPoint;
    ReasonFlags reasons;

    public DistributionPoint(ASN1Sequence r6) {
        int r1 = 0;
    L4:
        if (r1 == r6.size()) goto L16;
        ASN1TaggedObject r2 = ASN1TaggedObject.getInstance(r6.getObjectAt(r1));
        int r3 = r2.getTagNo();
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L9;
        this.reasons = new ReasonFlags(DERBitString.getInstance(r2, false));
    L15:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r3 != 2) goto L12;
        this.cRLIssuer = GeneralNames.getInstance(r2, false);
        goto L15
    L12:
        throw new IllegalArgumentException("Unknown tag encountered in structure: " + r2.getTagNo());
    L14:
        this.distributionPoint = DistributionPointName.getInstance(r2, true);
        goto L15
    }

    private void appendObject(StringBuffer r1, String r2, String r3, String r4) {
        r1.append("    ");
        r1.append(r3);
        r1.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r1.append(r2);
        r1.append("    ");
        r1.append("    ");
        r1.append(r4);
        r1.append(r2);
    }

    public static DistributionPoint getInstance(Object r3) {
        if (r3 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, DistributionPoint.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, ASN1Sequence.class) == false) goto L12;
        return new DistributionPoint((ASN1Sequence) ZeusTransformUtils.preCheckCast(r3, ASN1Sequence.class, "com.obric.memorydata.plugin"));
    L12:
        throw new IllegalArgumentException("Invalid DistributionPoint: " + r3.getClass().getName());
    L14:
        return (DistributionPoint) ZeusTransformUtils.preCheckCast(r3, DistributionPoint.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        if (this.distributionPoint == null) goto L6;
        r0.add(new DERTaggedObject(0, this.distributionPoint));
    L6:
        if (this.reasons == null) goto L9;
        r0.add(new DERTaggedObject(false, 1, this.reasons));
    L9:
        if (this.cRLIssuer == null) goto L12;
        r0.add(new DERTaggedObject(false, 2, this.cRLIssuer));
    L12:
        return new DERSequence(r0);
    }

    public String toString() {
        String r0 = Strings.lineSeparator();
        StringBuffer r1 = new StringBuffer();
        r1.append("DistributionPoint: [");
        r1.append(r0);
        DistributionPointName r2 = this.distributionPoint;
        if (r2 == null) goto L5;
        appendObject(r1, r0, "distributionPoint", r2.toString());
    L5:
        ReasonFlags r3 = this.reasons;
        if (r3 == null) goto L8;
        appendObject(r1, r0, "reasons", r3.toString());
    L8:
        GeneralNames r4 = this.cRLIssuer;
        if (r4 == null) goto L11;
        appendObject(r1, r0, "cRLIssuer", r4.toString());
    L11:
        r1.append("]");
        r1.append(r0);
        return r1.toString();
    }
}
