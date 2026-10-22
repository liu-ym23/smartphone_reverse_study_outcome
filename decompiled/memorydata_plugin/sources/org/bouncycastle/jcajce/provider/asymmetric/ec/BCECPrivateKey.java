package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCECPrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 994553197664784084L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient ProviderConfiguration configuration;
    private transient BigInteger d;
    private transient ECParameterSpec ecSpec;
    private transient byte[] encoding;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCECPrivateKey() {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public BCECPrivateKey(String r3, ECPrivateKeySpec r4, ProviderConfiguration r5) {
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getS();
        this.ecSpec = r4.getParams();
        this.configuration = r6;
    }

    BCECPrivateKey(String r3, PrivateKeyInfo r4, ProviderConfiguration r5) {
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.configuration = r6;
        populateFromPrivKeyInfo(r4);
    }

    public BCECPrivateKey(String r3, ECPrivateKeyParameters r4, BCECPublicKey r5, ECParameterSpec r6, ProviderConfiguration r7) {
        ProviderConfiguration r8 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r7, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        this.configuration = r8;
        if (r6 != null) goto L5;
        ECDomainParameters r9 = r4.getParameters();
        r6 = new ECParameterSpec(EC5Util.convertCurve(r9.getCurve(), r9.getSeed()), EC5Util.convertPoint(r9.getG()), r9.getN(), r9.getH().intValue());
    L5:
        this.ecSpec = r6;
        this.publicKey = getPublicKeyDetails(r5);
    }

    public BCECPrivateKey(String r3, ECPrivateKeyParameters r4, BCECPublicKey r5, org.bouncycastle.jce.spec.ECParameterSpec r6, ProviderConfiguration r7) {
        ProviderConfiguration r8 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r7, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        this.configuration = r8;
        if (r6 != null) goto L5;
        ECDomainParameters r9 = r4.getParameters();
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r9.getCurve(), r9.getSeed()), EC5Util.convertPoint(r9.getG()), r9.getN(), r9.getH().intValue());
    L10:
        this.publicKey = getPublicKeyDetails(r5);     // Catch: Exception -> L8
        return;
    L8:
        this.publicKey = null;
        return;
    L5:
        this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(r6.getCurve(), r6.getSeed()), r6);
        goto L10
    }

    public BCECPrivateKey(String r3, ECPrivateKeyParameters r4, ProviderConfiguration r5) {
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        this.ecSpec = null;
        this.configuration = r6;
    }

    public BCECPrivateKey(String r2, BCECPrivateKey r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.d;
        this.ecSpec = r3.ecSpec;
        this.withCompression = r3.withCompression;
        this.attrCarrier = r3.attrCarrier;
        this.publicKey = r3.publicKey;
        this.configuration = r3.configuration;
    }

    public BCECPrivateKey(String r3, org.bouncycastle.jce.spec.ECPrivateKeySpec r4, ProviderConfiguration r5) {
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r4.getParams() == null) goto L5;
        ECParameterSpec r7 = EC5Util.convertSpec(EC5Util.convertCurve(r4.getParams().getCurve(), r4.getParams().getSeed()), r4.getParams());
    L6:
        this.ecSpec = r7;
        this.configuration = r6;
        return;
    L5:
        r7 = null;
        goto L6
    }

    public BCECPrivateKey(ECPrivateKey r3, ProviderConfiguration r4) {
        ECPrivateKey r5 = (ECPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, ECPrivateKey.class, "com.obric.memorydata.plugin");
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r4, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r5.getS();
        this.algorithm = r5.getAlgorithm();
        this.ecSpec = r5.getParams();
        this.configuration = r6;
    }

    private ASN1BitString getPublicKeyDetails(BCECPublicKey r1) {
        return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(r1.getEncoded())).getPublicKeyData();
    L4:
        return null;
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo r3) {
        X962Parameters r0 = X962Parameters.getInstance(r3.getPrivateKeyAlgorithm().getParameters());
        this.ecSpec = EC5Util.convertToSpec(r0, EC5Util.getCurve(this.configuration, r0));
        ASN1Encodable r4 = r3.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r4, ASN1Integer.class) == false) goto L5;
        this.d = ASN1Integer.getInstance(r4).getValue();
        return;
    L5:
        org.bouncycastle.asn1.sec.ECPrivateKey r5 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r4);
        this.d = r5.getKey();
        this.publicKey = r5.getPublicKey();
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
        this.configuration = BouncyCastleProvider.CONFIGURATION;
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(r4)));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec r0 = this.ecSpec;
        if (r0 == null) goto L7;
        return EC5Util.convertSpec(r0);
    L7:
        return this.configuration.getEcImplicitlyCa();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ECPrivateKey.class) == false) goto L6;
        ECPrivateKey r4 = (ECPrivateKey) ZeusTransformUtils.preCheckCast(r3, ECPrivateKey.class, "com.obric.memorydata.plugin");
        return Arrays.constantTimeAreEqual(getEncoded(), r4.getEncoded());
    L6:
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
        if (this.encoding != null) goto L16;
        X962Parameters r0 = ECUtils.getDomainParametersFromName(this.ecSpec, this.withCompression);
        ECParameterSpec r1 = this.ecSpec;
        if (r1 != null) goto L7;
        int r2 = ECUtil.getOrderBitLength(this.configuration, null, getS());
    L9:
        if (this.publicKey == null) goto L11;
        org.bouncycastle.asn1.sec.ECPrivateKey r3 = new org.bouncycastle.asn1.sec.ECPrivateKey(r2, getS(), this.publicKey, r0);
    L17:
        this.encoding = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, r0), r3).getEncoded("DER");     // Catch: IOException -> L14
    L14:
        return null;
    L11:
        r3 = new org.bouncycastle.asn1.sec.ECPrivateKey(r2, getS(), r0);
        goto L17
    L7:
        r2 = ECUtil.getOrderBitLength(this.configuration, r1.getOrder(), getS());
    L16:
        return Arrays.clone(this.encoding);
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
        return ECUtil.privateKeyToString(CryptoConst.ALGORITHM_EC, this.d, engineGetSpec());
    }
}
