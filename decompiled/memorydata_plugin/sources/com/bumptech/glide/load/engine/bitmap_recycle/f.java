package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class f implements e {
    public f() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public Bitmap a(int r1, int r2, Bitmap.Config r3) {
        return Bitmap.createBitmap(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void a(int r1) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void a(Bitmap r1) {
        r1.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public Bitmap b(int r1, int r2, Bitmap.Config r3) {
        return a(r1, r2, r3);
    }
}
