package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ew;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H'J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH'¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveMemorySyncPendingDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/ProactiveMemorySyncPendingEntity;", "getTableName", "", "queryByTypeAndEntityId", "", "type", "", "entityId", "queryByTypeAndEntityIds", "queryByTypeAndStatus", "status", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveMemorySyncPendingDao extends BaseDao<ew> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(ProactiveMemorySyncPendingDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ProactiveMemorySyncPendingDao r2) {
            ProactiveMemorySyncPendingDao r3 = (ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin");
            return "ProactiveMemorySyncPending";
        }

        public static List<ew> queryAll(ProactiveMemorySyncPendingDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ProactiveMemorySyncPendingDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ew queryById(ProactiveMemorySyncPendingDao r2, long r3) {
            return (ew) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ew.class, "com.obric.memorydata.plugin");
        }

        public static List<ew> queryByIds(ProactiveMemorySyncPendingDao r2, List<Long> r3) {
            ProactiveMemorySyncPendingDao r4 = (ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ew queryByUUID(ProactiveMemorySyncPendingDao r2, String r3) {
            ProactiveMemorySyncPendingDao r4 = (ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ew) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ew.class, "com.obric.memorydata.plugin");
        }

        public static ew queryOne(ProactiveMemorySyncPendingDao r2) {
            return (ew) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ew.class, "com.obric.memorydata.plugin");
        }

        public static List<ew> queryWithLimitAndOffset(ProactiveMemorySyncPendingDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveMemorySyncPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveMemorySyncPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<ew> queryByTypeAndEntityId(int r1, String r2);

    List<ew> queryByTypeAndEntityIds(List<String> r1);

    List<ew> queryByTypeAndStatus(int r1, int r2);
}
