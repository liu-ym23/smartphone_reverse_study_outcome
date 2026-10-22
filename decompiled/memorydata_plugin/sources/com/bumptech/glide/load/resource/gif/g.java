package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class g implements com.bumptech.glide.load.f<com.bumptech.glide.b.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f909a;

    public g(com.bumptech.glide.load.engine.bitmap_recycle.e r3) {
        this.f909a = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public s<Bitmap> a2(com.bumptech.glide.b.a r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return com.bumptech.glide.load.resource.bitmap.e.a(((com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r1, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin")).i(), this.f909a);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ s<Bitmap> a(com.bumptech.glide.b.a r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((com.bumptech.glide.b.a) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(com.bumptech.glide.b.a r1, com.bumptech.glide.load.e r2) {
        com.bumptech.glide.b.a r0 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r1, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin");
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(com.bumptech.glide.b.a r3, com.bumptech.glide.load.e r4) {
        return a2((com.bumptech.glide.b.a) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin"), r4);
    }
}
