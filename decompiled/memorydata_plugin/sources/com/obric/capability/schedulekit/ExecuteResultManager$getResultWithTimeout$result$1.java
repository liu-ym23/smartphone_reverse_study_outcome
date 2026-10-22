package com.obric.capability.schedulekit;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capability/schedulekit/JobResultWrapper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.capability.schedulekit.ExecuteResultManager$getResultWithTimeout$result$1", f = "ExecuteResultManager.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
final class ExecuteResultManager$getResultWithTimeout$result$1 extends SuspendLambda implements Function2<al, Continuation<? super JobResultWrapper>, Object> {
    final /* synthetic */ long $questionId;
    long J$0;
    int label;

    ExecuteResultManager$getResultWithTimeout$result$1(long r3, Continuation<? super ExecuteResultManager$getResultWithTimeout$result$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$questionId = r3;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ExecuteResultManager$getResultWithTimeout$result$1(this.$questionId, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super JobResultWrapper> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super JobResultWrapper> r4) {
        return ((ExecuteResultManager$getResultWithTimeout$result$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ExecuteResultManager$getResultWithTimeout$result$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L13:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        long r3 = this.$questionId;
        this.J$0 = r3;
        this.label = 1;
        o r5 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r5.e();
        final n r8 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        Long r2 = Boxing.boxLong(r3);
        ((Map) ZeusTransformUtils.preCheckCast(c.a(), Map.class, "com.obric.memorydata.plugin")).put(r2, new ExecuteResultManager$getResultWithTimeout$result$1$1$1(r8));
        r7 = r5.h();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    L11:
        if (r7 != r0) goto L13;
        return r0;
    }
}
