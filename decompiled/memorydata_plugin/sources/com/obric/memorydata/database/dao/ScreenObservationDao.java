package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ScreenObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H'J\b\u0010\t\u001a\u00020\nH'J\b\u0010\u000b\u001a\u00020\nH'J\b\u0010\f\u001a\u00020\nH\u0017¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/dao/ScreenObservationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/ScreenObservationEntity;", "getTableName", "", "queryScreenshotPathsByIds", "", "ids", "", "clearTable", "", "resetSequence", "clearTableAndResetId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ScreenObservationDao extends BaseDao<ScreenObservationEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clearTableAndResetId(ScreenObservationDao r2) {
            ScreenObservationDao r3 = (ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin");
            r3.clearTable();
            r3.resetSequence();
        }

        public static int deleteAll(ScreenObservationDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ScreenObservationDao r2) {
            ScreenObservationDao r3 = (ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin");
            return "ScreenObservation";
        }

        public static List<ScreenObservationEntity> queryAll(ScreenObservationDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ScreenObservationDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ScreenObservationEntity queryById(ScreenObservationDao r2, long r3) {
            return (ScreenObservationEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ScreenObservationEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<ScreenObservationEntity> queryByIds(ScreenObservationDao r2, List<Long> r3) {
            ScreenObservationDao r4 = (ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ScreenObservationEntity queryByUUID(ScreenObservationDao r2, String r3) {
            ScreenObservationDao r4 = (ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ScreenObservationEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ScreenObservationEntity.class, "com.obric.memorydata.plugin");
        }

        public static ScreenObservationEntity queryOne(ScreenObservationDao r2) {
            return (ScreenObservationEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ScreenObservationEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<ScreenObservationEntity> queryWithLimitAndOffset(ScreenObservationDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ScreenObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    void clearTable();

    void clearTableAndResetId();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<String> queryScreenshotPathsByIds(List<Long> r1);

    void resetSequence();
}
