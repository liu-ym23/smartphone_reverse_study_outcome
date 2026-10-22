package com.bytedance.android.livesdk.commerce.coupon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveCouponPriceView extends View {
    public Paint a;
    public Paint b;
    public Paint c;
    public final Paint d;
    public int e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public float j;
    public float k;
    public float l;
    public float m;
    public final float n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public float t;

    public LiveCouponPriceView(Context r4) {
        super(r4);
        this.d = new Paint();
        this.e = -364470;
        this.g = false;
        this.k = UIUtils.sp2px(getContext(), 20.0f);
        this.m = 0.0f;
        this.n = UIUtils.sp2px(getContext(), 1.0f);
        this.t = 0.0f;
        a(r4, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r13) {
        super.draw(r13);
        if (TextUtils.isEmpty(this.f) == true) goto L5;
    L6:
        float r0 = getHeight();
        Paint.FontMetrics r1 = this.a.getFontMetrics();
        Paint.FontMetrics r2 = this.b.getFontMetrics();
        if (this.j <= this.k) goto L9;
        float r3 = getPaddingTop();
        float r4 = r1.descent;
        float r5 = (r3 + (((r0 + r4) - r1.ascent) / 2.0f)) - r4;
    L10:
        float r6 = getPaddingLeft();
        if (this.g == true) goto L16;
        if (TextUtils.isEmpty(this.f) == true) goto L16;
        r13.drawText(this.f, getPaddingLeft(), r5, this.a);
        r6 = r6 + (this.t + this.m);
    L16:
        if (TextUtils.isEmpty(this.h) == true) goto L21;
        r13.drawText(this.h, r6, r5, this.b);
        if (TextUtils.isEmpty(this.i) == true) goto L21;
        r13.drawText(this.i, r6 + this.b.measureText(this.h), r5, this.c);
    L21:
        if (this.r == false) goto L25;
        this.d.setColor(this.e);
        this.d.setStrokeWidth(this.n);
        r13.drawLine(3.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth(), getMeasuredHeight() / 2.0f, this.d);
        return;
    L25:
        return;
    L9:
        float r7 = getPaddingTop();
        float r8 = r2.descent;
        r5 = (r7 + (((r0 + r8) - r2.ascent) / 2.0f)) - r8;
        goto L10
    L5:
        if (TextUtils.isEmpty(this.h) == false) goto L6;
    }

    public void setPriceBold(boolean r2) {
        this.o = r2;
        this.p = r2;
        if (r2 == false) goto L6;
        this.b.setTypeface(Typeface.DEFAULT_BOLD);
    L6:
        if (this.p == false) goto L8;
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    public void setPriceText(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (this.s == true) goto L7;
    L9:
        this.h = r3;
        this.i = null;
    L10:
        requestLayout();
        invalidate();
        return;
    L7:
        if (r3.contains(".") == false) goto L9;
        int r0 = r3.indexOf(".");
        this.h = r3.substring(0, r0);
        this.i = r3.substring(r0);
        goto L10
    }

    public void setPriceTextColor(int r2) {
        this.e = r2;
        this.a.setColor(r2);
        this.b.setColor(this.e);
        this.c.setColor(this.e);
        this.d.setColor(this.e);
        requestLayout();
        invalidate();
    }

    public void setPriceTextSize(float r3) {
        this.k = r3;
        this.b.setTextSize(r3);
        this.c.setTextSize((r3 * 2.0f) / 3.0f);
        requestLayout();
        invalidate();
    }

    public void setYangTextSize(float r2) {
        this.j = r2;
        this.a.setTextSize(r2);
        requestLayout();
        invalidate();
    }

    public LiveCouponPriceView(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.d = new Paint();
        this.e = -364470;
        this.g = false;
        this.k = UIUtils.sp2px(getContext(), 20.0f);
        this.m = 0.0f;
        this.n = UIUtils.sp2px(getContext(), 1.0f);
        this.t = 0.0f;
        a(r4, r5);
    }

    public final void a(Context r5, AttributeSet r6) {
        if (r6 == null) goto L6;
        TypedArray r7 = getContext().obtainStyledAttributes(r6, new int[]{2130969910, 2130969916, 2130969917, 2130969918, 2130969919, 2130969920, 2130969931, 2130969932, 2130969934, 2130969935, 2130970211, 2130973600, 2130973601, 2130973602, 2130973603, 2130973604, 2130974058, 2130974116, 2130974556, 2130975167});
        this.h = r7.getString(13);
        this.e = r7.getColor(14, -364470);
        this.k = r7.getDimension(15, this.k);
        this.l = r7.getDimension(12, 0.0f);
        this.j = r7.getDimension(19, 0.0f);
        this.g = r7.getBoolean(10, false);
        this.m = r7.getDimension(17, this.m);
        boolean r1 = r7.getBoolean(11, false);
        this.o = r1;
        this.p = r1;
        this.q = r1;
        this.r = r7.getBoolean(16, this.r);
        this.s = r7.getBoolean(18, false);
        r7.recycle();
        setPriceText(this.h);
    L6:
        if (this.l != 0.0f) goto L9;
        this.l = (this.k * 2.0f) / 3.0f;
    L9:
        if (this.j != 0.0f) goto L11;
        this.j = (this.k * 2.0f) / 3.0f;
    L11:
        this.f = r5.getString(2131920111);
        Paint r8 = new Paint();
        this.a = r8;
        r8.setTextSize(this.j);
        this.a.setColor(this.e);
        this.a.setAntiAlias(true);
        if (this.q == false) goto L14;
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
    L14:
        Paint r9 = new Paint();
        this.b = r9;
        r9.setTextSize(this.k);
        this.b.setColor(this.e);
        this.b.setAntiAlias(true);
        if (this.o == false) goto L17;
        this.b.setTypeface(Typeface.DEFAULT_BOLD);
    L17:
        Paint r10 = new Paint();
        this.c = r10;
        if (this.s == false) goto L20;
        r10.setTextSize(this.l);
    L21:
        this.c.setColor(this.e);
        this.c.setAntiAlias(true);
        if (this.p == false) goto L25;
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L25:
        return;
    L20:
        r10.setTextSize(this.k);
        goto L21
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        if (TextUtils.isEmpty(this.f) == true) goto L5;
        Rect r0 = new Rect();
        Paint r1 = this.a;
        String r2 = this.f;
        r1.getTextBounds(r2, 0, r2.length(), r0);
        this.t = r0.width();
    L5:
        int r3 = View.MeasureSpec.getMode(r7);
        int r9 = View.getDefaultSize(getMinimumWidth(), r7);
        if (r3 == 1073741824) goto L21;
        float r4 = 0.0f;
        if (TextUtils.isEmpty(this.h) == true) goto L13;
        float r5 = this.b.measureText(this.h);
        if (TextUtils.isEmpty(this.i) == true) goto L15;
        r5 = r5 + this.c.measureText(this.i);
    L15:
        if (this.g == true) goto L17;
        r4 = this.t + this.m;
    L17:
        float r6 = (((r4 + r5) + getPaddingRight()) + getPaddingLeft()) + 0.5f;
        if (r9 != 0) goto L20;
        r9 = (int) r6;
        goto L21
    L20:
        r9 = (int) Math.min(r6, r9);
        goto L21
    L13:
        r5 = 0.0f;
    L21:
        int r10 = View.MeasureSpec.getMode(r8);
        int r11 = View.getDefaultSize(getMinimumHeight(), r8);
        if (r10 == 1073741824) goto L28;
        float r12 = ((this.k + getPaddingBottom()) + getPaddingTop()) + 0.5f;
        if (r11 != 0) goto L27;
        r11 = Math.round(r12);
        goto L28
    L27:
        r11 = Math.round(Math.min(r12, r11));
    L28:
        setMeasuredDimension(r9, r11);
    }

    public LiveCouponPriceView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.d = new Paint();
        this.e = -364470;
        this.g = false;
        this.k = UIUtils.sp2px(getContext(), 20.0f);
        this.m = 0.0f;
        this.n = UIUtils.sp2px(getContext(), 1.0f);
        this.t = 0.0f;
        a(r3, r4);
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
