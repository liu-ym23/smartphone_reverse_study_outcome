package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.dc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0016\u0010\t\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/dao/MemorySourceEpisodicImageRelationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemorySourceEpisodicImageRelationEntity;", "insert", "", "entity", "insertAll", "", "entities", "bulkInsert", "", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemorySourceEpisodicImageRelationDao extends BaseDao<dc> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MemorySourceEpisodicImageRelationDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemorySourceEpisodicImageRelationDao r2) {
            MemorySourceEpisodicImageRelationDao r3 = (MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin");
            return "MemorySourceEpisodicImageRelation";
        }

        public static List<dc> queryAll(MemorySourceEpisodicImageRelationDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemorySourceEpisodicImageRelationDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static dc queryById(MemorySourceEpisodicImageRelationDao r2, long r3) {
            return (dc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), dc.class, "com.obric.memorydata.plugin");
        }

        public static List<dc> queryByIds(MemorySourceEpisodicImageRelationDao r2, List<Long> r3) {
            MemorySourceEpisodicImageRelationDao r4 = (MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static dc queryByUUID(MemorySourceEpisodicImageRelationDao r2, String r3) {
            MemorySourceEpisodicImageRelationDao r4 = (MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (dc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), dc.class, "com.obric.memorydata.plugin");
        }

        public static dc queryOne(MemorySourceEpisodicImageRelationDao r2) {
            return (dc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), dc.class, "com.obric.memorydata.plugin");
        }

        public static List<dc> queryWithLimitAndOffset(MemorySourceEpisodicImageRelationDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceEpisodicImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceEpisodicImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<dc> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(dc r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<dc> r1);
}
