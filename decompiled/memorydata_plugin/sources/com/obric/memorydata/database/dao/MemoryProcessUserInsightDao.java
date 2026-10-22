package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.da;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\b\u0010\n\u001a\u00020\tH'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0016\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\b\u0010\u000e\u001a\u00020\tH'J\b\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryProcessUserInsightDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryProcessUserInsightEntity;", "insert", "", "entity", "queryUnprocessedForUnion", "", "limit", "", "countUnprocessedForUnion", "queryRecent", "markProcessedForUnion", "ids", "deleteAll", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryProcessUserInsightDao extends BaseDao<da> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(MemoryProcessUserInsightDao r2) {
            MemoryProcessUserInsightDao r3 = (MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin");
            return "MemoryProcessUserInsight";
        }

        public static List<da> queryAll(MemoryProcessUserInsightDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryProcessUserInsightDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static da queryById(MemoryProcessUserInsightDao r2, long r3) {
            return (da) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), da.class, "com.obric.memorydata.plugin");
        }

        public static List<da> queryByIds(MemoryProcessUserInsightDao r2, List<Long> r3) {
            MemoryProcessUserInsightDao r4 = (MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static da queryByUUID(MemoryProcessUserInsightDao r2, String r3) {
            MemoryProcessUserInsightDao r4 = (MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (da) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), da.class, "com.obric.memorydata.plugin");
        }

        public static da queryOne(MemoryProcessUserInsightDao r2) {
            return (da) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), da.class, "com.obric.memorydata.plugin");
        }

        public static List<da> queryWithLimitAndOffset(MemoryProcessUserInsightDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryProcessUserInsightDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryProcessUserInsightDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int countUnprocessedForUnion();

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(da r1);

    int markProcessedForUnion(List<Long> r1);

    List<da> queryRecent(int r1);

    List<da> queryUnprocessedForUnion(int r1);
}
