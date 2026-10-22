package com.larus.photopicker.v2.impl.others.scale;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import pp9.j;
import qp9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class ClipFrameLayout extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public final RectF a;
    public final Path b;
    public final RectF c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Rect g;
    public Rect h;
    public float i;
    public final Rect j;
    public final j k;
    public final j l;

    public ClipFrameLayout(Context r2) {
        super(r2);
        this.a = new RectF();
        this.b = new Path();
        this.c = new RectF();
        this.d = false;
        this.e = false;
        this.f = false;
        this.j = new Rect();
        this.k = new j(new Rect());
        this.l = new j(new Rect());
    }

    public ClipFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new RectF();
        this.b = new Path();
        this.c = new RectF();
        this.d = false;
        this.e = false;
        this.f = false;
        this.j = new Rect();
        this.k = new j(new Rect());
        this.l = new j(new Rect());
    }

    public ClipFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new RectF();
        this.b = new Path();
        this.c = new RectF();
        this.d = false;
        this.e = false;
        this.f = false;
        this.j = new Rect();
        this.k = new j(new Rect());
        this.l = new j(new Rect());
    }

    public boolean a(Canvas r1, View r2, long r3) {
        return super.drawChild(r1, r2, r3);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        if (this.f == false) goto L13;
        r2.save();
        r2.clipRect(this.c);
        if (this.e == false) goto L8;
        r2.save();
        r2.clipPath(this.b);
        boolean r5 = a(r2, r3, r4);
        r2.restore();
    L11:
        r2.restore();
        return r5;
    L8:
        if (this.d == false) goto L10;
        r2.save();
        r2.clipRect(this.a);
        r5 = a(r2, r3, r4);
        r2.restore();
        goto L11
    L10:
        r5 = a(r2, r3, r4);
        goto L11
    L13:
        if (this.e == false) goto L16;
        r2.save();
        r2.clipPath(this.b);
        boolean r6 = a(r2, r3, r4);
        r2.restore();
        return r6;
    L16:
        if (this.d == false) goto L19;
        r2.save();
        r2.clipRect(this.a);
        boolean r7 = a(r2, r3, r4);
        r2.restore();
        return r7;
    L19:
        return a(r2, r3, r4);
    }

    public final Animator b(Rect r2, Rect r3, float r4, final boolean r5) {
        this.g = new Rect(r2);
        this.h = new Rect(r3);
        this.i = r4;
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.addUpdateListener(new c(this, r5));
        return r6;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.j.set(0, 0, getWidth(), getHeight());
    }
}
