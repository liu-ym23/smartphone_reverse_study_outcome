package com.bumptech.glide.load.data;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class m implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f1435a;

    public m(com.bumptech.glide.load.engine.bitmap_recycle.f r5) {
        this.f1435a = r5;
    }

    @Override // com.bumptech.glide.load.data.f
    public final g a(Object r5) {
        return new i((InputStream) r5, this.f1435a);
    }

    @Override // com.bumptech.glide.load.data.f
    public final Class c() {
        return InputStream.class;
    }
}
