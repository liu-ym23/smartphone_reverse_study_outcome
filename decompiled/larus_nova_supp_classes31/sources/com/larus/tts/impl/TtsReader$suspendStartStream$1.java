package com.larus.tts.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader", f = "TtsReader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {779, 337}, m = "suspendStartStream", n = {"msg", "ttsText", "voiceStyleInfo", "startReadMessageReason", "cacheConfig", "scope", "botId", "chatType", "traceInfo", "outerConversationId", "$this$withLock_u24default$iv", "showToast", "skipTtsChecked", "startTTSWithText", "isFromManual", "voiceStyleInfo", "startReadMessageReason", "traceInfo", "$this$withLock_u24default$iv", "msgId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "Z$1", "Z$2", "Z$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class TtsReader$suspendStartStream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TtsReader this$0;

    public TtsReader$suspendStartStream$1(TtsReader r1, Continuation<? super TtsReader$suspendStartStream$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r18) {
        this.result = r18;
        this.label |= Integer.MIN_VALUE;
        TtsReader r0 = this.this$0;
        int r16 = TtsReader.i;
        return r0.h(null, null, false, false, false, null, null, null, false, null, null, null, null, null, this);
    }
}
