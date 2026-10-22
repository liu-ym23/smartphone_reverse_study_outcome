package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0, 0, 0}, l = {1372, 1432, 1452}, m = "observeVideoResourceAccessTask", n = {"bean", "resourceKey", "currentLocalPath", "preprocessMetadataApplied"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1(MultiAttachmentSelectorComponent r1, Continuation<? super MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MultiAttachmentSelectorComponent.h3(this.this$0, null, null, null, this);
    }
}
