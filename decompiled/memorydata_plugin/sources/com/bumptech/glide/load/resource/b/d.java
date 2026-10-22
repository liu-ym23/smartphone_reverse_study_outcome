package com.bumptech.glide.load.resource.b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: loaded from: classes.dex */
final class d extends c<Drawable> {
    private d(Drawable r1) {
        super(r1);
    }

    static s<Drawable> a(Drawable r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new d(r1);
    }

    @Override // com.bumptech.glide.load.engine.s
    public Class<Drawable> c() {
        return this.f832a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int e() {
        return Math.max(1, (this.f832a.getIntrinsicWidth() * this.f832a.getIntrinsicHeight()) * 4);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void f() {
    }
}
