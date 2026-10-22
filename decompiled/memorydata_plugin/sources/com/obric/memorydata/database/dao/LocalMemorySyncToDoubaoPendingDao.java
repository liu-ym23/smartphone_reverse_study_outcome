package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.cj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H'J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H'¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/LocalMemorySyncToDoubaoPendingDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/LocalMemorySyncToDoubaoPendingEntity;", "getTableName", "", "queryByTypeAndEntityId", "", "type", "", "entityId", "queryByTypeAndEntityIds", "queryNeedToSyncPendingEntity", "earliestTimestamp", "", "currentUid", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LocalMemorySyncToDoubaoPendingDao extends BaseDao<cj> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(LocalMemorySyncToDoubaoPendingDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(LocalMemorySyncToDoubaoPendingDao r2) {
            LocalMemorySyncToDoubaoPendingDao r3 = (LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin");
            return "LocalMemorySyncToDoubaoPending";
        }

        public static List<cj> queryAll(LocalMemorySyncToDoubaoPendingDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(LocalMemorySyncToDoubaoPendingDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static cj queryById(LocalMemorySyncToDoubaoPendingDao r2, long r3) {
            return (cj) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), cj.class, "com.obric.memorydata.plugin");
        }

        public static List<cj> queryByIds(LocalMemorySyncToDoubaoPendingDao r2, List<Long> r3) {
            LocalMemorySyncToDoubaoPendingDao r4 = (LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cj queryByUUID(LocalMemorySyncToDoubaoPendingDao r2, String r3) {
            LocalMemorySyncToDoubaoPendingDao r4 = (LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cj) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), cj.class, "com.obric.memorydata.plugin");
        }

        public static cj queryOne(LocalMemorySyncToDoubaoPendingDao r2) {
            return (cj) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), cj.class, "com.obric.memorydata.plugin");
        }

        public static List<cj> queryWithLimitAndOffset(LocalMemorySyncToDoubaoPendingDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((LocalMemorySyncToDoubaoPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, LocalMemorySyncToDoubaoPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<cj> queryByTypeAndEntityId(int r1, String r2);

    List<cj> queryByTypeAndEntityIds(int r1, List<String> r2);

    List<cj> queryNeedToSyncPendingEntity(int r1, long r2, String r4);
}
