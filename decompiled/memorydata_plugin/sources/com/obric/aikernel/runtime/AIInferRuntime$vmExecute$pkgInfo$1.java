package com.obric.aikernel.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/obric/aee/res/PackageInfo;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$vmExecute$pkgInfo$1", f = "AIInferRuntime.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$vmExecute$pkgInfo$1 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends Integer, ? extends com.obric.aee.res.b>>, Object> {
    final /* synthetic */ AIInferRuntime.g $pkgWrapper;
    int label;

    AIInferRuntime$vmExecute$pkgInfo$1(AIInferRuntime.g r3, Continuation<? super AIInferRuntime$vmExecute$pkgInfo$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$pkgWrapper = r3;
        super(1, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$pkgInfo$1(this.$pkgWrapper, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Pair<? extends Integer, ? extends com.obric.aee.res.b>> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Pair<Integer, com.obric.aee.res.b>> r3) {
        return ((AIInferRuntime$vmExecute$pkgInfo$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$vmExecute$pkgInfo$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L16:
        return (Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AIInferRuntime.g r6 = this.$pkgWrapper;
        if (r6 == null) goto L14;
        Continuation<? super Pair<Integer, com.obric.aee.res.b>> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r5 = r6.a(r2);
        if (r5 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
