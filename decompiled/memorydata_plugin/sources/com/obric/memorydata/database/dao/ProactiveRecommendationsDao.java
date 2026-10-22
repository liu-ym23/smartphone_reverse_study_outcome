package com.obric.memorydata.database.dao;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ez;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\rH'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u000f2\u0006\u0010\f\u001a\u00020\rH'J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH'J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH'J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\rH'J*\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\rH'J \u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H'J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0018H'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u001c\u001a\u00020\tH'J \u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H'¨\u0006 "}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveRecommendationsDao;", "", "upsert", "", "entity", "Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", BuildConfig.CHANNEL, "getById", "recommendId", "", "listTopAll", "", "limit", "", "observeTopAll", "Lkotlinx/coroutines/flow/Flow;", "listTopByStatus", "status", "observeTopByStatus", "listTopByStatuses", "statuses", "observeTopByStatuses", "updateStatus", "updated", "", "updateActionExecuteInstruction", "actionExecuteInstruction", "listBySubscriptionId", "subscriptionId", "updateIsDeleteBySubscriptionId", "isDelete", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveRecommendationsDao {
    ez getById(String r1);

    List<ez> listBySubscriptionId(String r1);

    List<ez> listTopAll(int r1);

    List<ez> listTopByStatus(String r1, int r2);

    List<ez> listTopByStatuses(List<String> r1, int r2);

    i<List<ez>> observeTopAll(int r1);

    i<List<ez>> observeTopByStatus(String r1, int r2);

    i<List<ez>> observeTopByStatuses(List<String> r1, int r2);

    void update(ez r1);

    int updateActionExecuteInstruction(String r1, String r2, long r3);

    int updateIsDeleteBySubscriptionId(String r1, boolean r2, long r3);

    int updateStatus(String r1, String r2, long r3);

    void upsert(ez r1);
}
