package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    MotionLayout f13738b;
    float[] c;
    Matrix d;
    int e;
    int f;
    float g;
    private Paint h;

    public MotionTelltales(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.h = new Paint();
        this.c = new float[2];
        this.d = new Matrix();
        this.e = 0;
        this.f = -65281;
        this.g = 0.25f;
        a(r4, null);
    }

    public MotionTelltales(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.h = new Paint();
        this.c = new float[2];
        this.d = new Matrix();
        this.e = 0;
        this.f = -65281;
        this.g = 0.25f;
        a(r5, r6);
    }

    public MotionTelltales(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.h = new Paint();
        this.c = new float[2];
        this.d = new Matrix();
        this.e = 0;
        this.f = -65281;
        this.g = 0.25f;
        a(r6, r7);
    }

    private void a(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.MotionTelltales);
        int r11 = r10.getIndexCount();
        int r0 = 0;
    L5:
        if (r0 >= r11) goto L16;
        int r1 = r10.getIndex(r0);
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.MotionTelltales_telltales_tailColor, "styleable", "MotionTelltales_telltales_tailColor")) goto L10;
        this.f = r10.getColor(r1, this.f);
    L15:
        r0 = r0 + 1;
        goto L5
    L10:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.MotionTelltales_telltales_velocityMode, "styleable", "MotionTelltales_telltales_velocityMode")) goto L13;
        this.e = r10.getInt(r1, this.e);
        goto L15
    L13:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.MotionTelltales_telltales_tailScale, "styleable", "MotionTelltales_telltales_tailScale")) goto L15;
        this.g = r10.getFloat(r1, this.g);
        goto L15
    L16:
        r10.recycle();
    L17:
        this.h.setColor(this.f);
        this.h.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.obric.oui.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas r23) {
        super.onDraw(r23);
        getMatrix().invert(this.d);
        if (this.f13738b != null) goto L8;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, MotionLayout.class) == false) goto L17;
        this.f13738b = (MotionLayout) ZeusTransformUtils.preCheckCast(r0, MotionLayout.class, "com.obric.memorydata.plugin");
        return;
    L17:
        return;
    L8:
        int r7 = getWidth();
        int r8 = getHeight();
        float[] r10 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r12 = 0;
    L9:
        if (r12 >= 5) goto L14;
        float r13 = r10[r12];
        int r14 = 0;
    L11:
        if (r14 >= 5) goto L13;
        float r15 = r10[r14];
        this.f13738b.getViewVelocity(this, r15, r13, this.c, this.e);
        this.d.mapVectors(this.c);
        float r17 = r7 * r15;
        float r18 = r8 * r13;
        float[] r1 = this.c;
        float r2 = r1[0];
        float r3 = this.g;
        float r20 = r18 - (r1[1] * r3);
        this.d.mapVectors(r1);
        r23.drawLine(r17, r18, r17 - (r2 * r3), r20, this.h);
        r14 = r14 + 1;
        goto L11
    L13:
        r12 = r12 + 1;
        goto L9
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        postInvalidate();
    }

    public void setText(CharSequence r3) {
        this.f13729a = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        requestLayout();
    }
}
