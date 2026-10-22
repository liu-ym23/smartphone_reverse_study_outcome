package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$reportRecordingIdToGlasses$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {584}, m = "invokeSuspend", n = {}, s = {})
final class LarkRecordMinutesManager$reportRecordingIdToGlasses$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ IDoraOfflineRecordSyncService $syncService;
    final /* synthetic */ String $wakeupId;
    private /* synthetic */ Object L$0;
    int label;

    public LarkRecordMinutesManager$reportRecordingIdToGlasses$1(String r1, String r2, IDoraOfflineRecordSyncService r3, Continuation<? super LarkRecordMinutesManager$reportRecordingIdToGlasses$1> r4) {
        this.$recordingId = r1;
        this.$wakeupId = r2;
        this.$syncService = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        LarkRecordMinutesManager$reportRecordingIdToGlasses$1 r0 = new LarkRecordMinutesManager$reportRecordingIdToGlasses$1(this.$recordingId, this.$wakeupId, this.$syncService, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L13:
        Object r9 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r8).booleanValue()));     // Catch: Throwable -> L15
    L17:
        String r2 = this.$recordingId;
        String r3 = this.$wakeupId;
        Throwable r4 = Result.exceptionOrNull-impl(r9);
        if (r4 == null) goto L20;
        n1.b("LarkRecordMinutesManager", "report recordingId to glasses failed, id=" + r2 + ", wakeupId=" + r3 + ", err=" + r4.getMessage());
    L20:
        Boolean r5 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r9) == false) goto L23;
        r9 = r5;
    L23:
        n1.d("LarkRecordMinutesManager", "report recordingId to glasses done, success=" + ((Boolean) r9).booleanValue() + ", id=" + this.$recordingId + ", wakeupId=" + this.$wakeupId);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        IDoraOfflineRecordSyncService r11 = this.$syncService;
        String r6 = this.$wakeupId;
        String r7 = this.$recordingId;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r8 = r11.a(r6, r7, this);     // Catch: Throwable -> L15
        if (r8 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
