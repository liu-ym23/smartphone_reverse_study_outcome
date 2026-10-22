package com.obric.memorydata.memory.glasses;

import com.obric.memorydata.recommend.RecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class GlassesObservationSyncCoordinator$lifecycle$5 extends FunctionReferenceImpl implements Function0<Boolean> {
    GlassesObservationSyncCoordinator$lifecycle$5(Object r8) {
        super(0, r8, RecommendApi.class, "getScreenObservationCellularEnabled", "getScreenObservationCellularEnabled()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((RecommendApi) ZeusTransformUtils.preCheckCast(this.receiver, RecommendApi.class, "com.obric.memorydata.plugin")).getScreenObservationCellularEnabled());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
