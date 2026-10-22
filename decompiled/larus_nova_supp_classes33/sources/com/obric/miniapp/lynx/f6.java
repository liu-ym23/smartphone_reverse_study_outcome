package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f6 extends FrameLayout {
    public int a;

    public f6(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r9) {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
    L36:
        super.onMeasure(r8, r9);
        return;
    L5:
        if (r1.getVisibility() == 8) goto L36;
        int r2 = View.MeasureSpec.getMode(r8);
        int r3 = View.MeasureSpec.getSize(r8);
        if (r2 != 0) goto L10;
        int r4 = 0;
    L11:
        int r5 = this.a;
        if (r5 <= 0) goto L14;
        int r6 = RangesKt.coerceAtLeast((r5 - getPaddingTop()) - getPaddingBottom(), 0);
    L15:
        if (r2 != 0) goto L17;
        int r7 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L18:
        if (r6 < 0) goto L20;
        int r0 = View.MeasureSpec.makeMeasureSpec(r6, Integer.MIN_VALUE);
    L21:
        r1.measure(r7, r0);
        if (r2 != 0) goto L24;
        r3 = (r1.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
    L24:
        int r10 = (r1.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r6 < 0) goto L27;
        r10 = RangesKt.coerceAtMost(r10, this.a);
    L27:
        setMeasuredDimension(r3, RangesKt.coerceAtLeast(r10, getSuggestedMinimumHeight()));
        String r11 = r1.getClass().getSimpleName();
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("onMeasure self=");
        r13.append(getMeasuredWidth());
        r13.append('x');
        r13.append(r10);
        r13.append(", widthSpec=");
        r13.append(View.MeasureSpec.toString(r8));
        r13.append(", heightSpec=");
        r13.append(View.MeasureSpec.toString(r9));
        r13.append(", bodyMaxHeightPx=");
        r13.append(this.a);
        r13.append(", child=");
        r13.append(r11);
        r13.append(':');
        r13.append(r1.getMeasuredWidth());
        r13.append('x');
        r13.append(r1.getMeasuredHeight());
        r13.append(" lp=");
        ViewGroup.LayoutParams r14 = r1.getLayoutParams();
        Integer r15 = null;
        if (r14 == null) goto L30;
        Integer r16 = Integer.valueOf(r14.width);
    L31:
        r13.append(r16);
        r13.append('x');
        ViewGroup.LayoutParams r17 = r1.getLayoutParams();
        if (r17 == null) goto L34;
        r15 = Integer.valueOf(r17.height);
    L34:
        r13.append(r15);
        r12.i("SheetBodyContainerView", r13.toString());
        getMeasuredWidth();
        View.MeasureSpec.toString(r8);
        View.MeasureSpec.toString(r9);
        r1.getMeasuredWidth();
        r1.getMeasuredHeight();
        r1.getLayoutParams();
        r1.getLayoutParams();
        return;
    L30:
        r16 = null;
        goto L31
    L20:
        r0 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L21
    L17:
        r7 = View.MeasureSpec.makeMeasureSpec(r4, 1073741824);
        goto L18
    L14:
        r6 = -1;
        goto L15
    L10:
        r4 = RangesKt.coerceAtLeast((r3 - getPaddingLeft()) - getPaddingRight(), 0);
        goto L11
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        View r6 = getChildAt(0);
        if (r6 != null) goto L5;
        return;
    L5:
        int r7 = getPaddingLeft();
        int r8 = getPaddingTop();
        r6.layout(r7, r8, (r4 - r2) - getPaddingRight(), r6.getMeasuredHeight() + r8);
    }
}
