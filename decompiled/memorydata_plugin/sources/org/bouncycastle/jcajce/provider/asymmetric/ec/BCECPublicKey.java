package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class BCECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 2422789860422731812L;
    private String algorithm;
    private transient ProviderConfiguration configuration;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private transient byte[] encoding;
    private transient boolean oldPcSet;
    private boolean withCompression;

    public BCECPublicKey(String r3, ECPublicKeySpec r4, ProviderConfiguration r5) {
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r3;
        this.ecSpec = r4.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, r4.getW()), EC5Util.getDomainParameters(r6, r4.getParams()));
        this.configuration = r6;
    }

    BCECPublicKey(String r3, SubjectPublicKeyInfo r4, ProviderConfiguration r5) {
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r3;
        this.configuration = r6;
        populateFromPubKeyInfo(r4);
    }

    public BCECPublicKey(String r3, ECPublicKeyParameters r4, ECParameterSpec r5, ProviderConfiguration r6) {
        ProviderConfiguration r7 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        ECDomainParameters r0 = r4.getParameters();
        this.algorithm = r3;
        this.ecPublicKey = r4;
        if (r5 != null) goto L5;
        this.ecSpec = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
    L6:
        this.configuration = r7;
        return;
    L5:
        this.ecSpec = r5;
        goto L6
    }

    public BCECPublicKey(String r3, ECPublicKeyParameters r4, ProviderConfiguration r5) {
        ProviderConfiguration r6 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r3;
        this.ecPublicKey = r4;
        this.ecSpec = null;
        this.configuration = r6;
    }

    public BCECPublicKey(String r3, ECPublicKeyParameters r4, org.bouncycastle.jce.spec.ECParameterSpec r5, ProviderConfiguration r6) {
        ProviderConfiguration r7 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        ECDomainParameters r0 = r4.getParameters();
        this.algorithm = r3;
        if (r5 != null) goto L5;
        ECParameterSpec r8 = createSpec(EC5Util.convertCurve(r0.getCurve(), r0.getSeed()), r0);
    L6:
        this.ecSpec = r8;
        this.ecPublicKey = r4;
        this.configuration = r7;
        return;
    L5:
        r8 = EC5Util.convertSpec(EC5Util.convertCurve(r5.getCurve(), r5.getSeed()), r5);
        goto L6
    }

    public BCECPublicKey(String r2, BCECPublicKey r3) {
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r2;
        this.ecPublicKey = r3.ecPublicKey;
        this.ecSpec = r3.ecSpec;
        this.withCompression = r3.withCompression;
        this.configuration = r3.configuration;
    }

    public BCECPublicKey(String r4, org.bouncycastle.jce.spec.ECPublicKeySpec r5, ProviderConfiguration r6) {
        ProviderConfiguration r7 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r4;
        if (r5.getParams() == null) goto L5;
        EllipticCurve r8 = EC5Util.convertCurve(r5.getParams().getCurve(), r5.getParams().getSeed());
        this.ecPublicKey = new ECPublicKeyParameters(r5.getQ(), ECUtil.getDomainParameters(r7, r5.getParams()));
        this.ecSpec = EC5Util.convertSpec(r8, r5.getParams());
    L6:
        this.configuration = r7;
        return;
    L5:
        this.ecPublicKey = new ECPublicKeyParameters(r7.getEcImplicitlyCa().getCurve().createPoint(r5.getQ().getAffineXCoord().toBigInteger(), r5.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(r7, (ECParameterSpec) ZeusTransformUtils.preCheckCast(null, ECParameterSpec.class, "com.obric.memorydata.plugin")));
        this.ecSpec = null;
        goto L6
    }

    public BCECPublicKey(ECPublicKey r4, ProviderConfiguration r5) {
        ECPublicKey r6 = (ECPublicKey) ZeusTransformUtils.wrapperContextForParams(r4, ECPublicKey.class, "com.obric.memorydata.plugin");
        ProviderConfiguration r7 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r5, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        this.algorithm = CryptoConst.ALGORITHM_EC;
        this.algorithm = r6.getAlgorithm();
        this.ecSpec = r6.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(this.ecSpec, r6.getW()), EC5Util.getDomainParameters(r7, r6.getParams()));
        this.configuration = r7;
    }

    private ECParameterSpec createSpec(EllipticCurve r3, ECDomainParameters r4) {
        return new ECParameterSpec(r3, EC5Util.convertPoint(r4.getG()), r4.getN(), r4.getH().intValue());
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r7) {
        X962Parameters r0 = X962Parameters.getInstance(r7.getAlgorithm().getParameters());
        ECCurve r1 = EC5Util.getCurve(this.configuration, r0);
        this.ecSpec = EC5Util.convertToSpec(r0, r1);
        byte[] r8 = r7.getPublicKeyData().getBytes();
        ASN1OctetString r2 = new DEROctetString(r8);
        if (r8[0] == 4) goto L5;
    L16:
        this.ecPublicKey = new ECPublicKeyParameters(new X9ECPoint(r1, r2).getPoint(), ECUtil.getDomainParameters(this.configuration, r0));
        return;
    L5:
        if (r8[1] != (r8.length - 2)) goto L16;
        if (r8[2] == 2) goto L11;
        if (r8[2] != 3) goto L16;
    L11:
        if (new X9IntegerConverter().getByteLength(r1) < (r8.length - 3)) goto L16;
        r2 = (ASN1OctetString) ZeusTransformUtils.preCheckCast(ASN1Primitive.fromByteArray(r8), ASN1OctetString.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L14
    L15:
        throw new IllegalArgumentException("error recovering public key");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
        this.configuration = BouncyCastleProvider.CONFIGURATION;
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(r4)));
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
        return this.configuration.getEcImplicitlyCa();
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, BCECPublicKey.class) == false) goto L11;
        BCECPublicKey r6 = (BCECPublicKey) ZeusTransformUtils.preCheckCast(r5, BCECPublicKey.class, "com.obric.memorydata.plugin");
        if (this.ecPublicKey.getQ().equals(r6.ecPublicKey.getQ()) == true) goto L7;
        return false;
    L7:
        if (engineGetSpec().equals(r6.engineGetSpec()) == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, ECPublicKey.class) == false) goto L14;
        ECPublicKey r7 = (ECPublicKey) ZeusTransformUtils.preCheckCast(r5, ECPublicKey.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(getEncoded(), r7.getEncoded());
    L14:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        boolean r0 = Properties.isOverrideSet("org.bouncycastle.ec.enable_pc");
        if (this.encoding == null) goto L7;
        if (this.oldPcSet != r0) goto L7;
    L14:
        return Arrays.clone(this.encoding);
    L7:
        if (this.withCompression == true) goto L11;
        if (r0 == true) goto L11;
        boolean r1 = false;
    L12:
        this.encoding = KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, ECUtils.getDomainParametersFromName(this.ecSpec, r1)), this.ecPublicKey.getQ().getEncoded(r1));
        this.oldPcSet = r0;
    L11:
        r1 = true;
        goto L12
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
        ECPoint r0 = this.ecPublicKey.getQ();
        if (this.ecSpec == null) goto L5;
        return r0;
    L5:
        return r0.getDetachedPoint();
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
        this.encoding = null;
    }

    public String toString() {
        return ECUtil.publicKeyToString(CryptoConst.ALGORITHM_EC, this.ecPublicKey.getQ(), engineGetSpec());
    }
}
