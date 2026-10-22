package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DrawableUtils {
    public static int a(int r5, int r10) {
        if (r10 != 255) goto L6;
        return r5;
    L6:
        if (r10 == 0) goto L8;
        int r11 = r10 + (r10 >> 7);
        int r12 = (((r5 >>> 24) * r11) >> 8) << 24;
        return (r5 & ViewCompat.MEASURED_SIZE_MASK) | r12;
    L8:
        return r5 & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static void a(Drawable r5, DrawableProperties r10) {
        if (r5 == null) goto L23;
        if (r10 == null) goto L25;
        int r11 = r10.f7835a;
        if (r11 == (-1)) goto L9;
        r5.setAlpha(r11);
    L9:
        if (r10.f7836b == false) goto L11;
        r5.setColorFilter(r10.f7837c);
    L11:
        int r12 = r10.d;
        boolean r13 = false;
        if (r12 == (-1)) goto L17;
        if (r12 == 0) goto L15;
        boolean r14 = true;
    L16:
        r5.setDither(r14);
        goto L17
    L15:
        r14 = false;
    L17:
        int r15 = r10.e;
        if (r15 == (-1)) goto L24;
        if (r15 == 0) goto L21;
        r13 = true;
    L21:
        r5.setFilterBitmap(r13);
        return;
    L24:
        return;
    L25:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Drawable r5, Drawable.Callback r10, TransformCallback r11) {
        if (r5 == 0) goto L7;
        r5.setCallback(r10);
        if ((r5 instanceof TransformAwareDrawable) == false) goto L8;
        ((TransformAwareDrawable) r5).a(r11);
        return;
    L8:
        return;
    }
}
