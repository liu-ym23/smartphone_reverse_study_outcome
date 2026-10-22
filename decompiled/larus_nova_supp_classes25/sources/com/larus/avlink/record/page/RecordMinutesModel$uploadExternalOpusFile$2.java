package com.larus.avlink.record.page;

import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.minutes.api.IMinutesService;
import com.larus.minutes.api.MinutesOfflineRecordingDeviceType;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/record/page/DataState;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel$uploadExternalOpusFile$2", f = "RecordMinutesModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecordMinutesModel$uploadExternalOpusFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends String>>, Object> {
    final /* synthetic */ String $itemId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesModel this$0;

    public RecordMinutesModel$uploadExternalOpusFile$2(RecordMinutesModel r1, String r2, Continuation<? super RecordMinutesModel$uploadExternalOpusFile$2> r3) {
        this.this$0 = r1;
        this.$itemId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RecordMinutesModel$uploadExternalOpusFile$2 r0 = new RecordMinutesModel$uploadExternalOpusFile$2(this.this$0, this.$itemId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        String r2 = "";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r18);
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        com.larus.dora.api.offline.record.e r4 = this.this$0.e.get(this.$itemId);
        if (r4 != null) goto L9;
        com.larus.avlink.n1.d("RecordMinutesModel", "upload external opus skipped, synced recording not found, id=" + this.$itemId);
        return new a.C0022a("synced recording not found");
    L9:
        if (r4.o.length() != 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L15;
        com.larus.avlink.n1.d("RecordMinutesModel", "upload external opus skipped, local path empty, id=" + this.$itemId);
        return new a.C0022a("synced recording local path empty");
    L15:
        IMinutesService r7 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r7 != null) goto L19;
        com.larus.avlink.n1.d("RecordMinutesModel", "upload external opus failed, minutes service is null");
        return new a.C0022a("minutes service is null");
    L19:
        String r6 = r4.a;
        if ((true ^ StringsKt.isBlank(r6)) == false) goto L22;
        this.this$0.f.put(this.$itemId, r6);
    L22:
        String r8 = this.$itemId;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L25
        LarkRecordMinutesManager.a.getClass();     // Catch: Throwable -> L25
        r7.T0(r4.o, MinutesOfflineRecordingDeviceType.GLASSES, r4.j, r4.i, r4.k, r4.l, r4.f, LarkRecordMinutesManager.e("", ""));     // Catch: Throwable -> L25
        com.larus.avlink.n1.d("RecordMinutesModel", "upload external opus requested, id=" + r8 + ", vuiId=" + r4.a);     // Catch: Throwable -> L25
        Object r0 = Result.constructor-impl(new a.b(r8));     // Catch: Throwable -> L25
    L27:
        RecordMinutesModel r10 = this.this$0;
        String r11 = this.$itemId;
        Throwable r12 = Result.exceptionOrNull-impl(r0);
        if (r12 == null) goto L35;
        r10.f.remove(r11, r6);
        com.larus.avlink.n1.d("RecordMinutesModel", "upload external opus failed, id=" + r11 + ", msg=" + r12.getMessage());
        String r13 = r12.getMessage();
        if (r13 == null) goto L34;
        r2 = r13;
    L34:
        r0 = new a.C0022a(r2);
    L35:
        return r0;
    L25:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L11:
        r5 = false;
        goto L12
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
