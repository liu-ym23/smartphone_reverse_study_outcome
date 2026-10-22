package com.larus.voice_setting.voice;

import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader", f = "UgcVoiceLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2}, l = {407, 455, 457}, m = "requestCheckUgcVoice", n = {LynxResourceModule.URI_KEY, "freeTalkContent", "languageCode", "localVoiceId", "voiceName", "iconItem", "previousPage", "enterMethod", "replaceVoice", "isFromVoiceCloneScheme", "previousPage", "previousPage"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "Z$1", "L$0", "L$0"})
final class UgcVoiceLoader$requestCheckUgcVoice$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcVoiceLoader this$0;

    public UgcVoiceLoader$requestCheckUgcVoice$1(UgcVoiceLoader r1, Continuation<? super UgcVoiceLoader$requestCheckUgcVoice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        return UgcVoiceLoader.e(this.this$0, null, null, null, null, null, null, false, null, null, false, this);
    }
}
