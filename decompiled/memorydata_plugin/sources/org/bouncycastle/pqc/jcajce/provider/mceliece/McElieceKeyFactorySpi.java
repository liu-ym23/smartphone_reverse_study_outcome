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
import org.bouncycastle.pqc.asn1.McEliecePrivateKey;
import org.bouncycastle.pqc.asn1.McEliecePublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McEliecePublicKeyParameters;

/* JADX INFO: loaded from: classes7.dex */
public class McElieceKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public McElieceKeyFactorySpi() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r10) {
        KeySpec r9 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r10, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, PKCS8EncodedKeySpec.class) == false) goto L18;
        PrivateKeyInfo r11 = PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(((PKCS8EncodedKeySpec) ZeusTransformUtils.preCheckCast(r9, PKCS8EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));     // Catch: IOException -> L14
        if (PQCObjectIdentifiers.mcEliece.equals(r11.getPrivateKeyAlgorithm().getAlgorithm()) == false) goto L11;
        McEliecePrivateKey r12 = McEliecePrivateKey.getInstance(r11.parsePrivateKey());     // Catch: IOException -> L12
        return new BCMcEliecePrivateKey(new McEliecePrivateKeyParameters(r12.getN(), r12.getK(), r12.getField(), r12.getGoppaPoly(), r12.getP1(), r12.getP2(), r12.getSInv()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");     // Catch: IOException -> L12
    L13:
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
    L14:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e);
    L18:
        throw new InvalidKeySpecException("Unsupported key specification: " + r9.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r4) {
        KeySpec r3 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r4, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, X509EncodedKeySpec.class) == false) goto L19;
        SubjectPublicKeyInfo r5 = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(((X509EncodedKeySpec) ZeusTransformUtils.preCheckCast(r3, X509EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded()));     // Catch: IOException -> L15
    L12:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e.getMessage());
    L7:
        if (PQCObjectIdentifiers.mcEliece.equals(r5.getAlgorithm().getAlgorithm()) == false) goto L11;
        McEliecePublicKey r6 = McEliecePublicKey.getInstance(r5.parsePublicKey());     // Catch: IOException -> L12
        return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(r6.getN(), r6.getT(), r6.getG()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");     // Catch: IOException -> L12
    L15:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L19:
        throw new InvalidKeySpecException("Unsupported key specification: " + r3.getClass() + ".");
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
    public PrivateKey generatePrivate(PrivateKeyInfo r10) {
        McEliecePrivateKey r9 = McEliecePrivateKey.getInstance(r10.parsePrivateKey().toASN1Primitive());
        return new BCMcEliecePrivateKey(new McEliecePrivateKeyParameters(r9.getN(), r9.getK(), r9.getField(), r9.getGoppaPoly(), r9.getP1(), r9.getP2(), r9.getSInv()));
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r4) {
        McEliecePublicKey r3 = McEliecePublicKey.getInstance(r4.parsePublicKey());
        return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(r3.getN(), r3.getT(), r3.getG()));
    }
}
