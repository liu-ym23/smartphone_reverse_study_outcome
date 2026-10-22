package org.bouncycastle.pqc.crypto.util;

import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.bike.BIKEParameters;
import org.bouncycastle.pqc.crypto.cmce.CMCEParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoParameters;
import org.bouncycastle.pqc.crypto.hqc.HQCParameters;
import org.bouncycastle.pqc.crypto.ntru.NTRUParameters;
import org.bouncycastle.pqc.crypto.ntruprime.NTRULPRimeParameters;
import org.bouncycastle.pqc.crypto.ntruprime.SNTRUPrimeParameters;
import org.bouncycastle.pqc.crypto.picnic.PicnicParameters;
import org.bouncycastle.pqc.crypto.saber.SABERParameters;
import org.bouncycastle.pqc.crypto.sike.SIKEParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    static final AlgorithmIdentifier AlgID_qTESLA_p_I = null;
    static final AlgorithmIdentifier AlgID_qTESLA_p_III = null;
    static final AlgorithmIdentifier SPHINCS_SHA3_256 = null;
    static final AlgorithmIdentifier SPHINCS_SHA512_256 = null;
    static final AlgorithmIdentifier XMSS_SHA256 = null;
    static final AlgorithmIdentifier XMSS_SHA512 = null;
    static final AlgorithmIdentifier XMSS_SHAKE128 = null;
    static final AlgorithmIdentifier XMSS_SHAKE256 = null;
    static final Map bikeOids = null;
    static final Map bikeParams = null;
    static final Map categories = null;
    static final Map dilithiumOids = null;
    static final Map dilithiumParams = null;
    static final Map falconOids = null;
    static final Map falconParams = null;
    static final Map frodoOids = null;
    static final Map frodoParams = null;
    static final Map hqcOids = null;
    static final Map hqcParams = null;
    static final Map kyberOids = null;
    static final Map kyberParams = null;
    static final Map mcElieceOids = null;
    static final Map mcElieceParams = null;
    static final Map ntruOids = null;
    static final Map ntruParams = null;
    static final Map ntruprimeOids = null;
    static final Map ntruprimeParams = null;
    static final Map picnicOids = null;
    static final Map picnicParams = null;
    static final Map saberOids = null;
    static final Map saberParams = null;
    static final Map sikeOids = null;
    static final Map sikeParams = null;
    static final Map sntruprimeOids = null;
    static final Map sntruprimeParams = null;
    static final Map sphincsPlusOids = null;
    static final Map sphincsPlusParams = null;

    static {
        AlgID_qTESLA_p_I = new AlgorithmIdentifier(PQCObjectIdentifiers.qTESLA_p_I);
        AlgID_qTESLA_p_III = new AlgorithmIdentifier(PQCObjectIdentifiers.qTESLA_p_III);
        SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
        SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
        XMSS_SHA256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        XMSS_SHA512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
        XMSS_SHAKE128 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
        XMSS_SHAKE256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
        HashMap r0 = new HashMap();
        categories = r0;
        HashMap r1 = new HashMap();
        picnicOids = r1;
        HashMap r2 = new HashMap();
        picnicParams = r2;
        HashMap r3 = new HashMap();
        frodoOids = r3;
        HashMap r4 = new HashMap();
        frodoParams = r4;
        HashMap r5 = new HashMap();
        saberOids = r5;
        HashMap r6 = new HashMap();
        saberParams = r6;
        HashMap r7 = new HashMap();
        mcElieceOids = r7;
        HashMap r8 = new HashMap();
        mcElieceParams = r8;
        sphincsPlusOids = new HashMap();
        sphincsPlusParams = new HashMap();
        HashMap r9 = new HashMap();
        sikeOids = r9;
        HashMap r10 = new HashMap();
        sikeParams = r10;
        HashMap r11 = new HashMap();
        ntruOids = r11;
        HashMap r12 = new HashMap();
        ntruParams = r12;
        HashMap r13 = new HashMap();
        falconOids = r13;
        HashMap r14 = new HashMap();
        falconParams = r14;
        HashMap r15 = new HashMap();
        kyberOids = r15;
        HashMap r16 = new HashMap();
        kyberParams = r16;
        HashMap r17 = new HashMap();
        ntruprimeOids = r17;
        HashMap r18 = new HashMap();
        ntruprimeParams = r18;
        HashMap r19 = new HashMap();
        sntruprimeOids = r19;
        HashMap r110 = new HashMap();
        sntruprimeParams = r110;
        HashMap r111 = new HashMap();
        dilithiumOids = r111;
        HashMap r112 = new HashMap();
        dilithiumParams = r112;
        HashMap r113 = new HashMap();
        bikeOids = r113;
        HashMap r114 = new HashMap();
        bikeParams = r114;
        HashMap r115 = new HashMap();
        hqcOids = r115;
        HashMap r116 = new HashMap();
        hqcParams = r116;
        r0.put(PQCObjectIdentifiers.qTESLA_p_I, Integers.valueOf(5));
        r0.put(PQCObjectIdentifiers.qTESLA_p_III, Integers.valueOf(6));
        r7.put(CMCEParameters.mceliece348864r3, BCObjectIdentifiers.mceliece348864_r3);
        r7.put(CMCEParameters.mceliece348864fr3, BCObjectIdentifiers.mceliece348864f_r3);
        r7.put(CMCEParameters.mceliece460896r3, BCObjectIdentifiers.mceliece460896_r3);
        r7.put(CMCEParameters.mceliece460896fr3, BCObjectIdentifiers.mceliece460896f_r3);
        r7.put(CMCEParameters.mceliece6688128r3, BCObjectIdentifiers.mceliece6688128_r3);
        r7.put(CMCEParameters.mceliece6688128fr3, BCObjectIdentifiers.mceliece6688128f_r3);
        r7.put(CMCEParameters.mceliece6960119r3, BCObjectIdentifiers.mceliece6960119_r3);
        r7.put(CMCEParameters.mceliece6960119fr3, BCObjectIdentifiers.mceliece6960119f_r3);
        r7.put(CMCEParameters.mceliece8192128r3, BCObjectIdentifiers.mceliece8192128_r3);
        r7.put(CMCEParameters.mceliece8192128fr3, BCObjectIdentifiers.mceliece8192128f_r3);
        r8.put(BCObjectIdentifiers.mceliece348864_r3, CMCEParameters.mceliece348864r3);
        r8.put(BCObjectIdentifiers.mceliece348864f_r3, CMCEParameters.mceliece348864fr3);
        r8.put(BCObjectIdentifiers.mceliece460896_r3, CMCEParameters.mceliece460896r3);
        r8.put(BCObjectIdentifiers.mceliece460896f_r3, CMCEParameters.mceliece460896fr3);
        r8.put(BCObjectIdentifiers.mceliece6688128_r3, CMCEParameters.mceliece6688128r3);
        r8.put(BCObjectIdentifiers.mceliece6688128f_r3, CMCEParameters.mceliece6688128fr3);
        r8.put(BCObjectIdentifiers.mceliece6960119_r3, CMCEParameters.mceliece6960119r3);
        r8.put(BCObjectIdentifiers.mceliece6960119f_r3, CMCEParameters.mceliece6960119fr3);
        r8.put(BCObjectIdentifiers.mceliece8192128_r3, CMCEParameters.mceliece8192128r3);
        r8.put(BCObjectIdentifiers.mceliece8192128f_r3, CMCEParameters.mceliece8192128fr3);
        r3.put(FrodoParameters.frodokem640aes, BCObjectIdentifiers.frodokem640aes);
        r3.put(FrodoParameters.frodokem640shake, BCObjectIdentifiers.frodokem640shake);
        r3.put(FrodoParameters.frodokem976aes, BCObjectIdentifiers.frodokem976aes);
        r3.put(FrodoParameters.frodokem976shake, BCObjectIdentifiers.frodokem976shake);
        r3.put(FrodoParameters.frodokem1344aes, BCObjectIdentifiers.frodokem1344aes);
        r3.put(FrodoParameters.frodokem1344shake, BCObjectIdentifiers.frodokem1344shake);
        r4.put(BCObjectIdentifiers.frodokem640aes, FrodoParameters.frodokem640aes);
        r4.put(BCObjectIdentifiers.frodokem640shake, FrodoParameters.frodokem640shake);
        r4.put(BCObjectIdentifiers.frodokem976aes, FrodoParameters.frodokem976aes);
        r4.put(BCObjectIdentifiers.frodokem976shake, FrodoParameters.frodokem976shake);
        r4.put(BCObjectIdentifiers.frodokem1344aes, FrodoParameters.frodokem1344aes);
        r4.put(BCObjectIdentifiers.frodokem1344shake, FrodoParameters.frodokem1344shake);
        r5.put(SABERParameters.lightsaberkem128r3, BCObjectIdentifiers.lightsaberkem128r3);
        r5.put(SABERParameters.saberkem128r3, BCObjectIdentifiers.saberkem128r3);
        r5.put(SABERParameters.firesaberkem128r3, BCObjectIdentifiers.firesaberkem128r3);
        r5.put(SABERParameters.lightsaberkem192r3, BCObjectIdentifiers.lightsaberkem192r3);
        r5.put(SABERParameters.saberkem192r3, BCObjectIdentifiers.saberkem192r3);
        r5.put(SABERParameters.firesaberkem192r3, BCObjectIdentifiers.firesaberkem192r3);
        r5.put(SABERParameters.lightsaberkem256r3, BCObjectIdentifiers.lightsaberkem256r3);
        r5.put(SABERParameters.saberkem256r3, BCObjectIdentifiers.saberkem256r3);
        r5.put(SABERParameters.firesaberkem256r3, BCObjectIdentifiers.firesaberkem256r3);
        r6.put(BCObjectIdentifiers.lightsaberkem128r3, SABERParameters.lightsaberkem128r3);
        r6.put(BCObjectIdentifiers.saberkem128r3, SABERParameters.saberkem128r3);
        r6.put(BCObjectIdentifiers.firesaberkem128r3, SABERParameters.firesaberkem128r3);
        r6.put(BCObjectIdentifiers.lightsaberkem192r3, SABERParameters.lightsaberkem192r3);
        r6.put(BCObjectIdentifiers.saberkem192r3, SABERParameters.saberkem192r3);
        r6.put(BCObjectIdentifiers.firesaberkem192r3, SABERParameters.firesaberkem192r3);
        r6.put(BCObjectIdentifiers.lightsaberkem256r3, SABERParameters.lightsaberkem256r3);
        r6.put(BCObjectIdentifiers.saberkem256r3, SABERParameters.saberkem256r3);
        r6.put(BCObjectIdentifiers.firesaberkem256r3, SABERParameters.firesaberkem256r3);
        r1.put(PicnicParameters.picnicl1fs, BCObjectIdentifiers.picnicl1fs);
        r1.put(PicnicParameters.picnicl1ur, BCObjectIdentifiers.picnicl1ur);
        r1.put(PicnicParameters.picnicl3fs, BCObjectIdentifiers.picnicl3fs);
        r1.put(PicnicParameters.picnicl3ur, BCObjectIdentifiers.picnicl3ur);
        r1.put(PicnicParameters.picnicl5fs, BCObjectIdentifiers.picnicl5fs);
        r1.put(PicnicParameters.picnicl5ur, BCObjectIdentifiers.picnicl5ur);
        r1.put(PicnicParameters.picnic3l1, BCObjectIdentifiers.picnic3l1);
        r1.put(PicnicParameters.picnic3l3, BCObjectIdentifiers.picnic3l3);
        r1.put(PicnicParameters.picnic3l5, BCObjectIdentifiers.picnic3l5);
        r1.put(PicnicParameters.picnicl1full, BCObjectIdentifiers.picnicl1full);
        r1.put(PicnicParameters.picnicl3full, BCObjectIdentifiers.picnicl3full);
        r1.put(PicnicParameters.picnicl5full, BCObjectIdentifiers.picnicl5full);
        r2.put(BCObjectIdentifiers.picnicl1fs, PicnicParameters.picnicl1fs);
        r2.put(BCObjectIdentifiers.picnicl1ur, PicnicParameters.picnicl1ur);
        r2.put(BCObjectIdentifiers.picnicl3fs, PicnicParameters.picnicl3fs);
        r2.put(BCObjectIdentifiers.picnicl3ur, PicnicParameters.picnicl3ur);
        r2.put(BCObjectIdentifiers.picnicl5fs, PicnicParameters.picnicl5fs);
        r2.put(BCObjectIdentifiers.picnicl5ur, PicnicParameters.picnicl5ur);
        r2.put(BCObjectIdentifiers.picnic3l1, PicnicParameters.picnic3l1);
        r2.put(BCObjectIdentifiers.picnic3l3, PicnicParameters.picnic3l3);
        r2.put(BCObjectIdentifiers.picnic3l5, PicnicParameters.picnic3l5);
        r2.put(BCObjectIdentifiers.picnicl1full, PicnicParameters.picnicl1full);
        r2.put(BCObjectIdentifiers.picnicl3full, PicnicParameters.picnicl3full);
        r2.put(BCObjectIdentifiers.picnicl5full, PicnicParameters.picnicl5full);
        r9.put(SIKEParameters.sikep434, BCObjectIdentifiers.sikep434);
        r9.put(SIKEParameters.sikep503, BCObjectIdentifiers.sikep503);
        r9.put(SIKEParameters.sikep610, BCObjectIdentifiers.sikep610);
        r9.put(SIKEParameters.sikep751, BCObjectIdentifiers.sikep751);
        r9.put(SIKEParameters.sikep434_compressed, BCObjectIdentifiers.sikep434_compressed);
        r9.put(SIKEParameters.sikep503_compressed, BCObjectIdentifiers.sikep503_compressed);
        r9.put(SIKEParameters.sikep610_compressed, BCObjectIdentifiers.sikep610_compressed);
        r9.put(SIKEParameters.sikep751_compressed, BCObjectIdentifiers.sikep751_compressed);
        r10.put(BCObjectIdentifiers.sikep434, SIKEParameters.sikep434);
        r10.put(BCObjectIdentifiers.sikep503, SIKEParameters.sikep503);
        r10.put(BCObjectIdentifiers.sikep610, SIKEParameters.sikep610);
        r10.put(BCObjectIdentifiers.sikep751, SIKEParameters.sikep751);
        r10.put(BCObjectIdentifiers.sikep434_compressed, SIKEParameters.sikep434_compressed);
        r10.put(BCObjectIdentifiers.sikep503_compressed, SIKEParameters.sikep503_compressed);
        r10.put(BCObjectIdentifiers.sikep610_compressed, SIKEParameters.sikep610_compressed);
        r10.put(BCObjectIdentifiers.sikep751_compressed, SIKEParameters.sikep751_compressed);
        r11.put(NTRUParameters.ntruhps2048509, BCObjectIdentifiers.ntruhps2048509);
        r11.put(NTRUParameters.ntruhps2048677, BCObjectIdentifiers.ntruhps2048677);
        r11.put(NTRUParameters.ntruhps4096821, BCObjectIdentifiers.ntruhps4096821);
        r11.put(NTRUParameters.ntruhrss701, BCObjectIdentifiers.ntruhrss701);
        r12.put(BCObjectIdentifiers.ntruhps2048509, NTRUParameters.ntruhps2048509);
        r12.put(BCObjectIdentifiers.ntruhps2048677, NTRUParameters.ntruhps2048677);
        r12.put(BCObjectIdentifiers.ntruhps4096821, NTRUParameters.ntruhps4096821);
        r12.put(BCObjectIdentifiers.ntruhrss701, NTRUParameters.ntruhrss701);
        r13.put(FalconParameters.falcon_512, BCObjectIdentifiers.falcon_512);
        r13.put(FalconParameters.falcon_1024, BCObjectIdentifiers.falcon_1024);
        r14.put(BCObjectIdentifiers.falcon_512, FalconParameters.falcon_512);
        r14.put(BCObjectIdentifiers.falcon_1024, FalconParameters.falcon_1024);
        r15.put(KyberParameters.kyber512, BCObjectIdentifiers.kyber512);
        r15.put(KyberParameters.kyber768, BCObjectIdentifiers.kyber768);
        r15.put(KyberParameters.kyber1024, BCObjectIdentifiers.kyber1024);
        r15.put(KyberParameters.kyber512_aes, BCObjectIdentifiers.kyber512_aes);
        r15.put(KyberParameters.kyber768_aes, BCObjectIdentifiers.kyber768_aes);
        r15.put(KyberParameters.kyber1024_aes, BCObjectIdentifiers.kyber1024_aes);
        r16.put(BCObjectIdentifiers.kyber512, KyberParameters.kyber512);
        r16.put(BCObjectIdentifiers.kyber768, KyberParameters.kyber768);
        r16.put(BCObjectIdentifiers.kyber1024, KyberParameters.kyber1024);
        r16.put(BCObjectIdentifiers.kyber512_aes, KyberParameters.kyber512_aes);
        r16.put(BCObjectIdentifiers.kyber768_aes, KyberParameters.kyber768_aes);
        r16.put(BCObjectIdentifiers.kyber1024_aes, KyberParameters.kyber1024_aes);
        r17.put(NTRULPRimeParameters.ntrulpr653, BCObjectIdentifiers.ntrulpr653);
        r17.put(NTRULPRimeParameters.ntrulpr761, BCObjectIdentifiers.ntrulpr761);
        r17.put(NTRULPRimeParameters.ntrulpr857, BCObjectIdentifiers.ntrulpr857);
        r17.put(NTRULPRimeParameters.ntrulpr953, BCObjectIdentifiers.ntrulpr953);
        r17.put(NTRULPRimeParameters.ntrulpr1013, BCObjectIdentifiers.ntrulpr1013);
        r17.put(NTRULPRimeParameters.ntrulpr1277, BCObjectIdentifiers.ntrulpr1277);
        r18.put(BCObjectIdentifiers.ntrulpr653, NTRULPRimeParameters.ntrulpr653);
        r18.put(BCObjectIdentifiers.ntrulpr761, NTRULPRimeParameters.ntrulpr761);
        r18.put(BCObjectIdentifiers.ntrulpr857, NTRULPRimeParameters.ntrulpr857);
        r18.put(BCObjectIdentifiers.ntrulpr953, NTRULPRimeParameters.ntrulpr953);
        r18.put(BCObjectIdentifiers.ntrulpr1013, NTRULPRimeParameters.ntrulpr1013);
        r18.put(BCObjectIdentifiers.ntrulpr1277, NTRULPRimeParameters.ntrulpr1277);
        r19.put(SNTRUPrimeParameters.sntrup653, BCObjectIdentifiers.sntrup653);
        r19.put(SNTRUPrimeParameters.sntrup761, BCObjectIdentifiers.sntrup761);
        r19.put(SNTRUPrimeParameters.sntrup857, BCObjectIdentifiers.sntrup857);
        r19.put(SNTRUPrimeParameters.sntrup953, BCObjectIdentifiers.sntrup953);
        r19.put(SNTRUPrimeParameters.sntrup1013, BCObjectIdentifiers.sntrup1013);
        r19.put(SNTRUPrimeParameters.sntrup1277, BCObjectIdentifiers.sntrup1277);
        r110.put(BCObjectIdentifiers.sntrup653, SNTRUPrimeParameters.sntrup653);
        r110.put(BCObjectIdentifiers.sntrup761, SNTRUPrimeParameters.sntrup761);
        r110.put(BCObjectIdentifiers.sntrup857, SNTRUPrimeParameters.sntrup857);
        r110.put(BCObjectIdentifiers.sntrup953, SNTRUPrimeParameters.sntrup953);
        r110.put(BCObjectIdentifiers.sntrup1013, SNTRUPrimeParameters.sntrup1013);
        r110.put(BCObjectIdentifiers.sntrup1277, SNTRUPrimeParameters.sntrup1277);
        r111.put(DilithiumParameters.dilithium2, BCObjectIdentifiers.dilithium2);
        r111.put(DilithiumParameters.dilithium3, BCObjectIdentifiers.dilithium3);
        r111.put(DilithiumParameters.dilithium5, BCObjectIdentifiers.dilithium5);
        r111.put(DilithiumParameters.dilithium2_aes, BCObjectIdentifiers.dilithium2_aes);
        r111.put(DilithiumParameters.dilithium3_aes, BCObjectIdentifiers.dilithium3_aes);
        r111.put(DilithiumParameters.dilithium5_aes, BCObjectIdentifiers.dilithium5_aes);
        r112.put(BCObjectIdentifiers.dilithium2, DilithiumParameters.dilithium2);
        r112.put(BCObjectIdentifiers.dilithium3, DilithiumParameters.dilithium3);
        r112.put(BCObjectIdentifiers.dilithium5, DilithiumParameters.dilithium5);
        r112.put(BCObjectIdentifiers.dilithium2_aes, DilithiumParameters.dilithium2_aes);
        r112.put(BCObjectIdentifiers.dilithium3_aes, DilithiumParameters.dilithium3_aes);
        r112.put(BCObjectIdentifiers.dilithium5_aes, DilithiumParameters.dilithium5_aes);
        r114.put(BCObjectIdentifiers.bike128, BIKEParameters.bike128);
        r114.put(BCObjectIdentifiers.bike192, BIKEParameters.bike192);
        r114.put(BCObjectIdentifiers.bike256, BIKEParameters.bike256);
        r113.put(BIKEParameters.bike128, BCObjectIdentifiers.bike128);
        r113.put(BIKEParameters.bike192, BCObjectIdentifiers.bike192);
        r113.put(BIKEParameters.bike256, BCObjectIdentifiers.bike256);
        r116.put(BCObjectIdentifiers.hqc128, HQCParameters.hqc128);
        r116.put(BCObjectIdentifiers.hqc192, HQCParameters.hqc192);
        r116.put(BCObjectIdentifiers.hqc256, HQCParameters.hqc256);
        r115.put(HQCParameters.hqc128, BCObjectIdentifiers.hqc128);
        r115.put(HQCParameters.hqc192, BCObjectIdentifiers.hqc192);
        r115.put(HQCParameters.hqc256, BCObjectIdentifiers.hqc256);
    }

    static ASN1ObjectIdentifier bikeOidLookup(BIKEParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(bikeOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static BIKEParameters bikeParamsLookup(ASN1ObjectIdentifier r2) {
        return (BIKEParameters) ZeusTransformUtils.preCheckCast(bikeParams.get(r2), BIKEParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier dilithiumOidLookup(DilithiumParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(dilithiumOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static DilithiumParameters dilithiumParamsLookup(ASN1ObjectIdentifier r2) {
        return (DilithiumParameters) ZeusTransformUtils.preCheckCast(dilithiumParams.get(r2), DilithiumParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier falconOidLookup(FalconParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(falconOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static FalconParameters falconParamsLookup(ASN1ObjectIdentifier r2) {
        return (FalconParameters) ZeusTransformUtils.preCheckCast(falconParams.get(r2), FalconParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier frodoOidLookup(FrodoParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(frodoOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static FrodoParameters frodoParamsLookup(ASN1ObjectIdentifier r2) {
        return (FrodoParameters) ZeusTransformUtils.preCheckCast(frodoParams.get(r2), FrodoParameters.class, "com.obric.memorydata.plugin");
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(String r3) {
        if (r3.equals("SHA-1") == false) goto L7;
        return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    L7:
        if (r3.equals("SHA-224") == false) goto L11;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224);
    L11:
        if (r3.equals(CryptoConst.ALGORITHM_SHA256) == false) goto L15;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    L15:
        if (r3.equals("SHA-384") == false) goto L19;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
    L19:
        if (r3.equals("SHA-512") == false) goto L23;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
    L23:
        throw new IllegalArgumentException("unrecognised digest algorithm: " + r3);
    }

    static Digest getDigest(ASN1ObjectIdentifier r3) {
        if (r3.equals(NISTObjectIdentifiers.id_sha256) == false) goto L7;
        return new SHA256Digest();
    L7:
        if (r3.equals(NISTObjectIdentifiers.id_sha512) == false) goto L11;
        return new SHA512Digest();
    L11:
        if (r3.equals(NISTObjectIdentifiers.id_shake128) == false) goto L15;
        return new SHAKEDigest(128);
    L15:
        if (r3.equals(NISTObjectIdentifiers.id_shake256) == false) goto L19;
        return new SHAKEDigest(256);
    L19:
        throw new IllegalArgumentException("unrecognized digest OID: " + r3);
    }

    public static String getDigestName(ASN1ObjectIdentifier r3) {
        if (r3.equals(OIWObjectIdentifiers.idSHA1) == false) goto L7;
        return "SHA-1";
    L7:
        if (r3.equals(NISTObjectIdentifiers.id_sha224) == false) goto L11;
        return "SHA-224";
    L11:
        if (r3.equals(NISTObjectIdentifiers.id_sha256) == false) goto L15;
        return CryptoConst.ALGORITHM_SHA256;
    L15:
        if (r3.equals(NISTObjectIdentifiers.id_sha384) == false) goto L19;
        return "SHA-384";
    L19:
        if (r3.equals(NISTObjectIdentifiers.id_sha512) == false) goto L23;
        return "SHA-512";
    L23:
        throw new IllegalArgumentException("unrecognised digest algorithm: " + r3);
    }

    static ASN1ObjectIdentifier hqcOidLookup(HQCParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(hqcOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static HQCParameters hqcParamsLookup(ASN1ObjectIdentifier r2) {
        return (HQCParameters) ZeusTransformUtils.preCheckCast(hqcParams.get(r2), HQCParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier kyberOidLookup(KyberParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(kyberOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static KyberParameters kyberParamsLookup(ASN1ObjectIdentifier r2) {
        return (KyberParameters) ZeusTransformUtils.preCheckCast(kyberParams.get(r2), KyberParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier mcElieceOidLookup(CMCEParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(mcElieceOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static CMCEParameters mcElieceParamsLookup(ASN1ObjectIdentifier r2) {
        return (CMCEParameters) ZeusTransformUtils.preCheckCast(mcElieceParams.get(r2), CMCEParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier ntruOidLookup(NTRUParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(ntruOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static NTRUParameters ntruParamsLookup(ASN1ObjectIdentifier r2) {
        return (NTRUParameters) ZeusTransformUtils.preCheckCast(ntruParams.get(r2), NTRUParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier ntrulprimeOidLookup(NTRULPRimeParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(ntruprimeOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static NTRULPRimeParameters ntrulprimeParamsLookup(ASN1ObjectIdentifier r2) {
        return (NTRULPRimeParameters) ZeusTransformUtils.preCheckCast(ntruprimeParams.get(r2), NTRULPRimeParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier picnicOidLookup(PicnicParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(picnicOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static PicnicParameters picnicParamsLookup(ASN1ObjectIdentifier r2) {
        return (PicnicParameters) ZeusTransformUtils.preCheckCast(picnicParams.get(r2), PicnicParameters.class, "com.obric.memorydata.plugin");
    }

    static AlgorithmIdentifier qTeslaLookupAlgID(int r3) {
        if (r3 == 5) goto L11;
        if (r3 != 6) goto L9;
        return AlgID_qTESLA_p_III;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r3);
    L11:
        return AlgID_qTESLA_p_I;
    }

    static int qTeslaLookupSecurityCategory(AlgorithmIdentifier r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(categories.get(r2.getAlgorithm()), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    static ASN1ObjectIdentifier saberOidLookup(SABERParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(saberOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static SABERParameters saberParamsLookup(ASN1ObjectIdentifier r2) {
        return (SABERParameters) ZeusTransformUtils.preCheckCast(saberParams.get(r2), SABERParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier sikeOidLookup(SIKEParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(sikeOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static SIKEParameters sikeParamsLookup(ASN1ObjectIdentifier r2) {
        return (SIKEParameters) ZeusTransformUtils.preCheckCast(sikeParams.get(r2), SIKEParameters.class, "com.obric.memorydata.plugin");
    }

    static ASN1ObjectIdentifier sntruprimeOidLookup(SNTRUPrimeParameters r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(sntruprimeOids.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    static SNTRUPrimeParameters sntruprimeParamsLookup(ASN1ObjectIdentifier r2) {
        return (SNTRUPrimeParameters) ZeusTransformUtils.preCheckCast(sntruprimeParams.get(r2), SNTRUPrimeParameters.class, "com.obric.memorydata.plugin");
    }

    static AlgorithmIdentifier sphincs256LookupTreeAlgID(String r3) {
        if (r3.equals("SHA3-256") == false) goto L7;
        return SPHINCS_SHA3_256;
    L7:
        if (r3.equals("SHA-512/256") == false) goto L11;
        return SPHINCS_SHA512_256;
    L11:
        throw new IllegalArgumentException("unknown tree digest: " + r3);
    }

    static String sphincs256LookupTreeAlgName(SPHINCS256KeyParams r3) {
        AlgorithmIdentifier r4 = r3.getTreeDigest();
        if (r4.getAlgorithm().equals(SPHINCS_SHA3_256.getAlgorithm()) == false) goto L7;
        return "SHA3-256";
    L7:
        if (r4.getAlgorithm().equals(SPHINCS_SHA512_256.getAlgorithm()) == false) goto L11;
        return "SHA-512/256";
    L11:
        throw new IllegalArgumentException("unknown tree digest: " + r4.getAlgorithm());
    }

    static ASN1ObjectIdentifier sphincsPlusOidLookup(SPHINCSPlusParameters r2) {
        int r3 = SPHINCSPlusParameters.getID(r2).intValue();
        int r1 = r3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if (r1 != 196608) goto L7;
        return BCObjectIdentifiers.sphincsPlus_haraka;
    L7:
        if (r1 != 131072) goto L11;
        return BCObjectIdentifiers.sphincsPlus_shake_256;
    L11:
        if ((r3 & 5) == 5) goto L18;
        if ((r3 & 6) == 6) goto L18;
        return BCObjectIdentifiers.sphincsPlus_sha_256;
    L18:
        return BCObjectIdentifiers.sphincsPlus_sha_512;
    }

    static AlgorithmIdentifier xmssLookupTreeAlgID(String r3) {
        if (r3.equals(CryptoConst.ALGORITHM_SHA256) == false) goto L7;
        return XMSS_SHA256;
    L7:
        if (r3.equals("SHA-512") == false) goto L11;
        return XMSS_SHA512;
    L11:
        if (r3.equals("SHAKE128") == false) goto L15;
        return XMSS_SHAKE128;
    L15:
        if (r3.equals("SHAKE256") == false) goto L19;
        return XMSS_SHAKE256;
    L19:
        throw new IllegalArgumentException("unknown tree digest: " + r3);
    }
}
