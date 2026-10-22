package com.google.crypto.tink.subtle;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final enum PemKeyType extends Enum<PemKeyType> {
    private static final /* synthetic */ PemKeyType[] $VALUES = null;
    private static final String BEGIN = "-----BEGIN ";
    public static final PemKeyType ECDSA_P256_SHA256 = null;
    public static final PemKeyType ECDSA_P384_SHA384 = null;
    public static final PemKeyType ECDSA_P521_SHA512 = null;
    private static final String END = "-----END ";
    private static final String MARKER = "-----";
    private static final String PRIVATE_KEY = "PRIVATE KEY";
    private static final String PUBLIC_KEY = "PUBLIC KEY";
    public static final PemKeyType RSA_PSS_2048_SHA256 = null;
    public static final PemKeyType RSA_PSS_3072_SHA256 = null;
    public static final PemKeyType RSA_PSS_4096_SHA256 = null;
    public static final PemKeyType RSA_PSS_4096_SHA512 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_2048_SHA256 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_3072_SHA256 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_4096_SHA256 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_4096_SHA512 = null;
    public final String algorithm;
    public final Enums.HashType hash;
    public final int keySizeInBits;
    public final String keyType;

    static {
        PemKeyType r7 = new PemKeyType("RSA_PSS_2048_SHA256", 0, "RSA", "RSASSA-PSS", 2048, Enums.HashType.SHA256);
        RSA_PSS_2048_SHA256 = r7;
        PemKeyType r0 = new PemKeyType("RSA_PSS_3072_SHA256", 1, "RSA", "RSASSA-PSS", 3072, Enums.HashType.SHA256);
        RSA_PSS_3072_SHA256 = r0;
        PemKeyType r1 = new PemKeyType("RSA_PSS_4096_SHA256", 2, "RSA", "RSASSA-PSS", 4096, Enums.HashType.SHA256);
        RSA_PSS_4096_SHA256 = r1;
        PemKeyType r2 = new PemKeyType("RSA_PSS_4096_SHA512", 3, "RSA", "RSASSA-PSS", 4096, Enums.HashType.SHA512);
        RSA_PSS_4096_SHA512 = r2;
        PemKeyType r3 = new PemKeyType("RSA_SIGN_PKCS1_2048_SHA256", 4, "RSA", "RSASSA-PKCS1-v1_5", 2048, Enums.HashType.SHA256);
        RSA_SIGN_PKCS1_2048_SHA256 = r3;
        PemKeyType r4 = new PemKeyType("RSA_SIGN_PKCS1_3072_SHA256", 5, "RSA", "RSASSA-PKCS1-v1_5", 3072, Enums.HashType.SHA256);
        RSA_SIGN_PKCS1_3072_SHA256 = r4;
        PemKeyType r5 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA256", 6, "RSA", "RSASSA-PKCS1-v1_5", 4096, Enums.HashType.SHA256);
        RSA_SIGN_PKCS1_4096_SHA256 = r5;
        PemKeyType r6 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA512", 7, "RSA", "RSASSA-PKCS1-v1_5", 4096, Enums.HashType.SHA512);
        RSA_SIGN_PKCS1_4096_SHA512 = r6;
        PemKeyType r8 = new PemKeyType("ECDSA_P256_SHA256", 8, CryptoConst.ALGORITHM_EC, "ECDSA", 256, Enums.HashType.SHA256);
        ECDSA_P256_SHA256 = r8;
        PemKeyType r16 = new PemKeyType("ECDSA_P384_SHA384", 9, CryptoConst.ALGORITHM_EC, "ECDSA", 384, Enums.HashType.SHA384);
        ECDSA_P384_SHA384 = r16;
        PemKeyType r9 = new PemKeyType("ECDSA_P521_SHA512", 10, CryptoConst.ALGORITHM_EC, "ECDSA", 521, Enums.HashType.SHA512);
        ECDSA_P521_SHA512 = r9;
        $VALUES = new PemKeyType[]{r7, r0, r1, r2, r3, r4, r5, r6, r8, r16, r9};
    }

    private PemKeyType(String r1, int r2, String r3, String r4, int r5, Enums.HashType r6) {
        super(r1, r2);
        this.keyType = r3;
        this.algorithm = r4;
        this.keySizeInBits = r5;
        this.hash = r6;
    }

    private Key getPrivateKey(byte[] r4) {
        return validate(((KeyFactory) ZeusTransformUtils.preCheckCast(b.g.a(this.keyType), KeyFactory.class, "com.obric.memorydata.plugin")).generatePrivate(new PKCS8EncodedKeySpec(r4)));
    }

    private Key getPublicKey(byte[] r4) {
        return validate(((KeyFactory) ZeusTransformUtils.preCheckCast(b.g.a(this.keyType), KeyFactory.class, "com.obric.memorydata.plugin")).generatePublic(new X509EncodedKeySpec(r4)));
    }

    private Key validate(Key r6) {
        Key r7 = (Key) ZeusTransformUtils.wrapperContextForParams(r6, Key.class, "com.obric.memorydata.plugin");
        if (this.keyType.equals("RSA") == false) goto L9;
        int r0 = ((RSAKey) ZeusTransformUtils.preCheckCast(r7, RSAKey.class, "com.obric.memorydata.plugin")).getModulus().bitLength();
        if (r0 != this.keySizeInBits) goto L8;
    L13:
        return r7;
    L8:
        throw new GeneralSecurityException(String.format("invalid RSA key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(r0)}));
    L9:
        ECParameterSpec r1 = ((ECKey) ZeusTransformUtils.preCheckCast(r7, ECKey.class, "com.obric.memorydata.plugin")).getParams();
        if (EllipticCurves.a(r1) == false) goto L17;
        int r2 = EllipticCurves.b(r1.getCurve());
        if (r2 == this.keySizeInBits) goto L13;
        throw new GeneralSecurityException(String.format("invalid EC key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(r2)}));
    L17:
        throw new GeneralSecurityException("unsupport EC spec: " + r1.toString());
    }

    public static PemKeyType valueOf(String r2) {
        return (PemKeyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PemKeyType.class, r2), PemKeyType.class, "com.obric.memorydata.plugin");
    }

    public static PemKeyType[] values() {
        return (PemKeyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PemKeyType[].class, "com.obric.memorydata.plugin");
    }

    public Key readKey(BufferedReader r8) {
    L2:
        String r0 = r8.readLine();
        if (r0 == null) goto L8;
        if (r0.startsWith(BEGIN) == false) goto L2;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        String r1 = r0.trim().substring(11);
        int r3 = r1.indexOf(MARKER);
        if (r3 >= 0) goto L13;
        return null;
    L13:
        String r2 = r1.substring(0, r3);
        String r4 = END + r2 + MARKER;
        StringBuilder r5 = new StringBuilder();
    L14:
        String r6 = r8.readLine();
        if (r6 != null) goto L17;
    L33:
        byte[] r9 = a.a(r5.toString(), 0);     // Catch: Throwable -> L32
        if (r2.contains(PUBLIC_KEY) == false) goto L28;
        return getPublicKey(r9);
    L28:
        if (r2.contains(PRIVATE_KEY) == false) goto L31;
        return getPrivateKey(r9);
    L31:
        return null;
    L17:
        if (r6.indexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR) > 0) goto L14;
        if (r6.contains(r4) == true) goto L33;
        r5.append(r6);
        goto L14
    }
}
