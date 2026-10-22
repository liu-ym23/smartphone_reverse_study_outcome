package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.dao.MemoryReviewFeedbackDao;
import com.obric.memorydata.database.entity.db;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/DaoMemoryReviewFeedbackLocalDataSource;", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackLocalDataSource;", "dao", "Lcom/obric/memorydata/database/dao/MemoryReviewFeedbackDao;", "<init>", "(Lcom/obric/memorydata/database/dao/MemoryReviewFeedbackDao;)V", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryReviewFeedbackEntity;", "queryByModulesAndRecords", "", "modules", "", "recordIds", "queryByModulesAndStatus", "status", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryReviewFeedbackDao f10470a;

    /* JADX WARN: Multi-variable type inference failed */
    public t() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public t(MemoryReviewFeedbackDao r3) {
        MemoryReviewFeedbackDao r4 = (MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r3, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dao");
        this.f10470a = r4;
    }

    public /* synthetic */ t(MemoryReviewFeedbackDao r2, int r3, DefaultConstructorMarker r4) {
        MemoryReviewFeedbackDao r5 = (MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryReviewFeedbackDao();
    L5:
        this(r5);
    }

    @Override // com.obric.memorydata.memory.review.provider.ab
    public List<db> a(List<String> r3, String r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "modules");
        Intrinsics.checkNotNullParameter(r4, "status");
        return this.f10470a.queryByModulesAndStatus(r5, r4);
    }

    @Override // com.obric.memorydata.memory.review.provider.ab
    public List<db> a(List<String> r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "modules");
        Intrinsics.checkNotNullParameter(r6, "recordIds");
        return this.f10470a.queryByModulesAndRecords(r5, r6);
    }

    @Override // com.obric.memorydata.memory.review.provider.ab
    public long insert(db r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return this.f10470a.insert(r2);
    }
}
