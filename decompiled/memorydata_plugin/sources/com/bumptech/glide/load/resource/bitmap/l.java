package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class l implements com.bumptech.glide.load.h<Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.h<Bitmap> f865b;
    private final boolean c;

    public l(com.bumptech.glide.load.h<Bitmap> r3, boolean r4) {
        this.f865b = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this.c = r4;
    }

    private com.bumptech.glide.load.engine.s<Drawable> a(Context r2, com.bumptech.glide.load.engine.s<Bitmap> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.s r4 = (com.bumptech.glide.load.engine.s) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin");
        return q.a(ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bumptech.glide.load.h
    public com.bumptech.glide.load.engine.s<Drawable> a(Context r5, com.bumptech.glide.load.engine.s<Drawable> r6, int r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.s<Drawable> r10 = (com.bumptech.glide.load.engine.s) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r0 = com.bumptech.glide.c.a(r9).a();
        Drawable r1 = (Drawable) ZeusTransformUtils.preCheckCast(r10.d(), Drawable.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.s<Bitmap> r2 = k.a(r0, r1, r7, r8);
        if (r2 == null) goto L5;
        com.bumptech.glide.load.engine.s<Bitmap> r11 = this.f865b.a(r9, r2, r7, r8);
        if (r11.equals(r2) == false) goto L14;
        r11.f();
        return r10;
    L14:
        return a(r9, r11);
    L5:
        if (this.c == true) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException("Unable to convert " + r1 + " to a Bitmap");
    }

    public com.bumptech.glide.load.h<BitmapDrawable> a() {
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r1) {
        this.f865b.a(r1);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, l.class) == false) goto L6;
        l r4 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.memorydata.plugin");
        return this.f865b.equals(r4.f865b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f865b.hashCode();
    }
}
