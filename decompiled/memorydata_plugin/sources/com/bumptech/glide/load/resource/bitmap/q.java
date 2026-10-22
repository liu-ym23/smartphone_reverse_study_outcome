package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class q implements com.bumptech.glide.load.engine.o, com.bumptech.glide.load.engine.s<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.s<Bitmap> f876b;

    private q(Resources r3, com.bumptech.glide.load.engine.s<Bitmap> r4) {
        com.bumptech.glide.load.engine.s r5 = (com.bumptech.glide.load.engine.s) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin");
        this.f875a = (Resources) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r3), Resources.class, "com.obric.memorydata.plugin");
        this.f876b = (com.bumptech.glide.load.engine.s) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r5), com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin");
    }

    public static com.bumptech.glide.load.engine.s<BitmapDrawable> a(Resources r2, com.bumptech.glide.load.engine.s<Bitmap> r3) {
        com.bumptech.glide.load.engine.s r4 = (com.bumptech.glide.load.engine.s) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new q(r2, r4);
    }

    @Override // com.bumptech.glide.load.engine.o
    public void a() {
        if (ZeusTransformUtils.instanceOf(this.f876b, com.bumptech.glide.load.engine.o.class) == false) goto L6;
        ((com.bumptech.glide.load.engine.o) ZeusTransformUtils.preCheckCast(this.f876b, com.bumptech.glide.load.engine.o.class, "com.obric.memorydata.plugin")).a();
        return;
    }

    public BitmapDrawable b() {
        return new BitmapDrawable(this.f875a, (Bitmap) ZeusTransformUtils.preCheckCast(this.f876b.d(), Bitmap.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.s
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.s
    public /* synthetic */ BitmapDrawable d() {
        return b();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int e() {
        return this.f876b.e();
    }

    @Override // com.bumptech.glide.load.engine.s
    public void f() {
        this.f876b.f();
    }
}
