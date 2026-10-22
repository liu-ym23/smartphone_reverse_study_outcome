package com.obric.memorydata.awareness.impl.collector;

import com.obric.memorydata.ability.data.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class DeviceFeatureCollectorFactory$createFeatureCollector$11 extends FunctionReferenceImpl implements Function1<h, Unit> {
    DeviceFeatureCollectorFactory$createFeatureCollector$11(Object r8) {
        super(1, r8, d.class, "brightnessProcess", "brightnessProcess(Lcom/obric/memorydata/ability/data/IStandardData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(h r3) {
        invoke2((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "p0");
        d.f((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.memorydata.plugin"), r4);
    }
}
