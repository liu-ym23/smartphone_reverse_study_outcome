package com.larus.bmhome.chat.standarduikit.floatingthink.view;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import fl8.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001bJ\b\u0010\u001f\u001a\u00020\u001bH\u0002J(\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\b\u0010%\u001a\u00020\u001bH\u0014J\b\u0010&\u001a\u00020\u001bH\u0014J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/floatingthink/view/DeepThinkShimmerLinearLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "shaderMatrix", "Landroid/graphics/Matrix;", "shimmerPaint", "Landroid/graphics/Paint;", "linearGradient", "Landroid/graphics/LinearGradient;", "shimmerColor", "shimmerAlpha", "", "shimmerDuration", "", "needStartAnimation", "", "isAnimating", "startShimmerAnimation", "", "setShimmerColor", "color", "cancelShimmerAnimation", "createShimmerGradient", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DeepThinkShimmerLinearLayout extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;
    public ValueAnimator a;
    public final Matrix b;
    public final Paint c;
    public LinearGradient d;
    public int e;
    public final float f;
    public final long g;
    public boolean h;
    public boolean i;

    public DeepThinkShimmerLinearLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepThinkShimmerLinearLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        ValueAnimator r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.a = null;
        this.i = false;
        this.h = false;
        setLayerType(0, null);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        if (this.i == false) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L8;
    L12:
        this.h = true;
        return;
    L8:
        if (getWidth() == 0) goto L12;
        this.i = true;
        setLayerType(2, null);
        S5();
        float r0 = getWidth() / 2.0f;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{-r0, getWidth() + r0});
        r1.setDuration(this.g);
        r1.setRepeatCount(-1);
        r1.setInterpolator(new LinearInterpolator());
        r1.addUpdateListener(new a(this));
        r1.start();
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        float r5 = getWidth() / 2.0f;
        int r0 = ContextCompat.getColor(getContext(), R.color.transparent);
        LinearGradient r10 = new LinearGradient(0.0f, 0.0f, r5, 0.0f, new int[]{r0, ColorUtils.setAlphaComponent(this.e, (int) (255 * this.f)), r0}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.d = r10;
        this.c.setShader(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (this.h == false) goto L6;
        T5();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        R5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.dispatchDraw(r8);
        if (this.i == true) goto L5;
        return;
    L5:
        if (this.d == null) goto L9;
        r8.drawRect(getPaddingStart(), getPaddingTop(), getWidth() - getPaddingEnd(), getHeight() - getPaddingBottom(), this.c);
        return;
    }

    public final void setShimmerColor(int r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepThinkShimmerLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new Matrix();
        this.c = new Paint();
        this.e = c.a(2130970533, r2, 2131102542);
        this.f = 1.0f;
        this.g = 1000;
        setWillNotDraw(false);
    }

    public /* synthetic */ DeepThinkShimmerLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super/*android.view.ViewGroup*/.onSizeChanged(r3, r4, r5, r6);
        if (this.i == false) goto L9;
        if (r3 <= 0) goto L9;
        S5();
        float r7 = r3;
        float r8 = r7 / 2.0f;
        ValueAnimator r9 = this.a;
        if (r9 == null) goto L14;
        r9.setFloatValues(new float[]{-r8, r7 + r8});
        return;
    L14:
        return;
    L9:
        if (this.h == false) goto L16;
        if (r3 <= 0) goto L17;
        if (r4 <= 0) goto L18;
        T5();
        return;
    L18:
        return;
    L17:
        return;
    }
}
