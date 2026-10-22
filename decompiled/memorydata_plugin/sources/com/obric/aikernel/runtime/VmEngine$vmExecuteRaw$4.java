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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/aikernel/runtime/AIInferRuntime$VmExecuteController;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$4", f = "VmEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$vmExecuteRaw$4 extends SuspendLambda implements Function2<AIInferRuntime.i, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ com.obric.aee.res.b $pkg;
    private /* synthetic */ Object L$0;
    int label;

    VmEngine$vmExecuteRaw$4(RequestParams r3, com.obric.aee.res.b r4, Continuation<? super VmEngine$vmExecuteRaw$4> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$params = r3;
        this.$pkg = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        VmEngine$vmExecuteRaw$4 r0 = new VmEngine$vmExecuteRaw$4(this.$params, this.$pkg, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(AIInferRuntime.i r3, Continuation<? super Unit> r4) {
        return ((VmEngine$vmExecuteRaw$4) ZeusTransformUtils.preCheckCast(create((AIInferRuntime.i) ZeusTransformUtils.wrapperContextForParams(r3, AIInferRuntime.i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), VmEngine$vmExecuteRaw$4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(AIInferRuntime.i r3, Continuation<? super Unit> r4) {
        return invoke2((AIInferRuntime.i) ZeusTransformUtils.preCheckCast(r3, AIInferRuntime.i.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        ((AIInferRuntime.i) ZeusTransformUtils.preCheckCast(this.L$0, AIInferRuntime.i.class, "com.obric.memorydata.plugin")).a(this.$params, this.$pkg);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
