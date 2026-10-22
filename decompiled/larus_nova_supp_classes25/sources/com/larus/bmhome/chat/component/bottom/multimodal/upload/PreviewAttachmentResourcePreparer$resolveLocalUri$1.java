package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.PreviewAttachmentResourcePreparer", f = "PreviewAttachmentResourcePreparer.kt", i = {1, 1, 2}, l = {72, 124, 87, 93}, m = "resolveLocalUri", n = {"entity", "ref", "entity"}, s = {"L$0", "L$1", "L$0"})
public final class PreviewAttachmentResourcePreparer$resolveLocalUri$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewAttachmentResourcePreparer this$0;

    public PreviewAttachmentResourcePreparer$resolveLocalUri$1(PreviewAttachmentResourcePreparer r1, Continuation<? super PreviewAttachmentResourcePreparer$resolveLocalUri$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PreviewAttachmentResourcePreparer r3 = this.this$0;
        PreviewAttachmentResourcePreparer r0 = PreviewAttachmentResourcePreparer.a;
        return r3.d(null, this);
    }
}
