package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.at;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\nH'J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH'J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH'J0\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H'¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/dao/ContextAwarenessSubscriptionDao;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/ContextAwarenessSubscriptionEntity;", "listAll", "", "listByOwnerAndSubscription", "ownerPackage", "", "subscriptionId", "listByOwner", "deleteByOwnerAndSubscription", "", "deleteAllByOwner", "updateLastMatched", "targetType", "targetName", "matched", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ContextAwarenessSubscriptionDao {
    int deleteAllByOwner(String r1);

    int deleteByOwnerAndSubscription(String r1, String r2);

    long insert(at r1);

    List<at> listAll();

    List<at> listByOwner(String r1);

    List<at> listByOwnerAndSubscription(String r1, String r2);

    int updateLastMatched(String r1, String r2, String r3, String r4, boolean r5);
}
