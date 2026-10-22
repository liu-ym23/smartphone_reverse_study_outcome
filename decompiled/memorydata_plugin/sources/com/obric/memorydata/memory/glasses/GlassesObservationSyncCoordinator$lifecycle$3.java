package com.obric.memorydata.memory.glasses;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class GlassesObservationSyncCoordinator$lifecycle$3 extends FunctionReferenceImpl implements Function2<Long, Boolean, Unit> {
    GlassesObservationSyncCoordinator$lifecycle$3(Object r8) {
        super(2, r8, c.class, "scheduleNext", "scheduleNext(JZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(Long r5, Boolean r6) {
        invoke(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long r3, boolean r5) {
        c.a((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.memorydata.plugin"), r3, r5);
    }
}
