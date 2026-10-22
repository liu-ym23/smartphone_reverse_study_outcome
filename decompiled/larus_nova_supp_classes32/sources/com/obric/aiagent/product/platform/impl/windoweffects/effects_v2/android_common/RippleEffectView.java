package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.common.oea.foundation.animation.token.Token;
import fja.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 :2\u00020\u0001:\u0003:;<B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0014\u0010#\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020\u0014J\b\u0010&\u001a\u00020 H\u0014J(\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0014J\u001a\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u00101\u001a\u00020 2\u0006\u00100\u001a\u00020\u0012H\u0002J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001d\u0010\u001e¨\u0006="}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rippleShader", "Landroid/graphics/RuntimeShader;", "shaderPaint", "Landroid/graphics/Paint;", "animationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "playGeneration", "activeSpec", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$RippleSpec;", "shouldRender", NameKeys.UnloadStrategy_No_Strategy, "originX", NameKeys.UnloadStrategy_No_Strategy, "originY", "travelDistance", "pulseWidth", "viewIntensity", "value", "progress", "setProgress", "(F)V", "playWakeUpEffect", NameKeys.UnloadStrategy_No_Strategy, "onEnd", "Ljava/lang/Runnable;", "playCaptureEffect", "stop", "isPlaying", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "playRipple", "spec", "updateGeometry", "compensateClippedOrigin", "rawOriginY", "resolutionY", "cancelRunningAnimation", "nextGeneration", "cleanupAnimation", "generation", "hideWhenIdle", "Companion", "RippleSpec", "DeviceProfile", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RippleEffectView extends View {
    public static final c m = null;
    public static final c n = null;
    public static final Token.Easing o = null;
    public static final List<b> p = null;
    public final RuntimeShader a;
    public final Paint b;
    public d c;
    public int d;
    public c e;
    public final boolean f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "DeviceProfile(manufacturer=" + this.a + ", brand=" + this.b + ", model=" + this.c + ", device=" + this.d + ')';
        }

        public b() {
            Intrinsics.checkNotNullParameter("shenqijiyuan", "manufacturer");
            Intrinsics.checkNotNullParameter("nubia", "brand");
            Intrinsics.checkNotNullParameter("p0210", "model");
            Intrinsics.checkNotNullParameter("nerida", "device");
            this.a = "shenqijiyuan";
            this.b = "nubia";
            this.c = "p0210";
            this.d = "nerida";
        }
    }

    public static final class c {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final long g;
        public final float h;
        public final float i;
        public final float j;
        public final float k;
        public final float l;
        public final float m;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Float.compare(this.a, r9.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r9.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r9.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r9.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r9.e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f, r9.f) == 0) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L30;
            return false;
        L30:
            if (Float.compare(this.h, r9.h) == 0) goto L33;
            return false;
        L33:
            if (Float.compare(this.i, r9.i) == 0) goto L36;
            return false;
        L36:
            if (Float.compare(this.j, r9.j) == 0) goto L39;
            return false;
        L39:
            if (Float.compare(this.k, r9.k) == 0) goto L42;
            return false;
        L42:
            if (Float.compare(this.l, r9.l) == 0) goto L45;
            return false;
        L45:
            if (Float.compare(this.m, r9.m) == 0) goto L47;
            return false;
        L47:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31;
            long r1 = this.g;
            return ((((((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k)) * 31) + Float.floatToIntBits(this.l)) * 31) + Float.floatToIntBits(this.m);
        }

        public final String toString() {
            return "RippleSpec(originFractionX=" + this.a + ", originFractionY=" + this.b + ", amplitudeDp=" + this.c + ", amplitudeRamp=" + this.d + ", pulseWidthDp=" + this.e + ", travelDistanceMultiplier=" + this.f + ", durationMs=" + this.g + ", screenDimIntensity=" + this.h + ", waveGlowIntensity=" + this.i + ", trailDecayLength=" + this.j + ", edgeGlowRadiusDp=" + this.k + ", edgeGlowColorIntensity=" + this.l + ", edgeGlowIntensity=" + this.m + ')';
        }

        public c(float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10) {
            this.a = 0.5f;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = 70.0f;
            this.f = r5;
            this.g = 1500;
            this.h = r6;
            this.i = r7;
            this.j = r8;
            this.k = 1.0f;
            this.l = r9;
            this.m = r10;
        }
    }

    public RippleEffectView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RippleEffectView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        m = new c(1.2f, 70.0f, 0.5f, 2.2f, 0.0f, 1.0f, 2.0f, 1.0f, 0.0f);
        n = new c(0.5f, 10.0f, 0.2f, 1.0f, 0.16f, 0.3f, 1.5f, 0.5f, 1.0f);
        o = Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD;
        p = CollectionsKt.listOf(new b());
    }

    public final void d() {
        d r0 = this.c;
        this.c = null;
        this.d++;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        setProgress(0.0f);
        if (this.f == false) goto L8;
        int r1 = 4;
    L9:
        setVisibility(r1);
        return;
    L8:
        r1 = 8;
        goto L9
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    private final void setProgress(float r3) {
        float r4 = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        if (this.l != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.l = r4;
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void e(c r8) {
        float r0 = getWidth();
        float r1 = getHeight();
        float r2 = haa.b.a(r8.e) * 1.65f;
        this.j = r2;
        this.g = r8.a * r0;
        float r4 = r8.b * r1;
        float r3 = r2 * 0.95f;
        if (r4 <= r1) goto L6;
        r4 = RangesKt.coerceAtMost(r4 - r1, r3) + r1;
    L8:
        this.h = r4;
        this.i = ((float) Math.hypot(r0, r1)) * r8.f;
        this.k = RangesKt.coerceAtLeast(r8.i * 1.65f, 0.9f);
        return;
    L6:
        if (r4 >= 0.0f) goto L8;
        r4 = -RangesKt.coerceAtMost(0.0f - r4, r3);
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L13;
        this.a.setFloatUniform("uResolution", getWidth(), getHeight());
        this.a.setFloatUniform("uOrigin", this.g, this.h);
        this.a.setFloatUniform("uProgress", this.l);
        this.a.setFloatUniform("uTravelDistance", this.i);
        this.a.setFloatUniform("uPulseWidth", this.j);
        this.a.setFloatUniform("uWaveGlowIntensity", this.k);
        this.a.setFloatUniform("uTrailDecayLength", this.e.j);
        r5.drawPaint(this.b);
        return;
    }

    public final void c(c r9, final Runnable r10) {
        if (this.f == true) goto L6;
        r10.run();
        return;
    L6:
        final int r0 = this.d + 1;
        this.d = r0;
        d r2 = this.c;
        if (r2 == null) goto L9;
        r2.a(true);
    L9:
        this.c = null;
        this.e = r9;
        e(r9);
        setProgress(0.0f);
        setVisibility(0);
        com.obric.common.oea.foundation.animation.builder.d.a r4 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r4.a = 1.0f;
        int r11 = (int) r9.g;
        Token.Easing r6 = o;
        Intrinsics.checkNotNullParameter(r6, "easing");
        r4.b(0.0f, 1.0f, new hja.a(r11, 0, r6), null);
        Function3 r12 = new faa.a(r0, this);
        Intrinsics.checkNotNullParameter(r12, "callback");
        r4.d = r12;
        Function2 r13 = new faa.b(r10, r0, this);
        Intrinsics.checkNotNullParameter(r13, "callback");
        r4.e = r13;
        this.c = r4.a().a();
    }

    public RippleEffectView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        RuntimeShader r7 = new RuntimeShader("\n            uniform vec2 uResolution;\n            uniform vec2 uOrigin;\n            uniform float uProgress;\n            uniform float uTravelDistance;\n            uniform float uPulseWidth;\n            uniform float uWaveGlowIntensity;\n            uniform float uTrailDecayLength;\n\n            const vec3 RIPPLE_BLUE = vec3(0.051, 0.447, 1.0);\n            const vec3 RIPPLE_CYAN = vec3(0.608, 0.863, 1.0);\n            const float FREQUENCY = 4.0;\n            const float TRAIL_DISPLACEMENT = 0.32;\n            const float CREST_ALPHA = 0.44;\n            const float SHOULDER_ALPHA = 0.16;\n            const float HALO_ALPHA = 0.09;\n            const float RIPPLE_LINE_ALPHA = 0.18;\n            const float TRAIL_ALPHA = 0.12;\n            const float WASH_ALPHA = 0.04;\n            const float DISPLACEMENT_ALPHA = 0.08;\n\n            // 锚定谐波：扣掉 t=0 的初始值，避免开场跳变。\n            float harmonic(float t, float ratio, float phase, float weight) {\n                return (sin(t * ratio + phase) - sin(phase)) * weight;\n            }\n\n            vec4 main(vec2 fragCoord) {\n                vec2 position = fragCoord;\n                vec2 delta = position - uOrigin;\n                float dist = length(delta);\n\n                // 波形包络：前沿高斯环 + 已经过区域的指数拖尾。\n                float waveFront = uProgress * uTravelDistance;\n                float ringOffset = (dist - waveFront) / uPulseWidth;\n                float crest = exp(-ringOffset * ringOffset * 5.5);\n                float shoulder = exp(-ringOffset * ringOffset * 1.25);\n                float haloOffset = (dist - waveFront) / (uPulseWidth * 1.8);\n                float halo = exp(-haloOffset * haloOffset);\n                float frontActivation = smoothstep(0.0, uPulseWidth * 0.9, waveFront);\n                float passedFront = smoothstep(-uPulseWidth * 0.5, uPulseWidth * 1.5, waveFront - dist);\n                float trailDecayDistance = uPulseWidth * max(uTrailDecayLength, 0.001);\n                float trail = passedFront * exp(-max(waveFront - dist, 0.0) / trailDecayDistance);\n                float behindFront = max(waveFront - dist, 0.0) / max(uPulseWidth, 1.0);\n                float washDecayDistance = uPulseWidth * max(uTrailDecayLength * 1.7, 0.001);\n                float wash = passedFront * exp(-max(waveFront - dist, 0.0) / washDecayDistance);\n\n                // 按半径延迟波相位，让波纹从 origin 向外传播。\n                float waveTime = max(0.0, uProgress - dist / max(uTravelDistance, 1.0));\n                float w = waveTime * FREQUENCY;\n                float totalWave = sin(w)\n                                + harmonic(w, 0.82, -1.45, 0.52)\n                                + harmonic(w, 1.27,  0.72, 0.28);\n                float rippleLineWave = pow(0.5 + 0.5 * sin(behindFront * 13.0 + totalWave * 0.65), 3.0);\n                float rippleLines = trail * rippleLineWave * exp(-behindFront / max(uTrailDecayLength * 1.2, 0.001));\n\n                float displacementMask = max(shoulder, trail * TRAIL_DISPLACEMENT) * frontActivation;\n                float crestShape = clamp(crest * frontActivation, 0.0, 1.0);\n                float shoulderShape = clamp(shoulder * frontActivation, 0.0, 1.0);\n                float haloShape = clamp(halo * frontActivation, 0.0, 1.0);\n                float trailShape = clamp(trail * frontActivation, 0.0, 1.0);\n                float rippleLineShape = clamp(rippleLines * frontActivation, 0.0, 1.0);\n                float washShape = clamp(\n                    wash\n                        * frontActivation\n                        * smoothstep(0.02, 0.18, uProgress)\n                        * (1.0 - smoothstep(0.78, 1.0, uProgress)),\n                    0.0,\n                    1.0);\n\n                // 颜色层：使用豆包光晕主蓝色。清晰 crest + 细纹拖尾负责涟漪感，\n                // 低 alpha halo / wash 只补偿 View 没有 ±depth 形变时的视觉裁薄。\n                float waveBoost = smoothstep(-0.2, 1.0, totalWave);\n                vec3 waveColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.28 + 0.38 * waveBoost);\n                vec3 haloColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.18);\n                float waveAlpha = (\n                    crestShape * CREST_ALPHA\n                    + shoulderShape * SHOULDER_ALPHA\n                    + haloShape * HALO_ALPHA\n                    + rippleLineShape * RIPPLE_LINE_ALPHA\n                    + trailShape * TRAIL_ALPHA\n                    + washShape * WASH_ALPHA\n                    + displacementMask * DISPLACEMENT_ALPHA\n                ) * uWaveGlowIntensity;\n                float alpha = clamp(waveAlpha, 0.0, 0.54);\n\n                vec3 color = mix(\n                    haloColor,\n                    waveColor,\n                    clamp(crestShape + rippleLineShape * 0.75 + shoulderShape * 0.35, 0.0, 1.0));\n                return vec4(color * alpha, alpha);\n            }\n        ");
        this.a = r7;
        boolean r8 = true;
        Paint r9 = new Paint(1);
        r9.setShader(r7);
        this.b = r9;
        this.e = m;
        List<b> r10 = p;
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L22;
        b r12 = (b) r11.next();
        r12.getClass();
        if (Intrinsics.areEqual(faa.c.a(Build.MANUFACTURER), r12.a) == true) goto L13;
    L19:
        boolean r13 = false;
    L20:
        if (r13 == false) goto L9;
        r8 = false;
        goto L22
    L13:
        if (Intrinsics.areEqual(faa.c.a(Build.BRAND), r12.b) == false) goto L19;
        if (Intrinsics.areEqual(faa.c.a(Build.MODEL), r12.c) == false) goto L19;
        if (Intrinsics.areEqual(faa.c.a(Build.DEVICE), r12.d) == false) goto L19;
        r13 = true;
    L22:
        this.f = r8;
        this.k = 1.0f;
        if (r8 == false) goto L25;
        int r14 = 4;
    L26:
        setVisibility(r14);
        setLayerType(2, null);
        return;
    L25:
        r14 = 8;
        goto L26
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }

    public static Unit b(Runnable r0, int r1, RippleEffectView r2) {
        if (r0 == null) goto L4;
        r0.run();
    L4:
        int r3 = r2.d;
        if (r1 != r3) goto L16;
        if (r1 != r3) goto L15;
        r2.c = null;
        r2.setProgress(0.0f);
        if (r2.f == false) goto L12;
        int r4 = 4;
    L13:
        r2.setVisibility(r4);
        goto L15
    L12:
        r4 = 8;
    L15:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    }

    public /* synthetic */ RippleEffectView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.c == null) goto L6;
        e(this.e);
        return;
    }

    public static Unit a(int r1, RippleEffectView r2, String r3, Object r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, "value");
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        if (r1 != r2.d) goto L7;
        r2.setProgress(RangesKt.coerceIn(((Float) r4).floatValue(), 0.0f, 1.0f));
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }
}
