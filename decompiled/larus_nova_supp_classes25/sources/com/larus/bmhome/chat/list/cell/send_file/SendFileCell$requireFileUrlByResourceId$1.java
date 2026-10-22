package com.larus.bmhome.chat.list.cell.send_file;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.send_file.SendFileCell", f = "SendFileCell.kt", i = {0, 0}, l = {252}, m = "requireFileUrlByResourceId", n = {"file", "resourceId"}, s = {"L$0", "L$1"})
public final class SendFileCell$requireFileUrlByResourceId$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendFileCell this$0;

    public SendFileCell$requireFileUrlByResourceId$1(SendFileCell r1, Continuation<? super SendFileCell$requireFileUrlByResourceId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        SendFileCell r3 = this.this$0;
        int r0 = SendFileCell.i;
        return r3.r(null, this);
    }
}
