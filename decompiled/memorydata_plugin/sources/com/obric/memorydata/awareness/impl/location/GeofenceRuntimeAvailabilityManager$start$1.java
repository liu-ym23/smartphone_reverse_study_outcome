package com.obric.memorydata.awareness.impl.location;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class GeofenceRuntimeAvailabilityManager$start$1 extends FunctionReferenceImpl implements Function2<GeofenceRuntimeAvailabilityManager.e, String, Unit> {
    GeofenceRuntimeAvailabilityManager$start$1(Object r8) {
        super(2, r8, GeofenceRuntimeAvailabilityManager.class, "onEnvironmentChanged", "onEnvironmentChanged(Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentState;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(GeofenceRuntimeAvailabilityManager.e r3, String r4) {
        invoke2((GeofenceRuntimeAvailabilityManager.e) ZeusTransformUtils.preCheckCast(r3, GeofenceRuntimeAvailabilityManager.e.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GeofenceRuntimeAvailabilityManager.e r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        GeofenceRuntimeAvailabilityManager.a((GeofenceRuntimeAvailabilityManager) ZeusTransformUtils.preCheckCast(this.receiver, GeofenceRuntimeAvailabilityManager.class, "com.obric.memorydata.plugin"), r3, r4);
    }
}
