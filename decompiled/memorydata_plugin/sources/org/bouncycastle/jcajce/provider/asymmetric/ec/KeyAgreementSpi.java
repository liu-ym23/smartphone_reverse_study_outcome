package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.agreement.ECDHCUnifiedAgreement;
import org.bouncycastle.crypto.agreement.ECMQVBasicAgreement;
import org.bouncycastle.crypto.params.ECDHUPrivateParameters;
import org.bouncycastle.crypto.params.ECDHUPublicParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.DHUParameterSpec;
import org.bouncycastle.jcajce.spec.MQVParameterSpec;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.MQVPrivateKey;
import org.bouncycastle.jce.interfaces.MQVPublicKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private static final X9IntegerConverter converter = null;
    private Object agreement;
    private DHUParameterSpec dheParameters;
    private String kaAlgorithm;
    private MQVParameterSpec mqvParameters;
    private ECDomainParameters parameters;
    private byte[] result;

    static {
        converter = new X9IntegerConverter();
    }

    private static String getSimpleName(Class r1) {
        String r2 = r1.getName();
        return r2.substring(r2.lastIndexOf(46) + 1);
    }

    public byte[] bigIntToBytes(BigInteger r2) {
        X9IntegerConverter r0 = converter;
        return r0.integerToBytes(r2, r0.getByteLength(this.parameters.getCurve()));
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public byte[] doCalcSecret() {
        return Arrays.clone(this.result);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public void doInitFromKey(Key r5, AlgorithmParameterSpec r6, SecureRandom r7) {
        Key r8 = (Key) ZeusTransformUtils.wrapperContextForParams(r5, Key.class, "com.obric.memorydata.plugin");
        AlgorithmParameterSpec r9 = (AlgorithmParameterSpec) ZeusTransformUtils.wrapperContextForParams(r6, AlgorithmParameterSpec.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
    L13:
        byte[] r3 = null;
        ECPublicKeyParameters r4 = null;
        r4 = null;
        ECPublicKeyParameters r10 = null;
        if (ZeusTransformUtils.instanceOf(this.agreement, ECMQVBasicAgreement.class) == false) goto L33;
        this.mqvParameters = null;
        if (ZeusTransformUtils.instanceOf(r8, MQVPrivateKey.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r9, MQVParameterSpec.class) == true) goto L23;
        throw new InvalidAlgorithmParameterException(this.kaAlgorithm + " key agreement requires " + getSimpleName(MQVParameterSpec.class) + " for initialisation");
    L23:
        if (ZeusTransformUtils.instanceOf(r8, MQVPrivateKey.class) == false) goto L27;
        MQVPrivateKey r11 = (MQVPrivateKey) ZeusTransformUtils.preCheckCast(r8, MQVPrivateKey.class, "com.obric.memorydata.plugin");
        ECPrivateKeyParameters r12 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter(r11.getStaticPrivateKey()), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ECPrivateKeyParameters r13 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter(r11.getEphemeralPrivateKey()), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        if (r11.getEphemeralPublicKey() == null) goto L31;
        r4 = (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter(r11.getEphemeralPublicKey()), ECPublicKeyParameters.class, "com.obric.memorydata.plugin");
    L31:
        MQVPrivateParameters r14 = new MQVPrivateParameters(r12, r13, r4);
        this.parameters = r12.getParameters();
        ((ECMQVBasicAgreement) ZeusTransformUtils.preCheckCast(this.agreement, ECMQVBasicAgreement.class, "com.obric.memorydata.plugin")).init(r14);
        return;
    L27:
        MQVParameterSpec r15 = (MQVParameterSpec) ZeusTransformUtils.preCheckCast(r9, MQVParameterSpec.class, "com.obric.memorydata.plugin");
        ECPrivateKeyParameters r16 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter((PrivateKey) ZeusTransformUtils.preCheckCast(r8, PrivateKey.class, "com.obric.memorydata.plugin")), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        r13 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter(r15.getEphemeralPrivateKey()), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        if (r15.getEphemeralPublicKey() == null) goto L30;
        r4 = (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter(r15.getEphemeralPublicKey()), ECPublicKeyParameters.class, "com.obric.memorydata.plugin");
    L30:
        this.mqvParameters = r15;
        this.ukmParameters = r15.getUserKeyingMaterial();
        r12 = r16;
        goto L31
    L33:
        if (ZeusTransformUtils.instanceOf(r9, DHUParameterSpec.class) == false) goto L43;
        if (ZeusTransformUtils.instanceOf(this.agreement, ECDHCUnifiedAgreement.class) == false) goto L41;
        DHUParameterSpec r17 = (DHUParameterSpec) ZeusTransformUtils.preCheckCast(r9, DHUParameterSpec.class, "com.obric.memorydata.plugin");
        ECPrivateKeyParameters r18 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter((PrivateKey) ZeusTransformUtils.preCheckCast(r8, PrivateKey.class, "com.obric.memorydata.plugin")), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ECPrivateKeyParameters r19 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter(r17.getEphemeralPrivateKey()), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        if (r17.getEphemeralPublicKey() == null) goto L39;
        r10 = (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter(r17.getEphemeralPublicKey()), ECPublicKeyParameters.class, "com.obric.memorydata.plugin");
    L39:
        this.dheParameters = r17;
        this.ukmParameters = r17.getUserKeyingMaterial();
        ECDHUPrivateParameters r20 = new ECDHUPrivateParameters(r18, r19, r10);
        this.parameters = r18.getParameters();
        ((ECDHCUnifiedAgreement) ZeusTransformUtils.preCheckCast(this.agreement, ECDHCUnifiedAgreement.class, "com.obric.memorydata.plugin")).init(r20);
        return;
    L41:
        throw new InvalidAlgorithmParameterException(this.kaAlgorithm + " key agreement cannot be used with " + getSimpleName(DHUParameterSpec.class));
    L43:
        if (ZeusTransformUtils.instanceOf(r8, PrivateKey.class) == false) goto L57;
        if (this.kdf == null) goto L47;
    L51:
        ECPrivateKeyParameters r21 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter((PrivateKey) ZeusTransformUtils.preCheckCast(r8, PrivateKey.class, "com.obric.memorydata.plugin")), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        this.parameters = r21.getParameters();
        if (ZeusTransformUtils.instanceOf(r9, UserKeyingMaterialSpec.class) == false) goto L54;
        r3 = ((UserKeyingMaterialSpec) ZeusTransformUtils.preCheckCast(r9, UserKeyingMaterialSpec.class, "com.obric.memorydata.plugin")).getUserKeyingMaterial();
    L54:
        this.ukmParameters = r3;
        ((BasicAgreement) ZeusTransformUtils.preCheckCast(this.agreement, BasicAgreement.class, "com.obric.memorydata.plugin")).init(r21);
        return;
    L47:
        if (ZeusTransformUtils.instanceOf(r9, UserKeyingMaterialSpec.class) == false) goto L51;
        throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
    L57:
        throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPrivateKey.class) + " for initialisation");
    L5:
        if (ZeusTransformUtils.instanceOf(r9, MQVParameterSpec.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r9, UserKeyingMaterialSpec.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r9, DHUParameterSpec.class) == true) goto L13;
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key r3, boolean r4) {
        Key r5 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        if (this.parameters == null) goto L31;
        if (r4 == false) goto L29;
        if (ZeusTransformUtils.instanceOf(this.agreement, ECMQVBasicAgreement.class) == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r5, MQVPublicKey.class) == true) goto L10;
        CipherParameters r0 = new MQVPublicParameters((ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter((PublicKey) ZeusTransformUtils.preCheckCast(r5, PublicKey.class, "com.obric.memorydata.plugin")), ECPublicKeyParameters.class, "com.obric.memorydata.plugin"), (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter(this.mqvParameters.getOtherPartyEphemeralKey()), ECPublicKeyParameters.class, "com.obric.memorydata.plugin"));
    L32:
    L23:
        e = move-exception;
        final String r1 = "calculation failed: " + e.getMessage();
        throw new AnonymousClass1(this, r1, e);
    L18:
        if (ZeusTransformUtils.instanceOf(this.agreement, BasicAgreement.class) == false) goto L20;
        this.result = bigIntToBytes(((BasicAgreement) ZeusTransformUtils.preCheckCast(this.agreement, BasicAgreement.class, "com.obric.memorydata.plugin")).calculateAgreement(r0));     // Catch: Exception -> L23
        return null;
    L20:
        this.result = ((ECDHCUnifiedAgreement) ZeusTransformUtils.preCheckCast(this.agreement, ECDHCUnifiedAgreement.class, "com.obric.memorydata.plugin")).calculateAgreement(r0);     // Catch: Exception -> L23
        return null;
    L10:
        MQVPublicKey r6 = (MQVPublicKey) ZeusTransformUtils.preCheckCast(r5, MQVPublicKey.class, "com.obric.memorydata.plugin");
        r0 = new MQVPublicParameters((ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter(r6.getStaticKey()), ECPublicKeyParameters.class, "com.obric.memorydata.plugin"), (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter(r6.getEphemeralKey()), ECPublicKeyParameters.class, "com.obric.memorydata.plugin"));
        goto L32
    L12:
        if (ZeusTransformUtils.instanceOf(this.agreement, ECDHCUnifiedAgreement.class) == false) goto L15;
        r0 = new ECDHUPublicParameters((ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter((PublicKey) ZeusTransformUtils.preCheckCast(r5, PublicKey.class, "com.obric.memorydata.plugin")), ECPublicKeyParameters.class, "com.obric.memorydata.plugin"), (ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(ECUtils.generatePublicKeyParameter(this.dheParameters.getOtherPartyEphemeralKey()), ECPublicKeyParameters.class, "com.obric.memorydata.plugin"));
        goto L32
    L15:
        if (ZeusTransformUtils.instanceOf(r5, PublicKey.class) == false) goto L27;
        r0 = ECUtils.generatePublicKeyParameter((PublicKey) ZeusTransformUtils.preCheckCast(r5, PublicKey.class, "com.obric.memorydata.plugin"));
        goto L32
    L27:
        throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
    L29:
        throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
    L31:
        throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
    }
}
