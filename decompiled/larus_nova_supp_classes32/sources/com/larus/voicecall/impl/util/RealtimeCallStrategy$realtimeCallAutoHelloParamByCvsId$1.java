package com.larus.voicecall.impl.util;

import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.util.RealtimeCallStrategy", f = "RealtimeCallStrategy.kt", i = {0, 1}, l = {MessageContentType.CARD, MessageContentType.BOT_MAKER}, m = "realtimeCallAutoHelloParamByCvsId", n = {"cvsId", "cvs"}, s = {"L$0", "L$0"})
public final class RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallStrategy this$0;

    public RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1(RealtimeCallStrategy r1, Continuation<? super RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
