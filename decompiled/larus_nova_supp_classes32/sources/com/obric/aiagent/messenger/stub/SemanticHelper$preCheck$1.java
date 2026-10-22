package com.obric.aiagent.messenger.stub;

import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.SemanticHelper", f = "SemanticHelper.kt", i = {0, 0}, l = {MessageContentType.BOT_MAKER}, m = "preCheck", n = {"message", "latestSendMessage"}, s = {"L$0", "L$1"})
public final class SemanticHelper$preCheck$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SemanticHelper this$0;

    public SemanticHelper$preCheck$1(SemanticHelper r1, Continuation<? super SemanticHelper$preCheck$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
