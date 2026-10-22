package com.larus.bmhome.taskskill.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/PcDeviceAuthorizingLoadingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arcRect", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "gradientColors", "", "animator", "Landroid/animation/ValueAnimator;", "gradient", "Landroid/graphics/SweepGradient;", "gradientCenterX", "", "gradientCenterY", "rotationDegrees", "attached", "", "onAttachedToWindow", "", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "onWindowVisibilityChanged", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getGradient", "centerX", "centerY", "updateAnimationState", "startAnimation", "stopAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcDeviceAuthorizingLoadingView extends View {
    public static final float[] j = null;
    public final RectF a;
    public final Paint b;
    public final int[] c;
    public ValueAnimator d;
    public SweepGradient e;
    public float f;
    public float g;
    public float h;
    public boolean i;

    public static final class a {
    }

    public PcDeviceAuthorizingLoadingView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PcDeviceAuthorizingLoadingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.i = false;
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d = null;
        this.h = 0.0f;
        super.onDetachedFromWindow();
    }

    static {
        j = new float[]{0.0f, 0.38f, 0.78f, 1.0f};
    }

    public final void a() {
        if (this.i == true) goto L5;
    L17:
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L20;
        r0.cancel();
    L20:
        this.d = null;
        this.h = 0.0f;
        return;
    L5:
        if (getVisibility() != 0) goto L17;
        if (getWindowVisibility() != 0) goto L17;
        ValueAnimator r1 = this.d;
        if (r1 == null) goto L13;
        boolean r2 = true;
        if (r1.isRunning() != true) goto L13;
    L14:
        if (r2 == true) goto L23;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r3.setDuration(750);
        r3.setInterpolator(new LinearInterpolator());
        r3.setRepeatCount(-1);
        r3.addUpdateListener(new d(this));
        r3.start();
        this.d = r3;
        return;
    L23:
        return;
    L13:
        r2 = false;
        goto L14
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        float r0 = Math.min(getWidth(), getHeight());
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        float r2 = getWidth() / 2.0f;
        float r4 = getHeight() / 2.0f;
        float r5 = 0.2f * r0;
        float r6 = ((r0 - r5) / 2.0f) - (r0 * 0.06f);
        if (r6 > 0.0f) goto L8;
        return;
    L8:
        this.b.setStrokeWidth(r5);
        Paint r1 = this.b;
        SweepGradient r3 = this.e;
        if (r3 == null) goto L20;
        boolean r7 = false;
        if (this.f != r2) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L20;
        if (this.g != r4) goto L18;
        r7 = true;
    L18:
        if (r7 == false) goto L20;
    L21:
        r1.setShader(r3);
        this.a.set(r2 - r6, r4 - r6, r2 + r6, r6 + r4);
        r12.save();
        r12.rotate(this.h, r2, r4);
        r12.drawArc(this.a, 0.0f, 260.0f, false, this.b);
        r12.restore();
        return;
    L13:
        r8 = false;
    L20:
        r3 = new SweepGradient(r2, r4, this.c, j);
        this.e = r3;
        this.f = r2;
        this.g = r4;
        goto L21
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        a();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        a();
    }

    public PcDeviceAuthorizingLoadingView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new RectF();
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeCap(Paint.Cap.ROUND);
        this.b = r8;
        this.c = new int[]{ContextCompat.getColor(r5, v19.c.b(2130972087, r5, 2131103162)), ContextCompat.getColor(r5, v19.c.b(2130972080, r5, 2131103140)), ContextCompat.getColor(r5, v19.c.b(2130972082, r5, 2131103146)), ContextCompat.getColor(r5, v19.c.b(2130972087, r5, 2131103162))};
    }

    public /* synthetic */ PcDeviceAuthorizingLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
