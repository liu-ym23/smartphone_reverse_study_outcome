package com.larus.utils;

import android.R;
import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.graphics.ColorUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w0 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends ViewOutlineProvider {
        public final /* synthetic */ int a;

        public a(int r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a);
        }
    }

    static {
    }

    public w0() {
    }

    public static int c(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Point r0 = new Point();
        r1.getWindowManager().getDefaultDisplay().getRealSize(r0);
        return r0.y;
    }

    public static boolean d(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Rect r0 = new Rect();
        if (r3.getGlobalVisibleRect(r0) == true) goto L5;
    L9:
        return false;
    L5:
        if (r3.getWidth() != r0.width()) goto L9;
        if (r3.getHeight() != r0.height()) goto L9;
        return true;
    }

    @JvmStatic
    public static final void e(View r1, int r2) {
        if (r1 == null) goto L5;
        r1.setOutlineProvider(new a(r2));
        r1.setClipToOutline(true);
        return;
    }

    public static StateListDrawable a(Integer r5, Integer r6, Float r7, Integer r8) {
        if (r5 == null) goto L5;
        int r9 = r5.intValue();
    L6:
        GradientDrawable r1 = new GradientDrawable();
        r1.setColor(r9);
        if (r7 == null) goto L9;
        r1.setCornerRadius(r7.floatValue());
    L9:
        GradientDrawable r10 = new GradientDrawable();
        if (r6 == null) goto L12;
        r10.setColor(r6.intValue());
    L12:
        if (r7 == null) goto L14;
        r10.setCornerRadius(r7.floatValue());
    L14:
        StateListDrawable r11 = new StateListDrawable();
        r11.addState(new int[]{R.attr.state_pressed}, r10);
        if (r8 == null) goto L20;
        int[] r12 = {-16842910};
        GradientDrawable r2 = new GradientDrawable();
        r2.setColor(r8.intValue());
        if (r7 == null) goto L19;
        r2.setCornerRadius(r7.floatValue());
    L19:
        Unit r13 = Unit.INSTANCE;
        r11.addState(r12, r2);
    L20:
        r11.addState(new int[0], r1);
        return r11;
    L5:
        r9 = 0;
        goto L6
    }

    public static StateListDrawable b(Integer r1, Float r2, float r3, Integer r4, int r5) {
        if ((r5 & 4) == 0) goto L5;
        r3 = 0.1f;
    L5:
        Object r0 = null;
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        if (r1 == null) goto L10;
        int r6 = r1.intValue();
    L21:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        Object r8 = Result.constructor-impl(Integer.valueOf(ColorUtils.blendARGB(r6, -16777216, r3)));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r8) == true) goto L20;
        r0 = r8;
    L20:
        return a(Integer.valueOf(r6), (Integer) r0, r2, r4);
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L10:
        r6 = 0;
        goto L21
    }
}
