package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r3) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r3, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, PKCS8EncodedKeySpec.class) == false) goto L10;
        return generatePrivate(PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec) ZeusTransformUtils.preCheckCast(r4, PKCS8EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));
    L6:
        e = move-exception;
        throw new InvalidKeySpecException("encoded key spec not recognized: " + e.getMessage());
    L10:
        throw new InvalidKeySpecException("key spec not recognized");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r3) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r3, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, X509EncodedKeySpec.class) == false) goto L10;
        return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) ZeusTransformUtils.preCheckCast(r4, X509EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));
    L6:
        e = move-exception;
        throw new InvalidKeySpecException("encoded key spec not recognized: " + e.getMessage());
    L10:
        throw new InvalidKeySpecException("key spec not recognized");
    }

    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r3, Class r4) {
        Key r2 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        if (r4.isAssignableFrom(PKCS8EncodedKeySpec.class) == false) goto L9;
        if (r2.getFormat().equals("PKCS#8") == false) goto L9;
        return new PKCS8EncodedKeySpec(r2.getEncoded());
    L9:
        if (r4.isAssignableFrom(X509EncodedKeySpec.class) == false) goto L15;
        if (r2.getFormat().equals("X.509") == false) goto L15;
        return new X509EncodedKeySpec(r2.getEncoded());
    L15:
        throw new InvalidKeySpecException("not implemented yet " + r2 + " " + r4);
    }
}
