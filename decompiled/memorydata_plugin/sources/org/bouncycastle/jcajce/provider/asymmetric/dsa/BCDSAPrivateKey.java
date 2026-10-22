package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class BCDSAPrivateKey implements DSAPrivateKey, PKCS12BagAttributeCarrier {
    private static final long serialVersionUID = -4677259546958385734L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient DSAParams dsaSpec;
    private BigInteger x;

    public BCDSAPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    BCDSAPrivateKey(DSAPrivateKey r3) {
        DSAPrivateKey r4 = (DSAPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, DSAPrivateKey.class, "com.obric.memorydata.plugin");
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.dsaSpec = r4.getParams();
    }

    BCDSAPrivateKey(DSAPrivateKeySpec r4) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.dsaSpec = new DSAParameterSpec(r4.getP(), r4.getQ(), r4.getG());
    }

    public BCDSAPrivateKey(PrivateKeyInfo r4) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        DSAParameter r0 = DSAParameter.getInstance(r4.getPrivateKeyAlgorithm().getParameters());
        this.x = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r4.parsePrivateKey(), ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
        this.dsaSpec = new DSAParameterSpec(r0.getP(), r0.getQ(), r0.getG());
    }

    BCDSAPrivateKey(DSAPrivateKeyParameters r4) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.x = r4.getX();
        this.dsaSpec = new DSAParameterSpec(r4.getParameters().getP(), r4.getParameters().getQ(), r4.getParameters().getG());
    }

    private void readObject(ObjectInputStream r6) {
        r6.defaultReadObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6.readObject(), BigInteger.class, "com.obric.memorydata.plugin"));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(this.dsaSpec.getP());
        r2.writeObject(this.dsaSpec.getQ());
        r2.writeObject(this.dsaSpec.getG());
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DSAPrivateKey.class) == true) goto L5;
        return false;
    L5:
        DSAPrivateKey r5 = (DSAPrivateKey) ZeusTransformUtils.preCheckCast(r4, DSAPrivateKey.class, "com.obric.memorydata.plugin");
        if (getX().equals(r5.getX()) == true) goto L8;
        return false;
    L8:
        if (getParams().getG().equals(r5.getParams().getG()) == true) goto L10;
        return false;
    L10:
        if (getParams().getP().equals(r5.getParams().getP()) == true) goto L12;
        return false;
    L12:
        if (getParams().getQ().equals(r5.getParams().getQ()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
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
        return KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).toASN1Primitive()), new ASN1Integer(getX()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.dsaSpec;
    }

    @Override // java.security.interfaces.DSAPrivateKey
    public BigInteger getX() {
        return this.x;
    }

    public int hashCode() {
        int r0 = (getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode();
        return getParams().getQ().hashCode() ^ r0;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        BigInteger r2 = getParams().getG().modPow(this.x, getParams().getP());
        r0.append("DSA Private Key [").append(DSAUtil.generateKeyFingerprint(r2, getParams())).append("]").append(r1);
        r0.append("            Y: ").append(r2.toString(16)).append(r1);
        return r0.toString();
    }
}
