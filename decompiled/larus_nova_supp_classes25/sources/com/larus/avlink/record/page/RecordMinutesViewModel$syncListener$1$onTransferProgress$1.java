package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$syncListener$1$onTransferProgress$1", f = "RecordMinutesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesViewModel$syncListener$1$onTransferProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.dora.api.offline.record.d $progress;
    int label;
    final /* synthetic */ RecordMinutesViewModel this$0;

    public RecordMinutesViewModel$syncListener$1$onTransferProgress$1(RecordMinutesViewModel r1, com.larus.dora.api.offline.record.d r2, Continuation<? super RecordMinutesViewModel$syncListener$1$onTransferProgress$1> r3) {
        this.this$0 = r1;
        this.$progress = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordMinutesViewModel$syncListener$1$onTransferProgress$1(this.this$0, this.$progress, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        boolean r5 = ((RecordMinutesState) this.this$0.getState()).getSyncState().a;
        RecordMinutesViewModel r0 = this.this$0;
        final com.larus.dora.api.offline.record.d r1 = this.$progress;
        RecordMinutesViewModel.access$setState(r0, new n1(r1));
        if (r5 == false) goto L12;
        com.larus.dora.api.offline.record.d r6 = this.$progress;
        if (r6.a == true) goto L12;
        if (r6.g == true) goto L12;
        com.larus.avlink.n1.d("RecordMinutesViewModel", "dora transfer finished, refresh record list");
        this.this$0.fetchRecordMinutesHistoryList(Action.REFRESH_PULL);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
