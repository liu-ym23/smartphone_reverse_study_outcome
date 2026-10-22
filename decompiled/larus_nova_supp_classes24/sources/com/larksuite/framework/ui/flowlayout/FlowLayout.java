package com.larksuite.framework.ui.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class FlowLayout extends ViewGroup {
    public final List<List<View>> a;
    public final List<Integer> b;
    public final List<Integer> c;
    public int d;
    public List<View> e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Gravity {
        public static final int CENTER = 0;
        public static final int LEFT = -1;
        public static final int RIGHT = 1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public FlowLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    public void setGravity(int r1) {
        this.d = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new ViewGroup.MarginLayoutParams(r2);
    }

    public FlowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r19, int r20) {
        int r1 = View.MeasureSpec.getSize(r19);
        int r2 = View.MeasureSpec.getMode(r19);
        int r3 = View.MeasureSpec.getSize(r20);
        int r4 = View.MeasureSpec.getMode(r20);
        int r5 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r6 >= r5) goto L19;
        View r11 = getChildAt(r6);
        if (r11.getVisibility() == 8) goto L7;
        measureChild(r11, r19, r20);
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        int r15 = (r11.getMeasuredWidth() + r14.leftMargin) + r14.rightMargin;
        int r12 = (r11.getMeasuredHeight() + r14.topMargin) + r14.bottomMargin;
        int r13 = r8 + r15;
        if (r13 <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L13;
        r7 = Math.max(r7, r8);
        r10 = r10 + r9;
    L15:
        if (r6 != (r5 - 1)) goto L17;
        r7 = Math.max(r15, r7);
        r10 = r10 + r12;
    L17:
        r9 = r12;
        r8 = r15;
    L18:
        r6 = r6 + 1;
        r3 = r3;
        goto L3
    L13:
        r12 = Math.max(r9, r12);
        r15 = r13;
        goto L15
    L7:
        if (r6 != (r5 - 1)) goto L18;
        r7 = Math.max(r8, r7);
        r10 = r10 + r9;
        goto L18
    L19:
        int r16 = r3;
        if (r2 == 1073741824) goto L23;
        r1 = getPaddingRight() + (r7 + getPaddingLeft());
    L23:
        if (r4 != 1073741824) goto L25;
        int r17 = r16;
    L26:
        setMeasuredDimension(r1, r17);
        return;
    L25:
        r17 = (r10 + getPaddingTop()) + getPaddingBottom();
        goto L26
    }

    public FlowLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        TypedArray r4 = r1.obtainStyledAttributes(r2, new int[]{2130968882, 2130970172, 2130972675, 2130972701, 2130972715, 2130973427, 2130973429, 2130973430, 2130973431, 2130973858, 2130974467, 2130974468, 2130974472, 2130974475, 2130974525, 2130974542});
        this.d = r4.getInt(1, -1);
        r4.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        this.e.clear();
        int r16 = getWidth();
        int r17 = getChildCount();
        int r19 = 0;
        int r110 = 0;
        int r0 = 0;
    L4:
        if (r19 >= r17) goto L13;
        View r2 = getChildAt(r19);
        if (r2.getVisibility() == 8) goto L12;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        int r3 = r2.getMeasuredWidth();
        int r4 = r2.getMeasuredHeight();
        if ((((r3 + r0) + r1.leftMargin) + r1.rightMargin) <= ((r16 - getPaddingLeft()) - getPaddingRight())) goto L11;
        List<Integer> r5 = this.b;
        ArrayList r6 = (ArrayList) r5;
        r6.add(Integer.valueOf(r110));
        List<List<View>> r111 = this.a;
        ArrayList r112 = (ArrayList) r111;
        r112.add(this.e);
        List<Integer> r113 = this.c;
        ArrayList r114 = (ArrayList) r113;
        r114.add(Integer.valueOf(r0));
        r110 = (r1.topMargin + r4) + r1.bottomMargin;
        this.e = new ArrayList();
        r0 = 0;
    L11:
        r0 = r0 + ((r3 + r1.leftMargin) + r1.rightMargin);
        r110 = Math.max(r110, (r4 + r1.topMargin) + r1.bottomMargin);
        this.e.add(r2);
    L12:
        r19 = r19 + 1;
        goto L4
    L13:
        List<Integer> r115 = this.b;
        ArrayList r116 = (ArrayList) r115;
        r116.add(Integer.valueOf(r110));
        List<Integer> r117 = this.c;
        ArrayList r118 = (ArrayList) r117;
        r118.add(Integer.valueOf(r0));
        List<List<View>> r119 = this.a;
        ArrayList r120 = (ArrayList) r119;
        r120.add(this.e);
        int r121 = getPaddingLeft();
        int r122 = getPaddingTop();
        int r123 = ((ArrayList) this.a).size();
        int r7 = 0;
    L14:
        if (r7 >= r123) goto L34;
        this.e = (List) ListProtector.get(this.a, r7);
        int r8 = ((Integer) ListProtector.get(this.b, r7)).intValue();
        int r9 = ((Integer) ListProtector.get(this.c, r7)).intValue();
        int r10 = this.d;
        if (r10 == (-1)) goto L24;
        if (r10 != 0) goto L19;
        int r124 = (r16 - r9) / 2;
        int r20 = getPaddingLeft();
    L23:
        r121 = r124 + r20;
    L25:
        int r21 = 0;
    L27:
        if (r21 >= this.e.size()) goto L33;
        View r22 = (View) ListProtector.get(this.e, r21);
        if (r22.getVisibility() == 8) goto L32;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22.getLayoutParams();
        int r24 = r23.leftMargin + r121;
        int r25 = r23.topMargin + r122;
        r22.layout(r24, r25, r22.getMeasuredWidth() + r24, r22.getMeasuredHeight() + r25);
        r121 = r121 + ((r22.getMeasuredWidth() + r23.leftMargin) + r23.rightMargin);
    L32:
        r21 = r21 + 1;
        goto L27
    L33:
        r122 = r122 + r8;
        r7 = r7 + 1;
        goto L14
    L19:
        if (r10 != 1) goto L25;
        r124 = r16 - r9;
        r20 = getPaddingLeft();
        goto L23
    L24:
        r121 = getPaddingLeft();
        goto L25
    }
}
