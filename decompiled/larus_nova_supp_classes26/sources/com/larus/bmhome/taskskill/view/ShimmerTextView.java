package com.larus.bmhome.taskskill.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 G2\u00020\u0001:\u0001GB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u00105\u001a\u0002042\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000204\u0018\u000103J\u0006\u00107\u001a\u000204J\u0006\u00108\u001a\u000204J(\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0014J\b\u0010>\u001a\u000204H\u0014J\b\u0010?\u001a\u000204H\u0014J\u0010\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\u0007H\u0002J\b\u0010B\u001a\u000204H\u0002J\u0010\u0010C\u001a\u0002042\u0006\u0010D\u001a\u000201H\u0002J\u0010\u0010E\u001a\u0002012\u0006\u0010F\u001a\u000201H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010%\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000204\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/bmhome/taskskill/view/ShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "shimmerIncludeIcon", "getShimmerIncludeIcon$impl_mainlandRelease", "()Z", "setShimmerIncludeIcon$impl_mainlandRelease", "(Z)V", "", "shimmerDurationMillis", "getShimmerDurationMillis$impl_mainlandRelease", "()J", "setShimmerDurationMillis$impl_mainlandRelease", "(J)V", "shimmerRepeatCount", "getShimmerRepeatCount$impl_mainlandRelease", "()I", "setShimmerRepeatCount$impl_mainlandRelease", "(I)V", "shimmerBaseColor", "getShimmerBaseColor$impl_mainlandRelease", "()Ljava/lang/Integer;", "setShimmerBaseColor$impl_mainlandRelease", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "shimmerDimAlpha", "getShimmerDimAlpha$impl_mainlandRelease", "setShimmerDimAlpha$impl_mainlandRelease", "shimmerBrightAlpha", "getShimmerBrightAlpha$impl_mainlandRelease", "setShimmerBrightAlpha$impl_mainlandRelease", "animator", "Landroid/animation/ValueAnimator;", "shaderMatrix", "Landroid/graphics/Matrix;", "gradient", "Landroid/graphics/LinearGradient;", "isAnimating", "pendingStart", "shimmerProgress", "", "iconShimmerProgressListener", "Lkotlin/Function1;", "", "setIconShimmerProgressListener", "listener", "startShimmer", "stopShimmer", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "buildGradient", "viewWidth", "rebuildGradientIfNeeded", "dispatchIconShimmerProgress", "progress", "calculatePulseProgress", "fraction", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShimmerTextView extends AppCompatTextView {
    public static final /* synthetic */ int n = 0;
    public boolean a;
    public long b;
    public int c;
    public Integer d;
    public int e;
    public int f;
    public ValueAnimator g;
    public final Matrix h;
    public LinearGradient i;
    public boolean j;
    public boolean k;
    public float l;
    public Function1<? super Float, Unit> m;

    public static final class a {
    }

    static {
    }

    public ShimmerTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShimmerTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        if (this.j == false) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L8;
    L12:
        this.k = true;
        return;
    L8:
        if (getWidth() <= 0) goto L12;
        this.k = false;
        this.j = true;
        x(getWidth());
        float r2 = getWidth() / 2.0f;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{-r2, getWidth() + r2});
        r0.setDuration(this.b);
        r0.setRepeatCount(this.c);
        r0.setInterpolator(new LinearInterpolator());
        r0.addUpdateListener(new w(this));
        r0.start();
        this.g = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.g = null;
        this.j = false;
        this.k = false;
        this.l = 1.0f;
        getPaint().setShader(null);
        this.i = null;
        y(1.0f);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (getWidth() <= 0) goto L9;
        x(getWidth());
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (this.k == false) goto L6;
        A();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        B();
        super/*android.widget.TextView*/.onDetachedFromWindow();
    }

    public final Integer getShimmerBaseColor$impl_mainlandRelease() {
        return this.d;
    }

    public final int getShimmerBrightAlpha$impl_mainlandRelease() {
        return this.f;
    }

    public final int getShimmerDimAlpha$impl_mainlandRelease() {
        return this.e;
    }

    public final long getShimmerDurationMillis$impl_mainlandRelease() {
        return this.b;
    }

    public final boolean getShimmerIncludeIcon$impl_mainlandRelease() {
        return this.a;
    }

    public final int getShimmerRepeatCount$impl_mainlandRelease() {
        return this.c;
    }

    public final void setIconShimmerProgressListener(Function1<? super Float, Unit> r1) {
        this.m = r1;
        if (this.a == true) goto L5;
    L7:
        float r2 = 1.0f;
    L8:
        y(r2);
        return;
    L5:
        if (this.j == false) goto L7;
        r2 = this.l;
        goto L8
    }

    public final void setShimmerBaseColor$impl_mainlandRelease(Integer r1) {
        this.d = r1;
        z();
    }

    public final void setShimmerBrightAlpha$impl_mainlandRelease(int r3) {
        this.f = RangesKt.coerceIn(r3, 0, 255);
        z();
    }

    public final void setShimmerDimAlpha$impl_mainlandRelease(int r3) {
        this.e = RangesKt.coerceIn(r3, 0, 255);
        z();
    }

    public final void setShimmerDurationMillis$impl_mainlandRelease(long r3) {
        long r4 = RangesKt.coerceAtLeast(r3, 1);
        this.b = r4;
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L6;
        r0.setDuration(r4);
        return;
    }

    public final void setShimmerIncludeIcon$impl_mainlandRelease(boolean r1) {
        this.a = r1;
        if (r1 == false) goto L5;
        float r2 = this.l;
    L6:
        y(r2);
        return;
    L5:
        r2 = 1.0f;
        goto L6
    }

    public final void setShimmerRepeatCount$impl_mainlandRelease(int r2) {
        int r3 = RangesKt.coerceAtLeast(r2, -1);
        this.c = r3;
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L6;
        r0.setRepeatCount(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(int r12) {
        Integer r0 = this.d;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        int r2 = ColorUtils.setAlphaComponent(r1, this.e);
        LinearGradient r13 = new LinearGradient(0.0f, 0.0f, RangesKt.coerceAtLeast(r12 / 2.0f, 1.0f), 0.0f, new int[]{r2, ColorUtils.setAlphaComponent(r1, this.f), r2}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        getPaint().setShader(r13);
        this.i = r13;
        return;
    L5:
        r1 = getCurrentTextColor();
        goto L6
    }

    public final void y(float r4) {
        Function1<? super Float, Unit> r0 = this.m;
        if (r0 == null) goto L6;
        r0.invoke(Float.valueOf(RangesKt.coerceIn(r4, 0.0f, 1.0f)));
        return;
    }

    public ShimmerTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        this.b = 1000;
        this.c = -1;
        this.e = 128;
        this.f = 255;
        this.h = new Matrix();
        this.l = 1.0f;
    }

    public /* synthetic */ ShimmerTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super/*android.widget.TextView*/.onSizeChanged(r3, r4, r5, r6);
        if (this.j == false) goto L9;
        if (r3 <= 0) goto L9;
        x(r3);
        float r7 = r3;
        float r8 = r7 / 2.0f;
        ValueAnimator r9 = this.g;
        if (r9 == null) goto L14;
        r9.setFloatValues(new float[]{-r8, r7 + r8});
        return;
    L14:
        return;
    L9:
        if (this.k == false) goto L16;
        if (r3 <= 0) goto L17;
        if (r4 <= 0) goto L18;
        A();
        return;
    L18:
        return;
    L17:
        return;
    }
}
