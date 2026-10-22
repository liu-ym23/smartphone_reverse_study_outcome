package com.larus.bot.impl.feature.health;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1", f = "ChatHealthTipFragmentManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $callback;
    final /* synthetic */ GetSafetyInstructionResponse $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1(GetSafetyInstructionResponse r1, Function2<? super Boolean, ? super Boolean, Unit> r2, Continuation<? super ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1> r3) {
        this.$it = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1(this.$it, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        if (this.$it.getShowSafetyInstruction() != null) goto L7;
        this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(false));
    L9:
        return Unit.INSTANCE;
    L7:
        this.$callback.invoke(Boxing.boxBoolean(true), this.$it.getShowSafetyInstruction());
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
