package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z5 extends com.lynx.tasm.behavior.ui.view.a {
    public final Function0<com.lynx.tasm.behavior.b1> a;
    public final Function0<UIGroup<?>> b;
    public final Function0<Rect> c;
    public Rect d;
    public Integer e;
    public int f;
    public int g;

    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (super.dispatchTouchEvent(r10) == false) goto L6;
        return true;
    L6:
        Function0<com.lynx.tasm.behavior.b1> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L37;
        com.lynx.tasm.behavior.b1 r2 = (com.lynx.tasm.behavior.b1) r0.invoke();
        if (r2 == null) goto L37;
        Function0<UIGroup<?>> r3 = this.b;
        if (r3 == null) goto L37;
        UIGroup r4 = (UIGroup) r3.invoke();
        if (r4 == null) goto L37;
        float r5 = r10.getX();
        float r6 = r10.getY();
        Rect r7 = this.d;
        Function0<Rect> r8 = this.c;
        if (r8 == null) goto L20;
        Rect r9 = (Rect) r8.invoke();
        if (r9 == null) goto L20;
    L21:
        if (r7 == null) goto L23;
        int r11 = r7.left;
    L24:
        float r12 = r11 + r5;
        if (r9 == null) goto L27;
        int r13 = r9.left;
    L28:
        float r14 = r12 + r13;
        if (r7 == null) goto L31;
        r1 = r7.top;
    L31:
        float r15 = r1 + r6;
        if (r9 == null) goto L34;
        int r16 = r9.top;
    L35:
        r10.setLocation(r14, r15 + r16);
        boolean r17 = r2.x(r10, r4);
        r10.setLocation(r5, r6);
        return r17;
    L34:
        r16 = r4.getOriginTop();
        goto L35
    L27:
        r13 = r4.getOriginLeft();
        goto L28
    L23:
        r11 = 0;
    L20:
        r9 = r4.getBound();
    L37:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r18, int r19) {
        int r1 = View.MeasureSpec.getMode(r18);
        int r2 = View.MeasureSpec.getSize(r18);
        int r3 = View.MeasureSpec.getMode(r19);
        int r4 = View.MeasureSpec.getSize(r19);
        Resources r5 = getResources();
        int r6 = RangesKt.coerceAtLeast(WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).widthPixels - y0.c(getContext(), 24), 0);
        Resources r8 = getResources();
        int r7 = RangesKt.coerceAtLeast(WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).heightPixels - y0.c(getContext(), 24), 0);
        int r9 = Integer.MIN_VALUE;
        if (r1 == Integer.MIN_VALUE) goto L6;
        if (r1 == 1073741824) goto L6;
        r2 = r6;
    L6:
        int r10 = RangesKt.coerceAtLeast(r2, 0);
        if (r3 == Integer.MIN_VALUE) goto L10;
        if (r3 == 1073741824) goto L10;
        r4 = r7;
    L10:
        int r11 = RangesKt.coerceAtLeast(r4, 0);
        Integer r12 = this.e;
        if (r12 == null) goto L13;
        Integer r13 = Integer.valueOf(RangesKt.coerceIn(r12.intValue(), 1, r10));
    L14:
        int r14 = getPaddingLeft() + getPaddingRight();
        int r15 = getPaddingTop() + getPaddingBottom();
        int r16 = getChildCount();
        int r17 = 0;
    L15:
        if (r17 >= r16) goto L56;
        View r110 = getChildAt(r17);
        if (r110 == null) goto L55;
        if (r110.getVisibility() == 8) goto L55;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
    L26:
        if (r112 == null) goto L28;
        Integer r113 = Integer.valueOf(r112.leftMargin);
    L29:
        int r114 = y0.d(r113);
        if (r112 == null) goto L32;
        Integer r115 = Integer.valueOf(r112.rightMargin);
    L33:
        int r116 = r114 + y0.d(r115);
        if (r112 == null) goto L36;
        Integer r117 = Integer.valueOf(r112.topMargin);
    L37:
        int r118 = y0.d(r117);
        if (r112 == null) goto L40;
        Integer r119 = Integer.valueOf(r112.bottomMargin);
    L41:
        int r120 = r118 + y0.d(r119);
        Rect r121 = this.d;
        if (r121 == null) goto L44;
        int r20 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(((r121.right - getPaddingLeft()) - getPaddingRight()) - r116, 0), 1073741824);
    L51:
        if (r121 == null) goto L53;
        int r21 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(((r121.bottom - getPaddingTop()) - getPaddingBottom()) - r120, 0), 1073741824);
    L54:
        r110.measure(r20, r21);
        int r22 = Math.max(r14, ((r110.getMeasuredWidth() + r116) + getPaddingLeft()) + getPaddingRight());
        r15 = Math.max(r15, ((r110.getMeasuredHeight() + r120) + getPaddingTop()) + getPaddingBottom());
        r14 = r22;
        goto L55
    L53:
        r21 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(((r11 - getPaddingTop()) - getPaddingBottom()) - r120, 0), Integer.MIN_VALUE);
        goto L54
    L44:
        if (r13 == null) goto L46;
        int r23 = r13.intValue();
    L47:
        int r24 = RangesKt.coerceAtLeast(((r23 - getPaddingLeft()) - getPaddingRight()) - r116, 0);
        if (r13 == null) goto L50;
        r9 = 1073741824;
    L50:
        r20 = View.MeasureSpec.makeMeasureSpec(r24, r9);
        goto L51
    L46:
        r23 = r10;
        goto L47
    L40:
        r119 = null;
        goto L41
    L36:
        r117 = null;
        goto L37
    L32:
        r115 = null;
        goto L33
    L28:
        r113 = null;
        goto L29
    L25:
        r112 = null;
    L55:
        r17 = r17 + 1;
        r9 = Integer.MIN_VALUE;
        goto L15
    L56:
        Rect r25 = this.d;
        if (r25 == null) goto L59;
        r14 = r25.width();
    L61:
        int r26 = View.resolveSize(r14, r18);
        Rect r27 = this.d;
        if (r27 == null) goto L64;
        r15 = r27.height();
    L64:
        setMeasuredDimension(r26, View.resolveSize(r15, r19));
        return;
    L59:
        if (r13 == null) goto L61;
        r14 = r13.intValue();
        goto L61
    L13:
        r13 = null;
        goto L14
    }

    public z5(Context r2, Function0 r3, r0 r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L31;
        View r13 = getChildAt(r12);
        if (r13 == null) goto L30;
        if (r13.getVisibility() == 8) goto L30;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Integer r1 = null;
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
    L14:
        Rect r0 = this.d;
        int r2 = getPaddingLeft();
        if (r15 == null) goto L17;
        Integer r3 = Integer.valueOf(r15.leftMargin);
    L18:
        int r4 = (r2 + y0.d(r3)) - this.f;
        int r5 = getPaddingTop();
        if (r15 == null) goto L21;
        r1 = Integer.valueOf(r15.topMargin);
    L21:
        int r16 = (r5 + y0.d(r1)) - this.g;
        int r17 = r13.getMeasuredWidth();
        int r18 = this.f;
        if (r0 == null) goto L24;
        int r19 = r0.right;
    L25:
        int r110 = Math.max(r17, r18 + r19);
        int r20 = r13.getMeasuredHeight();
        int r21 = this.g;
        if (r0 == null) goto L28;
        int r22 = r0.bottom;
    L29:
        r13.layout(r4, r16, r110 + r4, Math.max(r20, r21 + r22) + r16);
        goto L30
    L28:
        r22 = 0;
        goto L29
    L24:
        r19 = 0;
        goto L25
    L17:
        r3 = null;
        goto L18
    L13:
        r15 = null;
    L30:
        r12 = r12 + 1;
        goto L3
    }
}
