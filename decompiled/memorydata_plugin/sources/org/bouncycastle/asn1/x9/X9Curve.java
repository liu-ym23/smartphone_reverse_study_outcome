package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    private ECCurve curve;
    private ASN1ObjectIdentifier fieldIdentifier;
    private byte[] seed;

    public X9Curve(X9FieldID r18, BigInteger r19, BigInteger r20, ASN1Sequence r21) {
        this.fieldIdentifier = null;
        ASN1ObjectIdentifier r2 = r18.getIdentifier();
        this.fieldIdentifier = r2;
        if (r2.equals(prime_field) == false) goto L7;
        ECCurve r3 = new ECCurve.Fp(((ASN1Integer) ZeusTransformUtils.preCheckCast(r18.getParameters(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue(), new BigInteger(1, ASN1OctetString.getInstance(r21.getObjectAt(0)).getOctets()), new BigInteger(1, ASN1OctetString.getInstance(r21.getObjectAt(1)).getOctets()), r19, r20);
    L5:
        this.curve = r3;
        if (r21.size() != 3) goto L23;
        this.seed = ((DERBitString) ZeusTransformUtils.preCheckCast(r21.getObjectAt(2), DERBitString.class, "com.obric.memorydata.plugin")).getBytes();
        return;
    L23:
        return;
    L7:
        if (this.fieldIdentifier.equals(characteristic_two_field) == false) goto L22;
        ASN1Sequence r4 = ASN1Sequence.getInstance(r18.getParameters());
        int r9 = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).intValueExact();
        ASN1ObjectIdentifier r7 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r4.getObjectAt(1), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r7.equals(tpBasis) == false) goto L12;
        int r10 = ASN1Integer.getInstance(r4.getObjectAt(2)).intValueExact();
        int r11 = 0;
        int r12 = 0;
    L14:
        r3 = new ECCurve.F2m(r9, r10, r11, r12, new BigInteger(1, ASN1OctetString.getInstance(r21.getObjectAt(0)).getOctets()), new BigInteger(1, ASN1OctetString.getInstance(r21.getObjectAt(1)).getOctets()), r19, r20);
        goto L5
    L12:
        if (r7.equals(ppBasis) == false) goto L20;
        ASN1Sequence r5 = ASN1Sequence.getInstance(r4.getObjectAt(2));
        int r8 = ASN1Integer.getInstance(r5.getObjectAt(0)).intValueExact();
        int r13 = ASN1Integer.getInstance(r5.getObjectAt(1)).intValueExact();
        r12 = ASN1Integer.getInstance(r5.getObjectAt(2)).intValueExact();
        r10 = r8;
        r11 = r13;
        goto L14
    L20:
        throw new IllegalArgumentException("This type of EC basis is not implemented");
    L22:
        throw new IllegalArgumentException("This type of ECCurve is not implemented");
    }

    public X9Curve(ECCurve r2, byte[] r3) {
        this.fieldIdentifier = null;
        this.curve = r2;
        this.seed = Arrays.clone(r3);
        setFieldIdentifier();
    }

    private void setFieldIdentifier() {
        if (ECAlgorithms.isFpCurve(this.curve) == false) goto L7;
        ASN1ObjectIdentifier r0 = prime_field;
    L5:
        this.fieldIdentifier = r0;
        return;
    L7:
        if (ECAlgorithms.isF2mCurve(this.curve) == false) goto L11;
        r0 = characteristic_two_field;
        goto L5
    L11:
        throw new IllegalArgumentException("This type of ECCurve is not implemented");
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        if (this.fieldIdentifier.equals(prime_field) == false) goto L7;
        r0.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
        X9FieldElement r1 = new X9FieldElement(this.curve.getB());
    L5:
        r0.add(r1.toASN1Primitive());
    L10:
        if (this.seed == null) goto L13;
        r0.add(new DERBitString(this.seed));
    L13:
        return new DERSequence(r0);
    L7:
        if (this.fieldIdentifier.equals(characteristic_two_field) == false) goto L10;
        r0.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
        r1 = new X9FieldElement(this.curve.getB());
        goto L5
    }
}
