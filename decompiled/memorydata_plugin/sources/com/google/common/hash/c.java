package com.google.common.hash;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
abstract class c implements g {
    c() {
    }

    public g a(char r2) {
        a((byte) r2);
        a((byte) (r2 >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.g
    public g a(int r2) {
        a((byte) r2);
        a((byte) (r2 >>> 8));
        a((byte) (r2 >>> 16));
        a((byte) (r2 >>> 24));
        return this;
    }

    @Override // com.google.common.hash.g
    public g a(long r4) {
        int r0 = 0;
    L4:
        if (r0 >= 64) goto L6;
        a((byte) (r4 >>> r0));
        r0 = r0 + 8;
        goto L4
    L6:
        return this;
    }

    @Override // com.google.common.hash.g
    public g a(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r5.charAt(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // com.google.common.hash.g
    public g a(CharSequence r3, Charset r4) {
        return a(((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString().getBytes(r4));
    }

    @Override // com.google.common.hash.g
    public <T> g a(T r3, Funnel<? super T> r4) {
        ((Funnel) ZeusTransformUtils.wrapperContextForParams(r4, Funnel.class, "com.obric.memorydata.plugin")).funnel(r3, this);
        return this;
    }

    @Override // com.google.common.hash.g
    public g a(ByteBuffer r4) {
        if (r4.hasArray() == false) goto L5;
        a(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());
        i.b(r4, r4.limit());
    L8:
        return this;
    L5:
        int r0 = r4.remaining();
    L6:
        if (r0 <= 0) goto L8;
        a(r4.get());
        r0 = r0 - 1;
        goto L6
    }

    @Override // com.google.common.hash.g
    public g a(byte[] r3) {
        return a(r3, 0, r3.length);
    }

    @Override // com.google.common.hash.g
    public g a(byte[] r3, int r4, int r5) {
        n.a(r4, r4 + r5, r3.length);
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        a(r3[r4 + r0]);
        r0 = r0 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(int r1) {
        return a(r1);
    }

    @Override // com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(long r1) {
        return a(r1);
    }

    @Override // com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(CharSequence r3) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(CharSequence r3, Charset r4) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(byte[] r1) {
        return a(r1);
    }
}
