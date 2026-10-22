package com.larus.common_ui.blur;

import com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BlurCircleWithAmplitude$startWaveAnim$1 extends AdaptedFunctionReference implements Function0<Float> {
    public BlurCircleWithAmplitude$startWaveAnim$1(Object r8) {
        super(0, r8, AudioAmplitudeProcessor.class, "getMaxAmplitude", "getMaxAmplitude(Z)F", 0);
    }

    public final Float invoke() {
        return Float.valueOf(AudioAmplitudeProcessor.a((AudioAmplitudeProcessor) ((AdaptedFunctionReference) this).receiver));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2invoke() {
        return invoke();
    }
}
