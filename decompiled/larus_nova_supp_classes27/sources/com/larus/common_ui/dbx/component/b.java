package com.larus.common_ui.dbx.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b extends View {
    public final Paint a;
    public final RectF b;
    public ValueAnimator c;
    public boolean d;
    public int e;

    public final void a() {
        if (this.d == true) goto L5;
    L19:
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L22;
        r0.cancel();
    L22:
        this.c = null;
        return;
    L5:
        if (isAttachedToWindow() == false) goto L19;
        if (isShown() == false) goto L19;
        if (getWindowVisibility() != 0) goto L19;
        ValueAnimator r1 = this.c;
        if (r1 == null) goto L15;
        boolean r2 = true;
        if (r1.isRunning() != true) goto L15;
    L16:
        if (r2 == true) goto L25;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r3.setDuration(1000);
        r3.setRepeatCount(-1);
        r3.setInterpolator(new LinearInterpolator());
        r3.addUpdateListener(new a(this));
        r3.start();
        this.c = r3;
        return;
    L25:
        return;
    L15:
        r2 = false;
        goto L16
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.c = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public final int getRingColor() {
        return this.e;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        Paint r3 = new Paint(1);
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeCap(Paint.Cap.ROUND);
        this.a = r3;
        this.b = new RectF();
        this.e = -16777216;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        float r0 = Math.min(getWidth(), getHeight());
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        float r1 = 0.12f * r0;
        this.a.setStrokeWidth(r1);
        float r2 = getWidth() / 2.0f;
        float r4 = getHeight() / 2.0f;
        this.a.setShader(new SweepGradient(r2, r4, new int[]{this.e & 16777215, this.e}, new float[]{0.0f, 1.0f}));
        float r3 = (r0 - r1) / 2.0f;
        this.b.set(r2 - r3, r4 - r3, r2 + r3, r4 + r3);
        r13.drawArc(this.b, 0.0f, 360.0f, false, this.a);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        a();
    }

    public final void setRingColor(int r1) {
        this.e = r1;
        invalidate();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        a();
    }
}
