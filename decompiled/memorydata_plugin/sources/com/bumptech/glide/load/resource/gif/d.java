package com.bumptech.glide.load.resource.gif;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.bumptech.glide.load.resource.b.c<GifDrawable> {
    public d(GifDrawable r1) {
        super(r1);
    }

    @Override // com.bumptech.glide.load.resource.b.c, com.bumptech.glide.load.engine.o
    public void a() {
        ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f832a, GifDrawable.class, "com.obric.memorydata.plugin")).getFirstFrame().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.s
    public Class<GifDrawable> c() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.s
    public int e() {
        return ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f832a, GifDrawable.class, "com.obric.memorydata.plugin")).getSize();
    }

    @Override // com.bumptech.glide.load.engine.s
    public void f() {
        ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f832a, GifDrawable.class, "com.obric.memorydata.plugin")).stop();
        ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f832a, GifDrawable.class, "com.obric.memorydata.plugin")).recycle();
    }
}
