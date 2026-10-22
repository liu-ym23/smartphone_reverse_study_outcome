package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.bt;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/CollectionMemoryReviewPageSource;", "", "queryPage", "", "Lcom/obric/memorydata/database/entity/EpisodicWithRelevantPojo;", "startTimeInclusive", "", "endTimeExclusive", "cursorTime", "cursorEntityId", "", "limit", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface o {
    List<bt> a(long r1, long r3, long r5, String r7, int r8);
}
