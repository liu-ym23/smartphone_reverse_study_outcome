package com.obric.oui.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12321c;
    public int d;

    public FlowLayout(@NonNull Context r5) {
        this(r5, null);
    }

    public int getItemSpacing() {
        return this.f12320b;
    }

    public int getLineSpacing() {
        return this.f12319a;
    }

    public int getRowCount() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (getChildCount() != 0) goto L6;
        this.d = 0;
        return;
    L6:
        this.d = 1;
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
        r21.setTag(R$id.row_index_key, -1);
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
        if (this.f12321c == true) goto L30;
        if (r26 <= r18) goto L30;
        r110 = this.f12319a + r17;
        this.d++;
        r20 = r5;
    L30:
        r21.setTag(R$id.row_index_key, Integer.valueOf(this.d - 1));
        int r27 = r20 + r24;
        int r28 = r21.getMeasuredWidth() + r27;
        int r29 = r21.getMeasuredHeight() + r110;
        if (r15 == false) goto L33;
        r21.layout(r18 - r28, r110, (r18 - r20) - r24, r29);
    L34:
        r20 = r20 + ((r21.getMeasuredWidth() + (r24 + r25)) + this.f12320b);
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
    public final void onMeasure(int r20, int r21) {
        int r5 = View.MeasureSpec.getSize(r20);
        int r10 = View.MeasureSpec.getMode(r20);
        int r11 = View.MeasureSpec.getSize(r21);
        int r12 = View.MeasureSpec.getMode(r21);
        if (r10 == Integer.MIN_VALUE) goto L7;
        if (r10 == 1073741824) goto L7;
        int r13 = Integer.MAX_VALUE;
    L8:
        int r14 = getPaddingLeft();
        int r15 = getPaddingTop();
        int r16 = r13 - getPaddingRight();
        int r17 = r15;
        int r18 = 0;
        int r19 = 0;
    L10:
        if (r18 >= getChildCount()) goto L32;
        View r110 = getChildAt(r18);
        if (r110.getVisibility() == 8) goto L31;
        measureChild(r110, r20, r21);
        ViewGroup.LayoutParams r22 = r110.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        int r24 = r23.leftMargin;
        int r25 = r23.rightMargin;
    L18:
        int r111 = r14;
        if ((r110.getMeasuredWidth() + (r14 + r24)) > r16) goto L21;
    L23:
        int r26 = r111;
    L24:
        int r27 = r110.getMeasuredWidth() + (r26 + r24);
        int r112 = r110.getMeasuredHeight() + r17;
        if (r27 <= r19) goto L27;
        r19 = r27;
    L27:
        int r28 = ((r110.getMeasuredWidth() + (r24 + r25)) + this.f12320b) + r26;
        if (r18 != (getChildCount() - 1)) goto L30;
        r19 = r19 + r25;
    L30:
        r14 = r28;
        r15 = r112;
        goto L31
    L21:
        if (this.f12321c == true) goto L23;
        r26 = getPaddingLeft();
        r17 = this.f12319a + r15;
        goto L24
    L17:
        r25 = 0;
        r24 = 0;
    L31:
        r18 = r18 + 1;
        goto L10
    L32:
        int r29 = getPaddingRight() + r19;
        int r30 = getPaddingBottom() + r15;
        if (r10 == Integer.MIN_VALUE) goto L37;
        int r31 = BasicMeasure.EXACTLY;
        if (r10 == 1073741824) goto L38;
        r5 = r29;
    L38:
        if (r12 == Integer.MIN_VALUE) goto L41;
        if (r12 == r31) goto L42;
        r11 = r30;
    L42:
        setMeasuredDimension(r5, r11);
        return;
    L41:
        r11 = Math.min(r30, r11);
        goto L42
    L37:
        r31 = BasicMeasure.EXACTLY;
        r5 = Math.min(r29, r5);
    L7:
        r13 = r5;
        goto L8
    }

    public void setItemSpacing(int r5) {
        this.f12320b = r5;
    }

    public void setLineSpacing(int r5) {
        this.f12319a = r5;
    }

    public void setSingleLine(boolean r5) {
        this.f12321c = r5;
    }

    public FlowLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public FlowLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12321c = false;
        TypedArray r12 = r5.getTheme().obtainStyledAttributes(r10, R$styleable.OChipGroup, 0, 0);
        this.f12319a = r12.getDimensionPixelSize(R$styleable.OChipGroup_oui_line_space, 0);
        this.f12320b = r12.getDimensionPixelSize(R$styleable.OChipGroup_oui_item_space, 0);
        r12.recycle();
    }
}
