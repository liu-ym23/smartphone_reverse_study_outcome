package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.minutes.api.IMinutesService;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
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
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel$deleteRecordMinutesItem$2", f = "RecordMinutesModel.kt", i = {1}, l = {192, 216}, m = "invokeSuspend", n = {"deleteStartTime"}, s = {"J$0"})
final class RecordMinutesModel$deleteRecordMinutesItem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends String>>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ i0 $item;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesModel this$0;

    public RecordMinutesModel$deleteRecordMinutesItem$2(RecordMinutesModel r1, String r2, i0 r3, Continuation<? super RecordMinutesModel$deleteRecordMinutesItem$2> r4) {
        this.this$0 = r1;
        this.$id = r2;
        this.$item = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        RecordMinutesModel$deleteRecordMinutesItem$2 r0 = new RecordMinutesModel$deleteRecordMinutesItem$2(this.this$0, this.$id, this.$item, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r12 = "";
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        long r0 = this.J$0;
        ResultKt.throwOnFailure(r28);
        long r16 = r0;
        Object r2 = r28;
    L49:
        dm9.a.a r3 = (dm9.a) r2;
        long r21 = System.currentTimeMillis() - r16;
        if ((r3 instanceof dm9.a.a) == false) goto L54;
        StringBuilder r4 = new StringBuilder("delete failed due to code=");
        dm9.a.a r5 = r3;
        r4.append(r5.a);
        r4.append(", msg=");
        r4.append(r5.b);
        com.larus.avlink.n1.d("RecordMinutesModel", r4.toString());
        int r6 = com.larus.avlink.record.util.a.a;
        com.larus.avlink.record.util.a.g(false, this.$id, this.this$0.c, r21, "request_failed", r5.b, null, 64);
        return new a.C0022a(r5.b);
    L54:
        if ((r3 instanceof dm9.a.b) == false) goto L64;
        BizResponse r7 = ((dm9.a.b) r3).a;
        int r8 = com.larus.avlink.record.util.a.a;
        String r25 = com.larus.avlink.record.util.a.b(r7);
        if (r7.isSuccess() == false) goto L58;
        com.larus.avlink.n1.d("RecordMinutesModel", "delete success, id: " + this.$id);
        RecordMinutesModel.e(this.this$0, this.$id);
        com.larus.avlink.record.util.a.g(true, this.$id, this.this$0.c, r21, null, null, r25, 48);
        return new a.b(this.$id);
    L58:
        com.larus.avlink.n1.d("RecordMinutesModel", "delete failed due to code=" + r7.getCode() + ", msg=" + r7.getMsg());
        com.larus.avlink.record.util.a.f(false, this.$id, this.this$0.c, r21, "response_code_" + r7.getCode(), r7.getMsg(), r25);
        String r9 = r7.getMsg();
        if (r9 == null) goto L63;
        r12 = r9;
    L63:
        return new a.C0022a(r12);
    L64:
        com.larus.avlink.n1.d("RecordMinutesModel", "Unknown error in delete: " + r3);
        return new a.C0022a("Unknown error in delete");
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r28);
        Object r10 = r28;
    L22:
        if (((Boolean) r10).booleanValue() == false) goto L25;
        return new a.b(this.$id);
    L25:
        return new a.C0022a("delete external opus recording failed");
    L10:
        ResultKt.throwOnFailure(r28);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        RecordMinutesModel r14 = this.this$0;
        String r15 = this.$id;
        r14.getClass();
        boolean r17 = false;
        if (r15 != null) goto L13;
    L15:
        if (r17 == false) goto L27;
        if (this.$item.d != TagType.OFFLINE) goto L27;
        com.larus.avlink.n1.d("RecordMinutesModel", "delete external opus recording, id=" + this.$id);
        RecordMinutesModel r18 = this.this$0;
        String r19 = this.$id;
        this.label = 1;
        r10 = RecordMinutesModel.a(r18, r19, this);
        if (r10 != r11) goto L22;
        return r11;
    L27:
        if (this.$item.d != TagType.OFFLINE) goto L46;
        IMinutesService r20 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r20 != null) goto L32;
        com.larus.avlink.n1.d("RecordMinutesModel", "delete offline recording failed, minutes service is null");
        return new a.C0022a("minutes service is null");
    L32:
        String r22 = this.$id;
        RecordMinutesModel r23 = this.this$0;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L35
        r20.J0(r22);     // Catch: Throwable -> L35
        com.larus.avlink.n1.d("RecordMinutesModel", "delete offline recording success, id: " + r22);     // Catch: Throwable -> L35
        RecordMinutesModel.e(r23, r22);     // Catch: Throwable -> L35
        Object r26 = Result.constructor-impl(new a.b(r22));     // Catch: Throwable -> L35
    L37:
        String r27 = this.$id;
        Throwable r29 = Result.exceptionOrNull-impl(r26);
        if (r29 == null) goto L45;
        com.larus.avlink.n1.d("RecordMinutesModel", "delete offline recording failed, id=" + r27 + ", msg=" + r29.getMessage());
        String r30 = r29.getMessage();
        if (r30 == null) goto L44;
        r12 = r30;
    L44:
        r26 = new a.C0022a(r12);
    L45:
        return r26;
    L35:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L46:
        long r32 = System.currentTimeMillis();
        RecordMinutesApi.a r33 = RecordMinutesApi.a;
        RecordMinutesModel$deleteRecordMinutesItem$2$result$1 r34 = new RecordMinutesModel$deleteRecordMinutesItem$2$result$1(this.$id, null);
        this.J$0 = r32;
        this.label = 2;
        r33.getClass();
        FlowHttpConnection r35 = FlowHttpConnection.a;
        r16 = r32;
        r2 = FlowHttpConnection.g("Audio", RecordMinutesApi.class, r34, false, null, null, null, this, 248);
        if (r2 != r11) goto L49;
        return r11;
    L13:
        if (StringsKt.startsWith$default(r15, "external_opus_", false, 2, null) == false) goto L15;
        r17 = true;
        goto L15
    }
}
