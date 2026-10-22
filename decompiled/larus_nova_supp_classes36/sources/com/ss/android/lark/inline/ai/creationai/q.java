package com.ss.android.lark.inline.ai.creationai;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.MarginLayoutParamsCompat;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ CreationAIPanelController a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.o.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int r0 = cu5.c.d();
        if (this.a.l.getVisibility() != 0) goto L9;
        int r1 = this.a.l.getWidth();
        ViewGroup.LayoutParams r3 = this.a.l.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        int r4 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r3);
    L8:
        int r2 = r1 + r4;
    L11:
        if (this.a.m.getVisibility() != 0) goto L17;
        int r5 = this.a.m.getWidth();
        ViewGroup.LayoutParams r6 = this.a.m.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        int r7 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r6);
    L16:
        int r8 = r5 + r7;
    L18:
        int r9 = (((r0 - r2) - r8) - this.a.o.getPaddingStart()) - this.a.o.getPaddingEnd();
        this.a.o.setMaxWidth(RangesKt.coerceAtLeast(r9, 0));
        return;
    L15:
        r7 = 0;
        goto L16
    L17:
        r8 = 0;
        goto L18
    L7:
        r4 = 0;
        goto L8
    L9:
        r2 = 0;
        goto L11
    }

    public q(CreationAIPanelController r1) {
        this.a = r1;
    }
}
