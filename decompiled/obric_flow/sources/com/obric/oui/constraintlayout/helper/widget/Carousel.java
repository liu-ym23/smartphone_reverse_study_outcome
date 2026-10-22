package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.lynx.tasm.ui.image.h;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.c0;
import com.obric.oui.constraintlayout.motion.widget.g0;
import com.obric.oui.constraintlayout.widget.R$styleable;
import ir.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Carousel extends MotionHelper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f12598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MotionLayout f12600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12602r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12603t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12604u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12605v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f12606w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12607x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12608y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f12609z;

    public Carousel(Context r5) {
        super(r5);
        this.f12598n = new ArrayList();
        this.f12599o = 0;
        this.f12601q = -1;
        this.f12602r = false;
        this.s = -1;
        this.f12603t = -1;
        this.f12604u = -1;
        this.f12605v = -1;
        this.f12606w = 0.9f;
        this.f12607x = 4;
        this.f12608y = 1;
        this.f12609z = 2.0f;
        new h(this, 26);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.z
    public final void a(int r5) {
        int r10 = this.f12599o;
        if (r5 != this.f12605v) goto L6;
        this.f12599o = r10 + 1;
    L9:
        if (this.f12602r == false) goto L11;
        throw null;
    L11:
        throw null;
    L6:
        if (r5 != this.f12604u) goto L9;
        this.f12599o = r10 - 1;
        goto L9
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.f12599o;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof MotionLayout) == false) goto L22;
        MotionLayout r5 = (MotionLayout) getParent();
        ArrayList r10 = this.f12598n;
        r10.clear();
        int r11 = 0;
    L6:
        if (r11 >= this.f12985b) goto L8;
        r10.add(r5.e(this.f12984a[r11]));
        r11 = r11 + 1;
        goto L6
    L8:
        this.f12600p = r5;
        if (this.f12608y != 2) goto L23;
        c0 r12 = r5.B(this.f12603t);
        if (r12 == null) goto L15;
        g0 r13 = r12.f12723l;
        if (r13 == null) goto L15;
        r13.f12775c = 5;
    L15:
        c0 r14 = this.f12600p.B(this.s);
        if (r14 == null) goto L24;
        g0 r15 = r14.f12723l;
        if (r15 == null) goto L25;
        r15.f12775c = 5;
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12598n.clear();
    }

    public final void s(Context r5, AttributeSet r10) {
        if (r10 == null) goto L50;
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.Carousel);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L36;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.Carousel_carousel_firstView) goto L9;
        this.f12601q = r11.getResourceId(r14, this.f12601q);
    L35:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.Carousel_carousel_backwardTransition) goto L12;
        this.s = r11.getResourceId(r14, this.s);
        goto L35
    L12:
        if (r14 != R$styleable.Carousel_carousel_forwardTransition) goto L15;
        this.f12603t = r11.getResourceId(r14, this.f12603t);
        goto L35
    L15:
        if (r14 != R$styleable.Carousel_carousel_emptyViewsBehavior) goto L18;
        this.f12607x = r11.getInt(r14, this.f12607x);
        goto L35
    L18:
        if (r14 != R$styleable.Carousel_carousel_previousState) goto L21;
        this.f12604u = r11.getResourceId(r14, this.f12604u);
        goto L35
    L21:
        if (r14 != R$styleable.Carousel_carousel_nextState) goto L24;
        this.f12605v = r11.getResourceId(r14, this.f12605v);
        goto L35
    L24:
        if (r14 != R$styleable.Carousel_carousel_touchUp_dampeningFactor) goto L27;
        this.f12606w = r11.getFloat(r14, this.f12606w);
        goto L35
    L27:
        if (r14 != R$styleable.Carousel_carousel_touchUpMode) goto L30;
        this.f12608y = r11.getInt(r14, this.f12608y);
        goto L35
    L30:
        if (r14 != R$styleable.Carousel_carousel_touchUp_velocityThreshold) goto L33;
        this.f12609z = r11.getFloat(r14, this.f12609z);
        goto L35
    L33:
        if (r14 != R$styleable.Carousel_carousel_infinite) goto L35;
        this.f12602r = r11.getBoolean(r14, this.f12602r);
        goto L35
    L36:
        r11.recycle();
        return;
    }

    public void setAdapter(a r5) {
    }

    public void setInfinite(boolean r5) {
        this.f12602r = r5;
    }

    public Carousel(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12598n = new ArrayList();
        this.f12599o = 0;
        this.f12601q = -1;
        this.f12602r = false;
        this.s = -1;
        this.f12603t = -1;
        this.f12604u = -1;
        this.f12605v = -1;
        this.f12606w = 0.9f;
        this.f12607x = 4;
        this.f12608y = 1;
        this.f12609z = 2.0f;
        new h(this, 26);
        s(r5, r10);
    }

    public Carousel(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12598n = new ArrayList();
        this.f12599o = 0;
        this.f12601q = -1;
        this.f12602r = false;
        this.s = -1;
        this.f12603t = -1;
        this.f12604u = -1;
        this.f12605v = -1;
        this.f12606w = 0.9f;
        this.f12607x = 4;
        this.f12608y = 1;
        this.f12609z = 2.0f;
        new h(this, 26);
        s(r5, r10);
    }
}
