package org.bouncycastle.pqc.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.CMCEPublicKey;
import org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.asn1.XMSSKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import org.bouncycastle.pqc.asn1.XMSSPublicKey;
import org.bouncycastle.pqc.crypto.bike.BIKEPublicKeyParameters;
import org.bouncycastle.pqc.crypto.cmce.CMCEPublicKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumPublicKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberParameters;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberPublicKeyParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconPublicKeyParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoPublicKeyParameters;
import org.bouncycastle.pqc.crypto.hqc.HQCPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.pqc.crypto.ntru.NTRUPublicKeyParameters;
import org.bouncycastle.pqc.crypto.ntruprime.NTRULPRimePublicKeyParameters;
import org.bouncycastle.pqc.crypto.ntruprime.SNTRUPrimePublicKeyParameters;
import org.bouncycastle.pqc.crypto.picnic.PicnicPublicKeyParameters;
import org.bouncycastle.pqc.crypto.saber.SABERPublicKeyParameters;
import org.bouncycastle.pqc.crypto.sike.SIKEPublicKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.qtesla.QTESLAPublicKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class PublicKeyFactory {
    private static Map converters;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.util.PublicKeyFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BIKEConverter extends SubjectPublicKeyInfoConverter {
        private BIKEConverter() {
            super(null);
        }

        /* synthetic */ BIKEConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new BIKEPublicKeyParameters(Utils.bikeParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class CMCEConverter extends SubjectPublicKeyInfoConverter {
        private CMCEConverter() {
            super(null);
        }

        /* synthetic */ CMCEConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = CMCEPublicKey.getInstance(r1.parsePublicKey()).getT();
            return new CMCEPublicKeyParameters(Utils.mcElieceParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class DilithiumConverter extends SubjectPublicKeyInfoConverter {
        private DilithiumConverter() {
            super(null);
        }

        /* synthetic */ DilithiumConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r3, Object r4) {
            DilithiumParameters r2 = Utils.dilithiumParamsLookup(r3.getAlgorithm().getAlgorithm());
            ASN1Primitive r5 = r3.parsePublicKey();
            if (ZeusTransformUtils.instanceOf(r5, ASN1Sequence.class) == false) goto L7;
            ASN1Sequence r6 = ASN1Sequence.getInstance(r5);
            return new DilithiumPublicKeyParameters(r2, ASN1OctetString.getInstance(r6.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(r6.getObjectAt(1)).getOctets());
        L7:
            return new DilithiumPublicKeyParameters(r2, ASN1OctetString.getInstance(r5).getOctets());
        }
    }

    private static class FalconConverter extends SubjectPublicKeyInfoConverter {
        private FalconConverter() {
            super(null);
        }

        /* synthetic */ FalconConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r3, Object r4) {
            FalconParameters r2 = Utils.falconParamsLookup(r3.getAlgorithm().getAlgorithm());
            ASN1Primitive r5 = r3.parsePublicKey();
            if (ZeusTransformUtils.instanceOf(r5, ASN1Sequence.class) == true) goto L5;
            byte[] r6 = ASN1OctetString.getInstance(r5).getOctets();
            if (r6[0] != ((byte) (r2.getLogN() + 0))) goto L11;
            return new FalconPublicKeyParameters(r2, Arrays.copyOfRange(r6, 1, r6.length));
        L11:
            throw new IllegalArgumentException("byte[] enc of Falcon h value not tagged correctly");
        L5:
            return new FalconPublicKeyParameters(r2, ASN1OctetString.getInstance(ASN1Sequence.getInstance(r5).getObjectAt(0)).getOctets());
        }
    }

    private static class FrodoConverter extends SubjectPublicKeyInfoConverter {
        private FrodoConverter() {
            super(null);
        }

        /* synthetic */ FrodoConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new FrodoPublicKeyParameters(Utils.frodoParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class HQCConverter extends SubjectPublicKeyInfoConverter {
        private HQCConverter() {
            super(null);
        }

        /* synthetic */ HQCConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new HQCPublicKeyParameters(Utils.hqcParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class KyberConverter extends SubjectPublicKeyInfoConverter {
        private KyberConverter() {
            super(null);
        }

        /* synthetic */ KyberConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r3, Object r4) {
            KyberParameters r2 = Utils.kyberParamsLookup(r3.getAlgorithm().getAlgorithm());
            ASN1Primitive r5 = r3.parsePublicKey();
            if (ZeusTransformUtils.instanceOf(r5, ASN1Sequence.class) == false) goto L7;
            ASN1Sequence r6 = ASN1Sequence.getInstance(r5);
            return new KyberPublicKeyParameters(r2, ASN1OctetString.getInstance(r6.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(r6.getObjectAt(1)).getOctets());
        L7:
            return new KyberPublicKeyParameters(r2, ASN1OctetString.getInstance(r5).getOctets());
        }
    }

    private static class LMSConverter extends SubjectPublicKeyInfoConverter {
        private LMSConverter() {
            super(null);
        }

        /* synthetic */ LMSConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r2, Object r3) {
            byte[] r1 = ASN1OctetString.getInstance(r2.parsePublicKey()).getOctets();
            if (Pack.bigEndianToInt(r1, 0) != 1) goto L7;
            return LMSPublicKeyParameters.getInstance(Arrays.copyOfRange(r1, 4, r1.length));
        L7:
            if (r1.length != 64) goto L10;
            r1 = Arrays.copyOfRange(r1, 4, r1.length);
        L10:
            return HSSPublicKeyParameters.getInstance(r1);
        }
    }

    private static class McElieceCCA2Converter extends SubjectPublicKeyInfoConverter {
        private McElieceCCA2Converter() {
            super(null);
        }

        /* synthetic */ McElieceCCA2Converter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r3, Object r4) {
            McElieceCCA2PublicKey r2 = McElieceCCA2PublicKey.getInstance(r3.parsePublicKey());
            return new McElieceCCA2PublicKeyParameters(r2.getN(), r2.getT(), r2.getG(), Utils.getDigestName(r2.getDigest().getAlgorithm()));
        }
    }

    private static class NHConverter extends SubjectPublicKeyInfoConverter {
        private NHConverter() {
            super(null);
        }

        /* synthetic */ NHConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            return new NHPublicKeyParameters(r1.getPublicKeyData().getBytes());
        }
    }

    private static class NTRULPrimeConverter extends SubjectPublicKeyInfoConverter {
        private NTRULPrimeConverter() {
            super(null);
        }

        /* synthetic */ NTRULPrimeConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new NTRULPRimePublicKeyParameters(Utils.ntrulprimeParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class NtruConverter extends SubjectPublicKeyInfoConverter {
        private NtruConverter() {
            super(null);
        }

        /* synthetic */ NtruConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new NTRUPublicKeyParameters(Utils.ntruParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class PicnicConverter extends SubjectPublicKeyInfoConverter {
        private PicnicConverter() {
            super(null);
        }

        /* synthetic */ PicnicConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new PicnicPublicKeyParameters(Utils.picnicParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class QTeslaConverter extends SubjectPublicKeyInfoConverter {
        private QTeslaConverter() {
            super(null);
        }

        /* synthetic */ QTeslaConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            return new QTESLAPublicKeyParameters(Utils.qTeslaLookupSecurityCategory(r1.getAlgorithm()), r1.getPublicKeyData().getOctets());
        }
    }

    private static class SABERConverter extends SubjectPublicKeyInfoConverter {
        private SABERConverter() {
            super(null);
        }

        /* synthetic */ SABERConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(ASN1Sequence.getInstance(r1.parsePublicKey()).getObjectAt(0)).getOctets();
            return new SABERPublicKeyParameters(Utils.saberParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class SIKEConverter extends SubjectPublicKeyInfoConverter {
        private SIKEConverter() {
            super(null);
        }

        /* synthetic */ SIKEConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new SIKEPublicKeyParameters(Utils.sikeParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class SNTRUPrimeConverter extends SubjectPublicKeyInfoConverter {
        private SNTRUPrimeConverter() {
            super(null);
        }

        /* synthetic */ SNTRUPrimeConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            byte[] r0 = ASN1OctetString.getInstance(r1.parsePublicKey()).getOctets();
            return new SNTRUPrimePublicKeyParameters(Utils.sntruprimeParamsLookup(r1.getAlgorithm().getAlgorithm()), r0);
        }
    }

    private static class SPHINCSConverter extends SubjectPublicKeyInfoConverter {
        private SPHINCSConverter() {
            super(null);
        }

        /* synthetic */ SPHINCSConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2) {
            return new SPHINCSPublicKeyParameters(r1.getPublicKeyData().getBytes(), Utils.sphincs256LookupTreeAlgName(SPHINCS256KeyParams.getInstance(r1.getAlgorithm().getParameters())));
        }
    }

    private static class SPHINCSPlusConverter extends SubjectPublicKeyInfoConverter {
        private SPHINCSPlusConverter() {
            super(null);
        }

        /* synthetic */ SPHINCSPlusConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r3, Object r4) {
            byte[] r2 = ASN1OctetString.getInstance(r3.parsePublicKey()).getOctets();
            return new SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters.getParams(Integers.valueOf(Pack.bigEndianToInt(r2, 0))), Arrays.copyOfRange(r2, 4, r2.length));
        }
    }

    private static abstract class SubjectPublicKeyInfoConverter {
        private SubjectPublicKeyInfoConverter() {
        }

        /* synthetic */ SubjectPublicKeyInfoConverter(AnonymousClass1 r1) {
            this();
        }

        abstract AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r1, Object r2);
    }

    private static class XMSSConverter extends SubjectPublicKeyInfoConverter {
        private XMSSConverter() {
            super(null);
        }

        /* synthetic */ XMSSConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r3, Object r4) {
            XMSSKeyParams r2 = XMSSKeyParams.getInstance(r3.getAlgorithm().getParameters());
            if (r2 == null) goto L7;
            ASN1ObjectIdentifier r5 = r2.getTreeDigest().getAlgorithm();
            XMSSPublicKey r6 = XMSSPublicKey.getInstance(r3.parsePublicKey());
            XMSSPublicKeyParameters.Builder r7 = new XMSSPublicKeyParameters.Builder(new XMSSParameters(r2.getHeight(), Utils.getDigest(r5))).withPublicSeed(r6.getPublicSeed()).withRoot(r6.getRoot());
        L6:
            return r7.build();
        L7:
            byte[] r8 = ASN1OctetString.getInstance(r3.parsePublicKey()).getOctets();
            r7 = new XMSSPublicKeyParameters.Builder(XMSSParameters.lookupByOID(Pack.bigEndianToInt(r8, 0))).withPublicKey(r8);
            goto L6
        }
    }

    private static class XMSSMTConverter extends SubjectPublicKeyInfoConverter {
        private XMSSMTConverter() {
            super(null);
        }

        /* synthetic */ XMSSMTConverter(AnonymousClass1 r1) {
            this();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo r4, Object r5) {
            XMSSMTKeyParams r3 = XMSSMTKeyParams.getInstance(r4.getAlgorithm().getParameters());
            if (r3 == null) goto L7;
            ASN1ObjectIdentifier r6 = r3.getTreeDigest().getAlgorithm();
            XMSSPublicKey r7 = XMSSPublicKey.getInstance(r4.parsePublicKey());
            XMSSMTPublicKeyParameters.Builder r8 = new XMSSMTPublicKeyParameters.Builder(new XMSSMTParameters(r3.getHeight(), r3.getLayers(), Utils.getDigest(r6))).withPublicSeed(r7.getPublicSeed()).withRoot(r7.getRoot());
        L6:
            return r8.build();
        L7:
            byte[] r9 = ASN1OctetString.getInstance(r4.parsePublicKey()).getOctets();
            r8 = new XMSSMTPublicKeyParameters.Builder(XMSSMTParameters.lookupByOID(Pack.bigEndianToInt(r9, 0))).withPublicKey(r9);
            goto L6
        }
    }

    static {
        HashMap r0 = new HashMap();
        converters = r0;
        AnonymousClass1 r3 = null;
        r0.put(PQCObjectIdentifiers.qTESLA_p_I, new QTeslaConverter(r3));
        converters.put(PQCObjectIdentifiers.qTESLA_p_III, new QTeslaConverter(r3));
        converters.put(PQCObjectIdentifiers.sphincs256, new SPHINCSConverter(r3));
        converters.put(PQCObjectIdentifiers.newHope, new NHConverter(r3));
        converters.put(PQCObjectIdentifiers.xmss, new XMSSConverter(r3));
        converters.put(PQCObjectIdentifiers.xmss_mt, new XMSSMTConverter(r3));
        converters.put(IsaraObjectIdentifiers.id_alg_xmss, new XMSSConverter(r3));
        converters.put(IsaraObjectIdentifiers.id_alg_xmssmt, new XMSSMTConverter(r3));
        converters.put(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new LMSConverter(r3));
        converters.put(PQCObjectIdentifiers.mcElieceCca2, new McElieceCCA2Converter(r3));
        converters.put(BCObjectIdentifiers.sphincsPlus, new SPHINCSPlusConverter(r3));
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_256, new SPHINCSPlusConverter(r3));
        converters.put(BCObjectIdentifiers.sphincsPlus_sha_256, new SPHINCSPlusConverter(r3));
        converters.put(BCObjectIdentifiers.sphincsPlus_sha_512, new SPHINCSPlusConverter(r3));
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka, new SPHINCSPlusConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece348864_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece348864f_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece460896_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece460896f_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece6688128_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece6688128f_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece6960119_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece6960119f_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece8192128_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.mceliece8192128f_r3, new CMCEConverter(r3));
        converters.put(BCObjectIdentifiers.frodokem640aes, new FrodoConverter(r3));
        converters.put(BCObjectIdentifiers.frodokem640shake, new FrodoConverter(r3));
        converters.put(BCObjectIdentifiers.frodokem976aes, new FrodoConverter(r3));
        converters.put(BCObjectIdentifiers.frodokem976shake, new FrodoConverter(r3));
        converters.put(BCObjectIdentifiers.frodokem1344aes, new FrodoConverter(r3));
        converters.put(BCObjectIdentifiers.frodokem1344shake, new FrodoConverter(r3));
        converters.put(BCObjectIdentifiers.lightsaberkem128r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.saberkem128r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.firesaberkem128r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.lightsaberkem192r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.saberkem192r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.firesaberkem192r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.lightsaberkem256r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.saberkem256r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.firesaberkem256r3, new SABERConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl1fs, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl1ur, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl3fs, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl3ur, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl5fs, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl5ur, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnic3l1, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnic3l3, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnic3l5, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl1full, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl3full, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.picnicl5full, new PicnicConverter(r3));
        converters.put(BCObjectIdentifiers.sikep434, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.sikep503, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.sikep610, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.sikep751, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.sikep434_compressed, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.sikep503_compressed, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.sikep610_compressed, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.sikep751_compressed, new SIKEConverter(r3));
        converters.put(BCObjectIdentifiers.ntruhps2048509, new NtruConverter(r3));
        converters.put(BCObjectIdentifiers.ntruhps2048677, new NtruConverter(r3));
        converters.put(BCObjectIdentifiers.ntruhps4096821, new NtruConverter(r3));
        converters.put(BCObjectIdentifiers.ntruhrss701, new NtruConverter(r3));
        converters.put(BCObjectIdentifiers.falcon_512, new FalconConverter(r3));
        converters.put(BCObjectIdentifiers.falcon_1024, new FalconConverter(r3));
        converters.put(BCObjectIdentifiers.kyber512, new KyberConverter(r3));
        converters.put(BCObjectIdentifiers.kyber768, new KyberConverter(r3));
        converters.put(BCObjectIdentifiers.kyber1024, new KyberConverter(r3));
        converters.put(BCObjectIdentifiers.kyber512_aes, new KyberConverter(r3));
        converters.put(BCObjectIdentifiers.kyber768_aes, new KyberConverter(r3));
        converters.put(BCObjectIdentifiers.kyber1024_aes, new KyberConverter(r3));
        converters.put(BCObjectIdentifiers.ntrulpr653, new NTRULPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.ntrulpr761, new NTRULPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.ntrulpr857, new NTRULPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.ntrulpr953, new NTRULPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.ntrulpr1013, new NTRULPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.ntrulpr1277, new NTRULPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.sntrup653, new SNTRUPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.sntrup761, new SNTRUPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.sntrup857, new SNTRUPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.sntrup953, new SNTRUPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.sntrup1013, new SNTRUPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.sntrup1277, new SNTRUPrimeConverter(r3));
        converters.put(BCObjectIdentifiers.dilithium2, new DilithiumConverter(r3));
        converters.put(BCObjectIdentifiers.dilithium3, new DilithiumConverter(r3));
        converters.put(BCObjectIdentifiers.dilithium5, new DilithiumConverter(r3));
        converters.put(BCObjectIdentifiers.dilithium2_aes, new DilithiumConverter(r3));
        converters.put(BCObjectIdentifiers.dilithium3_aes, new DilithiumConverter(r3));
        converters.put(BCObjectIdentifiers.dilithium5_aes, new DilithiumConverter(r3));
        converters.put(BCObjectIdentifiers.bike128, new BIKEConverter(r3));
        converters.put(BCObjectIdentifiers.bike192, new BIKEConverter(r3));
        converters.put(BCObjectIdentifiers.bike256, new BIKEConverter(r3));
        converters.put(BCObjectIdentifiers.hqc128, new HQCConverter(r3));
        converters.put(BCObjectIdentifiers.hqc192, new HQCConverter(r3));
        converters.put(BCObjectIdentifiers.hqc256, new HQCConverter(r3));
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo r1) {
        return createKey(r1, null);
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo r4, Object r5) {
        AlgorithmIdentifier r0 = r4.getAlgorithm();
        SubjectPublicKeyInfoConverter r1 = (SubjectPublicKeyInfoConverter) ZeusTransformUtils.preCheckCast(converters.get(r0.getAlgorithm()), SubjectPublicKeyInfoConverter.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return r1.getPublicKeyParameters(r4, r5);
    L7:
        throw new IOException("algorithm identifier in public key not recognised: " + r0.getAlgorithm());
    }
}
