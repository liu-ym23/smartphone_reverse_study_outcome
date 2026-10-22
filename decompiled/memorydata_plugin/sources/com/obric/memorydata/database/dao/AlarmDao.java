package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.aw;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/dao/AlarmDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/DeviceAlarmEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AlarmDao extends BaseDao<aw> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AlarmDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AlarmDao r2) {
            AlarmDao r3 = (AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin");
            return "RawAlarm";
        }

        public static List<aw> queryAll(AlarmDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AlarmDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static aw queryById(AlarmDao r2, long r3) {
            return (aw) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), aw.class, "com.obric.memorydata.plugin");
        }

        public static List<aw> queryByIds(AlarmDao r2, List<Long> r3) {
            AlarmDao r4 = (AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static aw queryByUUID(AlarmDao r2, String r3) {
            AlarmDao r4 = (AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (aw) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), aw.class, "com.obric.memorydata.plugin");
        }

        public static aw queryOne(AlarmDao r2) {
            return (aw) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), aw.class, "com.obric.memorydata.plugin");
        }

        public static List<aw> queryWithLimitAndOffset(AlarmDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AlarmDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<aw> queryRecords(long r1, long r3);
}
