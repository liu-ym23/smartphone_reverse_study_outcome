package com.obric.aiproactive.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ProactiveService$allRecommendationsCoordinator$2$3 extends FunctionReferenceImpl implements SuspendFunction, Function3<String, Function0<? extends Unit>, Continuation<? super com.obric.aiproactive.impl.all.a>, Object> {
    ProactiveService$allRecommendationsCoordinator$2$3(Object r8) {
        super(3, r8, ProactiveService.class, "bindAllRecommendationsInvalidation", "bindAllRecommendationsInvalidation(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(String r3, Function0<? extends Unit> r4, Continuation<? super com.obric.aiproactive.impl.all.a> r5) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(r4, Function0.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r3, Function0<Unit> r4, Continuation<? super com.obric.aiproactive.impl.all.a> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return ProactiveService.access$bindAllRecommendationsInvalidation((ProactiveService) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveService.class, "com.obric.memorydata.plugin"), r3, r6, r7);
    }
}
