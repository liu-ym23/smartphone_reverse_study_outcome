package com.obric.audio.tts;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.tts.ObricTtsClient", f = "ObricTtsClient.kt", i = {0, 1, 1, 1}, l = {310, 340}, m = "resolveMainBotVoice", n = {"requestId", "mainBotId", "mainBotIdSource", "requestId"}, s = {"J$0", "L$0", "L$1", "J$0"})
final class ObricTtsClient$resolveMainBotVoice$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public ObricTtsClient$resolveMainBotVoice$1(f r1, Continuation<? super ObricTtsClient$resolveMainBotVoice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return f.b(this.this$0, 0, this);
    }
}
