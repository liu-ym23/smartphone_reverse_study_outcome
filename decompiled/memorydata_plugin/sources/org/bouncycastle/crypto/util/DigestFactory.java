package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes7.dex */
public final class DigestFactory {
    private static final Map cloneMap = null;

    static {
        HashMap r0 = new HashMap();
        cloneMap = r0;
        r0.put(createMD5().getAlgorithmName(), new AnonymousClass1());
        r0.put(createSHA1().getAlgorithmName(), new AnonymousClass2());
        r0.put(createSHA224().getAlgorithmName(), new AnonymousClass3());
        r0.put(createSHA256().getAlgorithmName(), new AnonymousClass4());
        r0.put(createSHA384().getAlgorithmName(), new AnonymousClass5());
        r0.put(createSHA512().getAlgorithmName(), new AnonymousClass6());
        r0.put(createSHA3_224().getAlgorithmName(), new AnonymousClass7());
        r0.put(createSHA3_256().getAlgorithmName(), new AnonymousClass8());
        r0.put(createSHA3_384().getAlgorithmName(), new AnonymousClass9());
        r0.put(createSHA3_512().getAlgorithmName(), new AnonymousClass10());
        r0.put(createSHAKE128().getAlgorithmName(), new AnonymousClass11());
        r0.put(createSHAKE256().getAlgorithmName(), new AnonymousClass12());
    }

    public static Digest createMD5() {
        return new MD5Digest();
    }

    public static Digest createMD5PRF() {
        return new MD5Digest();
    }

    public static Digest createSHA1() {
        return new SHA1Digest();
    }

    public static Digest createSHA1PRF() {
        return new SHA1Digest(CryptoServicePurpose.PRF);
    }

    public static Digest createSHA224() {
        return new SHA224Digest();
    }

    public static Digest createSHA224PRF() {
        return new SHA224Digest(CryptoServicePurpose.PRF);
    }

    public static Digest createSHA256() {
        return new SHA256Digest();
    }

    public static Digest createSHA256PRF() {
        return new SHA256Digest(CryptoServicePurpose.PRF);
    }

    public static Digest createSHA384() {
        return new SHA384Digest();
    }

    public static Digest createSHA384PRF() {
        return new SHA384Digest(CryptoServicePurpose.PRF);
    }

    public static Digest createSHA3_224() {
        return new SHA3Digest(224);
    }

    public static Digest createSHA3_224PRF() {
        return new SHA3Digest(224, CryptoServicePurpose.PRF);
    }

    public static Digest createSHA3_256() {
        return new SHA3Digest(256);
    }

    public static Digest createSHA3_256PRF() {
        return new SHA3Digest(256, CryptoServicePurpose.PRF);
    }

    public static Digest createSHA3_384() {
        return new SHA3Digest(384);
    }

    public static Digest createSHA3_384PRF() {
        return new SHA3Digest(384, CryptoServicePurpose.PRF);
    }

    public static Digest createSHA3_512() {
        return new SHA3Digest(512);
    }

    public static Digest createSHA3_512PRF() {
        return new SHA3Digest(512, CryptoServicePurpose.PRF);
    }

    public static Digest createSHA512() {
        return new SHA512Digest();
    }

    public static Digest createSHA512PRF() {
        return new SHA512Digest(CryptoServicePurpose.PRF);
    }

    public static Digest createSHAKE128() {
        return new SHAKEDigest(128);
    }

    public static Digest createSHAKE256() {
        return new SHAKEDigest(256);
    }
}
