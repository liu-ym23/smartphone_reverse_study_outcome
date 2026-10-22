package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

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
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
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
public class BCECGOST3410PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private transient ASN1Encodable gostParams;
    private boolean withCompression;

    public BCECGOST3410PublicKey(String r2, ECPublicKeyParameters r3) {
        this.algorithm = "ECGOST3410";
        this.algorithm = r2;
        this.ecPublicKey = r3;
        this.ecSpec = null;
    }

    public BCECGOST3410PublicKey(String r6, ECPublicKeyParameters r7, ECParameterSpec r8) {
        this.algorithm = "ECGOST3410";
        ECDomainParameters r0 = r7.getParameters();
        if (ZeusTransformUtils.instanceOf(r0, ECGOST3410Parameters.class) == false) goto L5;
        ECGOST3410Parameters r1 = (ECGOST3410Parameters) ZeusTransformUtils.preCheckCast(r0, ECGOST3410Parameters.class, "com.obric.memorydata.plugin");
        this.gostParams = new GOST3410PublicKeyAlgParameters(r1.getPublicKeyParamSet(), r1.getDigestParamSet(), r1.getEncryptionParamSet());
    L5:
        this.algorithm = r6;
        this.ecPublicKey = r7;
        if (r8 != null) goto L8;
        this.ecSpec = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
        return;
    L8:
        this.ecSpec = r8;
    }

    public BCECGOST3410PublicKey(String r2, ECPublicKeyParameters r3, org.bouncycastle.jce.spec.ECParameterSpec r4) {
        this.algorithm = "ECGOST3410";
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

    public BCECGOST3410PublicKey(ECPublicKey r4) {
        ECPublicKey r5 = (ECPublicKey) ZeusTransformUtils.wrapperContextForParams(r4, ECPublicKey.class, "com.obric.memorydata.plugin");
        this.algorithm = "ECGOST3410";
        this.algorithm = r5.getAlgorithm();
        this.ecSpec = r5.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, r5.getW()), EC5Util.getDomainParameters(null, r5.getParams()));
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec r4) {
        this.algorithm = "ECGOST3410";
        this.ecSpec = r4.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, r4.getW()), EC5Util.getDomainParameters(null, r4.getParams()));
    }

    BCECGOST3410PublicKey(SubjectPublicKeyInfo r2) {
        this.algorithm = "ECGOST3410";
        populateFromPubKeyInfo(r2);
    }

    public BCECGOST3410PublicKey(BCECGOST3410PublicKey r2) {
        this.algorithm = "ECGOST3410";
        this.ecPublicKey = r2.ecPublicKey;
        this.ecSpec = r2.ecSpec;
        this.withCompression = r2.withCompression;
        this.gostParams = r2.gostParams;
    }

    public BCECGOST3410PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec r5, ProviderConfiguration r6) {
        ProviderConfiguration r7 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = "ECGOST3410";
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

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r11) {
        ASN1BitString r0 = r11.getPublicKeyData();
        this.algorithm = "ECGOST3410";
        byte[] r1 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(ASN1Primitive.fromByteArray(r0.getBytes()), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        byte[] r2 = new byte[65];
        r2[0] = 4;
        int r3 = 1;
    L6:
        if (r3 > 32) goto L8;
        r2[r3] = r1[32 - r3];
        r2[r3 + 32] = r1[64 - r3];
        r3 = r3 + 1;
        goto L6
    L8:
        boolean r4 = ZeusTransformUtils.instanceOf(r11.getAlgorithm().getParameters(), ASN1ObjectIdentifier.class);
        ASN1Encodable r12 = r11.getAlgorithm().getParameters();
        if (r4 == false) goto L11;
        ASN1ObjectIdentifier r13 = ASN1ObjectIdentifier.getInstance(r12);
        this.gostParams = r13;
    L12:
        ECNamedCurveParameterSpec r5 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(r13));
        ECCurve r6 = r5.getCurve();
        EllipticCurve r7 = EC5Util.convertCurve(r6, r5.getSeed());
        this.ecPublicKey = new ECPublicKeyParameters(r6.decodePoint(r2), ECUtil.getDomainParameters(null, r5));
        this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(r13), r7, EC5Util.convertPoint(r5.getG()), r5.getN(), r5.getH());
        return;
    L11:
        GOST3410PublicKeyAlgParameters r14 = GOST3410PublicKeyAlgParameters.getInstance(r12);
        this.gostParams = r14;
        r13 = r14.getPublicKeyParamSet();
    L15:
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
        if (ZeusTransformUtils.instanceOf(r4, BCECGOST3410PublicKey.class) == true) goto L5;
        return false;
    L5:
        BCECGOST3410PublicKey r5 = (BCECGOST3410PublicKey) ZeusTransformUtils.preCheckCast(r4, BCECGOST3410PublicKey.class, "com.obric.memorydata.plugin");
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
        ASN1Encodable r0 = getGostParams();
        if (r0 == null) goto L5;
    L8:
        BigInteger r1 = this.ecPublicKey.getQ().getAffineXCoord().toBigInteger();
        BigInteger r2 = this.ecPublicKey.getQ().getAffineYCoord().toBigInteger();
        byte[] r3 = new byte[64];
        extractBytes(r3, 0, r1);
        extractBytes(r3, 32, r2);
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, r0), new DEROctetString(r3)));
    L12:
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L7;
        r0 = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
        goto L8
    L7:
        ECCurve r4 = EC5Util.convertCurve(this.ecSpec.getCurve());
        r0 = new X962Parameters(new X9ECParameters(r4, new X9ECPoint(EC5Util.convertPoint(r4, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L8
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    ASN1Encodable getGostParams() {
        if (this.gostParams != null) goto L8;
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L8;
        this.gostParams = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
    L8:
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
