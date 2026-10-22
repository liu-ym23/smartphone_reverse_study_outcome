package com.larus.uaigc.createpage.utils;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor", f = "NestedFileSendMessageProcessor.kt", i = {0, 0, 0, 0, 0}, l = {181}, m = "checkSendMessage", n = {"params", "ext", "localNestedFileMessageId", "localTextMessageId", "originalLogic"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class UgcUploadingSendMessageProcessor$checkSendMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$checkSendMessage$1(UgcUploadingSendMessageProcessor r1, Continuation<? super UgcUploadingSendMessageProcessor$checkSendMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return UgcUploadingSendMessageProcessor.a(this.this$0, null, null, null, null, null, null, null, this);
    }
}
