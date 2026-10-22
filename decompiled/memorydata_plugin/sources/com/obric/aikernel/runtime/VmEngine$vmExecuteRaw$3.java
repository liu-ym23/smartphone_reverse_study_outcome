package com.obric.aikernel.runtime;

import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/aikernel/runtime/AIInferRuntime$VmExecuteController;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$3", f = "VmEngine.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$vmExecuteRaw$3 extends SuspendLambda implements Function2<AIInferRuntime.i, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ com.obric.aee.res.b $pkg;
    final /* synthetic */ Ref.IntRef $preExecuteStatus;
    private /* synthetic */ Object L$0;
    int label;

    VmEngine$vmExecuteRaw$3(Ref.IntRef r3, RequestParams r4, com.obric.aee.res.b r5, Continuation<? super VmEngine$vmExecuteRaw$3> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$preExecuteStatus = r3;
        this.$params = r4;
        this.$pkg = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        VmEngine$vmExecuteRaw$3 r0 = new VmEngine$vmExecuteRaw$3(this.$preExecuteStatus, this.$params, this.$pkg, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(AIInferRuntime.i r3, Continuation<? super Unit> r4) {
        return ((VmEngine$vmExecuteRaw$3) ZeusTransformUtils.preCheckCast(create((AIInferRuntime.i) ZeusTransformUtils.wrapperContextForParams(r3, AIInferRuntime.i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), VmEngine$vmExecuteRaw$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(AIInferRuntime.i r3, Continuation<? super Unit> r4) {
        return invoke2((AIInferRuntime.i) ZeusTransformUtils.preCheckCast(r3, AIInferRuntime.i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.IntRef r7 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.IntRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L12:
        r7.element = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        AIInferRuntime.i r9 = (AIInferRuntime.i) ZeusTransformUtils.preCheckCast(this.L$0, AIInferRuntime.i.class, "com.obric.memorydata.plugin");
        Ref.IntRef r2 = this.$preExecuteStatus;
        RequestParams r4 = this.$params;
        com.obric.aee.res.b r5 = this.$pkg;
        Continuation<? super Integer> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 1;
        r8 = r9.a(r4, r5, r6);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r7 = r2;
        goto L12
    }
}
