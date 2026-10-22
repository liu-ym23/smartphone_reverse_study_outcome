package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleBitmapReleaser f7989a;

    public SimpleBitmapReleaser() {
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public final void release(Object r5) {
        ((Bitmap) r5).recycle();
    }
}
