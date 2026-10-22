package com.larus.bot.impl.feature.edit.feature.firstmet;

import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.firstmet.BotFirstMetEditViewModel$onLifecycleChange$1", f = "BotFirstMetEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotFirstMetEditViewModel$onLifecycleChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotFirstMetEditViewModel this$0;

    public BotFirstMetEditViewModel$onLifecycleChange$1(BotFirstMetEditViewModel r1, Continuation<? super BotFirstMetEditViewModel$onLifecycleChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotFirstMetEditViewModel$onLifecycleChange$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r9);
        if (AppHost.a.a().isAppBackground() == true) goto L8;
        BotFirstMetEditViewModel r10 = this.this$0;
        int r0 = BotFirstMetEditViewModel.r;
        r10.getClass();
        BotFirstMetEditViewModel.h(r10, false, 1, false, null, false, false, 251);
        r10.i(m.e.a);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
