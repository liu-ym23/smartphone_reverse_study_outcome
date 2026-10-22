package com.bytedance.android.ec.core.widget.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class FlowLayout extends ViewGroup {
    public final List<List<View>> a;
    public final List<Integer> b;
    public final List<Integer> c;
    public final int d;
    public List<View> e;
    public int f;
    public int g;
    public int h;

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public int getVisibleViewCount() {
        Iterator r0 = ((ArrayList) this.a).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((List) r0.next()).size();
        goto L4
    L6:
        return r1;
    }

    public FlowLayout(Context r10) {
        this(r10, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new ViewGroup.MarginLayoutParams(getContext(), r10);
    }

    public void setMaxLine(int r1) {
        this.h = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new ViewGroup.MarginLayoutParams(r10);
    }

    public FlowLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r20, int r21) {
        int r1 = View.MeasureSpec.getSize(r20);
        int r10 = View.MeasureSpec.getMode(r20);
        int r11 = View.MeasureSpec.getSize(r21);
        int r12 = View.MeasureSpec.getMode(r21);
        int r13 = 0;
        int r14 = View.MeasureSpec.makeMeasureSpec(r1, 0);
        int r15 = getChildCount();
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r110 = 1;
    L3:
        if (r13 >= r15) goto L22;
        View r111 = getChildAt(r13);
        if (r111.getVisibility() == 8) goto L7;
        measureChild(r111, r14, r21);
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111.getLayoutParams();
        int r113 = r11;
        int r114 = (r111.getMeasuredWidth() + r112.leftMargin) + r112.rightMargin;
        int r22 = (r111.getMeasuredHeight() + r112.topMargin) + r112.bottomMargin;
        if ((r16 + r114) <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L16;
        r18 = Math.max(r18, r16);
        int r115 = r114 + this.g;
        r19 = r19 + r17;
        r110 = r110 + 1;
        int r23 = this.h;
        if (r23 <= 0) goto L17;
        if (r110 <= r23) goto L17;
        r17 = r22;
    L23:
        if (r17 <= 0) goto L26;
        r19 = r19 + (((r19 / r17) - 1) * this.f);
    L26:
        if (r10 == 1073741824) goto L29;
        r1 = getPaddingRight() + (r18 + getPaddingLeft());
    L29:
        if (r12 != 1073741824) goto L31;
        int r24 = r113;
    L32:
        setMeasuredDimension(r1, r24);
        return;
    L31:
        r24 = (r19 + getPaddingTop()) + getPaddingBottom();
    L17:
        r16 = r115;
        if (r13 != (r15 - 1)) goto L20;
        r19 = r19 + r22;
        r18 = Math.max(r16, r18);
    L20:
        r17 = r22;
    L21:
        r13 = r13 + 1;
        r11 = r113;
        goto L3
    L16:
        r115 = r16 + (r114 + this.g);
        r22 = Math.max(r17, r22);
        goto L17
    L7:
        if (r13 != (r15 - 1)) goto L9;
        r19 = r19 + r17;
        r113 = r11;
        r18 = Math.max(r16, r18);
        goto L21
    L9:
        r113 = r11;
        goto L21
    L22:
        r113 = r11;
        goto L23
    }

    public FlowLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{2130972717, 2130974466, 2130974470, 2130974474, 2130974477});
        int r0 = r13.getInt(1, -1);
        this.d = r0;
        this.g = r13.getDimensionPixelSize(3, 0);
        this.f = r13.getDimensionPixelSize(4, 0);
        this.h = r13.getInteger(2, 0);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        if (r0 != (-1)) goto L6;
        this.d = 1;
        goto L7
    L6:
        this.d = -1;
    L7:
        r13.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        this.e.clear();
        int r1 = getWidth();
        int r10 = getChildCount();
        int r11 = 1;
        int r12 = 0;
        int r13 = 0;
        int r14 = 1;
        int r15 = 0;
    L4:
        if (r12 >= r10) goto L17;
        View r16 = getChildAt(r12);
        if (r16.getVisibility() == 8) goto L16;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16.getLayoutParams();
        int r110 = (r16.getMeasuredWidth() + r17.leftMargin) + r17.rightMargin;
        int r111 = (r16.getMeasuredHeight() + r17.topMargin) + r17.bottomMargin;
        if ((r110 + r13) <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L15;
        r14 = r14 + 1;
        int r112 = this.h;
        if (r112 <= 0) goto L14;
        if (r14 > r112) goto L17;
    L14:
        List<Integer> r23 = this.b;
        ArrayList r24 = (ArrayList) r23;
        r24.add(Integer.valueOf(r15));
        List<List<View>> r25 = this.a;
        ArrayList r26 = (ArrayList) r25;
        r26.add(this.e);
        List<Integer> r27 = this.c;
        ArrayList r28 = (ArrayList) r27;
        r28.add(Integer.valueOf(r13));
        this.e = new ArrayList();
        r15 = r111;
        r13 = 0;
    L15:
        r13 = r13 + (r110 + this.g);
        r15 = Math.max(r15, r111);
        this.e.add(r16);
    L16:
        r12 = r12 + 1;
    L17:
        List<Integer> r29 = this.b;
        ArrayList r30 = (ArrayList) r29;
        r30.add(Integer.valueOf(r15));
        List<Integer> r31 = this.c;
        ArrayList r32 = (ArrayList) r31;
        r32.add(Integer.valueOf(r13));
        List<List<View>> r33 = this.a;
        ArrayList r34 = (ArrayList) r33;
        r34.add(this.e);
        int r35 = getPaddingLeft();
        int r36 = getPaddingTop();
        int r37 = ((ArrayList) this.a).size();
        int r38 = 0;
    L18:
        if (r38 >= r37) goto L35;
        List<View> r39 = (List) ListProtector.get(this.a, r38);
        this.e = r39;
        int r40 = r39.size();
        int r113 = ((Integer) ListProtector.get(this.b, r38)).intValue() + this.f;
        int r114 = ((Integer) ListProtector.get(this.c, r38)).intValue();
        int r115 = this.d;
        if (r115 == (-1)) goto L26;
        if (r115 == 0) goto L25;
        if (r115 != r11) goto L27;
        r35 = (r1 - (r114 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.e);
    L27:
        int r116 = 0;
    L28:
        if (r116 >= r40) goto L34;
        View r117 = (View) ListProtector.get(this.e, r116);
        if (r117.getVisibility() == 8) goto L33;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117.getLayoutParams();
        int r119 = r118.leftMargin + r35;
        int r120 = r118.topMargin + r36;
        r117.layout(r119, r120, r119 + r117.getMeasuredWidth(), r120 + r117.getMeasuredHeight());
        r35 = r35 + (((r117.getMeasuredWidth() + r118.leftMargin) + r118.rightMargin) + this.g);
    L33:
        r116 = r116 + 1;
        goto L28
    L34:
        r36 = r36 + r113;
        r38 = r38 + 1;
        r11 = 1;
        goto L18
    L25:
        r35 = ((r1 - r114) / 2) + getPaddingLeft();
        goto L27
    L26:
        r35 = getPaddingLeft();
        goto L27
    }
}
