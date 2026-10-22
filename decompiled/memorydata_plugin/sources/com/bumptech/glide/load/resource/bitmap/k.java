package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bumptech.glide.load.engine.bitmap_recycle.e f864a = null;

    static {
        f864a = new AnonymousClass1();
    }

    static com.bumptech.glide.load.engine.s<Bitmap> a(com.bumptech.glide.load.engine.bitmap_recycle.e r3, Drawable r4, int r5, int r6) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r7 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        Drawable r8 = r4.getCurrent();
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r8, BitmapDrawable.class) == false) goto L6;
        Bitmap r9 = ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r8, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap();
    L9:
        if (r2 == true) goto L13;
        r7 = f864a;
    L13:
        return e.a(r9, r7);
    L6:
        if (ZeusTransformUtils.instanceOf(r8, Animatable.class) == true) goto L8;
        r9 = b(r7, r8, r5, r6);
        r2 = true;
        goto L9
    L8:
        r9 = null;
        goto L9
    }

    private static Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.e r6, Drawable r7, int r8, int r9) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r10 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        if (r8 == Integer.MIN_VALUE) goto L5;
    L10:
        if (r9 != Integer.MIN_VALUE) goto L18;
        if (r7.getIntrinsicHeight() > 0) goto L18;
        if (Log.isLoggable("DrawableToBitmap", 5) == false) goto L16;
        Log.w("DrawableToBitmap", "Unable to draw " + r7 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
    L16:
        return null;
    L18:
        if (r7.getIntrinsicWidth() <= 0) goto L21;
        r8 = r7.getIntrinsicWidth();
    L21:
        if (r7.getIntrinsicHeight() <= 0) goto L23;
        r9 = r7.getIntrinsicHeight();
    L23:
        Lock r0 = u.a();
        r0.lock();
        Bitmap r11 = r10.a(r8, r9, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r11);     // Catch: Throwable -> L27
        r7.setBounds(0, 0, r8, r9);     // Catch: Throwable -> L27
        r7.draw(r1);     // Catch: Throwable -> L27
        r1.setBitmap(null);     // Catch: Throwable -> L27
        r0.unlock();
        return r11;
    L27:
        th = move-exception;
        r0.unlock();
        throw th;
    L5:
        if (r7.getIntrinsicWidth() > 0) goto L10;
        if (Log.isLoggable("DrawableToBitmap", 5) == false) goto L9;
        Log.w("DrawableToBitmap", "Unable to draw " + r7 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
    L9:
        return null;
    }
}
