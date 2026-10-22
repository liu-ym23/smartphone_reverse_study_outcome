package com.obric.memorydata.realtimecontext;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.realtimecontext.ReferenceResolution$loadModel$1", f = "ReferenceResolution.kt", i = {}, l = {64, 65, 68}, m = "invokeSuspend", n = {}, s = {})
final class ReferenceResolution$loadModel$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ n this$0;

    ReferenceResolution$loadModel$1(n r3, Continuation<? super ReferenceResolution$loadModel$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ReferenceResolution$loadModel$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ReferenceResolution$loadModel$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ReferenceResolution$loadModel$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r0 = r18;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        n r2 = (n) ZeusTransformUtils.preCheckCast(this.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L36:
        n.a(r2, (IBaseModel) ZeusTransformUtils.preCheckCast(r0, IBaseModel.class, "com.obric.memorydata.plugin"));
    L38:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r18);
        Object r3 = ((Result) ZeusTransformUtils.preCheckCast(r0, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L26:
        if (Result.m1427isFailureimpl(r3) == false) goto L28;
        r3 = null;
    L28:
        PackageResource r4 = (PackageResource) ZeusTransformUtils.preCheckCast(r3, PackageResource.class, "com.obric.memorydata.plugin");
    L29:
        if (r4 == null) goto L40;
        n r9 = this.this$0;
        if (r4.isAvailable() == false) goto L38;
        IAIKernelManager r5 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        this.L$0 = r9;
        this.label = 3;
        r0 = IAIKernelManager.DefaultImpls.loadPackage$default(r5, "slm_reference_resolution", false, null, this, 6, null);
        if (r0 != r7) goto L35;
        return r7;
    L35:
        r2 = r9;
        goto L36
    L40:
        return null;
    L11:
        ResultKt.throwOnFailure(r18);
        Object r6 = ((Result) ZeusTransformUtils.preCheckCast(r0, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L16:
        if (Result.m1427isFailureimpl(r6) == false) goto L18;
        r6 = null;
    L18:
        r4 = (PackageResource) ZeusTransformUtils.preCheckCast(r6, PackageResource.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L21;
        return null;
    L21:
        if (r4.isAvailable() == true) goto L29;
        IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        this.label = 2;
        r3 = IAIKernelManager.DefaultImpls.m191updatePackage0E7RQCE$default(r8, r4, null, this, 2, null);
        if (r3 != r7) goto L26;
        return r7;
    L12:
        ResultKt.throwOnFailure(r18);
        IAIKernelManager r11 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r6 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r11, "slm_reference_resolution", null, r14, 2, null);
        if (r6 != r7) goto L16;
        return r7;
    }
}
