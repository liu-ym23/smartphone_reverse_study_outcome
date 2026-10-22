package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.iz;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\b\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H'J\b\u0010\u0014\u001a\u00020\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/dao/UpdateUnionSemanticMemoryDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UpdateUnionSemanticMemoryEntity;", "insert", "", "entity", "insertAll", "", "entities", "queryByEntityId", "entityId", "", "queryAll", "hasNotUpdatedData", "", "countNotUpdatedByEntityIds", "", "entityIds", "observeHasNotUpdatedData", "Lkotlinx/coroutines/flow/Flow;", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UpdateUnionSemanticMemoryDao extends BaseDao<iz> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(UpdateUnionSemanticMemoryDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(UpdateUnionSemanticMemoryDao r2) {
            UpdateUnionSemanticMemoryDao r3 = (UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin");
            return "UpdateUnionSemanticMemory";
        }

        public static int queryAllCount(UpdateUnionSemanticMemoryDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static iz queryById(UpdateUnionSemanticMemoryDao r2, long r3) {
            return (iz) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), iz.class, "com.obric.memorydata.plugin");
        }

        public static List<iz> queryByIds(UpdateUnionSemanticMemoryDao r2, List<Long> r3) {
            UpdateUnionSemanticMemoryDao r4 = (UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static iz queryByUUID(UpdateUnionSemanticMemoryDao r2, String r3) {
            UpdateUnionSemanticMemoryDao r4 = (UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (iz) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), iz.class, "com.obric.memorydata.plugin");
        }

        public static iz queryOne(UpdateUnionSemanticMemoryDao r2) {
            return (iz) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), iz.class, "com.obric.memorydata.plugin");
        }

        public static List<iz> queryWithLimitAndOffset(UpdateUnionSemanticMemoryDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UpdateUnionSemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateUnionSemanticMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int countNotUpdatedByEntityIds(List<String> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    boolean hasNotUpdatedData();

    long insert(iz r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<iz> r1);

    i<Boolean> observeHasNotUpdatedData();

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<iz> queryAll();

    iz queryByEntityId(String r1);
}
