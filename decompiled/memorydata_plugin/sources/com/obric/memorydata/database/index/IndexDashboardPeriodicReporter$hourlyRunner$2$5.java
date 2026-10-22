package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexDashboardPeriodicReporter$hourlyRunner$2$5 extends FunctionReferenceImpl implements Function1<List<? extends h>, Boolean> {
    IndexDashboardPeriodicReporter$hourlyRunner$2$5(Object r8) {
        super(1, r8, ak.class, "reportCoverage", "reportCoverage(Ljava/util/List;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(List<h> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "p0");
        return Boolean.valueOf(ak.a((ak) ZeusTransformUtils.preCheckCast(this.receiver, ak.class, "com.obric.memorydata.plugin"), r4));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(List<? extends h> r3) {
        return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    }
}
