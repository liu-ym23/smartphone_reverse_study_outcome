package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.dao.UnionSemanticMemorySnapShotDao;
import com.obric.memorydata.database.entity.iu;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/DaoPersonalMemoryReviewPageSource;", "Lcom/obric/memorydata/memory/review/provider/PersonalMemoryReviewPageSource;", "dao", "Lcom/obric/memorydata/database/dao/UnionSemanticMemorySnapShotDao;", "<init>", "(Lcom/obric/memorydata/database/dao/UnionSemanticMemorySnapShotDao;)V", "queryPage", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemorySnapShotEntity;", "startTimeInclusive", "", "endTimeExclusive", "cursorSnapshotTime", "cursorId", "limit", "", "queryVersionWindow", "entityId", "", "currentVersion", "countVersionWindow", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UnionSemanticMemorySnapShotDao f10472a;

    /* JADX WARN: Multi-variable type inference failed */
    public v() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public v(UnionSemanticMemorySnapShotDao r3) {
        UnionSemanticMemorySnapShotDao r4 = (UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r3, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dao");
        this.f10472a = r4;
    }

    public /* synthetic */ v(UnionSemanticMemorySnapShotDao r2, int r3, DefaultConstructorMarker r4) {
        UnionSemanticMemorySnapShotDao r5 = (UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemorySnapShotDao();
    L5:
        this(r5);
    }

    @Override // com.obric.memorydata.memory.review.provider.aw
    public List<iu> a(long r11, long r13, long r15, long r17, int r19) {
        return this.f10472a.queryPageBeforeCursor(r11, r13, r15, r17, r19);
    }
}
