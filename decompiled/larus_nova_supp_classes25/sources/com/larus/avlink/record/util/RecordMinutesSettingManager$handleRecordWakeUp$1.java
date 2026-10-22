package com.larus.avlink.record.util;

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
@DebugMetadata(c = "com.larus.avlink.record.util.RecordMinutesSettingManager$handleRecordWakeUp$1", f = "RecordMinutesSettingManager.kt", i = {0}, l = {866}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class RecordMinutesSettingManager$handleRecordWakeUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $kw;
    final /* synthetic */ int $mode;
    final /* synthetic */ int $query;
    final /* synthetic */ int $state;
    final /* synthetic */ int $vuiId;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    int label;

    public RecordMinutesSettingManager$handleRecordWakeUp$1(int r1, int r2, int r3, int r4, String r5, Continuation<? super RecordMinutesSettingManager$handleRecordWakeUp$1> r6) {
        this.$state = r1;
        this.$mode = r2;
        this.$query = r3;
        this.$vuiId = r4;
        this.$kw = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RecordMinutesSettingManager$handleRecordWakeUp$1(this.$state, this.$mode, this.$query, this.$vuiId, this.$kw, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$3;
        int r3 = this.I$2;
        int r4 = this.I$1;
        int r5 = this.I$0;
        String r6 = (String) this.L$1;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);
        int r12 = r2;
        int r11 = r3;
        int r10 = r4;
        int r9 = r5;
        String r13 = r6;
    L18:
        RecordMinutesSettingManager.b(RecordMinutesSettingManager.a, r9, r10, r11, r12, r13);     // Catch: Throwable -> L15
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r7.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r7 = RecordMinutesSettingManager.e;
        int r8 = this.$state;
        int r17 = this.$mode;
        int r14 = this.$query;
        int r18 = this.$vuiId;
        String r19 = this.$kw;
        this.L$0 = r7;
        this.L$1 = r19;
        this.I$0 = r8;
        this.I$1 = r17;
        this.I$2 = r14;
        this.I$3 = r18;
        this.label = 1;
        if (r7.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r10 = r17;
        r11 = r14;
        r9 = r8;
        r12 = r18;
        r13 = r19;
        goto L18
    }
}
