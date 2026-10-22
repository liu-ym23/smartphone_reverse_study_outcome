package org.bouncycastle.jce.provider;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
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
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class JCEECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    private String algorithm;
    private ECParameterSpec ecSpec;
    private GOST3410PublicKeyAlgParameters gostParams;
    private ECPoint q;
    private boolean withCompression;

    public JCEECPublicKey(String r2, ECPublicKeySpec r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r2;
        ECParameterSpec r4 = r3.getParams();
        this.ecSpec = r4;
        this.q = EC5Util.convertPoint(r4, r3.getW());
    }

    public JCEECPublicKey(String r2, ECPublicKeyParameters r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r2;
        this.q = r3.getQ();
        this.ecSpec = null;
    }

    public JCEECPublicKey(String r2, ECPublicKeyParameters r3, ECParameterSpec r4) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        ECDomainParameters r0 = r3.getParameters();
        this.algorithm = r2;
        this.q = r3.getQ();
        if (r4 != null) goto L5;
        this.ecSpec = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
        return;
    L5:
        this.ecSpec = r4;
    }

    public JCEECPublicKey(String r2, ECPublicKeyParameters r3, org.bouncycastle.jce.spec.ECParameterSpec r4) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        ECDomainParameters r0 = r3.getParameters();
        this.algorithm = r2;
        this.q = r3.getQ();
        if (r4 != null) goto L5;
        ECParameterSpec r5 = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
    L6:
        this.ecSpec = r5;
        return;
    L5:
        r5 = EC5Util.convertSpec(EC5Util.convertCurve(r4.getCurve(), r4.getSeed()), r4);
        goto L6
    }

    public JCEECPublicKey(String r2, JCEECPublicKey r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r2;
        this.q = r3.q;
        this.ecSpec = r3.ecSpec;
        this.withCompression = r3.withCompression;
        this.gostParams = r3.gostParams;
    }

    public JCEECPublicKey(String r2, org.bouncycastle.jce.spec.ECPublicKeySpec r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r2;
        this.q = r3.getQ();
        if (r3.getParams() == null) goto L7;
        ECParameterSpec r4 = EC5Util.convertSpec(EC5Util.convertCurve(r3.getParams().getCurve(), r3.getParams().getSeed()), r3.getParams());
    L5:
        this.ecSpec = r4;
        return;
    L7:
        if (this.q.getCurve() != null) goto L9;
        this.q = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve().createPoint(this.q.getAffineXCoord().toBigInteger(), this.q.getAffineYCoord().toBigInteger());
    L9:
        r4 = null;
        goto L5
    }

    public JCEECPublicKey(ECPublicKey r3) {
        ECPublicKey r4 = (ECPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, ECPublicKey.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r4.getAlgorithm();
        ECParameterSpec r0 = r4.getParams();
        this.ecSpec = r0;
        this.q = EC5Util.convertPoint(r0, r4.getW());
    }

    JCEECPublicKey(SubjectPublicKeyInfo r2) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        populateFromPubKeyInfo(r2);
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

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r17) {
        AlgorithmIdentifier r1 = r17.getAlgorithm();
        int r6 = 1;
        if (r1.getAlgorithm().equals(CryptoProObjectIdentifiers.gostR3410_2001) == false) goto L13;
        ASN1BitString r2 = r17.getPublicKeyData();
        this.algorithm = "ECGOST3410";
        byte[] r3 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(ASN1Primitive.fromByteArray(r2.getBytes()), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        byte[] r4 = new byte[65];
        r4[0] = 4;
    L8:
        if (r6 > 32) goto L10;
        r4[r6] = r3[32 - r6];
        r4[r6 + 32] = r3[64 - r6];
        r6 = r6 + 1;
        goto L8
    L10:
        GOST3410PublicKeyAlgParameters r5 = GOST3410PublicKeyAlgParameters.getInstance(r1.getParameters());
        this.gostParams = r5;
        ECNamedCurveParameterSpec r7 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(r5.getPublicKeyParamSet()));
        ECCurve r8 = r7.getCurve();
        EllipticCurve r9 = EC5Util.convertCurve(r8, r7.getSeed());
        this.q = r8.decodePoint(r4);
        this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()), r9, EC5Util.convertPoint(r7.getG()), r7.getN(), r7.getH());
        return;
    L12:
        throw new IllegalArgumentException("error recovering public key");
    L13:
        X962Parameters r10 = X962Parameters.getInstance(r1.getParameters());
        if (r10.isNamedCurve() == false) goto L18;
        ASN1ObjectIdentifier r11 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r10.getParameters(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        X9ECParameters r12 = ECUtil.getNamedCurveByOid(r11);
        ECCurve r13 = r12.getCurve();
        EllipticCurve r14 = EC5Util.convertCurve(r13, r12.getSeed());
        ECParameterSpec r15 = new ECNamedCurveSpec(ECUtil.getCurveName(r11), r14, EC5Util.convertPoint(r12.getG()), r12.getN(), r12.getH());
    L16:
        this.ecSpec = r15;
    L21:
        byte[] r16 = r17.getPublicKeyData().getBytes();
        ASN1OctetString r18 = new DEROctetString(r16);
        if (r16[0] == 4) goto L24;
    L35:
        this.q = new X9ECPoint(r13, r18).getPoint();
        return;
    L24:
        if (r16[1] != (r16.length - 2)) goto L35;
        if (r16[2] == 2) goto L30;
        if (r16[2] != 3) goto L35;
    L30:
        if (new X9IntegerConverter().getByteLength(r13) < (r16.length - 3)) goto L35;
        r18 = (ASN1OctetString) ZeusTransformUtils.preCheckCast(ASN1Primitive.fromByteArray(r16), ASN1OctetString.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L33
    L34:
        throw new IllegalArgumentException("error recovering public key");
    L18:
        if (r10.isImplicitlyCA() == false) goto L20;
        this.ecSpec = null;
        r13 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve();
        goto L21
    L20:
        X9ECParameters r19 = X9ECParameters.getInstance(r10.getParameters());
        r13 = r19.getCurve();
        r15 = new ECParameterSpec(EC5Util.convertCurve(r13, r19.getSeed()), EC5Util.convertPoint(r19.getG()), r19.getN(), r19.getH().intValue());
        goto L16
    }

    private void readObject(ObjectInputStream r4) {
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"))));
        this.algorithm = (String) ZeusTransformUtils.preCheckCast(r4.readObject(), String.class, "com.obric.memorydata.plugin");
        this.withCompression = r4.readBoolean();
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(getEncoded());
        r2.writeObject(this.algorithm);
        r2.writeBoolean(this.withCompression);
    }

    public ECPoint engineGetQ() {
        return this.q;
    }

    org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec r0 = this.ecSpec;
        if (r0 == null) goto L7;
        return EC5Util.convertSpec(r0);
    L7:
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, JCEECPublicKey.class) == true) goto L5;
        return false;
    L5:
        JCEECPublicKey r5 = (JCEECPublicKey) ZeusTransformUtils.preCheckCast(r4, JCEECPublicKey.class, "com.obric.memorydata.plugin");
        if (engineGetQ().equals(r5.engineGetQ()) == true) goto L8;
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
        if (this.algorithm.equals("ECGOST3410") == false) goto L17;
        ASN1Encodable r0 = this.gostParams;
        if (r0 == null) goto L8;
    L11:
        BigInteger r1 = this.q.getAffineXCoord().toBigInteger();
        BigInteger r2 = this.q.getAffineYCoord().toBigInteger();
        byte[] r3 = new byte[64];
        extractBytes(r3, 0, r1);
        extractBytes(r3, 32, r2);
        SubjectPublicKeyInfo r7 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, r0), new DEROctetString(r3));     // Catch: IOException -> L14
    L28:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r7);
    L14:
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L10;
        r0 = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
        goto L11
    L10:
        ECCurve r4 = EC5Util.convertCurve(this.ecSpec.getCurve());
        r0 = new X962Parameters(new X9ECParameters(r4, new X9ECPoint(EC5Util.convertPoint(r4, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L11
    L17:
        if (ZeusTransformUtils.instanceOf(this.ecSpec, ECNamedCurveSpec.class) == false) goto L22;
        ASN1ObjectIdentifier r5 = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
        if (r5 != null) goto L21;
        r5 = new ASN1ObjectIdentifier(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(this.ecSpec, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName());
    L21:
        X962Parameters r6 = new X962Parameters(r5);
    L26:
        r7 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, r6), getQ().getEncoded(this.withCompression));
        goto L28
    L22:
        ECParameterSpec r8 = this.ecSpec;
        if (r8 != null) goto L25;
        r6 = new X962Parameters(DERNull.INSTANCE);
        goto L26
    L25:
        ECCurve r9 = EC5Util.convertCurve(r8.getCurve());
        r6 = new X962Parameters(new X9ECParameters(r9, new X9ECPoint(EC5Util.convertPoint(r9, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        goto L26
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
    public ECPoint getQ() {
        ECParameterSpec r0 = this.ecSpec;
        ECPoint r1 = this.q;
        if (r0 == null) goto L5;
        return r1;
    L5:
        return r1.getDetachedPoint();
    }

    @Override // java.security.interfaces.ECPublicKey
    public java.security.spec.ECPoint getW() {
        return EC5Util.convertPoint(this.q);
    }

    public int hashCode() {
        int r0 = engineGetQ().hashCode();
        return engineGetSpec().hashCode() ^ r0;
    }

    public void setPointFormat(String r2) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(r2);
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("EC Public Key").append(r1);
        r0.append("            X: ").append(this.q.getAffineXCoord().toBigInteger().toString(16)).append(r1);
        r0.append("            Y: ").append(this.q.getAffineYCoord().toBigInteger().toString(16)).append(r1);
        return r0.toString();
    }
}
