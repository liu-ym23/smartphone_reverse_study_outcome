package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3335c;

    public BaselineLayout(Context r10) {
        super(r10, null, 0);
        this.f3335c = -1;
    }

    public BaselineLayout(Context r10, AttributeSet r11) {
        super(r10, r11, 0);
        this.f3335c = -1;
    }

    public BaselineLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f3335c = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f3335c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = getPaddingLeft();
        int r17 = ((r13 - r11) - getPaddingRight()) - r16;
        int r18 = getPaddingTop();
        int r19 = 0;
    L3:
        if (r19 >= r15) goto L15;
        View r20 = getChildAt(r19);
        if (r20.getVisibility() == 8) goto L14;
        int r21 = r20.getMeasuredWidth();
        int r22 = r20.getMeasuredHeight();
        int r23 = ((r17 - r21) / 2) + r16;
        if (this.f3335c != (-1)) goto L10;
    L12:
        int r24 = r18;
    L13:
        r20.layout(r23, r24, r21 + r23, r22 + r24);
        goto L14
    L10:
        if (r20.getBaseline() == (-1)) goto L12;
        r24 = (this.f3335c + r18) - r20.getBaseline();
    L14:
        r19 = r19 + 1;
        goto L3
    }

    @Override // android.view.View
    protected void onMeasure(int r12, int r13) {
        int r10 = getChildCount();
        int r11 = 0;
        int r14 = -1;
        int r15 = -1;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r11 >= r10) goto L12;
        View r19 = getChildAt(r11);
        if (r19.getVisibility() == 8) goto L11;
        measureChild(r19, r12, r13);
        int r20 = r19.getBaseline();
        if (r20 == (-1)) goto L10;
        r14 = Math.max(r14, r20);
        r15 = Math.max(r15, r19.getMeasuredHeight() - r20);
    L10:
        r17 = Math.max(r17, r19.getMeasuredWidth());
        r16 = Math.max(r16, r19.getMeasuredHeight());
        r18 = View.combineMeasuredStates(r18, r19.getMeasuredState());
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        if (r14 == (-1)) goto L14;
        r16 = Math.max(r16, Math.max(r15, getPaddingBottom()) + r14);
        this.f3335c = r14;
    L14:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r17, getSuggestedMinimumWidth()), r12, r18), View.resolveSizeAndState(Math.max(r16, getSuggestedMinimumHeight()), r13, r18 << 16));
    }
}
