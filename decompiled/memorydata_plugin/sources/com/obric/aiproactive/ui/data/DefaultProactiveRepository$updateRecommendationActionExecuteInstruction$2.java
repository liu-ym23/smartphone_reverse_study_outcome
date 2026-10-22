package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.IProactiveService;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2", f = "ProactiveRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionExecuteInstruction;
    final /* synthetic */ String $recommendId;
    int label;
    final /* synthetic */ a this$0;

    DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2(String r3, String r4, a r5, Continuation<? super DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$recommendId = r3;
        this.$actionExecuteInstruction = r4;
        this.this$0 = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2(this.$recommendId, this.$actionExecuteInstruction, this.this$0, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r7);
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("[Repo] updateRecommendationActionExecuteInstruction id=").append(this.$recommendId).append(" len=");
        String r1 = this.$actionExecuteInstruction;
        if (r1 == null) goto L7;
        int r2 = r1.length();
    L8:
        IRunLog.a.a(r0, "ProactiveUI", r8.append(r2).toString(), false, 4, null);
        IProactiveService r9 = a.a(this.this$0);
        if (r9 == null) goto L11;
        r9.updateRecommendationActionExecuteInstruction(this.$recommendId, this.$actionExecuteInstruction);
        return Unit.INSTANCE;
    L11:
        return null;
    L7:
        r2 = 0;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
