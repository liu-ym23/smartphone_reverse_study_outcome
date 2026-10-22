package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;

/* JADX INFO: loaded from: classes7.dex */
public class DSAUtil {
    public static final ASN1ObjectIdentifier[] dsaOids = null;

    static {
        dsaOids = new ASN1ObjectIdentifier[]{X9ObjectIdentifiers.id_dsa, OIWObjectIdentifiers.dsaWithSHA1, X9ObjectIdentifiers.id_dsa_with_sha1};
    }

    static String generateKeyFingerprint(BigInteger r3, DSAParams r4) {
        DSAParams r5 = (DSAParams) ZeusTransformUtils.wrapperContextForParams(r4, DSAParams.class, "com.obric.memorydata.plugin");
        return new Fingerprint(Arrays.concatenate(r3.toByteArray(), r5.getP().toByteArray(), r5.getQ().toByteArray(), r5.getG().toByteArray())).toString();
    }

    public static boolean isDsaOid(ASN1ObjectIdentifier r4) {
        int r1 = 0;
    L3:
        ASN1ObjectIdentifier[] r2 = dsaOids;
        if (r1 == r2.length) goto L10;
        if (r4.equals(r2[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    static DSAParameters toDSAParameters(DSAParams r3) {
        DSAParams r4 = (DSAParams) ZeusTransformUtils.wrapperContextForParams(r3, DSAParams.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        return new DSAParameters(r4.getP(), r4.getQ(), r4.getG());
    }
}
