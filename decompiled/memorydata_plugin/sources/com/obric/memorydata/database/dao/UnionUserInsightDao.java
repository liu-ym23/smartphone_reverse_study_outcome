package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.iw;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H'J\b\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/UnionUserInsightDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UnionUserInsightEntity;", "insert", "", "entity", "getLatest", "deleteAll", "", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UnionUserInsightDao extends BaseDao<iw> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(UnionUserInsightDao r2) {
            UnionUserInsightDao r3 = (UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin");
            return "UnionUserInsight";
        }

        public static List<iw> queryAll(UnionUserInsightDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UnionUserInsightDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static iw queryById(UnionUserInsightDao r2, long r3) {
            return (iw) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), iw.class, "com.obric.memorydata.plugin");
        }

        public static List<iw> queryByIds(UnionUserInsightDao r2, List<Long> r3) {
            UnionUserInsightDao r4 = (UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static iw queryByUUID(UnionUserInsightDao r2, String r3) {
            UnionUserInsightDao r4 = (UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (iw) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), iw.class, "com.obric.memorydata.plugin");
        }

        public static iw queryOne(UnionUserInsightDao r2) {
            return (iw) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), iw.class, "com.obric.memorydata.plugin");
        }

        public static List<iw> queryWithLimitAndOffset(UnionUserInsightDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UnionUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    iw getLatest();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(iw r1);
}
