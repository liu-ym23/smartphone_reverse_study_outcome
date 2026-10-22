package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.iv;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH'J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\b\u0010\u0010\u001a\u00020\u0011H'J\b\u0010\u0012\u001a\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/database/dao/UnionSemanticTypeSummaryDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UnionSemanticTypeSummaryEntity;", "insert", "", "entity", "getLatest", "type", "", "treePath", "getAll", "", "getAllExcludeTypeOrderByCount", "excludeType", "deleteByTypeAndTreePath", "", "deleteAll", "", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UnionSemanticTypeSummaryDao extends BaseDao<iv> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(UnionSemanticTypeSummaryDao r2) {
            UnionSemanticTypeSummaryDao r3 = (UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin");
            return "UnionSemanticTypeSummary";
        }

        public static List<iv> queryAll(UnionSemanticTypeSummaryDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UnionSemanticTypeSummaryDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static iv queryById(UnionSemanticTypeSummaryDao r2, long r3) {
            return (iv) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), iv.class, "com.obric.memorydata.plugin");
        }

        public static List<iv> queryByIds(UnionSemanticTypeSummaryDao r2, List<Long> r3) {
            UnionSemanticTypeSummaryDao r4 = (UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static iv queryByUUID(UnionSemanticTypeSummaryDao r2, String r3) {
            UnionSemanticTypeSummaryDao r4 = (UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (iv) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), iv.class, "com.obric.memorydata.plugin");
        }

        public static iv queryOne(UnionSemanticTypeSummaryDao r2) {
            return (iv) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), iv.class, "com.obric.memorydata.plugin");
        }

        public static List<iv> queryWithLimitAndOffset(UnionSemanticTypeSummaryDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticTypeSummaryDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticTypeSummaryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    void deleteByTypeAndTreePath(String r1, String r2);

    List<iv> getAll();

    List<iv> getAllExcludeTypeOrderByCount(String r1);

    iv getLatest(String r1, String r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(iv r1);
}
