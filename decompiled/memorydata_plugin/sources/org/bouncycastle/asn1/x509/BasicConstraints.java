package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class BasicConstraints extends ASN1Object {
    ASN1Boolean cA;
    ASN1Integer pathLenConstraint;

    private BasicConstraints(ASN1Sequence r5) {
        this.cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        if (r5.size() != 0) goto L6;
        this.cA = null;
        this.pathLenConstraint = null;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(0), ASN1Boolean.class) == false) goto L8;
        this.cA = ASN1Boolean.getInstance(r5.getObjectAt(0));
    L10:
        if (r5.size() > 1) goto L12;
        return;
    L12:
        if (this.cA == null) goto L15;
        this.pathLenConstraint = ASN1Integer.getInstance(r5.getObjectAt(1));
        return;
    L15:
        throw new IllegalArgumentException("wrong sequence in constructor");
    L8:
        this.cA = null;
        this.pathLenConstraint = ASN1Integer.getInstance(r5.getObjectAt(0));
        goto L10
    }

    public static BasicConstraints getInstance(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, BasicConstraints.class) == false) goto L7;
        return (BasicConstraints) ZeusTransformUtils.preCheckCast(r3, BasicConstraints.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, X509Extension.class) == true) goto L9;
        if (r3 != null) goto L12;
        return null;
    L12:
        return new BasicConstraints(ASN1Sequence.getInstance(r3));
    L9:
        return getInstance(X509Extension.convertValueToObject((X509Extension) ZeusTransformUtils.preCheckCast(r3, X509Extension.class, "com.obric.memorydata.plugin")));
    }

    public BigInteger getPathLenConstraint() {
        ASN1Integer r0 = this.pathLenConstraint;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getValue();
    }

    public boolean isCA() {
        ASN1Boolean r0 = this.cA;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isTrue() == false) goto L7;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        ASN1Boolean r1 = this.cA;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        ASN1Integer r2 = this.pathLenConstraint;
        if (r2 == null) goto L9;
        r0.add(r2);
    L9:
        return new DERSequence(r0);
    }

    public String toString() {
        if (this.pathLenConstraint != null) goto L7;
        StringBuilder r2 = new StringBuilder().append("BasicConstraints: isCa(").append(isCA()).append(")");
    L6:
        return r2.toString();
    L7:
        r2 = new StringBuilder().append("BasicConstraints: isCa(").append(isCA()).append("), pathLenConstraint = ").append(this.pathLenConstraint.getValue());
        goto L6
    }
}
