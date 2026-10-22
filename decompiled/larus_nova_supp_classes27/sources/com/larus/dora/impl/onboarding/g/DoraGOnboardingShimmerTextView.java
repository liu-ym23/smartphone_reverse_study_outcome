package com.larus.dora.impl.onboarding.g;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import c69.b;
import c69.d;
import com.larus.common.apphost.AppHost;
import com.larus.utils.i;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007J\u0014\u0010\u001e\u001a\u00020\u001b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0006\u0010\u001f\u001a\u00020\u001bJ\b\u0010 \u001a\u00020\u001bH\u0014J\b\u0010!\u001a\u00020\u001bH\u0014J\u0006\u0010\"\u001a\u00020\u001bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/DoraGOnboardingShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linearGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "", "shaderMatrix", "Landroid/graphics/Matrix;", "textColor", "textColorAlpha", "needStartAnimation", "", "path", "Landroid/view/animation/PathInterpolator;", "animRepeatCount", "onAnimationFinished", "Lkotlin/Function0;", "", "setAnimRepeatCount", "count", "setOnAnimationFinished", "startShimmerAnimation", "onDetachedFromWindow", "onAttachedToWindow", "cancelAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingShimmerTextView extends AppCompatTextView {
    public static final /* synthetic */ int j = 0;
    public LinearGradient a;
    public ValueAnimator b;
    public final Matrix c;
    public final int d;
    public final int e;
    public boolean f;
    public final PathInterpolator g;
    public int h;
    public Function0<Unit> i;

    public static final class a {
    }

    static {
    }

    public DoraGOnboardingShimmerTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoraGOnboardingShimmerTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        this.i = new b();
        ValueAnimator r0 = this.b;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.b = null;
        getPaint().setShader(null);
        invalidate();
    L7:
        this.f = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        if (this.b == null) goto L6;
        Function0<Unit> r0 = this.i;
        x();
        this.i = r0;
    L6:
        if (isAttachedToWindow() == true) goto L9;
        this.f = true;
        return;
    L9:
        int r1 = j0.a;
        float r2 = Math.min(j0.b(c.b(2130971486, null, 2131167341)), i.d(AppHost.a.getApplication()) - (i5.Q() * 2));
        int r5 = this.d;
        this.a = new LinearGradient(0.0f, 0.0f, r2, 0.0f, new int[]{r5, r5, this.e, r5, r5}, new float[]{0.0f, 0.3f, 0.5f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
        getPaint().setShader(this.a);
        float r3 = r2 - (0.3f * r2);
        ValueAnimator r4 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("tx", new Keyframe[]{Keyframe.ofFloat(0.0f, -r3), Keyframe.ofFloat(1.0f, r3)})});
        r4.setDuration(2000);
        r4.setRepeatCount(this.h);
        r4.setInterpolator(this.g);
        r4.addUpdateListener(new c69.c(this));
        r4.addListener(new d(this));
        r4.start();
        this.b = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (this.f == false) goto L6;
        y();
        this.f = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        x();
    }

    public final void setAnimRepeatCount(int r1) {
        this.h = r1;
    }

    public final void setOnAnimationFinished(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onAnimationFinished");
        this.i = r2;
    }

    public DoraGOnboardingShimmerTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.c = new Matrix();
        this.d = ContextCompat.getColor(r3, 2131103140);
        this.e = ContextCompat.getColor(r3, 2131103136);
        this.g = new PathInterpolator(0.4f, 0.0f, 0.1f, 1.0f);
        this.h = 1;
        this.i = new c69.a();
    }

    public /* synthetic */ DoraGOnboardingShimmerTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
