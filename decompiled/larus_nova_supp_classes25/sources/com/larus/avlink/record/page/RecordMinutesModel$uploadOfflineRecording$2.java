package com.larus.avlink.record.page;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.minutes.api.IMinutesService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/record/page/DataState;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel$uploadOfflineRecording$2", f = "RecordMinutesModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecordMinutesModel$uploadOfflineRecording$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends String>>, Object> {
    final /* synthetic */ String $recordingId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesModel this$0;

    public RecordMinutesModel$uploadOfflineRecording$2(String r1, RecordMinutesModel r2, Continuation<? super RecordMinutesModel$uploadOfflineRecording$2> r3) {
        this.$recordingId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RecordMinutesModel$uploadOfflineRecording$2 r0 = new RecordMinutesModel$uploadOfflineRecording$2(this.$recordingId, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        String r0 = "";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        IMinutesService r15 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r15 != null) goto L8;
        com.larus.avlink.n1.d("RecordMinutesModel", "upload offline recording failed, minutes service is null");
        return new a.C0022a("minutes service is null");
    L8:
        String r11 = this.$recordingId;
        RecordMinutesModel r3 = this.this$0;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        LarkRecordMinutesManager.a.getClass();     // Catch: Throwable -> L11
        String r5 = LarkRecordMinutesManager.e("", "");     // Catch: Throwable -> L11
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L11
        r15.C0(r11, r5);     // Catch: Throwable -> L11
        com.larus.avlink.n1.d("RecordMinutesModel", "upload offline recording requested, id=" + r11);     // Catch: Throwable -> L11
        int r16 = com.larus.avlink.record.util.a.a;     // Catch: Throwable -> L11
        com.larus.avlink.record.util.a.m(true, r11, r3.c, System.currentTimeMillis() - r6, null, null, DoraCallStateCode.DOUBAO_CMD_12);     // Catch: Throwable -> L11
        Object r17 = Result.constructor-impl(new a.b(r11));     // Catch: Throwable -> L11
    L13:
        String r7 = this.$recordingId;
        RecordMinutesModel r1 = this.this$0;
        Throwable r12 = Result.exceptionOrNull-impl(r17);
        if (r12 == null) goto L21;
        com.larus.avlink.n1.d("RecordMinutesModel", "upload offline recording failed, id=" + r7 + ", msg=" + r12.getMessage());
        int r18 = com.larus.avlink.record.util.a.a;
        com.larus.avlink.record.util.a.m(false, r7, r1.c, 0, "internal_error", r12.getMessage(), 16);
        String r2 = r12.getMessage();
        if (r2 == null) goto L20;
        r0 = r2;
    L20:
        r17 = new a.C0022a(r0);
    L21:
        return r17;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
