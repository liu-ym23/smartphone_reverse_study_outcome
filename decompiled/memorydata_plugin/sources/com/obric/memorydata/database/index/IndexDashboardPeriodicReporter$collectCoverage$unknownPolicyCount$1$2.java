package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexDashboardPeriodicReporter$collectCoverage$unknownPolicyCount$1$2 extends FunctionReferenceImpl implements Function1<List<? extends f>, Unit> {
    IndexDashboardPeriodicReporter$collectCoverage$unknownPolicyCount$1$2(Object r8) {
        super(1, r8, ae.class, "addPage", "addPage(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends f> r3) {
        invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<f> r3) {
        List<f> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "p0");
        ((ae) ZeusTransformUtils.preCheckCast(this.receiver, ae.class, "com.obric.memorydata.plugin")).a(r4);
    }
}
