package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f1624a = null;

    static {
        f1624a = new m();
    }

    public static c a(com.bumptech.glide.load.engine.bitmap_recycle.a r10, Drawable r11, int r12, int r13) {
        Drawable r14 = r11.getCurrent();
        boolean r5 = false;
        if ((r14 instanceof BitmapDrawable) == false) goto L6;
        Bitmap r15 = ((BitmapDrawable) r14).getBitmap();
    L35:
        if (r5 == true) goto L39;
        r10 = f1624a;
    L39:
        return c.b(r15, r10);
    L6:
        if ((r14 instanceof Animatable) == false) goto L8;
        r15 = null;
        goto L35
    L8:
        if (r12 == Integer.MIN_VALUE) goto L10;
    L15:
        if (r13 != Integer.MIN_VALUE) goto L22;
        if (r14.getIntrinsicHeight() > 0) goto L22;
        if (Log.isLoggable("DrawableToBitmap", 5) == true) goto L20;
    L14:
        r15 = null;
    L30:
        r5 = true;
        goto L35
    L20:
        Log.w("DrawableToBitmap", "Unable to draw " + r14 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
    L22:
        if (r14.getIntrinsicWidth() <= 0) goto L25;
        r12 = r14.getIntrinsicWidth();
    L25:
        if (r14.getIntrinsicHeight() <= 0) goto L27;
        r13 = r14.getIntrinsicHeight();
    L27:
        Lock r16 = u.f1635b;
        r16.lock();
        Bitmap r17 = r10.g(r12, r13, Bitmap.Config.ARGB_8888);
        Canvas r18 = new Canvas(r17);     // Catch: Throwable -> L31
        r14.setBounds(0, 0, r12, r13);     // Catch: Throwable -> L31
        r14.draw(r18);     // Catch: Throwable -> L31
        r18.setBitmap(null);     // Catch: Throwable -> L31
        r16.unlock();
        r15 = r17;
    L31:
        th = move-exception;
        r16.unlock();
        throw th;
    L10:
        if (r14.getIntrinsicWidth() > 0) goto L15;
        if (Log.isLoggable("DrawableToBitmap", 5) == false) goto L14;
        Log.w("DrawableToBitmap", "Unable to draw " + r14 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
        goto L14
    }
}
