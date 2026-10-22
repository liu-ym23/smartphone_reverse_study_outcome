package com.google.common.hash;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
abstract class b implements f {
    b() {
    }

    public HashCode hashBytes(ByteBuffer r2) {
        return newHasher(r2.remaining()).a(r2).a();
    }

    public HashCode hashBytes(byte[] r3) {
        return hashBytes(r3, 0, r3.length);
    }

    public HashCode hashBytes(byte[] r3, int r4, int r5) {
        n.a(r4, r4 + r5, r3.length);
        return newHasher(r5).a(r3, r4, r5).a();
    }

    public HashCode hashInt(int r2) {
        return newHasher(4).a(r2).a();
    }

    public HashCode hashLong(long r2) {
        return newHasher(8).a(r2).a();
    }

    @Override // com.google.common.hash.f
    public <T> HashCode hashObject(T r3, Funnel<? super T> r4) {
        Funnel<? super T> r5 = (Funnel) ZeusTransformUtils.wrapperContextForParams(r4, Funnel.class, "com.obric.memorydata.plugin");
        return newHasher().a(r3, r5).a();
    }

    public HashCode hashString(CharSequence r3, Charset r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return newHasher().a(r5, r4).a();
    }

    public HashCode hashUnencodedChars(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return newHasher(r4.length() * 2).a(r4).a();
    }

    public g newHasher(int r3) {
        if (r3 < 0) goto L4;
        boolean r0 = true;
    L5:
        n.a(r0, "expectedInputSize must be >= 0 but was %s", r3);
        return newHasher();
    L4:
        r0 = false;
        goto L5
    }
}
