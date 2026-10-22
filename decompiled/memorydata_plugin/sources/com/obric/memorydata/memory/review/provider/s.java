package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/DaoCollectionMemoryReviewPageSource;", "Lcom/obric/memorydata/memory/review/provider/CollectionMemoryReviewPageSource;", "dao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;", "<init>", "(Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;)V", "queryPage", "", "Lcom/obric/memorydata/database/entity/EpisodicWithRelevantPojo;", "startTimeInclusive", "", "endTimeExclusive", "cursorTime", "cursorEntityId", "", "limit", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EpisodicMemoryDao f10469a;

    /* JADX WARN: Multi-variable type inference failed */
    public s() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public s(EpisodicMemoryDao r3) {
        EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r3, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dao");
        this.f10469a = r4;
    }

    public /* synthetic */ s(EpisodicMemoryDao r2, int r3, DefaultConstructorMarker r4) {
        EpisodicMemoryDao r5 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
    L5:
        this(r5);
    }

    @Override // com.obric.memorydata.memory.review.provider.o
    public List<bt> a(long r11, long r13, long r15, String r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "cursorEntityId");
        return this.f10469a.queryCollectionMemoryReviewPage(r11, r13, r15, r17, r18);
    }
}
