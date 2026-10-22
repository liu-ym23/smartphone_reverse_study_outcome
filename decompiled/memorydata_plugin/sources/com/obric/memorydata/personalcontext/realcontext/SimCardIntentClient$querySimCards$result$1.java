package com.obric.memorydata.personalcontext.realcontext;

import com.obric.capability.schedulekit.JobResultWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/obric/capability/schedulekit/JobResultWrapper;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.realcontext.SimCardIntentClient$querySimCards$result$1", f = "SimCardIntentClient.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
final class SimCardIntentClient$querySimCards$result$1 extends SuspendLambda implements Function1<Continuation<? super JobResultWrapper>, Object> {
    final /* synthetic */ Function3<String, Long, Continuation<? super JobResultWrapper>, Object> $dispatch;
    final /* synthetic */ long $timeoutMillis;
    int label;

    SimCardIntentClient$querySimCards$result$1(Function3<? super String, ? super Long, ? super Continuation<? super JobResultWrapper>, ? extends Object> r3, long r4, Continuation<? super SimCardIntentClient$querySimCards$result$1> r6) {
        Function3<String, Long, Continuation<? super JobResultWrapper>, Object> r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$dispatch = r5;
        this.$timeoutMillis = r4;
        super(1, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new SimCardIntentClient$querySimCards$result$1(this.$dispatch, this.$timeoutMillis, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super JobResultWrapper> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super JobResultWrapper> r3) {
        return ((SimCardIntentClient$querySimCards$result$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), SimCardIntentClient$querySimCards$result$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Function3<String, Long, Continuation<? super JobResultWrapper>, Object> r7 = this.$dispatch;
        String r2 = d.b();
        Long r3 = Boxing.boxLong(this.$timeoutMillis);
        this.label = 1;
        r6 = r7.invoke(r2, r3, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
