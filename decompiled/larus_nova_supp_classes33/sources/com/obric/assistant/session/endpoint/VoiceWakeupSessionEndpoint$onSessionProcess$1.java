package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.endpoint.VoiceWakeupSessionEndpoint", f = "VoiceWakeupSessionEndpoint.kt", i = {0}, l = {107, 234}, m = "onSessionProcess", n = {"args"}, s = {"L$0"})
public final class VoiceWakeupSessionEndpoint$onSessionProcess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceWakeupSessionEndpoint this$0;

    public VoiceWakeupSessionEndpoint$onSessionProcess$1(VoiceWakeupSessionEndpoint r1, Continuation<? super VoiceWakeupSessionEndpoint$onSessionProcess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
