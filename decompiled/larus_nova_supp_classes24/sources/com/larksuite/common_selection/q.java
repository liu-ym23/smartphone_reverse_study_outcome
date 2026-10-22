package com.larksuite.common_selection;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q extends View {
    public boolean a;
    public final Rect b;
    public float c;
    public float d;
    public boolean e;
    public final int f;
    public final /* synthetic */ r g;

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = r7.getAction();
        if (r1 == 0) goto L25;
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L30;
        this.e = false;
    L30:
        if (this.a == false) goto L32;
        return false;
    L32:
        this.a = true;
        this.g.c.dispatchTouchEvent(r7);
        this.a = false;
        return true;
    L15:
        if (this.e == false) goto L30;
        float r2 = Math.abs(r7.getX() - this.c);
        float r3 = Math.abs(r7.getY() - this.d);
        int r4 = this.f;
        if (r2 <= r4) goto L19;
    L20:
        this.e = false;
        goto L30
    L19:
        if (r3 <= r4) goto L30;
    L22:
        if (this.e == false) goto L30;
        this.e = false;
        this.g.b.invoke();
        return true;
    L25:
        this.g.a.getHitRect(this.b);
        if (this.b.contains((int) r7.getX(), (int) r7.getY()) == true) goto L28;
        this.e = true;
        this.c = r7.getX();
        this.d = r7.getY();
        goto L30
    L28:
        this.e = false;
        goto L30
    }

    public q(r r1, Context r2) {
        this.g = r1;
        super(r2);
        this.b = new Rect();
        this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        int r0 = getSuggestedMinimumWidth();
        int r1 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r1 != 1073741824) goto L8;
        r0 = r9;
    L8:
        int r10 = getSuggestedMinimumHeight();
        int r2 = View.MeasureSpec.getMode(r8);
        int r11 = View.MeasureSpec.getSize(r8);
        if (r2 == Integer.MIN_VALUE) goto L13;
        if (r2 != 1073741824) goto L14;
        r10 = r11;
    L14:
        setMeasuredDimension(r0, r10);
        return;
    L13:
        r10 = (int) Math.min(r10, r11);
        goto L14
    L7:
        r0 = (int) Math.min(r0, r9);
        goto L8
    }
}
