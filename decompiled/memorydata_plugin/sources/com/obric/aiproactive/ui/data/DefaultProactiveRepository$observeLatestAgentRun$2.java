package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.g;
import com.obric.aiproactive.api.i;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$observeLatestAgentRun$2", f = "ProactiveRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$observeLatestAgentRun$2 extends SuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    DefaultProactiveRepository$observeLatestAgentRun$2(Continuation<? super DefaultProactiveRepository$observeLatestAgentRun$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DefaultProactiveRepository$observeLatestAgentRun$2 r4 = new DefaultProactiveRepository$observeLatestAgentRun$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(g r3, Continuation<? super Unit> r4) {
        return ((DefaultProactiveRepository$observeLatestAgentRun$2) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$observeLatestAgentRun$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(g r3, Continuation<? super Unit> r4) {
        return invoke2((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r7);
        g r6 = (g) ZeusTransformUtils.preCheckCast(this.L$0, g.class, "com.obric.memorydata.plugin");
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("[Repo] observeLatestAgentRun onChanged executionId=");
        String r1 = null;
        if (r6 == null) goto L7;
        String r2 = r6.a();
    L8:
        StringBuilder r9 = r8.append(r2).append(" state=");
        if (r6 == null) goto L11;
        r1 = r6.c();
    L11:
        StringBuilder r10 = r9.append(r1).append(" steps=");
        if (r6 == null) goto L16;
        List<i> r11 = r6.g();
        if (r11 == null) goto L16;
        int r12 = r11.size();
    L17:
        IRunLog.a.a(r0, "ProactiveUI", r10.append(r12).toString(), false, 4, null);
        return Unit.INSTANCE;
    L16:
        r12 = 0;
        goto L17
    L7:
        r2 = null;
        goto L8
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
