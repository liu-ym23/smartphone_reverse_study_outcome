package com.ss.android.lark.inline.ai.creationai;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.MarginLayoutParamsCompat;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ g0 a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.l.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int r0 = cu5.c.d();
        if (this.a.j.getVisibility() != 0) goto L9;
        int r1 = this.a.j.getWidth();
        ViewGroup.LayoutParams r3 = this.a.j.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        int r4 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r3);
    L8:
        int r2 = r1 + r4;
    L11:
        if (this.a.k.getVisibility() != 0) goto L17;
        int r5 = this.a.k.getWidth();
        ViewGroup.LayoutParams r6 = this.a.k.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        int r7 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r6);
    L16:
        int r8 = r5 + r7;
    L18:
        int r9 = (((r0 - r2) - r8) - this.a.l.getPaddingStart()) - this.a.l.getPaddingEnd();
        this.a.l.setMaxWidth(RangesKt.coerceAtLeast(r9, 0));
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

    public h0(g0 r1) {
        this.a = r1;
    }
}
