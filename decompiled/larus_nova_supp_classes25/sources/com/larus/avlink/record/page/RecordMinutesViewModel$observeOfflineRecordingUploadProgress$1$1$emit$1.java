package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1", f = "RecordMinutesViewModel.kt", i = {0}, l = {227}, m = "emit", n = {"recordingId"}, s = {"L$0"})
public final class RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordMinutesViewModel.C01261.C00211<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1(RecordMinutesViewModel.C01261.C00211<? super T> r1, Continuation<? super RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
