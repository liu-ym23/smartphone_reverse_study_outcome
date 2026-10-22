package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a<DataType> implements com.bumptech.glide.load.f<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.f<DataType, Bitmap> f850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f851b;

    public a(Resources r3, com.bumptech.glide.load.f<DataType, Bitmap> r4) {
        com.bumptech.glide.load.f r5 = (com.bumptech.glide.load.f) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin");
        this.f851b = (Resources) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r3), Resources.class, "com.obric.memorydata.plugin");
        this.f850a = (com.bumptech.glide.load.f) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r5), com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.f
    public com.bumptech.glide.load.engine.s<BitmapDrawable> a(DataType r2, int r3, int r4, com.bumptech.glide.load.e r5) {
        com.bumptech.glide.load.engine.s<Bitmap> r6 = this.f850a.a(r2, r3, r4, r5);
        return q.a(this.f851b, r6);
    }

    @Override // com.bumptech.glide.load.f
    public boolean a(DataType r1, com.bumptech.glide.load.e r2) {
        return this.f850a.a(r1, r2);
    }
}
