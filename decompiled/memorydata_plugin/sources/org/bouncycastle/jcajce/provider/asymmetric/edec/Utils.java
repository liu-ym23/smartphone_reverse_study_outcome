package org.bouncycastle.jcajce.provider.asymmetric.edec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    private static String generateKeyFingerprint(byte[] r1) {
        return new Fingerprint(r1).toString();
    }

    static boolean isValidPrefix(byte[] r6, byte[] r7) {
        if (r7.length < r6.length) goto L5;
        int r1 = 0;
        int r3 = 0;
    L8:
        if (r1 == r6.length) goto L10;
        r3 = r3 | (r6[r1] ^ r7[r1]);
        r1 = r1 + 1;
        goto L8
    L10:
        if (r3 != 0) goto L13;
        return true;
    L13:
        return false;
    L5:
        return !isValidPrefix(r6, r6);
    }

    static String keyToString(String r4, String r5, AsymmetricKeyParameter r6) {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        if (ZeusTransformUtils.instanceOf(r6, X448PublicKeyParameters.class) == false) goto L6;
        byte[] r7 = ((X448PublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, X448PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
    L12:
        r0.append(r5).append(" ").append(r4).append(" [").append(generateKeyFingerprint(r7)).append("]").append(r1).append("    public data: ").append(Hex.toHexString(r7)).append(r1);
        return r0.toString();
    L6:
        if (ZeusTransformUtils.instanceOf(r6, Ed448PublicKeyParameters.class) == false) goto L9;
        r7 = ((Ed448PublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, Ed448PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(r6, X25519PublicKeyParameters.class) == false) goto L11;
        r7 = ((X25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, X25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
        goto L12
    L11:
        r7 = ((Ed25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, Ed25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
        goto L12
    }
}
