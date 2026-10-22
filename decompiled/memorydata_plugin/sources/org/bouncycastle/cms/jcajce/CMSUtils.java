package org.bouncycastle.cms.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.jcajce.util.AlgorithmParametersUtils;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes7.dex */
class CMSUtils {
    private static final Set ecAlgs = null;
    private static final Set gostAlgs = null;
    private static final Set mqvAlgs = null;

    static {
        HashSet r0 = new HashSet();
        mqvAlgs = r0;
        HashSet r1 = new HashSet();
        ecAlgs = r1;
        HashSet r2 = new HashSet();
        gostAlgs = r2;
        r0.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
        r0.add(SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme);
        r0.add(SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme);
        r0.add(SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme);
        r0.add(SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme);
        r1.add(X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme);
        r1.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme);
        r1.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme);
        r2.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH);
        r2.add(CryptoProObjectIdentifiers.gostR3410_2001);
        r2.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_256);
        r2.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_512);
        r2.add(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256);
        r2.add(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512);
    }

    static PrivateKey cleanPrivateKey(PrivateKey r2) {
        PrivateKey r3 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r2, PrivateKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AnnotatedPrivateKey.class) == true) goto L5;
        return r3;
    L5:
        return cleanPrivateKey(((AnnotatedPrivateKey) ZeusTransformUtils.preCheckCast(r3, AnnotatedPrivateKey.class, "com.obric.memorydata.plugin")).getKey());
    }

    static boolean isGOST(ASN1ObjectIdentifier r1) {
        return gostAlgs.contains(r1);
    }

    static void loadParameters(AlgorithmParameters r2, ASN1Encodable r3) {
        AlgorithmParametersUtils.loadParameters(r2, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new CMSException("error encoding algorithm parameters.", e);
    }
}
