package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.iy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/dao/UpdateProactiveSemanticRelevantDataDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UpdateProactiveSemanticRelevantData;", "insert", "", "entity", "insertAll", "", "entities", "queryBySemanticId", "semanticId", "", "queryAll", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UpdateProactiveSemanticRelevantDataDao extends BaseDao<iy> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(UpdateProactiveSemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(UpdateProactiveSemanticRelevantDataDao r2) {
            UpdateProactiveSemanticRelevantDataDao r3 = (UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            return "UpdateProactiveSemanticRelevantData";
        }

        public static int queryAllCount(UpdateProactiveSemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static iy queryById(UpdateProactiveSemanticRelevantDataDao r2, long r3) {
            return (iy) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), iy.class, "com.obric.memorydata.plugin");
        }

        public static List<iy> queryByIds(UpdateProactiveSemanticRelevantDataDao r2, List<Long> r3) {
            UpdateProactiveSemanticRelevantDataDao r4 = (UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static iy queryByUUID(UpdateProactiveSemanticRelevantDataDao r2, String r3) {
            UpdateProactiveSemanticRelevantDataDao r4 = (UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (iy) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), iy.class, "com.obric.memorydata.plugin");
        }

        public static iy queryOne(UpdateProactiveSemanticRelevantDataDao r2) {
            return (iy) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), iy.class, "com.obric.memorydata.plugin");
        }

        public static List<iy> queryWithLimitAndOffset(UpdateProactiveSemanticRelevantDataDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UpdateProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UpdateProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(iy r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<iy> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<iy> queryAll();

    iy queryBySemanticId(String r1);
}
