package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class DistributionPointName extends ASN1Object implements ASN1Choice {
    ASN1Encodable name;
    int type;

    public DistributionPointName(ASN1TaggedObject r3) {
        int r0 = r3.getTagNo();
        this.type = r0;
        if (r0 != 0) goto L5;
        ASN1Encodable r4 = GeneralNames.getInstance(r3, false);
    L6:
        this.name = r4;
        return;
    L5:
        r4 = ASN1Set.getInstance(r3, false);
        goto L6
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

    public static DistributionPointName getInstance(Object r3) {
        if (r3 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, DistributionPointName.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, ASN1TaggedObject.class) == false) goto L12;
        return new DistributionPointName((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r3, ASN1TaggedObject.class, "com.obric.memorydata.plugin"));
    L12:
        throw new IllegalArgumentException("unknown object in factory: " + r3.getClass().getName());
    L14:
        return (DistributionPointName) ZeusTransformUtils.preCheckCast(r3, DistributionPointName.class, "com.obric.memorydata.plugin");
    }

    public static DistributionPointName getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1TaggedObject.getInstance(r0, true));
    }

    public int getType() {
        return this.type;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.type, this.name);
    }

    public String toString() {
        String r0 = Strings.lineSeparator();
        StringBuffer r1 = new StringBuffer();
        r1.append("DistributionPointName: [");
        r1.append(r0);
        if (this.type != 0) goto L5;
        String r2 = this.name.toString();
        String r3 = "fullName";
    L6:
        appendObject(r1, r0, r3, r2);
        r1.append("]");
        r1.append(r0);
        return r1.toString();
    L5:
        r2 = this.name.toString();
        r3 = "nameRelativeToCRLIssuer";
        goto L6
    }
}
