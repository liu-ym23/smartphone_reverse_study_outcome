package com.obric.aiproactive.impl.now;

import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.now.NowRecommendationsHub", f = "NowRecommendationsHub.kt", i = {0, 0, 0, 0}, l = {345}, m = "refreshNowCandidatesWithRetry", n = {"pythonSuccessButEmpty", URLDispatch.KEY_EPOCH, "retryCount", "attempt"}, s = {"L$0", "J$0", "I$0", "I$2"})
final class NowRecommendationsHub$refreshNowCandidatesWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    NowRecommendationsHub$refreshNowCandidatesWithRetry$1(a r3, Continuation<? super NowRecommendationsHub$refreshNowCandidatesWithRetry$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, 0, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
