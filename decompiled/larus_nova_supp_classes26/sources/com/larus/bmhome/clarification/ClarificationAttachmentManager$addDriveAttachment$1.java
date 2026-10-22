package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager", f = "ClarificationAttachmentManager.kt", i = {0, 0}, l = {428}, m = "addDriveAttachment", n = {"localMsgId", "pageIndex"}, s = {"L$0", "I$0"})
public final class ClarificationAttachmentManager$addDriveAttachment$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$addDriveAttachment$1(ClarificationAttachmentManager r1, Continuation<? super ClarificationAttachmentManager$addDriveAttachment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        ClarificationAttachmentManager r4 = this.this$0;
        int r0 = ClarificationAttachmentManager.k;
        return r4.g(0, null, null, this);
    }
}
