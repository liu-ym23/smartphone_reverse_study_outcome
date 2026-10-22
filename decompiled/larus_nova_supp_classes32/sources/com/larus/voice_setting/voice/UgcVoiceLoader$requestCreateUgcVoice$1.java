package com.larus.voice_setting.voice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader", f = "UgcVoiceLoader.kt", i = {0, 0, 0}, l = {527}, m = "requestCreateUgcVoice", n = {"localVoiceId", "enterMethod", "isFromVoiceCloneScheme"}, s = {"L$0", "L$1", "Z$0"})
public final class UgcVoiceLoader$requestCreateUgcVoice$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcVoiceLoader this$0;

    public UgcVoiceLoader$requestCreateUgcVoice$1(UgcVoiceLoader r1, Continuation<? super UgcVoiceLoader$requestCreateUgcVoice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        UgcVoiceLoader r0 = this.this$0;
        UgcVoiceLoader r13 = UgcVoiceLoader.a;
        return r0.m(null, null, null, null, null, false, null, null, false, this);
    }
}
