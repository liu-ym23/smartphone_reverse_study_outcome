package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class DummyBitmapPool implements BitmapPool {
    public DummyBitmapPool() {
    }

    @Override // com.facebook.common.memory.Pool
    public final Object get(int r5) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) r5) / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public final void release(Object r5) {
        Bitmap r10 = (Bitmap) r5;
        r10.getClass();
        r10.recycle();
    }
}
