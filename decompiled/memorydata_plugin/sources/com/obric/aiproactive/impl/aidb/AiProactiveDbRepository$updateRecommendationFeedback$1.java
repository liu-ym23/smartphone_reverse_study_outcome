package com.obric.aiproactive.impl.aidb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.aidb.AiProactiveDbRepository", f = "AiProactiveDbRepository.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 651, 653, 672}, m = "updateRecommendationFeedback", n = {"this", Ext.KEY_REQUEST, "policy", "db", "shouldToast", "valueOnly", "this", Ext.KEY_REQUEST, "policy", "db", "shouldToast", "valueOnly", "this", Ext.KEY_REQUEST, "policy", "db", "shouldToast", "valueOnly", "this", Ext.KEY_REQUEST, "policy", "shouldToast"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "I$0", "Z$0", "L$0", "L$1", "L$2", "I$0"})
final class AiProactiveDbRepository$updateRecommendationFeedback$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    AiProactiveDbRepository$updateRecommendationFeedback$1(d r3, Continuation<? super AiProactiveDbRepository$updateRecommendationFeedback$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
