package com.lynx.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.internal.InternalClassics;
import m6a.h;
import m6a.i;
import p6a.a;
import p6a.b;
import p6a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class InternalClassics<T extends InternalClassics> extends b {
    public TextView d;
    public ImageView e;
    public ImageView f;
    public h g;
    public a h;
    public d i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView r0 = this.e;
        ImageView r1 = this.f;
        r0.animate().cancel();
        r1.animate().cancel();
        Object r2 = this.f.getDrawable();
        if ((r2 instanceof Animatable) == false) goto L8;
        Animatable r3 = (Animatable) r2;
        if (r3.isRunning() == false) goto L9;
        r3.stop();
        return;
    L9:
        return;
    }

    public void g(int r3) {
        this.j = true;
        this.d.setTextColor(r3);
        a r0 = this.h;
        if (r0 == null) goto L5;
        r0.a(r3);
        this.e.invalidateDrawable(this.h);
    L5:
        d r1 = this.i;
        if (r1 == null) goto L9;
        r1.a(r3);
        this.f.invalidateDrawable(this.i);
        return;
    }

    @Override // p6a.b, m6a.g
    public void setPrimaryColors(int... r5) {
        if (r5.length > 0) goto L5;
        return;
    L5:
        if ((getBackground() instanceof BitmapDrawable) == true) goto L13;
        if (this.k == true) goto L13;
        int r0 = r5[0];
        this.k = true;
        this.l = r0;
        h r3 = this.g;
        if (r3 == null) goto L11;
        ((SmartRefreshLayout.i) r3).c(this, r0);
    L11:
        this.k = false;
    L13:
        if (this.j == false) goto L15;
        return;
    L15:
        if (r5.length <= 1) goto L17;
        g(r5[1]);
    L21:
        this.j = false;
        return;
    L17:
        int r1 = -1;
        if (r5[0] != (-1)) goto L20;
        r1 = -10066330;
    L20:
        g(r1);
        goto L21
    }

    @Override // p6a.b, m6a.g
    public int e(SmartRefreshLayout r3, boolean r4) {
        ImageView r5 = this.f;
        Object r6 = r5.getDrawable();
        if ((r6 instanceof Animatable) == false) goto L7;
        Animatable r7 = (Animatable) r6;
        if (r7.isRunning() == false) goto L8;
        r7.stop();
    L8:
        r5.setVisibility(8);
        return this.m;
    L7:
        r5.animate().rotation(0.0f).setDuration(0);
        goto L8
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r1 = 0;
        if (this.p != 0) goto L16;
        this.n = getPaddingTop();
        int r0 = getPaddingBottom();
        this.o = r0;
        if (this.n == 0) goto L7;
        if (r0 == 0) goto L7;
    L14:
        setClipToPadding(false);
    L7:
        int r2 = getPaddingLeft();
        int r3 = getPaddingRight();
        int r4 = this.n;
        if (r4 != 0) goto L10;
        r4 = r6a.b.c(20.0f);
    L10:
        this.n = r4;
        int r5 = this.o;
        if (r5 != 0) goto L13;
        r5 = r6a.b.c(20.0f);
    L13:
        this.o = r5;
        setPadding(r2, this.n, r3, r5);
    L16:
        if (View.MeasureSpec.getMode(r7) != 1073741824) goto L21;
        int r8 = View.MeasureSpec.getSize(r7);
        int r9 = this.p;
        if (r8 >= r9) goto L20;
        int r10 = (r8 - r9) / 2;
        setPadding(getPaddingLeft(), r10, getPaddingRight(), r10);
    L22:
        super.onMeasure(r6, r7);
        if (this.p == 0) goto L25;
        return;
    L25:
        if (r1 >= getChildCount()) goto L34;
        int r11 = getChildAt(r1).getMeasuredHeight();
        if (this.p >= r11) goto L29;
        this.p = r11;
    L29:
        r1 = r1 + 1;
        goto L25
    L34:
        return;
    L20:
        setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        goto L22
    L21:
        setPadding(getPaddingLeft(), this.n, getPaddingRight(), this.o);
        goto L22
    }

    public InternalClassics(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.m = 500;
        this.n = 20;
        this.o = 20;
        this.p = 0;
        this.b = n6a.b.d;
    }

    @Override // p6a.b, m6a.g
    public final void j(SmartRefreshLayout.i r1, int r2, int r3) {
        this.g = r1;
        r1.c(this, this.l);
    }

    @Override // p6a.b, m6a.g
    public final void k(i r1, int r2, int r3) {
        n(r1, r2, r3);
    }

    @Override // p6a.b, m6a.g
    public void n(i r1, int r2, int r3) {
        ImageView r4 = this.f;
        if (r4.getVisibility() == 0) goto L9;
        r4.setVisibility(0);
        Object r5 = this.f.getDrawable();
        if ((r5 instanceof Animatable) == false) goto L7;
        ((Animatable) r5).start();
        return;
    L7:
        r4.animate().rotation(36000.0f).setDuration(100000);
        return;
    }
}
