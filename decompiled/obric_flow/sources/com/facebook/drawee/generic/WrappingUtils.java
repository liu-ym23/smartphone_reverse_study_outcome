package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.Log;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WrappingUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ColorDrawable f7933a = null;

    static {
        f7933a = new ColorDrawable(0);
    }

    public static void a(Rounded r5, RoundingParams r10) {
        r5.a(r10.f7928b);
        r5.a(r10.f7929c);
        r5.a(r10.f, r10.e);
        r5.a(r10.g);
        r5.d();
        r5.b();
    }

    public static Drawable b(Drawable r5, RoundingParams r10, Resources r11) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L17
        if (r5 == null) goto L25;
        if (r10 == null) goto L25;
        if (r10.f7927a != RoundingParams.RoundingMethod.f7931b) goto L25;
        if ((r5 instanceof ForwardingDrawable) == false) goto L22;
        DrawableParent r12 = (ForwardingDrawable) r5;     // Catch: Throwable -> L17
    L11:
        Object r13 = r12.c();     // Catch: Throwable -> L17
        if (r13 == r12) goto L19;
        if ((r13 instanceof DrawableParent) == false) goto L19;
        r12 = (DrawableParent) r13;     // Catch: Throwable -> L17
    L19:
        r12.a(a(r12.a(f7933a), r10, r11));     // Catch: Throwable -> L17
        FrescoSystrace.a().getClass();
        return r5;
    L22:
        Drawable r14 = a(r5, r10, r11);     // Catch: Throwable -> L17
        FrescoSystrace.a().getClass();
        return r14;
    L25:
        FrescoSystrace.a().getClass();
        return r5;
    L17:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public static Drawable a(Drawable r5, RoundingParams r10) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        if (r10 == null) goto L13;
        if (r10.f7927a != RoundingParams.RoundingMethod.f7930a) goto L13;
        RoundedCornersDrawable r11 = new RoundedCornersDrawable(r5);     // Catch: Throwable -> L11
        a(r11, r10);     // Catch: Throwable -> L11
        r11.f7866l = r10.d;     // Catch: Throwable -> L11
        r11.invalidateSelf();     // Catch: Throwable -> L11
        FrescoSystrace.a().getClass();
        return r11;
    L13:
        FrescoSystrace.a().getClass();
        return r5;
    L11:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public static Drawable a(Drawable r5, ScalingUtils.ScaleType r10) {
        FrescoSystrace.a().getClass();
        if (r5 == null) goto L8;
        if (r10 == null) goto L8;
        ScaleTypeDrawable r11 = new ScaleTypeDrawable(r5, r10);
        FrescoSystrace.a().getClass();
        return r11;
    L8:
        FrescoSystrace.a().getClass();
        return r5;
    }

    public static Drawable a(Drawable r5, RoundingParams r10, Resources r11) {
        if ((r5 instanceof BitmapDrawable) == false) goto L7;
        BitmapDrawable r12 = (BitmapDrawable) r5;
        RoundedBitmapDrawable r13 = new RoundedBitmapDrawable(r11, r12.getBitmap(), r12.getPaint());
        a(r13, r10);
        return r13;
    L7:
        if ((r5 instanceof NinePatchDrawable) == false) goto L11;
        RoundedNinePatchDrawable r14 = new RoundedNinePatchDrawable((NinePatchDrawable) r5);
        a(r14, r10);
        return r14;
    L11:
        if ((r5 instanceof ColorDrawable) == false) goto L14;
        RoundedColorDrawable r15 = RoundedColorDrawable.a((ColorDrawable) r5);
        a(r15, r10);
        return r15;
    L14:
        Object[] r16 = {r5};
        if (FLogDefaultLoggingDelegate.f7658a.a(5) == false) goto L17;
        String r17 = String.format(null, "Don't know how to round that drawable: %s", r16);
        Log.println(5, FLogDefaultLoggingDelegate.a("WrappingUtils"), r17);
    L17:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(DrawableParent r5, RoundingParams r10, Resources r11) {
    L2:
        Object r12 = r5.c();
        if (r12 == r5) goto L8;
        if ((r12 instanceof DrawableParent) == false) goto L8;
        r5 = (DrawableParent) r12;
    L8:
        Drawable r13 = r5.c();
        if (r10 == null) goto L20;
        if (r10.f7927a != RoundingParams.RoundingMethod.f7931b) goto L20;
        if ((r13 instanceof Rounded) == false) goto L16;
        a((Rounded) r13, r10);
        return;
    L16:
        if (r13 == 0) goto L25;
        r5.a(f7933a);
        r5.a(a(r13, r10, r11));
        return;
    L25:
        return;
    L20:
        if ((r13 instanceof Rounded) == false) goto L26;
        Rounded r14 = (Rounded) r13;
        r14.a(false);
        r14.a();
        r14.a(0, 0.0f);
        r14.a(0.0f);
        r14.d();
        r14.b();
        return;
    }
}
