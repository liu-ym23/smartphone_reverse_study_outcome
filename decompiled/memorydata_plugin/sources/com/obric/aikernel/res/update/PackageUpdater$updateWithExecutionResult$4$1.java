package com.obric.aikernel.res.update;

import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$4$1", f = "PackageUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PackageUpdater$updateWithExecutionResult$4$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ StringBuilder $bizRequestStatus;
    final /* synthetic */ n.b $constriction;
    final /* synthetic */ PackageResourceManager.PresmConfig.d $it;
    final /* synthetic */ String $updateType;
    int label;

    PackageUpdater$updateWithExecutionResult$4$1(PackageResourceManager.PresmConfig.d r3, n.b r4, StringBuilder r5, String r6, Continuation<? super PackageUpdater$updateWithExecutionResult$4$1> r7) {
        PackageResourceManager.PresmConfig.d r8 = (PackageResourceManager.PresmConfig.d) ZeusTransformUtils.wrapperContextForParams(r3, PackageResourceManager.PresmConfig.d.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$it = r8;
        this.$constriction = r4;
        this.$bizRequestStatus = r5;
        this.$updateType = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$4$1(this.$it, this.$constriction, this.$bizRequestStatus, this.$updateType, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PackageUpdater$updateWithExecutionResult$4$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PackageUpdater$updateWithExecutionResult$4$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        PackageResourceManager.PresmConfig.d r5 = this.$it;
        n.b r0 = this.$constriction;
        String r1 = this.$bizRequestStatus.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "bizRequestStatus.toString()");
        r5.a(r0, r1, this.$updateType);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
