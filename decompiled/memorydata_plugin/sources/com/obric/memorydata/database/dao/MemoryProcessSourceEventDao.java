package com.obric.memorydata.database.dao;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.cy;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H'J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH'J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH'J&\u0010\u0010\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H'J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryProcessSourceEventDao;", "", "insertIgnore", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryProcessSourceEventEntity;", "queryByEventIds", "", "eventIds", "", "queryPendingByBusiness", "businessId", "limit", "", "queryPendingByBusinessAndTrigger", "triggerMode", "updateState", "state", "updateTime", BuildConfig.CHANNEL, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryProcessSourceEventDao {
    long insertIgnore(cy r1);

    List<cy> queryByEventIds(List<String> r1);

    List<cy> queryPendingByBusiness(String r1, int r2);

    List<cy> queryPendingByBusinessAndTrigger(String r1, String r2, int r3);

    int update(cy r1);

    int updateState(List<String> r1, String r2, long r3);
}
