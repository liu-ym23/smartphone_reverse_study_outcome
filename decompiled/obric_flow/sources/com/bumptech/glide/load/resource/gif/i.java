package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.d0;

/* JADX INFO: loaded from: classes.dex */
public final class i implements z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f1659a;

    public i(com.bumptech.glide.load.engine.bitmap_recycle.a r5) {
        this.f1659a = r5;
    }

    @Override // z.g
    public final /* bridge */ /* synthetic */ boolean a(Object r5, z.f r10) {
        x.a r11 = (x.a) r5;
        return true;
    }

    @Override // z.g
    public final d0 b(Object r5, int r10, int r11, z.f r12) {
        return com.bumptech.glide.load.resource.bitmap.c.b(((x.e) ((x.a) r5)).b(), this.f1659a);
    }
}
