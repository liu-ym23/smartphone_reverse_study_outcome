package org.bouncycastle.jce.provider;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
class X509SignatureUtil {
    private static final ASN1Null derNull = null;

    static {
        derNull = DERNull.INSTANCE;
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier r1) {
        if (PKCSObjectIdentifiers.md5.equals(r1) == false) goto L7;
        return CryptoConst.ALGORITHM_MD5;
    L7:
        if (OIWObjectIdentifiers.idSHA1.equals(r1) == false) goto L11;
        return "SHA1";
    L11:
        if (NISTObjectIdentifiers.id_sha224.equals(r1) == false) goto L15;
        return "SHA224";
    L15:
        if (NISTObjectIdentifiers.id_sha256.equals(r1) == false) goto L19;
        return "SHA256";
    L19:
        if (NISTObjectIdentifiers.id_sha384.equals(r1) == false) goto L23;
        return "SHA384";
    L23:
        if (NISTObjectIdentifiers.id_sha512.equals(r1) == false) goto L27;
        return "SHA512";
    L27:
        if (TeleTrusTObjectIdentifiers.ripemd128.equals(r1) == false) goto L31;
        return "RIPEMD128";
    L31:
        if (TeleTrusTObjectIdentifiers.ripemd160.equals(r1) == false) goto L35;
        return "RIPEMD160";
    L35:
        if (TeleTrusTObjectIdentifiers.ripemd256.equals(r1) == false) goto L39;
        return "RIPEMD256";
    L39:
        if (CryptoProObjectIdentifiers.gostR3411.equals(r1) == false) goto L43;
        return "GOST3411";
    L43:
        return r1.getId();
    }

    static String getSignatureName(AlgorithmIdentifier r3) {
        ASN1Encodable r0 = r3.getParameters();
        if (r0 == null) goto L15;
        if (derNull.equals(r0) == true) goto L15;
        if (r3.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L11;
        return getDigestAlgName(RSASSAPSSparams.getInstance(r0).getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
    L11:
        if (r3.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2) == false) goto L15;
        return getDigestAlgName(ASN1ObjectIdentifier.getInstance(ASN1Sequence.getInstance(r0).getObjectAt(0))) + "withECDSA";
    L15:
        return r3.getAlgorithm().getId();
    }

    static void setSignatureParameters(Signature r2, ASN1Encodable r3) {
        ASN1Encodable r4 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (derNull.equals(r4) == true) goto L23;
        AlgorithmParameters r0 = AlgorithmParameters.getInstance(r2.getAlgorithm(), r2.getProvider());
        r0.init(r4.toASN1Primitive().getEncoded());     // Catch: IOException -> L15
        if (r2.getAlgorithm().endsWith("MGF1") == false) goto L24;
        r2.setParameter(r0.getParameterSpec(PSSParameterSpec.class));     // Catch: GeneralSecurityException -> L12
        return;
    L12:
        e = move-exception;
        throw new SignatureException("Exception extracting parameters: " + e.getMessage());
    L24:
        return;
    L15:
        e = move-exception;
        throw new SignatureException("IOException decoding parameters: " + e.getMessage());
    }
}
