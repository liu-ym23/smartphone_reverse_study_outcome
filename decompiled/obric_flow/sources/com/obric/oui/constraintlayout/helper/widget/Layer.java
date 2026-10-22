package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import hr.f;

/* JADX INFO: loaded from: classes3.dex */
public class Layer extends ConstraintHelper {
    public boolean A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f12639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12641o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12642p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12643q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f12644r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f12645t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f12646u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f12647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View[] f12648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f12649x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f12650y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12651z;

    public Layer(Context r5) {
        super(r5);
        this.f12636j = Float.NaN;
        this.f12637k = Float.NaN;
        this.f12638l = Float.NaN;
        this.f12640n = 1.0f;
        this.f12641o = 1.0f;
        this.f12642p = Float.NaN;
        this.f12643q = Float.NaN;
        this.f12644r = Float.NaN;
        this.s = Float.NaN;
        this.f12645t = Float.NaN;
        this.f12646u = Float.NaN;
        this.f12647v = true;
        this.f12648w = null;
        this.f12649x = 0.0f;
        this.f12650y = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void g(ConstraintLayout r5) {
        f(r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r10) {
        super.k(r10);
        int r5 = 0;
        this.e = false;
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
    L5:
        if (r5 >= r12) goto L13;
        int r13 = r11.getIndex(r5);
        if (r13 != R$styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.f12651z = true;
    L12:
        r5 = r5 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.A = true;
        goto L12
    L13:
        r11.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n() {
        s();
        this.f12642p = Float.NaN;
        this.f12643q = Float.NaN;
        f r5 = ((ConstraintLayout.LayoutParams) getLayoutParams()).f13027q0;
        r5.P(0);
        r5.M(0);
        r();
        int r10 = ((int) this.f12645t) - getPaddingLeft();
        int r11 = ((int) this.f12646u) - getPaddingTop();
        int r12 = (int) this.f12644r;
        int r13 = getPaddingRight() + r12;
        int r14 = (int) this.s;
        layout(r10, r11, r13, getPaddingBottom() + r14);
        t();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void o(ConstraintLayout r5) {
        this.f12639m = r5;
        float r10 = getRotation();
        if (r10 == 0.0f) goto L5;
        this.f12638l = r10;
        return;
    L5:
        if (Float.isNaN(this.f12638l) == true) goto L9;
        this.f12638l = r10;
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12639m = (ConstraintLayout) getParent();
        if (this.f12651z == false) goto L5;
    L6:
        int r5 = getVisibility();
        float r10 = getElevation();
        int r11 = 0;
    L8:
        if (r11 >= this.f12985b) goto L26;
        int r12 = this.f12984a[r11];
        View r13 = this.f12639m.e(r12);
        if (r13 == null) goto L19;
        if (this.f12651z == false) goto L15;
        r13.setVisibility(r5);
    L15:
        if (this.A == false) goto L19;
        if (r10 <= 0.0f) goto L19;
        r13.setTranslationZ(r13.getTranslationZ() + r10);
    L19:
        r11 = r11 + 1;
        goto L8
    L26:
        return;
    L5:
        if (this.A == true) goto L6;
    }

    public final void r() {
        if (this.f12639m != null) goto L6;
        return;
    L6:
        if (this.f12647v == true) goto L13;
        if (Float.isNaN(this.f12642p) == true) goto L13;
        if (Float.isNaN(this.f12643q) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.f12636j) == false) goto L15;
    L18:
        View[] r5 = j(this.f12639m);
        int r10 = 0;
        int r11 = r5[0].getLeft();
        int r12 = r5[0].getTop();
        int r13 = r5[0].getRight();
        int r14 = r5[0].getBottom();
    L20:
        if (r10 >= this.f12985b) goto L22;
        View r15 = r5[r10];
        r11 = Math.min(r11, r15.getLeft());
        r12 = Math.min(r12, r15.getTop());
        r13 = Math.max(r13, r15.getRight());
        r14 = Math.max(r14, r15.getBottom());
        r10 = r10 + 1;
        goto L20
    L22:
        this.f12644r = r13;
        this.s = r14;
        this.f12645t = r11;
        this.f12646u = r12;
        if (Float.isNaN(this.f12636j) == false) goto L25;
        this.f12642p = (r11 + r13) / 2;
    L27:
        if (Float.isNaN(this.f12637k) == false) goto L29;
        this.f12643q = (r12 + r14) / 2;
        return;
    L29:
        this.f12643q = this.f12637k;
        return;
    L25:
        this.f12642p = this.f12636j;
        goto L27
    L15:
        if (Float.isNaN(this.f12637k) == true) goto L18;
        this.f12643q = this.f12637k;
        this.f12642p = this.f12636j;
    }

    public final void s() {
        if (this.f12639m != null) goto L5;
        return;
    L5:
        int r5 = this.f12985b;
        if (r5 != 0) goto L8;
        return;
    L8:
        View[] r10 = this.f12648w;
        if (r10 != null) goto L11;
    L12:
        this.f12648w = new View[r5];
    L13:
        int r11 = 0;
    L15:
        if (r11 >= this.f12985b) goto L17;
        int r12 = this.f12984a[r11];
        this.f12648w[r11] = this.f12639m.e(r12);
        r11 = r11 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r10.length == r5) goto L13;
        goto L12
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        super.setElevation(r5);
        e();
    }

    @Override // android.view.View
    public void setPivotX(float r5) {
        this.f12636j = r5;
        t();
    }

    @Override // android.view.View
    public void setPivotY(float r5) {
        this.f12637k = r5;
        t();
    }

    @Override // android.view.View
    public void setRotation(float r5) {
        this.f12638l = r5;
        t();
    }

    @Override // android.view.View
    public void setScaleX(float r5) {
        this.f12640n = r5;
        t();
    }

    @Override // android.view.View
    public void setScaleY(float r5) {
        this.f12641o = r5;
        t();
    }

    @Override // android.view.View
    public void setTranslationX(float r5) {
        this.f12649x = r5;
        t();
    }

    @Override // android.view.View
    public void setTranslationY(float r5) {
        this.f12650y = r5;
        t();
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        e();
    }

    public final void t() {
        if (this.f12639m != null) goto L6;
        return;
    L6:
        if (this.f12648w != null) goto L8;
        s();
    L8:
        r();
        if (Float.isNaN(this.f12638l) == false) goto L11;
        double r5 = 0.0d;
    L12:
        float r10 = (float) Math.sin(r5);
        float r11 = (float) Math.cos(r5);
        float r12 = this.f12640n;
        float r13 = r12 * r11;
        float r14 = this.f12641o;
        float r15 = (-r14) * r10;
        float r16 = r12 * r10;
        float r17 = r14 * r11;
        int r18 = 0;
    L14:
        if (r18 >= this.f12985b) goto L19;
        View r19 = this.f12648w[r18];
        int r20 = (r19.getRight() + r19.getLeft()) / 2;
        int r21 = (r19.getBottom() + r19.getTop()) / 2;
        float r22 = r20 - this.f12642p;
        float r23 = r21 - this.f12643q;
        float r24 = (((r15 * r23) + (r13 * r22)) - r22) + this.f12649x;
        float r25 = (((r17 * r23) + (r22 * r16)) - r23) + this.f12650y;
        r19.setTranslationX(r24);
        r19.setTranslationY(r25);
        r19.setScaleY(this.f12641o);
        r19.setScaleX(this.f12640n);
        if (Float.isNaN(this.f12638l) == true) goto L18;
        r19.setRotation(this.f12638l);
    L18:
        r18 = r18 + 1;
        goto L14
    L19:
        return;
    L11:
        r5 = Math.toRadians(this.f12638l);
        goto L12
    }

    public Layer(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12636j = Float.NaN;
        this.f12637k = Float.NaN;
        this.f12638l = Float.NaN;
        this.f12640n = 1.0f;
        this.f12641o = 1.0f;
        this.f12642p = Float.NaN;
        this.f12643q = Float.NaN;
        this.f12644r = Float.NaN;
        this.s = Float.NaN;
        this.f12645t = Float.NaN;
        this.f12646u = Float.NaN;
        this.f12647v = true;
        this.f12648w = null;
        this.f12649x = 0.0f;
        this.f12650y = 0.0f;
    }

    public Layer(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12636j = Float.NaN;
        this.f12637k = Float.NaN;
        this.f12638l = Float.NaN;
        this.f12640n = 1.0f;
        this.f12641o = 1.0f;
        this.f12642p = Float.NaN;
        this.f12643q = Float.NaN;
        this.f12644r = Float.NaN;
        this.s = Float.NaN;
        this.f12645t = Float.NaN;
        this.f12646u = Float.NaN;
        this.f12647v = true;
        this.f12648w = null;
        this.f12649x = 0.0f;
        this.f12650y = 0.0f;
    }
}
