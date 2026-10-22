package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.material.OMaterialHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y5 extends FrameLayout {
    public final x5 a;

    public static final class a extends ViewOutlineProvider {
        public final /* synthetic */ y5 a;

        public a(y5 r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            if (r7 != null) goto L4;
            return;
        L4:
            if (r8 == null) goto L7;
            r8.setRoundRect(0, 0, r7.getWidth(), r7.getHeight(), this.a.a.d);
            return;
        }
    }

    public final GradientDrawable a(int r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(this.a.d);
        r0.setColor(r3);
        return r0;
    }

    public y5(Context r4, x5 r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "appearance");
        super(r4);
        this.a = r5;
        setClipChildren(false);
        setClipToPadding(false);
        boolean r0 = true;
        setClipToOutline(true);
        setOutlineProvider(new a(this));
        GradientDrawable r6 = a(r5.a);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Context r2 = getContext();     // Catch: Throwable -> L12
        if (OMaterialHelper.k() == true) goto L7;
    L9:
        r0 = false;
    L10:
        Object r3 = Result.constructor-impl(Boolean.valueOf(r0));     // Catch: Throwable -> L12
    L14:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L18;
        r3 = r7;
    L18:
        if (((Boolean) r3).booleanValue() == false) goto L28;
        setBackground(a(0));
        com.obric.oui.material.c r8 = this.a.e;     // Catch: Throwable -> L22
        Integer r9 = OMaterialHelper.a;     // Catch: Throwable -> L22
        Resources r10 = Resources.getSystem();     // Catch: Throwable -> L22
        OMaterialHelper.v(this, 3, r8, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density);     // Catch: Throwable -> L22
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        if (Result.exceptionOrNull-impl(r11) == null) goto L27;
        setBackground(r6);
    L27:
        Result.box-impl(r11);
    L30:
        if (this.a.c <= 0) goto L32;
        GradientDrawable r12 = a(0);
        x5 r13 = this.a;
        r12.setStroke(r13.c, r13.b);
    L33:
        setForeground(r12);
        return;
    L32:
        r12 = null;
    L22:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L28:
        setBackground(r6);
        goto L30
    L7:
        if (OMaterialHelper.g(r2) <= 0) goto L9;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r9, int r10) {
        boolean r0 = false;
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
    L29:
        setMeasuredDimension(0, 0);
        return;
    L5:
        if (r1.getVisibility() == 8) goto L29;
        Integer r2 = Integer.valueOf(r1.getMeasuredWidth());
        if (r2.intValue() <= 0) goto L10;
        boolean r3 = true;
    L11:
        Integer r5 = null;
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        int r4 = View.MeasureSpec.makeMeasureSpec(r2.intValue(), 1073741824);
    L19:
        Integer r6 = Integer.valueOf(r1.getMeasuredHeight());
        if (r6.intValue() <= 0) goto L22;
        r0 = true;
    L22:
        if (r0 == false) goto L24;
        r5 = r6;
    L24:
        if (r5 == null) goto L26;
        int r7 = View.MeasureSpec.makeMeasureSpec(r5.intValue(), 1073741824);
    L27:
        r1.measure(r4, r7);
        setMeasuredDimension(View.resolveSize(r1.getMeasuredWidth(), r9), View.resolveSize(r1.getMeasuredHeight(), r10));
        return;
    L26:
        r7 = r10;
        goto L27
    L18:
        r4 = r9;
        goto L19
    L10:
        r3 = false;
        goto L11
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        View r0 = getChildAt(0);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.layout(0, 0, r5 - r3, r6 - r4);
    }
}
