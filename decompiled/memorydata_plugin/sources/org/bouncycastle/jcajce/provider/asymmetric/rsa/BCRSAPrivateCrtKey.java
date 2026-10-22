package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class BCRSAPrivateCrtKey extends BCRSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    BCRSAPrivateCrtKey(RSAPrivateCrtKey r11) {
        RSAPrivateCrtKey r12 = (RSAPrivateCrtKey) ZeusTransformUtils.wrapperContextForParams(r11, RSAPrivateCrtKey.class, "com.obric.memorydata.plugin");
        super(new RSAPrivateCrtKeyParameters(r12.getModulus(), r12.getPublicExponent(), r12.getPrivateExponent(), r12.getPrimeP(), r12.getPrimeQ(), r12.getPrimeExponentP(), r12.getPrimeExponentQ(), r12.getCrtCoefficient()));
        this.modulus = r12.getModulus();
        this.publicExponent = r12.getPublicExponent();
        this.privateExponent = r12.getPrivateExponent();
        this.primeP = r12.getPrimeP();
        this.primeQ = r12.getPrimeQ();
        this.primeExponentP = r12.getPrimeExponentP();
        this.primeExponentQ = r12.getPrimeExponentQ();
        this.crtCoefficient = r12.getCrtCoefficient();
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec r11) {
        super(new RSAPrivateCrtKeyParameters(r11.getModulus(), r11.getPublicExponent(), r11.getPrivateExponent(), r11.getPrimeP(), r11.getPrimeQ(), r11.getPrimeExponentP(), r11.getPrimeExponentQ(), r11.getCrtCoefficient()));
        this.modulus = r11.getModulus();
        this.publicExponent = r11.getPublicExponent();
        this.privateExponent = r11.getPrivateExponent();
        this.primeP = r11.getPrimeP();
        this.primeQ = r11.getPrimeQ();
        this.primeExponentP = r11.getPrimeExponentP();
        this.primeExponentQ = r11.getPrimeExponentQ();
        this.crtCoefficient = r11.getCrtCoefficient();
    }

    BCRSAPrivateCrtKey(PrivateKeyInfo r2) {
        this(r2.getPrivateKeyAlgorithm(), RSAPrivateKey.getInstance(r2.parsePrivateKey()));
    }

    BCRSAPrivateCrtKey(RSAPrivateKey r2) {
        this(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER, r2);
    }

    BCRSAPrivateCrtKey(AlgorithmIdentifier r11, RSAPrivateKey r12) {
        super(r11, new RSAPrivateCrtKeyParameters(r12.getModulus(), r12.getPublicExponent(), r12.getPrivateExponent(), r12.getPrime1(), r12.getPrime2(), r12.getExponent1(), r12.getExponent2(), r12.getCoefficient()));
        this.modulus = r12.getModulus();
        this.publicExponent = r12.getPublicExponent();
        this.privateExponent = r12.getPrivateExponent();
        this.primeP = r12.getPrime1();
        this.primeQ = r12.getPrime2();
        this.primeExponentP = r12.getExponent1();
        this.primeExponentQ = r12.getExponent2();
        this.crtCoefficient = r12.getCoefficient();
    }

    BCRSAPrivateCrtKey(AlgorithmIdentifier r1, RSAPrivateCrtKeyParameters r2) {
        super(r1, r2);
        this.publicExponent = r2.getPublicExponent();
        this.primeP = r2.getP();
        this.primeQ = r2.getQ();
        this.primeExponentP = r2.getDP();
        this.primeExponentQ = r2.getDQ();
        this.crtCoefficient = r2.getQInv();
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKeyParameters r2) {
        super(r2);
        this.publicExponent = r2.getPublicExponent();
        this.primeP = r2.getP();
        this.primeQ = r2.getQ();
        this.primeExponentP = r2.getDP();
        this.primeExponentQ = r2.getDQ();
        this.crtCoefficient = r2.getQInv();
    }

    private void readObject(ObjectInputStream r10) {
        r10.defaultReadObject();
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.rsaPrivateKey = new RSAPrivateCrtKeyParameters(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient());
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
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

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedPrivateKeyInfo(this.algorithmIdentifier, new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
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

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
    public int hashCode() {
        int r0 = getModulus().hashCode() ^ getPublicExponent().hashCode();
        return getPrivateExponent().hashCode() ^ r0;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("RSA Private CRT Key [").append(RSAUtil.generateKeyFingerprint(getModulus())).append("]").append(",[").append(RSAUtil.generateExponentFingerprint(getPublicExponent())).append("]").append(r1);
        r0.append("             modulus: ").append(getModulus().toString(16)).append(r1);
        r0.append("     public exponent: ").append(getPublicExponent().toString(16)).append(r1);
        return r0.toString();
    }
}
