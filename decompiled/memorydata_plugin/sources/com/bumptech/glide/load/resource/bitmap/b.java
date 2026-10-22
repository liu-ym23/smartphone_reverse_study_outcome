package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bumptech.glide.load.g<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.g<Bitmap> f853b;

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e r3, com.bumptech.glide.load.g<Bitmap> r4) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r5 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.g<Bitmap> r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.memorydata.plugin");
        this.f852a = r5;
        this.f853b = r6;
    }

    @Override // com.bumptech.glide.load.g
    public EncodeStrategy a(com.bumptech.glide.load.e r1) {
        return this.f853b.a(r1);
    }

    public boolean a(com.bumptech.glide.load.engine.s<BitmapDrawable> r5, File r6, com.bumptech.glide.load.e r7) {
        com.bumptech.glide.load.engine.s r8 = (com.bumptech.glide.load.engine.s) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin");
        return this.f853b.a((Bitmap) new e(((BitmapDrawable) ZeusTransformUtils.preCheckCast(r8.d(), BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap(), this.f852a), r6, r7);
    }

    @Override // com.bumptech.glide.load.a
    public /* synthetic */ boolean a(Object r3, File r4, com.bumptech.glide.load.e r5) {
        return a((com.bumptech.glide.load.engine.s) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin"), r4, r5);
    }
}
