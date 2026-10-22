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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1", f = "ComponentStateOperator.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_flowWhenStarted;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ kotlinx.coroutines.channels.k<T> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlinx.coroutines.channels.k<? super T> r1) {
            this.a = r1;
        }

        public final Object emit(T r2, Continuation<? super Unit> r3) {
            Object r4 = this.a.send(r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1(Flow<Object> r1, Continuation<? super ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1> r2) {
        this.$this_flowWhenStarted = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1 r0 = new ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1(this.$this_flowWhenStarted, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) this.L$0;
        Flow<Object> r2 = this.$this_flowWhenStarted;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
