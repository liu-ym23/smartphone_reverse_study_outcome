package com.obric.aiproactive.impl.aidb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.aidb.AiProactiveDbRepository", f = "AiProactiveDbRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {500, TypedValues.PositionType.TYPE_PERCENT_X, FrameMetricsAggregator.EVERY_DURATION}, m = "markCurrentActionExecuted", n = {"this", "db", "recommendationId", "updated", "this", "db", "recommendationId", "result"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "L$0"})
final class AiProactiveDbRepository$markCurrentActionExecuted$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    AiProactiveDbRepository$markCurrentActionExecuted$1(d r3, Continuation<? super AiProactiveDbRepository$markCurrentActionExecuted$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(0, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
