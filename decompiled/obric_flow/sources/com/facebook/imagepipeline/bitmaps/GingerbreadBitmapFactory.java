package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes2.dex */
public class GingerbreadBitmapFactory extends PlatformBitmapFactory {
    public GingerbreadBitmapFactory() {
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public final CloseableReference a(int r5, int r10, Bitmap.Config r11) {
        Bitmap r12 = Bitmap.createBitmap(r5, r10, r11);
        if (SimpleBitmapReleaser.f7989a != null) goto L6;
        SimpleBitmapReleaser.f7989a = new SimpleBitmapReleaser();
    L6:
        return CloseableReference.a(r12, SimpleBitmapReleaser.f7989a, CloseableReference.f);
    }
}
