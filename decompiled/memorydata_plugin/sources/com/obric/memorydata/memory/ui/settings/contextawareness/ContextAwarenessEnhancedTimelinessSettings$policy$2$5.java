package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.obric.memorydata.recommend.IRecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ContextAwarenessEnhancedTimelinessSettings$policy$2$5 extends FunctionReferenceImpl implements Function0<Unit> {
    ContextAwarenessEnhancedTimelinessSettings$policy$2$5(Object r8) {
        super(0, r8, IRecommendApi.class, "refreshEnhancedTimelinessTaskConditions", "refreshEnhancedTimelinessTaskConditions()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((IRecommendApi) ZeusTransformUtils.preCheckCast(this.receiver, IRecommendApi.class, "com.obric.memorydata.plugin")).refreshEnhancedTimelinessTaskConditions();
    }
}
