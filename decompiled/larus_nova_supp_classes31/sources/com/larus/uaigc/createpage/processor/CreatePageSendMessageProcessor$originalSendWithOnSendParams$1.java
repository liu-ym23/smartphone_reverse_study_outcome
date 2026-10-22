package com.larus.uaigc.createpage.processor;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor", f = "CreatePageSendMessageProcessor.kt", i = {}, l = {307, 313}, m = "originalSendWithOnSendParams", n = {}, s = {})
public final class CreatePageSendMessageProcessor$originalSendWithOnSendParams$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreatePageSendMessageProcessor this$0;

    public CreatePageSendMessageProcessor$originalSendWithOnSendParams$1(CreatePageSendMessageProcessor r1, Continuation<? super CreatePageSendMessageProcessor$originalSendWithOnSendParams$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreatePageSendMessageProcessor r3 = this.this$0;
        Set<String> r0 = CreatePageSendMessageProcessor.h;
        return r3.m(null, null, this);
    }
}
