package com.facebook.imagepipeline.image;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class CloseableDrawable extends CloseableImage {
    public Drawable f;

    public CloseableDrawable(Drawable r5) {
        this.f = r5;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final boolean a() {
        if (this.f != null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f = null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final int d() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public final int getHeight() {
        Drawable r5 = this.f;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return Math.max(0, r5.getIntrinsicHeight());
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public final int getWidth() {
        Drawable r5 = this.f;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return Math.max(0, r5.getIntrinsicWidth());
    }
}
