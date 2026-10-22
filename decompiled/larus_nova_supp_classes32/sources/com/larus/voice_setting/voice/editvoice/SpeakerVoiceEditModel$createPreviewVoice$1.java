package com.larus.voice_setting.voice.editvoice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel", f = "SpeakerVoiceEditModel.kt", i = {0, 0, 0, 0}, l = {545}, m = "createPreviewVoice", n = {"list", "languageCode", "pitchF64", "rateF64"}, s = {"L$0", "L$1", "F$0", "F$1"})
public final class SpeakerVoiceEditModel$createPreviewVoice$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    public SpeakerVoiceEditModel$createPreviewVoice$1(SpeakerVoiceEditModel r1, Continuation<? super SpeakerVoiceEditModel$createPreviewVoice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        SpeakerVoiceEditModel r0 = this.this$0;
        int r8 = SpeakerVoiceEditModel.P;
        return r0.d(null, 0.0f, 0.0f, null, this);
    }
}
