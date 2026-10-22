package com.obric.aiproactive.impl;

import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ProactiveService$allRecommendationsCoordinator$2$2 extends FunctionReferenceImpl implements SuspendFunction, Function2<String, Continuation<? super ProactiveAllPageSnapshot>, Object> {
    ProactiveService$allRecommendationsCoordinator$2$2(Object r8) {
        super(2, r8, ProactiveService.class, "loadCoordinatorAllRecommendations", "loadCoordinatorAllRecommendations(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(String r3, Continuation<? super ProactiveAllPageSnapshot> r4) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r3, Continuation<? super ProactiveAllPageSnapshot> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ProactiveService.access$loadCoordinatorAllRecommendations((ProactiveService) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveService.class, "com.obric.memorydata.plugin"), r3, r5);
    }
}
