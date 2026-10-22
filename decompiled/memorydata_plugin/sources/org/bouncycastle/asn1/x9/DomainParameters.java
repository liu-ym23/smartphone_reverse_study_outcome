package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class DomainParameters extends ASN1Object {
    private final ASN1Integer g;
    private final ASN1Integer j;
    private final ASN1Integer p;
    private final ASN1Integer q;
    private final ValidationParams validationParams;

    public DomainParameters(BigInteger r2, BigInteger r3, BigInteger r4, BigInteger r5, ValidationParams r6) {
        if (r2 == null) goto L17;
        if (r3 == null) goto L15;
        if (r4 == null) goto L13;
        this.p = new ASN1Integer(r2);
        this.g = new ASN1Integer(r3);
        this.q = new ASN1Integer(r4);
        if (r5 == null) goto L9;
        ASN1Integer r7 = new ASN1Integer(r5);
    L10:
        this.j = r7;
        this.validationParams = r6;
        return;
    L9:
        r7 = null;
        goto L10
    L13:
        throw new IllegalArgumentException("'q' cannot be null");
    L15:
        throw new IllegalArgumentException("'g' cannot be null");
    L17:
        throw new IllegalArgumentException("'p' cannot be null");
    }

    private DomainParameters(ASN1Sequence r4) {
        if (r4.size() < 3) goto L17;
        if (r4.size() > 5) goto L17;
        Enumeration r5 = r4.getObjects();
        this.p = ASN1Integer.getInstance(r5.nextElement());
        this.g = ASN1Integer.getInstance(r5.nextElement());
        this.q = ASN1Integer.getInstance(r5.nextElement());
        ASN1Encodable r0 = getNext(r5);
        if (r0 != null) goto L9;
    L11:
        this.j = null;
    L12:
        if (r0 == null) goto L14;
        this.validationParams = ValidationParams.getInstance(r0.toASN1Primitive());
        return;
    L14:
        this.validationParams = null;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, ASN1Integer.class) == false) goto L11;
        this.j = ASN1Integer.getInstance(r0);
        r0 = getNext(r5);
    L17:
        throw new IllegalArgumentException("Bad sequence size: " + r4.size());
    }

    public static DomainParameters getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, DomainParameters.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new DomainParameters(ASN1Sequence.getInstance(r2));
    L5:
        return (DomainParameters) ZeusTransformUtils.preCheckCast(r2, DomainParameters.class, "com.obric.memorydata.plugin");
    }

    private static ASN1Encodable getNext(Enumeration r2) {
        Enumeration r3 = (Enumeration) ZeusTransformUtils.wrapperContextForParams(r2, Enumeration.class, "com.obric.memorydata.plugin");
        if (r3.hasMoreElements() == true) goto L7;
        return null;
    L7:
        return (ASN1Encodable) ZeusTransformUtils.preCheckCast(r3.nextElement(), ASN1Encodable.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getG() {
        return this.g.getPositiveValue();
    }

    public BigInteger getJ() {
        ASN1Integer r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPositiveValue();
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.q.getPositiveValue();
    }

    public ValidationParams getValidationParams() {
        return this.validationParams;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(5);
        r0.add(this.p);
        r0.add(this.g);
        r0.add(this.q);
        ASN1Integer r1 = this.j;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        ValidationParams r2 = this.validationParams;
        if (r2 == null) goto L9;
        r0.add(r2);
    L9:
        return new DERSequence(r0);
    }
}
