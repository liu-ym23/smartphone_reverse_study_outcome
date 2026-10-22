package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class SpareLayout extends FrameLayout {
    public int a;

    public SpareLayout(Context r1) {
        super(r1);
        this.a = 0;
    }

    public void setFirstViewMinWidth(int r1) {
        this.a = r1;
    }

    public SpareLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r22, int r23) {
        int r1 = r22;
        if (getChildCount() > 0) goto L6;
        super.onMeasure(r22, r23);
        return;
    L6:
        int r3 = View.MeasureSpec.getSize(r22);
        int r4 = getPaddingLeft() + getPaddingRight();
        int r5 = getPaddingTop() + getPaddingBottom();
        int r6 = r3 - r4;
        View r8 = getChildAt(0);
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8.getLayoutParams();
        int r10 = r9.leftMargin + r9.rightMargin;
        int r11 = r9.topMargin + r9.bottomMargin;
        ViewGroup.LayoutParams r12 = r8.getLayoutParams();
        if (r12 != null) goto L9;
    L12:
        int r13 = LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L13:
        int r14 = 8;
        if (this.a > 0) goto L16;
    L18:
        int r15 = Math.min(this.a, r8.getMeasuredWidth()) + r10;
        int r16 = 1;
        int r17 = 0;
        int r19 = 0;
    L20:
        if (r16 >= getChildCount()) goto L34;
        View r7 = getChildAt(r16);
        if (r7.getVisibility() != r14) goto L24;
        int r110 = r5;
        int r20 = r11;
    L33:
        r16 = r16 + 1;
        r1 = r22;
        r5 = r110;
        r11 = r20;
        r14 = 8;
        goto L20
    L24:
        measureChild(r7, r1, r23);
        FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) r7.getLayoutParams();
        int r112 = r111.leftMargin + r111.rightMargin;
        r110 = r5;
        int r2 = r111.topMargin + r111.bottomMargin;
        int r21 = r7.getMeasuredWidth() + r112;
        r20 = r11;
        if (this.a <= 0) goto L32;
        int r113 = r6 - r17;
        if ((r113 - r21) >= r15) goto L32;
        measureChild(r7, View.MeasureSpec.makeMeasureSpec((r113 - r15) - r111.leftMargin, 1073741824), r23);
        r17 = r17 + (r7.getMeasuredWidth() + r111.leftMargin);
        int r24 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        int r114 = r16 + 1;
    L30:
        if (r114 >= (getChildCount() - 1)) goto L35;
        measureChild(getChildAt(r114), r24, r23);
        r114 = r114 + 1;
    L35:
        int r25 = r19;
        if (r8.getVisibility() == 8) goto L38;
        measureChild(r8, View.MeasureSpec.makeMeasureSpec(((r3 - r17) - r10) - r4, r13), r23);
        int r115 = Math.max(r8.getMeasuredHeight() + r20, r25);
    L39:
        setMeasuredDimension(Math.min((r17 + r8.getMeasuredWidth()) + r4, r3), r115 + r110);
        return;
    L38:
        r115 = r25;
    L32:
        r17 = r17 + (r7.getMeasuredWidth() + r112);
        int r26 = r7.getMeasuredHeight() + r2;
        r19 = Math.max(r19, r26);
        goto L33
    L34:
        r110 = r5;
        r20 = r11;
        goto L35
    L16:
        if (r8.getVisibility() == 8) goto L18;
        measureChild(r8, r1, r23);
        goto L18
    L9:
        if (r12.width == (-2)) goto L12;
        r13 = 1073741824;
        goto L13
    }

    public SpareLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= getChildCount()) goto L22;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() == 8) goto L21;
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) r13.getLayoutParams();
        int r1 = (r0.leftMargin + r12) + getPaddingLeft();
        int r2 = r0.gravity & 112;
        if (r2 != 16) goto L11;
        int r3 = ((((((getPaddingTop() + r8) + r0.topMargin) + r10) - getPaddingBottom()) - r0.bottomMargin) - r13.getMeasuredHeight()) / 2;
    L19:
        int r4 = r3 - r8;
    L20:
        r13.layout(r1, r4, r13.getMeasuredWidth() + r1, r13.getMeasuredHeight() + r4);
        r12 = r12 + ((r13.getMeasuredWidth() + r0.leftMargin) + r0.rightMargin);
        goto L21
    L11:
        if (r2 != 48) goto L13;
        int r5 = r0.topMargin;
        int r14 = getPaddingTop();
    L17:
        r4 = r5 + r14;
        goto L20
    L13:
        if (r2 == 80) goto L15;
        r5 = r0.topMargin;
        r14 = getPaddingTop();
        goto L17
    L15:
        r3 = ((r10 - r0.bottomMargin) - getPaddingBottom()) - r13.getMeasuredHeight();
    L21:
        r11 = r11 + 1;
        goto L4
    }
}
