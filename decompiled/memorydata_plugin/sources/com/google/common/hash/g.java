package com.google.common.hash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface g extends k {
    HashCode a();

    g a(byte r1);

    g a(int r1);

    g a(long r1);

    g a(CharSequence r1);

    g a(CharSequence r1, Charset r2);

    <T> g a(T r1, Funnel<? super T> r2);

    g a(ByteBuffer r1);

    g a(byte[] r1);

    g a(byte[] r1, int r2, int r3);

    @Override // com.google.common.hash.k
    /* synthetic */ default k b(int r1) {
        return a(r1);
    }

    @Override // com.google.common.hash.k
    /* synthetic */ default k b(long r1) {
        return a(r1);
    }

    @Override // com.google.common.hash.k
    /* synthetic */ default k b(CharSequence r3) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.hash.k
    /* synthetic */ default k b(CharSequence r3, Charset r4) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.hash.k
    /* synthetic */ default k b(byte[] r1) {
        return a(r1);
    }
}
