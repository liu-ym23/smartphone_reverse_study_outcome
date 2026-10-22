package com.larus.voice_setting.voice.editvoice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel", f = "SpeakerVoiceEditModel.kt", i = {}, l = {784}, m = "generatePreviewVoice", n = {}, s = {})
final class SpeakerVoiceEditModel$generatePreviewVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    public SpeakerVoiceEditModel$generatePreviewVoice$1(SpeakerVoiceEditModel r1, Continuation<? super SpeakerVoiceEditModel$generatePreviewVoice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SpeakerVoiceEditModel.a(this.this$0, null, this);
    }
}
