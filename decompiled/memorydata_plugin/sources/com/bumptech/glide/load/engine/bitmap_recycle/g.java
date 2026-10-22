package com.bumptech.glide.load.engine.bitmap_recycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class g implements a<byte[]> {
    public g() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public /* synthetic */ int a(byte[] r3) {
        return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(byte[] r1) {
        return r1.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public /* synthetic */ byte[] a(int r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String a() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int b() {
        return 1;
    }

    public byte[] b(int r1) {
        return new byte[r1];
    }
}
