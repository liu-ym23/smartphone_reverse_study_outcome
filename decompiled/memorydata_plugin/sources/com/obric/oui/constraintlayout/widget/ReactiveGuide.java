package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ReactiveGuide extends View implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13757b;
    private int c;
    private boolean d;

    public ReactiveGuide(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.f13756a = -1;
        this.f13757b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        a(null);
    }

    public ReactiveGuide(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.f13756a = -1;
        this.f13757b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        a(r6);
    }

    public ReactiveGuide(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.f13756a = -1;
        this.f13757b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        a(r7);
    }

    private void a(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r8, R.styleable.ConstraintLayout_ReactiveGuide);
        int r0 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L19;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_valueId")) goto L10;
        this.f13756a = r9.getResourceId(r2, this.f13756a);
    L18:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange")) goto L13;
        this.f13757b = r9.getBoolean(r2, this.f13757b);
        goto L18
    L13:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet")) goto L16;
        this.c = r9.getResourceId(r2, this.c);
        goto L18
    L16:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets, "styleable", "ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets")) goto L18;
        this.d = r9.getBoolean(r2, this.d);
        goto L18
    L19:
        r9.recycle();
    L21:
        if (this.f13756a == (-1)) goto L30;
        ConstraintLayout.getSharedValues().a(this.f13756a, this);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
    }

    public int getApplyToConstraintSetId() {
        return this.c;
    }

    public int getAttributeId() {
        return this.f13756a;
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean r1) {
        this.f13757b = r1;
    }

    public void setApplyToConstraintSetId(int r1) {
        this.c = r1;
    }

    public void setAttributeId(int r4) {
        d r0 = ConstraintLayout.getSharedValues();
        int r1 = this.f13756a;
        if (r1 == (-1)) goto L5;
        r0.b(r1, this);
    L5:
        this.f13756a = r4;
        if (r4 == (-1)) goto L9;
        r0.a(r4, this);
        return;
    }

    public void setGuidelineBegin(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r0.f13747a = r4;
        setLayoutParams(r0);
    }

    public void setGuidelineEnd(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r0.f13748b = r4;
        setLayoutParams(r0);
    }

    public void setGuidelinePercent(float r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r0.c = r4;
        setLayoutParams(r0);
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
    }
}
