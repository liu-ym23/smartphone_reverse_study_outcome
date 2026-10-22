package com.obric.aikernel.runtime;

import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aee/res/PackageInfo;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$transferPackage$vmInfo$3", f = "AIInferRuntime.kt", i = {}, l = {ErrorCode.Contacts.PHONE_NO_PAGE_ERROR}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$transferPackage$vmInfo$3 extends SuspendLambda implements Function1<Continuation<? super com.obric.aee.res.b>, Object> {
    final /* synthetic */ com.obric.aikernel.res.metadata.data.b $pkg;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$transferPackage$vmInfo$3(AIInferRuntime r3, com.obric.aikernel.res.metadata.data.b r4, Continuation<? super AIInferRuntime$transferPackage$vmInfo$3> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$pkg = r4;
        super(1, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$transferPackage$vmInfo$3(this.this$0, this.$pkg, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super com.obric.aee.res.b> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super com.obric.aee.res.b> r3) {
        return ((AIInferRuntime$transferPackage$vmInfo$3) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$transferPackage$vmInfo$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
        AIInferRuntime r7 = this.this$0;
        com.obric.aikernel.res.metadata.data.b r2 = this.$pkg;
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r6 = AIInferRuntime.a(r7, r2, r3);
        if (r6 != r0) goto L11;
        return r0;
    }
}
