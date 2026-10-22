package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.d0;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements z.i {
    @Override // z.i
    public final d0 a(com.bumptech.glide.c r5, d0 r10, int r11, int r12) {
        if (q0.i.g(r11, r12) == false) goto L15;
        com.bumptech.glide.load.engine.bitmap_recycle.a r13 = com.bumptech.glide.b.b(r5).f1382a;
        Bitmap r14 = (Bitmap) r10.get();
        if (r11 != Integer.MIN_VALUE) goto L7;
        r11 = r14.getWidth();
    L7:
        if (r12 != Integer.MIN_VALUE) goto L9;
        r12 = r14.getHeight();
    L9:
        Bitmap r15 = c(r13, r14, r11, r12);
        if (r14.equals(r15) == false) goto L13;
        return r10;
    L13:
        return c.b(r15, r13);
    L15:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r11 + " or height: " + r12 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.a r5, Bitmap r10, int r11, int r12);
}
