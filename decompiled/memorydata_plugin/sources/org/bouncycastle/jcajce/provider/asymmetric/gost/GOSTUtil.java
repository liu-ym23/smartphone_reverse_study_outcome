package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
class GOSTUtil {
    private static String generateKeyFingerprint(BigInteger r2, GOST3410Parameters r3) {
        return new Fingerprint(Arrays.concatenate(r2.toByteArray(), r3.getP().toByteArray(), r3.getA().toByteArray())).toString();
    }

    static String privateKeyToString(String r4, BigInteger r5, GOST3410Parameters r6) {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        BigInteger r7 = r6.getA().modPow(r5, r6.getP());
        r0.append(r4);
        r0.append(" Private Key [").append(generateKeyFingerprint(r7, r6)).append("]").append(r1);
        r0.append("                  Y: ").append(r7.toString(16)).append(r1);
        return r0.toString();
    }

    static String publicKeyToString(String r2, BigInteger r3, GOST3410Parameters r4) {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append(r2);
        r0.append(" Public Key [").append(generateKeyFingerprint(r3, r4)).append("]").append(r1);
        r0.append("                 Y: ").append(r3.toString(16)).append(r1);
        return r0.toString();
    }
}
