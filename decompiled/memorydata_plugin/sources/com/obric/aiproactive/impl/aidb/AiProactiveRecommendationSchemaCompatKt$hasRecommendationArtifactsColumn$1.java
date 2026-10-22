package com.obric.aiproactive.impl.aidb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.aidb.AiProactiveRecommendationSchemaCompatKt", f = "AiProactiveRecommendationSchemaCompat.kt", i = {}, l = {41}, m = "hasRecommendationArtifactsColumn", n = {}, s = {})
final class AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1(Continuation<? super AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1> r3) {
        super((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return l.a(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
