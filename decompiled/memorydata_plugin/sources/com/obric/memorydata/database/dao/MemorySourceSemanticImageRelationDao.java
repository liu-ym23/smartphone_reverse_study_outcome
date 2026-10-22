package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.de;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0016\u0010\t\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/dao/MemorySourceSemanticImageRelationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemorySourceSemanticImageRelationEntity;", "insert", "", "entity", "insertAll", "", "entities", "bulkInsert", "", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemorySourceSemanticImageRelationDao extends BaseDao<de> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MemorySourceSemanticImageRelationDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemorySourceSemanticImageRelationDao r2) {
            MemorySourceSemanticImageRelationDao r3 = (MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin");
            return "MemorySourceSemanticImageRelation";
        }

        public static List<de> queryAll(MemorySourceSemanticImageRelationDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemorySourceSemanticImageRelationDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static de queryById(MemorySourceSemanticImageRelationDao r2, long r3) {
            return (de) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), de.class, "com.obric.memorydata.plugin");
        }

        public static List<de> queryByIds(MemorySourceSemanticImageRelationDao r2, List<Long> r3) {
            MemorySourceSemanticImageRelationDao r4 = (MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static de queryByUUID(MemorySourceSemanticImageRelationDao r2, String r3) {
            MemorySourceSemanticImageRelationDao r4 = (MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (de) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), de.class, "com.obric.memorydata.plugin");
        }

        public static de queryOne(MemorySourceSemanticImageRelationDao r2) {
            return (de) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), de.class, "com.obric.memorydata.plugin");
        }

        public static List<de> queryWithLimitAndOffset(MemorySourceSemanticImageRelationDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemorySourceSemanticImageRelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemorySourceSemanticImageRelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<de> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(de r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<de> r1);
}
