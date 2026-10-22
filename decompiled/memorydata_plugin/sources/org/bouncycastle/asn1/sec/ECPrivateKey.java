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
public class ECPrivateKey extends ASN1Object {
    private ASN1Sequence seq;

    public ECPrivateKey(int r4, BigInteger r5, ASN1BitString r6, ASN1Encodable r7) {
        ASN1Encodable r8 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r7, ASN1Encodable.class, "com.obric.memorydata.plugin");
        byte[] r9 = BigIntegers.asUnsignedByteArray((r4 + 7) / 8, r5);
        ASN1EncodableVector r10 = new ASN1EncodableVector(4);
        r10.add(new ASN1Integer(1));
        r10.add(new DEROctetString(r9));
        if (r8 == null) goto L5;
        r10.add(new DERTaggedObject(true, 0, r8));
    L5:
        if (r6 == null) goto L7;
        r10.add(new DERTaggedObject(true, 1, r6));
    L7:
        this.seq = new DERSequence(r10);
    }

    public ECPrivateKey(int r3, BigInteger r4, ASN1Encodable r5) {
        this(r3, r4, null, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r5, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    private ECPrivateKey(ASN1Sequence r1) {
        this.seq = r1;
    }

    public static ECPrivateKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ECPrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ECPrivateKey(ASN1Sequence.getInstance(r2));
    L5:
        return (ECPrivateKey) ZeusTransformUtils.preCheckCast(r2, ECPrivateKey.class, "com.obric.memorydata.plugin");
    }

    private ASN1Object getObjectInTag(int r4, int r5) {
        Enumeration r3 = this.seq.getObjects();
    L4:
        if (r3.hasMoreElements() == false) goto L13;
        ASN1Encodable r0 = (ASN1Encodable) ZeusTransformUtils.preCheckCast(r3.nextElement(), ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, ASN1TaggedObject.class) == false) goto L4;
        ASN1TaggedObject r1 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r0, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        if (r1.hasContextTag(r4) == false) goto L4;
        if (r5 >= 0) goto L12;
        return r1.getExplicitBaseObject().toASN1Primitive();
    L12:
        return r1.getBaseUniversal(true, r5);
    L13:
        return null;
    }

    public BigInteger getKey() {
        return new BigInteger(1, ((ASN1OctetString) ZeusTransformUtils.preCheckCast(this.seq.getObjectAt(1), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets());
    }

    public ASN1Object getParametersObject() {
        return getObjectInTag(0, -1);
    }

    public ASN1BitString getPublicKey() {
        return (ASN1BitString) ZeusTransformUtils.preCheckCast(getObjectInTag(1, 3), ASN1BitString.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
