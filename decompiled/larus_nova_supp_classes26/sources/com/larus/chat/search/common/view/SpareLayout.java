package com.larus.chat.search.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class SpareLayout extends FrameLayout {
    public SpareLayout(Context r1) {
        super(r1);
    }

    public SpareLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        if (getChildCount() > 0) goto L6;
        super.onMeasure(r11, r12);
        return;
    L6:
        int r0 = View.MeasureSpec.getSize(r11);
        int r1 = getChildCount() - 1;
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r1 <= 0) goto L14;
        View r6 = getChildAt(r1);
        if (r6.getVisibility() == 8) goto L13;
        measureChild(r6, r11, r12);
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r6.getLayoutParams();
        int r7 = r5.leftMargin + r5.rightMargin;
        int r8 = r5.topMargin + r5.bottomMargin;
        r3 = r3 + (r6.getMeasuredWidth() + r7);
        r4 = Math.max(r4, r6.getMeasuredHeight() + r8);
    L13:
        r1 = r1 - 1;
        goto L8
    L14:
        View r13 = getChildAt(0);
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r13.getLayoutParams();
        int r9 = r2.leftMargin + r2.rightMargin;
        int r10 = r2.topMargin + r2.bottomMargin;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 != null) goto L17;
    L20:
        int r15 = Integer.MIN_VALUE;
    L21:
        int r16 = getPaddingLeft() + getPaddingRight();
        int r17 = getPaddingTop() + getPaddingBottom();
        if (r13.getVisibility() == 8) goto L24;
        measureChild(r13, View.MeasureSpec.makeMeasureSpec(((r0 - r3) - r9) - r16, r15), r12);
        r4 = Math.max(r13.getMeasuredHeight() + r10, r4);
    L24:
        setMeasuredDimension((r3 + r13.getMeasuredWidth()) + r16, r4 + r17);
        return;
    L17:
        if (r14.width == (-2)) goto L20;
        r15 = 1073741824;
        goto L21
    }

    public SpareLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        int r14 = 0;
        int r15 = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r16 = true;
    L6:
        int r0 = getChildCount();
        if (r16 == false) goto L9;
        int r17 = r0 - 1;
        r15 = -1;
    L10:
        int r1 = 0;
    L11:
        if (r14 >= r0) goto L29;
        View r2 = getChildAt((r15 * r14) + r17);
        if (r2.getVisibility() == 8) goto L28;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2.getLayoutParams();
        int r4 = (r3.leftMargin + r1) + getPaddingLeft();
        int r5 = r3.gravity & 112;
        if (r5 != 16) goto L18;
        int r6 = ((((((getPaddingTop() + r11) + r3.topMargin) + r13) - getPaddingBottom()) - r3.bottomMargin) - r2.getMeasuredHeight()) / 2;
    L26:
        int r7 = r6 - r11;
    L27:
        r2.layout(r4, r7, r2.getMeasuredWidth() + r4, r2.getMeasuredHeight() + r7);
        r1 = r1 + ((r2.getMeasuredWidth() + r3.leftMargin) + r3.rightMargin);
        goto L28
    L18:
        if (r5 != 48) goto L20;
        int r8 = r3.topMargin;
        int r18 = getPaddingTop();
    L24:
        r7 = r8 + r18;
        goto L27
    L20:
        if (r5 == 80) goto L22;
        r8 = r3.topMargin;
        r18 = getPaddingTop();
        goto L24
    L22:
        r6 = ((r13 - r3.bottomMargin) - getPaddingBottom()) - r2.getMeasuredHeight();
    L28:
        r14 = r14 + 1;
        goto L11
    L29:
        return;
    L9:
        r17 = 0;
        goto L10
    L5:
        r16 = false;
        goto L6
    }
}
