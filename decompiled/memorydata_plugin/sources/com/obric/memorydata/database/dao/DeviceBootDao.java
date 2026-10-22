package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ax;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/DeviceBootDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/DeviceBootEntity;", "getTableName", "", "queryLatestRecord", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DeviceBootDao extends BaseDao<ax> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(DeviceBootDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(DeviceBootDao r2) {
            DeviceBootDao r3 = (DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin");
            return "RawDeviceBoot";
        }

        public static List<ax> queryAll(DeviceBootDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(DeviceBootDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ax queryById(DeviceBootDao r2, long r3) {
            return (ax) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ax.class, "com.obric.memorydata.plugin");
        }

        public static List<ax> queryByIds(DeviceBootDao r2, List<Long> r3) {
            DeviceBootDao r4 = (DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ax queryByUUID(DeviceBootDao r2, String r3) {
            DeviceBootDao r4 = (DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ax) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ax.class, "com.obric.memorydata.plugin");
        }

        public static ax queryOne(DeviceBootDao r2) {
            return (ax) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ax.class, "com.obric.memorydata.plugin");
        }

        public static List<ax> queryWithLimitAndOffset(DeviceBootDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((DeviceBootDao) ZeusTransformUtils.wrapperContextForParams(r2, DeviceBootDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    ax queryLatestRecord();
}
