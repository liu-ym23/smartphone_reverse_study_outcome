package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.os_specific;

import android.content.Context;
import android.graphics.Point;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import bytedanceos.api.DisplayManagerSmt;
import bytedanceos.api.TransactionSmt;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.b;
import com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.os_specific.util.units.DisplayUnitsKt;
import com.obric.common.oea.foundation.animation.builder.c;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.spec.a;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0003:;<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u000fJ&\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ&\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ*\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u000fJ\n\u0010$\u001a\u0004\u0018\u00010\rH\u0002JH\u0010%\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0'0&j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0'`(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J<\u0010+\u001a\u00020\u0018**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0'0&j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0'`(2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0015H\u0002J`\u00100\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0'0&j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0'`(2\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u000202H\u0002J\u0018\u00108\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0015H\u0002R\u0018\u0010\u0002\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "windowManager", "Landroid/view/WindowManager;", "animationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "displayToken", "Landroid/os/IBinder;", "globalEffectStopLayerEffective", "", "getGlobalEffectStopLayerEffective", "()Z", "globalEffectStopLayerEffective$delegate", "Lkotlin/Lazy;", "playGeneration", "", "initialize", "playWakeUpEffect", "", "skipWindowLayer", "windowLayerName", "", "onEnd", "Ljava/lang/Runnable;", "playCaptureEffect", "playRipple", "spec", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect$RippleSpec;", "stop", "isPlaying", "ensureDisplayToken", "buildStaticProperties", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Lkotlin/collections/ArrayList;", "duration", "", "addUniform", EventBody.KEY_VALUE, "", "cancelRunningAnimation", "nextGeneration", "buildFrameProperties", "screenSize", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect$ScreenSize;", "progress", "amplitude", "pulseWidth", "edgeGlowRadius", "getRealScreenSize", "cleanupAnimation", PendingPersonalInfoNotificationTask.KEY_GENERATION, "Companion", "RippleSpec", "ScreenSize", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleEffect {
    private static final RippleSpec CAPTURE_SPEC = null;
    public static final Companion Companion = null;
    private static final float DEFAULT_DEFORMATION_INTENSITY = 1.0f;
    private static final Token.Easing DEFAULT_EASING = null;
    private static final String ENABLED_VALUE = "1";
    private static final int FRAME_UNIFORM_COUNT = 16;
    private static final float LANDSCAPE_DEFORMATION_INTENSITY = 1.0f;
    private static final float LEGACY_LANDSCAPE_DEFORMATION_INTENSITY = 0.0f;
    private static final String PROPERTY_DURATION = "duration";
    private static final String PROPERTY_PART = "part";
    private static final String PROPERTY_SHADER = "shader";
    private static final String PROPERTY_STOP_LAYER = "stop_layer";
    private static final String PROPERTY_UNIFORM_FLOAT = "uniform_float";
    private static final String RIPPLE_SHADER_AGSL = "\n            uniform vec2 uResolution;\n            uniform vec2 uOrigin;\n            uniform float uProgress;\n            uniform float uScreenDimIntensity;\n            uniform float uTravelDistance;\n            uniform float uAmplitude;\n            uniform float uAmplitudeRamp;\n            uniform float uDeformationIntensity;\n            uniform float uPulseWidth;\n            uniform float uWaveGlowIntensity;\n            uniform float uTrailDecayLength;\n            uniform float uEdgeGlowRadius;\n            uniform float uEdgeGlowColorIntensity;\n            uniform float uEdgeGlowIntensity;\n            uniform shader uScreen;\n\n            const vec3 RIPPLE_TINT = vec3(0.18, 0.34, 0.72);\n            const vec3 FILL_GLOW_COLOR = vec3(0.03, 0.08, 0.18);\n            const float FREQUENCY = 4.0;\n            const float SCREEN_DIM_FADE_IN_END = 0.2;\n            const float SCREEN_DIM_FADE_OUT_START = 0.6;\n            const vec3 EDGE_GLOW_COLOR = vec3(0.72, 0.88, 1.0);\n            const float EDGE_GLOW_THRESHOLD = 0.1;\n            const float EDGE_GLOW_SOFTNESS = 0.08;\n            const float TRAIL_DISPLACEMENT = 0.32;\n            const float INTERIOR_GLOW_FALLOFF = 2.4;\n            const float FILL_GLOW_DECAY = 3.5;\n\n            // 锚定谐波：扣掉 t=0 的初始值，避免开场跳变。\n            float harmonic(float t, float ratio, float phase, float weight) {\n                return (sin(t * ratio + phase) - sin(phase)) * weight;\n            }\n\n            float luminance(vec3 color) {\n                return dot(color, vec3(0.299, 0.587, 0.114));\n            }\n\n            float localContrastEdge(vec2 position, float radiusPx, float centerLuma) {\n                vec2 texel = vec2(max(radiusPx, 0.5));\n\n                float minLuma = centerLuma;\n                float maxLuma = centerLuma;\n\n                float luma = luminance(uScreen.eval(clamp(position + texel * vec2(-1.0, 0.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(1.0, 0.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(0.0, -1.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(0.0, 1.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n\n                return maxLuma - minLuma;\n            }\n\n            vec4 main(vec2 fragCoord) {\n                vec2 position = fragCoord;\n                vec2 delta = position - uOrigin;\n                float dist = length(delta);\n                vec2 dir = dist > 0.0001 ? delta / dist : vec2(0.0, 1.0);\n\n                // 波形包络：前沿高斯环 + 已经过区域的指数拖尾。\n                float waveFront = uProgress * uTravelDistance;\n                float ringOffset = (dist - waveFront) / uPulseWidth;\n                float ring = exp(-ringOffset * ringOffset);\n                float frontActivation = smoothstep(0.0, uPulseWidth * 0.9, waveFront);\n                float passedFront = smoothstep(-uPulseWidth * 0.5, uPulseWidth * 1.5, waveFront - dist);\n                float trailDecayDistance = uPulseWidth * max(uTrailDecayLength, 0.001);\n                float trail = passedFront * exp(-max(waveFront - dist, 0.0) / trailDecayDistance);\n\n                // 按半径延迟波相位，让波纹从 origin 向外传播。\n                float waveTime = max(0.0, uProgress - dist / max(uTravelDistance, 1.0));\n                float w = waveTime * FREQUENCY;\n                float totalWave = sin(w)\n                                + harmonic(w, 0.82, -1.45, 0.52)\n                                + harmonic(w, 1.27,  0.72, 0.28);\n\n                // 按包络做径向位移；AGSL 采样使用像素坐标，区别于 WebGL 的归一化坐标。\n                float displacementMask = max(ring, trail * TRAIL_DISPLACEMENT) * frontActivation;\n                float displacement = (totalWave * uAmplitude + dist * uAmplitudeRamp * abs(totalWave))\n                                     * displacementMask\n                                     * uDeformationIntensity;\n                vec2 warpedPos = clamp(position + dir * displacement, vec2(0.0), uResolution);\n\n                // 颜色层：形变后的原图 + 波纹染色 + 内部填充 glow。\n                vec3 screenColor = uScreen.eval(warpedPos).rgb;\n                float screenDim = uScreenDimIntensity\n                                * smoothstep(0.0, SCREEN_DIM_FADE_IN_END, uProgress)\n                                * (1.0 - smoothstep(SCREEN_DIM_FADE_OUT_START, 1.0, uProgress));\n                vec3 baseColor = screenColor * (1.0 - screenDim);\n                vec3 rippleTint = RIPPLE_TINT * (0.45 + 0.55 * max(totalWave, 0.0));\n                float interiorGlow = exp(-pow(dist / (waveFront + 1.0), INTERIOR_GLOW_FALLOFF));\n                vec3 fillGlow = FILL_GLOW_COLOR * interiorGlow * exp(-uProgress * FILL_GLOW_DECAY);\n\n                vec3 edgeGlow = vec3(0.0);\n                if (uEdgeGlowIntensity > 0.0) {\n                    float highlightFade = 1.0 - smoothstep(0.78, 1.0, uProgress);\n                    float highlightMask = clamp(ring * 0.85 + trail * 0.12, 0.0, 1.0)\n                                        * frontActivation\n                                        * highlightFade;\n                    float centerLuma = luminance(screenColor);\n                    float edgeFine = localContrastEdge(warpedPos, uEdgeGlowRadius, centerLuma);\n                    float edgeWide = localContrastEdge(warpedPos, uEdgeGlowRadius * 2.4, centerLuma) * 0.65;\n                    float edgeCore = smoothstep(\n                        EDGE_GLOW_THRESHOLD,\n                        EDGE_GLOW_THRESHOLD + EDGE_GLOW_SOFTNESS,\n                        edgeFine);\n                    float edgeHalo = smoothstep(\n                        EDGE_GLOW_THRESHOLD,\n                        EDGE_GLOW_THRESHOLD + EDGE_GLOW_SOFTNESS,\n                        edgeWide);\n                    float edgeMask = clamp(edgeCore * (1.0 + edgeHalo * 0.45), 0.0, 1.0);\n                    edgeMask = pow(edgeMask, 1.05);\n                    edgeGlow = EDGE_GLOW_COLOR * uEdgeGlowColorIntensity * edgeMask * highlightMask * uEdgeGlowIntensity;\n                }\n\n                vec3 waveGlow = rippleTint * (ring + trail);\n                vec3 color = baseColor + (waveGlow + fillGlow) * uWaveGlowIntensity + edgeGlow;\n\n                return vec4(color, 1.0);\n            }\n        ";
    private static final String TAG = "RippleEffect";
    private static final RippleSpec WAKE_UP_SPEC = null;
    private d animationManager;
    private final Context context;
    private IBinder displayToken;
    private final Lazy globalEffectStopLayerEffective$delegate;
    private volatile int playGeneration;
    private final WindowManager windowManager;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect$Companion;", "", "<init>", "()V", "TAG", "", "FRAME_UNIFORM_COUNT", "", "DEFAULT_DEFORMATION_INTENSITY", "", "LEGACY_LANDSCAPE_DEFORMATION_INTENSITY", "LANDSCAPE_DEFORMATION_INTENSITY", "PROPERTY_SHADER", "PROPERTY_DURATION", "PROPERTY_UNIFORM_FLOAT", "PROPERTY_PART", "ENABLED_VALUE", "PROPERTY_STOP_LAYER", "WAKE_UP_SPEC", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect$RippleSpec;", "CAPTURE_SPEC", "DEFAULT_EASING", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "RIPPLE_SHADER_AGSL", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00067"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect$RippleSpec;", "", "originFractionX", "", "originFractionY", "amplitudeDp", "amplitudeRamp", "pulseWidthDp", "travelDistanceMultiplier", "durationMs", "", "screenDimIntensity", "waveGlowIntensity", "trailDecayLength", "edgeGlowRadiusDp", "edgeGlowColorIntensity", "edgeGlowIntensity", "<init>", "(FFFFFFJFFFFFF)V", "getOriginFractionX", "()F", "getOriginFractionY", "getAmplitudeDp", "getAmplitudeRamp", "getPulseWidthDp", "getTravelDistanceMultiplier", "getDurationMs", "()J", "getScreenDimIntensity", "getWaveGlowIntensity", "getTrailDecayLength", "getEdgeGlowRadiusDp", "getEdgeGlowColorIntensity", "getEdgeGlowIntensity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class RippleSpec {
        private final float amplitudeDp;
        private final float amplitudeRamp;
        private final long durationMs;
        private final float edgeGlowColorIntensity;
        private final float edgeGlowIntensity;
        private final float edgeGlowRadiusDp;
        private final float originFractionX;
        private final float originFractionY;
        private final float pulseWidthDp;
        private final float screenDimIntensity;
        private final float trailDecayLength;
        private final float travelDistanceMultiplier;
        private final float waveGlowIntensity;

        public RippleSpec(float r1, float r2, float r3, float r4, float r5, float r6, long r7, float r9, float r10, float r11, float r12, float r13, float r14) {
            this.originFractionX = r1;
            this.originFractionY = r2;
            this.amplitudeDp = r3;
            this.amplitudeRamp = r4;
            this.pulseWidthDp = r5;
            this.travelDistanceMultiplier = r6;
            this.durationMs = r7;
            this.screenDimIntensity = r9;
            this.waveGlowIntensity = r10;
            this.trailDecayLength = r11;
            this.edgeGlowRadiusDp = r12;
            this.edgeGlowColorIntensity = r13;
            this.edgeGlowIntensity = r14;
        }

        public static /* synthetic */ RippleSpec copy$default(RippleSpec r15, float r16, float r17, float r18, float r19, float r20, float r21, long r22, float r24, float r25, float r26, float r27, float r28, float r29, int r30, Object r31) {
            if ((r30 & 1) == 0) goto L5;
            float r2 = r15.originFractionX;
        L7:
            if ((r30 & 2) == 0) goto L9;
            float r3 = r15.originFractionY;
        L11:
            if ((r30 & 4) == 0) goto L13;
            float r4 = r15.amplitudeDp;
        L15:
            if ((r30 & 8) == 0) goto L17;
            float r5 = r15.amplitudeRamp;
        L19:
            if ((r30 & 16) == 0) goto L21;
            float r6 = r15.pulseWidthDp;
        L23:
            if ((r30 & 32) == 0) goto L25;
            float r7 = r15.travelDistanceMultiplier;
        L27:
            if ((r30 & 64) == 0) goto L29;
            long r8 = r15.durationMs;
        L31:
            if ((r30 & 128) == 0) goto L33;
            float r10 = r15.screenDimIntensity;
        L35:
            if ((r30 & 256) == 0) goto L37;
            float r11 = r15.waveGlowIntensity;
        L39:
            if ((r30 & 512) == 0) goto L41;
            float r12 = r15.trailDecayLength;
        L43:
            if ((r30 & 1024) == 0) goto L45;
            float r13 = r15.edgeGlowRadiusDp;
        L47:
            if ((r30 & 2048) == 0) goto L49;
            float r14 = r15.edgeGlowColorIntensity;
        L51:
            if ((r30 & 4096) == 0) goto L53;
            float r1 = r15.edgeGlowIntensity;
        L55:
            return r15.copy(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r1);
        L53:
            r1 = r29;
            goto L55
        L49:
            r14 = r28;
            goto L51
        L45:
            r13 = r27;
            goto L47
        L41:
            r12 = r26;
            goto L43
        L37:
            r11 = r25;
            goto L39
        L33:
            r10 = r24;
            goto L35
        L29:
            r8 = r22;
            goto L31
        L25:
            r7 = r21;
            goto L27
        L21:
            r6 = r20;
            goto L23
        L17:
            r5 = r19;
            goto L19
        L13:
            r4 = r18;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r2 = r16;
            goto L7
        }

        public final float component1() {
            return this.originFractionX;
        }

        public final float component10() {
            return this.trailDecayLength;
        }

        public final float component11() {
            return this.edgeGlowRadiusDp;
        }

        public final float component12() {
            return this.edgeGlowColorIntensity;
        }

        public final float component13() {
            return this.edgeGlowIntensity;
        }

        public final float component2() {
            return this.originFractionY;
        }

        public final float component3() {
            return this.amplitudeDp;
        }

        public final float component4() {
            return this.amplitudeRamp;
        }

        public final float component5() {
            return this.pulseWidthDp;
        }

        public final float component6() {
            return this.travelDistanceMultiplier;
        }

        public final long component7() {
            return this.durationMs;
        }

        public final float component8() {
            return this.screenDimIntensity;
        }

        public final float component9() {
            return this.waveGlowIntensity;
        }

        public final RippleSpec copy(float r17, float r18, float r19, float r20, float r21, float r22, long r23, float r25, float r26, float r27, float r28, float r29, float r30) {
            return new RippleSpec(r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, RippleSpec.class) == true) goto L8;
            return false;
        L8:
            RippleSpec r10 = (RippleSpec) ZeusTransformUtils.preCheckCast(r9, RippleSpec.class, "com.obric.memorydata.plugin");
            if (Float.compare(this.originFractionX, r10.originFractionX) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.originFractionY, r10.originFractionY) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.amplitudeDp, r10.amplitudeDp) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.amplitudeRamp, r10.amplitudeRamp) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.pulseWidthDp, r10.pulseWidthDp) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.travelDistanceMultiplier, r10.travelDistanceMultiplier) == 0) goto L27;
            return false;
        L27:
            if (this.durationMs == r10.durationMs) goto L30;
            return false;
        L30:
            if (Float.compare(this.screenDimIntensity, r10.screenDimIntensity) == 0) goto L33;
            return false;
        L33:
            if (Float.compare(this.waveGlowIntensity, r10.waveGlowIntensity) == 0) goto L36;
            return false;
        L36:
            if (Float.compare(this.trailDecayLength, r10.trailDecayLength) == 0) goto L39;
            return false;
        L39:
            if (Float.compare(this.edgeGlowRadiusDp, r10.edgeGlowRadiusDp) == 0) goto L42;
            return false;
        L42:
            if (Float.compare(this.edgeGlowColorIntensity, r10.edgeGlowColorIntensity) == 0) goto L45;
            return false;
        L45:
            if (Float.compare(this.edgeGlowIntensity, r10.edgeGlowIntensity) == 0) goto L47;
            return false;
        L47:
            return true;
        }

        public final float getAmplitudeDp() {
            return this.amplitudeDp;
        }

        public final float getAmplitudeRamp() {
            return this.amplitudeRamp;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final float getEdgeGlowColorIntensity() {
            return this.edgeGlowColorIntensity;
        }

        public final float getEdgeGlowIntensity() {
            return this.edgeGlowIntensity;
        }

        public final float getEdgeGlowRadiusDp() {
            return this.edgeGlowRadiusDp;
        }

        public final float getOriginFractionX() {
            return this.originFractionX;
        }

        public final float getOriginFractionY() {
            return this.originFractionY;
        }

        public final float getPulseWidthDp() {
            return this.pulseWidthDp;
        }

        public final float getScreenDimIntensity() {
            return this.screenDimIntensity;
        }

        public final float getTrailDecayLength() {
            return this.trailDecayLength;
        }

        public final float getTravelDistanceMultiplier() {
            return this.travelDistanceMultiplier;
        }

        public final float getWaveGlowIntensity() {
            return this.waveGlowIntensity;
        }

        public int hashCode() {
            return (((((((((((((((((((((((Float.hashCode(this.originFractionX) * 31) + Float.hashCode(this.originFractionY)) * 31) + Float.hashCode(this.amplitudeDp)) * 31) + Float.hashCode(this.amplitudeRamp)) * 31) + Float.hashCode(this.pulseWidthDp)) * 31) + Float.hashCode(this.travelDistanceMultiplier)) * 31) + Long.hashCode(this.durationMs)) * 31) + Float.hashCode(this.screenDimIntensity)) * 31) + Float.hashCode(this.waveGlowIntensity)) * 31) + Float.hashCode(this.trailDecayLength)) * 31) + Float.hashCode(this.edgeGlowRadiusDp)) * 31) + Float.hashCode(this.edgeGlowColorIntensity)) * 31) + Float.hashCode(this.edgeGlowIntensity);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("RippleSpec(originFractionX=").append(this.originFractionX).append(", originFractionY=").append(this.originFractionY).append(", amplitudeDp=").append(this.amplitudeDp).append(", amplitudeRamp=").append(this.amplitudeRamp).append(", pulseWidthDp=").append(this.pulseWidthDp).append(", travelDistanceMultiplier=").append(this.travelDistanceMultiplier).append(", durationMs=").append(this.durationMs).append(", screenDimIntensity=").append(this.screenDimIntensity).append(", waveGlowIntensity=").append(this.waveGlowIntensity).append(", trailDecayLength=").append(this.trailDecayLength).append(", edgeGlowRadiusDp=").append(this.edgeGlowRadiusDp).append(", edgeGlowColorIntensity=");
            r0.append(this.edgeGlowColorIntensity).append(", edgeGlowIntensity=").append(this.edgeGlowIntensity).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/os_specific/RippleEffect$ScreenSize;", "", "width", "", "height", "<init>", "(II)V", "getWidth", "()I", "getHeight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class ScreenSize {
        private final int height;
        private final int width;

        public ScreenSize(int r1, int r2) {
            this.width = r1;
            this.height = r2;
        }

        public static /* synthetic */ ScreenSize copy$default(ScreenSize r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.width;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.height;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        public final ScreenSize copy(int r1, int r2) {
            return new ScreenSize(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ScreenSize.class) == true) goto L8;
            return false;
        L8:
            ScreenSize r6 = (ScreenSize) ZeusTransformUtils.preCheckCast(r5, ScreenSize.class, "com.obric.memorydata.plugin");
            if (this.width == r6.width) goto L12;
            return false;
        L12:
            if (this.height == r6.height) goto L14;
            return false;
        L14:
            return true;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
        }

        public String toString() {
            return "ScreenSize(width=" + this.width + ", height=" + this.height + ')';
        }
    }

    static {
        Companion = new Companion(null);
        WAKE_UP_SPEC = new RippleSpec(0.5f, 1.2f, 70.0f, 0.5f, 70.0f, 2.2f, 1500, 0.0f, 1.0f, 2.0f, 1.0f, 1.0f, 0.0f);
        CAPTURE_SPEC = new RippleSpec(0.5f, 0.5f, 10.0f, 0.2f, 70.0f, 1.0f, 1500, 0.16f, 0.3f, 1.5f, 1.0f, 0.5f, 1.0f);
        DEFAULT_EASING = Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD;
    }

    public RippleEffect(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.context = r5;
        Object r6 = r5.getSystemService("window");
        if (ZeusTransformUtils.instanceOf(r6, WindowManager.class) == false) goto L5;
        WindowManager r7 = (WindowManager) ZeusTransformUtils.preCheckCast(r6, WindowManager.class, "com.obric.memorydata.plugin");
    L6:
        this.windowManager = r7;
        this.globalEffectStopLayerEffective$delegate = LazyKt.lazy($$Lambda$RippleEffect$UAaLQ5MY6J8dpl1q8U0JkdaIHlQ.INSTANCE);
        return;
    L5:
        r7 = null;
        goto L6
    }

    private final void addUniform(ArrayList<Pair<String, String>> r2, float r3) {
        r2.add(new Pair(PROPERTY_UNIFORM_FLOAT, String.valueOf(r3)));
    }

    private final ArrayList<Pair<String, String>> buildFrameProperties(RippleSpec r8, ScreenSize r9, float r10, float r11, float r12, float r13) {
        float r0 = r9.getWidth();
        float r14 = r9.getHeight();
        float r1 = r8.getOriginFractionX() * r0;
        float r2 = r8.getOriginFractionY() * r14;
        float r3 = ((float) Math.hypot(r0, r14)) * r8.getTravelDistanceMultiplier();
        float r5 = 1.0f;
        if (r0 > r14) goto L5;
    L8:
        ArrayList<Pair<String, String>> r4 = new ArrayList(16);
        addUniform(r4, r0);
        addUniform(r4, r14);
        addUniform(r4, r1);
        addUniform(r4, r2);
        addUniform(r4, r10);
        addUniform(r4, r8.getScreenDimIntensity());
        addUniform(r4, r3);
        addUniform(r4, r11);
        addUniform(r4, r8.getAmplitudeRamp());
        addUniform(r4, r5);
        addUniform(r4, r12);
        addUniform(r4, r8.getWaveGlowIntensity());
        addUniform(r4, r8.getTrailDecayLength());
        addUniform(r4, r13);
        addUniform(r4, r8.getEdgeGlowColorIntensity());
        addUniform(r4, r8.getEdgeGlowIntensity());
        return r4;
    L5:
        if (getGlobalEffectStopLayerEffective() == true) goto L8;
        r5 = 0.0f;
        goto L8
    }

    private final ArrayList<Pair<String, String>> buildStaticProperties(long r5, boolean r7, String r8) {
        ArrayList<Pair<String, String>> r6 = CollectionsKt.arrayListOf(new Pair[]{new Pair(PROPERTY_SHADER, RIPPLE_SHADER_AGSL), new Pair("duration", String.valueOf(r5))});
        if (r7 == true) goto L5;
    L7:
        return r6;
    L5:
        if (getGlobalEffectStopLayerEffective() == false) goto L7;
        r6.add(new Pair(PROPERTY_PART, "1"));
        r6.add(new Pair(PROPERTY_STOP_LAYER, r8));
        goto L7
    }

    private final void cancelRunningAnimation() {
        d r0 = this.animationManager;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        this.animationManager = null;
    }

    private final void cleanupAnimation(IBinder r3, int r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        if (r4 == this.playGeneration) goto L5;
        return;
    L5:
        TransactionSmt.getInstance().stopAnimation(r5);
        this.animationManager = null;
    }

    private final IBinder ensureDisplayToken() {
        if (this.displayToken != null) goto L5;
        initialize();
    L5:
        IBinder r3 = this.displayToken;
        if (r3 != null) goto L8;
        com.obric.aiagent.platform.a.d.f5954a.c(TAG, "Display token not initialized");
    L8:
        return r3;
    }

    private final boolean getGlobalEffectStopLayerEffective() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.globalEffectStopLayerEffective$delegate.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final ScreenSize getRealScreenSize() {
        Point r1 = new Point();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        WindowManager r3 = ((RippleEffect) ZeusTransformUtils.preCheckCast(this, RippleEffect.class, "com.obric.memorydata.plugin")).windowManager;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        Display r4 = r3.getDefaultDisplay();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.getRealSize(r1);     // Catch: Throwable -> L11
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.m1421constructorimpl(r5);     // Catch: Throwable -> L11
    L13:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L17;
        com.obric.aiagent.platform.a.d.f5954a.a(TAG, "getRealScreenSize failed, fallback to displayMetrics", r7);
    L17:
        if (r1.x > 0) goto L19;
    L22:
        DisplayMetrics r8 = ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDisplayMetrics();
        return new ScreenSize(r8.widthPixels, r8.heightPixels);
    L19:
        if (r1.y <= 0) goto L22;
        return new ScreenSize(r1.x, r1.y);
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private static final boolean globalEffectStopLayerEffective_delegate$lambda$0() {
        return b.f5974a.b().f();
    }

    public static /* synthetic */ boolean lambda$UAaLQ5MY6J8dpl1q8U0JkdaIHlQ() {
        return globalEffectStopLayerEffective_delegate$lambda$0();
    }

    public static /* synthetic */ Unit lambda$XNKiTxcq62wccPKwynGiXCpOn0M(int r0, RippleEffect r1, Ref.ObjectRef r2, IBinder r3, RippleSpec r4, float r5, float r6, float r7, String r8, Object r9, Object r10) {
        return playRipple$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit lambda$rEW3VqUziWCVJuZw6LL9bZY_7X4(Runnable r0, int r1, RippleEffect r2, IBinder r3, boolean r4, Throwable r5) {
        return playRipple$lambda$5(r0, r1, r2, r3, r4, r5);
    }

    private final int nextGeneration() {
        this.playGeneration++;
        return this.playGeneration;
    }

    public static /* synthetic */ void playCaptureEffect$default(RippleEffect r1, boolean r2, String r3, Runnable r4, int r5, Object r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "obric-assistant-window";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r7 = null;
    L11:
        r1.playCaptureEffect(r2, r3, r7);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.os_specific.RippleEffect$ScreenSize] */
    private final void playRipple(final RippleSpec r24, boolean r25, String r26, Runnable r27) {
        final Runnable r10 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r27, Runnable.class, "com.obric.memorydata.plugin");
        final IBinder r11 = ensureDisplayToken();
        if (r11 != null) goto L8;
        com.obric.aiagent.platform.a.d.f5954a.c(TAG, "playRipple: displayToken is null");
        if (r10 == null) goto L10;
        r10.run();
        return;
    L10:
        return;
    L8:
        final int r12 = nextGeneration();
        cancelRunningAnimation();
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = getRealScreenSize();
        com.obric.aiagent.platform.a.d.f5954a.b(TAG, "playRipple: screenWidth=" + ((ScreenSize) ZeusTransformUtils.preCheckCast(r8.element, ScreenSize.class, "com.obric.memorydata.plugin")).getWidth() + ", screenHeight=" + ((ScreenSize) ZeusTransformUtils.preCheckCast(r8.element, ScreenSize.class, "com.obric.memorydata.plugin")).getHeight() + ", globalEffectStopLayerEffective=" + getGlobalEffectStopLayerEffective() + ", skipWindowLayer=" + r25 + ", windowLayerName=" + r26);
        final float r13 = DisplayUnitsKt.getDp(r24.getAmplitudeDp());
        final float r14 = DisplayUnitsKt.getDp(r24.getPulseWidthDp());
        final float r15 = DisplayUnitsKt.getDp(r24.getEdgeGlowRadiusDp());
        TransactionSmt.getInstance().setAnimationProperty(r11, buildStaticProperties(r24.getDurationMs(), r25, r26));
        TransactionSmt.getInstance().setAnimationProperty(r11, buildFrameProperties(r24, (ScreenSize) ZeusTransformUtils.preCheckCast(r8.element, ScreenSize.class, "com.obric.memorydata.plugin"), 0.0f, r13, r14, r15));
        TransactionSmt.getInstance().startAnimation(r11);
        this.animationManager = c.a.a(new c.a().a(1.0f), 0.0f, 1.0f, (a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a((int) r24.getDurationMs(), 0, DEFAULT_EASING), a.class, "com.obric.memorydata.plugin"), null, 8, null).a(new $$Lambda$RippleEffect$XNKiTxcq62wccPKwynGiXCpOn0M(r12, this, r8, r11, r24, r13, r14, r15)).a(new $$Lambda$RippleEffect$rEW3VqUziWCVJuZw6LL9bZY_7X4(r10, r12, this, r11)).a().a();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.os_specific.RippleEffect$ScreenSize, java.lang.Object] */
    private static final Unit playRipple$lambda$4(int r12, RippleEffect r13, Ref.ObjectRef r14, IBinder r15, RippleSpec r16, float r17, float r18, float r19, String r20, Object r21, Object r22) {
        IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r15, IBinder.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "<unused var>");
        Intrinsics.checkNotNullParameter(r21, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r22, "<unused var>");
        if (r12 != r13.playGeneration) goto L5;
        float r8 = RangesKt.coerceIn(((Float) ZeusTransformUtils.preCheckCast(r21, Float.class, "com.obric.memorydata.plugin")).floatValue(), 0.0f, 1.0f);
        ?? r1 = r13.getRealScreenSize();
        if (Intrinsics.areEqual(r1, r14.element) == true) goto L9;
        r14.element = r1;
        com.obric.aiagent.platform.a.d.f5954a.b(TAG, "playRipple: screenSize changed, screenWidth=" + ((ScreenSize) ZeusTransformUtils.preCheckCast(r14.element, ScreenSize.class, "com.obric.memorydata.plugin")).getWidth() + ", screenHeight=" + ((ScreenSize) ZeusTransformUtils.preCheckCast(r14.element, ScreenSize.class, "com.obric.memorydata.plugin")).getHeight());
    L9:
        TransactionSmt.getInstance().setAnimationProperty(r2, r13.buildFrameProperties(r16, (ScreenSize) ZeusTransformUtils.preCheckCast(r14.element, ScreenSize.class, "com.obric.memorydata.plugin"), r8, r17, r18, r19));
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit playRipple$lambda$5(Runnable r0, int r1, RippleEffect r2, IBinder r3, boolean r4, Throwable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r0, Runnable.class, "com.obric.memorydata.plugin");
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L6;
        r6.run();
    L6:
        if (r1 != r2.playGeneration) goto L8;
        r2.cleanupAnimation(r7, r1);
        return Unit.INSTANCE;
    L8:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void playWakeUpEffect$default(RippleEffect r1, boolean r2, String r3, Runnable r4, int r5, Object r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "obric-assistant-window";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r7 = null;
    L11:
        r1.playWakeUpEffect(r2, r3, r7);
    }

    public final boolean initialize() {
        boolean r2 = true;
        if (this.displayToken == null) goto L26;
        return true;
    L26:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        Object r4 = Result.m1421constructorimpl(DisplayManagerSmt.getInstance().getDisplayToken(((RippleEffect) ZeusTransformUtils.preCheckCast(this, RippleEffect.class, "com.obric.memorydata.plugin")).context, 0));     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L14;
        com.obric.aiagent.platform.a.d.f5954a.a(TAG, "Failed to get display token", r5);
    L14:
        if (Result.m1428isSuccessimpl(r4) == false) goto L20;
        Result.Companion r6 = Result.Companion;
        IBinder r7 = (IBinder) ZeusTransformUtils.preCheckCast(r4, IBinder.class, "com.obric.memorydata.plugin");
        this.displayToken = r7;
        if (r7 != null) goto L19;
        r2 = false;
    L19:
        Object r8 = Result.m1421constructorimpl(Boolean.valueOf(r2));
    L22:
        if (Result.m1427isFailureimpl(r8) == false) goto L25;
        r8 = false;
    L25:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L20:
        r8 = Result.m1421constructorimpl(r4);
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final boolean isPlaying() {
        if (this.animationManager == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void playCaptureEffect(boolean r3, String r4, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "windowLayerName");
        playRipple(CAPTURE_SPEC, r3, r4, r6);
    }

    public final void playWakeUpEffect(boolean r3, String r4, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "windowLayerName");
        playRipple(WAKE_UP_SPEC, r3, r4, r6);
    }

    public final void stop() {
        d r0 = this.animationManager;
        this.animationManager = null;
        this.playGeneration++;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        IBinder r2 = this.displayToken;
        if (r2 == null) goto L9;
        TransactionSmt.getInstance().stopAnimation(r2);
        return;
    }
}
