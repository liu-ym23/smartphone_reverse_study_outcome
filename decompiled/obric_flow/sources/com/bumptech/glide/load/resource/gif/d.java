package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.d0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class d implements z.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z.i f1654b;

    public d(z.i r5) {
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1654b = r5;
    }

    @Override // z.i
    public final d0 a(com.bumptech.glide.c r5, d0 r10, int r11, int r12) {
        GifDrawable r13 = (GifDrawable) r10.get();
        com.bumptech.glide.load.engine.bitmap_recycle.a r14 = com.bumptech.glide.b.b(r5).f1382a;
        d0 r15 = new com.bumptech.glide.load.resource.bitmap.c(r13.b(), r14);
        z.i r16 = this.f1654b;
        d0 r17 = r16.a(r5, r15, r11, r12);
        if (r15.equals(r17) == true) goto L5;
        r15.recycle();
    L5:
        Bitmap r18 = (Bitmap) r17.get();
        r13.f1643a.frameLoader.setFrameTransformation(r16, r18);
        return r10;
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        this.f1654b.b(r5);
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof d) == true) goto L5;
        return false;
    L5:
        return this.f1654b.equals(((d) r5).f1654b);
    }

    @Override // z.c
    public final int hashCode() {
        return this.f1654b.hashCode();
    }
}
