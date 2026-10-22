package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ci;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/LightSensorDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/LightSensorEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "queryLastRecords", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LightSensorDao extends BaseDao<ci> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(LightSensorDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(LightSensorDao r2) {
            LightSensorDao r3 = (LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin");
            return "RawLightSensor";
        }

        public static List<ci> queryAll(LightSensorDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(LightSensorDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ci queryById(LightSensorDao r2, long r3) {
            return (ci) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ci.class, "com.obric.memorydata.plugin");
        }

        public static List<ci> queryByIds(LightSensorDao r2, List<Long> r3) {
            LightSensorDao r4 = (LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ci queryByUUID(LightSensorDao r2, String r3) {
            LightSensorDao r4 = (LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ci) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ci.class, "com.obric.memorydata.plugin");
        }

        public static ci queryOne(LightSensorDao r2) {
            return (ci) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ci.class, "com.obric.memorydata.plugin");
        }

        public static List<ci> queryWithLimitAndOffset(LightSensorDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((LightSensorDao) ZeusTransformUtils.wrapperContextForParams(r2, LightSensorDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    ci queryLastRecords(long r1, long r3);

    List<ci> queryRecords(long r1, long r3);
}
