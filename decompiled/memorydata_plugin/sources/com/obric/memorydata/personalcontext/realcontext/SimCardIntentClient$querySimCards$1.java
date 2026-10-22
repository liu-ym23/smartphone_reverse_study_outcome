package com.obric.memorydata.personalcontext.realcontext;

import com.obric.capability.schedulekit.JobResultWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/obric/capability/schedulekit/JobResultWrapper;", "intentName", "", "timeoutMillis", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.realcontext.SimCardIntentClient$querySimCards$1", f = "SimCardIntentClient.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class SimCardIntentClient$querySimCards$1 extends SuspendLambda implements Function3<String, Long, Continuation<? super JobResultWrapper>, Object> {
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    SimCardIntentClient$querySimCards$1(Continuation<? super SimCardIntentClient$querySimCards$1> r3) {
        super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(String r5, Long r6, Continuation<? super JobResultWrapper> r7) {
        return invoke((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue(), (Continuation) ZeusTransformUtils.preCheckCast(r7, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(String r2, long r3, Continuation<? super JobResultWrapper> r5) {
        SimCardIntentClient$querySimCards$1 r6 = new SimCardIntentClient$querySimCards$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
        r6.L$0 = r2;
        r6.J$0 = r3;
        return r6.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        return r20;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        long r9 = this.J$0;
        com.obric.capability.schedulekit.a r6 = com.obric.capability.schedulekit.a.f7373a;
        Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        Object r0 = com.obric.capability.schedulekit.a.a(r6, r7, null, r9, 0, null, false, null, r16, 122, null);
        if (r0 != r1) goto L12;
        return r1;
    L12:
        return r0;
    }
}
