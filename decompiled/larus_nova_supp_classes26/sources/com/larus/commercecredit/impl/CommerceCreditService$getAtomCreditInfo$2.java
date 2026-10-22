package com.larus.commercecredit.impl;

import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.CommerceCreditService$getAtomCreditInfo$2", f = "CommerceCreditService.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceCreditService$getAtomCreditInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<oz8.a, Boolean, Unit> $callback;
    final /* synthetic */ boolean $needTasks;
    final /* synthetic */ CreditInfoScene $scene;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditService$getAtomCreditInfo$2(CreditInfoScene r1, boolean r2, Function2<? super oz8.a, ? super Boolean, Unit> r3, Continuation<? super CommerceCreditService$getAtomCreditInfo$2> r4) {
        this.$scene = r1;
        this.$needTasks = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommerceCreditService$getAtomCreditInfo$2(this.$scene, this.$needTasks, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CommerceCreditConfigManager r13 = CommerceCreditConfigManager.a;
        CreditInfoScene r3 = this.$scene;
        boolean r4 = this.$needTasks;
        final Function2<oz8.a, Boolean, Unit> r14 = this.$callback;
        Function3 r8 = new a(r14);
        this.label = 1;
        if (CommerceCreditConfigManager.b(r3, r4, false, null, null, r8, this, 28) != r0) goto L12;
        return r0;
    }
}
