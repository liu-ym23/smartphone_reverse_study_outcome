package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class g extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1608b = null;

    static {
        f1608b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(z.c.f23353a);
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        r5.update(f1608b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    public final Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.a r5, Bitmap r10, int r11, int r12) {
        Paint r13 = u.f1634a;
        if (r10.getWidth() > r11) goto L10;
        if (r10.getHeight() > r12) goto L10;
        if (Log.isLoggable("TransformationUtils", 2) == false) goto L14;
        Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        return r10;
    L14:
        return r10;
    L10:
        if (Log.isLoggable("TransformationUtils", 2) == false) goto L13;
        Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
    L13:
        return u.b(r5, r10, r11, r12);
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        return r5 instanceof g;
    }

    @Override // z.c
    public final int hashCode() {
        return -670243078;
    }
}
