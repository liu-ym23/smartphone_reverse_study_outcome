package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.iu;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH&¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/PersonalMemoryReviewPageSource;", "", "queryPage", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemorySnapShotEntity;", "startTimeInclusive", "", "endTimeExclusive", "cursorSnapshotTime", "cursorId", "limit", "", "queryVersionWindow", "entityId", "", "currentVersion", "countVersionWindow", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface aw {
    List<iu> a(long r1, long r3, long r5, long r7, int r9);
}
