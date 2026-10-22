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

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "asyncValue", "Lcom/larus/ui/arch/vm/external/Async;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onAsync$1", f = "ComponentStateOperator.kt", i = {}, l = {121, 123}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onAsync$1<T> extends SuspendLambda implements Function2<w1a.a<? extends T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Unit>, Object> $onFail;
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $onSuccess;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$onAsync$1(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super ComponentStateOperator$onAsync$1> r3) {
        this.$onSuccess = r1;
        this.$onFail = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ComponentStateOperator$onAsync$1 r0 = new ComponentStateOperator$onAsync$1(this.$onSuccess, this.$onFail, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((w1a.a) r1, (Continuation) r2);
    }

    public final Object invoke(w1a.a<? extends T> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L25:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r7);
        w1a.a r8 = (w1a.a) this.L$0;
        Function2<T, Continuation<? super Unit>, Object> r2 = this.$onSuccess;
        if (r2 != null) goto L13;
    L17:
        Function2<Throwable, Continuation<? super Unit>, Object> r3 = this.$onFail;
        if (r3 == null) goto L25;
        if ((r8 instanceof w1a.e) == false) goto L25;
        ((w1a.e) r8).getClass();
        this.label = 2;
        if (r3.invoke(null, this) != r0) goto L25;
        return r0;
    L13:
        if ((r8 instanceof w1a.g) == false) goto L17;
        ((w1a.g) r8).getClass();
        this.label = 1;
        if (r2.invoke(null, this) != r0) goto L25;
        return r0;
    }
}
