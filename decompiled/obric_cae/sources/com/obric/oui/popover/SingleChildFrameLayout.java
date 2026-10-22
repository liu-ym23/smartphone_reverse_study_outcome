package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleChildFrameLayout extends OUIFrameLayout {
    public SingleChildFrameLayout(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0, 12);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        View r11 = getChildAt(0);
        if (r11 == null) goto L14;
        int r12 = View.MeasureSpec.getMode(r8);
        int r13 = View.MeasureSpec.getSize(r8);
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        int r16 = r11.getMeasuredWidth();
        int r17 = getPaddingLeft() + r16;
        int r18 = getPaddingRight() + r17;
        int r19 = r11.getMeasuredHeight();
        int r20 = getPaddingTop() + r19;
        int r21 = getPaddingBottom() + r20;
        if (r12 != Integer.MIN_VALUE) goto L8;
        if (r14 != Integer.MIN_VALUE) goto L8;
        setMeasuredDimension(r18, r21);
        return;
    L8:
        if (r12 != Integer.MIN_VALUE) goto L10;
        setMeasuredDimension(r18, r15);
        return;
    L10:
        if (r14 != Integer.MIN_VALUE) goto L12;
        setMeasuredDimension(r13, r21);
        return;
    L12:
        setMeasuredDimension(r13, r15);
        return;
    }
}
