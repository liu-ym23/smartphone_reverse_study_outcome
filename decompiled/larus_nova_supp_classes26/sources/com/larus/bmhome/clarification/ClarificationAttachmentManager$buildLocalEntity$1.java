package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager", f = "ClarificationAttachmentManager.kt", i = {0, 0, 0, 0}, l = {489}, m = "buildLocalEntity", n = {"uri", "key", "isImage", "isAudio"}, s = {"L$0", "L$1", "Z$0", "Z$1"})
final class ClarificationAttachmentManager$buildLocalEntity$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$buildLocalEntity$1(ClarificationAttachmentManager r1, Continuation<? super ClarificationAttachmentManager$buildLocalEntity$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return ClarificationAttachmentManager.d(this.this$0, null, false, false, this);
    }
}
