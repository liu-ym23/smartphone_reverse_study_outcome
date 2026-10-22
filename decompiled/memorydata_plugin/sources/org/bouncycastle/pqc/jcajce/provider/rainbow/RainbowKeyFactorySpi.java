package org.bouncycastle.pqc.jcajce.provider.rainbow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class RainbowKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public RainbowKeyFactorySpi() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r3) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r3, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RainbowPrivateKeySpec.class) == false) goto L7;
        return new BCRainbowPrivateKey((RainbowPrivateKeySpec) ZeusTransformUtils.preCheckCast(r4, RainbowPrivateKeySpec.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r4, PKCS8EncodedKeySpec.class) == false) goto L15;
        return generatePrivate(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(((PKCS8EncodedKeySpec) ZeusTransformUtils.preCheckCast(r4, PKCS8EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded())));
    L11:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L15:
        throw new InvalidKeySpecException("Unsupported key specification: " + r4.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r3) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r3, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RainbowPublicKeySpec.class) == false) goto L7;
        return new BCRainbowPublicKey((RainbowPublicKeySpec) ZeusTransformUtils.preCheckCast(r4, RainbowPublicKeySpec.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r4, X509EncodedKeySpec.class) == false) goto L15;
        return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) ZeusTransformUtils.preCheckCast(r4, X509EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));
    L11:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L15:
        throw new InvalidKeySpecException("Unknown key specification: " + r4 + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key r8, Class r9) {
        Key r7 = (Key) ZeusTransformUtils.wrapperContextForParams(r8, Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, BCRainbowPrivateKey.class) == false) goto L13;
        if (PKCS8EncodedKeySpec.class.isAssignableFrom(r9) == false) goto L9;
        return new PKCS8EncodedKeySpec(r7.getEncoded());
    L9:
        if (RainbowPrivateKeySpec.class.isAssignableFrom(r9) == false) goto L23;
        BCRainbowPrivateKey r10 = (BCRainbowPrivateKey) ZeusTransformUtils.preCheckCast(r7, BCRainbowPrivateKey.class, "com.obric.memorydata.plugin");
        return new RainbowPrivateKeySpec(r10.getInvA1(), r10.getB1(), r10.getInvA2(), r10.getB2(), r10.getVi(), r10.getLayers());
    L23:
        throw new InvalidKeySpecException("Unknown key specification: " + r9 + ".");
    L13:
        if (ZeusTransformUtils.instanceOf(r7, BCRainbowPublicKey.class) == false) goto L25;
        if (X509EncodedKeySpec.class.isAssignableFrom(r9) == false) goto L19;
        return new X509EncodedKeySpec(r7.getEncoded());
    L19:
        if (RainbowPublicKeySpec.class.isAssignableFrom(r9) == false) goto L23;
        BCRainbowPublicKey r11 = (BCRainbowPublicKey) ZeusTransformUtils.preCheckCast(r7, BCRainbowPublicKey.class, "com.obric.memorydata.plugin");
        return new RainbowPublicKeySpec(r11.getDocLength(), r11.getCoeffQuadratic(), r11.getCoeffSingular(), r11.getCoeffScalar());
    L25:
        throw new InvalidKeySpecException("Unsupported key type: " + r7.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key r2) {
        Key r1 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, BCRainbowPrivateKey.class) == false) goto L5;
    L9:
        return r1;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, BCRainbowPublicKey.class) == true) goto L9;
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r8) {
        RainbowPrivateKey r7 = RainbowPrivateKey.getInstance(r8.parsePrivateKey());
        return new BCRainbowPrivateKey(r7.getInvA1(), r7.getB1(), r7.getInvA2(), r7.getB2(), r7.getVi(), r7.getLayers());
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r4) {
        RainbowPublicKey r3 = RainbowPublicKey.getInstance(r4.parsePublicKey());
        return new BCRainbowPublicKey(r3.getDocLength(), r3.getCoeffQuadratic(), r3.getCoeffSingular(), r3.getCoeffScalar());
    }
}
