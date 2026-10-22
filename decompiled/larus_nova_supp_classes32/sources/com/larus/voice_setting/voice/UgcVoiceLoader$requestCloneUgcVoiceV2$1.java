package com.larus.voice_setting.voice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader", f = "UgcVoiceLoader.kt", i = {0}, l = {587}, m = "requestCloneUgcVoiceV2", n = {"localVoiceId"}, s = {"L$0"})
public final class UgcVoiceLoader$requestCloneUgcVoiceV2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcVoiceLoader this$0;

    public UgcVoiceLoader$requestCloneUgcVoiceV2$1(UgcVoiceLoader r1, Continuation<? super UgcVoiceLoader$requestCloneUgcVoiceV2$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        UgcVoiceLoader r3 = this.this$0;
        UgcVoiceLoader r0 = UgcVoiceLoader.a;
        return r3.l(null, null, null, this);
    }
}
