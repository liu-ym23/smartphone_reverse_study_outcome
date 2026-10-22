package com.google.android.material.internal;

import android.annotation.TargetApi;
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
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(@NonNull Context r5) {
        this(r5, null);
    }

    private static int getMeasuredDimension(int r5, int r10, int r11) {
        if (r10 == Integer.MIN_VALUE) goto L9;
        if (r10 == 1073741824) goto L7;
        return r11;
    L7:
        return r5;
    L9:
        return Math.min(r11, r5);
    }

    private void loadFromAttributes(@NonNull Context r5, @Nullable AttributeSet r10) {
        TypedArray r11 = r5.getTheme().obtainStyledAttributes(r10, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = r11.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = r11.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        r11.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(@NonNull View r5) {
        Object r10 = r5.getTag(R.id.row_index_key);
        if ((r10 instanceof Integer) == true) goto L7;
        return -1;
    L7:
        return ((Integer) r10).intValue();
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (getChildCount() != 0) goto L6;
        this.rowCount = 0;
        return;
    L6:
        this.rowCount = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L12;
        int r5 = getPaddingRight();
    L13:
        if (r15 == false) goto L15;
        int r16 = getPaddingLeft();
    L16:
        int r17 = getPaddingTop();
        int r18 = (r13 - r11) - r16;
        int r19 = 0;
        int r20 = r5;
        int r110 = r17;
    L18:
        if (r19 >= getChildCount()) goto L36;
        View r21 = getChildAt(r19);
        if (r21.getVisibility() != 8) goto L22;
        r21.setTag(R.id.row_index_key, -1);
    L35:
        r19 = r19 + 1;
        goto L18
    L22:
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        int r24 = MarginLayoutParamsCompat.getMarginStart(r23);
        int r25 = MarginLayoutParamsCompat.getMarginEnd(r23);
    L26:
        int r26 = r21.getMeasuredWidth() + (r20 + r24);
        if (this.singleLine == true) goto L30;
        if (r26 <= r18) goto L30;
        r110 = this.lineSpacing + r17;
        this.rowCount++;
        r20 = r5;
    L30:
        r21.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
        int r27 = r20 + r24;
        int r28 = r21.getMeasuredWidth() + r27;
        int r29 = r21.getMeasuredHeight() + r110;
        if (r15 == false) goto L33;
        r21.layout(r18 - r28, r110, (r18 - r20) - r24, r29);
    L34:
        r20 = r20 + ((r21.getMeasuredWidth() + (r24 + r25)) + this.itemSpacing);
        r17 = r29;
        goto L35
    L33:
        r21.layout(r27, r110, r28, r29);
        goto L34
    L25:
        r25 = 0;
        r24 = 0;
        goto L26
    L36:
        return;
    L15:
        r16 = getPaddingRight();
        goto L16
    L12:
        r5 = getPaddingLeft();
        goto L13
    L9:
        r15 = false;
        goto L10
    }

    @Override // android.view.View
    public void onMeasure(int r20, int r21) {
        int r5 = View.MeasureSpec.getSize(r20);
        int r10 = View.MeasureSpec.getMode(r20);
        int r11 = View.MeasureSpec.getSize(r21);
        int r12 = View.MeasureSpec.getMode(r21);
        if (r10 != Integer.MIN_VALUE) goto L5;
    L8:
        int r13 = r5;
    L9:
        int r14 = getPaddingLeft();
        int r15 = getPaddingTop();
        int r16 = r13 - getPaddingRight();
        int r17 = r15;
        int r18 = 0;
        int r19 = 0;
    L11:
        if (r18 >= getChildCount()) goto L33;
        View r110 = getChildAt(r18);
        if (r110.getVisibility() == 8) goto L32;
        measureChild(r110, r20, r21);
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        int r22 = r112.leftMargin;
        int r113 = r112.rightMargin;
    L19:
        int r114 = r14;
        if ((r110.getMeasuredWidth() + (r14 + r22)) > r16) goto L22;
    L24:
        int r23 = r114;
    L25:
        int r24 = r110.getMeasuredWidth() + (r23 + r22);
        int r115 = r110.getMeasuredHeight() + r17;
        if (r24 <= r19) goto L28;
        r19 = r24;
    L28:
        int r25 = ((r110.getMeasuredWidth() + (r22 + r113)) + this.itemSpacing) + r23;
        if (r18 != (getChildCount() - 1)) goto L31;
        r19 = r19 + r113;
    L31:
        r14 = r25;
        r15 = r115;
        goto L32
    L22:
        if (isSingleLine() == true) goto L24;
        r23 = getPaddingLeft();
        r17 = this.lineSpacing + r15;
        goto L25
    L18:
        r22 = 0;
        r113 = 0;
    L32:
        r18 = r18 + 1;
        goto L11
    L33:
        setMeasuredDimension(getMeasuredDimension(r5, r10, getPaddingRight() + r19), getMeasuredDimension(r11, r12, getPaddingBottom() + r15));
        return;
    L5:
        if (r10 == 1073741824) goto L8;
        r13 = Integer.MAX_VALUE;
        goto L9
    }

    public void setItemSpacing(int r5) {
        this.itemSpacing = r5;
    }

    public void setLineSpacing(int r5) {
        this.lineSpacing = r5;
    }

    public void setSingleLine(boolean r5) {
        this.singleLine = r5;
    }

    public FlowLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public FlowLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.singleLine = false;
        loadFromAttributes(r5, r10);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11, r12);
        this.singleLine = false;
        loadFromAttributes(r5, r10);
    }
}
