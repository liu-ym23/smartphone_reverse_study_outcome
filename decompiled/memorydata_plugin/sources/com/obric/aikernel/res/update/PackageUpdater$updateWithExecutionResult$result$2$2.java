package com.obric.aikernel.res.update;

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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/res/update/UpdateResult;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$2$2", f = "PackageUpdater.kt", i = {}, l = {673}, m = "invokeSuspend", n = {}, s = {})
final class PackageUpdater$updateWithExecutionResult$result$2$2 extends SuspendLambda implements Function1<Continuation<? super UpdateResult>, Object> {
    final /* synthetic */ n.b $constriction;
    final /* synthetic */ UpdateResult $ret;
    final /* synthetic */ s $task;
    int label;

    PackageUpdater$updateWithExecutionResult$result$2$2(s r3, UpdateResult r4, n.b r5, Continuation<? super PackageUpdater$updateWithExecutionResult$result$2$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$task = r3;
        this.$ret = r4;
        this.$constriction = r5;
        super(1, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$result$2$2(this.$task, this.$ret, this.$constriction, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super UpdateResult> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super UpdateResult> r3) {
        return ((PackageUpdater$updateWithExecutionResult$result$2$2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), PackageUpdater$updateWithExecutionResult$result$2$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        Object r3 = r18;
    L13:
        UpdateResult r4 = (UpdateResult) ZeusTransformUtils.preCheckCast(r3, UpdateResult.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L16;
        return r4;
    L16:
        return new UpdateResult(this.$ret.getBiz(), false, 0, null, false, 0, 0, this.$constriction.a(), 0, false, 894, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        s r5 = this.$task;
        if (r5 == null) goto L16;
        Continuation<? super UpdateResult> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r3 = r5.a(r6);
        if (r3 != r1) goto L13;
        return r1;
    }
}
