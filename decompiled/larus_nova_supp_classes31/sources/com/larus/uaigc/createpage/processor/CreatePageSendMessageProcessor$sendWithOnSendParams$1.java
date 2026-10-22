package com.larus.uaigc.createpage.processor;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor", f = "CreatePageSendMessageProcessor.kt", i = {2, 2, 3, 3}, l = {260, 269, 272, 284, 297}, m = "sendWithOnSendParams", n = {"onSendParams", "creationSendTraceId", "onSendParams", "creationSendTraceId"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class CreatePageSendMessageProcessor$sendWithOnSendParams$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreatePageSendMessageProcessor this$0;

    public CreatePageSendMessageProcessor$sendWithOnSendParams$1(CreatePageSendMessageProcessor r1, Continuation<? super CreatePageSendMessageProcessor$sendWithOnSendParams$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.x(null, null, this);
    }
}
