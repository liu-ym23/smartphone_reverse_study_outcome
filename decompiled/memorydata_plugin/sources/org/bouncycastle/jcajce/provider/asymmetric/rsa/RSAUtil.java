package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.util.Fingerprint;

/* JADX INFO: loaded from: classes7.dex */
public class RSAUtil {
    public static final ASN1ObjectIdentifier[] rsaOids = null;

    static {
        rsaOids = new ASN1ObjectIdentifier[]{PKCSObjectIdentifiers.rsaEncryption, X509ObjectIdentifiers.id_ea_rsa, PKCSObjectIdentifiers.id_RSAES_OAEP, PKCSObjectIdentifiers.id_RSASSA_PSS};
    }

    static String generateExponentFingerprint(BigInteger r2) {
        return new Fingerprint(r2.toByteArray(), 32).toString();
    }

    static String generateKeyFingerprint(BigInteger r1) {
        return new Fingerprint(r1.toByteArray()).toString();
    }
}
