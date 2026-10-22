package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.agreement.ECVKOAgreement;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private static final X9IntegerConverter converter = null;
    private ECVKOAgreement agreement;
    private String kaAlgorithm;
    private ECDomainParameters parameters;
    private byte[] result;

    static {
        converter = new X9IntegerConverter();
    }

    static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r2) {
        PublicKey r3 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r2, PublicKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BCECPublicKey.class) == false) goto L6;
        return ((BCECGOST3410PublicKey) ZeusTransformUtils.preCheckCast(r3, BCECGOST3410PublicKey.class, "com.obric.memorydata.plugin")).engineGetKeyParameters();
    L6:
        return ECUtil.generatePublicKeyParameter(r3);
    }

    private static String getSimpleName(Class r1) {
        String r2 = r1.getName();
        return r2.substring(r2.lastIndexOf(46) + 1);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public byte[] doCalcSecret() {
        return this.result;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public void doInitFromKey(Key r2, AlgorithmParameterSpec r3, SecureRandom r4) {
        Key r5 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        AlgorithmParameterSpec r6 = (AlgorithmParameterSpec) ZeusTransformUtils.wrapperContextForParams(r3, AlgorithmParameterSpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, PrivateKey.class) == false) goto L17;
        if (r6 != null) goto L6;
    L10:
        ECPrivateKeyParameters r7 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(ECUtil.generatePrivateKeyParameter((PrivateKey) ZeusTransformUtils.preCheckCast(r5, PrivateKey.class, "com.obric.memorydata.plugin")), ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        this.parameters = r7.getParameters();
        if (ZeusTransformUtils.instanceOf(r6, UserKeyingMaterialSpec.class) == false) goto L13;
        byte[] r8 = ((UserKeyingMaterialSpec) ZeusTransformUtils.preCheckCast(r6, UserKeyingMaterialSpec.class, "com.obric.memorydata.plugin")).getUserKeyingMaterial();
    L14:
        this.ukmParameters = r8;
        this.agreement.init(new ParametersWithUKM(r7, this.ukmParameters));
        return;
    L13:
        r8 = null;
        goto L14
    L6:
        if (ZeusTransformUtils.instanceOf(r6, UserKeyingMaterialSpec.class) == true) goto L10;
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    L17:
        throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPrivateKey.class) + " for initialisation");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key r3, boolean r4) {
        Key r5 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        if (this.parameters == null) goto L19;
        if (r4 == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r5, PublicKey.class) == false) goto L15;
        this.result = this.agreement.calculateAgreement(generatePublicKeyParameter((PublicKey) ZeusTransformUtils.preCheckCast(r5, PublicKey.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L11
        return null;
    L11:
        e = move-exception;
        final String r0 = "calculation failed: " + e.getMessage();
        throw new AnonymousClass1(this, r0, e);
    L15:
        throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
    L17:
        throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
    L19:
        throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
    }
}
