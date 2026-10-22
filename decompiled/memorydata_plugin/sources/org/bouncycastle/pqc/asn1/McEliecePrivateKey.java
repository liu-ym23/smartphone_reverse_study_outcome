package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.legacy.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.legacy.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes7.dex */
public class McEliecePrivateKey extends ASN1Object {
    private byte[] encField;
    private byte[] encGp;
    private byte[] encP1;
    private byte[] encP2;
    private byte[] encSInv;
    private int k;
    private int n;

    public McEliecePrivateKey(int r1, int r2, GF2mField r3, PolynomialGF2mSmallM r4, Permutation r5, Permutation r6, GF2Matrix r7) {
        this.n = r1;
        this.k = r2;
        this.encField = r3.getEncoded();
        this.encGp = r4.getEncoded();
        this.encSInv = r7.getEncoded();
        this.encP1 = r5.getEncoded();
        this.encP2 = r6.getEncoded();
    }

    private McEliecePrivateKey(ASN1Sequence r4) {
        this.n = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.k = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(1), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.encField = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(2), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.encGp = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(3), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.encP1 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(4), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.encP2 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(5), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.encSInv = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(6), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
    }

    public static McEliecePrivateKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, McEliecePrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new McEliecePrivateKey(ASN1Sequence.getInstance(r2));
    L5:
        return (McEliecePrivateKey) ZeusTransformUtils.preCheckCast(r2, McEliecePrivateKey.class, "com.obric.memorydata.plugin");
    }

    public GF2mField getField() {
        return new GF2mField(this.encField);
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return new PolynomialGF2mSmallM(getField(), this.encGp);
    }

    public int getK() {
        return this.k;
    }

    public int getN() {
        return this.n;
    }

    public Permutation getP1() {
        return new Permutation(this.encP1);
    }

    public Permutation getP2() {
        return new Permutation(this.encP2);
    }

    public GF2Matrix getSInv() {
        return new GF2Matrix(this.encSInv);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(new ASN1Integer(this.n));
        r0.add(new ASN1Integer(this.k));
        r0.add(new DEROctetString(this.encField));
        r0.add(new DEROctetString(this.encGp));
        r0.add(new DEROctetString(this.encP1));
        r0.add(new DEROctetString(this.encP2));
        r0.add(new DEROctetString(this.encSInv));
        return new DERSequence(r0);
    }
}
