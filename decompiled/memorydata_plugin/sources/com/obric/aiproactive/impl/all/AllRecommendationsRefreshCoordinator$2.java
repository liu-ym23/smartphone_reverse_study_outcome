package com.obric.aiproactive.impl.all;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AllRecommendationsRefreshCoordinator$2 extends FunctionReferenceImpl implements Function1<Long, Long> {
    public static final AllRecommendationsRefreshCoordinator$2 INSTANCE = null;

    static {
        INSTANCE = new AllRecommendationsRefreshCoordinator$2();
    }

    AllRecommendationsRefreshCoordinator$2() {
        super(1, c.class, "defaultNextDayBoundaryDelayMs", "defaultNextDayBoundaryDelayMs(J)J", 1);
    }

    public final Long invoke(long r1) {
        return Long.valueOf(c.a(r1));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Long invoke(Long r3) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue());
    }
}
