package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4859b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4861n;

    public boolean a() {
        return this.f4860m;
    }

    public int getItemSpacing() {
        return this.f4859b;
    }

    public int getLineSpacing() {
        return this.f4858a;
    }

    public int getRowCount() {
        return this.f4861n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        if (getChildCount() != 0) goto L6;
        this.f4861n = 0;
        return;
    L6:
        this.f4861n = 1;
        WeakHashMap<View, h0> r16 = w.f8437a;
        if (w.e.d(this) != 1) goto L9;
        boolean r17 = true;
    L10:
        if (r17 == false) goto L12;
        int r8 = getPaddingRight();
    L13:
        if (r17 == false) goto L15;
        int r10 = getPaddingLeft();
    L16:
        int r18 = getPaddingTop();
        int r19 = (r14 - r12) - r10;
        int r20 = 0;
        int r21 = r8;
        int r110 = r18;
    L18:
        if (r20 >= getChildCount()) goto L35;
        View r22 = getChildAt(r20);
        if (r22.getVisibility() != 8) goto L22;
        r22.setTag(R.id.row_index_key, -1);
    L34:
        r20 = r20 + 1;
        goto L18
    L22:
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        int r25 = j0.f.c(r24);
        int r26 = j0.f.b(r24);
    L26:
        int r27 = r22.getMeasuredWidth() + (r21 + r25);
        if (this.f4860m == true) goto L30;
        if (r27 <= r19) goto L30;
        r110 = this.f4858a + r18;
        this.f4861n++;
        r21 = r8;
    L30:
        r22.setTag(R.id.row_index_key, Integer.valueOf(this.f4861n - 1));
        int r28 = r21 + r25;
        int r29 = r22.getMeasuredWidth() + r28;
        int r30 = r22.getMeasuredHeight() + r110;
        if (r17 == false) goto L33;
        r28 = r19 - r29;
        r29 = (r19 - r21) - r25;
    L33:
        r22.layout(r28, r110, r29, r30);
        r21 = r21 + ((r22.getMeasuredWidth() + (r25 + r26)) + this.f4859b);
        r18 = r30;
        goto L34
    L25:
        r26 = 0;
        r25 = 0;
        goto L26
    L35:
        return;
    L15:
        r10 = getPaddingRight();
        goto L16
    L12:
        r8 = getPaddingLeft();
        goto L13
    L9:
        r17 = false;
        goto L10
    }

    @Override // android.view.View
    public final void onMeasure(int r20, int r21) {
        int r8 = View.MeasureSpec.getSize(r20);
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
        if (r18 >= getChildCount()) goto L31;
        View r110 = getChildAt(r18);
        if (r110.getVisibility() == 8) goto L30;
        measureChild(r110, r20, r21);
        ViewGroup.LayoutParams r22 = r110.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        int r111 = r23.leftMargin + 0;
        int r24 = r23.rightMargin + 0;
    L19:
        if ((r110.getMeasuredWidth() + (r14 + r111)) > r16) goto L21;
    L23:
        int r25 = r110.getMeasuredWidth() + (r14 + r111);
        int r26 = r110.getMeasuredHeight() + r17;
        if (r25 <= r19) goto L26;
        r19 = r25;
    L26:
        int r27 = ((r110.getMeasuredWidth() + (r111 + r24)) + this.f4859b) + r14;
        if (r18 != (getChildCount() - 1)) goto L29;
        r19 = r19 + r24;
    L29:
        r14 = r27;
        r15 = r26;
        goto L30
    L21:
        if (a() == true) goto L23;
        r14 = getPaddingLeft();
        r17 = this.f4858a + r15;
        goto L23
    L17:
        r24 = 0;
        r111 = 0;
    L30:
        r18 = r18 + 1;
        goto L10
    L31:
        int r28 = getPaddingRight() + r19;
        int r29 = getPaddingBottom() + r15;
        if (r10 == Integer.MIN_VALUE) goto L35;
        if (r10 == 1073741824) goto L36;
        r8 = r28;
    L36:
        if (r12 == Integer.MIN_VALUE) goto L39;
        if (r12 == 1073741824) goto L40;
        r11 = r29;
    L40:
        setMeasuredDimension(r8, r11);
        return;
    L39:
        r11 = Math.min(r29, r11);
        goto L40
    L35:
        r8 = Math.min(r28, r8);
    L7:
        r13 = r8;
        goto L8
    }

    public void setItemSpacing(int r8) {
        this.f4859b = r8;
    }

    public void setLineSpacing(int r8) {
        this.f4858a = r8;
    }

    public void setSingleLine(boolean r8) {
        this.f4860m = r8;
    }
}
