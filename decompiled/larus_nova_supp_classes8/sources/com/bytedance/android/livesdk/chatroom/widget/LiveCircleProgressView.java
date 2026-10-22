package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveCircleProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "maxProgress", "setMaxProgress", "color", "setBgCircleColor", "setProgressColor", "width", "setCircleWidth", "setBgCircleWidth", "angle", "setStartAngle", "c", "I", "getWidth$livecommonui_saasRelease", "()I", "setWidth$livecommonui_saasRelease", "(I)V", "d", "getHeight$livecommonui_saasRelease", "setHeight$livecommonui_saasRelease", "height", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCircleProgressView extends View {
    public Paint a;
    public Paint b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public final int getHeight$livecommonui_saasRelease() {
        return this.d;
    }

    public final int getWidth$livecommonui_saasRelease() {
        return this.c;
    }

    public LiveCircleProgressView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        int r0 = this.c;
        float r1 = r0 / 2.0f;
        float r3 = this.d / 2.0f;
        float r2 = (r0 / 2.0f) - this.h;
        Paint r4 = this.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r12.drawCircle(r1, r3, r2, r4);
        int r5 = this.h;
        RectF r6 = new RectF(r5, r5, this.c - r5, this.d - r5);
        float r7 = this.g - 90;
        float r8 = ((this.e * 1.0f) / this.f) * 360;
        Paint r10 = this.b;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L8:
        r12.drawArc(r6, r7, r8, false, r10);
    }

    public final void setBgCircleColor(int r3) {
        Paint r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r0.setColor(r3);
    }

    public final void setBgCircleWidth(int r3) {
        this.h = r3 / 2;
        Paint r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r0.setStrokeWidth(r3);
    }

    public final void setCircleWidth(int r3) {
        Paint r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r0.setStrokeWidth(r3);
    }

    public final void setHeight$livecommonui_saasRelease(int r1) {
        this.d = r1;
    }

    public final void setMaxProgress(int r1) {
        this.f = r1;
    }

    public final void setProgress(int r1) {
        this.e = r1;
        invalidate();
    }

    public final void setProgressColor(int r3) {
        Paint r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r0.setColor(r3);
    }

    public final void setStartAngle(int r1) {
        this.g = r1;
    }

    public final void setWidth$livecommonui_saasRelease(int r1) {
        this.c = r1;
    }

    public LiveCircleProgressView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.f = 100;
        Paint r4 = new Paint();
        this.a = r4;
        r4.setAntiAlias(true);
        Paint r5 = this.a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r5.setStyle(Paint.Style.STROKE);
        Paint r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L8:
        Paint r6 = new Paint(r0);
        this.b = r6;
        r6.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.c = View.MeasureSpec.getSize(r1);
        this.d = View.MeasureSpec.getSize(r2);
    }
}
