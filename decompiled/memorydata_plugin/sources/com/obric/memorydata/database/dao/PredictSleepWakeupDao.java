package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ep;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/dao/PredictSleepWakeupDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/PredictSleepWakeupEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PredictSleepWakeupDao extends BaseDao<ep> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(PredictSleepWakeupDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PredictSleepWakeupDao r2) {
            PredictSleepWakeupDao r3 = (PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin");
            return "predict_sleep_result";
        }

        public static List<ep> queryAll(PredictSleepWakeupDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(PredictSleepWakeupDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ep queryById(PredictSleepWakeupDao r2, long r3) {
            return (ep) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ep.class, "com.obric.memorydata.plugin");
        }

        public static List<ep> queryByIds(PredictSleepWakeupDao r2, List<Long> r3) {
            PredictSleepWakeupDao r4 = (PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ep queryByUUID(PredictSleepWakeupDao r2, String r3) {
            PredictSleepWakeupDao r4 = (PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ep) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ep.class, "com.obric.memorydata.plugin");
        }

        public static ep queryOne(PredictSleepWakeupDao r2) {
            return (ep) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ep.class, "com.obric.memorydata.plugin");
        }

        public static List<ep> queryWithLimitAndOffset(PredictSleepWakeupDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((PredictSleepWakeupDao) ZeusTransformUtils.wrapperContextForParams(r2, PredictSleepWakeupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<ep> queryRecords(long r1, long r3);
}
