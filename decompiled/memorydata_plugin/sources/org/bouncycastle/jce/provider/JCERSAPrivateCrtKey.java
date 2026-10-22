package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class JCERSAPrivateCrtKey extends JCERSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    JCERSAPrivateCrtKey(RSAPrivateCrtKey r3) {
        RSAPrivateCrtKey r4 = (RSAPrivateCrtKey) ZeusTransformUtils.wrapperContextForParams(r3, RSAPrivateCrtKey.class, "com.obric.memorydata.plugin");
        this.modulus = r4.getModulus();
        this.publicExponent = r4.getPublicExponent();
        this.privateExponent = r4.getPrivateExponent();
        this.primeP = r4.getPrimeP();
        this.primeQ = r4.getPrimeQ();
        this.primeExponentP = r4.getPrimeExponentP();
        this.primeExponentQ = r4.getPrimeExponentQ();
        this.crtCoefficient = r4.getCrtCoefficient();
    }

    JCERSAPrivateCrtKey(RSAPrivateCrtKeySpec r2) {
        this.modulus = r2.getModulus();
        this.publicExponent = r2.getPublicExponent();
        this.privateExponent = r2.getPrivateExponent();
        this.primeP = r2.getPrimeP();
        this.primeQ = r2.getPrimeQ();
        this.primeExponentP = r2.getPrimeExponentP();
        this.primeExponentQ = r2.getPrimeExponentQ();
        this.crtCoefficient = r2.getCrtCoefficient();
    }

    JCERSAPrivateCrtKey(PrivateKeyInfo r1) {
        this(RSAPrivateKey.getInstance(r1.parsePrivateKey()));
    }

    JCERSAPrivateCrtKey(RSAPrivateKey r2) {
        this.modulus = r2.getModulus();
        this.publicExponent = r2.getPublicExponent();
        this.privateExponent = r2.getPrivateExponent();
        this.primeP = r2.getPrime1();
        this.primeQ = r2.getPrime2();
        this.primeExponentP = r2.getExponent1();
        this.primeExponentQ = r2.getExponent2();
        this.crtCoefficient = r2.getCoefficient();
    }

    JCERSAPrivateCrtKey(RSAPrivateCrtKeyParameters r2) {
        super(r2);
        this.publicExponent = r2.getPublicExponent();
        this.primeP = r2.getP();
        this.primeQ = r2.getQ();
        this.primeExponentP = r2.getDP();
        this.primeExponentQ = r2.getDQ();
        this.crtCoefficient = r2.getQInv();
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RSAPrivateCrtKey.class) == true) goto L8;
        return false;
    L8:
        RSAPrivateCrtKey r6 = (RSAPrivateCrtKey) ZeusTransformUtils.preCheckCast(r5, RSAPrivateCrtKey.class, "com.obric.memorydata.plugin");
        if (getModulus().equals(r6.getModulus()) == false) goto L26;
        if (getPublicExponent().equals(r6.getPublicExponent()) == false) goto L26;
        if (getPrivateExponent().equals(r6.getPrivateExponent()) == false) goto L26;
        if (getPrimeP().equals(r6.getPrimeP()) == false) goto L26;
        if (getPrimeQ().equals(r6.getPrimeQ()) == false) goto L26;
        if (getPrimeExponentP().equals(r6.getPrimeExponentP()) == false) goto L26;
        if (getPrimeExponentQ().equals(r6.getPrimeExponentQ()) == false) goto L26;
        if (getCrtCoefficient().equals(r6.getCrtCoefficient()) == false) goto L26;
        return true;
    L26:
        return false;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getCrtCoefficient() {
        return this.crtCoefficient;
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey, java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentP() {
        return this.primeExponentP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentQ() {
        return this.primeExponentQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeP() {
        return this.primeP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeQ() {
        return this.primeQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey
    public int hashCode() {
        int r0 = getModulus().hashCode() ^ getPublicExponent().hashCode();
        return getPrivateExponent().hashCode() ^ r0;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("RSA Private CRT Key").append(r1);
        r0.append("            modulus: ").append(getModulus().toString(16)).append(r1);
        r0.append("    public exponent: ").append(getPublicExponent().toString(16)).append(r1);
        r0.append("   private exponent: ").append(getPrivateExponent().toString(16)).append(r1);
        r0.append("             primeP: ").append(getPrimeP().toString(16)).append(r1);
        r0.append("             primeQ: ").append(getPrimeQ().toString(16)).append(r1);
        r0.append("     primeExponentP: ").append(getPrimeExponentP().toString(16)).append(r1);
        r0.append("     primeExponentQ: ").append(getPrimeExponentQ().toString(16)).append(r1);
        r0.append("     crtCoefficient: ").append(getCrtCoefficient().toString(16)).append(r1);
        return r0.toString();
    }
}
