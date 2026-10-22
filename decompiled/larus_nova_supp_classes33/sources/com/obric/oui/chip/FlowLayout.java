package com.obric.oui.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class FlowLayout extends ViewGroup {
    public int a;
    public int b;
    public boolean c;
    public int d;

    public int getItemSpacing() {
        return this.b;
    }

    public int getLineSpacing() {
        return this.a;
    }

    public int getRowCount() {
        return this.d;
    }

    public FlowLayout(Context r2) {
        this(r2, null);
    }

    public void setItemSpacing(int r1) {
        this.b = r1;
    }

    public void setLineSpacing(int r1) {
        this.a = r1;
    }

    public void setSingleLine(boolean r1) {
        this.c = r1;
    }

    public FlowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r20, int r21) {
        int r1 = View.MeasureSpec.getSize(r20);
        int r2 = View.MeasureSpec.getMode(r20);
        int r3 = View.MeasureSpec.getSize(r21);
        int r4 = View.MeasureSpec.getMode(r21);
        if (r2 == Integer.MIN_VALUE) goto L7;
        if (r2 == 1073741824) goto L7;
        int r7 = Integer.MAX_VALUE;
    L8:
        int r8 = getPaddingLeft();
        int r9 = getPaddingTop();
        int r10 = r7 - getPaddingRight();
        int r11 = r9;
        int r12 = 0;
        int r13 = 0;
    L10:
        if (r12 >= getChildCount()) goto L30;
        View r14 = getChildAt(r12);
        if (r14.getVisibility() == 8) goto L29;
        measureChild(r14, r20, r21);
        ViewGroup.LayoutParams r6 = r14.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r6;
        int r16 = r15.leftMargin + 0;
        int r17 = r15.rightMargin + 0;
    L19:
        if (((r8 + r16) + r14.getMeasuredWidth()) > r10) goto L21;
    L23:
        int r5 = (r8 + r16) + r14.getMeasuredWidth();
        r9 = r14.getMeasuredHeight() + r11;
        if (r5 <= r13) goto L26;
        r13 = r5;
    L26:
        r8 = r8 + (((r16 + r17) + r14.getMeasuredWidth()) + this.b);
        if (r12 != (getChildCount() - 1)) goto L29;
        r13 = r13 + r17;
        goto L29
    L21:
        if (this.c == true) goto L23;
        r8 = getPaddingLeft();
        r11 = this.a + r9;
        goto L23
    L17:
        r17 = 0;
        r16 = 0;
    L29:
        r12 = r12 + 1;
        goto L10
    L30:
        int r18 = r13 + getPaddingRight();
        int r19 = r9 + getPaddingBottom();
        if (r2 == Integer.MIN_VALUE) goto L35;
        int r22 = 1073741824;
        if (r2 == 1073741824) goto L36;
        r1 = r18;
    L36:
        if (r4 == Integer.MIN_VALUE) goto L39;
        if (r4 == r22) goto L40;
        r3 = r19;
    L40:
        setMeasuredDimension(r1, r3);
        return;
    L39:
        r3 = Math.min(r19, r3);
        goto L40
    L35:
        r22 = 1073741824;
        r1 = Math.min(r18, r1);
    L7:
        r7 = r1;
        goto L8
    }

    public FlowLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.c = false;
        TypedArray r5 = r2.getTheme().obtainStyledAttributes(r3, new int[]{2130973186, 2130973202}, 0, 0);
        this.a = r5.getDimensionPixelSize(1, 0);
        this.b = r5.getDimensionPixelSize(0, 0);
        r5.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        if (getChildCount() != 0) goto L6;
        this.d = 0;
        return;
    L6:
        this.d = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r16 = true;
    L10:
        if (r16 == false) goto L12;
        int r0 = getPaddingRight();
    L13:
        if (r16 == false) goto L15;
        int r1 = getPaddingLeft();
    L16:
        int r2 = getPaddingTop();
        int r17 = (r14 - r12) - r1;
        int r3 = r0;
        int r18 = r2;
        int r4 = 0;
    L18:
        if (r4 >= getChildCount()) goto L36;
        View r5 = getChildAt(r4);
        if (r5.getVisibility() != 8) goto L22;
        r5.setTag(2131384870, -1);
    L35:
        r4 = r4 + 1;
        goto L18
    L22:
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        int r8 = MarginLayoutParamsCompat.getMarginStart(r7);
        int r9 = MarginLayoutParamsCompat.getMarginEnd(r7);
    L26:
        int r10 = (r3 + r8) + r5.getMeasuredWidth();
        if (this.c == true) goto L30;
        if (r10 <= r17) goto L30;
        r18 = this.a + r2;
        this.d++;
        r3 = r0;
    L30:
        r5.setTag(2131384870, Integer.valueOf(this.d - 1));
        int r19 = r3 + r8;
        int r20 = r5.getMeasuredWidth() + r19;
        int r21 = r5.getMeasuredHeight() + r18;
        if (r16 == false) goto L33;
        r5.layout(r17 - r20, r18, (r17 - r3) - r8, r21);
    L34:
        r3 = r3 + (((r8 + r9) + r5.getMeasuredWidth()) + this.b);
        r2 = r21;
        goto L35
    L33:
        r5.layout(r19, r18, r20, r21);
        goto L34
    L25:
        r9 = 0;
        r8 = 0;
        goto L26
    L36:
        return;
    L15:
        r1 = getPaddingRight();
        goto L16
    L12:
        r0 = getPaddingLeft();
        goto L13
    L9:
        r16 = false;
        goto L10
    }
}
