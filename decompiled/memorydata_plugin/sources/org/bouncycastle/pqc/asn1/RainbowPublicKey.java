package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.legacy.crypto.rainbow.util.RainbowUtil;

/* JADX INFO: loaded from: classes7.dex */
public class RainbowPublicKey extends ASN1Object {
    private byte[][] coeffQuadratic;
    private byte[] coeffScalar;
    private byte[][] coeffSingular;
    private ASN1Integer docLength;
    private ASN1ObjectIdentifier oid;
    private ASN1Integer version;

    public RainbowPublicKey(int r4, short[][] r5, short[][] r6, short[] r7) {
        this.version = new ASN1Integer(0);
        this.docLength = new ASN1Integer(r4);
        this.coeffQuadratic = RainbowUtil.convertArray(r5);
        this.coeffSingular = RainbowUtil.convertArray(r6);
        this.coeffScalar = RainbowUtil.convertArray(r7);
    }

    private RainbowPublicKey(ASN1Sequence r7) {
        if (ZeusTransformUtils.instanceOf(r7.getObjectAt(0), ASN1Integer.class) == false) goto L5;
        this.version = ASN1Integer.getInstance(r7.getObjectAt(0));
    L6:
        this.docLength = ASN1Integer.getInstance(r7.getObjectAt(1));
        ASN1Sequence r1 = ASN1Sequence.getInstance(r7.getObjectAt(2));
        this.coeffQuadratic = new byte[r1.size()][];
        int r2 = 0;
    L8:
        if (r2 >= r1.size()) goto L10;
        this.coeffQuadratic[r2] = ASN1OctetString.getInstance(r1.getObjectAt(r2)).getOctets();
        r2 = r2 + 1;
        goto L8
    L10:
        ASN1Sequence r3 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r7.getObjectAt(3), ASN1Sequence.class, "com.obric.memorydata.plugin");
        this.coeffSingular = new byte[r3.size()][];
        int r4 = 0;
    L12:
        if (r4 >= r3.size()) goto L14;
        this.coeffSingular[r4] = ASN1OctetString.getInstance(r3.getObjectAt(r4)).getOctets();
        r4 = r4 + 1;
        goto L12
    L14:
        this.coeffScalar = ASN1OctetString.getInstance(((ASN1Sequence) ZeusTransformUtils.preCheckCast(r7.getObjectAt(4), ASN1Sequence.class, "com.obric.memorydata.plugin")).getObjectAt(0)).getOctets();
        return;
    L5:
        this.oid = ASN1ObjectIdentifier.getInstance(r7.getObjectAt(0));
        goto L6
    }

    public static RainbowPublicKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RainbowPublicKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RainbowPublicKey(ASN1Sequence.getInstance(r2));
    L5:
        return (RainbowPublicKey) ZeusTransformUtils.preCheckCast(r2, RainbowPublicKey.class, "com.obric.memorydata.plugin");
    }

    public short[][] getCoeffQuadratic() {
        return RainbowUtil.convertArray(this.coeffQuadratic);
    }

    public short[] getCoeffScalar() {
        return RainbowUtil.convertArray(this.coeffScalar);
    }

    public short[][] getCoeffSingular() {
        return RainbowUtil.convertArray(this.coeffSingular);
    }

    public int getDocLength() {
        return this.docLength.intValueExact();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        ASN1Encodable r1 = this.version;
        if (r1 != null) goto L6;
        r1 = this.oid;
    L6:
        r0.add(r1);
        r0.add(this.docLength);
        ASN1EncodableVector r2 = new ASN1EncodableVector();
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r4 >= this.coeffQuadratic.length) goto L10;
        r2.add(new DEROctetString(this.coeffQuadratic[r4]));
        r4 = r4 + 1;
        goto L8
    L10:
        r0.add(new DERSequence(r2));
        ASN1EncodableVector r5 = new ASN1EncodableVector();
    L12:
        if (r3 >= this.coeffSingular.length) goto L14;
        r5.add(new DEROctetString(this.coeffSingular[r3]));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.add(new DERSequence(r5));
        ASN1EncodableVector r6 = new ASN1EncodableVector();
        r6.add(new DEROctetString(this.coeffScalar));
        r0.add(new DERSequence(r6));
        return new DERSequence(r0);
    }
}
