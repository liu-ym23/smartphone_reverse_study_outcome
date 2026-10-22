package com.larus.uaigc.createpage.processor;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor", f = "CreatePageSendMessageProcessor.kt", i = {0, 0, 0, 0, 0, 1}, l = {174, 182}, m = "sendWithCreationMessageAndSetDoSameLandingResult", n = {"sendParam", "bundle", "creationSendTraceId", "isImagePreprocessed", "resultCode", "resultCode"}, s = {"L$0", "L$1", "L$2", "Z$0", "I$0", "I$0"})
public final class CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreatePageSendMessageProcessor this$0;

    public CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1(CreatePageSendMessageProcessor r1, Continuation<? super CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        CreatePageSendMessageProcessor r0 = this.this$0;
        Set<String> r9 = CreatePageSendMessageProcessor.h;
        return r0.w(null, null, false, 0, null, this);
    }
}
