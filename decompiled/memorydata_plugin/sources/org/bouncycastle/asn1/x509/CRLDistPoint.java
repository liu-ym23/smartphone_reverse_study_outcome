package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class CRLDistPoint extends ASN1Object {
    ASN1Sequence seq;

    private CRLDistPoint(ASN1Sequence r2) {
        this.seq = null;
        this.seq = r2;
    }

    public static CRLDistPoint getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, CRLDistPoint.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new CRLDistPoint(ASN1Sequence.getInstance(r2));
    L5:
        return (CRLDistPoint) ZeusTransformUtils.preCheckCast(r2, CRLDistPoint.class, "com.obric.memorydata.plugin");
    }

    public DistributionPoint[] getDistributionPoints() {
        DistributionPoint[] r0 = new DistributionPoint[this.seq.size()];
        int r1 = 0;
    L4:
        if (r1 == this.seq.size()) goto L6;
        r0[r1] = DistributionPoint.getInstance(this.seq.getObjectAt(r1));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("CRLDistPoint:");
        r0.append(r1);
        DistributionPoint[] r4 = getDistributionPoints();
        int r2 = 0;
    L4:
        if (r2 == r4.length) goto L7;
        r0.append("    ");
        r0.append(r4[r2]);
        r0.append(r1);
        r2 = r2 + 1;
        goto L4
    L7:
        return r0.toString();
    }
}
