package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class q extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1627b = null;

    static {
        f1627b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(z.c.f23353a);
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        r5.update(f1627b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    public final Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.a r5, Bitmap r10, int r11, int r12) {
        return u.b(r5, r10, r11, r12);
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        return r5 instanceof q;
    }

    @Override // z.c
    public final int hashCode() {
        return 1572326941;
    }
}
