package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2416, 2423, 2432}, m = "submitImageResourceAccess", n = {"resourceKey", "perfParentScene", "onFailed", "onSuccess", "processCallback", "localResPath", "uploaderIdentifier", "localMessageId", "fileInfo", "imageSize", "onFailed", "onSuccess", "processCallback"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
public final class MultiAttachmentSelectorComponent$submitImageResourceAccess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$submitImageResourceAccess$1(MultiAttachmentSelectorComponent r1, Continuation<? super MultiAttachmentSelectorComponent$submitImageResourceAccess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        MultiAttachmentSelectorComponent r0 = this.this$0;
        int r15 = MultiAttachmentSelectorComponent.Z;
        return r0.I5(null, null, null, null, null, null, null, null, null, null, null, this);
    }
}
