package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0, 0}, l = {1516}, m = "handleVideoResourceAccessFail", n = {"bean", "error", "localPath"}, s = {"L$0", "L$1", "L$2"})
public final class MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1(MultiAttachmentSelectorComponent r1, Continuation<? super MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MultiAttachmentSelectorComponent r3 = this.this$0;
        int r0 = MultiAttachmentSelectorComponent.Z;
        return r3.F4(null, null, null, this);
    }
}
