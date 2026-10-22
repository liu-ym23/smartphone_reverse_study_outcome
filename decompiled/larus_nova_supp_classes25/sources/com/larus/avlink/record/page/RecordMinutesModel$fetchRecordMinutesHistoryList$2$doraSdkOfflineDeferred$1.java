package com.larus.avlink.record.page;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel$fetchRecordMinutesHistoryList$2$doraSdkOfflineDeferred$1", f = "RecordMinutesModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_12}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesModel$fetchRecordMinutesHistoryList$2$doraSdkOfflineDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends i0>>, Object> {
    int label;
    final /* synthetic */ RecordMinutesModel this$0;

    public RecordMinutesModel$fetchRecordMinutesHistoryList$2$doraSdkOfflineDeferred$1(RecordMinutesModel r1, Continuation<? super RecordMinutesModel$fetchRecordMinutesHistoryList$2$doraSdkOfflineDeferred$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RecordMinutesModel$fetchRecordMinutesHistoryList$2$doraSdkOfflineDeferred$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<i0>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        RecordMinutesModel r5 = this.this$0;
        this.label = 1;
        r4 = RecordMinutesModel.c(r5, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
