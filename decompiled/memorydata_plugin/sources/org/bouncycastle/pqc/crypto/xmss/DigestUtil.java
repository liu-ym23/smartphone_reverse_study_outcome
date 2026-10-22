package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes7.dex */
class DigestUtil {
    private static Map<String, ASN1ObjectIdentifier> nameToOid;
    private static Map<ASN1ObjectIdentifier, String> oidToName;

    static {
        nameToOid = new HashMap();
        oidToName = new HashMap();
        nameToOid.put(CryptoConst.ALGORITHM_SHA256, NISTObjectIdentifiers.id_sha256);
        nameToOid.put("SHA-512", NISTObjectIdentifiers.id_sha512);
        nameToOid.put("SHAKE128", NISTObjectIdentifiers.id_shake128);
        nameToOid.put("SHAKE256", NISTObjectIdentifiers.id_shake256);
        oidToName.put(NISTObjectIdentifiers.id_sha256, CryptoConst.ALGORITHM_SHA256);
        oidToName.put(NISTObjectIdentifiers.id_sha512, "SHA-512");
        oidToName.put(NISTObjectIdentifiers.id_shake128, "SHAKE128");
        oidToName.put(NISTObjectIdentifiers.id_shake256, "SHAKE256");
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

    static String getDigestName(ASN1ObjectIdentifier r3) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(oidToName.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("unrecognized digest oid: " + r3);
    }

    static ASN1ObjectIdentifier getDigestOID(String r3) {
        ASN1ObjectIdentifier r0 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(nameToOid.get(r3), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("unrecognized digest name: " + r3);
    }
}
