package com.obric.assistant.audio;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.audio.ObricEnrollInteropServiceImpl", f = "ObricEnrollInteropServiceImpl.kt", i = {}, l = {SpeechEvent.SERVER_DOWNLINK_EVENT_ASR_INFO}, m = "refreshHelpImproveVoiceWakeupEnabled", n = {}, s = {})
public final class ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricEnrollInteropServiceImpl this$0;

    public ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1(ObricEnrollInteropServiceImpl r1, Continuation<? super ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q(this);
    }
}
