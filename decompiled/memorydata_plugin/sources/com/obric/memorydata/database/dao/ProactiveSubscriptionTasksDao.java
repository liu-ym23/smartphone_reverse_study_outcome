package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.fc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\bH'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\r\u001a\u00020\bH'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\nH'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\bH'J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\nH'J&\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H'J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J,\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveSubscriptionTasksDao;", "", "upsert", "", "entity", "Lcom/obric/memorydata/database/entity/ProactiveSubscriptionTaskEntity;", "getById", "taskId", "", "listBySubscriptionId", "", "subscriptionId", "listByState", "taskState", "listAll", "listTaskIdsBySubscriptionId", "listTaskIdsBySourceTaskIds", "sourceTaskIds", "updateIsDeleteByTaskIds", "", "taskIds", "isDelete", "", "updated", "", "updateIsDeleteBySubscriptionId", "updateIsDeleteBySourceTaskIds", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveSubscriptionTasksDao {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static List<String> updateIsDeleteBySourceTaskIds(ProactiveSubscriptionTasksDao r2, List<String> r3, boolean r4, long r5) {
            ProactiveSubscriptionTasksDao r6 = (ProactiveSubscriptionTasksDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSubscriptionTasksDao.class, "com.obric.memorydata.plugin");
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "sourceTaskIds");
            if (r7.isEmpty() == true) goto L5;
            List<String> r8 = r6.listTaskIdsBySourceTaskIds(r7);
            if (r8.isEmpty() == true) goto L9;
            r6.updateIsDeleteByTaskIds(r8, r4, r5);
            return r8;
        L9:
            return CollectionsKt.emptyList();
        L5:
            return CollectionsKt.emptyList();
        }

        public static List<String> updateIsDeleteBySubscriptionId(ProactiveSubscriptionTasksDao r2, String r3, boolean r4, long r5) {
            ProactiveSubscriptionTasksDao r6 = (ProactiveSubscriptionTasksDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSubscriptionTasksDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "subscriptionId");
            List<String> r7 = r6.listTaskIdsBySubscriptionId(r3);
            if (r7.isEmpty() == true) goto L5;
            r6.updateIsDeleteByTaskIds(r7, r4, r5);
            return r7;
        L5:
            return CollectionsKt.emptyList();
        }
    }

    fc getById(String r1);

    List<fc> listAll();

    List<fc> listByState(String r1);

    List<fc> listBySubscriptionId(String r1);

    List<String> listTaskIdsBySourceTaskIds(List<String> r1);

    List<String> listTaskIdsBySubscriptionId(String r1);

    List<String> updateIsDeleteBySourceTaskIds(List<String> r1, boolean r2, long r3);

    List<String> updateIsDeleteBySubscriptionId(String r1, boolean r2, long r3);

    int updateIsDeleteByTaskIds(List<String> r1, boolean r2, long r3);

    void upsert(fc r1);
}
