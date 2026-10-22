package com.larus.ui.arch.vm.internal;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [A, B, C] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006H\n"}, d2 = {"<anonymous>", "", "A", "B", "C", "<destruct>", "Lcom/larus/ui/arch/vm/internal/Tuple3;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onEach$6", f = "ComponentStateOperator.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onEach$6<A, B, C> extends SuspendLambda implements Function2<q<A, B, C>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<A, B, C, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$onEach$6(Function4<? super A, ? super B, ? super C, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super ComponentStateOperator$onEach$6> r2) {
        this.$action = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ComponentStateOperator$onEach$6 r0 = new ComponentStateOperator$onEach$6(this.$action, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(q<A, B, C> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((q) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        q r7 = (q) this.L$0;
        A r2 = r7.a;
        B r3 = r7.b;
        C r8 = r7.c;
        Function4<A, B, C, Continuation<? super Unit>, Object> r4 = this.$action;
        this.label = 1;
        if (r4.invoke(r2, r3, r8, this) != r0) goto L12;
        return r0;
    }
}
