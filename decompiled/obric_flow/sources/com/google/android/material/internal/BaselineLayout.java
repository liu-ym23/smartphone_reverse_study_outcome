package com.google.android.material.internal;

import ai.j0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class BaselineLayout extends ViewGroup {
    private int baseline;

    public BaselineLayout(Context r5) {
        super(r5, null, 0);
        this.baseline = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.baseline;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = getPaddingLeft();
        int r17 = ((r13 - r11) - getPaddingRight()) - r16;
        int r18 = getPaddingTop();
        int r19 = 0;
    L3:
        if (r19 >= r15) goto L15;
        View r5 = getChildAt(r19);
        if (r5.getVisibility() == 8) goto L14;
        int r20 = r5.getMeasuredWidth();
        int r21 = r5.getMeasuredHeight();
        int r22 = j0.c(r17, r20, 2, r16);
        if (this.baseline != (-1)) goto L10;
    L12:
        int r23 = r18;
    L13:
        r5.layout(r22, r23, r20 + r22, r21 + r23);
        goto L14
    L10:
        if (r5.getBaseline() == (-1)) goto L12;
        r23 = (this.baseline + r18) - r5.getBaseline();
    L14:
        r19 = r19 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        int r5 = getChildCount();
        int r10 = 0;
        int r11 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = -1;
        int r17 = -1;
    L3:
        if (r10 >= r5) goto L12;
        View r18 = getChildAt(r10);
        if (r18.getVisibility() == 8) goto L11;
        measureChild(r18, r12, r13);
        int r19 = r18.getBaseline();
        if (r19 == (-1)) goto L10;
        r16 = Math.max(r16, r19);
        r17 = Math.max(r17, r18.getMeasuredHeight() - r19);
    L10:
        r14 = Math.max(r14, r18.getMeasuredWidth());
        r11 = Math.max(r11, r18.getMeasuredHeight());
        r15 = View.combineMeasuredStates(r15, r18.getMeasuredState());
    L11:
        r10 = r10 + 1;
        goto L3
    L12:
        if (r16 == (-1)) goto L14;
        r11 = Math.max(r11, Math.max(r17, getPaddingBottom()) + r16);
        this.baseline = r16;
    L14:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r14, getSuggestedMinimumWidth()), r12, r15), View.resolveSizeAndState(Math.max(r11, getSuggestedMinimumHeight()), r13, r15 << 16));
    }

    public BaselineLayout(Context r5, AttributeSet r10) {
        super(r5, r10, 0);
        this.baseline = -1;
    }

    public BaselineLayout(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.baseline = -1;
    }
}
