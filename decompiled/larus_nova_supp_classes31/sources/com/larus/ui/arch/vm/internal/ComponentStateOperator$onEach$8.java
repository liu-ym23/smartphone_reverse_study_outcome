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
import kotlin.jvm.functions.Function5;

/* JADX INFO: Add missing generic type declarations: [A, B, C, D] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007H\n"}, d2 = {"<anonymous>", "", "A", "B", "C", "D", "<destruct>", "Lcom/larus/ui/arch/vm/internal/Tuple4;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onEach$8", f = "ComponentStateOperator.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onEach$8<A, B, C, D> extends SuspendLambda implements Function2<r<A, B, C, D>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function5<A, B, C, D, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$onEach$8(Function5<? super A, ? super B, ? super C, ? super D, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super ComponentStateOperator$onEach$8> r2) {
        this.$action = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ComponentStateOperator$onEach$8 r0 = new ComponentStateOperator$onEach$8(this.$action, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(r<A, B, C, D> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((r) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r r11 = (r) this.L$0;
        A r4 = r11.a;
        B r5 = r11.b;
        C r6 = r11.c;
        D r7 = r11.d;
        Function5<A, B, C, D, Continuation<? super Unit>, Object> r3 = this.$action;
        this.label = 1;
        if (r3.invoke(r4, r5, r6, r7, this) != r0) goto L12;
        return r0;
    }
}
