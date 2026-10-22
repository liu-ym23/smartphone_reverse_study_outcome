package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4815a;

    public BaselineLayout(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        this.f4815a = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f4815a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        int r15 = getPaddingLeft();
        int r16 = ((r12 - r10) - getPaddingRight()) - r15;
        int r17 = getPaddingTop();
        int r18 = 0;
    L3:
        if (r18 >= r14) goto L15;
        View r19 = getChildAt(r18);
        if (r19.getVisibility() == 8) goto L14;
        int r20 = r19.getMeasuredWidth();
        int r21 = r19.getMeasuredHeight();
        int r22 = ((r16 - r20) / 2) + r15;
        if (this.f4815a != (-1)) goto L10;
    L12:
        int r23 = r17;
    L13:
        r19.layout(r22, r23, r20 + r22, r21 + r23);
        goto L14
    L10:
        if (r19.getBaseline() == (-1)) goto L12;
        r23 = (this.f4815a + r17) - r19.getBaseline();
    L14:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    public final void onMeasure(int r12, int r13) {
        int r8 = getChildCount();
        int r10 = 0;
        int r11 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = -1;
        int r17 = -1;
    L3:
        if (r10 >= r8) goto L12;
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
        this.f4815a = r16;
    L14:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r14, getSuggestedMinimumWidth()), r12, r15), View.resolveSizeAndState(Math.max(r11, getSuggestedMinimumHeight()), r13, r15 << 16));
    }
}
