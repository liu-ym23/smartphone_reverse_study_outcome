package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
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
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
public class BCDSTU4145PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient DSTU4145Params dstuParams;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private boolean withCompression;

    public BCDSTU4145PublicKey(String r2, ECPublicKeyParameters r3) {
        this.algorithm = "DSTU4145";
        this.algorithm = r2;
        this.ecPublicKey = r3;
        this.ecSpec = null;
    }

    public BCDSTU4145PublicKey(String r2, ECPublicKeyParameters r3, ECParameterSpec r4) {
        this.algorithm = "DSTU4145";
        ECDomainParameters r0 = r3.getParameters();
        this.algorithm = r2;
        this.ecPublicKey = r3;
        if (r4 != null) goto L5;
        this.ecSpec = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
        return;
    L5:
        this.ecSpec = r4;
    }

    public BCDSTU4145PublicKey(String r2, ECPublicKeyParameters r3, org.bouncycastle.jce.spec.ECParameterSpec r4) {
        this.algorithm = "DSTU4145";
        ECDomainParameters r0 = r3.getParameters();
        this.algorithm = r2;
        if (r4 != null) goto L5;
        ECParameterSpec r5 = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
    L6:
        this.ecSpec = r5;
        this.ecPublicKey = r3;
        return;
    L5:
        r5 = EC5Util.convertSpec(EC5Util.convertCurve(r4.getCurve(), r4.getSeed()), r4);
        goto L6
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec r4) {
        this.algorithm = "DSTU4145";
        this.ecSpec = r4.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, r4.getW()), EC5Util.getDomainParameters(null, this.ecSpec));
    }

    BCDSTU4145PublicKey(SubjectPublicKeyInfo r2) {
        this.algorithm = "DSTU4145";
        populateFromPubKeyInfo(r2);
    }

    public BCDSTU4145PublicKey(BCDSTU4145PublicKey r2) {
        this.algorithm = "DSTU4145";
        this.ecPublicKey = r2.ecPublicKey;
        this.ecSpec = r2.ecSpec;
        this.withCompression = r2.withCompression;
        this.dstuParams = r2.dstuParams;
    }

    public BCDSTU4145PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec r5, ProviderConfiguration r6) {
        ProviderConfiguration r7 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = "DSTU4145";
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

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r14) {
        ASN1BitString r0 = r14.getPublicKeyData();
        this.algorithm = "DSTU4145";
        byte[] r1 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(ASN1Primitive.fromByteArray(r0.getBytes()), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        if (r14.getAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le) == false) goto L7;
        reverseBytes(r1);
    L7:
        ASN1Sequence r2 = ASN1Sequence.getInstance(r14.getAlgorithm().getParameters());
        if (ZeusTransformUtils.instanceOf(r2.getObjectAt(0), ASN1Integer.class) == false) goto L10;
        X9ECParameters r15 = X9ECParameters.getInstance(r2);
        org.bouncycastle.jce.spec.ECParameterSpec r3 = new org.bouncycastle.jce.spec.ECParameterSpec(r15.getCurve(), r15.getG(), r15.getN(), r15.getH(), r15.getSeed());
    L21:
        ECCurve r4 = r3.getCurve();
        EllipticCurve r7 = EC5Util.convertCurve(r4, r3.getSeed());
        if (this.dstuParams == null) goto L27;
        ECPoint r8 = EC5Util.convertPoint(r3.getG());
        if (this.dstuParams.isNamedCurve() == false) goto L26;
        ECParameterSpec r16 = new ECNamedCurveSpec(this.dstuParams.getNamedCurve().getId(), r7, r8, r3.getN(), r3.getH());
    L28:
        this.ecSpec = r16;
        this.ecPublicKey = new ECPublicKeyParameters(DSTU4145PointEncoder.decodePoint(r4, r1), EC5Util.getDomainParameters(null, this.ecSpec));
        return;
    L26:
        r16 = new ECParameterSpec(r7, r8, r3.getN(), r3.getH().intValue());
        goto L28
    L27:
        r16 = EC5Util.convertToSpec(r15);
        goto L28
    L10:
        DSTU4145Params r5 = DSTU4145Params.getInstance(r2);
        this.dstuParams = r5;
        if (r5.isNamedCurve() == false) goto L14;
        ASN1ObjectIdentifier r17 = this.dstuParams.getNamedCurve();
        ECDomainParameters r6 = DSTU4145NamedCurves.getByOID(r17);
        r3 = new ECNamedCurveParameterSpec(r17.getId(), r6.getCurve(), r6.getG(), r6.getN(), r6.getH(), r6.getSeed());
    L13:
        r15 = null;
        goto L21
    L14:
        DSTU4145ECBinary r9 = this.dstuParams.getECBinary();
        byte[] r10 = r9.getB();
        if (r14.getAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le) == false) goto L17;
        reverseBytes(r10);
    L17:
        DSTU4145BinaryField r11 = r9.getField();
        ECCurve.F2m r12 = new ECCurve.F2m(r11.getM(), r11.getK1(), r11.getK2(), r11.getK3(), r9.getA(), new BigInteger(1, r10));
        byte[] r13 = r9.getG();
        if (r14.getAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le) == false) goto L20;
        reverseBytes(r13);
    L20:
        r3 = new org.bouncycastle.jce.spec.ECParameterSpec(r12, DSTU4145PointEncoder.decodePoint(r12, r13), r9.getN());
    L31:
        throw new IllegalArgumentException("error recovering public key");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"))));
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
        if (ZeusTransformUtils.instanceOf(r4, BCDSTU4145PublicKey.class) == true) goto L5;
        return false;
    L5:
        BCDSTU4145PublicKey r5 = (BCDSTU4145PublicKey) ZeusTransformUtils.preCheckCast(r4, BCDSTU4145PublicKey.class, "com.obric.memorydata.plugin");
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
        ASN1Encodable r0 = this.dstuParams;
        if (r0 != null) goto L15;
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L8;
        r0 = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName()));
        goto L15
    L8:
        ECCurve r2 = EC5Util.convertCurve(this.ecSpec.getCurve());
        r0 = new X962Parameters(new X9ECParameters(r2, new X9ECPoint(EC5Util.convertPoint(r2, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
    L15:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, r0), new DEROctetString(DSTU4145PointEncoder.encodePoint(this.ecPublicKey.getQ()))));
    L13:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
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
    public org.bouncycastle.math.ec.ECPoint getQ() {
        org.bouncycastle.math.ec.ECPoint r0 = this.ecPublicKey.getQ();
        if (this.ecSpec == null) goto L5;
        return r0;
    L5:
        return r0.getDetachedPoint();
    }

    public byte[] getSbox() {
        DSTU4145Params r0 = this.dstuParams;
        if (r0 == null) goto L7;
        return r0.getDKE();
    L7:
        return DSTU4145Params.getDefaultDKE();
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
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
