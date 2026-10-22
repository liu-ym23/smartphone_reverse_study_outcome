package com.larus.ui.arch.vm.internal;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "", "started", "", "value"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1$transform$1", f = "ComponentStateOperator.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$flowWhenStarted$1$1$transform$1 extends SuspendLambda implements Function3<Boolean, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.channels.k<Object> $$this$channelFlow;
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public ComponentStateOperator$flowWhenStarted$1$1$transform$1(kotlinx.coroutines.channels.k<Object> r1, Continuation<? super ComponentStateOperator$flowWhenStarted$1$1$transform$1> r2) {
        this.$$this$channelFlow = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Boolean) r1).booleanValue(), r2, (Continuation) r3);
    }

    public final Object invoke(boolean r3, Object r4, Continuation<? super Unit> r5) {
        ComponentStateOperator$flowWhenStarted$1$1$transform$1 r0 = new ComponentStateOperator$flowWhenStarted$1$1$transform$1(this.$$this$channelFlow, r5);
        r0.Z$0 = r3;
        r0.L$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        boolean r5 = this.Z$0;
        Object r2 = this.L$0;
        if (r5 == false) goto L14;
        kotlinx.coroutines.channels.k<Object> r6 = this.$$this$channelFlow;
        this.label = 1;
        if (r6.send(r2, this) != r0) goto L14;
        return r0;
    }
}
