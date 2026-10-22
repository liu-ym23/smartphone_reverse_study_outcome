package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0}, l = {2539}, m = "observeImageResourceAccessTask", n = {"onFailed", "onSuccess"}, s = {"L$0", "L$1"})
public final class MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1(MultiAttachmentSelectorComponent r1, Continuation<? super MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        MultiAttachmentSelectorComponent r0 = this.this$0;
        int r10 = MultiAttachmentSelectorComponent.Z;
        return r0.W4(null, null, null, null, null, null, this);
    }
}
