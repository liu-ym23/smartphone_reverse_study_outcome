package com.obric.assistant.view.glowui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RuntimeShader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001oB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010+\u001a\u00020,H\u0002J(\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH\u0014J\u0010\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020OH\u0014J\u0010\u0010P\u001a\u00020,2\u0006\u0010N\u001a\u00020OH\u0002J&\u0010Q\u001a\u00020,2\u0016\u0010R\u001a\u0012\u0012\u0004\u0012\u00020T0Sj\b\u0012\u0004\u0012\u00020T`UH\u0096@¢\u0006\u0002\u0010VJ\b\u0010W\u001a\u00020,H\u0016J\b\u0010X\u001a\u00020,H\u0016J\b\u0010Y\u001a\u00020,H\u0002J\b\u0010Z\u001a\u00020\u0014H\u0016J\u0010\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020]H\u0016J\u0012\u0010^\u001a\u00020,2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020,H\u0014J\b\u0010b\u001a\u00020,H\u0014J\u0010\u0010c\u001a\u00020,2\u0006\u0010d\u001a\u00020\bH\u0014J\u0018\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020\u00012\u0006\u0010d\u001a\u00020\bH\u0014J\b\u0010g\u001a\u00020,H\u0002J\u0016\u0010D\u001a\u00020,2\u0006\u0010h\u001a\u00020\u00162\u0006\u0010i\u001a\u00020\u0016J\u0006\u0010j\u001a\u00020,J\u0018\u0010k\u001a\u00020,2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR$\u0010%\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR&\u0010(\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u000e\u0010-\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R$\u00106\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R$\u00109\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102R$\u0010<\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00100\"\u0004\b>\u00102R$\u0010?\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bE\u0010CR\u000e\u0010F\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006p"}, d2 = {"Lcom/obric/assistant/view/glowui/GlowView;", "Landroid/view/View;", "Lcom/obric/assistant/view/glowui/IAudioWaveView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shader", "Landroid/graphics/RuntimeShader;", "shaderPaint", "Landroid/graphics/Paint;", "amplitudeProcessor", "Lcom/obric/assistant/view/glowui/AudioAmplitudeProcessor;", "animHelper", "Lcom/obric/assistant/view/glowui/GlowAnimHelper;", "pendingStartAnim", "", "volume", "", "time", "centerY", "value", "radiusRatio", "getRadiusRatio", "()F", "setRadiusRatio", "(F)V", "blurRadius", "getBlurRadius", "setBlurRadius", "highlightRadius", "getHighlightRadius", "setHighlightRadius", "rectHeight", "getRectHeight", "setRectHeight", "glowScale", "getGlowScale", "setGlowScale", "recomputeCenterY", "", "density", "baseColor", "getBaseColor", "()I", "setBaseColor", "(I)V", "coverColor", "getCoverColor", "setCoverColor", "highlightColor", "getHighlightColor", "setHighlightColor", "particleColor", "getParticleColor", "setParticleColor", "noiseColor", "getNoiseColor", "setNoiseColor", "effectShow", "getEffectShow", "()Z", "setEffectShow", "(Z)V", "showHighlight", "setShowHighlight", "highlightX", "highlightY", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawFrame", "updateAudioData", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWaveAnim", "stopWaveAnim", "resetAudioState", "isAnimating", "setWaveTintList", "tint", "Landroid/content/res/ColorStateList;", "setWaveTintMode", "mode", "Landroid/graphics/PorterDuff$Mode;", "onAttachedToWindow", "onDetachedFromWindow", "onWindowVisibilityChanged", "visibility", "onVisibilityChanged", "changedView", "startPendingAnimation", "x", "y", "dismissHighlight", "setColorUniform", "name", "", "color", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlowView extends View {
    public final RuntimeShader a;
    public final Paint b;
    public final AudioAmplitudeProcessor c;
    public final com.obric.assistant.view.glowui.a d;
    public boolean e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public final float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;
    public float v;
    public float w;

    public static final class a {
    }

    static {
    }

    public GlowView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GlowView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        setShowHighlight(false);
    }

    public void setWaveTintList(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "tint");
    }

    public void setWaveTintMode(PorterDuff.Mode r1) {
    }

    public final void e() {
        boolean r1 = false;
        if (this.e == false) goto L10;
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        this.e = false;
        this.d.a(new c(this));
        postInvalidateOnAnimation();
        return;
    L10:
        if (this.d.d != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L16;
        postInvalidateOnAnimation();
        return;
    }

    public final void f() {
        FLogger r0 = FLogger.a;
        r0.i("GlowView", "stopWaveAnim");
        this.e = false;
        com.obric.assistant.view.glowui.a r2 = this.d;
        r2.d = 1;
        r2.e = null;
        r2.f = 0;
        r2.g = 0;
        r2.h = 0;
        r2.i = 0;
        r2.j = 0.0f;
        r2.k = 0.0f;
        r0.i("GlowView", "resetAudioState");
        this.f = 0.0f;
        this.c.b.clear();
        postInvalidate();
    }

    public final void c() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L9;
        this.h = (getHeight() - this.l) + (getWidth() * this.i);
        return;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.a.i("GlowView", "onAttachedToWindow");
        e();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.a.i("GlowView", "onDetachedFromWindow");
        f();
    }

    public final int getBaseColor() {
        return this.o;
    }

    public final float getBlurRadius() {
        return this.j;
    }

    public final int getCoverColor() {
        return this.p;
    }

    public final boolean getEffectShow() {
        return this.t;
    }

    public final float getGlowScale() {
        return this.m;
    }

    public final int getHighlightColor() {
        return this.q;
    }

    public final float getHighlightRadius() {
        return this.k;
    }

    public final int getNoiseColor() {
        return this.s;
    }

    public final int getParticleColor() {
        return this.r;
    }

    public final float getRadiusRatio() {
        return this.i;
    }

    public final float getRectHeight() {
        return this.l;
    }

    private final void setShowHighlight(boolean r2) {
        if (this.u == r2) goto L6;
        this.u = r2;
        postInvalidate();
        return;
    }

    public final void b(Canvas r13) {
        super.onDraw(r13);
        com.obric.assistant.view.glowui.a r0 = this.d;
        float r3 = 1.0f;
        if (r0.d == 1) goto L27;
        long r1 = SystemClock.elapsedRealtimeNanos();
        if (r0.g != 0) goto L8;
        r0.g = r1;
        r0.h = r1;
    L8:
        long r5 = r0.i;
        if (r5 != 0) goto L11;
    L13:
        Function0<Float> r6 = r0.e;
        if (r6 == null) goto L16;
        float r7 = RangesKt.coerceIn(((Number) r6.invoke()).floatValue(), 0.0f, 1.0f);
    L17:
        r0.j = r7;
        r0.i = r1;
    L18:
        long r8 = r0.f;
        if (r8 != 0) goto L21;
        float r9 = 16.0f;
    L22:
        r0.f = r1;
        float r10 = r0.k;
        float r11 = r0.j;
        if (r11 <= r10) goto L25;
        float r12 = 80.0f;
    L26:
        float r14 = r10 + ((r11 - r10) * (1.0f - ((float) Math.exp((-r9) / r12))));
        r0.k = r14;
        r0.b.invoke(Float.valueOf(r14 * ((RangesKt.coerceIn((float) Math.sin(((double) (((r1 - r0.h) % 400000000) / 400000000)) * 3.141592653589793d), 0.0f, 1.0f) * 0.9f) + 0.1f)));
        r0.c.invoke(Float.valueOf((r1 - r0.g) / 1.0E9f));
        goto L27
    L25:
        r12 = 160.0f;
        goto L26
    L21:
        r9 = RangesKt.coerceAtLeast((r1 - r8) / 1000000.0f, 1.0f);
        goto L22
    L16:
        r7 = 0.0f;
        goto L17
    L11:
        if ((r1 - r5) >= 80000000) goto L13;
    L27:
        this.a.setFloatUniform("uResolution", getWidth(), getHeight());
        this.a.setFloatUniform("uTime", this.g);
        this.a.setFloatUniform("uCenterY", this.h);
        this.a.setFloatUniform("uVolume", this.f);
        this.a.setColorUniform("uBaseColor", this.o);
        this.a.setColorUniform("uCoverColor", this.p);
        this.a.setColorUniform("uHighlightColor", this.q);
        this.a.setFloatUniform("uRadiusRatio", this.i);
        this.a.setFloatUniform("uScale", this.m);
        this.a.setFloatUniform("uBlurRadius", this.j);
        RuntimeShader r2 = this.a;
        if (this.t == false) goto L30;
        float r4 = 1.0f;
    L31:
        r2.setFloatUniform("uEffectShow", r4);
        this.a.setFloatUniform("uHighlightRadius", this.k);
        this.a.setFloatUniform("uHighlightPos", this.v, this.w);
        RuntimeShader r15 = this.a;
        if (this.u == true) goto L35;
        r3 = 0.0f;
    L35:
        r15.setFloatUniform("uHighlightShow", r3);
        this.a.setColorUniform("uParticleColor", this.r);
        this.a.setColorUniform("uNoiseColor", this.s);
        this.a.setFloatUniform("uDensity", this.n);
        r13.drawPaint(this.b);
        return;
    L30:
        r4 = 0.0f;
        goto L31
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        boolean r0 = true;
        b(r4);     // Catch: Throwable -> L11
        if (this.d.d == 0) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L21;
        postInvalidate();
        return;
    L21:
        return;
    L11:
        th = move-exception;
        if (this.d.d == 0) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L18;
        postInvalidate();
    L18:
        throw th;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r4) {
        super.onWindowVisibilityChanged(r4);
        FLogger.a.i("GlowView", "onWindowVisibilityChanged " + r4);
        if (r4 != 0) goto L6;
        e();
        return;
    }

    public final void setBaseColor(int r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        postInvalidate();
        return;
    }

    public final void setBlurRadius(float r2) {
        if (this.j != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.j = r2;
        postInvalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCoverColor(int r2) {
        if (this.p == r2) goto L6;
        this.p = r2;
        postInvalidate();
        return;
    }

    public final void setEffectShow(boolean r2) {
        if (this.t == r2) goto L6;
        this.t = r2;
        postInvalidate();
        return;
    }

    public final void setGlowScale(float r2) {
        if (this.m != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.m = r2;
        postInvalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setHighlightColor(int r2) {
        if (this.q == r2) goto L6;
        this.q = r2;
        postInvalidate();
        return;
    }

    public final void setHighlightRadius(float r2) {
        if (this.k != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.k = r2;
        postInvalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setNoiseColor(int r2) {
        if (this.s == r2) goto L6;
        this.s = r2;
        postInvalidate();
        return;
    }

    public final void setParticleColor(int r2) {
        if (this.r == r2) goto L6;
        this.r = r2;
        postInvalidate();
        return;
    }

    public final void setRadiusRatio(float r2) {
        if (this.i != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.i = r2;
        c();
        postInvalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setRectHeight(float r2) {
        if (this.l != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.l = r2;
        c();
        postInvalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void d(float r1, float r2) {
        this.v = r1;
        this.w = r2;
        setShowHighlight(true);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 0) goto L6;
        e();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.view.glowui.e] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.assistant.view.glowui.f] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.assistant.view.glowui.g] */
    public GlowView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        RuntimeShader r14 = new RuntimeShader("\n            uniform float2 uResolution;\n            uniform float  uDensity;\n            uniform float  uTime;\n            uniform float  uCenterY;\n            uniform float  uVolume;\n\n            layout(color) uniform half4 uBaseColor;\n            layout(color) uniform half4 uCoverColor;\n            layout(color) uniform half4 uHighlightColor;\n\n            uniform float  uRadiusRatio;\n            uniform float  uScale;\n            uniform float  uBlurRadius;\n\n            uniform float  uHighlightRadius;\n            uniform float2 uHighlightPos;\n            uniform float  uHighlightShow;\n\n            uniform float  uEffectShow;\n            layout(color) uniform half4 uParticleColor;\n            layout(color) uniform half4 uNoiseColor;\n\n\n            // --- Tunable constants (shared / design parameters) ---\n            const float TAU                    = 6.28318;\n            const float VOLUME_GAIN            = 0.15;\n            const float PARTICLE_DENSITY       = 32.0;\n\n            float erfApprox(float x) {\n                float ax = abs(x);\n                float t = 1.0 / (1.0 + 0.3275911 * ax);\n                float y = 1.0 - (((((1.061405429 * t - 1.453152027) * t)\n                    + 1.421413741) * t - 0.284496736) * t + 0.254829592)\n                    * t * exp(-ax * ax);\n                return x >= 0.0 ? y : -y;\n            }\n\n            float gaussianEdge(float dist, float sigma) {\n                return 0.5 - 0.5 * erfApprox(dist / (sigma * 1.4142135));\n            }\n\n            float sdCircle(float2 p, float r) {\n                return length(p) - r;\n            }\n\n            float interleavedNoise(float2 p) {\n                float2 pixel = floor(p);\n                return fract(52.9829189 * fract(\n                    0.06711056 * pixel.x + 0.00583715 * pixel.y));\n            }\n\n            float2 hash2(float2 p) {\n                p = float2(dot(p, float2(127.1, 311.7)),\n                           dot(p, float2(269.5, 183.3)));\n                return fract(sin(p) * 43758.5453);\n            }\n\n            int imod(int a, int b) { return a - (b * (a / b)); }\n\n            int3 imod3(int3 a, int b) {\n                return int3(imod(a.x, b), imod(a.y, b), imod(a.z, b));\n            }\n\n            float3 hash3d(float3 p) {\n                int3 v = int3(p);\n                v = v * 1671731 + 10139267;\n                v.x += v.y * v.z;\n                v.y += v.z * v.x;\n                v.z += v.x * v.y;\n                int3 v2 = v / 65536;\n                v = imod3(10 - imod3(v + v2, 10), 10);\n                v.x += v.y * v.z;\n                v.y += v.z * v.x;\n                v.z += v.x * v.y;\n                return float3(sin(float(v.x)), cos(float(v.y)), sin(float(v.z)));\n            }\n\n            const float SKEW = 0.3333333;\n            const float UNSKEW = 0.1666667;\n\n            float simplex3d(float3 p) {\n                float3 s = floor(p + (p.x + p.y + p.z) * SKEW);\n                float3 u = s - (s.x + s.y + s.z) * UNSKEW;\n                float3 c0 = p - u;\n                float3 en = c0 - float3(c0.y, c0.z, c0.x);\n                en = step(float3(0.0), en);\n                float3 offset1 = en * (1.0 - float3(en.z, en.x, en.y));\n                float3 offset2 = 1.0 - float3(en.z, en.x, en.y) * (1.0 - en);\n                float3 c1 = c0 - offset1 + UNSKEW;\n                float3 c2 = c0 - offset2 + UNSKEW * 2.0;\n                float3 c3 = c0 - float3(1.0) + UNSKEW * 3.0;\n                float4 w;\n                w.x = dot(c0, c0);\n                w.y = dot(c1, c1);\n                w.z = dot(c2, c2);\n                w.w = dot(c3, c3);\n                w = max(0.6 - w, 0.0);\n                float4 nc;\n                nc.x = dot(hash3d(s), c0);\n                nc.y = dot(hash3d(s + offset1), c1);\n                nc.z = dot(hash3d(s + offset2), c2);\n                nc.w = dot(hash3d(s + float3(1.0)), c3);\n                nc *= w * w * w * w;\n                return dot(float4(32.0), nc);\n            }\n\n            const float JITTER_SPEED   = 2.0;\n            const float JITTER_AMOUNT  = 0.15;\n            const float TWINKLE_SPEED  = 2.0;\n            const float TWINKLE_AMOUNT = 1.0;\n\n            float particle(float2 grid, float sqrtR, float sizePx, float radius) {\n                float2 id = floor(grid);\n                float2 local = fract(grid) - 0.5;\n                float2 jitter = (hash2(id) - 0.5) * 0.6\n                    + sin(uTime * (hash2(id + 0.5) - 0.5) * JITTER_SPEED)\n                      * JITTER_AMOUNT;\n                float dPx = length((local - jitter) * float2(\n                    sqrtR * sqrtR * TAU / PARTICLE_DENSITY,\n                    2.0 * sqrtR / PARTICLE_DENSITY)) * radius;\n                float alpha = step(dPx, max(sizePx, 0.5) * 0.6);\n                float phase = hash2(id).x;\n                alpha *= mix(1.0,\n                    sin(uTime * TWINKLE_SPEED + phase * TAU) * 0.5 + 0.5,\n                    TWINKLE_AMOUNT);\n                return alpha;\n            }\n\n            const float DITHER_MIN_INTENSITY = 0.35;\n            const float DITHER_BLUR_RATIO    = 0.015;\n\n            float glowShape(float2 p) {\n                float glowScale = uScale + uVolume * VOLUME_GAIN;\n                float radius = uResolution.x * uRadiusRatio;\n                float r = radius * glowScale;\n                float blurSigma = uBlurRadius * glowScale;\n                float glowDist = sdCircle(p, r);\n                float ditherIntensity = max(DITHER_MIN_INTENSITY, blurSigma * DITHER_BLUR_RATIO);\n                float ditherOffset = (interleavedNoise(p) - 0.5) * ditherIntensity;\n                return gaussianEdge(glowDist + ditherOffset, blurSigma);\n            }\n            \n            const float NOISE_SCALE    = 0.1;\n            const float NOISE_CONTRAST = 0.0;\n            const float NOISE_SPEED    = 0.5;\n            const float NOISE_BALANCE  = 0.5;\n\n            float noiseMask(float2 p) {\n                float2 noiseUV = p / uResolution.y;\n                float n = simplex3d(float3(\n                    noiseUV * exp(NOISE_SCALE),\n                    uTime * NOISE_SPEED));\n                return clamp(\n                    (n * (NOISE_CONTRAST + 1.0) + NOISE_BALANCE) * 0.5 + 0.5,\n                    0.0, 1.0);\n            }\n\n            float4 colorLayer(half4 color) {\n                float alpha = float(color.a);\n                return float4(\n                    float(color.r) * alpha,\n                    float(color.g) * alpha,\n                    float(color.b) * alpha,\n                    alpha);\n            }\n\n            float4 bodyColor(float nMask) {\n                float4 baseColor = colorLayer(uBaseColor);\n                if (uEffectShow < 0.5) return baseColor;\n                return mix(colorLayer(uNoiseColor), baseColor, nMask);\n            }\n\n            const float GOLDEN_ANGLE = 0.618034;\n            const float EMIT_SPEED   = 0.012;\n            const float PARTICLE_INNER_SIZE_DP = 1.2;\n            const float PARTICLE_OUTER_SIZE_DP = 0.6;\n            const float PARTICLE_WARP_DP       = 120.0;\n\n            float particleMask(float2 p, float2 highlightP) {\n                if (uEffectShow < 0.5) return 0.0;\n\n                float radius = uResolution.x * uRadiusRatio;\n\n                float2 highlightDir = p - highlightP;\n                float highlightDist2 = dot(highlightDir, highlightDir);\n                float highlightRadius2 = uHighlightRadius * uHighlightRadius;\n                float2 warpedP = p - highlightDir * (PARTICLE_WARP_DP * uDensity)\n                    * uHighlightShow\n                    * exp(-2.0 * highlightDist2 / highlightRadius2)\n                    / uHighlightRadius;\n\n                float2 pOffset = warpedP / radius;\n                float pAngle = atan(pOffset.y, pOffset.x) / TAU + 0.5;\n                float pRadius = length(pOffset);\n                float sqrtR = sqrt(pRadius);\n                float2 polarGrid = float2(pAngle, sqrtR) * PARTICLE_DENSITY;\n                float radialT = clamp(pRadius, 0.0, 1.0);\n                float currentSizePx = mix(\n                    PARTICLE_INNER_SIZE_DP, PARTICLE_OUTER_SIZE_DP, radialT) * uDensity;\n\n                float total = 0.0;\n                float layerAlpha = 1.0;\n                for (int i = 0; i < 4; i++) {\n                    float fi = float(i);\n                    float2 scroll = float2(\n                        fi * GOLDEN_ANGLE,\n                        -EMIT_SPEED * uTime * (1.0 + fi * 0.3));\n                    float2 offset = hash2(float2(fi, fi * 7.919)) * 10.0;\n                    total += particle(\n                        polarGrid * (1.0 + fi * 0.05)\n                            + scroll * PARTICLE_DENSITY + offset,\n                        sqrtR, currentSizePx, radius) * layerAlpha;\n                    layerAlpha *= 0.9;\n                }\n\n                return min(total, 1.0);\n            }\n\n            float4 particleColor(float nMask) {\n                return mix(colorLayer(uNoiseColor), colorLayer(uParticleColor), nMask);\n            }\n\n            float4 highlightSpot(float2 p, float2 highlightP) {\n                if (uEffectShow < 0.5) return float4(0.0);\n                float2 delta = p - highlightP;\n                float dist2 = dot(delta, delta);\n                float field = exp(-4.0 * dist2\n                    / (uHighlightRadius * uHighlightRadius)) * uHighlightShow;\n                return colorLayer(uHighlightColor) * field;\n            }\n\n            const float2 COVER_SCALE        = float2(1.0, 0.5);\n            const float2 COVER_SCALE_SILENT = float2(2.0, 0.4);\n\n            float4 coverLayer(float2 p) {\n                float2 scale     = mix(COVER_SCALE_SILENT, COVER_SCALE,     uEffectShow);\n                float radius = uResolution.x * uRadiusRatio;\n                float bx = p.x / (radius * scale.x);\n                float xFall = exp(-bx * bx * 1.5);\n                float domeH = radius * scale.y * xFall;\n                float by = p.y / max(domeH, 1.0);\n                float hl = xFall * exp(-by * by);\n                float hlGain = 1.0 + uVolume * VOLUME_GAIN * 8.0;\n                return colorLayer(uCoverColor) * hl * hlGain;\n            }\n\n            half4 main(float2 fragCoord) {\n                float2 origin     = float2(uResolution.x * 0.5, uCenterY);\n                float2 p          = fragCoord - origin;\n                float2 highlightP = uHighlightPos - origin;\n\n                float shape = glowShape(p);\n                float nMask = noiseMask(p);\n                float pMask = particleMask(p, highlightP);\n\n                float4 body      = bodyColor(nMask);\n                float4 particles = particleColor(nMask);\n                float4 overlays  = highlightSpot(p, highlightP) + coverLayer(p);\n\n                float4 color = mix(body, particles, pMask) + overlays;\n                float alpha = clamp(color.a, 0.0, 1.0);\n                return half4(color.rgb * shape, alpha * shape);\n            }\n        ");
        this.a = r14;
        Paint r0 = new Paint();
        r0.setShader(r14);
        this.b = r0;
        this.c = new AudioAmplitudeProcessor();
        this.d = new com.obric.assistant.view.glowui.a(new e(this), new f(this), new g(this));
        this.i = 0.8f;
        this.m = 1.0f;
        Resources r1 = getResources();
        this.n = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        this.o = -15895809;
        this.p = -6562561;
        this.q = -15840591;
        this.r = -1;
        this.s = -10076701;
        this.t = true;
        FLogger.a.i("GlowView", "init");
        TypedArray r15 = r11.obtainStyledAttributes(r12, new int[]{2130970159, 2130970160, 2130970161, 2130970162, 2130970163, 2130970164, 2130970165, 2130970166, 2130970167, 2130970168, 2130970169});
        setBaseColor(r15.getColor(0, -15895809));
        setCoverColor(r15.getColor(2, -6562561));
        setRadiusRatio(r15.getFloat(8, 0.8f));
        setRectHeight(r15.getDimension(9, r15.getResources().getDimension(2131166561)));
        setGlowScale(r15.getFloat(10, 1.0f));
        setBlurRadius(r15.getDimension(1, r15.getResources().getDimension(2131166554)));
        setHighlightRadius(r15.getDimension(5, r15.getResources().getDimension(2131166555)));
        setHighlightColor(r15.getColor(4, -15840591));
        setEffectShow(r15.getBoolean(3, true));
        setParticleColor(r15.getColor(7, -1));
        setNoiseColor(r15.getColor(6, -10076701));
        r15.recycle();
        setLayerType(2, null);
    }

    public /* synthetic */ GlowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        FLogger.a.i("GlowView", "onSizeChanged w: " + r4 + ", h: " + r5 + ", oldw: " + r6 + ", oldh: " + r7);
        super.onSizeChanged(r4, r5, r6, r7);
        c();
        if (this.e == false) goto L8;
        if (r4 <= 0) goto L9;
        if (r5 <= 0) goto L10;
        this.e = false;
        this.d.a(new b(this));
        postInvalidateOnAnimation();
        return;
    L10:
        return;
    L9:
        return;
    }
}
