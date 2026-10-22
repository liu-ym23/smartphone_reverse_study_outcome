package com.bytedance.android.ec.core.arch.state;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/arch/state/b;", "S", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.state.CoroutinesStateStore$setupTriggerFlushQueues$1", f = "CoroutinesStateStore.kt", i = {0}, l = {57}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class CoroutinesStateStore$setupTriggerFlushQueues$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public CoroutinesStateStore$setupTriggerFlushQueues$1(a r1, Continuation r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        CoroutinesStateStore$setupTriggerFlushQueues$1 r0 = new CoroutinesStateStore$setupTriggerFlushQueues$1(this.this$0, r11);
        r0.L$0 = r10;
        return r0;
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L11:
        if (CoroutineScopeKt.isActive(r11) == false) goto L27;
        a r12 = this.this$0;
        this.L$0 = r11;
        this.label = 1;
        r12.getClass();
        SelectBuilderImpl r13 = new SelectBuilderImpl(this);
        r13.d(r12.a.getOnReceive(), new CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1(null, r12));     // Catch: Throwable -> L15
        r13.d(r12.b.getOnReceive(), new CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$2(null, r12));     // Catch: Throwable -> L15
    L17:
        Object r14 = r13.n();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(this);
    L21:
        if (r14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        r14 = Unit.INSTANCE;
    L24:
        if (r14 != r0) goto L11;
        return r0;
    L15:
        th = move-exception;
        kotlinx.coroutines.j r15 = r13.g;
        Result.Companion r16 = Result.Companion;
        r15.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
        goto L17
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r11 = (CoroutineScope) this.L$0;
        goto L11
    }
}
