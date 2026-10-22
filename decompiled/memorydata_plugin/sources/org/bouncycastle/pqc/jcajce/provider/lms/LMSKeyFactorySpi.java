package org.bouncycastle.pqc.jcajce.provider.lms;

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

/* JADX INFO: loaded from: classes7.dex */
public class LMSKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public LMSKeyFactorySpi() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r3) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r3, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, PKCS8EncodedKeySpec.class) == false) goto L11;
        return generatePrivate(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(((PKCS8EncodedKeySpec) ZeusTransformUtils.preCheckCast(r4, PKCS8EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded())));
    L7:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString(), e);
    L11:
        throw new InvalidKeySpecException("unsupported key specification: " + r4.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r3) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r3, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, X509EncodedKeySpec.class) == false) goto L11;
        return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) ZeusTransformUtils.preCheckCast(r4, X509EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));
    L7:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString(), e);
    L11:
        throw new InvalidKeySpecException("unknown key specification: " + r4 + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key r3, Class r4) {
        Key r2 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, BCLMSPrivateKey.class) == false) goto L9;
        if (PKCS8EncodedKeySpec.class.isAssignableFrom(r4) == false) goto L15;
        return new PKCS8EncodedKeySpec(r2.getEncoded());
    L15:
        throw new InvalidKeySpecException("unknown key specification: " + r4 + ".");
    L9:
        if (ZeusTransformUtils.instanceOf(r2, BCLMSPublicKey.class) == false) goto L17;
        if (X509EncodedKeySpec.class.isAssignableFrom(r4) == false) goto L15;
        return new X509EncodedKeySpec(r2.getEncoded());
    L17:
        throw new InvalidKeySpecException("unsupported key type: " + r2.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key r2) {
        Key r1 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, BCLMSPrivateKey.class) == false) goto L5;
    L9:
        return r1;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, BCLMSPublicKey.class) == true) goto L9;
        throw new InvalidKeyException("unsupported key type");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r1) {
        return new BCLMSPrivateKey(r1);
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r1) {
        return new BCLMSPublicKey(r1);
    }
}
