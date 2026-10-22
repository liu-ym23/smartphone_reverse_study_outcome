package org.bouncycastle.jce.provider;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class JCEECPrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    private String algorithm;
    private PKCS12BagAttributeCarrierImpl attrCarrier;
    private BigInteger d;
    private ECParameterSpec ecSpec;
    private ASN1BitString publicKey;
    private boolean withCompression;

    public JCEECPrivateKey() {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public JCEECPrivateKey(String r2, ECPrivateKeySpec r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.getS();
        this.ecSpec = r3.getParams();
    }

    public JCEECPrivateKey(String r2, ECPrivateKeyParameters r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.getD();
        this.ecSpec = null;
    }

    public JCEECPrivateKey(String r3, ECPrivateKeyParameters r4, JCEECPublicKey r5, ECParameterSpec r6) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        ECDomainParameters r7 = r4.getParameters();
        r6 = new ECParameterSpec(EC5Util.convertCurve(r7.getCurve(), r7.getSeed()), EC5Util.convertPoint(r7.getG()), r7.getN(), r7.getH().intValue());
    L5:
        this.ecSpec = r6;
        this.publicKey = getPublicKeyDetails(r5);
    }

    public JCEECPrivateKey(String r3, ECPrivateKeyParameters r4, JCEECPublicKey r5, org.bouncycastle.jce.spec.ECParameterSpec r6) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        ECDomainParameters r7 = r4.getParameters();
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r7.getCurve(), r7.getSeed()), EC5Util.convertPoint(r7.getG()), r7.getN(), r7.getH().intValue());
    L6:
        this.publicKey = getPublicKeyDetails(r5);
        return;
    L5:
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r6.getCurve(), r6.getSeed()), EC5Util.convertPoint(r6.getG()), r6.getN(), r6.getH().intValue());
        goto L6
    }

    public JCEECPrivateKey(String r2, JCEECPrivateKey r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.d;
        this.ecSpec = r3.ecSpec;
        this.withCompression = r3.withCompression;
        this.attrCarrier = r3.attrCarrier;
        this.publicKey = r3.publicKey;
    }

    public JCEECPrivateKey(String r2, org.bouncycastle.jce.spec.ECPrivateKeySpec r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.getD();
        if (r3.getParams() == null) goto L5;
        ECParameterSpec r4 = EC5Util.convertSpec(EC5Util.convertCurve(r3.getParams().getCurve(), r3.getParams().getSeed()), r3.getParams());
    L6:
        this.ecSpec = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public JCEECPrivateKey(ECPrivateKey r3) {
        ECPrivateKey r4 = (ECPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, ECPrivateKey.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r4.getS();
        this.algorithm = r4.getAlgorithm();
        this.ecSpec = r4.getParams();
    }

    JCEECPrivateKey(PrivateKeyInfo r2) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        populateFromPrivKeyInfo(r2);
    }

    private ASN1BitString getPublicKeyDetails(JCEECPublicKey r1) {
        return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(r1.getEncoded())).getPublicKeyData();
    L4:
        return null;
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo r11) {
        X962Parameters r0 = X962Parameters.getInstance(r11.getPrivateKeyAlgorithm().getParameters());
        if (r0.isNamedCurve() == false) goto L8;
        ASN1ObjectIdentifier r1 = ASN1ObjectIdentifier.getInstance(r0.getParameters());
        X9ECParameters r2 = ECUtil.getNamedCurveByOid(r1);
        if (r2 == null) goto L12;
        EllipticCurve r6 = EC5Util.convertCurve(r2.getCurve(), r2.getSeed());
        ECParameterSpec r3 = new ECNamedCurveSpec(ECUtil.getCurveName(r1), r6, EC5Util.convertPoint(r2.getG()), r2.getN(), r2.getH());
    L11:
        this.ecSpec = r3;
    L12:
        ASN1Encodable r12 = r11.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r12, ASN1Integer.class) == false) goto L15;
        this.d = ASN1Integer.getInstance(r12).getValue();
        return;
    L15:
        ECPrivateKeyStructure r4 = new ECPrivateKeyStructure((ASN1Sequence) ZeusTransformUtils.preCheckCast(r12, ASN1Sequence.class, "com.obric.memorydata.plugin"));
        this.d = r4.getKey();
        this.publicKey = r4.getPublicKey();
        return;
    L8:
        if (r0.isImplicitlyCA() == false) goto L10;
        this.ecSpec = null;
        goto L12
    L10:
        X9ECParameters r5 = X9ECParameters.getInstance(r0.getParameters());
        r3 = new ECParameterSpec(EC5Util.convertCurve(r5.getCurve(), r5.getSeed()), EC5Util.convertPoint(r5.getG()), r5.getN(), r5.getH().intValue());
        goto L11
    }

    private void readObject(ObjectInputStream r4) {
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"))));
        this.algorithm = (String) ZeusTransformUtils.preCheckCast(r4.readObject(), String.class, "com.obric.memorydata.plugin");
        this.withCompression = r4.readBoolean();
        PKCS12BagAttributeCarrierImpl r0 = new PKCS12BagAttributeCarrierImpl();
        this.attrCarrier = r0;
        r0.readObject(r4);
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(getEncoded());
        r2.writeObject(this.algorithm);
        r2.writeBoolean(this.withCompression);
        this.attrCarrier.writeObject(r2);
    }

    org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec r0 = this.ecSpec;
        if (r0 == null) goto L7;
        return EC5Util.convertSpec(r0);
    L7:
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, JCEECPrivateKey.class) == true) goto L5;
        return false;
    L5:
        JCEECPrivateKey r5 = (JCEECPrivateKey) ZeusTransformUtils.preCheckCast(r4, JCEECPrivateKey.class, "com.obric.memorydata.plugin");
        if (getD().equals(r5.getD()) == true) goto L8;
        return false;
    L8:
        if (engineGetSpec().equals(r5.engineGetSpec()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r1) {
        return this.attrCarrier.getBagAttribute(r1);
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger getD() {
        return this.d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L8;
        ASN1ObjectIdentifier r0 = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
        if (r0 != null) goto L7;
        r0 = new ASN1ObjectIdentifier(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
    L7:
        X962Parameters r1 = new X962Parameters(r0);
    L13:
        if (this.publicKey == null) goto L15;
        ECPrivateKeyStructure r2 = new ECPrivateKeyStructure(getS(), this.publicKey, r1);
    L24:
    L22:
        return null;
    L17:
        if (this.algorithm.equals("ECGOST3410") == false) goto L19;
        PrivateKeyInfo r7 = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, r1.toASN1Primitive()), r2.toASN1Primitive());     // Catch: IOException -> L22
    L20:
        return r7.getEncoded("DER");
    L19:
        r7 = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, r1.toASN1Primitive()), r2.toASN1Primitive());     // Catch: IOException -> L22
        goto L20
    L15:
        r2 = new ECPrivateKeyStructure(getS(), r1);
        goto L24
    L8:
        ECParameterSpec r3 = this.ecSpec;
        if (r3 != null) goto L11;
        r1 = new X962Parameters(DERNull.INSTANCE);
        goto L13
    L11:
        ECCurve r4 = EC5Util.convertCurve(r3.getCurve());
        r1 = new X962Parameters(new X9ECParameters(r4, new X9ECPoint(EC5Util.convertPoint(r4, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L13
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.ECKey
    public org.bouncycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec r0 = this.ecSpec;
        if (r0 != null) goto L7;
        return null;
    L7:
        return EC5Util.convertSpec(r0);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.d;
    }

    public int hashCode() {
        int r0 = getD().hashCode();
        return engineGetSpec().hashCode() ^ r0;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.attrCarrier.setBagAttribute(r3, r5);
    }

    public void setPointFormat(String r2) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(r2);
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("EC Private Key").append(r1);
        r0.append("             S: ").append(this.d.toString(16)).append(r1);
        return r0.toString();
    }
}
