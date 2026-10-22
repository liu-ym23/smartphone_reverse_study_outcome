package org.bouncycastle.pqc.jcajce.provider.mceliece;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
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
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McElieceCCA2PublicKeyParameters;

/* JADX INFO: loaded from: classes7.dex */
public class McElieceCCA2KeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public McElieceCCA2KeyFactorySpi() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r9) {
        KeySpec r8 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r9, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, PKCS8EncodedKeySpec.class) == false) goto L18;
        PrivateKeyInfo r10 = PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(((PKCS8EncodedKeySpec) ZeusTransformUtils.preCheckCast(r8, PKCS8EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));     // Catch: IOException -> L14
        if (PQCObjectIdentifiers.mcElieceCca2.equals(r10.getPrivateKeyAlgorithm().getAlgorithm()) == false) goto L11;
        McElieceCCA2PrivateKey r11 = McElieceCCA2PrivateKey.getInstance(r10.parsePrivateKey());     // Catch: IOException -> L12
        return new BCMcElieceCCA2PrivateKey(new McElieceCCA2PrivateKeyParameters(r11.getN(), r11.getK(), r11.getField(), r11.getGoppaPoly(), r11.getP(), Utils.getDigest(r11.getDigest()).getAlgorithmName()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");     // Catch: IOException -> L12
    L13:
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
    L14:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e);
    L18:
        throw new InvalidKeySpecException("Unsupported key specification: " + r8.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r5) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r5, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, X509EncodedKeySpec.class) == false) goto L19;
        SubjectPublicKeyInfo r6 = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(((X509EncodedKeySpec) ZeusTransformUtils.preCheckCast(r4, X509EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));     // Catch: IOException -> L15
    L12:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e.getMessage());
    L7:
        if (PQCObjectIdentifiers.mcElieceCca2.equals(r6.getAlgorithm().getAlgorithm()) == false) goto L11;
        McElieceCCA2PublicKey r7 = McElieceCCA2PublicKey.getInstance(r6.parsePublicKey());     // Catch: IOException -> L12
        return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(r7.getN(), r7.getT(), r7.getG(), Utils.getDigest(r7.getDigest()).getAlgorithmName()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");     // Catch: IOException -> L12
    L15:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L19:
        throw new InvalidKeySpecException("Unsupported key specification: " + r4.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r1, Class r2) {
        Key r0 = (Key) ZeusTransformUtils.wrapperContextForParams(r1, Key.class, "com.obric.memorydata.plugin");
        return null;
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r2) {
        Key r1 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        return null;
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r9) {
        McElieceCCA2PrivateKey r8 = McElieceCCA2PrivateKey.getInstance(r9.parsePrivateKey().toASN1Primitive());
        return new BCMcElieceCCA2PrivateKey(new McElieceCCA2PrivateKeyParameters(r8.getN(), r8.getK(), r8.getField(), r8.getGoppaPoly(), r8.getP(), null));
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r5) {
        McElieceCCA2PublicKey r4 = McElieceCCA2PublicKey.getInstance(r5.parsePublicKey());
        return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(r4.getN(), r4.getT(), r4.getG(), Utils.getDigest(r4.getDigest()).getAlgorithmName()));
    }
}
