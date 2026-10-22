package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3950b;
    private boolean c;
    private int d;

    public FlowLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public FlowLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public FlowLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.c = false;
        a(r6, r7);
    }

    private static int a(int r1, int r2, int r3) {
        if (r2 == Integer.MIN_VALUE) goto L9;
        if (r2 == 1073741824) goto L7;
        return r3;
    L7:
        return r1;
    L9:
        return Math.min(r3, r1);
    }

    private void a(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r8 = r6.getTheme().obtainStyledAttributes(r7, R.styleable.FlowLayout, 0, 0);
        this.f3949a = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_lineSpacing, "styleable", "FlowLayout_lineSpacing"), 0);
        this.f3950b = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FlowLayout_itemSpacing, "styleable", "FlowLayout_itemSpacing"), 0);
        r8.recycle();
    }

    public boolean a() {
        return this.c;
    }

    public int b(View r3) {
        Object r2 = r3.getTag(ZeusTransformUtils.mapRes(R.id.row_index_key, OaidModel.KEY_ID, "row_index_key"));
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == true) goto L7;
        return -1;
    L7:
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public int getItemSpacing() {
        return this.f3950b;
    }

    public int getLineSpacing() {
        return this.f3949a;
    }

    public int getRowCount() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        int r2 = 0;
        if (getChildCount() != 0) goto L6;
        this.d = 0;
        return;
    L6:
        this.d = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        int r4 = getPaddingRight();
    L13:
        if (r3 == false) goto L15;
        int r5 = getPaddingLeft();
    L16:
        int r6 = getPaddingTop();
        int r7 = (r21 - r19) - r5;
        int r8 = 0;
        int r9 = r4;
        int r10 = r6;
    L18:
        if (r8 >= getChildCount()) goto L35;
        View r11 = getChildAt(r8);
        if (r11.getVisibility() != 8) goto L22;
        r11.setTag(ZeusTransformUtils.mapRes(R.id.row_index_key, OaidModel.KEY_ID, "row_index_key"), -1);
    L34:
        r8 = r8 + 1;
        r2 = 0;
        goto L18
    L22:
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r12, ViewGroup.MarginLayoutParams.class) == false) goto L25;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r12, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = MarginLayoutParamsCompat.getMarginStart(r13);
        int r15 = MarginLayoutParamsCompat.getMarginEnd(r13);
    L26:
        int r16 = (r9 + r14) + r11.getMeasuredWidth();
        if (this.c == true) goto L30;
        if (r16 <= r7) goto L30;
        r10 = r6 + this.f3949a;
        this.d++;
        r9 = r4;
    L30:
        r11.setTag(ZeusTransformUtils.mapRes(R.id.row_index_key, OaidModel.KEY_ID, "row_index_key"), Integer.valueOf(this.d - 1));
        int r17 = r9 + r14;
        int r23 = r11.getMeasuredWidth() + r17;
        int r110 = r11.getMeasuredHeight() + r10;
        if (r3 == false) goto L33;
        r17 = r7 - r23;
        r23 = (r7 - r9) - r14;
    L33:
        r11.layout(r17, r10, r23, r110);
        r9 = r9 + (((r14 + r15) + r11.getMeasuredWidth()) + this.f3950b);
        r6 = r110;
        goto L34
    L25:
        r15 = r2;
        r14 = r15;
        goto L26
    L35:
        return;
    L15:
        r5 = getPaddingRight();
        goto L16
    L12:
        r4 = getPaddingLeft();
        goto L13
    L9:
        r3 = false;
        goto L10
    }

    @Override // android.view.View
    public void onMeasure(int r20, int r21) {
        int r1 = View.MeasureSpec.getSize(r20);
        int r2 = View.MeasureSpec.getMode(r20);
        int r3 = View.MeasureSpec.getSize(r21);
        int r4 = View.MeasureSpec.getMode(r21);
        if (r2 != Integer.MIN_VALUE) goto L5;
    L8:
        int r5 = r1;
    L9:
        int r6 = getPaddingLeft();
        int r7 = getPaddingTop();
        int r8 = r5 - getPaddingRight();
        int r9 = r7;
        int r10 = 0;
        int r11 = 0;
    L11:
        if (r10 >= getChildCount()) goto L32;
        View r12 = getChildAt(r10);
        if (r12.getVisibility() == 8) goto L31;
        measureChild(r12, r20, r21);
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r15, ViewGroup.MarginLayoutParams.class) == false) goto L18;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = r13.leftMargin + 0;
        int r16 = r13.rightMargin + 0;
    L20:
        if (((r6 + r14) + r12.getMeasuredWidth()) > r8) goto L22;
    L24:
        int r17 = (r6 + r14) + r12.getMeasuredWidth();
        int r18 = r9 + r12.getMeasuredHeight();
        if (r17 <= r11) goto L27;
        r11 = r17;
    L27:
        r6 = r6 + (((r14 + r16) + r12.getMeasuredWidth()) + this.f3950b);
        if (r10 != (getChildCount() - 1)) goto L30;
        r11 = r11 + r16;
    L30:
        r7 = r18;
        r9 = r9;
        goto L31
    L22:
        if (a() == true) goto L24;
        r6 = getPaddingLeft();
        r9 = r7 + this.f3949a;
        goto L24
    L18:
        r16 = 0;
        r14 = 0;
    L31:
        r10 = r10 + 1;
        goto L11
    L32:
        setMeasuredDimension(a(r1, r2, r11 + getPaddingRight()), a(r3, r4, r7 + getPaddingBottom()));
        return;
    L5:
        if (r2 == 1073741824) goto L8;
        r5 = Integer.MAX_VALUE;
        goto L9
    }

    public void setItemSpacing(int r1) {
        this.f3950b = r1;
    }

    public void setLineSpacing(int r1) {
        this.f3949a = r1;
    }

    public void setSingleLine(boolean r1) {
        this.c = r1;
    }
}
