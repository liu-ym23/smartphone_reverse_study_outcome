package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent", f = "AttachmentPanelComponent.kt", i = {0}, l = {791}, m = "deleteResourceByResourceId", n = {"resourceIds"}, s = {"L$0"})
public final class AttachmentPanelComponent$deleteResourceByResourceId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$deleteResourceByResourceId$1(AttachmentPanelComponent r1, Continuation<? super AttachmentPanelComponent$deleteResourceByResourceId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AttachmentPanelComponent r3 = this.this$0;
        int r0 = AttachmentPanelComponent.g2;
        return r3.Z3(null, this);
    }
}
