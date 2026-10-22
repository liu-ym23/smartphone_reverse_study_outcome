package com.obric.assistant.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J0\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0007H\u0016J\u001c\u0010+\u001a\u00020\u00072\b\b\u0001\u0010,\u001a\u00020\u00072\b\b\u0001\u0010-\u001a\u00020\u0007H\u0003R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/assistant/view/ObricShimmerProgressBar;", "Landroid/widget/ProgressBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "gradient", "Landroid/graphics/LinearGradient;", "gradientMatrix", "Landroid/graphics/Matrix;", "translateXY", "", "progressColor", "progressColorAlpha", "shimmerColors", "", "shimmerPositions", "", "animator", "Landroid/animation/ValueAnimator;", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startShimmer", "stopShimmer", "onLayout", "changed", "", "left", "top", "right", "bottom", "setProgress", "progress", "applyAlpha", "color", "alpha", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricShimmerProgressBar extends ProgressBar {
    public static final /* synthetic */ int h = 0;
    public final Paint a;
    public LinearGradient b;
    public final Matrix c;
    public float d;
    public final int[] e;
    public final float[] f;
    public ValueAnimator g;

    public static final class a implements Runnable {
        public final /* synthetic */ ObricShimmerProgressBar a;

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator r0 = this.a.g;     // Catch: Throwable -> L9
            if (r0 == null) goto L5;
            r0.start();     // Catch: Throwable -> L9
        L5:
            ObricShimmerProgressBar r1 = this.a;     // Catch: Throwable -> L9
            if (r1.g == null) goto L12;
            r1.postDelayed(this, 1000);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(ObricShimmerProgressBar r1) {
            this.a = r1;
        }
    }

    public ObricShimmerProgressBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ObricShimmerProgressBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        ValueAnimator r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, (getWidth() * (getProgress() / getMax())) * 2.0f});
        r2.setDuration(800);
        r2.setInterpolator(new LinearInterpolator());
        r2.addUpdateListener(new u(this));
        this.g = r2;
        post(new a(this));
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.g = null;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        if (this.b != null) goto L5;
        LinearGradient r0 = new LinearGradient((getProgress() / getMax()) * (-getWidth()), 0.0f, 0.0f, 0.0f, this.e, this.f, Shader.TileMode.CLAMP);
        this.b = r0;
        this.a.setShader(r0);
    L5:
        Matrix r1 = this.c;
        float r2 = this.d;
        r1.setTranslate(r2, r2);
        LinearGradient r3 = this.b;
        if (r3 == null) goto L8;
        r3.setLocalMatrix(this.c);
    L8:
        r10.drawRect(0.0f, 0.0f, getWidth() * (getProgress() / getMax()), getHeight(), this.a);
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r5) {
        super.setProgress(r5);
        this.b = null;
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.setFloatValues(new float[]{0.0f, (getWidth() * (r5 / getMax())) * 2.0f});
    L5:
        invalidate();
    }

    public ObricShimmerProgressBar(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        w0.e(this, i5.c());
        this.a = new Paint(1);
        this.c = new Matrix();
        int r7 = ContextCompat.getColor(r4, v19.c.b(2130972081, r4, 2131103143));
        this.e = new int[]{r7, (16777215 & r7) | Integer.MIN_VALUE, r7};
        this.f = new float[]{0.0f, 0.5f, 1.0f};
        setLayerType(2, null);
    }

    public /* synthetic */ ObricShimmerProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L9;
        ValueAnimator r6 = this.g;
        if (r6 == null) goto L7;
        r6.cancel();
    L7:
        a();
        return;
    }
}
