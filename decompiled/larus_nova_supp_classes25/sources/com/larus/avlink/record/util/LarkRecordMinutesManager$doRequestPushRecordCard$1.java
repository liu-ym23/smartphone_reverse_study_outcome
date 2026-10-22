package com.larus.avlink.record.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager", f = "LarkRecordMinutesManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {1806}, m = "doRequestPushRecordCard", n = {"ctx", "requestId", "startType", "productId", "recordingId", "requestStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
final class LarkRecordMinutesManager$doRequestPushRecordCard$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkRecordMinutesManager this$0;

    public LarkRecordMinutesManager$doRequestPushRecordCard$1(LarkRecordMinutesManager r1, Continuation<? super LarkRecordMinutesManager$doRequestPushRecordCard$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return LarkRecordMinutesManager.a(this.this$0, null, this);
    }
}
