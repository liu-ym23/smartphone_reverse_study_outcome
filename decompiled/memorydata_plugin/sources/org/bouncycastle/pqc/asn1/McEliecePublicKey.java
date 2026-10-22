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

/* JADX INFO: loaded from: classes7.dex */
public class McEliecePublicKey extends ASN1Object {
    private final GF2Matrix g;
    private final int n;
    private final int t;

    public McEliecePublicKey(int r1, int r2, GF2Matrix r3) {
        this.n = r1;
        this.t = r2;
        this.g = new GF2Matrix(r3);
    }

    private McEliecePublicKey(ASN1Sequence r4) {
        this.n = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.t = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(1), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        this.g = new GF2Matrix(((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(2), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets());
    }

    public static McEliecePublicKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, McEliecePublicKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new McEliecePublicKey(ASN1Sequence.getInstance(r2));
    L5:
        return (McEliecePublicKey) ZeusTransformUtils.preCheckCast(r2, McEliecePublicKey.class, "com.obric.memorydata.plugin");
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.g);
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
        return new DERSequence(r0);
    }
}
