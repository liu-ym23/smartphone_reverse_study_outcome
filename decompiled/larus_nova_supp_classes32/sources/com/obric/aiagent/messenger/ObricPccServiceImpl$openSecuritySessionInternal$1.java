package com.obric.aiagent.messenger;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.ObricPccServiceImpl", f = "ObricPccServiceImpl.kt", i = {}, l = {SpeechEvent.SERVER_DOWNLINK_EVENT_TTS_SENTENCE_START}, m = "openSecuritySessionInternal", n = {}, s = {})
final class ObricPccServiceImpl$openSecuritySessionInternal$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricPccServiceImpl this$0;

    public ObricPccServiceImpl$openSecuritySessionInternal$1(ObricPccServiceImpl r1, Continuation<? super ObricPccServiceImpl$openSecuritySessionInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ObricPccServiceImpl.e(this.this$0, this);
    }
}
