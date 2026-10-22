package org.bouncycastle.crypto.prng;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class EntropyUtil {
    public static byte[] generateSeed(EntropySource r7, int r8) {
        EntropySource r9 = (EntropySource) ZeusTransformUtils.wrapperContextForParams(r7, EntropySource.class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[r8];
        if ((r8 * 8) > r9.entropySize()) goto L5;
        System.arraycopy(r9.getEntropy(), 0, r0, 0, r8);
    L12:
        return r0;
    L5:
        int r1 = r9.entropySize() / 8;
        int r2 = 0;
    L6:
        if (r2 >= r8) goto L12;
        byte[] r4 = r9.getEntropy();
        int r6 = r8 - r2;
        if (r4.length > r6) goto L10;
        System.arraycopy(r4, 0, r0, r2, r4.length);
    L11:
        r2 = r2 + r1;
        goto L6
    L10:
        System.arraycopy(r4, 0, r0, r2, r6);
        goto L11
    }
}
