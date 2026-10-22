package com.obric.memorydata.debug;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.debug.ReleaseAdbService$startDownloadModel$1$1$1", f = "ReleaseAdbService.kt", i = {}, l = {877, 878}, m = "invokeSuspend", n = {}, s = {})
final class ReleaseAdbService$startDownloadModel$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.memorydata.aikernelcore.utils.a.C0428a $it;
    int label;

    ReleaseAdbService$startDownloadModel$1$1$1(com.obric.memorydata.aikernelcore.utils.a.C0428a r3, Continuation<? super ReleaseAdbService$startDownloadModel$1$1$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$it = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ReleaseAdbService$startDownloadModel$1$1$1(this.$it, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ReleaseAdbService$startDownloadModel$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ReleaseAdbService$startDownloadModel$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
        ((Result) ZeusTransformUtils.preCheckCast(r12, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        Object r13 = ((Result) ZeusTransformUtils.preCheckCast(r12, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L14:
        if (Result.m1427isFailureimpl(r13) == false) goto L16;
        r13 = null;
    L16:
        PackageResource r6 = (PackageResource) ZeusTransformUtils.preCheckCast(r13, PackageResource.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L24;
        if (r6.isAvailable() == true) goto L24;
        IAIKernelManager r5 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (IAIKernelManager.DefaultImpls.m191updatePackage0E7RQCE$default(r5, r6, null, this, 2, null) != r0) goto L24;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        IAIKernelManager r7 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        String r8 = this.$it.a();
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r13 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r7, r8, null, r9, 2, null);
        if (r13 != r0) goto L14;
        return r0;
    }
}
