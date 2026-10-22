package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0018\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/common_ui/widget/CustomCircularProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progressPaint", "Landroid/graphics/Paint;", "backgroundPaint", "progress", "", "maxProgress", "progressWidth", "progressRect", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setProgress", "setProgressColor", "color", "setProgressBackgroundColor", "setProgressWidth", "width", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomCircularProgressBar extends View {
    public final Paint a;
    public final Paint b;
    public float c;
    public final float d;
    public float e;
    public final RectF f;

    public CustomCircularProgressBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomCircularProgressBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        float r0 = Math.min(getWidth(), getHeight()) - this.e;
        float r1 = getWidth() / 2.0f;
        float r3 = getHeight() / 2.0f;
        float r2 = r0 / 2.0f;
        this.f.set(r1 - r2, r3 - r2, r1 + r2, r3 + r2);
        r9.drawOval(this.f, this.b);
        r9.drawArc(this.f, -90.0f, (360 * this.c) / this.d, false, this.a);
    }

    public final void setProgress(float r3) {
        this.c = RangesKt.coerceIn(r3, 0.0f, this.d);
        invalidate();
    }

    public final void setProgressBackgroundColor(int r2) {
        this.b.setColor(r2);
        invalidate();
    }

    public final void setProgressColor(int r2) {
        this.a.setColor(r2);
        invalidate();
    }

    public final void setProgressWidth(float r2) {
        this.e = r2;
        this.a.setStrokeWidth(r2);
        this.b.setStrokeWidth(r2);
        invalidate();
    }

    public CustomCircularProgressBar(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        Paint r8 = new Paint(1);
        this.a = r8;
        Paint r1 = new Paint(1);
        this.b = r1;
        this.c = 20.0f;
        this.d = 100.0f;
        this.e = 10.0f;
        this.f = new RectF();
        TypedArray r9 = r5.getTheme().obtainStyledAttributes(r6, new int[]{2130972134, 2130972135, 2130972136}, 0, 0);
        this.e = r9.getDimension(2, this.e);     // Catch: Throwable -> L6
        r8.setColor(r9.getColor(1, -16744448));     // Catch: Throwable -> L6
        r1.setColor(r9.getColor(0, -16711936));     // Catch: Throwable -> L6
        r9.recycle();
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeWidth(this.e);
        r1.setStyle(Paint.Style.STROKE);
        r1.setStrokeWidth(this.e);
        return;
    L6:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    public /* synthetic */ CustomCircularProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
