package com.bytedance.awemeopen.infra.plugs.fresco;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends BasePostprocessor {
    public final /* synthetic */ l64.b a;

    public d(l64.b r1) {
        this.a = r1;
    }

    public final CloseableReference<Bitmap> process(Bitmap r7, PlatformBitmapFactory r8) {
        l64.b r0 = this.a;
        int r1 = r0.m;
        int r2 = r0.l;
        if (r0.k != ImageView.ScaleType.CENTER_INSIDE) goto L13;
        float r3 = r7.getWidth() / r7.getHeight();
        if (r7.getHeight() <= r7.getWidth()) goto L7;
        r1 = this.a.m;
    L9:
        if (r7.getHeight() <= r7.getWidth()) goto L11;
        int r4 = (int) (this.a.m * r3);
    L12:
        r2 = r4;
        goto L13
    L11:
        r4 = this.a.l;
        goto L12
    L7:
        r1 = (int) (this.a.l / r3);
    L13:
        CloseableReference r9 = r8.createBitmap(r2, r1);
        Bitmap r5 = (Bitmap) r9.get();     // Catch: Throwable -> L21
        l64.b r6 = this.a;     // Catch: Throwable -> L21
        if (r6.k != ImageView.ScaleType.CENTER_CROP) goto L17;
        c.b(c.a(r7, r6), r5, this.a);     // Catch: Throwable -> L21
    L18:
        CloseableReference<Bitmap> r10 = CloseableReference.cloneOrNull(r9);     // Catch: Throwable -> L21
        CloseableReference.closeSafely(r9);
        return r10;
    L17:
        c.c(r7, r5, r1, r2, r6);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableReference.closeSafely(r9);
        throw th;
    }

    public final void process(Bitmap r1, Bitmap r2) {
        super.process(r1, r2);
    }
}
