package org.bouncycastle.pqc.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.CMCEPrivateKey;
import org.bouncycastle.pqc.asn1.CMCEPublicKey;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.asn1.XMSSKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTPrivateKey;
import org.bouncycastle.pqc.asn1.XMSSPrivateKey;
import org.bouncycastle.pqc.crypto.bike.BIKEPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.cmce.CMCEPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.hqc.HQCPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.Composer;
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
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSUtil;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.qtesla.QTESLAPrivateKeyParameters;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class PrivateKeyInfoFactory {
    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter r10, ASN1Set r11) {
        if (ZeusTransformUtils.instanceOf(r10, QTESLAPrivateKeyParameters.class) == false) goto L7;
        QTESLAPrivateKeyParameters r12 = (QTESLAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, QTESLAPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(Utils.qTeslaLookupAlgID(r12.getSecurityCategory()), new DEROctetString(r12.getSecret()), r11);
    L7:
        if (ZeusTransformUtils.instanceOf(r10, SPHINCSPrivateKeyParameters.class) == false) goto L11;
        SPHINCSPrivateKeyParameters r13 = (SPHINCSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, SPHINCSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(Utils.sphincs256LookupTreeAlgID(r13.getTreeDigest()))), new DEROctetString(r13.getKeyData()));
    L11:
        if (ZeusTransformUtils.instanceOf(r10, NHPrivateKeyParameters.class) == false) goto L19;
        NHPrivateKeyParameters r14 = (NHPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, NHPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        AlgorithmIdentifier r15 = new AlgorithmIdentifier(PQCObjectIdentifiers.newHope);
        short[] r16 = r14.getSecData();
        byte[] r0 = new byte[r16.length * 2];
        int r1 = 0;
    L14:
        if (r1 == r16.length) goto L17;
        Pack.shortToLittleEndian(r16[r1], r0, r1 * 2);
        r1 = r1 + 1;
        goto L14
    L17:
        return new PrivateKeyInfo(r15, new DEROctetString(r0));
    L19:
        if (ZeusTransformUtils.instanceOf(r10, LMSPrivateKeyParameters.class) == false) goto L23;
        LMSPrivateKeyParameters r17 = (LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r2 = Composer.compose().u32str(1).bytes(r17).build();
        byte[] r18 = Composer.compose().u32str(1).bytes(r17.getPublicKey()).build();
        return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), new DEROctetString(r2), r11, r18);
    L23:
        if (ZeusTransformUtils.instanceOf(r10, HSSPrivateKeyParameters.class) == false) goto L27;
        HSSPrivateKeyParameters r19 = (HSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, HSSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r3 = Composer.compose().u32str(r19.getL()).bytes(r19).build();
        byte[] r110 = Composer.compose().u32str(r19.getL()).bytes(r19.getPublicKey().getLMSPublicKey()).build();
        return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), new DEROctetString(r3), r11, r110);
    L27:
        if (ZeusTransformUtils.instanceOf(r10, SPHINCSPlusPrivateKeyParameters.class) == false) goto L31;
        SPHINCSPlusPrivateKeyParameters r111 = (SPHINCSPlusPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, SPHINCSPlusPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r4 = r111.getEncoded();
        byte[] r5 = r111.getEncodedPublicKey();
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.sphincsPlusOidLookup(r111.getParameters())), new DEROctetString(r4), r11, r5);
    L31:
        if (ZeusTransformUtils.instanceOf(r10, PicnicPrivateKeyParameters.class) == false) goto L35;
        PicnicPrivateKeyParameters r112 = (PicnicPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, PicnicPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r6 = r112.getEncoded();
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.picnicOidLookup(r112.getParameters())), new DEROctetString(r6), r11);
    L35:
        if (ZeusTransformUtils.instanceOf(r10, CMCEPrivateKeyParameters.class) == false) goto L39;
        CMCEPrivateKeyParameters r113 = (CMCEPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, CMCEPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        r113.getEncoded();
        AlgorithmIdentifier r7 = new AlgorithmIdentifier(Utils.mcElieceOidLookup(r113.getParameters()));
        CMCEPublicKey r9 = new CMCEPublicKey(r113.reconstructPublicKey());
        return new PrivateKeyInfo(r7, new CMCEPrivateKey(0, r113.getDelta(), r113.getC(), r113.getG(), r113.getAlpha(), r113.getS(), r9), r11);
    L39:
        if (ZeusTransformUtils.instanceOf(r10, XMSSPrivateKeyParameters.class) == false) goto L43;
        XMSSPrivateKeyParameters r114 = (XMSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, XMSSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss, new XMSSKeyParams(r114.getParameters().getHeight(), Utils.xmssLookupTreeAlgID(r114.getTreeDigest()))), xmssCreateKeyStructure(r114), r11);
    L43:
        if (ZeusTransformUtils.instanceOf(r10, XMSSMTPrivateKeyParameters.class) == false) goto L47;
        XMSSMTPrivateKeyParameters r115 = (XMSSMTPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, XMSSMTPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyParams(r115.getParameters().getHeight(), r115.getParameters().getLayers(), Utils.xmssLookupTreeAlgID(r115.getTreeDigest()))), xmssmtCreateKeyStructure(r115), r11);
    L47:
        if (ZeusTransformUtils.instanceOf(r10, McElieceCCA2PrivateKeyParameters.class) == false) goto L51;
        McElieceCCA2PrivateKeyParameters r116 = (McElieceCCA2PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, McElieceCCA2PrivateKeyParameters.class, "com.obric.memorydata.plugin");
        McElieceCCA2PrivateKey r117 = new McElieceCCA2PrivateKey(r116.getN(), r116.getK(), r116.getField(), r116.getGoppaPoly(), r116.getP(), Utils.getAlgorithmIdentifier(r116.getDigest()));
        return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2), r117);
    L51:
        if (ZeusTransformUtils.instanceOf(r10, FrodoPrivateKeyParameters.class) == false) goto L55;
        FrodoPrivateKeyParameters r118 = (FrodoPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, FrodoPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r8 = r118.getEncoded();
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.frodoOidLookup(r118.getParameters())), new DEROctetString(r8), r11);
    L55:
        if (ZeusTransformUtils.instanceOf(r10, SABERPrivateKeyParameters.class) == false) goto L59;
        SABERPrivateKeyParameters r119 = (SABERPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, SABERPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r20 = r119.getEncoded();
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.saberOidLookup(r119.getParameters())), new DEROctetString(r20), r11);
    L59:
        if (ZeusTransformUtils.instanceOf(r10, SIKEPrivateKeyParameters.class) == false) goto L63;
        SIKEPrivateKeyParameters r120 = (SIKEPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, SIKEPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r21 = r120.getEncoded();
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.sikeOidLookup(r120.getParameters())), new DEROctetString(r21), r11);
    L63:
        if (ZeusTransformUtils.instanceOf(r10, NTRUPrivateKeyParameters.class) == false) goto L67;
        NTRUPrivateKeyParameters r121 = (NTRUPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, NTRUPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r22 = r121.getEncoded();
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.ntruOidLookup(r121.getParameters())), new DEROctetString(r22), r11);
    L67:
        if (ZeusTransformUtils.instanceOf(r10, FalconPrivateKeyParameters.class) == false) goto L71;
        FalconPrivateKeyParameters r122 = (FalconPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, FalconPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ASN1EncodableVector r23 = new ASN1EncodableVector();
        r23.add(new ASN1Integer(1));
        r23.add(new DEROctetString(r122.getSpolyf()));
        r23.add(new DEROctetString(r122.getG()));
        r23.add(new DEROctetString(r122.getSpolyF()));
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.falconOidLookup(r122.getParameters())), new DERSequence(r23), r11, r122.getPublicKey());
    L71:
        if (ZeusTransformUtils.instanceOf(r10, KyberPrivateKeyParameters.class) == false) goto L75;
        KyberPrivateKeyParameters r123 = (KyberPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, KyberPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ASN1EncodableVector r24 = new ASN1EncodableVector();
        r24.add(new ASN1Integer(0));
        r24.add(new DEROctetString(r123.getS()));
        r24.add(new DEROctetString(r123.getHPK()));
        r24.add(new DEROctetString(r123.getNonce()));
        AlgorithmIdentifier r25 = new AlgorithmIdentifier(Utils.kyberOidLookup(r123.getParameters()));
        ASN1EncodableVector r26 = new ASN1EncodableVector();
        r26.add(new DEROctetString(r123.getT()));
        r26.add(new DEROctetString(r123.getRho()));
        return new PrivateKeyInfo(r25, new DERSequence(r24), r11, new DERSequence(r26).getEncoded());
    L75:
        if (ZeusTransformUtils.instanceOf(r10, NTRULPRimePrivateKeyParameters.class) == false) goto L79;
        NTRULPRimePrivateKeyParameters r124 = (NTRULPRimePrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, NTRULPRimePrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ASN1EncodableVector r27 = new ASN1EncodableVector();
        r27.add(new DEROctetString(r124.getEnca()));
        r27.add(new DEROctetString(r124.getPk()));
        r27.add(new DEROctetString(r124.getRho()));
        r27.add(new DEROctetString(r124.getHash()));
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.ntrulprimeOidLookup(r124.getParameters())), new DERSequence(r27), r11);
    L79:
        if (ZeusTransformUtils.instanceOf(r10, SNTRUPrimePrivateKeyParameters.class) == false) goto L83;
        SNTRUPrimePrivateKeyParameters r125 = (SNTRUPrimePrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, SNTRUPrimePrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ASN1EncodableVector r28 = new ASN1EncodableVector();
        r28.add(new DEROctetString(r125.getF()));
        r28.add(new DEROctetString(r125.getGinv()));
        r28.add(new DEROctetString(r125.getPk()));
        r28.add(new DEROctetString(r125.getRho()));
        r28.add(new DEROctetString(r125.getHash()));
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.sntruprimeOidLookup(r125.getParameters())), new DERSequence(r28), r11);
    L83:
        if (ZeusTransformUtils.instanceOf(r10, DilithiumPrivateKeyParameters.class) == false) goto L87;
        DilithiumPrivateKeyParameters r126 = (DilithiumPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, DilithiumPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ASN1EncodableVector r29 = new ASN1EncodableVector();
        r29.add(new ASN1Integer(0));
        r29.add(new DERBitString(r126.getRho()));
        r29.add(new DERBitString(r126.getK()));
        r29.add(new DERBitString(r126.getTr()));
        r29.add(new DERBitString(r126.getS1()));
        r29.add(new DERBitString(r126.getS2()));
        r29.add(new DERBitString(r126.getT0()));
        AlgorithmIdentifier r30 = new AlgorithmIdentifier(Utils.dilithiumOidLookup(r126.getParameters()));
        ASN1EncodableVector r31 = new ASN1EncodableVector();
        r31.add(new DEROctetString(r126.getRho()));
        r31.add(new DEROctetString(r126.getT1()));
        return new PrivateKeyInfo(r30, new DERSequence(r29), r11, new DERSequence(r31).getEncoded());
    L87:
        if (ZeusTransformUtils.instanceOf(r10, BIKEPrivateKeyParameters.class) == false) goto L91;
        BIKEPrivateKeyParameters r127 = (BIKEPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, BIKEPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.bikeOidLookup(r127.getParameters())), new DEROctetString(r127.getEncoded()), r11);
    L91:
        if (ZeusTransformUtils.instanceOf(r10, HQCPrivateKeyParameters.class) == false) goto L95;
        HQCPrivateKeyParameters r128 = (HQCPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r10, HQCPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(Utils.hqcOidLookup(r128.getParameters())), new DEROctetString(r128.getPrivateKey()), r11);
    L95:
        throw new IOException("key parameters not recognized");
    }

    private static XMSSPrivateKey xmssCreateKeyStructure(XMSSPrivateKeyParameters r14) {
        byte[] r0 = r14.getEncoded();
        int r1 = r14.getParameters().getTreeDigestSize();
        int r15 = r14.getParameters().getHeight();
        int r7 = (int) XMSSUtil.bytesToXBigEndian(r0, 0, 4);
        if (XMSSUtil.isIndexValid(r15, r7) == false) goto L16;
        byte[] r8 = XMSSUtil.extractBytesAtOffset(r0, 4, r1);
        int r3 = 4 + r1;
        byte[] r9 = XMSSUtil.extractBytesAtOffset(r0, r3, r1);
        int r4 = r3 + r1;
        byte[] r10 = XMSSUtil.extractBytesAtOffset(r0, r4, r1);
        int r5 = r4 + r1;
        byte[] r11 = XMSSUtil.extractBytesAtOffset(r0, r5, r1);
        int r6 = r5 + r1;
        byte[] r12 = XMSSUtil.extractBytesAtOffset(r0, r6, r0.length - r6);
        BDS r2 = (BDS) ZeusTransformUtils.preCheckCast(XMSSUtil.deserialize(r12, BDS.class), BDS.class, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L12
        if (r2.getMaxIndex() == ((1 << r15) - 1)) goto L11;
        return new XMSSPrivateKey(r7, r8, r9, r10, r11, r12, r2.getMaxIndex());
    L11:
        return new XMSSPrivateKey(r7, r8, r9, r10, r11, r12);
    L12:
        e = move-exception;
        throw new IOException("cannot parse BDS: " + e.getMessage());
    L16:
        throw new IllegalArgumentException("index out of bounds");
    }

    private static XMSSMTPrivateKey xmssmtCreateKeyStructure(XMSSMTPrivateKeyParameters r15) {
        byte[] r0 = r15.getEncoded();
        int r1 = r15.getParameters().getTreeDigestSize();
        int r16 = r15.getParameters().getHeight();
        int r2 = (r16 + 7) / 8;
        long r6 = (int) XMSSUtil.bytesToXBigEndian(r0, 0, r2);
        if (XMSSUtil.isIndexValid(r16, r6) == false) goto L16;
        int r3 = r2 + 0;
        byte[] r8 = XMSSUtil.extractBytesAtOffset(r0, r3, r1);
        int r4 = r3 + r1;
        byte[] r9 = XMSSUtil.extractBytesAtOffset(r0, r4, r1);
        int r5 = r4 + r1;
        byte[] r10 = XMSSUtil.extractBytesAtOffset(r0, r5, r1);
        int r7 = r5 + r1;
        byte[] r11 = XMSSUtil.extractBytesAtOffset(r0, r7, r1);
        int r12 = r7 + r1;
        byte[] r13 = XMSSUtil.extractBytesAtOffset(r0, r12, r0.length - r12);
        BDSStateMap r14 = (BDSStateMap) ZeusTransformUtils.preCheckCast(XMSSUtil.deserialize(r13, BDSStateMap.class), BDSStateMap.class, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L12
        if (r14.getMaxIndex() == ((1 << r16) - 1)) goto L11;
        return new XMSSMTPrivateKey(r6, r8, r9, r10, r11, r13, r14.getMaxIndex());
    L11:
        return new XMSSMTPrivateKey(r6, r8, r9, r10, r11, r13);
    L12:
        e = move-exception;
        throw new IOException("cannot parse BDSStateMap: " + e.getMessage());
    L16:
        throw new IllegalArgumentException("index out of bounds");
    }
}
