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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1$1$1", f = "ComponentStateOperator.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$flowWhenStarted$1$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<? extends Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $flowChannel;
    final /* synthetic */ Ref.ObjectRef<Object> $flowValue;
    final /* synthetic */ Ref.BooleanRef $isClosed;
    final /* synthetic */ Ref.ObjectRef<Boolean> $started;
    final /* synthetic */ Function3<Boolean, Object, Continuation<? super Unit>, Object> $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$flowWhenStarted$1$1$1$1(ReceiveChannel<Object> r1, Ref.BooleanRef r2, Ref.ObjectRef<Boolean> r3, Ref.ObjectRef<Object> r4, Function3<? super Boolean, Object, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super ComponentStateOperator$flowWhenStarted$1$1$1$1> r6) {
        this.$flowChannel = r1;
        this.$isClosed = r2;
        this.$started = r3;
        this.$flowValue = r4;
        this.$transform = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ComponentStateOperator$flowWhenStarted$1$1$1$1 r7 = new ComponentStateOperator$flowWhenStarted$1$1$1$1(this.$flowChannel, this.$isClosed, this.$started, this.$flowValue, this.$transform, r10);
        r7.L$0 = r9;
        return r7;
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Boolean r6 = (Boolean) kotlinx.coroutines.channels.g.b(((kotlinx.coroutines.channels.g) this.L$0).a);
        if (r6 != null) goto L11;
        this.$flowChannel.cancel(null);
        this.$isClosed.element = true;
        goto L17
    L11:
        this.$started.element = r6;
        Object r2 = this.$flowValue.element;
        if (r2 == null) goto L17;
        Function3<Boolean, Object, Continuation<? super Unit>, Object> r3 = this.$transform;
        this.label = 1;
        if (r3.invoke(r6, r2, this) != r0) goto L17;
        return r0;
    }

    public /* synthetic */ Object invoke(Object r1, Object r2) {
        return m108invokeWpGqRn0(((kotlinx.coroutines.channels.g) r1).a, (Continuation) r2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m108invokeWpGqRn0(Object r2, Continuation<? super Unit> r3) {
        return create(new kotlinx.coroutines.channels.g(r2), r3).invokeSuspend(Unit.INSTANCE);
    }
}
