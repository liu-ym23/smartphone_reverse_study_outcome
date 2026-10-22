package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nJ*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0014J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u001dH\u0014J\b\u0010(\u001a\u00020\u001dH\u0014J\u0006\u0010)\u001a\u00020\u001dJ\u0006\u0010*\u001a\u00020\u001dJ\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0007J\u000e\u00101\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u0010R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/common_ui/view/ActivityIndicatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColor", "mStartAngle", "mStrokeWidth", "", "isAutoStart", "", "mLineCount", "minAlpha", "mAngleGradient", "mColors", "", "mPaint", "Landroid/graphics/Paint;", "mAnimHandler", "Landroid/os/Handler;", "mAnimRunnable", "Ljava/lang/Runnable;", "setup", "", "defStyleRes", "initialize", "onDraw", "canvas", "Landroid/graphics/Canvas;", "pointX", "angle", "radius", "pointY", "onAttachedToWindow", "onDetachedFromWindow", "start", "stop", "setColor", "color", "setStrokeWidth", "strokeWidth", "setStartAngle", "startAngle", "autoStart", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityIndicatorView extends View {
    public int a;
    public int b;
    public float c;
    public boolean d;
    public final int e;
    public final int[] f;
    public Paint g;
    public final Handler h;
    public final a i;

    public static final class a implements Runnable {
        public final /* synthetic */ ActivityIndicatorView a;

        @Override // java.lang.Runnable
        public final void run() {
            ActivityIndicatorView r0 = this.a;     // Catch: Throwable -> L4
            r0.b += r0.e;     // Catch: Throwable -> L4
            r0.invalidate();     // Catch: Throwable -> L4
            Handler r1 = this.a.h;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
            r1.postDelayed(this, 100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ActivityIndicatorView r1) {
            this.a = r1;
        }
    }

    public final void b() {
        Handler r0 = this.h;
        Intrinsics.checkNotNull(r0);
        r0.removeCallbacks(this.i);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d == false) goto L6;
        Handler r0 = this.h;
        Intrinsics.checkNotNull(r0);
        r0.post(this.i);
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h == null) goto L6;
        b();
        return;
    }

    public ActivityIndicatorView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        Intrinsics.checkNotNullParameter(r20, "canvas");
        super.onDraw(r20);
        int r9 = 2;
        int r1 = getWidth() / 2;
        int r10 = getHeight() / 2;
        float r11 = Math.min((getWidth() - getPaddingStart()) - getPaddingEnd(), (getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f;
        if (this.c != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        float r3 = 2;
        this.c = a(this.e / 2, r11 / r3) / r3;
    L8:
        Paint r4 = this.g;
        Intrinsics.checkNotNull(r4);
        r4.setStrokeWidth(this.c);
        int r12 = this.f.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        Paint r5 = this.g;
        Intrinsics.checkNotNull(r5);
        r5.setColor(this.f[r13]);
        float r6 = r1;
        float r7 = r9;
        float r8 = r11 / r7;
        float r14 = a(((-this.e) * r13) + this.b, r8) + r6;
        float r15 = r10;
        int r16 = r10;
        double r17 = ((double) (((-this.e) * r13) + this.b)) * 3.141592653589793d;
        double r18 = 180;
        float r21 = ((float) (((double) r8) * Math.sin(r17 / r18))) + r15;
        float r22 = a(((-this.e) * r13) + this.b, r11 - (this.c / r7)) + r6;
        int r23 = ((-this.e) * r13) + this.b;
        float r24 = r15 + ((float) ((r11 - (this.c / r7)) * Math.sin((((double) r23) * 3.141592653589793d) / r18)));
        Paint r25 = this.g;
        Intrinsics.checkNotNull(r25);
        r20.drawLine(r14, r21, r22, r24, r25);
        r13 = r13 + 1;
        r1 = r1;
        r10 = r16;
        r9 = 2;
        goto L9
    L11:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void setColor(int r1) {
        this.a = r1;
    }

    public final void setStartAngle(int r1) {
        this.b = r1;
    }

    public final void setStrokeWidth(float r1) {
        this.c = r1;
    }

    public ActivityIndicatorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static float a(int r4, float r5) {
        return (float) (((double) r5) * Math.cos((((double) r4) * 3.141592653589793d) / ((double) 180)));
    }

    public ActivityIndicatorView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.a = Color.argb(255, 255, 255, 255);
        this.e = 45;
        this.f = new int[8];
        this.h = new Handler(Looper.getMainLooper());
        this.i = new a(this);
        int r2 = 0;
        TypedArray r10 = r7.obtainStyledAttributes(r8, new int[]{2130970501, 2130970502, 2130970503, 2130970504}, r9, 0);
        this.a = r10.getColor(1, this.a);
        this.b = r10.getInt(2, this.b);
        this.c = r10.getDimension(3, this.c);
        this.d = r10.getBoolean(0, true);
        r10.recycle();
        this.g = new Paint(1);
        int r11 = Color.alpha(this.a);
        int r12 = Color.red(this.a);
        int r13 = Color.green(this.a);
        int r1 = Color.blue(this.a);
        int r3 = Math.abs(r11 + 0) / 8;
    L3:
        if (r2 >= 8) goto L5;
        this.f[r2] = Color.argb(r11 - (r3 * r2), r12, r13, r1);
        r2 = r2 + 1;
        goto L3
    L5:
        Paint r14 = this.g;
        Intrinsics.checkNotNull(r14);
        r14.setStrokeCap(Paint.Cap.ROUND);
    }
}
