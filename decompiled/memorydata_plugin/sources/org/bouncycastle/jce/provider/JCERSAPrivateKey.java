package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

/* JADX INFO: loaded from: classes7.dex */
public class JCERSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    private static BigInteger ZERO = null;
    static final long serialVersionUID = 5110188922551353628L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    protected BigInteger modulus;
    protected BigInteger privateExponent;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    public JCERSAPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    JCERSAPrivateKey(RSAPrivateKey r3) {
        RSAPrivateKey r4 = (RSAPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, RSAPrivateKey.class, "com.obric.memorydata.plugin");
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r4.getModulus();
        this.privateExponent = r4.getPrivateExponent();
    }

    JCERSAPrivateKey(RSAPrivateKeySpec r2) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r2.getModulus();
        this.privateExponent = r2.getPrivateExponent();
    }

    JCERSAPrivateKey(RSAKeyParameters r2) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r2.getModulus();
        this.privateExponent = r2.getExponent();
    }

    private void readObject(ObjectInputStream r4) {
        this.modulus = (BigInteger) ZeusTransformUtils.preCheckCast(r4.readObject(), BigInteger.class, "com.obric.memorydata.plugin");
        PKCS12BagAttributeCarrierImpl r0 = new PKCS12BagAttributeCarrierImpl();
        this.attrCarrier = r0;
        r0.readObject(r4);
        this.privateExponent = (BigInteger) ZeusTransformUtils.preCheckCast(r4.readObject(), BigInteger.class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(this.modulus);
        this.attrCarrier.writeObject(r2);
        r2.writeObject(this.privateExponent);
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
        AlgorithmIdentifier r0 = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
        BigInteger r4 = getModulus();
        BigInteger r5 = ZERO;
        BigInteger r6 = getPrivateExponent();
        BigInteger r11 = ZERO;
        return KeyUtil.getEncodedPrivateKeyInfo(r0, new org.bouncycastle.asn1.pkcs.RSAPrivateKey(r4, r5, r6, r11, r11, r11, r11, r11));
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
}
