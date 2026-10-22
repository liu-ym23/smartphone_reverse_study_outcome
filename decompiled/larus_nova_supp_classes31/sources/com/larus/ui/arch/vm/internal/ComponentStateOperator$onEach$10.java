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
import kotlin.jvm.functions.Function6;

/* JADX INFO: Add missing generic type declarations: [A, B, C, D, E] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u00062$\u0010\u0007\u001a \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\bH\n"}, d2 = {"<anonymous>", "", "A", "B", "C", "D", "E", "<destruct>", "Lcom/larus/ui/arch/vm/internal/Tuple5;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onEach$10", f = "ComponentStateOperator.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onEach$10<A, B, C, D, E> extends SuspendLambda implements Function2<s<A, B, C, D, E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function6<A, B, C, D, E, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$onEach$10(Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super ComponentStateOperator$onEach$10> r2) {
        this.$action = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ComponentStateOperator$onEach$10 r0 = new ComponentStateOperator$onEach$10(this.$action, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(s<A, B, C, D, E> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((s) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        s r12 = (s) this.L$0;
        A r4 = r12.a;
        B r5 = r12.b;
        C r6 = r12.c;
        D r7 = r12.d;
        E r8 = r12.e;
        Function6<A, B, C, D, E, Continuation<? super Unit>, Object> r3 = this.$action;
        this.label = 1;
        if (r3.invoke(r4, r5, r6, r7, r8, this) != r0) goto L12;
        return r0;
    }
}
