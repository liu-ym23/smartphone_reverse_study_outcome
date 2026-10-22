package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager", f = "ClarificationAttachmentManager.kt", i = {0, 0, 0, 0, 0}, l = {576}, m = "buildDriveEntity", n = {"attachment", "key", "token", "content", "entityType"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
final class ClarificationAttachmentManager$buildDriveEntity$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$buildDriveEntity$1(ClarificationAttachmentManager r1, Continuation<? super ClarificationAttachmentManager$buildDriveEntity$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ClarificationAttachmentManager.c(this.this$0, null, this);
    }
}
