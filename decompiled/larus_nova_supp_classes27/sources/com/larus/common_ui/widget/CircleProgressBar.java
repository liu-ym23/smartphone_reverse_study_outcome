package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u0014H\u0002J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/widget/CircleProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRadius", "mStrokeWidth", "mProgressbarInset", "mProgressbarBgColor", "mProgressColor", "mProgressGradientStartColor", "Ljava/lang/Integer;", "mProgressGradientEndColor", "mStartAngle", "mCurrentAngle", "", "mSweepAngle", "mMaxProgress", "mCurrentProgress", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawProgressbarBg", "rectF", "Landroid/graphics/RectF;", "drawProgress", "createProgressGradient", "Landroid/graphics/SweepGradient;", "sweepAngle", "setProgress", "progress", "getProgress", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleProgressBar extends View {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Integer f;
    public final Integer g;
    public final int h;
    public float i;
    public final int j;
    public final int k;
    public int l;

    public static final class a {
    }

    static {
    }

    public CircleProgressBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CircleProgressBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int getProgress() {
        return this.l;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        Intrinsics.checkNotNullParameter(r20, "canvas");
        int r1 = getWidth() / 2;
        RectF r10 = new RectF();
        int r2 = this.c;
        r10.left = r2;
        r10.top = r2;
        int r3 = r1 * 2;
        r10.right = r3 - r2;
        r10.bottom = r3 - r2;
        Paint r7 = new Paint();
        r7.setStyle(Paint.Style.STROKE);
        r7.setStrokeWidth(this.b);
        r7.setAntiAlias(true);
        r7.setColor(this.d);
        r7.setStrokeCap(Paint.Cap.ROUND);
        r20.drawArc(r10, this.h, this.j, false, r7);
        Paint r8 = new Paint();
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeWidth(this.b);
        r8.setAntiAlias(true);
        r8.setStrokeCap(Paint.Cap.ROUND);
        float r4 = 360 * ((this.l * 1.0f) / this.k);
        this.i = r4;
        Integer r5 = this.f;
        if (r5 == null) goto L18;
        int r6 = r5.intValue();
        Integer r9 = this.g;
        if (r9 == null) goto L18;
        int r11 = r9.intValue();
        if (r4 <= 0.0f) goto L18;
        float r12 = RangesKt.coerceIn(r4 / this.j, 0.0f, 1.0f);
        if (r12 >= 1.0f) goto L16;
        float r13 = r10.width() / 2.0f;
        if (r13 <= 0.0f) goto L14;
        float r14 = (float) (Math.asin(RangesKt.coerceIn((this.b / 2.0f) / r13, 0.0f, 1.0f)) / 6.283185307179586d);
    L15:
        float r15 = RangesKt.coerceAtLeast(1.0f - r14, r12);
        SweepGradient r16 = new SweepGradient(r10.centerX(), r10.centerY(), new int[]{r6, ColorUtils.blendARGB(r6, r11, 0.5f), r11, r11, r6, r6}, new float[]{0.0f, 0.25f * r12, r12, RangesKt.coerceAtMost(r14 + r12, r15), r15, 1.0f});
    L17:
        Matrix r17 = new Matrix();
        r17.setRotate(this.h, r10.centerX(), r10.centerY());
        r16.setLocalMatrix(r17);
    L19:
        r8.setShader(r16);
        if (r8.getShader() != null) goto L22;
        r8.setColor(this.e);
    L22:
        r20.drawArc(r10, this.h, this.i, false, r8);
        return;
    L14:
        r14 = 0.0f;
        goto L15
    L16:
        r16 = new SweepGradient(r10.centerX(), r10.centerY(), r6, r11);
    L18:
        r16 = null;
        goto L19
    }

    public final void setProgress(int r4) {
        if (r4 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L12;
        int r1 = this.k;
        if (r4 <= r1) goto L9;
        r4 = r1;
    L9:
        this.l = r4;
        this.i = 360 * ((r4 * 1.0f) / r1);
        invalidate();
        return;
    L12:
        throw new IllegalArgumentException("Progress value can not be less than 0".toString());
    L4:
        r0 = false;
        goto L5
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        int r4 = View.MeasureSpec.getMode(r2);
        if (r4 == Integer.MIN_VALUE) goto L9;
        if (r4 == 0) goto L9;
        if (r4 == 1073741824) goto L8;
        int r5 = 0;
    L10:
        setMeasuredDimension(r5, r5);
        return;
    L8:
        r5 = View.MeasureSpec.getSize(r2);
    L9:
        r5 = this.a * 2;
        goto L10
    }

    public CircleProgressBar(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.h = -90;
        this.j = 360;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130972048, 2130972133, 2130972139, 2130972140, 2130972141, 2130972142, 2130972143, 2130972151, 2130972315});
        this.a = r6.getDimensionPixelSize(7, 10);
        int r7 = r6.getDimensionPixelSize(8, 8);
        this.b = r7;
        this.c = r6.getDimensionPixelSize(6, r7);
        this.d = r6.getColor(2, ContextCompat.getColor(r3, c.b(2130972081, r3, 2131103143)));
        int r8 = r6.getColor(3, ContextCompat.getColor(r3, c.b(2130972123, r3, 2131103203)));
        this.e = r8;
        Integer r1 = null;
        if (r6.hasValue(5) == false) goto L5;
        Integer r9 = Integer.valueOf(r6.getColor(5, r8));
    L6:
        this.f = r9;
        if (r6.hasValue(4) == false) goto L9;
        r1 = Integer.valueOf(r6.getColor(4, r8));
    L9:
        this.g = r1;
        this.k = r6.getInt(0, 100);
        this.l = r6.getInt(1, 0);
        r6.recycle();
        return;
    L5:
        r9 = null;
        goto L6
    }

    public /* synthetic */ CircleProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
