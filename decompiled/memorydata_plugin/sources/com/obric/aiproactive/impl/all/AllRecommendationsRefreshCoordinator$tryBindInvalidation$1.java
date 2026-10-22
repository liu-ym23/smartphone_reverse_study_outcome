package com.obric.aiproactive.impl.all;

import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.all.AllRecommendationsRefreshCoordinator", f = "AllRecommendationsRefreshCoordinator.kt", i = {0, 0}, l = {276}, m = "tryBindInvalidation", n = {"this", URLDispatch.KEY_EPOCH}, s = {"L$0", "J$0"})
final class AllRecommendationsRefreshCoordinator$tryBindInvalidation$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    AllRecommendationsRefreshCoordinator$tryBindInvalidation$1(b r3, Continuation<? super AllRecommendationsRefreshCoordinator$tryBindInvalidation$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return b.a(this.this$0, 0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
