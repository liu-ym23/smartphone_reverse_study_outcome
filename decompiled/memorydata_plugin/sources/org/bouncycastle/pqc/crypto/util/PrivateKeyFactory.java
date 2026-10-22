package org.bouncycastle.pqc.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.CMCEPrivateKey;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.asn1.XMSSKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTPrivateKey;
import org.bouncycastle.pqc.asn1.XMSSPrivateKey;
import org.bouncycastle.pqc.crypto.bike.BIKEParameters;
import org.bouncycastle.pqc.crypto.bike.BIKEPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.cmce.CMCEPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberParameters;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.hqc.HQCPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.ntru.NTRUPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.ntruprime.NTRULPRimePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.ntruprime.SNTRUPrimePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.picnic.PicnicPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.saber.SABERPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sike.SIKEPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSUtil;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.qtesla.QTESLAPrivateKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class PrivateKeyFactory {
    private static short[] convert(byte[] r4) {
        int r0 = r4.length / 2;
        short[] r1 = new short[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = Pack.littleEndianToShort(r4, r2 * 2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static AsymmetricKeyParameter createKey(PrivateKeyInfo r18) {
        ASN1ObjectIdentifier r0 = r18.getPrivateKeyAlgorithm().getAlgorithm();
        if (r0.on(BCObjectIdentifiers.qTESLA) == false) goto L7;
        return new QTESLAPrivateKeyParameters(Utils.qTeslaLookupSecurityCategory(r18.getPrivateKeyAlgorithm()), ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets());
    L7:
        if (r0.equals(BCObjectIdentifiers.sphincs256) == false) goto L11;
        return new SPHINCSPrivateKeyParameters(ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets(), Utils.sphincs256LookupTreeAlgName(SPHINCS256KeyParams.getInstance(r18.getPrivateKeyAlgorithm().getParameters())));
    L11:
        if (r0.equals(BCObjectIdentifiers.newHope) == false) goto L15;
        return new NHPrivateKeyParameters(convert(ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets()));
    L15:
        if (r0.equals(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig) == false) goto L29;
        byte[] r1 = ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets();
        ASN1BitString r2 = r18.getPublicKeyData();
        if (Pack.bigEndianToInt(r1, 0) != 1) goto L23;
        if (r2 == null) goto L22;
        byte[] r3 = r2.getOctets();
        return LMSPrivateKeyParameters.getInstance(Arrays.copyOfRange(r1, 4, r1.length), Arrays.copyOfRange(r3, 4, r3.length));
    L22:
        return LMSPrivateKeyParameters.getInstance(Arrays.copyOfRange(r1, 4, r1.length));
    L23:
        if (r2 == null) goto L27;
        return HSSPrivateKeyParameters.getInstance(Arrays.copyOfRange(r1, 4, r1.length), r2.getOctets());
    L27:
        return HSSPrivateKeyParameters.getInstance(Arrays.copyOfRange(r1, 4, r1.length));
    L29:
        if (r0.on(BCObjectIdentifiers.sphincsPlus) == false) goto L33;
        byte[] r4 = ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets();
        return new SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters.getParams(Integers.valueOf(Pack.bigEndianToInt(r4, 0))), Arrays.copyOfRange(r4, 4, r4.length));
    L33:
        if (r0.on(BCObjectIdentifiers.picnic) == false) goto L37;
        return new PicnicPrivateKeyParameters(Utils.picnicParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets());
    L37:
        if (r0.on(BCObjectIdentifiers.pqc_kem_mceliece) == false) goto L41;
        CMCEPrivateKey r5 = CMCEPrivateKey.getInstance(r18.parsePrivateKey());
        return new CMCEPrivateKeyParameters(Utils.mcElieceParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), r5.getDelta(), r5.getC(), r5.getG(), r5.getAlpha(), r5.getS());
    L41:
        if (r0.on(BCObjectIdentifiers.pqc_kem_frodo) == false) goto L45;
        return new FrodoPrivateKeyParameters(Utils.frodoParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets());
    L45:
        if (r0.on(BCObjectIdentifiers.pqc_kem_saber) == false) goto L49;
        return new SABERPrivateKeyParameters(Utils.saberParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets());
    L49:
        if (r0.on(BCObjectIdentifiers.pqc_kem_sike) == false) goto L53;
        return new SIKEPrivateKeyParameters(Utils.sikeParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets());
    L53:
        if (r0.on(BCObjectIdentifiers.pqc_kem_ntru) == false) goto L57;
        return new NTRUPrivateKeyParameters(Utils.ntruParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets());
    L57:
        if (r0.on(BCObjectIdentifiers.pqc_kem_kyber) == false) goto L69;
        ASN1Sequence r6 = ASN1Sequence.getInstance(r18.parsePrivateKey());
        KyberParameters r9 = Utils.kyberParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm());
        int r7 = ASN1Integer.getInstance(r6.getObjectAt(0)).intValueExact();
        if (r7 != 0) goto L67;
        if (r18.getPublicKeyData() == null) goto L65;
        ASN1Sequence r8 = ASN1Sequence.getInstance(r18.getPublicKeyData().getOctets());
        return new KyberPrivateKeyParameters(r9, DEROctetString.getInstance(r6.getObjectAt(1)).getOctets(), DEROctetString.getInstance(r6.getObjectAt(2)).getOctets(), DEROctetString.getInstance(r6.getObjectAt(3)).getOctets(), ASN1OctetString.getInstance(r8.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(r8.getObjectAt(1)).getOctets());
    L65:
        return new KyberPrivateKeyParameters(r9, ASN1OctetString.getInstance(r6.getObjectAt(1)).getOctets(), ASN1OctetString.getInstance(r6.getObjectAt(2)).getOctets(), ASN1OctetString.getInstance(r6.getObjectAt(3)).getOctets(), null, null);
    L67:
        throw new IOException("unknown private key version: " + r7);
    L69:
        if (r0.on(BCObjectIdentifiers.pqc_kem_ntrulprime) == false) goto L73;
        ASN1Sequence r10 = ASN1Sequence.getInstance(r18.parsePrivateKey());
        return new NTRULPRimePrivateKeyParameters(Utils.ntrulprimeParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r10.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(r10.getObjectAt(1)).getOctets(), ASN1OctetString.getInstance(r10.getObjectAt(2)).getOctets(), ASN1OctetString.getInstance(r10.getObjectAt(3)).getOctets());
    L73:
        if (r0.on(BCObjectIdentifiers.pqc_kem_sntruprime) == false) goto L77;
        ASN1Sequence r11 = ASN1Sequence.getInstance(r18.parsePrivateKey());
        return new SNTRUPrimePrivateKeyParameters(Utils.sntruprimeParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r11.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(r11.getObjectAt(1)).getOctets(), ASN1OctetString.getInstance(r11.getObjectAt(2)).getOctets(), ASN1OctetString.getInstance(r11.getObjectAt(3)).getOctets(), ASN1OctetString.getInstance(r11.getObjectAt(4)).getOctets());
    L77:
        if (r0.equals(BCObjectIdentifiers.dilithium2) == false) goto L79;
    L146:
        ASN1Sequence r12 = ASN1Sequence.getInstance(r18.parsePrivateKey());
        DilithiumParameters r13 = Utils.dilithiumParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm());
        int r14 = ASN1Integer.getInstance(r12.getObjectAt(0)).intValueExact();
        if (r14 != 0) goto L155;
        if (r18.getPublicKeyData() == null) goto L153;
        return new DilithiumPrivateKeyParameters(r13, ASN1BitString.getInstance(r12.getObjectAt(1)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(2)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(3)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(4)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(5)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(6)).getOctets(), ASN1OctetString.getInstance(ASN1Sequence.getInstance(r18.getPublicKeyData().getOctets()).getObjectAt(1)).getOctets());
    L153:
        return new DilithiumPrivateKeyParameters(r13, ASN1BitString.getInstance(r12.getObjectAt(1)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(2)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(3)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(4)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(5)).getOctets(), ASN1BitString.getInstance(r12.getObjectAt(6)).getOctets(), null);
    L155:
        throw new IOException("unknown private key version: " + r14);
    L79:
        if (r0.equals(BCObjectIdentifiers.dilithium3) == true) goto L146;
        if (r0.equals(BCObjectIdentifiers.dilithium5) == true) goto L146;
        if (r0.equals(BCObjectIdentifiers.dilithium2_aes) == true) goto L146;
        if (r0.equals(BCObjectIdentifiers.dilithium3_aes) == true) goto L146;
        if (r0.equals(BCObjectIdentifiers.dilithium5_aes) == true) goto L146;
        if (r0.equals(BCObjectIdentifiers.falcon_512) == false) goto L92;
    L136:
        ASN1Sequence r15 = ASN1Sequence.getInstance(r18.parsePrivateKey());
        FalconParameters r16 = Utils.falconParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm());
        ASN1BitString r17 = r18.getPublicKeyData();
        int r19 = ASN1Integer.getInstance(r15.getObjectAt(0)).intValueExact();
        if (r19 != 1) goto L145;
        if (r18.getPublicKeyData() == null) goto L143;
        return new FalconPrivateKeyParameters(r16, ASN1OctetString.getInstance(r15.getObjectAt(1)).getOctets(), ASN1OctetString.getInstance(r15.getObjectAt(2)).getOctets(), ASN1OctetString.getInstance(r15.getObjectAt(3)).getOctets(), r17.getOctets());
    L143:
        return new FalconPrivateKeyParameters(r16, ASN1OctetString.getInstance(r15.getObjectAt(1)).getOctets(), ASN1OctetString.getInstance(r15.getObjectAt(2)).getOctets(), ASN1OctetString.getInstance(r15.getObjectAt(3)).getOctets(), null);
    L145:
        throw new IOException("unknown private key version: " + r19);
    L92:
        if (r0.equals(BCObjectIdentifiers.falcon_1024) == true) goto L136;
        if (r0.on(BCObjectIdentifiers.pqc_kem_bike) == false) goto L99;
        byte[] r20 = ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets();
        BIKEParameters r21 = Utils.bikeParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm());
        return new BIKEPrivateKeyParameters(r21, Arrays.copyOfRange(r20, 0, r21.getRByte()), Arrays.copyOfRange(r20, r21.getRByte(), r21.getRByte() * 2), Arrays.copyOfRange(r20, r21.getRByte() * 2, r20.length));
    L99:
        if (r0.on(BCObjectIdentifiers.pqc_kem_hqc) == false) goto L103;
        return new HQCPrivateKeyParameters(Utils.hqcParamsLookup(r18.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(r18.parsePrivateKey()).getOctets());
    L103:
        if (r0.equals(BCObjectIdentifiers.xmss) == false) goto L117;
        XMSSKeyParams r22 = XMSSKeyParams.getInstance(r18.getPrivateKeyAlgorithm().getParameters());
        ASN1ObjectIdentifier r23 = r22.getTreeDigest().getAlgorithm();
        XMSSPrivateKey r24 = XMSSPrivateKey.getInstance(r18.parsePrivateKey());
        XMSSPrivateKeyParameters.Builder r25 = new XMSSPrivateKeyParameters.Builder(new XMSSParameters(r22.getHeight(), Utils.getDigest(r23))).withIndex(r24.getIndex()).withSecretKeySeed(r24.getSecretKeySeed()).withSecretKeyPRF(r24.getSecretKeyPRF()).withPublicSeed(r24.getPublicSeed()).withRoot(r24.getRoot());     // Catch: ClassNotFoundException -> L113
        if (r24.getVersion() == 0) goto L109;
        r25.withMaxIndex(r24.getMaxIndex());     // Catch: ClassNotFoundException -> L113
    L109:
        if (r24.getBdsState() == null) goto L111;
        r25.withBDSState(((BDS) ZeusTransformUtils.preCheckCast(XMSSUtil.deserialize(r24.getBdsState(), BDS.class), BDS.class, "com.obric.memorydata.plugin")).withWOTSDigest(r23));     // Catch: ClassNotFoundException -> L113
    L111:
        return r25.build();
    L113:
        e = move-exception;
        throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
    L117:
        if (r0.equals(PQCObjectIdentifiers.xmss_mt) == false) goto L131;
        XMSSMTKeyParams r26 = XMSSMTKeyParams.getInstance(r18.getPrivateKeyAlgorithm().getParameters());
        ASN1ObjectIdentifier r27 = r26.getTreeDigest().getAlgorithm();
        XMSSMTPrivateKey r28 = XMSSMTPrivateKey.getInstance(r18.parsePrivateKey());     // Catch: ClassNotFoundException -> L127
        XMSSMTPrivateKeyParameters.Builder r29 = new XMSSMTPrivateKeyParameters.Builder(new XMSSMTParameters(r26.getHeight(), r26.getLayers(), Utils.getDigest(r27))).withIndex(r28.getIndex()).withSecretKeySeed(r28.getSecretKeySeed()).withSecretKeyPRF(r28.getSecretKeyPRF()).withPublicSeed(r28.getPublicSeed()).withRoot(r28.getRoot());     // Catch: ClassNotFoundException -> L127
        if (r28.getVersion() == 0) goto L123;
        r29.withMaxIndex(r28.getMaxIndex());     // Catch: ClassNotFoundException -> L127
    L123:
        if (r28.getBdsState() == null) goto L125;
        r29.withBDSState(((BDSStateMap) ZeusTransformUtils.preCheckCast(XMSSUtil.deserialize(r28.getBdsState(), BDSStateMap.class), BDSStateMap.class, "com.obric.memorydata.plugin")).withWOTSDigest(r27));     // Catch: ClassNotFoundException -> L127
    L125:
        return r29.build();
    L127:
        e = move-exception;
        throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
    L131:
        if (r0.equals(PQCObjectIdentifiers.mcElieceCca2) == false) goto L135;
        McElieceCCA2PrivateKey r30 = McElieceCCA2PrivateKey.getInstance(r18.parsePrivateKey());
        return new McElieceCCA2PrivateKeyParameters(r30.getN(), r30.getK(), r30.getField(), r30.getGoppaPoly(), r30.getP(), Utils.getDigestName(r30.getDigest().getAlgorithm()));
    L135:
        throw new RuntimeException("algorithm identifier in private key not recognised");
    }
}
