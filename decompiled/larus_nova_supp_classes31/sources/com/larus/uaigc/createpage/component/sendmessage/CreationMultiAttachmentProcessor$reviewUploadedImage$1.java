package com.larus.uaigc.createpage.component.sendmessage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor", f = "CreationMultiAttachmentProcessor.kt", i = {1, 1}, l = {815, 822, 835}, m = "reviewUploadedImage", n = {"entity", "localNestedFileMessageId"}, s = {"L$0", "L$1"})
final class CreationMultiAttachmentProcessor$reviewUploadedImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$reviewUploadedImage$1(CreationMultiAttachmentProcessor r1, Continuation<? super CreationMultiAttachmentProcessor$reviewUploadedImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return CreationMultiAttachmentProcessor.f(this.this$0, null, null, null, null, null, this);
    }
}
