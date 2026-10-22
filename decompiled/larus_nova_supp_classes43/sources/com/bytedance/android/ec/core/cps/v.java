package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.crypto.digests.SM3Digest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v implements k {
    public static final v a = null;

    public v() {
    }

    static {
        a = new v();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        byte[] r11 = r10.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L5
        SM3Digest r0 = new SM3Digest();     // Catch: Throwable -> L5
        r0.update(r11, 0, r11.length);     // Catch: Throwable -> L5
        byte[] r12 = new byte[r0.getDigestSize()];     // Catch: Throwable -> L5
        r0.doFinal(r12, 0);     // Catch: Throwable -> L5
        return j.d(r12);
    L5:
        return null;
    }
}
