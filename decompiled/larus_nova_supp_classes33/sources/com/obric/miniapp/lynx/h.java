package com.obric.miniapp.lynx;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.behavior.ui.UIGroup;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h extends com.lynx.tasm.behavior.ui.view.a {
    public final Function0<com.lynx.tasm.behavior.b1> a;
    public final Function0<UIGroup<?>> b;
    public final Function0<Rect> c;
    public int d;
    public int e;

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final int getBodyMaxHeightPx() {
        return this.d;
    }

    public final int getContentHeightOverridePx() {
        return this.e;
    }

    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (super.dispatchTouchEvent(r7) == false) goto L6;
        return true;
    L6:
        Function0<com.lynx.tasm.behavior.b1> r0 = this.a;
        if (r0 == null) goto L29;
        com.lynx.tasm.behavior.b1 r1 = (com.lynx.tasm.behavior.b1) r0.invoke();
        if (r1 == null) goto L29;
        Function0<UIGroup<?>> r2 = this.b;
        if (r2 == null) goto L29;
        UIGroup r3 = (UIGroup) r2.invoke();
        if (r3 == null) goto L29;
        float r4 = r7.getX();
        float r5 = r7.getY();
        Function0<Rect> r6 = this.c;
        if (r6 == null) goto L20;
        Rect r8 = (Rect) r6.invoke();
        if (r8 == null) goto L20;
    L21:
        if (r8 == null) goto L23;
        float r9 = r8.left + r4;
    L24:
        if (r8 == null) goto L26;
        float r10 = r8.top + r5;
    L27:
        r7.setLocation(r9, r10);
        boolean r11 = r1.x(r7, r3);
        r7.setLocation(r4, r5);
        return r11;
    L26:
        r10 = r5;
        goto L27
    L23:
        r9 = r4;
    L20:
        r8 = r3.getBound();
    L29:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBodyMaxHeightPx(int r2) {
        if (this.d != r2) goto L5;
        return;
    L5:
        this.d = r2;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContentHeightOverridePx(int r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r20, int r21) {
        int r2 = getChildCount();
        int r4 = 0;
    L3:
        int r5 = -1;
        if (r4 >= r2) goto L35;
        View r6 = getChildAt(r4);
        if (r6 == null) goto L34;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L11;
        r7 = new ViewGroup.LayoutParams(-1, -2);
    L11:
        int r9 = r7.width;
        boolean r10 = true;
        if (r9 == (-2)) goto L16;
        if (r9 == 0) goto L16;
        boolean r11 = false;
    L17:
        int r12 = r7.height;
        if (r12 == (-1)) goto L22;
        if (r12 == 0) goto L22;
        r10 = false;
    L22:
        if (r11 == true) goto L26;
        if (r10 == false) goto L34;
    L26:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        ViewGroup.LayoutParams r13 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r7);
    L29:
        if (r11 == false) goto L31;
        r13.width = -1;
    L31:
        if (r10 == false) goto L33;
        r13.height = -2;
    L33:
        r6.setLayoutParams(r13);
        goto L34
    L28:
        r13 = new ViewGroup.LayoutParams(r7);
    L16:
        r11 = true;
    L34:
        r4 = r4 + 1;
        goto L3
    L35:
        int r3 = View.MeasureSpec.getMode(r20);
        int r8 = View.MeasureSpec.getSize(r20);
        int r14 = View.MeasureSpec.getMode(r21);
        int r15 = View.MeasureSpec.getSize(r21);
        int r16 = this.d;
        if (r16 <= 0) goto L38;
        r5 = RangesKt.coerceAtLeast((r16 - getPaddingTop()) - getPaddingBottom(), 0);
    L43:
        if (r3 == Integer.MIN_VALUE) goto L46;
        if (r3 == 1073741824) goto L46;
        int r17 = r20;
    L47:
        if (r5 < 0) goto L49;
        int r18 = View.MeasureSpec.makeMeasureSpec(r5, Integer.MIN_VALUE);
    L51:
        if (getChildCount() != 0) goto L63;
        int r19 = this.e;
        if (r19 <= 0) goto L57;
        if (r5 < 0) goto L56;
        int r22 = RangesKt.coerceAtMost(r19, (r5 + getPaddingTop()) + getPaddingBottom());
    L58:
        if (r3 == Integer.MIN_VALUE) goto L61;
        if (r3 == 1073741824) goto L61;
        r8 = getSuggestedMinimumWidth();
    L61:
        setMeasuredDimension(View.resolveSize(r8, r20), RangesKt.coerceAtLeast(r22, getSuggestedMinimumHeight()));
        FLogger.a.i("DialogContentHostView", "onMeasure host=" + r8 + 'x' + getMeasuredHeight() + ", widthSpec=" + View.MeasureSpec.toString(r20) + ", heightSpec=" + View.MeasureSpec.toString(r21) + ", bodyMaxHeightPx=" + this.d + ", contentHeightOverridePx=" + this.e + ", childCount=0");
        getMeasuredHeight();
        View.MeasureSpec.toString(r20);
        View.MeasureSpec.toString(r21);
        return;
    L56:
        r22 = r19;
        goto L58
    L57:
        r22 = 0;
        goto L58
    L63:
        super.onMeasure(r17, r18);
        int r23 = getSuggestedMinimumWidth();
        int r24 = getSuggestedMinimumHeight();
        int r110 = getChildCount();
        int r111 = 0;
    L64:
        Integer r112 = null;
        if (r111 >= r110) goto L103;
        View r113 = getChildAt(r111);
        if (r113 == null) goto L102;
        if (r113.getVisibility() == 8) goto L102;
        ViewGroup.LayoutParams r25 = r113.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L75;
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
    L76:
        if (r26 == null) goto L78;
        Integer r27 = Integer.valueOf(r26.leftMargin);
    L79:
        if (r27 == null) goto L81;
        int r28 = r27.intValue();
    L83:
        if (r26 == null) goto L85;
        Integer r29 = Integer.valueOf(r26.rightMargin);
    L86:
        if (r29 == null) goto L88;
        int r30 = r29.intValue();
    L89:
        int r31 = r28 + r30;
        if (r26 == null) goto L92;
        Integer r32 = Integer.valueOf(r26.topMargin);
    L93:
        if (r32 == null) goto L95;
        int r33 = r32.intValue();
    L96:
        if (r26 == null) goto L98;
        r112 = Integer.valueOf(r26.bottomMargin);
    L98:
        if (r112 == null) goto L100;
        int r34 = r112.intValue();
    L101:
        int r35 = r33 + r34;
        int r36 = Math.max(r23, ((r113.getMeasuredWidth() + r31) + getPaddingLeft()) + getPaddingRight());
        r24 = Math.max(r24, ((r113.getMeasuredHeight() + r35) + getPaddingTop()) + getPaddingBottom());
        r23 = r36;
        goto L102
    L100:
        r34 = 0;
        goto L101
    L95:
        r33 = 0;
        goto L96
    L92:
        r32 = null;
        goto L93
    L88:
        r30 = 0;
        goto L89
    L85:
        r29 = null;
        goto L86
    L81:
        r28 = 0;
        goto L83
    L78:
        r27 = null;
        goto L79
    L75:
        r26 = null;
    L102:
        r111 = r111 + 1;
        r8 = r8;
        goto L64
    L103:
        int r114 = r8;
        int r37 = this.e;
        if (r37 <= 0) goto L106;
        r24 = Math.max(r24, r37);
    L106:
        if (r5 < 0) goto L109;
        r24 = RangesKt.coerceAtMost(r24, (r5 + getPaddingTop()) + getPaddingBottom());
    L109:
        if (r3 != Integer.MIN_VALUE) goto L111;
    L113:
        int r38 = r114;
    L114:
        setMeasuredDimension(View.resolveSize(r38, r20), RangesKt.coerceAtLeast(r24, getSuggestedMinimumHeight()));
        if (getChildCount() <= 0) goto L157;
        StringBuilder r39 = new StringBuilder("childCount=");
        r39.append(getChildCount());
        r39.append(" [");
        int r40 = getChildCount();
        int r41 = 0;
    L117:
        if (r41 >= r40) goto L145;
        if (r41 <= 0) goto L120;
        r39.append("; ");
    L120:
        View r42 = getChildAt(r41);
        r39.append(r41);
        r39.append(":");
        if (r42 == null) goto L123;
        String r43 = r42.getClass().getSimpleName();
    L124:
        r39.append(r43);
        r39.append("=");
        if (r42 == null) goto L127;
        Integer r44 = Integer.valueOf(r42.getMeasuredWidth());
    L128:
        r39.append(r44);
        r39.append("x");
        if (r42 == null) goto L131;
        Integer r45 = Integer.valueOf(r42.getMeasuredHeight());
    L132:
        r39.append(r45);
        r39.append(" lp=");
        if (r42 == null) goto L137;
        ViewGroup.LayoutParams r46 = r42.getLayoutParams();
        if (r46 == null) goto L137;
        Integer r47 = Integer.valueOf(r46.width);
    L138:
        r39.append(r47);
        r39.append("x");
        if (r42 == null) goto L143;
        ViewGroup.LayoutParams r48 = r42.getLayoutParams();
        if (r48 == null) goto L143;
        Integer r49 = Integer.valueOf(r48.height);
    L144:
        r39.append(r49);
        r41 = r41 + 1;
    L143:
        r49 = null;
    L137:
        r47 = null;
        goto L138
    L131:
        r45 = null;
        goto L132
    L127:
        r44 = null;
        goto L128
    L123:
        r43 = null;
        goto L124
    L145:
        r39.append("]");
        String r50 = r39.toString();
        FLogger.a.i("DialogContentHostView", "onMeasure host=" + r38 + 'x' + getMeasuredHeight() + ", widthSpec=" + View.MeasureSpec.toString(r20) + ", heightSpec=" + View.MeasureSpec.toString(r21) + ", bodyMaxHeightPx=" + this.d + ", " + r50);
        getMeasuredHeight();
        View.MeasureSpec.toString(r20);
        View.MeasureSpec.toString(r21);
        return;
    L157:
        return;
    L111:
        if (r3 == 1073741824) goto L113;
        r38 = r23;
        goto L114
    L49:
        r18 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L46:
        r17 = View.MeasureSpec.makeMeasureSpec(r8, 1073741824);
        goto L47
    L38:
        if (r14 == 0) goto L43;
        if (r15 == 0) goto L43;
        r5 = RangesKt.coerceAtLeast((r15 - getPaddingTop()) - getPaddingBottom(), 0);
        goto L43
    }

    public h(Context r2, Function0 r3, y r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
