package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Layer extends ConstraintHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConstraintLayout f13655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f13656b;
    protected float c;
    protected float d;
    protected float e;
    protected float f;
    protected float g;
    boolean h;
    View[] i;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private boolean y;
    private boolean z;

    public Layer(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 1.0f;
        this.v = 1.0f;
        this.f13656b = Float.NaN;
        this.c = Float.NaN;
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = true;
        this.i = null;
        this.w = 0.0f;
        this.x = 0.0f;
    }

    public Layer(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 1.0f;
        this.v = 1.0f;
        this.f13656b = Float.NaN;
        this.c = Float.NaN;
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = true;
        this.i = null;
        this.w = 0.0f;
        this.x = 0.0f;
    }

    public Layer(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 1.0f;
        this.v = 1.0f;
        this.f13656b = Float.NaN;
        this.c = Float.NaN;
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = true;
        this.i = null;
        this.w = 0.0f;
        this.x = 0.0f;
    }

    private void b() {
        if (this.f13655a != null) goto L6;
        return;
    L6:
        if (this.k != 0) goto L8;
        return;
    L8:
        View[] r0 = this.i;
        if (r0 != null) goto L11;
    L12:
        this.i = new View[this.k];
    L13:
        int r1 = 0;
    L15:
        if (r1 >= this.k) goto L17;
        int r2 = this.j[r1];
        this.i[r1] = this.f13655a.getViewById(r2);
        r1 = r1 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r0.length == this.k) goto L13;
        goto L12
    }

    private void c() {
        if (this.f13655a != null) goto L6;
        return;
    L6:
        if (this.i != null) goto L8;
        b();
    L8:
        a();
        if (Float.isNaN(this.t) == false) goto L11;
        double r0 = 0.0d;
    L12:
        float r2 = (float) Math.sin(r0);
        float r1 = (float) Math.cos(r0);
        float r3 = this.u;
        float r4 = r3 * r1;
        float r5 = this.v;
        float r6 = (-r5) * r2;
        float r7 = r3 * r2;
        float r8 = r5 * r1;
        int r9 = 0;
    L14:
        if (r9 >= this.k) goto L19;
        View r10 = this.i[r9];
        int r11 = (r10.getLeft() + r10.getRight()) / 2;
        int r12 = (r10.getTop() + r10.getBottom()) / 2;
        float r13 = r11 - this.f13656b;
        float r14 = r12 - this.c;
        float r15 = (((r4 * r13) + (r6 * r14)) - r13) + this.w;
        float r16 = (((r13 * r7) + (r8 * r14)) - r14) + this.x;
        r10.setTranslationX(r15);
        r10.setTranslationY(r16);
        r10.setScaleY(this.v);
        r10.setScaleX(this.u);
        if (Float.isNaN(this.t) == true) goto L18;
        r10.setRotation(this.t);
    L18:
        r9 = r9 + 1;
        goto L14
    L19:
        return;
    L11:
        r0 = Math.toRadians(this.t);
        goto L12
    }

    public void a() {
        if (this.f13655a != null) goto L6;
        return;
    L6:
        if (this.h == true) goto L13;
        if (Float.isNaN(this.f13656b) == true) goto L13;
        if (Float.isNaN(this.c) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.r) == false) goto L15;
    L18:
        View[] r0 = f(this.f13655a);
        int r1 = 0;
        int r2 = r0[0].getLeft();
        int r3 = r0[0].getTop();
        int r4 = r0[0].getRight();
        int r5 = r0[0].getBottom();
    L20:
        if (r1 >= this.k) goto L22;
        View r6 = r0[r1];
        r2 = Math.min(r2, r6.getLeft());
        r3 = Math.min(r3, r6.getTop());
        r4 = Math.max(r4, r6.getRight());
        r5 = Math.max(r5, r6.getBottom());
        r1 = r1 + 1;
        goto L20
    L22:
        this.d = r4;
        this.e = r5;
        this.f = r2;
        this.g = r3;
        if (Float.isNaN(this.r) == false) goto L25;
        float r7 = (r2 + r4) / 2;
    L26:
        this.f13656b = r7;
        if (Float.isNaN(this.s) == false) goto L29;
        float r8 = (r3 + r5) / 2;
    L30:
        this.c = r8;
        return;
    L29:
        r8 = this.s;
        goto L30
    L25:
        r7 = this.r;
        goto L26
    L15:
        if (Float.isNaN(this.s) == true) goto L18;
        this.c = this.s;
        this.f13656b = this.r;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super.a(r9);
        int r0 = 0;
        this.n = false;
        if (r9 == null) goto L19;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r1 = r10.getIndexCount();
    L5:
        if (r0 >= r1) goto L13;
        int r2 = r10.getIndex(r0);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_visibility, "styleable", "ConstraintLayout_Layout_android_visibility")) goto L10;
        this.y = true;
    L12:
        r0 = r0 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_elevation, "styleable", "ConstraintLayout_Layout_android_elevation")) goto L12;
        this.z = true;
        goto L12
    L13:
        r10.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(ConstraintLayout r2) {
        this.f13655a = r2;
        float r3 = getRotation();
        if (r3 == 0.0f) goto L5;
    L6:
        this.t = r3;
        return;
    L5:
        if (Float.isNaN(this.t) == false) goto L6;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void b(ConstraintLayout r5) {
        b();
        this.f13656b = Float.NaN;
        this.c = Float.NaN;
        ConstraintWidget r6 = ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).a();
        r6.q(0);
        r6.r(0);
        a();
        layout(((int) this.f) - getPaddingLeft(), ((int) this.g) - getPaddingTop(), ((int) this.d) + getPaddingRight(), ((int) this.e) + getPaddingBottom());
        c();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void c(ConstraintLayout r1) {
        d(r1);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f13655a = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (this.y == false) goto L5;
    L6:
        int r0 = getVisibility();
        float r1 = getElevation();
        int r2 = 0;
    L8:
        if (r2 >= this.k) goto L26;
        int r3 = this.j[r2];
        View r4 = this.f13655a.getViewById(r3);
        if (r4 == null) goto L19;
        if (this.y == false) goto L15;
        r4.setVisibility(r0);
    L15:
        if (this.z == false) goto L19;
        if (r1 <= 0.0f) goto L19;
        r4.setTranslationZ(r4.getTranslationZ() + r1);
    L19:
        r2 = r2 + 1;
        goto L8
    L26:
        return;
    L5:
        if (this.z == true) goto L6;
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        e();
    }

    @Override // android.view.View
    public void setPivotX(float r1) {
        this.r = r1;
        c();
    }

    @Override // android.view.View
    public void setPivotY(float r1) {
        this.s = r1;
        c();
    }

    @Override // android.view.View
    public void setRotation(float r1) {
        this.t = r1;
        c();
    }

    @Override // android.view.View
    public void setScaleX(float r1) {
        this.u = r1;
        c();
    }

    @Override // android.view.View
    public void setScaleY(float r1) {
        this.v = r1;
        c();
    }

    @Override // android.view.View
    public void setTranslationX(float r1) {
        this.w = r1;
        c();
    }

    @Override // android.view.View
    public void setTranslationY(float r1) {
        this.x = r1;
        c();
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        e();
    }
}
