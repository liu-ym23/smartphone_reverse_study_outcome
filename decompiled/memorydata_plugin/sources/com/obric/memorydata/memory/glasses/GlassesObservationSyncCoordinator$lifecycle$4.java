package com.obric.memorydata.memory.glasses;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class GlassesObservationSyncCoordinator$lifecycle$4 extends FunctionReferenceImpl implements Function0<Unit> {
    GlassesObservationSyncCoordinator$lifecycle$4(Object r8) {
        super(0, r8, c.class, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cancel()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        c.a((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.memorydata.plugin"));
    }
}
