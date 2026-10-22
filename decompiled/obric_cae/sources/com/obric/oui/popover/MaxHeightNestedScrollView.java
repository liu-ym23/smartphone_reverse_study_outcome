package com.obric.oui.popover;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class MaxHeightNestedScrollView extends NestedScrollView {
    public final int N;

    public MaxHeightNestedScrollView(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.N = Integer.MAX_VALUE;
        if (r10 == null) goto L6;
        TypedArray r11 = r8.obtainStyledAttributes(r10, new int[]{R.attr.maxHeight});
        i.e(r11, "context.obtainStyledAttr…ndroid.R.attr.maxHeight))");
        this.N = r11.getDimensionPixelSize(0, Integer.MAX_VALUE);
        r11.recycle();
        return;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        int r11 = this.N;
        if (r11 == Integer.MAX_VALUE) goto L8;
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        if (r13 <= r11) goto L7;
        r13 = r11;
    L7:
        r10 = View.MeasureSpec.makeMeasureSpec(r13, r12);
    L8:
        super.onMeasure(r8, r10);
        if (getMeasuredHeight() <= r11) goto L12;
        setMeasuredDimension(getMeasuredWidth(), r11);
        return;
    }
}
