package org.bouncycastle.asn1.ua;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class DSTU4145ECBinary extends ASN1Object {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ASN1Integer f17968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ASN1OctetString f17969b;
    ASN1OctetString bp;
    DSTU4145BinaryField f;
    ASN1Integer n;
    BigInteger version;

    private DSTU4145ECBinary(ASN1Sequence r5) {
        this.version = BigInteger.valueOf(0);
        int r0 = 0;
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(0), ASN1TaggedObject.class) == false) goto L11;
        ASN1TaggedObject r1 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r5.getObjectAt(0), ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        if (r1.isExplicit() == false) goto L10;
        if (r1.getTagNo() != 0) goto L10;
        this.version = ASN1Integer.getInstance(r1.getLoadedObject()).getValue();
        r0 = 1;
    L10:
        throw new IllegalArgumentException("object parse error");
    L11:
        this.f = DSTU4145BinaryField.getInstance(r5.getObjectAt(r0));
        int r2 = r0 + 1;
        this.f17968a = ASN1Integer.getInstance(r5.getObjectAt(r2));
        int r3 = r2 + 1;
        this.f17969b = ASN1OctetString.getInstance(r5.getObjectAt(r3));
        int r4 = r3 + 1;
        this.n = ASN1Integer.getInstance(r5.getObjectAt(r4));
        this.bp = ASN1OctetString.getInstance(r5.getObjectAt(r4 + 1));
    }

    public static DSTU4145ECBinary getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, DSTU4145ECBinary.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new DSTU4145ECBinary(ASN1Sequence.getInstance(r2));
    L5:
        return (DSTU4145ECBinary) ZeusTransformUtils.preCheckCast(r2, DSTU4145ECBinary.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getA() {
        return this.f17968a.getValue();
    }

    public byte[] getB() {
        return Arrays.clone(this.f17969b.getOctets());
    }

    public DSTU4145BinaryField getField() {
        return this.f;
    }

    public byte[] getG() {
        return Arrays.clone(this.bp.getOctets());
    }

    public BigInteger getN() {
        return this.n.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(6);
        if (this.version.compareTo(BigInteger.valueOf(0)) == 0) goto L5;
        r0.add(new DERTaggedObject(true, 0, new ASN1Integer(this.version)));
    L5:
        r0.add(this.f);
        r0.add(this.f17968a);
        r0.add(this.f17969b);
        r0.add(this.n);
        r0.add(this.bp);
        return new DERSequence(r0);
    }
}
