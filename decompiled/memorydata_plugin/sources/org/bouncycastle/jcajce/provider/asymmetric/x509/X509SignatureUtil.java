package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.util.MessageDigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
class X509SignatureUtil {
    private static final Map<ASN1ObjectIdentifier, String> algNames = null;
    private static final ASN1Null derNull = null;

    static {
        HashMap r0 = new HashMap();
        algNames = r0;
        r0.put(EdECObjectIdentifiers.id_Ed25519, "Ed25519");
        r0.put(EdECObjectIdentifiers.id_Ed448, "Ed448");
        r0.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1withDSA");
        r0.put(X9ObjectIdentifiers.id_dsa_with_sha1, "SHA1withDSA");
        derNull = DERNull.INSTANCE;
    }

    private static String findAlgName(ASN1ObjectIdentifier r4) {
        Provider r0 = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (r0 == null) goto L7;
        String r1 = lookupAlg(r0, r4);
        if (r1 == null) goto L7;
        return r1;
    L7:
        Provider[] r2 = Security.getProviders();
        int r3 = 0;
    L9:
        if (r3 == r2.length) goto L17;
        if (r0 == r2[r3]) goto L15;
        String r5 = lookupAlg(r2[r3], r4);
        if (r5 == null) goto L15;
        return r5;
    L15:
        r3 = r3 + 1;
        goto L9
    L17:
        return r4.getId();
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier r3) {
        String r4 = MessageDigestUtils.getDigestName(r3);
        int r0 = r4.indexOf(45);
        if (r0 > 0) goto L5;
        return r4;
    L5:
        if (r4.startsWith("SHA3") == false) goto L7;
        return r4;
    L7:
        return r4.substring(0, r0) + r4.substring(r0 + 1);
    }

    static String getSignatureName(AlgorithmIdentifier r4) {
        ASN1Encodable r0 = r4.getParameters();
        if (r0 != null) goto L5;
    L14:
        String r1 = (String) ZeusTransformUtils.preCheckCast(algNames.get(r4.getAlgorithm()), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L18;
        return r1;
    L18:
        return findAlgName(r4.getAlgorithm());
    L5:
        if (derNull.equals(r0) == true) goto L14;
        if (r4.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L11;
        return getDigestAlgName(RSASSAPSSparams.getInstance(r0).getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
    L11:
        if (r4.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2) == false) goto L14;
        return getDigestAlgName((ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(ASN1Sequence.getInstance(r0).getObjectAt(0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin")) + "withECDSA";
    }

    static boolean isCompositeAlgorithm(AlgorithmIdentifier r1) {
        return MiscObjectIdentifiers.id_alg_composite.equals(r1.getAlgorithm());
    }

    private static String lookupAlg(Provider r2, ASN1ObjectIdentifier r3) {
        String r0 = r2.getProperty("Alg.Alias.Signature." + r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r4 = r2.getProperty("Alg.Alias.Signature.OID." + r3);
        if (r4 == null) goto L8;
        return r4;
    L8:
        return null;
    }

    static void prettyPrintSignature(byte[] r4, StringBuffer r5, String r6) {
        if (r4.length <= 20) goto L12;
        r5.append("            Signature: ").append(Hex.toHexString(r4, 0, 20)).append(r6);
        int r0 = 20;
    L6:
        if (r0 >= r4.length) goto L17;
        if (r0 >= (r4.length - 20)) goto L10;
        StringBuffer r1 = r5.append("                       ");
        String r3 = Hex.toHexString(r4, r0, 20);
    L11:
        r1.append(r3).append(r6);
        r0 = r0 + 20;
        goto L6
    L10:
        r1 = r5.append("                       ");
        r3 = Hex.toHexString(r4, r0, r4.length - r0);
        goto L11
    L17:
        return;
    L12:
        r5.append("            Signature: ").append(Hex.toHexString(r4)).append(r6);
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
