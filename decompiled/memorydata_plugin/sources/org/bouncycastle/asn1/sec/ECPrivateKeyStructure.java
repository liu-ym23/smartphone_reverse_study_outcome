package org.bouncycastle.asn1.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class ECPrivateKeyStructure extends ASN1Object {
    private ASN1Sequence seq;

    public ECPrivateKeyStructure(BigInteger r5, ASN1BitString r6, ASN1Encodable r7) {
        ASN1Encodable r8 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r7, ASN1Encodable.class, "com.obric.memorydata.plugin");
        byte[] r9 = BigIntegers.asUnsignedByteArray(r5);
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        r0.add(new ASN1Integer(1));
        r0.add(new DEROctetString(r9));
        if (r8 == null) goto L5;
        r0.add(new DERTaggedObject(true, 0, r8));
    L5:
        if (r6 == null) goto L7;
        r0.add(new DERTaggedObject(true, 1, r6));
        r0.add(new DERTaggedObject(true, 1, r6));
    L7:
        this.seq = new DERSequence(r0);
    }

    public ECPrivateKeyStructure(BigInteger r3, ASN1Encodable r4) {
        this(r3, null, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    public ECPrivateKeyStructure(ASN1Sequence r1) {
        this.seq = r1;
    }

    private ASN1Primitive getObjectInTag(int r4) {
        Enumeration r3 = this.seq.getObjects();
    L4:
        if (r3.hasMoreElements() == false) goto L11;
        ASN1Encodable r0 = (ASN1Encodable) ZeusTransformUtils.preCheckCast(r3.nextElement(), ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, ASN1TaggedObject.class) == false) goto L4;
        ASN1TaggedObject r1 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r0, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        if (r1.getTagNo() != r4) goto L4;
        return r1.getObject().toASN1Primitive();
    L11:
        return null;
    }

    public BigInteger getKey() {
        return new BigInteger(1, ((ASN1OctetString) ZeusTransformUtils.preCheckCast(this.seq.getObjectAt(1), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets());
    }

    public ASN1BitString getPublicKey() {
        return (ASN1BitString) ZeusTransformUtils.preCheckCast(getObjectInTag(1), ASN1BitString.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
