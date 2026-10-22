package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager", f = "ClarificationAttachmentManager.kt", i = {0, 0, 0}, l = {603}, m = "buildDriveVideoExtension", n = {"attachment", "token", "fallbackCoverUrl$delegate"}, s = {"L$0", "L$1", "L$2"})
public final class ClarificationAttachmentManager$buildDriveVideoExtension$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$buildDriveVideoExtension$1(ClarificationAttachmentManager r1, Continuation<? super ClarificationAttachmentManager$buildDriveVideoExtension$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ClarificationAttachmentManager r3 = this.this$0;
        int r0 = ClarificationAttachmentManager.k;
        return r3.h(null, null, this);
    }
}
