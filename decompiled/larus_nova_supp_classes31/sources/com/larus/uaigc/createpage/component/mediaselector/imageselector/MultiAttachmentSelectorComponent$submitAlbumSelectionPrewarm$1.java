package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0, 1}, l = {1794, 1803, 1809}, m = "submitAlbumSelectionPrewarm", n = {"identifier", "uri", "identifier"}, s = {"L$0", "L$1", "L$0"})
final class MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1(MultiAttachmentSelectorComponent r1, Continuation<? super MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MultiAttachmentSelectorComponent.z3(this.this$0, null, null, this);
    }
}
