package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultDrawableFactory implements DrawableFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f7725a;

    public DefaultDrawableFactory(Resources r5) {
        this.f7725a = r5;
    }

    public final Drawable a(CloseableImage r5) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L15
        if ((r5 instanceof CloseableStaticBitmap) == false) goto L19;
        CloseableStaticBitmap r10 = (CloseableStaticBitmap) r5;     // Catch: Throwable -> L15
        BitmapDrawable r11 = new BitmapDrawable(this.f7725a, r10.g);     // Catch: Throwable -> L15
        int r12 = r10.f8172i;     // Catch: Throwable -> L15
        if (r12 != 0) goto L7;
    L9:
        int r13 = r10.f8173j;     // Catch: Throwable -> L15
        if (r13 == 1) goto L17;
        if (r13 == 0) goto L17;
    L12:
        OrientedDrawable r14 = new OrientedDrawable(r11, r10.f8172i, r10.f8173j);     // Catch: Throwable -> L15
        FrescoSystrace.a().getClass();
        return r14;
    L17:
        FrescoSystrace.a().getClass();
        return r11;
    L7:
        if (r12 == (-1)) goto L9;
    L19:
        FrescoSystrace.a().getClass();
        return null;
    L15:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final Drawable a(CloseableImage r5, Drawable r10) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L7
        if ((r5 instanceof CloseableStaticBitmap) == false) goto L9;
        Drawable r11 = a(r5);     // Catch: Throwable -> L7
        FrescoSystrace.a().getClass();
        return r11;
    L9:
        FrescoSystrace.a().getClass();
        return null;
    L7:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }
}
