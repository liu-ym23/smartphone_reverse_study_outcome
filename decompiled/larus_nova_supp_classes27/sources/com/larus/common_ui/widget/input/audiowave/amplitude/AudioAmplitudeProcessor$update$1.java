package com.larus.common_ui.widget.input.audiowave.amplitude;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor", f = "AudioAmplitudeProcessor.kt", i = {}, l = {28}, m = "update", n = {}, s = {})
public final class AudioAmplitudeProcessor$update$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AudioAmplitudeProcessor this$0;

    public AudioAmplitudeProcessor$update$1(AudioAmplitudeProcessor r1, Continuation<? super AudioAmplitudeProcessor$update$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.update(null, this);
    }
}
