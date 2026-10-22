package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\bH'J4\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0013\u001a\u00020\u0014H'J:\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H'J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\bH'J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H'J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H'J\b\u0010\u001c\u001a\u00020\u0006H'J\u001e\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u001f\u001a\u00020\u0004H'J4\u0010 \u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\bH'J4\u0010$\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006H'J \u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H'J\u0012\u0010*\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u0014H'J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0004H'J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H'J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010/\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0006H'J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u00101\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0006H'J\b\u00102\u001a\u00020\u0006H'J\u000f\u00103\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0002\u00104¨\u00065"}, d2 = {"Lcom/obric/memorydata/database/dao/RawObservationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "getTableName", "", "deleteAll", "", "queryPendingWorkKeys", "", "Lcom/obric/memorydata/database/dao/WorkKey;", "queryPending", "deviceId", AILabCheckPermissionTask.KEY_SOURCE, "limit", "queryScreenshotPayloads", "observeOldestUnfinishedObservation", "Lkotlinx/coroutines/flow/Flow;", "sources", "terminalStates", "maxTimestamp", "", "observeUnfinishedObservationCount", "minTimeStamp", "queryScreenshotByIds", "ids", "queryFirstScreenshotInWindow", "minTimestamp", "queryScreenshotsInWindow", "queryPendingScreenshotCount", "markState", "", "state", "markClientStateForStates", "fromClientState", "toClientState", "fromStates", "markStateForStates", "toState", "errorCode", "markRetry", OaidModel.KEY_ID, "retryCount", "queryById", "updateMeta", "meta", "queryLatestGlassesForDebug", "queryGlassesBeforeIdForDebug", "beforeId", "queryGlassesAfterIdForDebug", "afterId", "countGlassesForDebug", "queryLatestGlassesTimestampForDebug", "()Ljava/lang/Long;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RawObservationDao extends BaseDao<RawObservationEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(RawObservationDao r2) {
            RawObservationDao r3 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin");
            return "RawObservation";
        }

        public static List<RawObservationEntity> queryAll(RawObservationDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(RawObservationDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<RawObservationEntity> queryByIds(RawObservationDao r2, List<Long> r3) {
            RawObservationDao r4 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static RawObservationEntity queryByUUID(RawObservationDao r2, String r3) {
            RawObservationDao r4 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (RawObservationEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), RawObservationEntity.class, "com.obric.memorydata.plugin");
        }

        public static RawObservationEntity queryOne(RawObservationDao r2) {
            return (RawObservationEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), RawObservationEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<RawObservationEntity> queryWithLimitAndOffset(RawObservationDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int countGlassesForDebug();

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    void markClientStateForStates(List<Long> r1, String r2, String r3, List<String> r4);

    void markRetry(long r1, int r3, int r4);

    void markState(List<Long> r1, String r2);

    void markStateForStates(List<Long> r1, List<String> r2, String r3, int r4);

    i<RawObservationEntity> observeOldestUnfinishedObservation(List<String> r1, List<String> r2, long r3);

    i<Integer> observeUnfinishedObservationCount(List<String> r1, List<String> r2, long r3, long r5);

    @Override // com.obric.memorydata.database.dao.BaseDao
    RawObservationEntity queryById(long r1);

    RawObservationEntity queryFirstScreenshotInWindow(long r1, long r3);

    List<RawObservationEntity> queryGlassesAfterIdForDebug(long r1, int r3);

    List<RawObservationEntity> queryGlassesBeforeIdForDebug(long r1, int r3);

    List<RawObservationEntity> queryLatestGlassesForDebug(int r1);

    Long queryLatestGlassesTimestampForDebug();

    List<RawObservationEntity> queryPending(String r1, String r2, int r3);

    int queryPendingScreenshotCount();

    List<WorkKey> queryPendingWorkKeys();

    List<RawObservationEntity> queryScreenshotByIds(List<Long> r1);

    List<String> queryScreenshotPayloads();

    List<RawObservationEntity> queryScreenshotsInWindow(long r1, long r3);

    int updateMeta(long r1, String r3);
}
