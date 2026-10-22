package org.bouncycastle.pqc.jcajce.provider.xmss;

import com.bytedance.crypto.utils.CryptoConst;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
class DigestUtil {
    static ASN1ObjectIdentifier getDigestOID(String r3) {
        if (r3.equals(CryptoConst.ALGORITHM_SHA256) == false) goto L7;
        return NISTObjectIdentifiers.id_sha256;
    L7:
        if (r3.equals("SHA-512") == false) goto L11;
        return NISTObjectIdentifiers.id_sha512;
    L11:
        if (r3.equals("SHAKE128") == false) goto L15;
        return NISTObjectIdentifiers.id_shake128;
    L15:
        if (r3.equals("SHAKE256") == false) goto L19;
        return NISTObjectIdentifiers.id_shake256;
    L19:
        throw new IllegalArgumentException("unrecognized digest: " + r3);
    }

    public static String getXMSSDigestName(ASN1ObjectIdentifier r3) {
        if (r3.equals(NISTObjectIdentifiers.id_sha256) == false) goto L7;
        return "SHA256";
    L7:
        if (r3.equals(NISTObjectIdentifiers.id_sha512) == false) goto L11;
        return "SHA512";
    L11:
        if (r3.equals(NISTObjectIdentifiers.id_shake128) == false) goto L15;
        return "SHAKE128";
    L15:
        if (r3.equals(NISTObjectIdentifiers.id_shake256) == false) goto L19;
        return "SHAKE256";
    L19:
        throw new IllegalArgumentException("unrecognized digest OID: " + r3);
    }
}
