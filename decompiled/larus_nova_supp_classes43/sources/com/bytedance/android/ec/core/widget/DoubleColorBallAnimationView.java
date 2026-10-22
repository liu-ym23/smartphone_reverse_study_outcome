package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/widget/DoubleColorBallAnimationView;", "Landroid/view/View;", "", "visibility", "", "setVisibility", "size", "setProgressBarInfo", "", "progress", "setProgress", "cycleBias", "setCycleBias", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DoubleColorBallAnimationView extends View {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final long f;
    public int g;
    public int h;
    public Paint i;
    public final PorterDuffXfermode j;
    public float k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    public long p;
    public int q;
    public float r;
    public float s;
    public float t;
    public float u;

    public final void d() {
        this.o = false;
        this.m = false;
        this.k = 0.0f;
    }

    public final void a() {
        this.p = -1;
        if (this.q > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(2131166404));
    L5:
        int r0 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.q <= r0) goto L10;
        if (r0 <= 0) goto L10;
        setProgressBarInfo(r0);
    L10:
        if (this.i != null) goto L12;
        Paint r1 = new Paint();
        r1.setAntiAlias(true);
        r1.setDither(true);
        r1.setStyle(Paint.Style.FILL);
        this.i = r1;
    L12:
        this.m = true;
    }

    public final void c() {
        a();
        this.o = true;
        this.l = true;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public DoubleColorBallAnimationView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null);
        b(r10);
    }

    public final void b(Context r10) {
        this.g = ContextCompat.getColor(r10, 2131101773);
        this.h = ContextCompat.getColor(r10, 2131101774);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        if (this.o == true) goto L7;
        if (this.l == false) goto L7;
        return;
    L7:
        if (this.m == false) goto L43;
        boolean r1 = false;
        if (this.l == false) goto L18;
        long r10 = System.nanoTime() / ((long) 1000000);
        if (this.p >= 0) goto L14;
        this.p = r10;
    L14:
        float r0 = (r10 - this.p) / this.e;
        this.k = r0;
        int r11 = (int) r0;
        if (((this.n + r11) & 1) != 1) goto L17;
        r1 = true;
    L17:
        this.k = r0 - r11;
        boolean r12 = r1;
    L19:
        float r14 = this.k;
        if (r14 >= 0.5d) goto L22;
        float r15 = (2 * r14) * r14;
    L23:
        float r16 = r15;
        int r17 = this.q;
        int r18 = r13.saveLayer(0.0f, 0.0f, r17, r17, this.i, 31);
        float r19 = (this.u * r16) + this.t;
        if (r16 >= 0.5d) goto L26;
        float r110 = r16 * 2.0f;
    L27:
        float r20 = this.a * r110;
        float r21 = this.s;
        float r22 = (r20 * r21) + r21;
        Paint r23 = this.i;
        Intrinsics.checkNotNull(r23);
        if (r12 == false) goto L30;
        int r24 = this.h;
    L31:
        r23.setColor(r24);
        Paint r25 = this.i;
        if (r25 == null) goto L34;
        r13.drawCircle(r19, this.r, r22, r25);
    L34:
        float r26 = this.q - r19;
        float r27 = this.s;
        float r28 = r27 - ((r110 * this.b) * r27);
        Paint r29 = this.i;
        Intrinsics.checkNotNull(r29);
        if (r12 == false) goto L37;
        int r30 = this.g;
    L38:
        r29.setColor(r30);
        Paint r31 = this.i;
        Intrinsics.checkNotNull(r31);
        r31.setXfermode(this.j);
        Paint r32 = this.i;
        if (r32 == null) goto L41;
        r13.drawCircle(r26, this.r, r28, r32);
    L41:
        Paint r33 = this.i;
        Intrinsics.checkNotNull(r33);
        r33.setXfermode(null);
        r13.restoreToCount(r18);
        postInvalidateDelayed(this.f);
        return;
    L37:
        r30 = this.h;
        goto L38
    L30:
        r24 = this.g;
        goto L31
    L26:
        float r34 = 2;
        r110 = r34 - (r16 * r34);
        goto L27
    L22:
        float r35 = 2;
        r15 = ((r35 * r14) * (r35 - r14)) - 1;
        goto L23
    L18:
        r12 = false;
        goto L19
    }

    public final void setCycleBias(int r1) {
        this.n = r1;
    }

    public final void setProgress(float r10) {
        if (this.m == true) goto L5;
        a();
    L5:
        this.k = r10;
        this.o = false;
        this.l = false;
        postInvalidate();
    }

    public final void setProgressBarInfo(int r10) {
        if (r10 <= 0) goto L5;
        this.q = r10;
        this.r = r10 / 2.0f;
        float r0 = (r10 >> 1) * this.d;
        this.s = r0;
        float r1 = (this.c * r10) + r0;
        this.t = r1;
        this.u = r10 - (r1 * 2);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        c();
        return;
    L5:
        d();
    }

    public DoubleColorBallAnimationView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0);
        b(r10);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r10) {
        super.onMeasure(r1, r10);
        int r11 = Math.min(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r10));
        if (this.q <= r11) goto L7;
        if (r11 <= 0) goto L8;
        setProgressBarInfo(r11);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = 0.25f;
        this.b = 0.375f;
        this.c = 0.16f;
        this.d = 0.32f;
        this.e = 400.0f;
        this.f = 17;
        this.j = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.p = -1;
        this.q = -1;
        b(r10);
    }
}
