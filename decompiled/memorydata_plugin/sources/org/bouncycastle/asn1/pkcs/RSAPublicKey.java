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
public class RSAPublicKey extends ASN1Object {
    private BigInteger modulus;
    private BigInteger publicExponent;

    public RSAPublicKey(BigInteger r1, BigInteger r2) {
        this.modulus = r1;
        this.publicExponent = r2;
    }

    private RSAPublicKey(ASN1Sequence r3) {
        if (r3.size() != 2) goto L7;
        Enumeration r4 = r3.getObjects();
        this.modulus = ASN1Integer.getInstance(r4.nextElement()).getPositiveValue();
        this.publicExponent = ASN1Integer.getInstance(r4.nextElement()).getPositiveValue();
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public static RSAPublicKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RSAPublicKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RSAPublicKey(ASN1Sequence.getInstance(r2));
    L5:
        return (RSAPublicKey) ZeusTransformUtils.preCheckCast(r2, RSAPublicKey.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(new ASN1Integer(getModulus()));
        r0.add(new ASN1Integer(getPublicExponent()));
        return new DERSequence(r0);
    }
}
