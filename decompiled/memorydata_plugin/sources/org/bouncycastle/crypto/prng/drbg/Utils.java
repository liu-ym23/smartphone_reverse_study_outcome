package org.bouncycastle.crypto.prng.drbg;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    static final Hashtable maxSecurityStrengths = null;

    static {
        Hashtable r0 = new Hashtable();
        maxSecurityStrengths = r0;
        r0.put("SHA-1", Integers.valueOf(128));
        r0.put("SHA-224", Integers.valueOf(192));
        r0.put(CryptoConst.ALGORITHM_SHA256, Integers.valueOf(256));
        r0.put("SHA-384", Integers.valueOf(256));
        r0.put("SHA-512", Integers.valueOf(256));
        r0.put("SHA-512/224", Integers.valueOf(192));
        r0.put("SHA-512/256", Integers.valueOf(256));
    }

    static int getMaxSecurityStrength(Digest r2) {
        Digest r3 = (Digest) ZeusTransformUtils.wrapperContextForParams(r2, Digest.class, "com.obric.memorydata.plugin");
        return ((Integer) ZeusTransformUtils.preCheckCast(maxSecurityStrengths.get(r3.getAlgorithmName()), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    static int getMaxSecurityStrength(Mac r4) {
        String r5 = ((Mac) ZeusTransformUtils.wrapperContextForParams(r4, Mac.class, "com.obric.memorydata.plugin")).getAlgorithmName();
        return ((Integer) ZeusTransformUtils.preCheckCast(maxSecurityStrengths.get(r5.substring(0, r5.indexOf("/"))), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    static byte[] hash_df(Digest r10, byte[] r11, int r12) {
        Digest r13 = (Digest) ZeusTransformUtils.wrapperContextForParams(r10, Digest.class, "com.obric.memorydata.plugin");
        int r0 = (r12 + 7) / 8;
        byte[] r1 = new byte[r0];
        int r2 = r0 / r13.getDigestSize();
        int r3 = r13.getDigestSize();
        byte[] r4 = new byte[r3];
        int r5 = 1;
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r7 > r2) goto L8;
        r13.update((byte) r5);
        r13.update((byte) (r12 >> 24));
        r13.update((byte) (r12 >> 16));
        r13.update((byte) (r12 >> 8));
        r13.update((byte) r12);
        r13.update(r11, 0, r11.length);
        r13.doFinal(r4, 0);
        int r8 = r7 * r3;
        int r9 = r0 - r8;
        if (r9 <= r3) goto L7;
        r9 = r3;
    L7:
        System.arraycopy(r4, 0, r1, r8, r9);
        r5 = r5 + 1;
        r7 = r7 + 1;
        goto L3
    L8:
        int r14 = r12 % 8;
        if (r14 == 0) goto L13;
        int r15 = 8 - r14;
        int r16 = 0;
    L11:
        if (r6 == r0) goto L13;
        int r17 = r1[r6] & 255;
        r1[r6] = (byte) ((r16 << (8 - r15)) | (r17 >>> r15));
        r6 = r6 + 1;
        r16 = r17;
    L13:
        return r1;
    }
}
