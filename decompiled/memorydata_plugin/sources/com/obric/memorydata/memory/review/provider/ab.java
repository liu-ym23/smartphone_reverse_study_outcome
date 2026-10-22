package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.db;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H&J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackLocalDataSource;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryReviewFeedbackEntity;", "queryByModulesAndRecords", "", "modules", "", "recordIds", "queryByModulesAndStatus", "status", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ab {
    List<db> a(List<String> r1, String r2);

    List<db> a(List<String> r1, List<String> r2);

    long insert(db r1);
}
