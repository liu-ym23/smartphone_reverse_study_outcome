package com.obric.memorydata.database.dao;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.cz;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH'J \u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH'J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000eH'J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryProcessTriggerStateDao;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryProcessTriggerStateEntity;", "queryByStateId", "stateId", "", "queryByGroup", "businessId", "groupKey", "triggerMode", "countPendingSources", "", "queryByState", "", "state", "limit", BuildConfig.CHANNEL, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryProcessTriggerStateDao {
    int countPendingSources(String r1, String r2, String r3);

    long insert(cz r1);

    cz queryByGroup(String r1, String r2, String r3);

    List<cz> queryByState(String r1, int r2);

    cz queryByStateId(String r1);

    int update(cz r1);
}
