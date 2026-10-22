package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class JCERSAPublicKey implements RSAPublicKey {
    static final long serialVersionUID = 2675817738516720772L;
    private BigInteger modulus;
    private BigInteger publicExponent;

    JCERSAPublicKey(RSAPublicKey r3) {
        RSAPublicKey r4 = (RSAPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, RSAPublicKey.class, "com.obric.memorydata.plugin");
        this.modulus = r4.getModulus();
        this.publicExponent = r4.getPublicExponent();
    }

    JCERSAPublicKey(RSAPublicKeySpec r2) {
        this.modulus = r2.getModulus();
        this.publicExponent = r2.getPublicExponent();
    }

    JCERSAPublicKey(SubjectPublicKeyInfo r2) {
        org.bouncycastle.asn1.pkcs.RSAPublicKey r3 = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(r2.parsePublicKey());     // Catch: IOException -> L5
        this.modulus = r3.getModulus();     // Catch: IOException -> L5
        this.publicExponent = r3.getPublicExponent();     // Catch: IOException -> L5
        return;
    L6:
        throw new IllegalArgumentException("invalid info structure in RSA public key");
    }

    JCERSAPublicKey(RSAKeyParameters r2) {
        this.modulus = r2.getModulus();
        this.publicExponent = r2.getExponent();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RSAPublicKey.class) == true) goto L8;
        return false;
    L8:
        RSAPublicKey r6 = (RSAPublicKey) ZeusTransformUtils.preCheckCast(r5, RSAPublicKey.class, "com.obric.memorydata.plugin");
        if (getModulus().equals(r6.getModulus()) == false) goto L14;
        if (getPublicExponent().equals(r6.getPublicExponent()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "RSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new org.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPublicKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int hashCode() {
        int r0 = getModulus().hashCode();
        return getPublicExponent().hashCode() ^ r0;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("RSA Public Key").append(r1);
        r0.append("            modulus: ").append(getModulus().toString(16)).append(r1);
        r0.append("    public exponent: ").append(getPublicExponent().toString(16)).append(r1);
        return r0.toString();
    }
}
