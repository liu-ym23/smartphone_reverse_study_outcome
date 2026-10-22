package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.util.DigestFactory;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    static Digest getDigest(AlgorithmIdentifier r3) {
        if (r3.getAlgorithm().equals(OIWObjectIdentifiers.idSHA1) == false) goto L7;
        return DigestFactory.createSHA1();
    L7:
        if (r3.getAlgorithm().equals(NISTObjectIdentifiers.id_sha224) == false) goto L11;
        return DigestFactory.createSHA224();
    L11:
        if (r3.getAlgorithm().equals(NISTObjectIdentifiers.id_sha256) == false) goto L15;
        return DigestFactory.createSHA256();
    L15:
        if (r3.getAlgorithm().equals(NISTObjectIdentifiers.id_sha384) == false) goto L19;
        return DigestFactory.createSHA384();
    L19:
        if (r3.getAlgorithm().equals(NISTObjectIdentifiers.id_sha512) == false) goto L23;
        return DigestFactory.createSHA512();
    L23:
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + r3.getAlgorithm());
    }
}
