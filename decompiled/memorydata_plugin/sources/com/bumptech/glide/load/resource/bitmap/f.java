package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class f implements com.bumptech.glide.load.h<Bitmap> {
    public f() {
    }

    public abstract Bitmap a(com.bumptech.glide.load.engine.bitmap_recycle.e r1, Bitmap r2, int r3, int r4);

    @Override // com.bumptech.glide.load.h
    public final com.bumptech.glide.load.engine.s<Bitmap> a(Context r4, com.bumptech.glide.load.engine.s<Bitmap> r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.s<Bitmap> r9 = (com.bumptech.glide.load.engine.s) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin");
        if (com.bumptech.glide.util.k.a(r6, r7) == false) goto L15;
        com.bumptech.glide.load.engine.bitmap_recycle.e r10 = com.bumptech.glide.c.a(r8).a();
        Bitmap r0 = (Bitmap) ZeusTransformUtils.preCheckCast(r9.d(), Bitmap.class, "com.obric.memorydata.plugin");
        if (r6 != Integer.MIN_VALUE) goto L7;
        r6 = r0.getWidth();
    L7:
        if (r7 != Integer.MIN_VALUE) goto L9;
        r7 = r0.getHeight();
    L9:
        Bitmap r3 = a(r10, r0, r6, r7);
        if (r0.equals(r3) == false) goto L13;
        return r9;
    L13:
        return e.a(r3, r10);
    L15:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r6 + " or height: " + r7 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
