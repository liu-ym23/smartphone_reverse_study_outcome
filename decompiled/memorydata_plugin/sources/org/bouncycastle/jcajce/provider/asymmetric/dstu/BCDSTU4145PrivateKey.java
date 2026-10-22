package org.bouncycastle.jcajce.provider.asymmetric.dstu;

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
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.ua.DSTU4145BinaryField;
import org.bouncycastle.asn1.ua.DSTU4145ECBinary;
import org.bouncycastle.asn1.ua.DSTU4145NamedCurves;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.asn1.ua.DSTU4145PointEncoder;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
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
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
public class BCDSTU4145PrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient BigInteger d;
    private transient ECParameterSpec ecSpec;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCDSTU4145PrivateKey() {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public BCDSTU4145PrivateKey(String r2, ECPrivateKeyParameters r3) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = r2;
        this.d = r3.getD();
        this.ecSpec = null;
    }

    public BCDSTU4145PrivateKey(String r3, ECPrivateKeyParameters r4, BCDSTU4145PublicKey r5, ECParameterSpec r6) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters r0 = r4.getParameters();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), EC5Util.convertPoint(r0.getG()), r0.getN(), r0.getH().intValue());
    L6:
        this.publicKey = getPublicKeyDetails(r5);
        return;
    L5:
        this.ecSpec = r6;
        goto L6
    }

    public BCDSTU4145PrivateKey(String r3, ECPrivateKeyParameters r4, BCDSTU4145PublicKey r5, org.bouncycastle.jce.spec.ECParameterSpec r6) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters r0 = r4.getParameters();
        this.algorithm = r3;
        this.d = r4.getD();
        if (r6 != null) goto L5;
        ECParameterSpec r7 = new ECParameterSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), EC5Util.convertPoint(r0.getG()), r0.getN(), r0.getH().intValue());
    L6:
        this.ecSpec = r7;
        this.publicKey = getPublicKeyDetails(r5);
        return;
    L5:
        r7 = new ECParameterSpec(EC5Util.convertCurve(r6.getCurve(), r6.getSeed()), EC5Util.convertPoint(r6.getG()), r6.getN(), r6.getH().intValue());
        goto L6
    }

    public BCDSTU4145PrivateKey(ECPrivateKey r3) {
        ECPrivateKey r4 = (ECPrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, ECPrivateKey.class, "com.obric.memorydata.plugin");
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r4.getS();
        this.algorithm = r4.getAlgorithm();
        this.ecSpec = r4.getParams();
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec r2) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r2.getS();
        this.ecSpec = r2.getParams();
    }

    BCDSTU4145PrivateKey(PrivateKeyInfo r2) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        populateFromPrivKeyInfo(r2);
    }

    public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey r2) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.d = r2.d;
        this.ecSpec = r2.ecSpec;
        this.withCompression = r2.withCompression;
        this.attrCarrier = r2.attrCarrier;
        this.publicKey = r2.publicKey;
    }

    public BCDSTU4145PrivateKey(org.bouncycastle.jce.spec.ECPrivateKeySpec r3) {
        this.algorithm = "DSTU4145";
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

    private ASN1BitString getPublicKeyDetails(BCDSTU4145PublicKey r1) {
        return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(r1.getEncoded())).getPublicKeyData();
    L4:
        return null;
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo r12) {
        X962Parameters r0 = X962Parameters.getInstance(r12.getPrivateKeyAlgorithm().getParameters());
        if (r0.isNamedCurve() == false) goto L9;
        ASN1ObjectIdentifier r1 = ASN1ObjectIdentifier.getInstance(r0.getParameters());
        X9ECParameters r2 = ECUtil.getNamedCurveByOid(r1);
        if (r2 != null) goto L7;
        ECDomainParameters r3 = DSTU4145NamedCurves.getByOID(r1);
        EllipticCurve r6 = EC5Util.convertCurve(r3.getCurve(), r3.getSeed());
        ECParameterSpec r4 = new ECNamedCurveSpec(r1.getId(), r6, EC5Util.convertPoint(r3.getG()), r3.getN(), r3.getH());
    L14:
        this.ecSpec = r4;
    L26:
        ASN1Encodable r13 = r12.parsePrivateKey();
        if (ZeusTransformUtils.instanceOf(r13, ASN1Integer.class) == false) goto L29;
        this.d = ASN1Integer.getInstance(r13).getValue();
        return;
    L29:
        org.bouncycastle.asn1.sec.ECPrivateKey r14 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r13);
        this.d = r14.getKey();
        this.publicKey = r14.getPublicKey();
        return;
    L7:
        EllipticCurve r7 = EC5Util.convertCurve(r2.getCurve(), r2.getSeed());
        r4 = new ECNamedCurveSpec(ECUtil.getCurveName(r1), r7, EC5Util.convertPoint(r2.getG()), r2.getN(), r2.getH());
        goto L14
    L9:
        if (r0.isImplicitlyCA() == false) goto L11;
        this.ecSpec = null;
        goto L26
    L11:
        ASN1Sequence r5 = ASN1Sequence.getInstance(r0.getParameters());
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(0), ASN1Integer.class) == false) goto L15;
        X9ECParameters r8 = X9ECParameters.getInstance(r0.getParameters());
        r4 = new ECParameterSpec(EC5Util.convertCurve(r8.getCurve(), r8.getSeed()), EC5Util.convertPoint(r8.getG()), r8.getN(), r8.getH().intValue());
        goto L14
    L15:
        DSTU4145Params r9 = DSTU4145Params.getInstance(r5);
        if (r9.isNamedCurve() == false) goto L18;
        ASN1ObjectIdentifier r10 = r9.getNamedCurve();
        ECDomainParameters r11 = DSTU4145NamedCurves.getByOID(r10);
        org.bouncycastle.jce.spec.ECParameterSpec r15 = new ECNamedCurveParameterSpec(r10.getId(), r11.getCurve(), r11.getG(), r11.getN(), r11.getH(), r11.getSeed());
    L25:
        this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(r15.getCurve(), r15.getSeed()), EC5Util.convertPoint(r15.getG()), r15.getN(), r15.getH().intValue());
        goto L26
    L18:
        DSTU4145ECBinary r16 = r9.getECBinary();
        byte[] r17 = r16.getB();
        if (r12.getPrivateKeyAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le) == false) goto L21;
        reverseBytes(r17);
    L21:
        DSTU4145BinaryField r18 = r16.getField();
        ECCurve.F2m r19 = new ECCurve.F2m(r18.getM(), r18.getK1(), r18.getK2(), r18.getK3(), r16.getA(), new BigInteger(1, r17));
        byte[] r20 = r16.getG();
        if (r12.getPrivateKeyAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le) == false) goto L24;
        reverseBytes(r20);
    L24:
        r15 = new org.bouncycastle.jce.spec.ECParameterSpec(r19, DSTU4145PointEncoder.decodePoint(r19, r20), r16.getN());
        goto L25
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"))));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void reverseBytes(byte[] r3) {
        int r2 = 0;
    L4:
        if (r2 >= (r3.length / 2)) goto L6;
        byte r0 = r3[r2];
        r3[r2] = r3[(r3.length - 1) - r2];
        r3[(r3.length - 1) - r2] = r0;
        r2 = r2 + 1;
        goto L4
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
        if (ZeusTransformUtils.instanceOf(r4, BCDSTU4145PrivateKey.class) == true) goto L5;
        return false;
    L5:
        BCDSTU4145PrivateKey r5 = (BCDSTU4145PrivateKey) ZeusTransformUtils.preCheckCast(r4, BCDSTU4145PrivateKey.class, "com.obric.memorydata.plugin");
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
        X962Parameters r2 = new X962Parameters(r0);
    L12:
        int r1 = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
    L14:
        if (this.publicKey == null) goto L16;
        org.bouncycastle.asn1.sec.ECPrivateKey r3 = new org.bouncycastle.asn1.sec.ECPrivateKey(r1, getS(), this.publicKey, r2);
    L24:
    L23:
        return null;
    L18:
        if (this.algorithm.equals("DSTU4145") == false) goto L20;
        PrivateKeyInfo r8 = new PrivateKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, r2.toASN1Primitive()), r3.toASN1Primitive());     // Catch: IOException -> L23
    L21:
        return r8.getEncoded("DER");
    L20:
        r8 = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, r2.toASN1Primitive()), r3.toASN1Primitive());     // Catch: IOException -> L23
        goto L21
    L16:
        r3 = new org.bouncycastle.asn1.sec.ECPrivateKey(r1, getS(), r2);
        goto L24
    L8:
        ECParameterSpec r4 = this.ecSpec;
        if (r4 != null) goto L11;
        r2 = new X962Parameters(DERNull.INSTANCE);
        r1 = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
        goto L14
    L11:
        ECCurve r5 = EC5Util.convertCurve(r4.getCurve());
        r2 = new X962Parameters(new X9ECParameters(r5, new X9ECPoint(EC5Util.convertPoint(r5, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L12
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
