package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bumptech.glide.load.engine.o, com.bumptech.glide.load.engine.s<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f858b;

    public e(Bitmap r3, com.bumptech.glide.load.engine.bitmap_recycle.e r4) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r5 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        this.f857a = (Bitmap) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r3, "Bitmap must not be null"), Bitmap.class, "com.obric.memorydata.plugin");
        this.f858b = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r5, "BitmapPool must not be null"), com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
    }

    public static e a(Bitmap r2, com.bumptech.glide.load.engine.bitmap_recycle.e r3) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r4 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new e(r2, r4);
    }

    @Override // com.bumptech.glide.load.engine.o
    public void a() {
        this.f857a.prepareToDraw();
    }

    public Bitmap b() {
        return this.f857a;
    }

    @Override // com.bumptech.glide.load.engine.s
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.s
    public /* synthetic */ Bitmap d() {
        return b();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int e() {
        return com.bumptech.glide.util.k.a(this.f857a);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void f() {
        this.f858b.a(this.f857a);
    }
}
