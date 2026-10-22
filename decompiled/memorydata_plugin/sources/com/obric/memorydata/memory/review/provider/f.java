package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptDataSource;", "", "queryAudioMemory", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "recordId", "", "queryRawObservations", "", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "rawObservationIds", "", "queryAuditoryAudioUrl", "taskId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface f {
    EpisodicMemoryEntity a(String r1);

    List<RawObservationEntity> a(List<Long> r1);

    String b(String r1);
}
