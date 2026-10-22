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
import org.bouncycastle.pqc.legacy.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes7.dex */
public class McElieceCCA2PublicKey extends ASN1Object {
    private final AlgorithmIdentifier digest;
    private final GF2Matrix g;
    private final int n;
    private final int t;

    public McElieceCCA2PublicKey(int r1, int r2, GF2Matrix r3, AlgorithmIdentifier r4) {
        this.n = r1;
        this.t = r2;
        this.g = new GF2Matrix(r3.getEncoded());
        this.digest = r4;
    }

    private McElieceCCA2PublicKey(ASN1Sequence r5) {
        this.n = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r5.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.t = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r5.getObjectAt(1), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.g = new GF2Matrix(((ASN1OctetString) ZeusTransformUtils.preCheckCast(r5.getObjectAt(2), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets());
        this.digest = AlgorithmIdentifier.getInstance(r5.getObjectAt(3));
    }

    public static McElieceCCA2PublicKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, McElieceCCA2PublicKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new McElieceCCA2PublicKey(ASN1Sequence.getInstance(r2));
    L5:
        return (McElieceCCA2PublicKey) ZeusTransformUtils.preCheckCast(r2, McElieceCCA2PublicKey.class, "com.obric.memorydata.plugin");
    }

    public AlgorithmIdentifier getDigest() {
        return this.digest;
    }

    public GF2Matrix getG() {
        return this.g;
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(new ASN1Integer(this.n));
        r0.add(new ASN1Integer(this.t));
        r0.add(new DEROctetString(this.g.getEncoded()));
        r0.add(this.digest);
        return new DERSequence(r0);
    }
}
