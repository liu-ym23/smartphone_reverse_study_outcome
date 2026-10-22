package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class IssuingDistributionPoint extends ASN1Object {
    private DistributionPointName distributionPoint;
    private boolean indirectCRL;
    private boolean onlyContainsAttributeCerts;
    private boolean onlyContainsCACerts;
    private boolean onlyContainsUserCerts;
    private ReasonFlags onlySomeReasons;
    private ASN1Sequence seq;

    private IssuingDistributionPoint(ASN1Sequence r6) {
        this.seq = r6;
        int r1 = 0;
    L4:
        if (r1 == r6.size()) goto L25;
        ASN1TaggedObject r2 = ASN1TaggedObject.getInstance(r6.getObjectAt(r1));
        int r3 = r2.getTagNo();
        if (r3 == 0) goto L23;
        if (r3 != 1) goto L9;
        this.onlyContainsUserCerts = ASN1Boolean.getInstance(r2, false).isTrue();
    L24:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r3 != 2) goto L11;
        this.onlyContainsCACerts = ASN1Boolean.getInstance(r2, false).isTrue();
        goto L24
    L11:
        if (r3 != 3) goto L13;
        this.onlySomeReasons = new ReasonFlags(ASN1BitString.getInstance(r2, false));
        goto L24
    L13:
        if (r3 != 4) goto L15;
        this.indirectCRL = ASN1Boolean.getInstance(r2, false).isTrue();
        goto L24
    L15:
        if (r3 != 5) goto L18;
        this.onlyContainsAttributeCerts = ASN1Boolean.getInstance(r2, false).isTrue();
        goto L24
    L18:
        throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
    L23:
        this.distributionPoint = DistributionPointName.getInstance(r2, true);
        goto L24
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

    private String booleanToString(boolean r1) {
        if (r1 == false) goto L4;
        return "true";
    L4:
        return "false";
    }

    public static IssuingDistributionPoint getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, IssuingDistributionPoint.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new IssuingDistributionPoint(ASN1Sequence.getInstance(r2));
    L5:
        return (IssuingDistributionPoint) ZeusTransformUtils.preCheckCast(r2, IssuingDistributionPoint.class, "com.obric.memorydata.plugin");
    }

    public boolean isIndirectCRL() {
        return this.indirectCRL;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        String r0 = Strings.lineSeparator();
        StringBuffer r1 = new StringBuffer();
        r1.append("IssuingDistributionPoint: [");
        r1.append(r0);
        DistributionPointName r2 = this.distributionPoint;
        if (r2 == null) goto L5;
        appendObject(r1, r0, "distributionPoint", r2.toString());
    L5:
        boolean r3 = this.onlyContainsUserCerts;
        if (r3 == false) goto L8;
        appendObject(r1, r0, "onlyContainsUserCerts", booleanToString(r3));
    L8:
        boolean r4 = this.onlyContainsCACerts;
        if (r4 == false) goto L11;
        appendObject(r1, r0, "onlyContainsCACerts", booleanToString(r4));
    L11:
        ReasonFlags r5 = this.onlySomeReasons;
        if (r5 == null) goto L14;
        appendObject(r1, r0, "onlySomeReasons", r5.toString());
    L14:
        boolean r6 = this.onlyContainsAttributeCerts;
        if (r6 == false) goto L17;
        appendObject(r1, r0, "onlyContainsAttributeCerts", booleanToString(r6));
    L17:
        boolean r7 = this.indirectCRL;
        if (r7 == false) goto L20;
        appendObject(r1, r0, "indirectCRL", booleanToString(r7));
    L20:
        r1.append("]");
        r1.append(r0);
        return r1.toString();
    }
}
