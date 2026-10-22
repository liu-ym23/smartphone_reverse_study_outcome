package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e extends FrameLayout {
    public int a;
    public final d b;

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() > 0) goto L7;
        return;
    L7:
        if (isInLayout() == true) goto L12;
        removeCallbacks(this.b);
        post(this.b);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.miniapp.lynx.d] */
    public e(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        this.b = new d(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r9, int r10) {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
    L28:
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), r9), View.resolveSize(Math.max(getSuggestedMinimumHeight(), this.a), r10));
        return;
    L5:
        if (r1.getVisibility() == 8) goto L28;
        int r2 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        int r3 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r4 = Math.max(getSuggestedMinimumHeight(), this.a);
        if (r2 == Integer.MIN_VALUE) goto L11;
        if (r2 == 1073741824) goto L11;
        r11 = Math.max(getSuggestedMinimumWidth(), (r1.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
    L11:
        if (r3 != 1073741824) goto L14;
        if (r12 != 0) goto L14;
    L21:
        r12 = r4;
    L22:
        int r5 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (r11 - getPaddingLeft()) - getPaddingRight()), 1073741824);
        if (r1.getLayoutParams().height != (-2)) goto L25;
        int r0 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L26:
        r1.measure(r5, r0);
        setMeasuredDimension(r11, r12);
        return;
    L25:
        r0 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (r12 - getPaddingTop()) - getPaddingBottom()), 1073741824);
    L14:
        if (r3 == 1073741824) goto L22;
        if (r3 != Integer.MIN_VALUE) goto L19;
        if (r12 == 0) goto L21;
    L19:
        if (r3 != Integer.MIN_VALUE) goto L21;
        r12 = Math.min(r4, r12);
        goto L22
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        View r7 = getChildAt(0);
        if (r7 != null) goto L5;
        return;
    L5:
        int r8 = getPaddingTop() + r7.getMeasuredHeight();
        r7.layout(getPaddingLeft(), getPaddingTop(), (r5 - r3) - getPaddingRight(), r8);
    }
}
