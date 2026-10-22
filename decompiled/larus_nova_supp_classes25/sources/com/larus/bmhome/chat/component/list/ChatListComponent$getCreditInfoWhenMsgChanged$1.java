package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$getCreditInfoWhenMsgChanged$1", f = "ChatListComponent.kt", i = {}, l = {835}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$getCreditInfoWhenMsgChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreditInfoScene $scene;
    int label;

    public ChatListComponent$getCreditInfoWhenMsgChanged$1(CreditInfoScene r1, Continuation<? super ChatListComponent$getCreditInfoWhenMsgChanged$1> r2) {
        this.$scene = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatListComponent$getCreditInfoWhenMsgChanged$1(this.$scene, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Exception -> L15
    L19:
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        ICommerceCreditService.a.getClass();     // Catch: Exception -> L15
        ICommerceCreditService r6 = ICommerceCreditService.a.a();     // Catch: Exception -> L15
        if (r6 == null) goto L19;
        CreditInfoScene r2 = this.$scene;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        if (r6.m(r2, false, null, this) != r0) goto L19;
        return r0;
    L15:
        e = move-exception;
        FLogger.a.e("streamService", "Failed to getAtomCreditInfo", e);
        goto L18
    }
}
