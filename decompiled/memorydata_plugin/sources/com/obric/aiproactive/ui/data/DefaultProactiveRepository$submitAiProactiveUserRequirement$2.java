package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.x;
import com.obric.aiproactive.api.z;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$submitAiProactiveUserRequirement$2", f = "ProactiveRepository.kt", i = {0}, l = {461}, m = "invokeSuspend", n = {"startedAt"}, s = {"J$0"})
final class DefaultProactiveRepository$submitAiProactiveUserRequirement$2 extends SuspendLambda implements Function2<al, Continuation<? super z>, Object> {
    final /* synthetic */ x $request;
    long J$0;
    int label;
    final /* synthetic */ a this$0;

    DefaultProactiveRepository$submitAiProactiveUserRequirement$2(a r3, x r4, Continuation<? super DefaultProactiveRepository$submitAiProactiveUserRequirement$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$request = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$submitAiProactiveUserRequirement$2(this.this$0, this.$request, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z> r4) {
        return ((DefaultProactiveRepository$submitAiProactiveUserRequirement$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$submitAiProactiveUserRequirement$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r15);
    L16:
        z r16 = (z) ZeusTransformUtils.preCheckCast(r15, z.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L20;
        r16 = new z(false, 3, "repository_timeout", this.$request.b(), null, false, 48, null);
    L20:
        if (r16.c() == this.$request.b()) goto L22;
        r16 = new z(false, 1, "request_id_mismatch", this.$request.b(), null, false, 48, null);
    L22:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] submitUserRequirement requestId=" + this.$request.b() + " code=" + r16.b() + " success=" + r16.a() + " deduplicated=" + r16.d() + " durationMs=" + (System.currentTimeMillis() - r2), false, 4, null);
        return r16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        IProactiveService r17 = a.a(this.this$0);
        if (r17 == null) goto L11;
        long r4 = System.currentTimeMillis();
        Function2 r18 = (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$submitAiProactiveUserRequirement$2$result$1(r17, this.$request, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r4;
        this.label = 1;
        r15 = da.b(12000, r18, r3);
        if (r15 != r0) goto L15;
        return r0;
    L15:
        r2 = r4;
        goto L16
    L11:
        return new z(false, 1004, "service_unavailable", this.$request.b(), null, false, 48, null);
    }
}
