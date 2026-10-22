package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
class CMSUtils {
    private static final Set<String> des = null;
    private static final Set ecAlgs = null;
    private static final Set gostAlgs = null;
    private static final Set mqvAlgs = null;

    static {
        HashSet r0 = new HashSet();
        des = r0;
        HashSet r1 = new HashSet();
        mqvAlgs = r1;
        HashSet r2 = new HashSet();
        ecAlgs = r2;
        HashSet r3 = new HashSet();
        gostAlgs = r3;
        r0.add("DES");
        r0.add("DESEDE");
        r0.add(OIWObjectIdentifiers.desCBC.getId());
        r0.add(PKCSObjectIdentifiers.des_EDE3_CBC.getId());
        r0.add(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId());
        r1.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
        r1.add(SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme);
        r1.add(SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme);
        r1.add(SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme);
        r1.add(SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme);
        r2.add(X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme);
        r2.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme);
        r2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme);
        r3.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH);
        r3.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_256);
        r3.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_512);
    }

    private static ContentInfo readContentInfo(ASN1InputStream r2) {
        ContentInfo r3 = ContentInfo.getInstance(r2.readObject());     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11 IOException -> L14
        if (r3 == null) goto L7;
        return r3;
    L7:
        throw new CMSException("No content found.");     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11 IOException -> L14
    L14:
        e = move-exception;
        throw new CMSException("IOException reading content.", e);
    L11:
        e = move-exception;
        throw new CMSException("Malformed content.", e);
    L8:
        e = move-exception;
        throw new CMSException("Malformed content.", e);
    }

    static ContentInfo readContentInfo(byte[] r1) {
        return readContentInfo(new ASN1InputStream(r1));
    }

    public static byte[] streamToByteArray(InputStream r0) {
        return Streams.readAll(r0);
    }
}
