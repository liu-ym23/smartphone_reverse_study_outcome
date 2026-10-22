package com.larus.bmhome.bot;

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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingFragment$clearHistory$1$confirm$1", f = "ServiceBotSettingFragment.kt", i = {}, l = {219, 220}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotSettingFragment$clearHistory$1$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ServiceBotSettingFragment this$0;

    public ServiceBotSettingFragment$clearHistory$1$confirm$1(ServiceBotSettingFragment r1, Continuation<? super ServiceBotSettingFragment$clearHistory$1$confirm$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ServiceBotSettingFragment$clearHistory$1$confirm$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        wc9.e r6 = (wc9.e) r5;
        if (r6 == null) goto L19;
        MutableSharedFlow<wc9.e> r2 = com.larus.bmhome.bot.utils.a.a;
        MutableSharedFlow<wc9.e> r3 = com.larus.bmhome.bot.utils.a.a;
        this.label = 2;
        if (r3.emit(r6, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        ServiceBotSettingFragment r7 = this.this$0;
        int r4 = ServiceBotSettingFragment.i;
        String r8 = r7.getConversationId();
        this.label = 1;
        r5 = ServiceBotSettingFragment.U90(r7, r8, this);
        if (r5 != r0) goto L13;
        return r0;
    }
}
