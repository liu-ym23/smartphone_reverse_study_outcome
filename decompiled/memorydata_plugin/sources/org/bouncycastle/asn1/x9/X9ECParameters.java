package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    private static final BigInteger ONE = null;
    private ECCurve curve;
    private X9FieldID fieldID;
    private X9ECPoint g;
    private BigInteger h;
    private BigInteger n;
    private byte[] seed;

    static {
        ONE = BigInteger.valueOf(1);
    }

    private X9ECParameters(ASN1Sequence r7) {
        if (ZeusTransformUtils.instanceOf(r7.getObjectAt(0), ASN1Integer.class) == false) goto L16;
        if (((ASN1Integer) ZeusTransformUtils.preCheckCast(r7.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).hasValue(1) == false) goto L16;
        this.n = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r7.getObjectAt(4), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        if (r7.size() != 6) goto L9;
        this.h = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r7.getObjectAt(5), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
    L9:
        X9Curve r0 = new X9Curve(X9FieldID.getInstance(r7.getObjectAt(1)), this.n, this.h, ASN1Sequence.getInstance(r7.getObjectAt(2)));
        this.curve = r0.getCurve();
        ASN1Encodable r8 = r7.getObjectAt(3);
        if (ZeusTransformUtils.instanceOf(r8, X9ECPoint.class) == false) goto L12;
        this.g = (X9ECPoint) ZeusTransformUtils.preCheckCast(r8, X9ECPoint.class, "com.obric.memorydata.plugin");
    L13:
        this.seed = r0.getSeed();
        return;
    L12:
        this.g = new X9ECPoint(this.curve, (ASN1OctetString) ZeusTransformUtils.preCheckCast(r8, ASN1OctetString.class, "com.obric.memorydata.plugin"));
    L16:
        throw new IllegalArgumentException("bad version in X9ECParameters");
    }

    public X9ECParameters(ECCurve r2, X9ECPoint r3, BigInteger r4, BigInteger r5, byte[] r6) {
        this.curve = r2;
        this.g = r3;
        this.n = r4;
        this.h = r5;
        this.seed = Arrays.clone(r6);
        if (ECAlgorithms.isFpCurve(r2) == false) goto L7;
        X9FieldID r7 = new X9FieldID(r2.getField().getCharacteristic());
    L5:
        this.fieldID = r7;
        return;
    L7:
        if (ECAlgorithms.isF2mCurve(r2) == false) goto L18;
        int[] r8 = ((PolynomialExtensionField) ZeusTransformUtils.preCheckCast(r2.getField(), PolynomialExtensionField.class, "com.obric.memorydata.plugin")).getMinimalPolynomial().getExponentsPresent();
        if (r8.length != 3) goto L12;
        r7 = new X9FieldID(r8[2], r8[1]);
        goto L5
    L12:
        if (r8.length != 5) goto L16;
        r7 = new X9FieldID(r8[4], r8[1], r8[2], r8[3]);
        goto L5
    L16:
        throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
    L18:
        throw new IllegalArgumentException("'curve' is of an unsupported type");
    }

    public static X9ECParameters getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, X9ECParameters.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new X9ECParameters(ASN1Sequence.getInstance(r2));
    L5:
        return (X9ECParameters) ZeusTransformUtils.preCheckCast(r2, X9ECParameters.class, "com.obric.memorydata.plugin");
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.g.getPoint();
    }

    public BigInteger getH() {
        return this.h;
    }

    public BigInteger getN() {
        return this.n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(6);
        r0.add(new ASN1Integer(ONE));
        r0.add(this.fieldID);
        r0.add(new X9Curve(this.curve, this.seed));
        r0.add(this.g);
        r0.add(new ASN1Integer(this.n));
        if (this.h == null) goto L6;
        r0.add(new ASN1Integer(this.h));
    L6:
        return new DERSequence(r0);
    }
}
