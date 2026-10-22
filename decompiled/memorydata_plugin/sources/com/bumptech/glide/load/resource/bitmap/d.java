package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.bumptech.glide.load.f<ImageDecoder.Source, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f856a;

    public d() {
        this.f856a = new com.bumptech.glide.load.engine.bitmap_recycle.f();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.s<Bitmap> a2(ImageDecoder.Source r4, int r5, int r6, com.bumptech.glide.load.e r7) {
        Bitmap r8 = ImageDecoder.decodeBitmap(r4, new com.bumptech.glide.load.resource.a(r5, r6, r7));
        if (Log.isLoggable("BitmapImageDecoder", 2) == false) goto L6;
        Log.v("BitmapImageDecoder", "Decoded [" + r8.getWidth() + "x" + r8.getHeight() + "] for [" + r5 + "x" + r6 + "]");
    L6:
        return new e(r8, this.f856a);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ com.bumptech.glide.load.engine.s<Bitmap> a(ImageDecoder.Source r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((ImageDecoder.Source) ZeusTransformUtils.preCheckCast(r3, ImageDecoder.Source.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ImageDecoder.Source r1, com.bumptech.glide.load.e r2) {
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(ImageDecoder.Source r3, com.bumptech.glide.load.e r4) {
        return a2((ImageDecoder.Source) ZeusTransformUtils.preCheckCast(r3, ImageDecoder.Source.class, "com.obric.memorydata.plugin"), r4);
    }
}
