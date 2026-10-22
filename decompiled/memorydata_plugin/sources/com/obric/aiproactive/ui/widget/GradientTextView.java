package com.obric.aiproactive.ui.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J*\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\b\u0010$\u001a\u00020\u0016H\u0014J\b\u0010%\u001a\u00020\u0016H\u0014J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/aiproactive/ui/widget/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sweepColors", "", "sweepBaseColor", "sweepPositions", "", "sweepEnabled", "", "sweepPhase", "", "sweepAnimator", "Landroid/animation/ValueAnimator;", "setSweepColors", "", "baseColor", "highlightColor", "setSweepEnabled", "enabled", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "lengthBefore", "lengthAfter", "onAttachedToWindow", "onDetachedFromWindow", "startSweepAnimator", "stopSweepAnimator", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GradientTextView extends AppCompatTextView {
    private ValueAnimator sweepAnimator;
    private int sweepBaseColor;
    private int[] sweepColors;
    private boolean sweepEnabled;
    private float sweepPhase;
    private final float[] sweepPositions;

    public GradientTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public GradientTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public GradientTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.sweepColors = a.a(ViewCompat.MEASURED_STATE_MASK);
        this.sweepBaseColor = getCurrentTextColor();
        this.sweepPositions = a.a();
    }

    public /* synthetic */ GradientTextView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    /* JADX INFO: renamed from: lambda$0m3aajiu0ZoU15GkT-w9raPVzEc, reason: not valid java name */
    public static /* synthetic */ void m359lambda$0m3aajiu0ZoU15GkTw9raPVzEc(GradientTextView r0) {
        startSweepAnimator$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$ExpzmvGmhH5P9zrgdLZT5JgW6vg(GradientTextView r0, ValueAnimator r1) {
        startSweepAnimator$lambda$2$lambda$1(r0, r1);
    }

    private final void startSweepAnimator() {
        if (this.sweepEnabled == true) goto L6;
        return;
    L6:
        if (getWidth() > 0) goto L10;
        post(new $$Lambda$GradientTextView$0m3aajiu0ZoU15GkTw9raPVzEc(this));
        return;
    L10:
        if (this.sweepAnimator == null) goto L12;
        return;
    L12:
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(3500);
        r0.setRepeatCount(-1);
        r0.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r0.addUpdateListener(new $$Lambda$GradientTextView$ExpzmvGmhH5P9zrgdLZT5JgW6vg(this));
        r0.start();
        this.sweepAnimator = r0;
    }

    private static final void startSweepAnimator$lambda$0(GradientTextView r1) {
        if (r1.sweepEnabled == false) goto L6;
        r1.startSweepAnimator();
        return;
    }

    private static final void startSweepAnimator$lambda$2$lambda$1(GradientTextView r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.sweepPhase = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.invalidate();
    }

    private final void stopSweepAnimator() {
        ValueAnimator r0 = this.sweepAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.sweepAnimator = null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.sweepEnabled == false) goto L6;
        startSweepAnimator();
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        stopSweepAnimator();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        if (this.sweepEnabled == true) goto L5;
    L8:
        getPaint().setShader(null);
        super.onDraw(r13);
        return;
    L5:
        if (getWidth() <= 0) goto L8;
        getPaint().setShader(null);
        super.onDraw(r13);
        float r0 = getWidth() * 0.4f;
        float r5 = (-r0) + ((getWidth() + (2.0f * r0)) * this.sweepPhase);
        getPaint().setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(r5, 0.0f, r5 + r0, 0.0f, this.sweepColors, this.sweepPositions, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
        super.onDraw(r13);
        getPaint().setShader(null);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        super.onTextChanged((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        if (this.sweepEnabled == false) goto L6;
        invalidate();
        return;
    }

    public final void setSweepColors(int r1, int r2) {
        this.sweepColors = a.a(r2);
        this.sweepBaseColor = r1;
        if (getCurrentTextColor() == r1) goto L6;
        setTextColor(r1);
    L6:
        if (this.sweepEnabled == false) goto L9;
        invalidate();
        return;
    }

    public final void setSweepEnabled(boolean r2) {
        if (this.sweepEnabled != r2) goto L5;
        return;
    L5:
        this.sweepEnabled = r2;
        if (r2 == false) goto L8;
        startSweepAnimator();
        return;
    L8:
        stopSweepAnimator();
        getPaint().setShader(null);
        invalidate();
    }
}
