package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class MotionHelper extends ConstraintHelper implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13666b;
    protected View[] c;
    private float d;

    public MotionHelper(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.f13665a = false;
        this.f13666b = false;
    }

    public MotionHelper(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.f13665a = false;
        this.f13666b = false;
        a(r6);
    }

    public MotionHelper(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.f13665a = false;
        this.f13666b = false;
        a(r7);
    }

    public void a(Canvas r1) {
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        super.a(r8);
        if (r8 == null) goto L19;
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r8, R.styleable.MotionHelper);
        int r0 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionHelper_onShow, "styleable", "MotionHelper_onShow")) goto L10;
        this.f13665a = r9.getBoolean(r2, this.f13665a);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionHelper_onHide, "styleable", "MotionHelper_onHide")) goto L12;
        this.f13666b = r9.getBoolean(r2, this.f13666b);
        goto L12
    L13:
        r9.recycle();
        return;
    }

    public void a(View r1, float r2) {
    }

    public void a(MotionLayout r1) {
    }

    public void a(MotionLayout r1, int r2) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.g
    public void a(MotionLayout r1, int r2, int r3) {
    }

    public void a(MotionLayout r1, int r2, int r3, float r4) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.g
    public void a(MotionLayout r1, int r2, boolean r3, float r4) {
    }

    public void a(MotionLayout r1, HashMap<View, m> r2) {
    }

    public boolean a() {
        return false;
    }

    public void b(Canvas r1) {
    }

    public boolean b() {
        return this.f13665a;
    }

    public boolean c() {
        return this.f13666b;
    }

    public float getProgress() {
        return this.d;
    }

    public void setProgress(float r6) {
        this.d = r6;
        int r1 = 0;
        if (this.k <= 0) goto L8;
        this.c = f((ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin"));
    L6:
        if (r1 >= this.k) goto L15;
        a(this.c[r1], r6);
        r1 = r1 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        int r2 = r0.getChildCount();
    L9:
        if (r1 >= r2) goto L20;
        View r3 = r0.getChildAt(r1);
        if (ZeusTransformUtils.instanceOf(r3, MotionHelper.class) == true) goto L14;
        a(r3, r6);
    L14:
        r1 = r1 + 1;
        goto L9
    }
}
