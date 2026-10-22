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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "", "result", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1$1$2", f = "ComponentStateOperator.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$flowWhenStarted$1$1$1$2 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $flowValue;
    final /* synthetic */ Ref.BooleanRef $isClosed;
    final /* synthetic */ Ref.ObjectRef<Boolean> $started;
    final /* synthetic */ Function3<Boolean, Object, Continuation<? super Unit>, Object> $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$flowWhenStarted$1$1$1$2(Ref.BooleanRef r1, Ref.ObjectRef<Object> r2, Ref.ObjectRef<Boolean> r3, Function3<? super Boolean, Object, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super ComponentStateOperator$flowWhenStarted$1$1$1$2> r5) {
        this.$isClosed = r1;
        this.$flowValue = r2;
        this.$started = r3;
        this.$transform = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ComponentStateOperator$flowWhenStarted$1$1$1$2 r6 = new ComponentStateOperator$flowWhenStarted$1$1$1$2(this.$isClosed, this.$flowValue, this.$started, this.$transform, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Object r7 = kotlinx.coroutines.channels.g.b(((kotlinx.coroutines.channels.g) this.L$0).a);
        if (r7 != null) goto L11;
        this.$isClosed.element = true;
        goto L17
    L11:
        this.$flowValue.element = r7;
        Object r2 = this.$started.element;
        if (r2 == null) goto L17;
        Function3<Boolean, Object, Continuation<? super Unit>, Object> r3 = this.$transform;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Boolean");
        this.label = 1;
        if (r3.invoke((Boolean) r2, r7, this) != r0) goto L17;
        return r0;
    }

    public /* synthetic */ Object invoke(Object r1, Object r2) {
        return m109invokeWpGqRn0(((kotlinx.coroutines.channels.g) r1).a, (Continuation) r2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m109invokeWpGqRn0(Object r2, Continuation<? super Unit> r3) {
        return create(new kotlinx.coroutines.channels.g(r2), r3).invokeSuspend(Unit.INSTANCE);
    }
}
