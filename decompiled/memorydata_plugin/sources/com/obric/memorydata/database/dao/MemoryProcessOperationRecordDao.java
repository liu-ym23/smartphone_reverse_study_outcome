package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.cw;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\f\u001a\u00020\rH'¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryProcessOperationRecordDao;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryProcessOperationRecordEntity;", "insertAll", "", "entities", "queryByBusiness", "businessId", "", "limit", "", "queryRecent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryProcessOperationRecordDao {
    long insert(cw r1);

    List<Long> insertAll(List<cw> r1);

    List<cw> queryByBusiness(String r1, int r2);

    List<cw> queryRecent(int r1);
}
