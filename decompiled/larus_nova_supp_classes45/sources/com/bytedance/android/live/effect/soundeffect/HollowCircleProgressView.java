package com.bytedance.android.live.effect.soundeffect;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/HollowCircleProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "maxProgress", "setMaxProgress", "color", "setBgCircleColor", "", "width", "setCircleWidth", "angle", "setStartAngle", "c", "I", "getWidth$liveeffect_saasRelease", "()I", "setWidth$liveeffect_saasRelease", "(I)V", "d", "getHeight$liveeffect_saasRelease", "setHeight$liveeffect_saasRelease", "height", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HollowCircleProgressView extends View {
    public Paint a;
    public Paint b;
    public int c;
    public int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public final RectF l;

    public final int getHeight$liveeffect_saasRelease() {
        return this.d;
    }

    public final int getWidth$liveeffect_saasRelease() {
        return this.c;
    }

    public HollowCircleProgressView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        int r0 = r12.saveLayer(0.0f, 0.0f, this.c, this.d, null);
        float r1 = this.i;
        Paint r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r12.drawCircle(r1, r1, r1, r2);
        float r3 = this.j;
        if (r3 <= 0) goto L8;
        RectF r4 = this.l;
        float r5 = this.c / 2;
        float r6 = r5 + r3;
        r4.set(r5 - r3, (this.d / 2) - r3, r6, r6);
    L9:
        RectF r7 = this.l;
        float r8 = this.h - 90;
        float r9 = ((this.f * 1.0f) / this.g) * 360;
        Paint r11 = this.b;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L12:
        r12.drawArc(r7, r8, r9, false, r11);
        r12.restoreToCount(r0);
        return;
    L8:
        RectF r13 = this.l;
        float r14 = this.i;
        r13.set(r14, r14, this.c - r14, this.d - r14);
        goto L9
    }

    public final void setBgCircleColor(int r3) {
        Paint r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r0.setColor(r3);
    }

    public final void setCircleWidth(float r3) {
        Paint r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r0.setStrokeWidth(r3);
    }

    public final void setHeight$liveeffect_saasRelease(int r1) {
        this.d = r1;
    }

    public final void setMaxProgress(int r1) {
        this.g = r1;
    }

    public final void setProgress(int r1) {
        this.f = r1;
        invalidate();
    }

    public final void setStartAngle(int r1) {
        this.h = r1;
    }

    public final void setWidth$liveeffect_saasRelease(int r1) {
        this.c = r1;
    }

    public HollowCircleProgressView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.g = 100;
        if (r5 == null) goto L5;
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130974719, 2130974724, 2130974725, 2130974726, 2130974727});
        this.j = r6.getDimension(1, -1.0f);
        this.k = r6.getDimension(2, -1.0f);
        this.e = r6.getColor(0, 0);
        this.f = r6.getInteger(4, 0);
        this.g = r6.getInteger(3, 100);
        r6.recycle();
    L5:
        Paint r7 = new Paint();
        this.a = r7;
        r7.setColor(this.e);
        Paint r8 = this.a;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L8:
        r8.setAntiAlias(true);
        Paint r9 = this.a;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L11:
        r9.setStyle(Paint.Style.FILL);
        Paint r11 = new Paint();
        this.b = r11;
        r11.setColor(-16777216);
        Paint r12 = this.b;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L14:
        r12.setStyle(Paint.Style.STROKE);
        Paint r13 = this.b;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L17:
        r13.setStrokeWidth(this.k);
        Paint r14 = this.b;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L20:
        r14.setStrokeCap(Paint.Cap.ROUND);
        Paint r15 = this.b;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L23:
        r15.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.l = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        this.c = View.MeasureSpec.getSize(r4);
        this.d = View.MeasureSpec.getSize(r5);
        float r6 = this.c / 2.0f;
        this.i = r6;
        if (this.j != (-1.0f)) goto L6;
        this.j = (3 * r6) / 7;
    L6:
        if (this.k != (-1.0f)) goto L9;
        float r7 = (r6 * 2) / 7;
        this.k = r7;
        setCircleWidth(r7);
        return;
    }
}
