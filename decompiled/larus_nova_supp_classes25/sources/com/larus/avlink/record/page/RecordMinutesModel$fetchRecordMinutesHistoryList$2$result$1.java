package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/avlink/record/page/RecordMinutesResult;", "Lcom/larus/avlink/record/page/RecordMinutesApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1", f = "RecordMinutesModel.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1 extends SuspendLambda implements Function2<RecordMinutesApi, Continuation<? super BizResponse<List<? extends l0>>>, Object> {
    final /* synthetic */ d $request;
    private /* synthetic */ Object L$0;
    int label;

    public RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1(d r1, Continuation<? super RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1 r0 = new RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1(this.$request, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(RecordMinutesApi r1, Continuation<? super BizResponse<List<l0>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((RecordMinutesApi) r1, (Continuation) r2);
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
        RecordMinutesApi r5 = (RecordMinutesApi) this.L$0;
        d r2 = this.$request;
        this.label = 1;
        r4 = r5.listRecording(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
