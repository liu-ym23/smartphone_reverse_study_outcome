package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes7.dex */
class LmsUtils {
    static void byteArray(byte[] r2, Digest r3) {
        ((Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin")).update(r2, 0, r2.length);
    }

    static void u16str(short r2, Digest r3) {
        Digest r4 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        r4.update((byte) (r2 >>> 8));
        r4.update((byte) r2);
    }

    static void u32str(int r2, Digest r3) {
        Digest r4 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        r4.update((byte) (r2 >>> 24));
        r4.update((byte) (r2 >>> 16));
        r4.update((byte) (r2 >>> 8));
        r4.update((byte) r2);
    }
}
