package com.obric.memorydata.memory.glasses;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class GlassesObservationSyncCoordinator$lifecycle$2 extends FunctionReferenceImpl implements Function3<Long, Boolean, Boolean, Unit> {
    GlassesObservationSyncCoordinator$lifecycle$2(Object r8) {
        super(3, r8, c.class, "enqueue", "enqueue(JZZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(Long r5, Boolean r6, Boolean r7) {
        invoke(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long r3, boolean r5, boolean r6) {
        c.a((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.memorydata.plugin"), r3, r5, r6);
    }
}
