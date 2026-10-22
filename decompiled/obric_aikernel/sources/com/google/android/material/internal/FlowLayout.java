package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3336c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3339i;

    public FlowLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public FlowLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public FlowLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f3338h = false;
        d(r10, r11);
    }

    private static int a(int r10, int r11, int r12) {
        if (r11 == Integer.MIN_VALUE) goto L9;
        if (r11 == 1073741824) goto L7;
        return r12;
    L7:
        return r10;
    L9:
        return Math.min(r12, r10);
    }

    private void d(@NonNull Context r10, @Nullable AttributeSet r11) {
        TypedArray r12 = r10.getTheme().obtainStyledAttributes(r11, q5.l.FlowLayout, 0, 0);
        this.f3336c = r12.getDimensionPixelSize(q5.l.FlowLayout_lineSpacing, 0);
        this.f3337g = r12.getDimensionPixelSize(q5.l.FlowLayout_itemSpacing, 0);
        r12.recycle();
    }

    public int b(@NonNull View r10) {
        Object r11 = r10.getTag(q5.f.row_index_key);
        if ((r11 instanceof Integer) == true) goto L7;
        return -1;
    L7:
        return ((Integer) r11).intValue();
    }

    public boolean c() {
        return this.f3338h;
    }

    protected int getItemSpacing() {
        return this.f3337g;
    }

    protected int getLineSpacing() {
        return this.f3336c;
    }

    protected int getRowCount() {
        return this.f3339i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (getChildCount() != 0) goto L6;
        this.f3339i = 0;
        return;
    L6:
        this.f3339i = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L12;
        int r16 = getPaddingRight();
    L13:
        if (r15 == false) goto L15;
        int r17 = getPaddingLeft();
    L16:
        int r18 = getPaddingTop();
        int r19 = (r13 - r11) - r17;
        int r20 = 0;
        int r21 = r16;
        int r110 = r18;
    L18:
        if (r20 >= getChildCount()) goto L35;
        View r22 = getChildAt(r20);
        if (r22.getVisibility() != 8) goto L22;
        r22.setTag(q5.f.row_index_key, -1);
    L34:
        r20 = r20 + 1;
        goto L18
    L22:
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        int r25 = MarginLayoutParamsCompat.getMarginStart(r24);
        int r26 = MarginLayoutParamsCompat.getMarginEnd(r24);
    L26:
        int r27 = (r21 + r25) + r22.getMeasuredWidth();
        if (this.f3338h == true) goto L30;
        if (r27 <= r19) goto L30;
        r110 = this.f3336c + r18;
        this.f3339i++;
        r21 = r16;
    L30:
        r22.setTag(q5.f.row_index_key, Integer.valueOf(this.f3339i - 1));
        int r28 = r21 + r25;
        int r29 = r22.getMeasuredWidth() + r28;
        int r30 = r22.getMeasuredHeight() + r110;
        if (r15 == false) goto L33;
        r28 = r19 - r29;
        r29 = (r19 - r21) - r25;
    L33:
        r22.layout(r28, r110, r29, r30);
        r21 = r21 + (((r25 + r26) + r22.getMeasuredWidth()) + this.f3337g);
        r18 = r30;
        goto L34
    L25:
        r26 = 0;
        r25 = 0;
        goto L26
    L35:
        return;
    L15:
        r17 = getPaddingRight();
        goto L16
    L12:
        r16 = getPaddingLeft();
        goto L13
    L9:
        r15 = false;
        goto L10
    }

    @Override // android.view.View
    protected void onMeasure(int r21, int r22) {
        int r10 = View.MeasureSpec.getSize(r21);
        int r11 = View.MeasureSpec.getMode(r21);
        int r12 = View.MeasureSpec.getSize(r22);
        int r13 = View.MeasureSpec.getMode(r22);
        if (r11 != Integer.MIN_VALUE) goto L5;
    L8:
        int r14 = r10;
    L9:
        int r15 = getPaddingLeft();
        int r16 = getPaddingTop();
        int r17 = r14 - getPaddingRight();
        int r18 = r16;
        int r19 = 0;
        int r110 = 0;
    L11:
        if (r19 >= getChildCount()) goto L33;
        View r111 = getChildAt(r19);
        if (r111.getVisibility() == 8) goto L32;
        measureChild(r111, r21, r22);
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r20 = r113.leftMargin + 0;
        int r114 = r113.rightMargin + 0;
    L19:
        int r115 = r15;
        if (((r15 + r20) + r111.getMeasuredWidth()) > r17) goto L22;
    L24:
        int r23 = r115;
    L25:
        int r24 = (r23 + r20) + r111.getMeasuredWidth();
        int r116 = r18 + r111.getMeasuredHeight();
        if (r24 <= r110) goto L28;
        r110 = r24;
    L28:
        r15 = r23 + (((r20 + r114) + r111.getMeasuredWidth()) + this.f3337g);
        if (r19 != (getChildCount() - 1)) goto L31;
        r110 = r110 + r114;
    L31:
        r16 = r116;
        goto L32
    L22:
        if (c() == true) goto L24;
        r23 = getPaddingLeft();
        r18 = this.f3336c + r16;
        goto L25
    L18:
        r20 = 0;
        r114 = 0;
    L32:
        r19 = r19 + 1;
        goto L11
    L33:
        setMeasuredDimension(a(r10, r11, r110 + getPaddingRight()), a(r12, r13, r16 + getPaddingBottom()));
        return;
    L5:
        if (r11 == 1073741824) goto L8;
        r14 = Integer.MAX_VALUE;
        goto L9
    }

    protected void setItemSpacing(int r10) {
        this.f3337g = r10;
    }

    protected void setLineSpacing(int r10) {
        this.f3336c = r10;
    }

    public void setSingleLine(boolean r10) {
        this.f3338h = r10;
    }
}
