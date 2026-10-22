package com.bumptech.glide.load.resource.gif;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class c extends h0.a {
    @Override // com.bumptech.glide.load.engine.d0
    public final int a() {
        return ((GifDrawable) this.f17270a).f1643a.frameLoader.getSize();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Class c() {
        return GifDrawable.class;
    }

    @Override // h0.a, com.bumptech.glide.load.engine.a0
    public final void initialize() {
        ((GifDrawable) this.f17270a).b().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final void recycle() {
        Drawable r5 = this.f17270a;
        ((GifDrawable) r5).stop();
        GifDrawable r10 = (GifDrawable) r5;
        r10.d = true;
        r10.f1643a.frameLoader.clear();
    }
}
