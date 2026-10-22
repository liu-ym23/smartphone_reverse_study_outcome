package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w5 extends com.lynx.tasm.behavior.ui.view.a {
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

    public w5(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r1 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        int r2 = RangesKt.coerceAtLeast(getSuggestedMinimumWidth(), 0);
        int r3 = RangesKt.coerceAtLeast(getSuggestedMinimumHeight(), 0);
        if (r0 == Integer.MIN_VALUE) goto L6;
        if (r0 == 1073741824) goto L7;
        r9 = r2;
    L7:
        if (r1 == Integer.MIN_VALUE) goto L10;
        if (r1 == 1073741824) goto L11;
        r10 = r3;
    L11:
        setMeasuredDimension(r9, r10);
        return;
    L10:
        r10 = RangesKt.coerceAtMost(r3, r10);
        goto L11
    L6:
        r9 = RangesKt.coerceAtMost(r2, r9);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        int r6 = getChildCount();
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L8;
        View r8 = getChildAt(r7);
        if (r8 == null) goto L7;
        r8.layout(0, 0, 0, 0);
    L7:
        r7 = r7 + 1;
        goto L3
    }
}
