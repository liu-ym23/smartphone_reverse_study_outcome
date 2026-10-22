package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.dc;
import com.obric.memorydata.database.entity.dd;
import com.obric.memorydata.database.entity.de;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H'J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH'J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH'J\u0016\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH'¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/dao/MemorySourceImageRelationDao;", "", "insertEpisodicRelation", "", "entity", "Lcom/obric/memorydata/database/entity/MemorySourceEpisodicImageRelationEntity;", "insertSemanticRelation", "Lcom/obric/memorydata/database/entity/MemorySourceSemanticImageRelationEntity;", "queryLatestStatusByHash", "Lcom/obric/memorydata/database/entity/MemorySourceImageStatus;", "sourceImageHash", "", "queryLatestStatusByHashes", "", "sourceImageHashes", "deleteEpisodicRelationsByMemoryIds", "", "episodicIds", "deleteSemanticRelationsByMemoryIds", "semanticIds", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemorySourceImageRelationDao {
    int deleteEpisodicRelationsByMemoryIds(List<String> r1);

    int deleteSemanticRelationsByMemoryIds(List<String> r1);

    long insertEpisodicRelation(dc r1);

    long insertSemanticRelation(de r1);

    dd queryLatestStatusByHash(String r1);

    List<dd> queryLatestStatusByHashes(List<String> r1);
}
