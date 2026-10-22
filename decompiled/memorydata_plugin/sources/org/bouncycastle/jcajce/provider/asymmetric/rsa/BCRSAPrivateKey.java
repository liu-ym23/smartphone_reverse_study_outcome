package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class BCRSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    private static BigInteger ZERO = null;
    static final long serialVersionUID = 5110188922551353628L;
    protected transient AlgorithmIdentifier algorithmIdentifier;
    private byte[] algorithmIdentifierEnc;
    protected transient PKCS12BagAttributeCarrierImpl attrCarrier;
    protected BigInteger modulus;
    protected BigInteger privateExponent;
    protected transient RSAKeyParameters rsaPrivateKey;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    BCRSAPrivateKey(RSAPrivateKey r4) {
        RSAPrivateKey r5 = (RSAPrivateKey) ZeusTransformUtils.wrapperContextForParams(r4, RSAPrivateKey.class, "com.obric.memorydata.plugin");
        this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
        this.algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r5.getModulus();
        this.privateExponent = r5.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    BCRSAPrivateKey(RSAPrivateKeySpec r4) {
        this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
        this.algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r4.getModulus();
        this.privateExponent = r4.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    BCRSAPrivateKey(AlgorithmIdentifier r3, org.bouncycastle.asn1.pkcs.RSAPrivateKey r4) {
        this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
        this.algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithmIdentifier = r3;
        this.algorithmIdentifierEnc = getEncoding(r3);
        this.modulus = r4.getModulus();
        this.privateExponent = r4.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    BCRSAPrivateKey(AlgorithmIdentifier r2, RSAKeyParameters r3) {
        this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
        this.algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithmIdentifier = r2;
        this.algorithmIdentifierEnc = getEncoding(r2);
        this.modulus = r3.getModulus();
        this.privateExponent = r3.getExponent();
        this.rsaPrivateKey = r3;
    }

    BCRSAPrivateKey(RSAKeyParameters r2) {
        this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
        this.algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r2.getModulus();
        this.privateExponent = r2.getExponent();
        this.rsaPrivateKey = r2;
    }

    private static byte[] getEncoding(AlgorithmIdentifier r0) {
        return r0.getEncoded();
    L4:
        return null;
    }

    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        if (this.algorithmIdentifierEnc != null) goto L5;
        this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
    L5:
        this.algorithmIdentifier = AlgorithmIdentifier.getInstance(this.algorithmIdentifierEnc);
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
    }

    RSAKeyParameters engineGetKeyParameters() {
        return this.rsaPrivateKey;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, RSAPrivateKey.class) == true) goto L6;
        return false;
    L6:
        if (r5 != this) goto L8;
        return true;
    L8:
        RSAPrivateKey r6 = (RSAPrivateKey) ZeusTransformUtils.preCheckCast(r5, RSAPrivateKey.class, "com.obric.memorydata.plugin");
        if (getModulus().equals(r6.getModulus()) == true) goto L11;
        return false;
    L11:
        if (getPrivateExponent().equals(r6.getPrivateExponent()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        if (this.algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L6;
        return "RSASSA-PSS";
    L6:
        return "RSA";
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r1) {
        return this.attrCarrier.getBagAttribute(r1);
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        AlgorithmIdentifier r0 = this.algorithmIdentifier;
        BigInteger r2 = getModulus();
        BigInteger r3 = ZERO;
        BigInteger r4 = getPrivateExponent();
        BigInteger r9 = ZERO;
        return KeyUtil.getEncodedPrivateKeyInfo(r0, new org.bouncycastle.asn1.pkcs.RSAPrivateKey(r2, r3, r4, r9, r9, r9, r9, r9));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPrivateKey
    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public int hashCode() {
        int r0 = getModulus().hashCode();
        return getPrivateExponent().hashCode() ^ r0;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("RSA Private Key [").append(RSAUtil.generateKeyFingerprint(getModulus())).append("],[]").append(r1);
        r0.append("            modulus: ").append(getModulus().toString(16)).append(r1);
        return r0.toString();
    }
}
