package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.db;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0016\u0010\t\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H'J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H'J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0014\u001a\u00020\rH'J\b\u0010\u0015\u001a\u00020\u0016H'J\b\u0010\u0017\u001a\u00020\rH\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryReviewFeedbackDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryReviewFeedbackEntity;", "insert", "", "entity", "insertAll", "", "entities", "bulkInsert", "", "queryByRecord", "module", "", "recordId", "queryByRecords", "recordIds", "queryByModulesAndRecords", "modules", "queryByModulesAndStatus", "status", "deleteAll", "", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryReviewFeedbackDao extends BaseDao<db> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(MemoryReviewFeedbackDao r2) {
            MemoryReviewFeedbackDao r3 = (MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin");
            return "MemoryReviewFeedback";
        }

        public static List<db> queryAll(MemoryReviewFeedbackDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryReviewFeedbackDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static db queryById(MemoryReviewFeedbackDao r2, long r3) {
            return (db) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), db.class, "com.obric.memorydata.plugin");
        }

        public static List<db> queryByIds(MemoryReviewFeedbackDao r2, List<Long> r3) {
            MemoryReviewFeedbackDao r4 = (MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static db queryByUUID(MemoryReviewFeedbackDao r2, String r3) {
            MemoryReviewFeedbackDao r4 = (MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (db) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), db.class, "com.obric.memorydata.plugin");
        }

        public static db queryOne(MemoryReviewFeedbackDao r2) {
            return (db) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), db.class, "com.obric.memorydata.plugin");
        }

        public static List<db> queryWithLimitAndOffset(MemoryReviewFeedbackDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryReviewFeedbackDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryReviewFeedbackDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<db> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(db r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<db> r1);

    List<db> queryByModulesAndRecords(List<String> r1, List<String> r2);

    List<db> queryByModulesAndStatus(List<String> r1, String r2);

    db queryByRecord(String r1, String r2);

    List<db> queryByRecords(String r1, List<String> r2);
}
