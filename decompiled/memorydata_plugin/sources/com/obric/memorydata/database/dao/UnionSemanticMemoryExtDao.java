package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ir;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH'J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/UnionSemanticMemoryExtDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryExtEntity;", "insertOrReplace", "", "entity", "queryByMemoryId", "memoryId", "", "deleteByMemoryId", "", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UnionSemanticMemoryExtDao extends BaseDao<ir> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(UnionSemanticMemoryExtDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(UnionSemanticMemoryExtDao r2) {
            UnionSemanticMemoryExtDao r3 = (UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin");
            return "UnionSemanticMemoryExt";
        }

        public static List<ir> queryAll(UnionSemanticMemoryExtDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UnionSemanticMemoryExtDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ir queryById(UnionSemanticMemoryExtDao r2, long r3) {
            return (ir) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ir.class, "com.obric.memorydata.plugin");
        }

        public static List<ir> queryByIds(UnionSemanticMemoryExtDao r2, List<Long> r3) {
            UnionSemanticMemoryExtDao r4 = (UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ir queryByUUID(UnionSemanticMemoryExtDao r2, String r3) {
            UnionSemanticMemoryExtDao r4 = (UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ir) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ir.class, "com.obric.memorydata.plugin");
        }

        public static ir queryOne(UnionSemanticMemoryExtDao r2) {
            return (ir) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ir.class, "com.obric.memorydata.plugin");
        }

        public static List<ir> queryWithLimitAndOffset(UnionSemanticMemoryExtDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemoryExtDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemoryExtDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByMemoryId(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insertOrReplace(ir r1);

    ir queryByMemoryId(String r1);
}
