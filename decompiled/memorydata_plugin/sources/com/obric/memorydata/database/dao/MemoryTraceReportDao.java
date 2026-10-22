package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.dh;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0016\u0010\t\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H'J6\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\fH'J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH'J0\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0004H'J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0004H'J*\u0010!\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u0004H'J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0004H'J\u0016\u0010$\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH'J\u0018\u0010(\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\fH'J\b\u0010)\u001a\u00020\fH'J\b\u0010*\u001a\u00020\u000eH\u0016¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryTraceReportDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryTraceReportEntity;", "insert", "", "entity", "insertAll", "", "entities", "bulkInsert", "", "markTriggeredByLogId", "", "logId", "", "successStatus", "uploadingStatus", "triggerTime", "queryTriggeredPending", "pendingStatus", "pendingBeforeTime", "retryBeforeTime", "limit", "queryUnfinishedByLogId", "claimForUpload", OaidModel.KEY_ID, "expectedStatus", "expectedLastReportTime", "claimTime", "updateMergedTriggered", "reportData", "reportStatus", "lastReportTime", "updateReportResult", "lastError", "deleteById", "deleteByIds", "ids", "deleteOversizedReportData", "maxReportDataBytes", "deleteOversizedReportDataByLogId", "deleteAll", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryTraceReportDao extends BaseDao<dh> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(MemoryTraceReportDao r2) {
            MemoryTraceReportDao r3 = (MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin");
            return "MemoryTraceReport";
        }

        public static List<dh> queryAll(MemoryTraceReportDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryTraceReportDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static dh queryById(MemoryTraceReportDao r2, long r3) {
            return (dh) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), dh.class, "com.obric.memorydata.plugin");
        }

        public static List<dh> queryByIds(MemoryTraceReportDao r2, List<Long> r3) {
            MemoryTraceReportDao r4 = (MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static dh queryByUUID(MemoryTraceReportDao r2, String r3) {
            MemoryTraceReportDao r4 = (MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (dh) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), dh.class, "com.obric.memorydata.plugin");
        }

        public static dh queryOne(MemoryTraceReportDao r2) {
            return (dh) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), dh.class, "com.obric.memorydata.plugin");
        }

        public static List<dh> queryWithLimitAndOffset(MemoryTraceReportDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<dh> r1);

    int claimForUpload(long r1, String r3, long r4, String r6, long r7);

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    int deleteById(long r1);

    int deleteByIds(List<Long> r1);

    int deleteOversizedReportData(int r1);

    int deleteOversizedReportDataByLogId(String r1, int r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(dh r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<dh> r1);

    int markTriggeredByLogId(String r1, String r2, String r3, long r4);

    List<dh> queryTriggeredPending(String r1, String r2, long r3, long r5, int r7);

    List<dh> queryUnfinishedByLogId(String r1, String r2, String r3);

    int updateMergedTriggered(long r1, String r3, String r4, long r5);

    int updateReportResult(long r1, String r3, String r4, long r5);
}
