package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

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
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
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
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCECGOST3410_2012PrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient BigInteger d;
    private transient ECParameterSpec ecSpec;
    private transient GOST3410PublicKeyAlgParameters gostParams;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCECGOST3410_2012PrivateKey() {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public BCECGOST3410_2012PrivateKey(String r2, ECPrivateKeyParameters r3) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.getD();
        this.ecSpec = null;
    }

    public BCECGOST3410_2012PrivateKey(String r3, ECPrivateKeyParameters r4, BCECGOST3410_2012PublicKey r5, ECParameterSpec r6) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters r0 = r4.getParameters();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), EC5Util.convertPoint(r0.getG()), r0.getN(), r0.getH().intValue());
    L6:
        this.gostParams = r5.getGostParams();
        this.publicKey = getPublicKeyDetails(r5);
        return;
    L5:
        this.ecSpec = r6;
        goto L6
    }

    public BCECGOST3410_2012PrivateKey(String r3, ECPrivateKeyParameters r4, BCECGOST3410_2012PublicKey r5, org.bouncycastle.jce.spec.ECParameterSpec r6) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters r0 = r4.getParameters();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        ECParameterSpec r7 = new ECParameterSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), EC5Util.convertPoint(r0.getG()), r0.getN(), r0.getH().intValue());
    L6:
        this.ecSpec = r7;
        this.gostParams = r5.getGostParams();
        this.publicKey = getPublicKeyDetails(r5);
        return;
    L5:
        r7 = new ECParameterSpec(EC5Util.convertCurve(r6.getCurve(), r6.getSeed()), EC5Util.convertPoint(r6.getG()), r6.getN(), r6.getH().intValue());
        goto L6
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKey r3) {
        ECPrivateKey r4 = (ECPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, ECPrivateKey.class, "com.obric.memorydata.plugin");
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r4.getS();
        this.algorithm = r4.getAlgorithm();
        this.ecSpec = r4.getParams();
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKeySpec r2) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r2.getS();
        this.ecSpec = r2.getParams();
    }

    BCECGOST3410_2012PrivateKey(PrivateKeyInfo r2) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        populateFromPrivKeyInfo(r2);
    }

    public BCECGOST3410_2012PrivateKey(BCECGOST3410_2012PrivateKey r2) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r2.d;
        this.ecSpec = r2.ecSpec;
        this.withCompression = r2.withCompression;
        this.attrCarrier = r2.attrCarrier;
        this.publicKey = r2.publicKey;
        this.gostParams = r2.gostParams;
    }

    public BCECGOST3410_2012PrivateKey(org.bouncycastle.jce.spec.ECPrivateKeySpec r3) {
        this.algorithm = "ECGOST3410-2012";
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

    private void extractBytes(byte[] r4, int r5, int r6, BigInteger r7) {
        byte[] r3 = r7.toByteArray();
        int r0 = 0;
        if (r3.length >= r5) goto L5;
        byte[] r8 = new byte[r5];
        System.arraycopy(r3, 0, r8, r5 - r3.length, r3.length);
        r3 = r8;
    L5:
        if (r0 == r5) goto L7;
        r4[r6 + r0] = r3[(r3.length - 1) - r0];
        r0 = r0 + 1;
        goto L5
    }

    private ASN1BitString getPublicKeyDetails(BCECGOST3410_2012PublicKey r1) {
        return SubjectPublicKeyInfo.getInstance(r1.getEncoded()).getPublicKeyData();
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo r11) {
        ASN1Primitive r0 = r11.getPrivateKeyAlgorithm().getParameters().toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r0, ASN1Sequence.class) == true) goto L5;
    L18:
        X962Parameters r1 = X962Parameters.getInstance(r11.getPrivateKeyAlgorithm().getParameters());
        if (r1.isNamedCurve() == false) goto L25;
        ASN1ObjectIdentifier r2 = ASN1ObjectIdentifier.getInstance(r1.getParameters());
        X9ECParameters r3 = ECUtil.getNamedCurveByOid(r2);
        if (r3 != null) goto L23;
        X9ECParameters r4 = ECGOST3410NamedCurves.getByOIDX9(r2);
        EllipticCurve r6 = EC5Util.convertCurve(r4.getCurve(), r4.getSeed());
        ECParameterSpec r5 = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(r2), r6, EC5Util.convertPoint(r4.getG()), r4.getN(), r4.getH());
    L28:
        this.ecSpec = r5;
    L29:
        ASN1Encodable r12 = r11.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r12, ASN1Integer.class) == false) goto L33;
        BigInteger r13 = ASN1Integer.getInstance(r12).getValue();
    L32:
        this.d = r13;
        return;
    L33:
        org.bouncycastle.asn1.sec.ECPrivateKey r14 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r12);
        this.d = r14.getKey();
        this.publicKey = r14.getPublicKey();
        return;
    L23:
        EllipticCurve r7 = EC5Util.convertCurve(r3.getCurve(), r3.getSeed());
        r5 = new ECNamedCurveSpec(ECUtil.getCurveName(r2), r7, EC5Util.convertPoint(r3.getG()), r3.getN(), r3.getH());
        goto L28
    L25:
        if (r1.isImplicitlyCA() == false) goto L27;
        this.ecSpec = null;
        goto L29
    L27:
        X9ECParameters r8 = X9ECParameters.getInstance(r1.getParameters());
        r5 = new ECParameterSpec(EC5Util.convertCurve(r8.getCurve(), r8.getSeed()), EC5Util.convertPoint(r8.getG()), r8.getN(), r8.getH().intValue());
        goto L28
    L5:
        if (ASN1Sequence.getInstance(r0).size() != 2) goto L7;
    L8:
        GOST3410PublicKeyAlgParameters r9 = GOST3410PublicKeyAlgParameters.getInstance(r11.getPrivateKeyAlgorithm().getParameters());
        this.gostParams = r9;
        ECNamedCurveParameterSpec r10 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(r9.getPublicKeyParamSet()));
        EllipticCurve r15 = EC5Util.convertCurve(r10.getCurve(), r10.getSeed());
        this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()), r15, EC5Util.convertPoint(r10.getG()), r10.getN(), r10.getH());
        ASN1OctetString r16 = r11.getPrivateKey();
        if (r16.getOctets().length != 32) goto L11;
    L17:
        r13 = new BigInteger(1, Arrays.reverse(r16.getOctets()));
        goto L32
    L11:
        if (r16.getOctets().length == 64) goto L17;
        ASN1Encodable r17 = r11.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r17, ASN1Integer.class) == false) goto L16;
        r13 = ASN1Integer.getInstance(r17).getPositiveValue();
        goto L32
    L16:
        this.d = new BigInteger(1, Arrays.reverse(ASN1OctetString.getInstance(r17).getOctets()));
        return;
    L7:
        if (ASN1Sequence.getInstance(r0).size() != 3) goto L18;
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
        if (ZeusTransformUtils.instanceOf(r4, BCECGOST3410_2012PrivateKey.class) == true) goto L5;
        return false;
    L5:
        BCECGOST3410_2012PrivateKey r5 = (BCECGOST3410_2012PrivateKey) ZeusTransformUtils.preCheckCast(r4, BCECGOST3410_2012PrivateKey.class, "com.obric.memorydata.plugin");
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
        if (this.d.bitLength() <= 256) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        ASN1ObjectIdentifier r2 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512;
    L9:
        if (r0 == false) goto L11;
        int r1 = 64;
    L13:
        if (this.gostParams == null) goto L19;
        byte[] r3 = new byte[r1];
        extractBytes(r3, r1, 0, getS());
        return new PrivateKeyInfo(new AlgorithmIdentifier(r2, this.gostParams), new DEROctetString(r3)).getEncoded("DER");
    L17:
        return null;
    L19:
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L24;
        ASN1ObjectIdentifier r4 = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
        if (r4 != null) goto L23;
        r4 = new ASN1ObjectIdentifier(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
    L23:
        X962Parameters r5 = new X962Parameters(r4);
    L28:
        int r6 = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
    L30:
        if (this.publicKey == null) goto L32;
        org.bouncycastle.asn1.sec.ECPrivateKey r7 = new org.bouncycastle.asn1.sec.ECPrivateKey(r6, getS(), this.publicKey, r5);
    L36:
        return new PrivateKeyInfo(new AlgorithmIdentifier(r2, r5.toASN1Primitive()), r7.toASN1Primitive()).getEncoded("DER");
    L35:
        return null;
    L32:
        r7 = new org.bouncycastle.asn1.sec.ECPrivateKey(r6, getS(), r5);
        goto L36
    L24:
        ECParameterSpec r8 = this.ecSpec;
        if (r8 != null) goto L27;
        r5 = new X962Parameters(DERNull.INSTANCE);
        r6 = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
        goto L30
    L27:
        ECCurve r9 = EC5Util.convertCurve(r8.getCurve());
        r5 = new X962Parameters(new X9ECParameters(r9, new X9ECPoint(EC5Util.convertPoint(r9, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L28
    L11:
        r1 = 32;
        goto L13
    L8:
        r2 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256;
        goto L9
    L5:
        r0 = false;
        goto L6
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
