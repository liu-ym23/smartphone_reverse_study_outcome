package com.larus.bmhome.chat.trace;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace", f = "ChatControlTrace.kt", i = {0, 0, 0, 0, 0}, l = {2544}, m = "onAnswerResult", n = {"msg", "errResult", "botId", "$this$onAnswerResult_u24lambda_u24152", "isSoftLink"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
public final class ChatControlTrace$onAnswerResult$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatControlTrace this$0;

    public ChatControlTrace$onAnswerResult$1(ChatControlTrace r1, Continuation<? super ChatControlTrace$onAnswerResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Vb(null, null, null, null, null, this);
    }
}
