package com.larus.uaigc.chat.markdown.placeholder;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.uaigc.impl.databinding.LarusWidgetMdCreationTextPlaceHolderBinding;
import com.tencent.open.log.TraceLevel;
import gz9.b;
import gz9.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;
import we8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001d\u001a\u00020\u001eJ0\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\b\u0010%\u001a\u00020\u001eH\u0014J\b\u0010&\u001a\u00020\u001eH\u0014J\u0006\u0010'\u001a\u00020\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/uaigc/chat/markdown/placeholder/ShimmerTextPlaceHolderView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMdCreationTextPlaceHolderBinding;", "linearGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "", "shaderMatrix", "Landroid/graphics/Matrix;", "textColor", "textColorAlpha", "dotAnim", "loadingText", "Landroid/widget/TextView;", "getLoadingText", "()Landroid/widget/TextView;", "needStartAnimation", "", "startShimmerAnimation", "", "onLayout", "changed", "left", "top", "right", "bottom", "onDetachedFromWindow", "onAttachedToWindow", "cancelAnimation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShimmerTextPlaceHolderView extends LinearLayout {
    public static final /* synthetic */ int j = 0;
    public final LarusWidgetMdCreationTextPlaceHolderBinding a;
    public LinearGradient b;
    public ValueAnimator c;
    public final Matrix d;
    public final int e;
    public final int f;
    public ValueAnimator g;
    public final TextView h;
    public boolean i;

    public ShimmerTextPlaceHolderView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShimmerTextPlaceHolderView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (this.c == null) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L9;
        this.i = true;
        return;
    L9:
        final TextView r0 = this.h;
        float r5 = r0.getWidth() * 1.0f;
        int r8 = this.e;
        this.b = new LinearGradient(0.0f, 0.0f, r5, 0.0f, new int[]{r8, this.f, r8}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        r0.getPaint().setShader(this.b);
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{-r0.getWidth(), r0.getWidth()});
        r1.setDuration(1500);
        r1.setRepeatCount(-1);
        r1.setInterpolator(new LinearInterpolator());
        r1.addUpdateListener(new b(this, r0));
        r1.start();
        this.c = r1;
        boolean r2 = h.a;
        if (h.a(null) == false) goto L12;
        this.a.b.setAlpha(1.0f);
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.1f});
    L13:
        r3.setStartDelay(580);
        r3.setInterpolator(new LinearInterpolator());
        r3.setDuration(750);
        r3.setRepeatCount(-1);
        r3.setRepeatMode(2);
        r3.addUpdateListener(new c(this));
        this.g = r3;
        r3.start();
        return;
    L12:
        r3 = ValueAnimator.ofFloat(new float[]{0.1f, 1.0f});
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i == false) goto L6;
        a();
        this.i = false;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L8;
        r0.cancel();
        ValueAnimator r1 = this.g;
        if (r1 == null) goto L7;
        r1.cancel();
    L7:
        this.c = null;
    L8:
        this.i = false;
    }

    public final TextView getLoadingText() {
        return this.h;
    }

    public ShimmerTextPlaceHolderView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131563259, this);
        int r5 = 2131379016;
        View r6 = ViewBindings.findChildViewById(this, 2131379016);
        if (r6 == null) goto L13;
        r5 = 2131379082;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131379082);
        if (r7 == null) goto L13;
        this.a = new LarusWidgetMdCreationTextPlaceHolderBinding(this, r6, r7);
        this.d = new Matrix();
        this.e = ColorProtector.parseColor("#CCCCCC");
        this.f = ColorProtector.parseColor("#666666");
        this.h = r7;
        float r8 = a.a(i5.t(), false);
        r7.setTextSize(0, r8);
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        if (r9 == null) goto L11;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        float r11 = r8 / i5.t();
        int r0 = (int) (i5.r0() * r11);
        r10.width = r0;
        r10.height = r0;
        r10.topMargin = (int) (i5.z() * r11);
        r6.setLayoutParams(r10);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ ShimmerTextPlaceHolderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L13;
        ValueAnimator r6 = this.c;
        if (r6 == null) goto L14;
        if (r6 == null) goto L11;
        r6.cancel();
        ValueAnimator r7 = this.g;
        if (r7 == null) goto L10;
        r7.cancel();
    L10:
        this.c = null;
    L11:
        this.i = false;
        a();
        return;
    L14:
        return;
    }
}
