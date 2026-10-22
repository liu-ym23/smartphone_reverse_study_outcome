package com.obric.memorydata.database.manager.proactive;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDbProvider", f = "ProactiveRecommendationDbProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {90}, m = "await", n = {"this", "context", "uid", "timeoutMs", "pollIntervalMs", CommonConsts.APM_INNER_EVENT_COST_START}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2"})
final class ProactiveRecommendationDbProvider$await$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    ProactiveRecommendationDbProvider$await$1(a r3, Continuation<? super ProactiveRecommendationDbProvider$await$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, 0, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
