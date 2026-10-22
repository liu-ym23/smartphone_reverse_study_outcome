package com.obric.memorydata.memory.review.provider;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0003H&J.\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00032\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0003H&J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;", "", "queryScreenEvidenceMap", "", "", "Lcom/obric/memorydata/memory/review/provider/RawObservationEvidence;", "rawObservationIdsByEntityId", "", "", "querySnapshotEvidenceMap", "rawObservationIdsBySnapshotId", "queryEvidence", "rawObservationIds", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface al {
    ay a(List<Long> r1);

    Map<String, ay> a(Map<String, ? extends List<Long>> r1);

    Map<Long, ay> b(Map<Long, ? extends List<Long>> r1);
}
