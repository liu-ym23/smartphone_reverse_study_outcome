package com.obric.memorydata.database.index;

import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexDashboardPeriodicReporter$collectCoverage$unknownPolicyCount$1$1$1 extends FunctionReferenceImpl implements Function2<Integer, Long, List<? extends com.obric.memorydata.database.b>> {
    IndexDashboardPeriodicReporter$collectCoverage$unknownPolicyCount$1$1$1(Object r8) {
        super(2, r8, IAppEntityRawDbDao.class, "getEntitySimpleDataPaging", "getEntitySimpleDataPaging(IJ)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ List<? extends com.obric.memorydata.database.b> invoke(Integer r3, Long r4) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());
    }

    public final List<com.obric.memorydata.database.b> invoke(int r3, long r4) {
        return ((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(this.receiver, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")).getEntitySimpleDataPaging(r3, r4);
    }
}
