package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class s implements com.bumptech.glide.load.f<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.b.e f878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f879b;

    public s(com.bumptech.glide.load.resource.b.e r3, com.bumptech.glide.load.engine.bitmap_recycle.e r4) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r5 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        this.f878a = r3;
        this.f879b = r5;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.s<Bitmap> a2(Uri r2, int r3, int r4, com.bumptech.glide.load.e r5) {
        com.bumptech.glide.load.engine.s<Drawable> r6 = this.f878a.a2(r2, r3, r4, r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        Drawable r7 = (Drawable) ZeusTransformUtils.preCheckCast(r6.d(), Drawable.class, "com.obric.memorydata.plugin");
        return k.a(this.f879b, r7, r3, r4);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ com.bumptech.glide.load.engine.s<Bitmap> a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1, com.bumptech.glide.load.e r2) {
        return "android.resource".equals(r1.getScheme());
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(Uri r3, com.bumptech.glide.load.e r4) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4);
    }
}
