package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil;
import org.bouncycastle.crypto.util.OpenSSHPublicKeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r7) {
        KeySpec r8 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r7, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, DSAPrivateKeySpec.class) == false) goto L7;
        return new BCDSAPrivateKey((DSAPrivateKeySpec) ZeusTransformUtils.preCheckCast(r8, DSAPrivateKeySpec.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r8, OpenSSHPrivateKeySpec.class) == false) goto L15;
        AsymmetricKeyParameter r9 = OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(((OpenSSHPrivateKeySpec) ZeusTransformUtils.preCheckCast(r8, OpenSSHPrivateKeySpec.class, "com.obric.memorydata.plugin")).getEncoded());
        if (ZeusTransformUtils.instanceOf(r9, DSAPrivateKeyParameters.class) == false) goto L13;
        return engineGeneratePrivate(new DSAPrivateKeySpec(((DSAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getX(), ((DSAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getParameters().getP(), ((DSAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getParameters().getQ(), ((DSAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getParameters().getG()));
    L13:
        throw new IllegalArgumentException("openssh private key is not dsa privare key");
    L15:
        return super.engineGeneratePrivate(r8);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r7) {
        KeySpec r8 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r7, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, DSAPublicKeySpec.class) == false) goto L10;
        return new BCDSAPublicKey((DSAPublicKeySpec) ZeusTransformUtils.preCheckCast(r8, DSAPublicKeySpec.class, "com.obric.memorydata.plugin"));
    L6:
        e = move-exception;
        final String r1 = "invalid KeySpec: " + e.getMessage();
        throw new AnonymousClass1(this, r1, e);
    L10:
        if (ZeusTransformUtils.instanceOf(r8, OpenSSHPublicKeySpec.class) == false) goto L18;
        AsymmetricKeyParameter r9 = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) ZeusTransformUtils.preCheckCast(r8, OpenSSHPublicKeySpec.class, "com.obric.memorydata.plugin")).getEncoded());
        if (ZeusTransformUtils.instanceOf(r9, DSAPublicKeyParameters.class) == false) goto L16;
        return engineGeneratePublic(new DSAPublicKeySpec(((DSAPublicKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPublicKeyParameters.class, "com.obric.memorydata.plugin")).getY(), ((DSAPublicKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPublicKeyParameters.class, "com.obric.memorydata.plugin")).getParameters().getP(), ((DSAPublicKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPublicKeyParameters.class, "com.obric.memorydata.plugin")).getParameters().getQ(), ((DSAPublicKeyParameters) ZeusTransformUtils.preCheckCast(r9, DSAPublicKeyParameters.class, "com.obric.memorydata.plugin")).getParameters().getG()));
    L16:
        throw new IllegalArgumentException("openssh public key is not dsa public key");
    L18:
        return super.engineGeneratePublic(r8);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r6, Class r7) {
        Key r8 = (Key) ZeusTransformUtils.wrapperContextForParams(r6, Key.class, "com.obric.memorydata.plugin");
        if (r7.isAssignableFrom(DSAPublicKeySpec.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r8, DSAPublicKey.class) == false) goto L9;
        DSAPublicKey r5 = (DSAPublicKey) ZeusTransformUtils.preCheckCast(r8, DSAPublicKey.class, "com.obric.memorydata.plugin");
        return new DSAPublicKeySpec(r5.getY(), r5.getParams().getP(), r5.getParams().getQ(), r5.getParams().getG());
    L9:
        if (r7.isAssignableFrom(DSAPrivateKeySpec.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r8, DSAPrivateKey.class) == false) goto L15;
        DSAPrivateKey r9 = (DSAPrivateKey) ZeusTransformUtils.preCheckCast(r8, DSAPrivateKey.class, "com.obric.memorydata.plugin");
        return new DSAPrivateKeySpec(r9.getX(), r9.getParams().getP(), r9.getParams().getQ(), r9.getParams().getG());
    L15:
        if (r7.isAssignableFrom(OpenSSHPublicKeySpec.class) == false) goto L25;
        if (ZeusTransformUtils.instanceOf(r8, DSAPublicKey.class) == false) goto L25;
        DSAPublicKey r10 = (DSAPublicKey) ZeusTransformUtils.preCheckCast(r8, DSAPublicKey.class, "com.obric.memorydata.plugin");
        return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new DSAPublicKeyParameters(r10.getY(), new DSAParameters(r10.getParams().getP(), r10.getParams().getQ(), r10.getParams().getG()))));
    L21:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L25:
        if (r7.isAssignableFrom(OpenSSHPrivateKeySpec.class) == false) goto L35;
        if (ZeusTransformUtils.instanceOf(r8, DSAPrivateKey.class) == false) goto L35;
        DSAPrivateKey r11 = (DSAPrivateKey) ZeusTransformUtils.preCheckCast(r8, DSAPrivateKey.class, "com.obric.memorydata.plugin");
        return new OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new DSAPrivateKeyParameters(r11.getX(), new DSAParameters(r11.getParams().getP(), r11.getParams().getQ(), r11.getParams().getG()))));
    L31:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L35:
        return super.engineGetKeySpec(r8, r7);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r3) {
        Key r2 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, DSAPublicKey.class) == false) goto L7;
        return new BCDSAPublicKey((DSAPublicKey) ZeusTransformUtils.preCheckCast(r2, DSAPublicKey.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r2, DSAPrivateKey.class) == false) goto L11;
        return new BCDSAPrivateKey((DSAPrivateKey) ZeusTransformUtils.preCheckCast(r2, DSAPrivateKey.class, "com.obric.memorydata.plugin"));
    L11:
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r3) {
        ASN1ObjectIdentifier r2 = r3.getPrivateKeyAlgorithm().getAlgorithm();
        if (DSAUtil.isDsaOid(r2) == false) goto L7;
        return new BCDSAPrivateKey(r3);
    L7:
        throw new IOException("algorithm identifier " + r2 + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r3) {
        ASN1ObjectIdentifier r2 = r3.getAlgorithm().getAlgorithm();
        if (DSAUtil.isDsaOid(r2) == false) goto L7;
        return new BCDSAPublicKey(r3);
    L7:
        throw new IOException("algorithm identifier " + r2 + " in key not recognised");
    }
}
