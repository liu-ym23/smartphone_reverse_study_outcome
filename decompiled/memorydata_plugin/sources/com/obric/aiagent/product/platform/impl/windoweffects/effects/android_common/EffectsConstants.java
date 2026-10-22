package com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/windoweffects/effects/android_common/EffectsConstants;", "", "<init>", "()V", "FADE_IN_DURATION", "", "FADE_OUT_DURATION", "SHIMMER_DURATION", "RIPPLE_EFFECT_DURATION", "MIN_ALPHA", "", "MAX_ALPHA", "RIPPLE_EFFECT_SHADER", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EffectsConstants {
    public static final long FADE_IN_DURATION = 300;
    public static final long FADE_OUT_DURATION = 100;
    public static final EffectsConstants INSTANCE = null;
    public static final float MAX_ALPHA = 1.0f;
    public static final float MIN_ALPHA = 0.0f;
    public static final long RIPPLE_EFFECT_DURATION = 882;
    public static final String RIPPLE_EFFECT_SHADER = "\n        uniform vec2 uResolution;\n        uniform float uDensity;\n        uniform float uProgress;\n        uniform shader uScreen;\n        \n        const vec2 EFFECT_ORIGIN = vec2(0.5, 1.0);\n        const float SHIMMER_RING_WIDTH_RATIO = 0.5;\n        const float SHIMMER_RING_SOFTNESS = 0.2;\n        const float SHIMMER_RING_OPACITY = 0.25;\n        const float BACKGROUND_DISTORTION_PIXELS = 24.0;\n        \n        float sdCircle(vec2 position, vec2 center, float radius) {\n            return length(position - center) - radius;\n        }\n        \n        float easeArc(float t) {\n            return 4.0 * t * (1.0 - t);\n        }\n        \n        float createStroke(float offset, float width, float edge, float sdf) {\n            float inner = smoothstep(offset - edge, offset + edge, sdf + width * 0.5);\n            float outer = smoothstep(offset - edge, offset + edge, sdf - width * 0.5);\n            return saturate(inner - outer);\n        }\n        \n        vec4 main(vec2 pixelCoord) {\n            vec2 effectOrigin = EFFECT_ORIGIN * uResolution;\n            float maxCircleRadius = length(uResolution);\n\n            float circleSDF = 1.0 - sdCircle(pixelCoord, effectOrigin, maxCircleRadius * uProgress);\n            float shimmerRing = createStroke(0.0, maxCircleRadius * SHIMMER_RING_WIDTH_RATIO, maxCircleRadius * SHIMMER_RING_SOFTNESS, circleSDF) * SHIMMER_RING_OPACITY;\n            shimmerRing *= easeArc(uProgress);\n            \n            float distortionPixels = BACKGROUND_DISTORTION_PIXELS * uDensity;\n            vec2 distortedScreenCoord = pixelCoord + shimmerRing * normalize(pixelCoord - effectOrigin) * distortionPixels;\n            vec4 distortedScreenColor = uScreen.eval(distortedScreenCoord);\n        \n            return vec4(distortedScreenColor.rgb, 1.0);\n        }\n    ";
    public static final long SHIMMER_DURATION = 882;

    static {
        INSTANCE = new EffectsConstants();
    }

    private EffectsConstants() {
    }
}
