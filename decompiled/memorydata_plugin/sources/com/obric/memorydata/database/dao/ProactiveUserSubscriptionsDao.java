package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.fd;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH'¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveUserSubscriptionsDao;", "", "upsert", "", "entity", "Lcom/obric/memorydata/database/entity/ProactiveUserSubscriptionEntity;", "getById", "subscriptionId", "", "listAll", "", "listActive", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveUserSubscriptionsDao {
    fd getById(String r1);

    List<fd> listActive();

    List<fd> listAll();

    long upsert(fd r1);
}
