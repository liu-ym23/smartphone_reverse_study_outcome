package com.larus.voicecall.impl.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.util.RealtimeCallUtil", f = "RealtimeCallUtil.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {676, 681}, m = "updateConversationInfo", n = {"conversationId", "localCallId", "imAsrMsgNum", "imTtsMsgNum", "imTtsPreQueryMsgMap", "vuiAsrMsgIdSet", "vuiChatRespMsgIdSet", "callTracer", "vuiTtsRespMsgNum", "conversationId", "localCallId", "imAsrMsgNum", "imTtsMsgNum", "imTtsPreQueryMsgMap", "vuiAsrMsgIdSet", "vuiChatRespMsgIdSet", "callTracer", "vuiTtsRespMsgNum"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
final class RealtimeCallUtil$updateConversationInfo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallUtil this$0;

    public RealtimeCallUtil$updateConversationInfo$1(RealtimeCallUtil r1, Continuation<? super RealtimeCallUtil$updateConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        return RealtimeCallUtil.a(this.this$0, null, null, null, null, null, null, null, null, null, null, 0, this);
    }
}
