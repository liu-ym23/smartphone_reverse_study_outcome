package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel", f = "RecordMinutesModel.kt", i = {}, l = {405}, m = "fetchOfflineRecordings", n = {}, s = {})
final class RecordMinutesModel$fetchOfflineRecordings$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordMinutesModel this$0;

    public RecordMinutesModel$fetchOfflineRecordings$1(RecordMinutesModel r1, Continuation<? super RecordMinutesModel$fetchOfflineRecordings$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return RecordMinutesModel.d(this.this$0, this);
    }
}
