package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f892b;
    private final e<GifDrawable, byte[]> c;

    public c(com.bumptech.glide.load.engine.bitmap_recycle.e r3, e<Bitmap, byte[]> r4, e<GifDrawable, byte[]> r5) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r6 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        e<Bitmap, byte[]> r7 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        e<GifDrawable, byte[]> r8 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        this.f891a = r6;
        this.f892b = r7;
        this.c = r8;
    }

    private static s<GifDrawable> a(s<Drawable> r2) {
        return (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public s<byte[]> a(s<Drawable> r4, com.bumptech.glide.load.e r5) {
        s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin");
        Drawable r0 = (Drawable) ZeusTransformUtils.preCheckCast(r6.d(), Drawable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, BitmapDrawable.class) == false) goto L7;
        return this.f892b.a(com.bumptech.glide.load.resource.bitmap.e.a(((BitmapDrawable) ZeusTransformUtils.preCheckCast(r0, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap(), this.f891a), r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r0, GifDrawable.class) == true) goto L9;
        return null;
    L9:
        return this.c.a(a(r6), r5);
    }
}
