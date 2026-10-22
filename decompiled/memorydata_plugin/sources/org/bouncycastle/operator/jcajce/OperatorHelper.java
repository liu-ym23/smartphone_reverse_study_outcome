package org.bouncycastle.operator.jcajce;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.operator.DefaultSignatureNameFinder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
class OperatorHelper {
    private static final Map asymmetricWrapperAlgNames = null;
    private static final Map oids = null;
    private static DefaultSignatureNameFinder sigFinder;
    private static final Map symmetricKeyAlgNames = null;
    private static final Map symmetricWrapperAlgNames = null;
    private static final Map symmetricWrapperKeySizes = null;
    private JcaJceHelper helper;

    private static class OpCertificateException extends CertificateException {
        private Throwable cause;

        public OpCertificateException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    static {
        HashMap r0 = new HashMap();
        oids = r0;
        HashMap r1 = new HashMap();
        asymmetricWrapperAlgNames = r1;
        HashMap r2 = new HashMap();
        symmetricWrapperAlgNames = r2;
        HashMap r3 = new HashMap();
        symmetricKeyAlgNames = r3;
        HashMap r4 = new HashMap();
        symmetricWrapperKeySizes = r4;
        sigFinder = new DefaultSignatureNameFinder();
        r0.put(OIWObjectIdentifiers.idSHA1, "SHA1");
        r0.put(NISTObjectIdentifiers.id_sha224, "SHA224");
        r0.put(NISTObjectIdentifiers.id_sha256, "SHA256");
        r0.put(NISTObjectIdentifiers.id_sha384, "SHA384");
        r0.put(NISTObjectIdentifiers.id_sha512, "SHA512");
        r0.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
        r0.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD160");
        r0.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
        r1.put(PKCSObjectIdentifiers.rsaEncryption, "RSA/ECB/PKCS1Padding");
        r1.put(CryptoProObjectIdentifiers.gostR3410_2001, "ECGOST3410");
        r2.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, "DESEDEWrap");
        r2.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap, "RC2Wrap");
        r2.put(NISTObjectIdentifiers.id_aes128_wrap, "AESWrap");
        r2.put(NISTObjectIdentifiers.id_aes192_wrap, "AESWrap");
        r2.put(NISTObjectIdentifiers.id_aes256_wrap, "AESWrap");
        r2.put(NTTObjectIdentifiers.id_camellia128_wrap, "CamelliaWrap");
        r2.put(NTTObjectIdentifiers.id_camellia192_wrap, "CamelliaWrap");
        r2.put(NTTObjectIdentifiers.id_camellia256_wrap, "CamelliaWrap");
        r2.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap, "SEEDWrap");
        r2.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESede");
        r4.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, Integers.valueOf(192));
        r4.put(NISTObjectIdentifiers.id_aes128_wrap, Integers.valueOf(128));
        r4.put(NISTObjectIdentifiers.id_aes192_wrap, Integers.valueOf(192));
        r4.put(NISTObjectIdentifiers.id_aes256_wrap, Integers.valueOf(256));
        r4.put(NTTObjectIdentifiers.id_camellia128_wrap, Integers.valueOf(128));
        r4.put(NTTObjectIdentifiers.id_camellia192_wrap, Integers.valueOf(192));
        r4.put(NTTObjectIdentifiers.id_camellia256_wrap, Integers.valueOf(256));
        r4.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap, Integers.valueOf(128));
        r4.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
        r3.put(NISTObjectIdentifiers.aes, CryptoConst.ALGORITHM_AES);
        r3.put(NISTObjectIdentifiers.id_aes128_CBC, CryptoConst.ALGORITHM_AES);
        r3.put(NISTObjectIdentifiers.id_aes192_CBC, CryptoConst.ALGORITHM_AES);
        r3.put(NISTObjectIdentifiers.id_aes256_CBC, CryptoConst.ALGORITHM_AES);
        r3.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESede");
        r3.put(PKCSObjectIdentifiers.RC2_CBC, "RC2");
    }

    OperatorHelper(JcaJceHelper r3) {
        this.helper = (JcaJceHelper) ZeusTransformUtils.wrapperContextForParams(r3, JcaJceHelper.class, "com.obric.memorydata.plugin");
    }

    AlgorithmParameters createAlgorithmParameters(AlgorithmIdentifier r3) {
        if (r3.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption) == false) goto L17;
        return null;
    L17:
        AlgorithmParameters r2 = this.helper.createAlgorithmParameters(r3.getAlgorithm().getId());     // Catch: NoSuchProviderException -> L11 NoSuchAlgorithmException -> L14
        r2.init(r3.getParameters().toASN1Primitive().getEncoded());     // Catch: IOException -> L8
        return r2;
    L8:
        e = move-exception;
        throw new OperatorCreationException("cannot initialise algorithm parameters: " + e.getMessage(), e);
    L14:
        return null;
    L11:
        e = move-exception;
        throw new OperatorCreationException("cannot create algorithm parameters: " + e.getMessage(), e);
    }

    Cipher createAsymmetricWrapper(ASN1ObjectIdentifier r4, Map r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        String r0 = null;
    L17:
        e = move-exception;
        throw new OperatorCreationException("cannot create cipher: " + e.getMessage(), e);
    L4:
        if (r6.isEmpty() == true) goto L6;
        r0 = (String) ZeusTransformUtils.preCheckCast(r6.get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: GeneralSecurityException -> L17
    L6:
        if (r0 != null) goto L8;
        r0 = (String) ZeusTransformUtils.preCheckCast(asymmetricWrapperAlgNames.get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: GeneralSecurityException -> L17
    L8:
        if (r0 == null) goto L16;
        return this.helper.createCipher(r0);
    L12:
        if (r0.equals("RSA/ECB/PKCS1Padding") == false) goto L16;
        return this.helper.createCipher("RSA/NONE/PKCS1Padding");
    L16:
        return this.helper.createCipher(r4.getId());
    }

    String getKeyAlgorithmName(ASN1ObjectIdentifier r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(symmetricKeyAlgNames.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        return r3.getId();
    }
}
