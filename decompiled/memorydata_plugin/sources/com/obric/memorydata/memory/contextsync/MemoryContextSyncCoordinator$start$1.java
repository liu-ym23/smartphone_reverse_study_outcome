package com.obric.memorydata.memory.contextsync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryContextSyncCoordinator$start$1 extends FunctionReferenceImpl implements Function0<Unit> {
    MemoryContextSyncCoordinator$start$1(Object r8) {
        super(0, r8, f.class, "onProviderChanged", "onProviderChanged()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((f) ZeusTransformUtils.preCheckCast(this.receiver, f.class, "com.obric.memorydata.plugin")).b();
    }
}
