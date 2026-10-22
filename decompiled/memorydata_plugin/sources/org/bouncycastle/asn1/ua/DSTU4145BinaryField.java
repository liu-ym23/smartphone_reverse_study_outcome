package org.bouncycastle.asn1.ua;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class DSTU4145BinaryField extends ASN1Object {
    private int j;
    private int k;
    private int l;
    private int m;

    private DSTU4145BinaryField(ASN1Sequence r5) {
        this.m = ASN1Integer.getInstance(r5.getObjectAt(0)).intPositiveValueExact();
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(1), ASN1Integer.class) == false) goto L6;
        this.k = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r5.getObjectAt(1), ASN1Integer.class, "com.obric.memorydata.plugin")).intPositiveValueExact();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(1), ASN1Sequence.class) == false) goto L10;
        ASN1Sequence r6 = ASN1Sequence.getInstance(r5.getObjectAt(1));
        this.k = ASN1Integer.getInstance(r6.getObjectAt(0)).intPositiveValueExact();
        this.j = ASN1Integer.getInstance(r6.getObjectAt(1)).intPositiveValueExact();
        this.l = ASN1Integer.getInstance(r6.getObjectAt(2)).intPositiveValueExact();
        return;
    L10:
        throw new IllegalArgumentException("object parse error");
    }

    public static DSTU4145BinaryField getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, DSTU4145BinaryField.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new DSTU4145BinaryField(ASN1Sequence.getInstance(r2));
    L5:
        return (DSTU4145BinaryField) ZeusTransformUtils.preCheckCast(r2, DSTU4145BinaryField.class, "com.obric.memorydata.plugin");
    }

    public int getK1() {
        return this.k;
    }

    public int getK2() {
        return this.j;
    }

    public int getK3() {
        return this.l;
    }

    public int getM() {
        return this.m;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(new ASN1Integer(this.m));
        if (this.j != 0) goto L5;
        r0.add(new ASN1Integer(this.k));
    L7:
        return new DERSequence(r0);
    L5:
        ASN1EncodableVector r1 = new ASN1EncodableVector(3);
        r1.add(new ASN1Integer(this.k));
        r1.add(new ASN1Integer(this.j));
        r1.add(new ASN1Integer(this.l));
        r0.add(new DERSequence(r1));
        goto L7
    }
}
