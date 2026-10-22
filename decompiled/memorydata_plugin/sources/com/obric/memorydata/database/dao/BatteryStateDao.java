package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ae;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H'¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/dao/BatteryStateDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/BatteryStateEntity;", "getTableName", "", "queryLastRecord", "startTimeStamp", "", "endTimeStamp", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BatteryStateDao extends BaseDao<ae> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(BatteryStateDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(BatteryStateDao r2) {
            BatteryStateDao r3 = (BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin");
            return "RawBatteryState";
        }

        public static List<ae> queryAll(BatteryStateDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(BatteryStateDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ae queryById(BatteryStateDao r2, long r3) {
            return (ae) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ae.class, "com.obric.memorydata.plugin");
        }

        public static List<ae> queryByIds(BatteryStateDao r2, List<Long> r3) {
            BatteryStateDao r4 = (BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ae queryByUUID(BatteryStateDao r2, String r3) {
            BatteryStateDao r4 = (BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ae) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ae.class, "com.obric.memorydata.plugin");
        }

        public static ae queryOne(BatteryStateDao r2) {
            return (ae) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ae.class, "com.obric.memorydata.plugin");
        }

        public static List<ae> queryWithLimitAndOffset(BatteryStateDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((BatteryStateDao) ZeusTransformUtils.wrapperContextForParams(r2, BatteryStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    ae queryLastRecord(long r1, long r3);
}
