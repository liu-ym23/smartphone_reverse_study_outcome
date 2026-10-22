package com.larus.uaigc.createpage.processor;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor", f = "CreatePageSendMessageProcessor.kt", i = {1, 2, 5, 5, 6}, l = {718, 725, 730, 732, 736, 739, 745}, m = "ensureConversationRemoteBeforeSend", n = {"targetConversationId", "targetConversationId", "targetConversationId", "localConversation", "targetConversationId"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0"})
public final class CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreatePageSendMessageProcessor this$0;

    public CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1(CreatePageSendMessageProcessor r1, Continuation<? super CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreatePageSendMessageProcessor r3 = this.this$0;
        Set<String> r0 = CreatePageSendMessageProcessor.h;
        return r3.j(this);
    }
}
