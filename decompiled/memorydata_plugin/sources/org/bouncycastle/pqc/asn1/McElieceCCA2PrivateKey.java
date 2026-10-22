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
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.legacy.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.legacy.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes7.dex */
public class McElieceCCA2PrivateKey extends ASN1Object {
    private AlgorithmIdentifier digest;
    private byte[] encField;
    private byte[] encGp;
    private byte[] encP;
    private int k;
    private int n;

    public McElieceCCA2PrivateKey(int r1, int r2, GF2mField r3, PolynomialGF2mSmallM r4, Permutation r5, AlgorithmIdentifier r6) {
        this.n = r1;
        this.k = r2;
        this.encField = r3.getEncoded();
        this.encGp = r4.getEncoded();
        this.encP = r5.getEncoded();
        this.digest = r6;
    }

    private McElieceCCA2PrivateKey(ASN1Sequence r4) {
        this.n = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.k = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(1), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.encField = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(2), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.encGp = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(3), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.encP = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(4), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.digest = AlgorithmIdentifier.getInstance(r4.getObjectAt(5));
    }

    public static McElieceCCA2PrivateKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, McElieceCCA2PrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new McElieceCCA2PrivateKey(ASN1Sequence.getInstance(r2));
    L5:
        return (McElieceCCA2PrivateKey) ZeusTransformUtils.preCheckCast(r2, McElieceCCA2PrivateKey.class, "com.obric.memorydata.plugin");
    }

    public AlgorithmIdentifier getDigest() {
        return this.digest;
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

    public Permutation getP() {
        return new Permutation(this.encP);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(new ASN1Integer(this.n));
        r0.add(new ASN1Integer(this.k));
        r0.add(new DEROctetString(this.encField));
        r0.add(new DEROctetString(this.encGp));
        r0.add(new DEROctetString(this.encP));
        r0.add(this.digest);
        return new DERSequence(r0);
    }
}
