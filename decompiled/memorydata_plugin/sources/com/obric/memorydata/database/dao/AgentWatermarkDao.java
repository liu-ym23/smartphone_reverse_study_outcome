package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.AgentWatermarkEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/AgentWatermarkDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/AgentWatermarkEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AgentWatermarkDao extends BaseDao<AgentWatermarkEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AgentWatermarkDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AgentWatermarkDao r2) {
            AgentWatermarkDao r3 = (AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin");
            return "AgentWatermark";
        }

        public static List<AgentWatermarkEntity> queryAll(AgentWatermarkDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AgentWatermarkDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static AgentWatermarkEntity queryById(AgentWatermarkDao r2, long r3) {
            return (AgentWatermarkEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), AgentWatermarkEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AgentWatermarkEntity> queryByIds(AgentWatermarkDao r2, List<Long> r3) {
            AgentWatermarkDao r4 = (AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static AgentWatermarkEntity queryByUUID(AgentWatermarkDao r2, String r3) {
            AgentWatermarkDao r4 = (AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (AgentWatermarkEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), AgentWatermarkEntity.class, "com.obric.memorydata.plugin");
        }

        public static AgentWatermarkEntity queryOne(AgentWatermarkDao r2) {
            return (AgentWatermarkEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), AgentWatermarkEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AgentWatermarkEntity> queryWithLimitAndOffset(AgentWatermarkDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, AgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
