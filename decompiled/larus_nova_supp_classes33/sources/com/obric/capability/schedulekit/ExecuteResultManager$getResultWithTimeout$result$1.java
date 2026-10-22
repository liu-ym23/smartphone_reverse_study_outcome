package com.obric.capability.schedulekit;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/capability/schedulekit/JobResultWrapper;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.capability.schedulekit.ExecuteResultManager$getResultWithTimeout$result$1", f = "ExecuteResultManager.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
final class ExecuteResultManager$getResultWithTimeout$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JobResultWrapper>, Object> {
    final /* synthetic */ long $questionId;
    long J$0;
    int label;

    public ExecuteResultManager$getResultWithTimeout$result$1(long r1, Continuation<? super ExecuteResultManager$getResultWithTimeout$result$1> r3) {
        this.$questionId = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ExecuteResultManager$getResultWithTimeout$result$1(this.$questionId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super JobResultWrapper> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L13:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r3 = this.$questionId;
        this.J$0 = r3;
        this.label = 1;
        final j r7 = new j(IntrinsicsKt.intercepted(this), 1);
        r7.C();
        Long r2 = Boxing.boxLong(r3);
        ExecuteResultManager.a.put(r2, new ExecuteResultManager$getResultWithTimeout$result$1$1$1(r7));
        r6 = r7.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r6 != r0) goto L13;
        return r0;
    }
}
