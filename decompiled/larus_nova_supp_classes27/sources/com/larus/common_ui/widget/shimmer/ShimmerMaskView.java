package com.larus.common_ui.widget.shimmer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.larus.utils.CubicBezierInterpolator;
import d29.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\u001fJ\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020\u001fH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "shader", "Landroid/graphics/LinearGradient;", "bandWidth", "", "matrix", "Landroid/graphics/Matrix;", "CENTER_COLOR", "getCENTER_COLOR", "()I", "CENTER_COLOR$delegate", "Lkotlin/Lazy;", "interpolator", "Landroid/view/animation/Interpolator;", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animating", "", "onSizeChanged", "", "w", "h", "oldw", "oldh", "rebuildShader", "width", "startShimmer", "cancelShimmer", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShimmerMaskView extends View {
    public static final /* synthetic */ int i = 0;
    public final Paint a;
    public LinearGradient b;
    public float c;
    public final Matrix d;
    public final Lazy e;
    public final CubicBezierInterpolator f;
    public final ValueAnimator g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public ShimmerMaskView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShimmerMaskView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.h = false;
        this.g.cancel();
        setVisibility(8);
    }

    private final int getCENTER_COLOR() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final void c() {
        if (this.h == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.h = true;
        if (getVisibility() == 0) goto L9;
        r0 = false;
    L9:
        if (r0 == true) goto L11;
        setVisibility(0);
    L11:
        this.g.cancel();
        this.g.start();
        invalidate();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final void b(int r9) {
        if (r9 > 0) goto L5;
        this.b = null;
        this.c = 0.0f;
        return;
    L5:
        this.c = r9 * 0.3f;
        this.b = new LinearGradient(0.0f, 0.0f, this.c, 0.0f, new int[]{16777215, getCENTER_COLOR(), 16777215}, null, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        int r0 = getWidth();
        int r1 = getHeight();
        if (r0 <= 0) goto L16;
        if (r1 > 0) goto L7;
        return;
    L7:
        if (this.h == true) goto L9;
        return;
    L9:
        LinearGradient r2 = this.b;
        if (r2 != null) goto L14;
        b(r0);
        r2 = this.b;
        if (r2 != null) goto L14;
        return;
    L14:
        float r3 = this.f.getInterpolation(RangesKt.coerceAtMost((this.g.getAnimatedFraction() * 1300) / 900, 1.0f));
        float r4 = -this.c;
        float r8 = r0;
        this.d.reset();
        this.d.postTranslate(r4 + ((r8 - r4) * r3), 0.0f);
        r2.setLocalMatrix(this.d);
        this.a.setShader(r2);
        this.a.setColor(-1);
        r12.drawRect(0.0f, 0.0f, r8, r1, this.a);
        return;
    }

    public ShimmerMaskView(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new Paint(1);
        this.d = new Matrix();
        this.e = LazyKt.lazy(new d29.a(r3));
        this.f = new CubicBezierInterpolator(0.25f, 1.0f, 0.25f);
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.setDuration(1300);
        r6.setRepeatCount(-1);
        r6.setRepeatMode(1);
        r6.addUpdateListener(new b(this));
        this.g = r6;
        setVisibility(8);
    }

    public /* synthetic */ ShimmerMaskView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        b(r1);
    }
}
