package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexDashboardPeriodicReporter$backlogTriggerRouter$2$2 extends FunctionReferenceImpl implements Function0<Unit> {
    IndexDashboardPeriodicReporter$backlogTriggerRouter$2$2(Object r8) {
        super(0, r8, ak.class, "scheduleDailyBacklog", "scheduleDailyBacklog()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ak.b((ak) ZeusTransformUtils.preCheckCast(this.receiver, ak.class, "com.obric.memorydata.plugin"));
    }
}
