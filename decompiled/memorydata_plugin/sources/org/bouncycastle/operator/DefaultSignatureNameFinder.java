package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bsi.BSIObjectIdentifiers;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultSignatureNameFinder {
    private static final Map digests = null;
    private static final Map oids = null;

    static {
        HashMap r0 = new HashMap();
        oids = r0;
        HashMap r1 = new HashMap();
        digests = r1;
        r0.put(PKCSObjectIdentifiers.id_RSASSA_PSS, "RSASSA-PSS");
        r0.put(EdECObjectIdentifiers.id_Ed25519, "ED25519");
        r0.put(EdECObjectIdentifiers.id_Ed448, "ED448");
        r0.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        r0.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        r0.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        r0.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        r0.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        r0.put(CMSObjectIdentifiers.id_RSASSA_PSS_SHAKE128, "SHAKE128WITHRSAPSS");
        r0.put(CMSObjectIdentifiers.id_RSASSA_PSS_SHAKE256, "SHAKE256WITHRSAPSS");
        r0.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
        r0.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
        r0.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411-2012-256WITHECGOST3410-2012-256");
        r0.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411-2012-512WITHECGOST3410-2012-512");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA1, "SHA1WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA224, "SHA224WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA256, "SHA256WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA384, "SHA384WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA512, "SHA512WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA3_224, "SHA3-224WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA3_256, "SHA3-256WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA3_384, "SHA3-384WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_SHA3_512, "SHA3-512WITHPLAIN-ECDSA");
        r0.put(BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, "RIPEMD160WITHPLAIN-ECDSA");
        r0.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1WITHCVC-ECDSA");
        r0.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224WITHCVC-ECDSA");
        r0.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256WITHCVC-ECDSA");
        r0.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384WITHCVC-ECDSA");
        r0.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512WITHCVC-ECDSA");
        r0.put(IsaraObjectIdentifiers.id_alg_xmss, "XMSS");
        r0.put(IsaraObjectIdentifiers.id_alg_xmssmt, "XMSSMT");
        r0.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128, "RIPEMD128WITHRSA");
        r0.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160, "RIPEMD160WITHRSA");
        r0.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256, "RIPEMD256WITHRSA");
        r0.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        r0.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        r0.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        r0.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        r0.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        r0.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        r0.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        r0.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        r0.put(CMSObjectIdentifiers.id_ecdsa_with_shake128, "SHAKE128WITHECDSA");
        r0.put(CMSObjectIdentifiers.id_ecdsa_with_shake256, "SHAKE256WITHECDSA");
        r0.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        r0.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        r0.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        r0.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
        r1.put(OIWObjectIdentifiers.idSHA1, "SHA1");
        r1.put(NISTObjectIdentifiers.id_sha224, "SHA224");
        r1.put(NISTObjectIdentifiers.id_sha256, "SHA256");
        r1.put(NISTObjectIdentifiers.id_sha384, "SHA384");
        r1.put(NISTObjectIdentifiers.id_sha512, "SHA512");
        r1.put(NISTObjectIdentifiers.id_sha3_224, "SHA3-224");
        r1.put(NISTObjectIdentifiers.id_sha3_256, "SHA3-256");
        r1.put(NISTObjectIdentifiers.id_sha3_384, "SHA3-384");
        r1.put(NISTObjectIdentifiers.id_sha3_512, "SHA3-512");
        r1.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
        r1.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD160");
        r1.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
    }

    public DefaultSignatureNameFinder() {
    }
}
