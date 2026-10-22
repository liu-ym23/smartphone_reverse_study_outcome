package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
public class BCECGOST3410PrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient BigInteger d;
    private transient ECParameterSpec ecSpec;
    private transient ASN1Encodable gostParams;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCECGOST3410PrivateKey() {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public BCECGOST3410PrivateKey(String r2, ECPrivateKeyParameters r3) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.getD();
        this.ecSpec = null;
    }

    public BCECGOST3410PrivateKey(String r3, ECPrivateKeyParameters r4, BCECGOST3410PublicKey r5, ECParameterSpec r6) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        ECDomainParameters r7 = r4.getParameters();
        r6 = new ECParameterSpec(EC5Util.convertCurve(r7.getCurve(), r7.getSeed()), EC5Util.convertPoint(r7.getG()), r7.getN(), r7.getH().intValue());
    L5:
        this.ecSpec = r6;
        this.gostParams = r5.getGostParams();
        this.publicKey = getPublicKeyDetails(r5);
    }

    public BCECGOST3410PrivateKey(String r3, ECPrivateKeyParameters r4, BCECGOST3410PublicKey r5, org.bouncycastle.jce.spec.ECParameterSpec r6) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        ECDomainParameters r7 = r4.getParameters();
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r7.getCurve(), r7.getSeed()), EC5Util.convertPoint(r7.getG()), r7.getN(), r7.getH().intValue());
    L6:
        this.gostParams = r5.getGostParams();
        this.publicKey = getPublicKeyDetails(r5);
        return;
    L5:
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r6.getCurve(), r6.getSeed()), EC5Util.convertPoint(r6.getG()), r6.getN(), r6.getH().intValue());
        goto L6
    }

    public BCECGOST3410PrivateKey(ECPrivateKey r3) {
        ECPrivateKey r4 = (ECPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, ECPrivateKey.class, "com.obric.memorydata.plugin");
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r4.getS();
        this.algorithm = r4.getAlgorithm();
        this.ecSpec = r4.getParams();
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec r2) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r2.getS();
        this.ecSpec = r2.getParams();
    }

    BCECGOST3410PrivateKey(PrivateKeyInfo r2) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        populateFromPrivKeyInfo(r2);
    }

    public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey r2) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r2.d;
        this.ecSpec = r2.ecSpec;
        this.withCompression = r2.withCompression;
        this.attrCarrier = r2.attrCarrier;
        this.publicKey = r2.publicKey;
        this.gostParams = r2.gostParams;
    }

    public BCECGOST3410PrivateKey(org.bouncycastle.jce.spec.ECPrivateKeySpec r3) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
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

    private void extractBytes(byte[] r5, int r6, BigInteger r7) {
        byte[] r4 = r7.toByteArray();
        int r0 = 0;
        if (r4.length >= 32) goto L5;
        byte[] r8 = new byte[32];
        System.arraycopy(r4, 0, r8, 32 - r4.length, r4.length);
        r4 = r8;
    L5:
        if (r0 == 32) goto L7;
        r5[r6 + r0] = r4[(r4.length - 1) - r0];
        r0 = r0 + 1;
        goto L5
    }

    private ASN1BitString getPublicKeyDetails(BCECGOST3410PublicKey r1) {
        return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(r1.getEncoded())).getPublicKeyData();
    L4:
        return null;
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo r11) {
        ASN1Encodable r0 = r11.getPrivateKeyAlgorithm().getParameters();
        ASN1Primitive r1 = r0.toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r1, ASN1Sequence.class) == true) goto L5;
    L16:
        X962Parameters r2 = X962Parameters.getInstance(r0);
        if (r2.isNamedCurve() == false) goto L24;
        ASN1ObjectIdentifier r3 = ASN1ObjectIdentifier.getInstance(r2.getParameters());
        X9ECParameters r4 = ECUtil.getNamedCurveByOid(r3);
        if (r4 == null) goto L22;
        ECNamedCurveSpec r5 = new ECNamedCurveSpec(ECUtil.getCurveName(r3), EC5Util.convertCurve(r4.getCurve(), r4.getSeed()), EC5Util.convertPoint(r4.getG()), r4.getN(), r4.getH());
    L26:
        this.ecSpec = r5;
    L28:
        ASN1Encodable r12 = r11.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r12, ASN1Integer.class) == false) goto L32;
        BigInteger r13 = ASN1Integer.getInstance(r12).getValue();
    L31:
        this.d = r13;
        return;
    L32:
        org.bouncycastle.asn1.sec.ECPrivateKey r14 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r12);
        this.d = r14.getKey();
        this.publicKey = r14.getPublicKey();
        return;
    L22:
        throw new IllegalStateException();
    L24:
        if (r2.isImplicitlyCA() == false) goto L27;
        r5 = null;
        goto L26
    L27:
        X9ECParameters r6 = X9ECParameters.getInstance(r2.getParameters());
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r6.getCurve(), r6.getSeed()), EC5Util.convertPoint(r6.getG()), r6.getN(), r6.getH().intValue());
        goto L28
    L5:
        if (ASN1Sequence.getInstance(r1).size() != 2) goto L7;
    L8:
        GOST3410PublicKeyAlgParameters r7 = GOST3410PublicKeyAlgParameters.getInstance(r0);
        this.gostParams = r7;
        ECNamedCurveParameterSpec r8 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(r7.getPublicKeyParamSet()));
        EllipticCurve r9 = EC5Util.convertCurve(r8.getCurve(), r8.getSeed());
        this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(r7.getPublicKeyParamSet()), r9, EC5Util.convertPoint(r8.getG()), r8.getN(), r8.getH());
        ASN1Encodable r15 = r11.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r15, ASN1Integer.class) == false) goto L11;
        r13 = ASN1Integer.getInstance(r15).getPositiveValue();
        goto L31
    L11:
        byte[] r16 = ASN1OctetString.getInstance(r15).getOctets();
        byte[] r10 = new byte[r16.length];
        int r17 = 0;
    L13:
        if (r17 == r16.length) goto L15;
        r10[r17] = r16[(r16.length - 1) - r17];
        r17 = r17 + 1;
        goto L13
    L15:
        r13 = new BigInteger(1, r10);
        goto L31
    L7:
        if (ASN1Sequence.getInstance(r1).size() != 3) goto L16;
        goto L8
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"))));
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
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, BCECGOST3410PrivateKey.class) == true) goto L5;
        return false;
    L5:
        BCECGOST3410PrivateKey r5 = (BCECGOST3410PrivateKey) ZeusTransformUtils.preCheckCast(r4, BCECGOST3410PrivateKey.class, "com.obric.memorydata.plugin");
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
        if (this.gostParams == null) goto L9;
        byte[] r0 = new byte[32];
        extractBytes(r0, 0, getS());
        return new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, this.gostParams), new DEROctetString(r0)).getEncoded("DER");
    L7:
        return null;
    L9:
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L14;
        ASN1ObjectIdentifier r1 = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
        if (r1 != null) goto L13;
        r1 = new ASN1ObjectIdentifier(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
    L13:
        X962Parameters r3 = new X962Parameters(r1);
    L18:
        int r2 = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
    L20:
        if (this.publicKey == null) goto L22;
        org.bouncycastle.asn1.sec.ECPrivateKey r4 = new org.bouncycastle.asn1.sec.ECPrivateKey(r2, getS(), this.publicKey, r3);
    L28:
        return new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, r3.toASN1Primitive()), r4.toASN1Primitive()).getEncoded("DER");
    L25:
        return null;
    L22:
        r4 = new org.bouncycastle.asn1.sec.ECPrivateKey(r2, getS(), r3);
        goto L28
    L14:
        ECParameterSpec r5 = this.ecSpec;
        if (r5 != null) goto L17;
        r3 = new X962Parameters(DERNull.INSTANCE);
        r2 = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
        goto L20
    L17:
        ECCurve r6 = EC5Util.convertCurve(r5.getCurve());
        r3 = new X962Parameters(new X9ECParameters(r6, new X9ECPoint(EC5Util.convertPoint(r6, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L18
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
        return ECUtil.privateKeyToString(this.algorithm, this.d, engineGetSpec());
    }
}
