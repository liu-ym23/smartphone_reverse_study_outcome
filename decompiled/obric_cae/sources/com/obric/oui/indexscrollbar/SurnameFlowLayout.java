package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import defpackage.b;
import he.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SurnameFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f6333b;

    public SurnameFlowLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f6332a = new ArrayList();
        this.f6333b = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        i.f(r8, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        ArrayList r8 = this.f6332a;
        r8.clear();
        ArrayList r10 = this.f6333b;
        r10.clear();
        int r11 = getWidth();
        ArrayList r12 = new ArrayList();
        int r13 = getChildCount();
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14 >= r13) goto L13;
        View r17 = getChildAt(r14);
        i.e(r17, "child");
        ViewGroup.LayoutParams r110 = r17.getLayoutParams();
        if (r110 == null) goto L12;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        int r23 = r17.getMeasuredWidth();
        int r112 = r17.getMeasuredHeight();
        if ((((r111.leftMargin + r23) + r111.rightMargin) + r16) <= r11) goto L10;
        r10.add(Integer.valueOf(r15));
        r8.add(r12);
        r12 = new ArrayList();
        r16 = 0;
    L10:
        r16 = r16 + ((r23 + r111.leftMargin) + r111.rightMargin);
        r15 = (int) Math.max(r15, (r112 + r111.topMargin) + r111.bottomMargin);
        r12.add(r17);
        r14 = r14 + 1;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        r10.add(Integer.valueOf(r15));
        r8.add(r12);
        int r24 = r8.size();
        int r25 = 0;
        int r26 = 0;
    L14:
        if (r25 >= r24) goto L27;
        List r27 = (List) r8.get(r25);
        int r28 = ((Number) r10.get(r25)).intValue();
        int r29 = r27.size();
        int r30 = 0;
        int r113 = 0;
    L16:
        if (r30 >= r29) goto L26;
        View r114 = (View) r27.get(r30);
        if (r114.getVisibility() == 8) goto L23;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L25;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        int r117 = r116.leftMargin + r113;
        int r118 = r116.topMargin + r26;
        int r119 = r114.getMeasuredWidth() + r117;
        int r31 = r114.getMeasuredHeight() + r118;
        StringBuilder r32 = new StringBuilder();
        r32.append(r114.toString());
        r32.append(" , l = ");
        r32.append(r117);
        r32.append(" , t = ");
        b.q(r32, r20, " , r =", r119, " , b = ");
        r32.append(r31);
        Log.e("FlowLayout", r32.toString());
        r114.layout(r117, r118, r119, r31);
        r113 = ((r114.getMeasuredWidth() + r116.rightMargin) + r116.leftMargin) + r113;
        goto L23
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L23:
        r30 = r30 + 1;
        r24 = r24;
        r10 = r10;
        r27 = r27;
        r29 = r29;
        r8 = r8;
        goto L16
    L26:
        r26 = r26 + r28;
        r25 = r25 + 1;
        goto L14
    }

    @Override // android.view.View
    public final void onMeasure(int r18, int r19) {
        super.onMeasure(r18, r19);
        int r8 = View.MeasureSpec.getSize(r18);
        int r10 = View.MeasureSpec.getSize(r19);
        int r11 = View.MeasureSpec.getMode(r18);
        int r12 = View.MeasureSpec.getMode(r19);
        StringBuilder r13 = new StringBuilder();
        r13.append(r8);
        r13.append(',');
        r13.append(r10);
        Log.e("FlowLayout", r13.toString());
        int r14 = getChildCount();
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r20 = 0;
        int r110 = 0;
    L3:
        if (r15 >= r14) goto L16;
        View r111 = getChildAt(r15);
        measureChild(r111, r18, r19);
        i.e(r111, "child");
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L15;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r114 = r10;
        int r115 = (r111.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
        int r21 = (r111.getMeasuredHeight() + r113.topMargin) + r113.bottomMargin;
        int r116 = r17 + r115;
        if (r116 <= r8) goto L9;
        r16 = (int) Math.max(r17, r115);
        r110 = r110 + r20;
        r20 = r21;
        r17 = r115;
    L11:
        if (r15 != (r14 - 1)) goto L13;
        r110 = r110 + r20;
        r16 = (int) Math.max(r16, r17);
    L13:
        r15 = r15 + 1;
        r10 = r114;
        goto L3
    L9:
        r20 = (int) Math.max(r20, r21);
        r17 = r116;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        int r117 = r10;
        if (r11 == 1073741824) goto L20;
        r8 = r16;
    L20:
        if (r12 != 1073741824) goto L22;
        int r22 = r117;
    L23:
        setMeasuredDimension(r8, r22);
        return;
    L22:
        r22 = r110;
        goto L23
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        i.f(r8, "p");
        return new ViewGroup.MarginLayoutParams(r8);
    }
}
