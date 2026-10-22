package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes.dex */
public class h {
    @NonNull
    static d a(int r10) {
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return b();
    L8:
        return new e();
    L10:
        return new k();
    }

    @NonNull
    static d b() {
        return new k();
    }

    @NonNull
    static f c() {
        return new f();
    }

    public static void d(@NonNull View r10, float r11) {
        Drawable r12 = r10.getBackground();
        if ((r12 instanceof MaterialShapeDrawable) == false) goto L6;
        ((MaterialShapeDrawable) r12).setElevation(r11);
        return;
    }

    public static void e(@NonNull View r10) {
        Drawable r11 = r10.getBackground();
        if ((r11 instanceof MaterialShapeDrawable) == false) goto L6;
        f(r10, (MaterialShapeDrawable) r11);
        return;
    }

    public static void f(@NonNull View r10, @NonNull MaterialShapeDrawable r11) {
        if (r11.isElevationOverlayEnabled() == false) goto L6;
        r11.setParentAbsoluteElevation(ViewUtils.h(r10));
        return;
    }
}
