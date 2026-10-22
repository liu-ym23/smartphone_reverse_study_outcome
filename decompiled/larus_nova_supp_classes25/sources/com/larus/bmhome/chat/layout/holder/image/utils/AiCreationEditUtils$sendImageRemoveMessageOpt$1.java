package com.larus.bmhome.chat.layout.holder.image.utils;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import ny9.s;
import ny9.u;
import ny9.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils$sendImageRemoveMessageOpt$1", f = "AiCreationEditUtils.kt", i = {0}, l = {691}, m = "invokeSuspend", n = {"sendConfig"}, s = {"L$1"})
final class AiCreationEditUtils$sendImageRemoveMessageOpt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $creationSendMessageConfig;
    final /* synthetic */ Function0<Unit> $dismissCreationPage;
    final /* synthetic */ ImageEditDataWithMask $imageEditDataWithMask;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public AiCreationEditUtils$sendImageRemoveMessageOpt$1(CreationSendMessageConfig r1, ImageEditDataWithMask r2, Function0<Unit> r3, Continuation<? super AiCreationEditUtils$sendImageRemoveMessageOpt$1> r4) {
        this.$creationSendMessageConfig = r1;
        this.$imageEditDataWithMask = r2;
        this.$dismissCreationPage = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AiCreationEditUtils$sendImageRemoveMessageOpt$1 r0 = new AiCreationEditUtils$sendImageRemoveMessageOpt$1(this.$creationSendMessageConfig, this.$imageEditDataWithMask, this.$dismissCreationPage, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        CreationSendMessageConfig r1 = (CreationSendMessageConfig) this.L$1;
        Function0<Unit> r3 = (Function0) this.L$0;
        ResultKt.throwOnFailure(r35);     // Catch: Throwable -> L23
    L15:
        MutableSharedFlow r4 = ty9.a.a;     // Catch: Throwable -> L23
        AiCreationEditUtils r5 = AiCreationEditUtils.a;     // Catch: Throwable -> L23
        String r6 = r1.getCvsId();     // Catch: Throwable -> L23
        if (r6 != null) goto L21;
        wc9.e r7 = r1.getConversation();     // Catch: Throwable -> L23
        if (r7 == null) goto L20;
        r6 = r7.a;     // Catch: Throwable -> L23
        goto L21
    L20:
        r6 = null;
    L21:
        boolean r8 = r1.getClearInputContent();     // Catch: Throwable -> L23
        r5.getClass();     // Catch: Throwable -> L23
        ty9.a.a(AiCreationEditUtils.c(r6, r8));     // Catch: Throwable -> L23
        r3.invoke();     // Catch: Throwable -> L23
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L29;
        FLogger.a.e("AiCreationEditUtils", "sendImageRemoveMessageOpt failed", r10);
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r35);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        CreationSendMessageConfig r12 = this.$creationSendMessageConfig;
        ImageEditDataWithMask r13 = this.$imageEditDataWithMask;
        Function0<Unit> r15 = this.$dismissCreationPage;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L23
        AiCreationEditUtils.a.getClass();     // Catch: Throwable -> L23
        CreationSendMessageConfig r16 = CreationSendMessageConfig.copy$default(r12, null, null, null, null, null, null, null, null, null, null, null, null, r13, null, new u(new s(v.a(new f()))), null, null, null, null, null, null, false, null, null, false, false, null, 134197247, null);     // Catch: Throwable -> L23
        ICreationWorkflowService.Companion r17 = ICreationWorkflowService.a;     // Catch: Throwable -> L23
        this.L$0 = r15;     // Catch: Throwable -> L23
        this.L$1 = r16;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        if (r17.W(r16, this) != r0) goto L14;
        return r0;
    L14:
        r1 = r16;
        r3 = r15;
    L23:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }
}
