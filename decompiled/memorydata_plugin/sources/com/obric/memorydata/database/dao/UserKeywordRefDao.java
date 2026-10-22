package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.jd;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH'J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H'J\u001e\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000f\u001a\u00020\tH'¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/dao/UserKeywordRefDao;", "", "insertIfAbsent", "", "entity", "Lcom/obric/memorydata/database/entity/UserKeywordRefEntity;", "queryBySemanticEntityId", "", "semanticEntityId", "", "deleteBySemanticEntityIdAndKeywordIds", "", "keywordIds", "moveToKeeper", "mergedEntityIds", "keeperEntityId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UserKeywordRefDao {
    int deleteBySemanticEntityIdAndKeywordIds(String r1, List<Long> r2);

    long insertIfAbsent(jd r1);

    int moveToKeeper(List<String> r1, String r2);

    List<jd> queryBySemanticEntityId(String r1);
}
