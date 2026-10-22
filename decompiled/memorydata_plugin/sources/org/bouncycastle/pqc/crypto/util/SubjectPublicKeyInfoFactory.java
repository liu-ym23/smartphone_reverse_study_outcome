package org.bouncycastle.pqc.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
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
import org.bouncycastle.pqc.asn1.XMSSMTPublicKey;
import org.bouncycastle.pqc.asn1.XMSSPublicKey;
import org.bouncycastle.pqc.crypto.bike.BIKEPublicKeyParameters;
import org.bouncycastle.pqc.crypto.cmce.CMCEPublicKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumPublicKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberPublicKeyParameters;
import org.bouncycastle.pqc.crypto.falcon.FalconPublicKeyParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoPublicKeyParameters;
import org.bouncycastle.pqc.crypto.hqc.HQCPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.Composer;
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
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.qtesla.QTESLAPublicKeyParameters;

/* JADX INFO: loaded from: classes7.dex */
public class SubjectPublicKeyInfoFactory {
    public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter r6) {
        if (ZeusTransformUtils.instanceOf(r6, QTESLAPublicKeyParameters.class) == false) goto L7;
        QTESLAPublicKeyParameters r7 = (QTESLAPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, QTESLAPublicKeyParameters.class, "com.obric.memorydata.plugin");
        return new SubjectPublicKeyInfo(Utils.qTeslaLookupAlgID(r7.getSecurityCategory()), r7.getPublicData());
    L7:
        if (ZeusTransformUtils.instanceOf(r6, SPHINCSPublicKeyParameters.class) == false) goto L11;
        SPHINCSPublicKeyParameters r8 = (SPHINCSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, SPHINCSPublicKeyParameters.class, "com.obric.memorydata.plugin");
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(Utils.sphincs256LookupTreeAlgID(r8.getTreeDigest()))), r8.getKeyData());
    L11:
        if (ZeusTransformUtils.instanceOf(r6, NHPublicKeyParameters.class) == false) goto L15;
        NHPublicKeyParameters r9 = (NHPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, NHPublicKeyParameters.class, "com.obric.memorydata.plugin");
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.newHope), r9.getPubData());
    L15:
        if (ZeusTransformUtils.instanceOf(r6, LMSPublicKeyParameters.class) == false) goto L19;
        LMSPublicKeyParameters r10 = (LMSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, LMSPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r11 = Composer.compose().u32str(1).bytes(r10).build();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), new DEROctetString(r11));
    L19:
        if (ZeusTransformUtils.instanceOf(r6, HSSPublicKeyParameters.class) == false) goto L23;
        HSSPublicKeyParameters r12 = (HSSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, HSSPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r13 = Composer.compose().u32str(r12.getL()).bytes(r12.getLMSPublicKey()).build();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), new DEROctetString(r13));
    L23:
        if (ZeusTransformUtils.instanceOf(r6, SPHINCSPlusPublicKeyParameters.class) == false) goto L27;
        SPHINCSPlusPublicKeyParameters r14 = (SPHINCSPlusPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, SPHINCSPlusPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r0 = r14.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.sphincsPlusOidLookup(r14.getParameters())), new DEROctetString(r0));
    L27:
        if (ZeusTransformUtils.instanceOf(r6, CMCEPublicKeyParameters.class) == false) goto L31;
        CMCEPublicKeyParameters r15 = (CMCEPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, CMCEPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r1 = r15.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.mcElieceOidLookup(r15.getParameters())), new CMCEPublicKey(r1));
    L31:
        if (ZeusTransformUtils.instanceOf(r6, XMSSPublicKeyParameters.class) == false) goto L39;
        XMSSPublicKeyParameters r16 = (XMSSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, XMSSPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r2 = r16.getPublicSeed();
        byte[] r3 = r16.getRoot();
        byte[] r4 = r16.getEncoded();
        if (r4.length <= (r2.length + r3.length)) goto L37;
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmss), new DEROctetString(r4));
    L37:
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss, new XMSSKeyParams(r16.getParameters().getHeight(), Utils.xmssLookupTreeAlgID(r16.getTreeDigest()))), new XMSSPublicKey(r2, r3));
    L39:
        if (ZeusTransformUtils.instanceOf(r6, XMSSMTPublicKeyParameters.class) == false) goto L47;
        XMSSMTPublicKeyParameters r17 = (XMSSMTPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, XMSSMTPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r5 = r17.getPublicSeed();
        byte[] r18 = r17.getRoot();
        byte[] r19 = r17.getEncoded();
        if (r19.length <= (r5.length + r18.length)) goto L45;
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmssmt), new DEROctetString(r19));
    L45:
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyParams(r17.getParameters().getHeight(), r17.getParameters().getLayers(), Utils.xmssLookupTreeAlgID(r17.getTreeDigest()))), new XMSSMTPublicKey(r17.getPublicSeed(), r17.getRoot()));
    L47:
        if (ZeusTransformUtils.instanceOf(r6, McElieceCCA2PublicKeyParameters.class) == false) goto L51;
        McElieceCCA2PublicKeyParameters r20 = (McElieceCCA2PublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, McElieceCCA2PublicKeyParameters.class, "com.obric.memorydata.plugin");
        McElieceCCA2PublicKey r21 = new McElieceCCA2PublicKey(r20.getN(), r20.getT(), r20.getG(), Utils.getAlgorithmIdentifier(r20.getDigest()));
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2), r21);
    L51:
        if (ZeusTransformUtils.instanceOf(r6, FrodoPublicKeyParameters.class) == false) goto L55;
        FrodoPublicKeyParameters r22 = (FrodoPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, FrodoPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r23 = r22.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.frodoOidLookup(r22.getParameters())), new DEROctetString(r23));
    L55:
        if (ZeusTransformUtils.instanceOf(r6, SABERPublicKeyParameters.class) == false) goto L59;
        SABERPublicKeyParameters r24 = (SABERPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, SABERPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r25 = r24.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.saberOidLookup(r24.getParameters())), new DERSequence(new DEROctetString(r25)));
    L59:
        if (ZeusTransformUtils.instanceOf(r6, PicnicPublicKeyParameters.class) == false) goto L63;
        PicnicPublicKeyParameters r26 = (PicnicPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, PicnicPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r27 = r26.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.picnicOidLookup(r26.getParameters())), new DEROctetString(r27));
    L63:
        if (ZeusTransformUtils.instanceOf(r6, SIKEPublicKeyParameters.class) == false) goto L67;
        SIKEPublicKeyParameters r28 = (SIKEPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, SIKEPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r29 = r28.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.sikeOidLookup(r28.getParameters())), new DEROctetString(r29));
    L67:
        if (ZeusTransformUtils.instanceOf(r6, NTRUPublicKeyParameters.class) == false) goto L71;
        NTRUPublicKeyParameters r30 = (NTRUPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, NTRUPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r31 = r30.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.ntruOidLookup(r30.getParameters())), new DEROctetString(r31));
    L71:
        if (ZeusTransformUtils.instanceOf(r6, FalconPublicKeyParameters.class) == false) goto L75;
        FalconPublicKeyParameters r32 = (FalconPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, FalconPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r33 = r32.getH();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.falconOidLookup(r32.getParameters())), new DERSequence(new DEROctetString(r33)));
    L75:
        if (ZeusTransformUtils.instanceOf(r6, KyberPublicKeyParameters.class) == false) goto L79;
        KyberPublicKeyParameters r34 = (KyberPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, KyberPublicKeyParameters.class, "com.obric.memorydata.plugin");
        AlgorithmIdentifier r35 = new AlgorithmIdentifier(Utils.kyberOidLookup(r34.getParameters()));
        ASN1EncodableVector r36 = new ASN1EncodableVector();
        r36.add(new DEROctetString(r34.getT()));
        r36.add(new DEROctetString(r34.getRho()));
        return new SubjectPublicKeyInfo(r35, new DERSequence(r36));
    L79:
        if (ZeusTransformUtils.instanceOf(r6, NTRULPRimePublicKeyParameters.class) == false) goto L83;
        NTRULPRimePublicKeyParameters r37 = (NTRULPRimePublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, NTRULPRimePublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r38 = r37.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.ntrulprimeOidLookup(r37.getParameters())), new DEROctetString(r38));
    L83:
        if (ZeusTransformUtils.instanceOf(r6, SNTRUPrimePublicKeyParameters.class) == false) goto L87;
        SNTRUPrimePublicKeyParameters r39 = (SNTRUPrimePublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, SNTRUPrimePublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r40 = r39.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.sntruprimeOidLookup(r39.getParameters())), new DEROctetString(r40));
    L87:
        if (ZeusTransformUtils.instanceOf(r6, DilithiumPublicKeyParameters.class) == false) goto L91;
        DilithiumPublicKeyParameters r41 = (DilithiumPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, DilithiumPublicKeyParameters.class, "com.obric.memorydata.plugin");
        AlgorithmIdentifier r42 = new AlgorithmIdentifier(Utils.dilithiumOidLookup(r41.getParameters()));
        ASN1EncodableVector r43 = new ASN1EncodableVector();
        r43.add(new DEROctetString(r41.getRho()));
        r43.add(new DEROctetString(r41.getT1()));
        return new SubjectPublicKeyInfo(r42, new DERSequence(r43));
    L91:
        if (ZeusTransformUtils.instanceOf(r6, BIKEPublicKeyParameters.class) == false) goto L95;
        BIKEPublicKeyParameters r44 = (BIKEPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, BIKEPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r45 = r44.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.bikeOidLookup(r44.getParameters())), new DEROctetString(r45));
    L95:
        if (ZeusTransformUtils.instanceOf(r6, HQCPublicKeyParameters.class) == false) goto L99;
        HQCPublicKeyParameters r46 = (HQCPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, HQCPublicKeyParameters.class, "com.obric.memorydata.plugin");
        byte[] r47 = r46.getEncoded();
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(Utils.hqcOidLookup(r46.getParameters())), new DEROctetString(r47));
    L99:
        throw new IOException("key parameters not recognized");
    }
}
