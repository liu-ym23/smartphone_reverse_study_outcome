package com.bumptech.glide.load.engine.bitmap_recycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class i implements a<int[]> {
    public i() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public /* synthetic */ int a(int[] r3) {
        return a2((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(int[] r1) {
        return r1.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public /* synthetic */ int[] a(int r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int b() {
        return 4;
    }

    public int[] b(int r1) {
        return new int[r1];
    }
}
