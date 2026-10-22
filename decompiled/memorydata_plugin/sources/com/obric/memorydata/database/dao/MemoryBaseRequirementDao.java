package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.MemoryBaseRequirementEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H'J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H'¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryBaseRequirementDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryBaseRequirementEntity;", "getTableName", "", "upsert", "", "entity", "markDelete", "", "requirementId", "updateTime", "markDeleteBySource", AILabCheckPermissionTask.KEY_SOURCE, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryBaseRequirementDao extends BaseDao<MemoryBaseRequirementEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MemoryBaseRequirementDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemoryBaseRequirementDao r2) {
            MemoryBaseRequirementDao r3 = (MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin");
            return "MemoryBaseRequirement";
        }

        public static List<MemoryBaseRequirementEntity> queryAll(MemoryBaseRequirementDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryBaseRequirementDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static MemoryBaseRequirementEntity queryById(MemoryBaseRequirementDao r2, long r3) {
            return (MemoryBaseRequirementEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryBaseRequirementEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<MemoryBaseRequirementEntity> queryByIds(MemoryBaseRequirementDao r2, List<Long> r3) {
            MemoryBaseRequirementDao r4 = (MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static MemoryBaseRequirementEntity queryByUUID(MemoryBaseRequirementDao r2, String r3) {
            MemoryBaseRequirementDao r4 = (MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (MemoryBaseRequirementEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryBaseRequirementEntity.class, "com.obric.memorydata.plugin");
        }

        public static MemoryBaseRequirementEntity queryOne(MemoryBaseRequirementDao r2) {
            return (MemoryBaseRequirementEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), MemoryBaseRequirementEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<MemoryBaseRequirementEntity> queryWithLimitAndOffset(MemoryBaseRequirementDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryBaseRequirementDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBaseRequirementDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    int markDelete(String r1, long r2);

    int markDeleteBySource(String r1, long r2);

    long upsert(MemoryBaseRequirementEntity r1);
}
