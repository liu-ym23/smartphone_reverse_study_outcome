package gaa;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import bytedanceos.api.DisplayManagerSmt;
import bytedanceos.api.TransactionSmt;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.Token;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final b g = null;
    public static final b h = null;
    public static final Token.Easing i = null;
    public final Context a;
    public final WindowManager b;
    public fja.d c;
    public IBinder d;
    public final Lazy e;
    public volatile int f;

    public static final class a {
    }

    public static final class b {
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
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
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

        public b(float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10) {
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

    public static final class c {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "ScreenSize(width=" + this.a + ", height=" + this.b + ')';
        }

        public c(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        g = new b(1.2f, 70.0f, 0.5f, 2.2f, 0.0f, 1.0f, 2.0f, 1.0f, 0.0f);
        h = new b(0.5f, 10.0f, 0.2f, 1.0f, 0.16f, 0.3f, 1.5f, 0.5f, 1.0f);
        i = Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD;
    }

    public final c c() {
        Point r0 = new Point();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        WindowManager r2 = this.b;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        Display r3 = r2.getDefaultDisplay();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.getRealSize(r0);     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L16;
        ILogDepend.a.w("RippleEffect", "getRealScreenSize failed, fallback to displayMetrics", r6);
    L16:
        int r7 = r0.x;
        if (r7 <= 0) goto L22;
        int r8 = r0.y;
        if (r8 <= 0) goto L22;
        return new c(r7, r8);
    L22:
        Resources r9 = this.a.getResources();
        DisplayMetrics r10 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics());
        return new c(r10.widthPixels, r10.heightPixels);
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Context r3 = r2.getApplicationContext();
        this.a = r3;
        Object r4 = r3.getSystemService("window");
        if ((r4 instanceof WindowManager) == false) goto L5;
        WindowManager r5 = (WindowManager) r4;
    L6:
        this.b = r5;
        this.e = LazyKt.lazy(new gaa.a());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static void a(ArrayList r2, float r3) {
        r2.add(new Pair("uniform_float", String.valueOf(r3)));
    }

    public final void d(final b r19, boolean r20, String r21, final Runnable r22) {
        IBinder r0 = this.d;
        if (r0 != null) goto L24;
        if (r0 != null) goto L24;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl(DisplayManagerSmt.getInstance().getDisplayToken(this.a, 0));     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.exceptionOrNull-impl(r2);
        if (r5 == null) goto L14;
        ILogDepend.a.w("RippleEffect", "Failed to get display token", r5);
    L14:
        if (Result.isSuccess-impl(r2) == false) goto L20;
        IBinder r3 = (IBinder) r2;
        this.d = r3;
        if (r3 == null) goto L18;
        boolean r4 = true;
    L19:
        r2 = Boolean.valueOf(r4);
        goto L20
    L18:
        r4 = false;
    L20:
        Object r6 = Result.constructor-impl(r2);
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L23;
        r6 = r7;
    L23:
        ((Boolean) r6).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        final IBinder r9 = this.d;
        if (r9 != null) goto L27;
        ILogDepend.a.w("RippleEffect", "Display token not initialized");
    L27:
        if (r9 != null) goto L30;
        ILogDepend.a.w("RippleEffect", "playRipple: displayToken is null");
        r22.run();
        return;
    L30:
        this.f++;
        final int r11 = this.f;
        fja.d r10 = this.c;
        if (r10 == null) goto L33;
        r10.a(true);
    L33:
        this.c = null;
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = c();
        ILogDepend.a.i("RippleEffect", "playRipple: screenWidth=" + ((c) r13.element).a + ", screenHeight=" + ((c) r13.element).b + ", globalEffectStopLayerEffective=" + ((Boolean) this.e.getValue()).booleanValue() + ", skipWindowLayer=" + r20 + ", windowLayerName=" + r21);
        final float r14 = haa.b.a(r19.c);
        final float r15 = haa.b.a(r19.e);
        final float r16 = haa.b.a(r19.k);
        TransactionSmt r12 = TransactionSmt.getInstance();
        ArrayList r17 = CollectionsKt.arrayListOf(new Pair[]{new Pair("shader", "\n            uniform vec2 uResolution;\n            uniform vec2 uOrigin;\n            uniform float uProgress;\n            uniform float uScreenDimIntensity;\n            uniform float uTravelDistance;\n            uniform float uAmplitude;\n            uniform float uAmplitudeRamp;\n            uniform float uDeformationIntensity;\n            uniform float uPulseWidth;\n            uniform float uWaveGlowIntensity;\n            uniform float uTrailDecayLength;\n            uniform float uEdgeGlowRadius;\n            uniform float uEdgeGlowColorIntensity;\n            uniform float uEdgeGlowIntensity;\n            uniform shader uScreen;\n\n            const vec3 RIPPLE_TINT = vec3(0.18, 0.34, 0.72);\n            const vec3 FILL_GLOW_COLOR = vec3(0.03, 0.08, 0.18);\n            const float FREQUENCY = 4.0;\n            const float SCREEN_DIM_FADE_IN_END = 0.2;\n            const float SCREEN_DIM_FADE_OUT_START = 0.6;\n            const vec3 EDGE_GLOW_COLOR = vec3(0.72, 0.88, 1.0);\n            const float EDGE_GLOW_THRESHOLD = 0.1;\n            const float EDGE_GLOW_SOFTNESS = 0.08;\n            const float TRAIL_DISPLACEMENT = 0.32;\n            const float INTERIOR_GLOW_FALLOFF = 2.4;\n            const float FILL_GLOW_DECAY = 3.5;\n\n            // 锚定谐波：扣掉 t=0 的初始值，避免开场跳变。\n            float harmonic(float t, float ratio, float phase, float weight) {\n                return (sin(t * ratio + phase) - sin(phase)) * weight;\n            }\n\n            float luminance(vec3 color) {\n                return dot(color, vec3(0.299, 0.587, 0.114));\n            }\n\n            float localContrastEdge(vec2 position, float radiusPx, float centerLuma) {\n                vec2 texel = vec2(max(radiusPx, 0.5));\n\n                float minLuma = centerLuma;\n                float maxLuma = centerLuma;\n\n                float luma = luminance(uScreen.eval(clamp(position + texel * vec2(-1.0, 0.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(1.0, 0.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(0.0, -1.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(0.0, 1.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n\n                return maxLuma - minLuma;\n            }\n\n            vec4 main(vec2 fragCoord) {\n                vec2 position = fragCoord;\n                vec2 delta = position - uOrigin;\n                float dist = length(delta);\n                vec2 dir = dist > 0.0001 ? delta / dist : vec2(0.0, 1.0);\n\n                // 波形包络：前沿高斯环 + 已经过区域的指数拖尾。\n                float waveFront = uProgress * uTravelDistance;\n                float ringOffset = (dist - waveFront) / uPulseWidth;\n                float ring = exp(-ringOffset * ringOffset);\n                float frontActivation = smoothstep(0.0, uPulseWidth * 0.9, waveFront);\n                float passedFront = smoothstep(-uPulseWidth * 0.5, uPulseWidth * 1.5, waveFront - dist);\n                float trailDecayDistance = uPulseWidth * max(uTrailDecayLength, 0.001);\n                float trail = passedFront * exp(-max(waveFront - dist, 0.0) / trailDecayDistance);\n\n                // 按半径延迟波相位，让波纹从 origin 向外传播。\n                float waveTime = max(0.0, uProgress - dist / max(uTravelDistance, 1.0));\n                float w = waveTime * FREQUENCY;\n                float totalWave = sin(w)\n                                + harmonic(w, 0.82, -1.45, 0.52)\n                                + harmonic(w, 1.27,  0.72, 0.28);\n\n                // 按包络做径向位移；AGSL 采样使用像素坐标，区别于 WebGL 的归一化坐标。\n                float displacementMask = max(ring, trail * TRAIL_DISPLACEMENT) * frontActivation;\n                float displacement = (totalWave * uAmplitude + dist * uAmplitudeRamp * abs(totalWave))\n                                     * displacementMask\n                                     * uDeformationIntensity;\n                vec2 warpedPos = clamp(position + dir * displacement, vec2(0.0), uResolution);\n\n                // 颜色层：形变后的原图 + 波纹染色 + 内部填充 glow。\n                vec3 screenColor = uScreen.eval(warpedPos).rgb;\n                float screenDim = uScreenDimIntensity\n                                * smoothstep(0.0, SCREEN_DIM_FADE_IN_END, uProgress)\n                                * (1.0 - smoothstep(SCREEN_DIM_FADE_OUT_START, 1.0, uProgress));\n                vec3 baseColor = screenColor * (1.0 - screenDim);\n                vec3 rippleTint = RIPPLE_TINT * (0.45 + 0.55 * max(totalWave, 0.0));\n                float interiorGlow = exp(-pow(dist / (waveFront + 1.0), INTERIOR_GLOW_FALLOFF));\n                vec3 fillGlow = FILL_GLOW_COLOR * interiorGlow * exp(-uProgress * FILL_GLOW_DECAY);\n\n                vec3 edgeGlow = vec3(0.0);\n                if (uEdgeGlowIntensity > 0.0) {\n                    float highlightFade = 1.0 - smoothstep(0.78, 1.0, uProgress);\n                    float highlightMask = clamp(ring * 0.85 + trail * 0.12, 0.0, 1.0)\n                                        * frontActivation\n                                        * highlightFade;\n                    float centerLuma = luminance(screenColor);\n                    float edgeFine = localContrastEdge(warpedPos, uEdgeGlowRadius, centerLuma);\n                    float edgeWide = localContrastEdge(warpedPos, uEdgeGlowRadius * 2.4, centerLuma) * 0.65;\n                    float edgeCore = smoothstep(\n                        EDGE_GLOW_THRESHOLD,\n                        EDGE_GLOW_THRESHOLD + EDGE_GLOW_SOFTNESS,\n                        edgeFine);\n                    float edgeHalo = smoothstep(\n                        EDGE_GLOW_THRESHOLD,\n                        EDGE_GLOW_THRESHOLD + EDGE_GLOW_SOFTNESS,\n                        edgeWide);\n                    float edgeMask = clamp(edgeCore * (1.0 + edgeHalo * 0.45), 0.0, 1.0);\n                    edgeMask = pow(edgeMask, 1.05);\n                    edgeGlow = EDGE_GLOW_COLOR * uEdgeGlowColorIntensity * edgeMask * highlightMask * uEdgeGlowIntensity;\n                }\n\n                vec3 waveGlow = rippleTint * (ring + trail);\n                vec3 color = baseColor + (waveGlow + fillGlow) * uWaveGlowIntensity + edgeGlow;\n\n                return vec4(color, 1.0);\n            }\n        "), new Pair("duration", String.valueOf(r19.g))});
        if (r20 == true) goto L36;
    L38:
        r12.setAnimationProperty(r9, r17);
        TransactionSmt.getInstance().setAnimationProperty(r9, b(r19, (c) r13.element, 0.0f, r14, r15, r16));
        TransactionSmt.getInstance().startAnimation(r9);
        com.obric.common.oea.foundation.animation.builder.d.a r18 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r18.a = 1.0f;
        int r23 = (int) r19.g;
        Token.Easing r24 = i;
        Intrinsics.checkNotNullParameter(r24, "easing");
        r18.b(0.0f, 1.0f, new hja.a(r23, 0, r24), null);
        Function3 r110 = new gaa.b(r11, this, r13, r9, r19, r14, r15, r16);
        Intrinsics.checkNotNullParameter(r110, "callback");
        r18.d = r110;
        Function2 r25 = new gaa.c(r22, r11, this, r9);
        Intrinsics.checkNotNullParameter(r25, "callback");
        r18.e = r25;
        this.c = r18.a().a();
        return;
    L36:
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L38;
        r17.add(new Pair("part", "1"));
        r17.add(new Pair("stop_layer", r21));
        goto L38
    }

    public final ArrayList<Pair<String, String>> b(b r8, c r9, float r10, float r11, float r12, float r13) {
        float r0 = r9.a;
        float r14 = r9.b;
        float r1 = r8.a * r0;
        float r2 = r8.b * r14;
        float r3 = ((float) Math.hypot(r0, r14)) * r8.f;
        if (r0 > r14) goto L5;
    L8:
        float r4 = 1.0f;
    L9:
        ArrayList<Pair<String, String>> r5 = new ArrayList(16);
        a(r5, r0);
        a(r5, r14);
        a(r5, r1);
        a(r5, r2);
        a(r5, r10);
        a(r5, r8.h);
        a(r5, r3);
        a(r5, r11);
        a(r5, r8.d);
        a(r5, r4);
        a(r5, r12);
        a(r5, r8.i);
        a(r5, r8.j);
        a(r5, r13);
        a(r5, r8.l);
        a(r5, r8.m);
        return r5;
    L5:
        if (((Boolean) this.e.getValue()).booleanValue() == true) goto L8;
        r4 = 0.0f;
        goto L9
    }
}
