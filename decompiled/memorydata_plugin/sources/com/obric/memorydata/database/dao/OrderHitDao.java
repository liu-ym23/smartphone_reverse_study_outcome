package com.obric.memorydata.database.dao;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ea;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/OrderHitDao;", "", "insertOrder", "", "orderHitEntity", "Lcom/obric/memorydata/database/entity/OrderHitEntity;", "getOrder", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "orderType", "orderId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface OrderHitDao {
    ea getOrder(String r1, String r2, String r3);

    void insertOrder(ea r1);
}
