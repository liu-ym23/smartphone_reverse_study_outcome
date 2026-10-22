package com.obric.memorydata.init.tasks;

import com.obric.aiproactive.impl.runtime.ProactiveRecommendationEnabledStoreImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AIProactiveAgentInitTask$initLifecycle$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    AIProactiveAgentInitTask$initLifecycle$2(Object r8) {
        super(0, r8, ProactiveRecommendationEnabledStoreImpl.class, "isEnabled", "isEnabled()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((ProactiveRecommendationEnabledStoreImpl) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveRecommendationEnabledStoreImpl.class, "com.obric.memorydata.plugin")).isEnabled());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
