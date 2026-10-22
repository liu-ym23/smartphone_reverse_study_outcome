package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class AlgorithmIdentifier extends ASN1Object {
    private ASN1ObjectIdentifier algorithm;
    private ASN1Encodable parameters;

    public AlgorithmIdentifier(ASN1ObjectIdentifier r1) {
        this.algorithm = r1;
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.algorithm = r3;
        this.parameters = r5;
    }

    private AlgorithmIdentifier(ASN1Sequence r4) {
        if (r4.size() < 1) goto L13;
        if (r4.size() > 2) goto L13;
        this.algorithm = ASN1ObjectIdentifier.getInstance(r4.getObjectAt(0));
        if (r4.size() != 2) goto L9;
        ASN1Encodable r5 = r4.getObjectAt(1);
    L10:
        this.parameters = r5;
        return;
    L9:
        r5 = null;
    L13:
        throw new IllegalArgumentException("Bad sequence size: " + r4.size());
    }

    public static AlgorithmIdentifier getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, AlgorithmIdentifier.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new AlgorithmIdentifier(ASN1Sequence.getInstance(r2));
    L5:
        return (AlgorithmIdentifier) ZeusTransformUtils.preCheckCast(r2, AlgorithmIdentifier.class, "com.obric.memorydata.plugin");
    }

    public static AlgorithmIdentifier getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public ASN1Encodable getParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.algorithm);
        ASN1Encodable r2 = this.parameters;
        if (r2 == null) goto L6;
        r0.add(r2);
    L6:
        return new DERSequence(r0);
    }
}
