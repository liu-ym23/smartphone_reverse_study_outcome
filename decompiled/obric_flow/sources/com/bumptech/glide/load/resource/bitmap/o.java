package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.d0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class o implements z.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z.i f1625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1626c;

    public o(z.i r5, boolean r10) {
        this.f1625b = r5;
        this.f1626c = r10;
    }

    @Override // z.i
    public final d0 a(com.bumptech.glide.c r5, d0 r10, int r11, int r12) {
        com.bumptech.glide.load.engine.bitmap_recycle.a r13 = com.bumptech.glide.b.b(r5).f1382a;
        Drawable r14 = (Drawable) r10.get();
        c r15 = n.a(r13, r14, r11, r12);
        if (r15 == null) goto L5;
        d0 r16 = this.f1625b.a(r5, r15, r11, r12);
        if (r16.equals(r15) == false) goto L14;
        r16.recycle();
        return r10;
    L14:
        return new c(r5.getResources(), r16);
    L5:
        if (this.f1626c == true) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException("Unable to convert " + r14 + " to a Bitmap");
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        this.f1625b.b(r5);
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof o) == true) goto L5;
        return false;
    L5:
        return this.f1625b.equals(((o) r5).f1625b);
    }

    @Override // z.c
    public final int hashCode() {
        return this.f1625b.hashCode();
    }
}
