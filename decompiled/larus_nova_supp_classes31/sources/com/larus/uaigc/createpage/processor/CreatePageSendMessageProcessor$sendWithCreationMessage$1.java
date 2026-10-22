package com.larus.uaigc.createpage.processor;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor", f = "CreatePageSendMessageProcessor.kt", i = {3, 3, 3, 3, 4, 4, 4, 4}, l = {88, 98, 110, 120, 128}, m = "sendWithCreationMessage", n = {"bundle", "sendParam", "creationSendTraceId", "isImagePreprocessed", "bundle", "sendParam", "sendConversation", "sendMessageConf"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3"})
public final class CreatePageSendMessageProcessor$sendWithCreationMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreatePageSendMessageProcessor this$0;

    public CreatePageSendMessageProcessor$sendWithCreationMessage$1(CreatePageSendMessageProcessor r1, Continuation<? super CreatePageSendMessageProcessor$sendWithCreationMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, false, null, this);
    }
}
