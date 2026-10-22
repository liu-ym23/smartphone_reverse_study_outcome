package com.larus.uaigc.createpage.component.sendmessage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor", f = "CreationMultiAttachmentProcessor.kt", i = {0, 0, 0, 0}, l = {1203}, m = "checkAndSendWhenAllDone", n = {"config", "ext", "localNestedFileMessageId", "localTextMessageId"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$1(CreationMultiAttachmentProcessor r1, Continuation<? super CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return CreationMultiAttachmentProcessor.a(this.this$0, null, null, null, null, null, null, this);
    }
}
