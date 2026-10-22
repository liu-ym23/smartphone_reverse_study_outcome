package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bumptech.glide.load.h<GifDrawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.h<Bitmap> f903b;

    public e(com.bumptech.glide.load.h<Bitmap> r3) {
        this.f903b = (com.bumptech.glide.load.h) ZeusTransformUtils.preCheckCast(j.a((com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin")), com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.h
    public s<GifDrawable> a(Context r6, s<GifDrawable> r7, int r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        s<GifDrawable> r11 = (s) ZeusTransformUtils.wrapperContextForParams(r7, s.class, "com.obric.memorydata.plugin");
        GifDrawable r0 = (GifDrawable) ZeusTransformUtils.preCheckCast(r11.d(), GifDrawable.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r2 = com.bumptech.glide.c.a(r10).a();
        s<Bitmap> r4 = new com.bumptech.glide.load.resource.bitmap.e(r0.getFirstFrame(), r2);
        s<Bitmap> r12 = this.f903b.a(r10, r4, r8, r9);
        if (r4.equals(r12) == true) goto L5;
        r4.f();
    L5:
        Bitmap r13 = (Bitmap) ZeusTransformUtils.preCheckCast(r12.d(), Bitmap.class, "com.obric.memorydata.plugin");
        r0.setFrameTransformation(this.f903b, r13);
        return r11;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r1) {
        this.f903b.a(r1);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L6;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
        return this.f903b.equals(r4.f903b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f903b.hashCode();
    }
}
