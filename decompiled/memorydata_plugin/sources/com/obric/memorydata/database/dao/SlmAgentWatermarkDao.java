package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.SlmAgentWatermarkEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/SlmAgentWatermarkDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/SlmAgentWatermarkEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SlmAgentWatermarkDao extends BaseDao<SlmAgentWatermarkEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(SlmAgentWatermarkDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(SlmAgentWatermarkDao r2) {
            SlmAgentWatermarkDao r3 = (SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin");
            return "SlmAgentWatermark";
        }

        public static List<SlmAgentWatermarkEntity> queryAll(SlmAgentWatermarkDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(SlmAgentWatermarkDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static SlmAgentWatermarkEntity queryById(SlmAgentWatermarkDao r2, long r3) {
            return (SlmAgentWatermarkEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), SlmAgentWatermarkEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<SlmAgentWatermarkEntity> queryByIds(SlmAgentWatermarkDao r2, List<Long> r3) {
            SlmAgentWatermarkDao r4 = (SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static SlmAgentWatermarkEntity queryByUUID(SlmAgentWatermarkDao r2, String r3) {
            SlmAgentWatermarkDao r4 = (SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (SlmAgentWatermarkEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), SlmAgentWatermarkEntity.class, "com.obric.memorydata.plugin");
        }

        public static SlmAgentWatermarkEntity queryOne(SlmAgentWatermarkDao r2) {
            return (SlmAgentWatermarkEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), SlmAgentWatermarkEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<SlmAgentWatermarkEntity> queryWithLimitAndOffset(SlmAgentWatermarkDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((SlmAgentWatermarkDao) ZeusTransformUtils.wrapperContextForParams(r2, SlmAgentWatermarkDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
