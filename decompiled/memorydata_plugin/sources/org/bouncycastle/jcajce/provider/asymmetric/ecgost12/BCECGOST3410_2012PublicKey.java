package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECGOST3410Parameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class BCECGOST3410_2012PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private transient GOST3410PublicKeyAlgParameters gostParams;
    private boolean withCompression;

    public BCECGOST3410_2012PublicKey(String r2, ECPublicKeyParameters r3) {
        this.algorithm = "ECGOST3410-2012";
        this.algorithm = r2;
        this.ecPublicKey = r3;
        this.ecSpec = null;
    }

    public BCECGOST3410_2012PublicKey(String r4, ECPublicKeyParameters r5, ECParameterSpec r6) {
        this.algorithm = "ECGOST3410-2012";
        ECDomainParameters r0 = r5.getParameters();
        this.algorithm = r4;
        this.ecPublicKey = r5;
        if (ZeusTransformUtils.instanceOf(r0, ECGOST3410Parameters.class) == false) goto L5;
        ECGOST3410Parameters r7 = (ECGOST3410Parameters) ZeusTransformUtils.preCheckCast(r0, ECGOST3410Parameters.class, "com.obric.memorydata.plugin");
        this.gostParams = new GOST3410PublicKeyAlgParameters(r7.getPublicKeyParamSet(), r7.getDigestParamSet(), r7.getEncryptionParamSet());
    L5:
        if (r6 != null) goto L7;
        this.ecSpec = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
        return;
    L7:
        this.ecSpec = r6;
    }

    public BCECGOST3410_2012PublicKey(String r2, ECPublicKeyParameters r3, org.bouncycastle.jce.spec.ECParameterSpec r4) {
        this.algorithm = "ECGOST3410-2012";
        ECDomainParameters r0 = r3.getParameters();
        this.algorithm = r2;
        this.ecPublicKey = r3;
        if (r4 != null) goto L5;
        ECParameterSpec r5 = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
    L6:
        this.ecSpec = r5;
        return;
    L5:
        r5 = EC5Util.convertSpec(EC5Util.convertCurve(r4.getCurve(), r4.getSeed()), r4);
        goto L6
    }

    public BCECGOST3410_2012PublicKey(ECPublicKey r4) {
        ECPublicKey r5 = (ECPublicKey) ZeusTransformUtils.wrapperContextForParams(r4, ECPublicKey.class, "com.obric.memorydata.plugin");
        this.algorithm = "ECGOST3410-2012";
        this.algorithm = r5.getAlgorithm();
        this.ecSpec = r5.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, r5.getW()), EC5Util.getDomainParameters(null, r5.getParams()));
    }

    public BCECGOST3410_2012PublicKey(ECPublicKeySpec r4) {
        this.algorithm = "ECGOST3410-2012";
        this.ecSpec = r4.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, r4.getW()), EC5Util.getDomainParameters(null, r4.getParams()));
    }

    BCECGOST3410_2012PublicKey(SubjectPublicKeyInfo r2) {
        this.algorithm = "ECGOST3410-2012";
        populateFromPubKeyInfo(r2);
    }

    public BCECGOST3410_2012PublicKey(BCECGOST3410_2012PublicKey r2) {
        this.algorithm = "ECGOST3410-2012";
        this.ecPublicKey = r2.ecPublicKey;
        this.ecSpec = r2.ecSpec;
        this.withCompression = r2.withCompression;
        this.gostParams = r2.gostParams;
    }

    public BCECGOST3410_2012PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec r5, ProviderConfiguration r6) {
        ProviderConfiguration r7 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = "ECGOST3410-2012";
        if (r5.getParams() == null) goto L5;
        EllipticCurve r0 = EC5Util.convertCurve(r5.getParams().getCurve(), r5.getParams().getSeed());
        this.ecPublicKey = new ECPublicKeyParameters(r5.getQ(), ECUtil.getDomainParameters(r7, r5.getParams()));
        this.ecSpec = EC5Util.convertSpec(r0, r5.getParams());
        return;
    L5:
        this.ecPublicKey = new ECPublicKeyParameters(r7.getEcImplicitlyCa().getCurve().createPoint(r5.getQ().getAffineXCoord().toBigInteger(), r5.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(r7, (ECParameterSpec) ZeusTransformUtils.preCheckCast(null, ECParameterSpec.class, "com.obric.memorydata.plugin")));
        this.ecSpec = null;
    }

    private ECParameterSpec createSpec(EllipticCurve r3, ECDomainParameters r4) {
        return new ECParameterSpec(r3, EC5Util.convertPoint(r4.getG()), r4.getN(), r4.getH().intValue());
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

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r11) {
        ASN1ObjectIdentifier r0 = r11.getAlgorithm().getAlgorithm();
        ASN1BitString r1 = r11.getPublicKeyData();
        this.algorithm = "ECGOST3410-2012";
        byte[] r2 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(ASN1Primitive.fromByteArray(r1.getBytes()), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        int r3 = 32;
        if (r0.equals(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512) == false) goto L7;
        r3 = 64;
    L7:
        int r4 = r3 * 2;
        byte[] r5 = new byte[r4 + 1];
        r5[0] = 4;
        int r6 = 1;
    L8:
        if (r6 > r3) goto L10;
        r5[r6] = r2[r3 - r6];
        r5[r6 + r3] = r2[r4 - r6];
        r6 = r6 + 1;
        goto L8
    L10:
        GOST3410PublicKeyAlgParameters r12 = GOST3410PublicKeyAlgParameters.getInstance(r11.getAlgorithm().getParameters());
        this.gostParams = r12;
        ECNamedCurveParameterSpec r13 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(r12.getPublicKeyParamSet()));
        ECCurve r7 = r13.getCurve();
        EllipticCurve r8 = EC5Util.convertCurve(r7, r13.getSeed());
        this.ecPublicKey = new ECPublicKeyParameters(r7.decodePoint(r5), ECUtil.getDomainParameters(null, r13));
        this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()), r8, EC5Util.convertPoint(r13.getG()), r13.getN(), r13.getH());
        return;
    L13:
        throw new IllegalArgumentException("error recovering public key");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"))));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    ECPublicKeyParameters engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec r0 = this.ecSpec;
        if (r0 == null) goto L7;
        return EC5Util.convertSpec(r0);
    L7:
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, BCECGOST3410_2012PublicKey.class) == true) goto L5;
        return false;
    L5:
        BCECGOST3410_2012PublicKey r5 = (BCECGOST3410_2012PublicKey) ZeusTransformUtils.preCheckCast(r4, BCECGOST3410_2012PublicKey.class, "com.obric.memorydata.plugin");
        if (this.ecPublicKey.getQ().equals(r5.ecPublicKey.getQ()) == true) goto L8;
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

    @Override // java.security.Key
    public byte[] getEncoded() {
        BigInteger r0 = this.ecPublicKey.getQ().getAffineXCoord().toBigInteger();
        BigInteger r1 = this.ecPublicKey.getQ().getAffineYCoord().toBigInteger();
        if (r0.bitLength() <= 256) goto L5;
        boolean r2 = true;
    L6:
        GOST3410PublicKeyAlgParameters r4 = getGostParams();
        ASN1Encodable r5 = r4;
        if (r4 == null) goto L9;
    L16:
        int r6 = 64;
        if (r2 == false) goto L19;
        ASN1ObjectIdentifier r7 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512;
        r6 = 128;
        int r3 = 64;
    L20:
        byte[] r8 = new byte[r6];
        int r9 = r6 / 2;
        extractBytes(r8, r9, 0, r0);
        extractBytes(r8, r9, r3, r1);
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(r7, r5), new DEROctetString(r8)));
    L24:
        return null;
    L19:
        r3 = 32;
        r7 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256;
        goto L20
    L9:
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L14;
        ASN1ObjectIdentifier r10 = ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
        if (r2 == false) goto L13;
        ASN1Encodable r11 = r5;
        GOST3410PublicKeyAlgParameters r12 = new GOST3410PublicKeyAlgParameters(r10, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512);
    L15:
        r5 = r11;
        goto L16
    L13:
        r11 = r12;
        r12 = new GOST3410PublicKeyAlgParameters(r10, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256);
        goto L15
    L14:
        ECCurve r13 = EC5Util.convertCurve(this.ecSpec.getCurve());
        r11 = new X962Parameters(new X9ECParameters(r13, new X9ECPoint(EC5Util.convertPoint(r13, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L15
    L5:
        r2 = false;
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public GOST3410PublicKeyAlgParameters getGostParams() {
        if (this.gostParams != null) goto L16;
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L16;
        if (this.ecPublicKey.getQ().getAffineXCoord().toBigInteger().bitLength() <= 256) goto L9;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        GOST3410PublicKeyAlgParameters r1 = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName()), RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512);
    L14:
        this.gostParams = r1;
        goto L16
    L13:
        r1 = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName()), RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256);
        goto L14
    L9:
        r0 = false;
    L16:
        return this.gostParams;
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

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public ECPoint getQ() {
        ECParameterSpec r0 = this.ecSpec;
        ECPoint r1 = this.ecPublicKey.getQ();
        if (r0 == null) goto L5;
        return r1;
    L5:
        return r1.getDetachedPoint();
    }

    @Override // java.security.interfaces.ECPublicKey
    public java.security.spec.ECPoint getW() {
        return EC5Util.convertPoint(this.ecPublicKey.getQ());
    }

    public int hashCode() {
        int r0 = this.ecPublicKey.getQ().hashCode();
        return engineGetSpec().hashCode() ^ r0;
    }

    public void setPointFormat(String r2) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(r2);
    }

    public String toString() {
        return ECUtil.publicKeyToString(this.algorithm, this.ecPublicKey.getQ(), engineGetSpec());
    }
}
