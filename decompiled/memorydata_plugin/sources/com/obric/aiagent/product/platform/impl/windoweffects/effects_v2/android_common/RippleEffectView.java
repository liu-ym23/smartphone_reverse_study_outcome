package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.platform.PlatformConst;
import com.loc.o;
import com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.os_specific.util.units.DisplayUnitsKt;
import com.obric.common.oea.foundation.animation.builder.c;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.spec.a;
import com.obric.common.oea.foundation.animation.spec.b;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 :2\u00020\u0001:\u0003:;<B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0014\u0010#\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020\u0014J\b\u0010&\u001a\u00020 H\u0014J(\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0014J\u001a\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u00101\u001a\u00020 2\u0006\u00100\u001a\u00020\u0012H\u0002J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001d\u0010\u001e¨\u0006="}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rippleShader", "Landroid/graphics/RuntimeShader;", "shaderPaint", "Landroid/graphics/Paint;", "animationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "playGeneration", "activeSpec", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$RippleSpec;", "shouldRender", "", "originX", "", "originY", "travelDistance", "pulseWidth", "viewIntensity", EventBody.KEY_VALUE, "progress", "setProgress", "(F)V", "playWakeUpEffect", "", "onEnd", "Ljava/lang/Runnable;", "playCaptureEffect", "stop", "isPlaying", "onDetachedFromWindow", "onSizeChanged", "w", o.g, "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "playRipple", "spec", "updateGeometry", "compensateClippedOrigin", "rawOriginY", "resolutionY", "cancelRunningAnimation", "nextGeneration", "cleanupAnimation", PendingPersonalInfoNotificationTask.KEY_GENERATION, "hideWhenIdle", "Companion", "RippleSpec", "DeviceProfile", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleEffectView extends View {
    private static final RippleSpec CAPTURE_SPEC = null;
    public static final Companion Companion = null;
    private static final Token.Easing DEFAULT_EASING = null;
    private static final List<DeviceProfile> DISABLED_DEVICE_PROFILES = null;
    private static final float MIN_VIEW_INTENSITY = 0.9f;
    private static final String RIPPLE_COLOR_SHADER_AGSL = "\n            uniform vec2 uResolution;\n            uniform vec2 uOrigin;\n            uniform float uProgress;\n            uniform float uTravelDistance;\n            uniform float uPulseWidth;\n            uniform float uWaveGlowIntensity;\n            uniform float uTrailDecayLength;\n\n            const vec3 RIPPLE_BLUE = vec3(0.051, 0.447, 1.0);\n            const vec3 RIPPLE_CYAN = vec3(0.608, 0.863, 1.0);\n            const float FREQUENCY = 4.0;\n            const float TRAIL_DISPLACEMENT = 0.32;\n            const float CREST_ALPHA = 0.44;\n            const float SHOULDER_ALPHA = 0.16;\n            const float HALO_ALPHA = 0.09;\n            const float RIPPLE_LINE_ALPHA = 0.18;\n            const float TRAIL_ALPHA = 0.12;\n            const float WASH_ALPHA = 0.04;\n            const float DISPLACEMENT_ALPHA = 0.08;\n\n            // 锚定谐波：扣掉 t=0 的初始值，避免开场跳变。\n            float harmonic(float t, float ratio, float phase, float weight) {\n                return (sin(t * ratio + phase) - sin(phase)) * weight;\n            }\n\n            vec4 main(vec2 fragCoord) {\n                vec2 position = fragCoord;\n                vec2 delta = position - uOrigin;\n                float dist = length(delta);\n\n                // 波形包络：前沿高斯环 + 已经过区域的指数拖尾。\n                float waveFront = uProgress * uTravelDistance;\n                float ringOffset = (dist - waveFront) / uPulseWidth;\n                float crest = exp(-ringOffset * ringOffset * 5.5);\n                float shoulder = exp(-ringOffset * ringOffset * 1.25);\n                float haloOffset = (dist - waveFront) / (uPulseWidth * 1.8);\n                float halo = exp(-haloOffset * haloOffset);\n                float frontActivation = smoothstep(0.0, uPulseWidth * 0.9, waveFront);\n                float passedFront = smoothstep(-uPulseWidth * 0.5, uPulseWidth * 1.5, waveFront - dist);\n                float trailDecayDistance = uPulseWidth * max(uTrailDecayLength, 0.001);\n                float trail = passedFront * exp(-max(waveFront - dist, 0.0) / trailDecayDistance);\n                float behindFront = max(waveFront - dist, 0.0) / max(uPulseWidth, 1.0);\n                float washDecayDistance = uPulseWidth * max(uTrailDecayLength * 1.7, 0.001);\n                float wash = passedFront * exp(-max(waveFront - dist, 0.0) / washDecayDistance);\n\n                // 按半径延迟波相位，让波纹从 origin 向外传播。\n                float waveTime = max(0.0, uProgress - dist / max(uTravelDistance, 1.0));\n                float w = waveTime * FREQUENCY;\n                float totalWave = sin(w)\n                                + harmonic(w, 0.82, -1.45, 0.52)\n                                + harmonic(w, 1.27,  0.72, 0.28);\n                float rippleLineWave = pow(0.5 + 0.5 * sin(behindFront * 13.0 + totalWave * 0.65), 3.0);\n                float rippleLines = trail * rippleLineWave * exp(-behindFront / max(uTrailDecayLength * 1.2, 0.001));\n\n                float displacementMask = max(shoulder, trail * TRAIL_DISPLACEMENT) * frontActivation;\n                float crestShape = clamp(crest * frontActivation, 0.0, 1.0);\n                float shoulderShape = clamp(shoulder * frontActivation, 0.0, 1.0);\n                float haloShape = clamp(halo * frontActivation, 0.0, 1.0);\n                float trailShape = clamp(trail * frontActivation, 0.0, 1.0);\n                float rippleLineShape = clamp(rippleLines * frontActivation, 0.0, 1.0);\n                float washShape = clamp(\n                    wash\n                        * frontActivation\n                        * smoothstep(0.02, 0.18, uProgress)\n                        * (1.0 - smoothstep(0.78, 1.0, uProgress)),\n                    0.0,\n                    1.0);\n\n                // 颜色层：使用豆包光晕主蓝色。清晰 crest + 细纹拖尾负责涟漪感，\n                // 低 alpha halo / wash 只补偿 View 没有 ±depth 形变时的视觉裁薄。\n                float waveBoost = smoothstep(-0.2, 1.0, totalWave);\n                vec3 waveColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.28 + 0.38 * waveBoost);\n                vec3 haloColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.18);\n                float waveAlpha = (\n                    crestShape * CREST_ALPHA\n                    + shoulderShape * SHOULDER_ALPHA\n                    + haloShape * HALO_ALPHA\n                    + rippleLineShape * RIPPLE_LINE_ALPHA\n                    + trailShape * TRAIL_ALPHA\n                    + washShape * WASH_ALPHA\n                    + displacementMask * DISPLACEMENT_ALPHA\n                ) * uWaveGlowIntensity;\n                float alpha = clamp(waveAlpha, 0.0, 0.54);\n\n                vec3 color = mix(\n                    haloColor,\n                    waveColor,\n                    clamp(crestShape + rippleLineShape * 0.75 + shoulderShape * 0.35, 0.0, 1.0));\n                return vec4(color * alpha, alpha);\n            }\n        ";
    private static final float VIEW_INTENSITY_MULTIPLIER = 1.65f;
    private static final float VIEW_ORIGIN_OVERFLOW_MULTIPLIER = 0.95f;
    private static final float VIEW_PULSE_WIDTH_MULTIPLIER = 1.65f;
    private static final RippleSpec WAKE_UP_SPEC = null;
    private RippleSpec activeSpec;
    private d animationManager;
    private float originX;
    private float originY;
    private int playGeneration;
    private float progress;
    private float pulseWidth;
    private final RuntimeShader rippleShader;
    private final Paint shaderPaint;
    private final boolean shouldRender;
    private float travelDistance;
    private float viewIntensity;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$Companion;", "", "<init>", "()V", "WAKE_UP_SPEC", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$RippleSpec;", "CAPTURE_SPEC", "DEFAULT_EASING", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "VIEW_PULSE_WIDTH_MULTIPLIER", "", "VIEW_INTENSITY_MULTIPLIER", "MIN_VIEW_INTENSITY", "VIEW_ORIGIN_OVERFLOW_MULTIPLIER", "DISABLED_DEVICE_PROFILES", "", "Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$DeviceProfile;", "isEnabledOnCurrentDevice", "", "RIPPLE_COLOR_SHADER_AGSL", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean isEnabledOnCurrentDevice() {
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RippleEffectView.access$getDISABLED_DEVICE_PROFILES$cp(), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
        L7:
            Iterator r5 = r4.iterator();
        L9:
            if (r5.hasNext() == false) goto L18;
            if (((DeviceProfile) ZeusTransformUtils.preCheckCast(r5.next(), DeviceProfile.class, "com.obric.memorydata.plugin")).matchesCurrentDevice() == false) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$DeviceProfile;", "", "manufacturer", "", PlatformConst.BUNDLE_KEY_BRAND, "model", "device", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getManufacturer", "()Ljava/lang/String;", "getBrand", "getModel", "getDevice", "matchesCurrentDevice", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class DeviceProfile {
        private final String brand;
        private final String device;
        private final String manufacturer;
        private final String model;

        public DeviceProfile(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "manufacturer");
            Intrinsics.checkNotNullParameter(r3, PlatformConst.BUNDLE_KEY_BRAND);
            Intrinsics.checkNotNullParameter(r4, "model");
            Intrinsics.checkNotNullParameter(r5, "device");
            this.manufacturer = r2;
            this.brand = r3;
            this.model = r4;
            this.device = r5;
        }

        public static /* synthetic */ DeviceProfile copy$default(DeviceProfile r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.manufacturer;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.brand;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.model;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.device;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.manufacturer;
        }

        public final String component2() {
            return this.brand;
        }

        public final String component3() {
            return this.model;
        }

        public final String component4() {
            return this.device;
        }

        public final DeviceProfile copy(String r1, String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r1, "manufacturer");
            Intrinsics.checkNotNullParameter(r2, PlatformConst.BUNDLE_KEY_BRAND);
            Intrinsics.checkNotNullParameter(r3, "model");
            Intrinsics.checkNotNullParameter(r4, "device");
            return new DeviceProfile(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, DeviceProfile.class) == true) goto L8;
            return false;
        L8:
            DeviceProfile r6 = (DeviceProfile) ZeusTransformUtils.preCheckCast(r5, DeviceProfile.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.manufacturer, r6.manufacturer) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.brand, r6.brand) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.model, r6.model) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.device, r6.device) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final String getDevice() {
            return this.device;
        }

        public final String getManufacturer() {
            return this.manufacturer;
        }

        public final String getModel() {
            return this.model;
        }

        public int hashCode() {
            return (((((this.manufacturer.hashCode() * 31) + this.brand.hashCode()) * 31) + this.model.hashCode()) * 31) + this.device.hashCode();
        }

        public final boolean matchesCurrentDevice() {
            String r0 = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(r0, "MANUFACTURER");
            if (Intrinsics.areEqual(RippleEffectViewKt.access$normalizedDeviceValue(r0), this.manufacturer) == false) goto L11;
            String r1 = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(r1, "BRAND");
            if (Intrinsics.areEqual(RippleEffectViewKt.access$normalizedDeviceValue(r1), this.brand) == false) goto L11;
            String r2 = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(r2, "MODEL");
            if (Intrinsics.areEqual(RippleEffectViewKt.access$normalizedDeviceValue(r2), this.model) == false) goto L11;
            String r3 = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(r3, "DEVICE");
            if (Intrinsics.areEqual(RippleEffectViewKt.access$normalizedDeviceValue(r3), this.device) == false) goto L11;
            return true;
        L11:
            return false;
        }

        public String toString() {
            return "DeviceProfile(manufacturer=" + this.manufacturer + ", brand=" + this.brand + ", model=" + this.model + ", device=" + this.device + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00067"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects_v2/android_common/RippleEffectView$RippleSpec;", "", "originFractionX", "", "originFractionY", "amplitudeDp", "amplitudeRamp", "pulseWidthDp", "travelDistanceMultiplier", "durationMs", "", "screenDimIntensity", "waveGlowIntensity", "trailDecayLength", "edgeGlowRadiusDp", "edgeGlowColorIntensity", "edgeGlowIntensity", "<init>", "(FFFFFFJFFFFFF)V", "getOriginFractionX", "()F", "getOriginFractionY", "getAmplitudeDp", "getAmplitudeRamp", "getPulseWidthDp", "getTravelDistanceMultiplier", "getDurationMs", "()J", "getScreenDimIntensity", "getWaveGlowIntensity", "getTrailDecayLength", "getEdgeGlowRadiusDp", "getEdgeGlowColorIntensity", "getEdgeGlowIntensity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    static {
        Companion = new Companion(null);
        WAKE_UP_SPEC = new RippleSpec(0.5f, 1.2f, 70.0f, 0.5f, 70.0f, 2.2f, 1500, 0.0f, 1.0f, 2.0f, 1.0f, 1.0f, 0.0f);
        CAPTURE_SPEC = new RippleSpec(0.5f, 0.5f, 10.0f, 0.2f, 70.0f, 1.0f, 1500, 0.16f, 0.3f, 1.5f, 1.0f, 0.5f, 1.0f);
        DEFAULT_EASING = Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD;
        DISABLED_DEVICE_PROFILES = CollectionsKt.listOf(new DeviceProfile("shenqijiyuan", "nubia", "p0210", "nerida"));
    }

    public RippleEffectView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public RippleEffectView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public RippleEffectView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        RuntimeShader r8 = new RuntimeShader(RIPPLE_COLOR_SHADER_AGSL);
        this.rippleShader = r8;
        Paint r9 = new Paint(1);
        r9.setShader((Shader) ZeusTransformUtils.preCheckCast(r8, Shader.class, "com.obric.memorydata.plugin"));
        this.shaderPaint = r9;
        this.activeSpec = WAKE_UP_SPEC;
        this.shouldRender = Companion.isEnabledOnCurrentDevice();
        this.viewIntensity = 1.0f;
        hideWhenIdle();
        setLayerType(2, null);
    }

    public /* synthetic */ RippleEffectView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ List access$getDISABLED_DEVICE_PROFILES$cp() {
        return DISABLED_DEVICE_PROFILES;
    }

    private final void cancelRunningAnimation() {
        d r0 = this.animationManager;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        this.animationManager = null;
    }

    private final void cleanupAnimation(int r2) {
        if (r2 == this.playGeneration) goto L5;
        return;
    L5:
        this.animationManager = null;
        setProgress(0.0f);
        hideWhenIdle();
    }

    private final float compensateClippedOrigin(float r2, float r3) {
        float r1 = this.pulseWidth * VIEW_ORIGIN_OVERFLOW_MULTIPLIER;
        if (r2 <= r3) goto L6;
        return r3 + RangesKt.coerceAtMost(r2 - r3, r1);
    L6:
        if (r2 < 0.0f) goto L8;
        return r2;
    L8:
        return -RangesKt.coerceAtMost(0.0f - r2, r1);
    }

    private final void hideWhenIdle() {
        if (this.shouldRender == false) goto L5;
        int r0 = 4;
    L6:
        setVisibility(r0);
        return;
    L5:
        r0 = 8;
        goto L6
    }

    public static /* synthetic */ Unit lambda$A2Mbe9Yb5IbOEH7RoiniMAQUIz0(int r0, RippleEffectView r1, String r2, Object r3, Object r4) {
        return playRipple$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$CDMKqcbtM_e7jgyR6joTau84rkc(Runnable r0, int r1, RippleEffectView r2, boolean r3, Throwable r4) {
        return playRipple$lambda$2(r0, r1, r2, r3, r4);
    }

    private final int nextGeneration() {
        int r0 = this.playGeneration + 1;
        this.playGeneration = r0;
        return r0;
    }

    public static /* synthetic */ void playCaptureEffect$default(RippleEffectView r1, Runnable r2, int r3, Object r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.playCaptureEffect(r5);
    }

    private final void playRipple(RippleSpec r13, Runnable r14) {
        final Runnable r15 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r14, Runnable.class, "com.obric.memorydata.plugin");
        if (this.shouldRender == true) goto L7;
        if (r15 == null) goto L9;
        r15.run();
        return;
    L9:
        return;
    L7:
        final int r0 = nextGeneration();
        cancelRunningAnimation();
        this.activeSpec = r13;
        updateGeometry(r13);
        setProgress(0.0f);
        setVisibility(0);
        this.animationManager = c.a.a(new c.a().a(1.0f), 0.0f, 1.0f, (a) ZeusTransformUtils.preCheckCast(b.a((int) r13.getDurationMs(), 0, DEFAULT_EASING), a.class, "com.obric.memorydata.plugin"), null, 8, null).a(new $$Lambda$RippleEffectView$A2Mbe9Yb5IbOEH7RoiniMAQUIz0(r0, this)).a(new $$Lambda$RippleEffectView$CDMKqcbtM_e7jgyR6joTau84rkc(r15, r0, this)).a().a();
    }

    private static final Unit playRipple$lambda$1(int r1, RippleEffectView r2, String r3, Object r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        if (r1 != r2.playGeneration) goto L5;
        r2.setProgress(RangesKt.coerceIn(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue(), 0.0f, 1.0f));
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit playRipple$lambda$2(Runnable r0, int r1, RippleEffectView r2, boolean r3, Throwable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r0, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        r5.run();
    L6:
        if (r1 != r2.playGeneration) goto L8;
        r2.cleanupAnimation(r1);
        return Unit.INSTANCE;
    L8:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void playWakeUpEffect$default(RippleEffectView r1, Runnable r2, int r3, Object r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.playWakeUpEffect(r5);
    }

    private final void setProgress(float r3) {
        float r4 = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        if (this.progress != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.progress = r4;
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void updateGeometry(RippleSpec r7) {
        float r0 = getWidth();
        float r1 = getHeight();
        this.pulseWidth = DisplayUnitsKt.getDp(r7.getPulseWidthDp()) * 1.65f;
        this.originX = r7.getOriginFractionX() * r0;
        this.originY = compensateClippedOrigin(r7.getOriginFractionY() * r1, r1);
        this.travelDistance = ((float) Math.hypot(r0, r1)) * r7.getTravelDistanceMultiplier();
        this.viewIntensity = RangesKt.coerceAtLeast(r7.getWaveGlowIntensity() * 1.65f, MIN_VIEW_INTENSITY);
    }

    public final boolean isPlaying() {
        if (this.animationManager == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L13;
        this.rippleShader.setFloatUniform("uResolution", getWidth(), getHeight());
        this.rippleShader.setFloatUniform("uOrigin", this.originX, this.originY);
        this.rippleShader.setFloatUniform("uProgress", this.progress);
        this.rippleShader.setFloatUniform("uTravelDistance", this.travelDistance);
        this.rippleShader.setFloatUniform("uPulseWidth", this.pulseWidth);
        this.rippleShader.setFloatUniform("uWaveGlowIntensity", this.viewIntensity);
        this.rippleShader.setFloatUniform("uTrailDecayLength", this.activeSpec.getTrailDecayLength());
        r5.drawPaint(this.shaderPaint);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.animationManager == null) goto L6;
        updateGeometry(this.activeSpec);
        return;
    }

    public final void playCaptureEffect() {
        playCaptureEffect$default(this, null, 1, null);
    }

    public final void playCaptureEffect(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        playRipple(CAPTURE_SPEC, r4);
    }

    public final void playWakeUpEffect() {
        playWakeUpEffect$default(this, null, 1, null);
    }

    public final void playWakeUpEffect(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        playRipple(WAKE_UP_SPEC, r4);
    }

    public final void stop() {
        d r0 = this.animationManager;
        this.animationManager = null;
        this.playGeneration++;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        setProgress(0.0f);
        hideWhenIdle();
    }
}
