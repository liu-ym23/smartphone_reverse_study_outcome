package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class RSAPrivateKey extends ASN1Object {
    private BigInteger coefficient;
    private BigInteger exponent1;
    private BigInteger exponent2;
    private BigInteger modulus;
    private ASN1Sequence otherPrimeInfos;
    private BigInteger prime1;
    private BigInteger prime2;
    private BigInteger privateExponent;
    private BigInteger publicExponent;
    private BigInteger version;

    public RSAPrivateKey(BigInteger r3, BigInteger r4, BigInteger r5, BigInteger r6, BigInteger r7, BigInteger r8, BigInteger r9, BigInteger r10) {
        this.otherPrimeInfos = null;
        this.version = BigInteger.valueOf(0);
        this.modulus = r3;
        this.publicExponent = r4;
        this.privateExponent = r5;
        this.prime1 = r6;
        this.prime2 = r7;
        this.exponent1 = r8;
        this.exponent2 = r9;
        this.coefficient = r10;
    }

    private RSAPrivateKey(ASN1Sequence r5) {
        this.otherPrimeInfos = null;
        Enumeration r6 = r5.getObjects();
        ASN1Integer r0 = (ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin");
        int r1 = r0.intValueExact();
        if (r1 < 0) goto L11;
        if (r1 > 1) goto L11;
        this.version = r0.getValue();
        this.modulus = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.publicExponent = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.privateExponent = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.prime1 = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.prime2 = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.exponent1 = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.exponent2 = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.coefficient = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        if (r6.hasMoreElements() == false) goto L12;
        this.otherPrimeInfos = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r6.nextElement(), ASN1Sequence.class, "com.obric.memorydata.plugin");
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("wrong version for RSA private key");
    }

    public static RSAPrivateKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RSAPrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RSAPrivateKey(ASN1Sequence.getInstance(r2));
    L5:
        return (RSAPrivateKey) ZeusTransformUtils.preCheckCast(r2, RSAPrivateKey.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getCoefficient() {
        return this.coefficient;
    }

    public BigInteger getExponent1() {
        return this.exponent1;
    }

    public BigInteger getExponent2() {
        return this.exponent2;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPrime1() {
        return this.prime1;
    }

    public BigInteger getPrime2() {
        return this.prime2;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(10);
        r0.add(new ASN1Integer(this.version));
        r0.add(new ASN1Integer(getModulus()));
        r0.add(new ASN1Integer(getPublicExponent()));
        r0.add(new ASN1Integer(getPrivateExponent()));
        r0.add(new ASN1Integer(getPrime1()));
        r0.add(new ASN1Integer(getPrime2()));
        r0.add(new ASN1Integer(getExponent1()));
        r0.add(new ASN1Integer(getExponent2()));
        r0.add(new ASN1Integer(getCoefficient()));
        ASN1Sequence r3 = this.otherPrimeInfos;
        if (r3 == null) goto L6;
        r0.add(r3);
    L6:
        return new DERSequence(r0);
    }
}
