package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/BluetoothDeviceDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/BluetoothDeviceEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "queryLastRecords", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BluetoothDeviceDao extends BaseDao<af> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(BluetoothDeviceDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(BluetoothDeviceDao r2) {
            BluetoothDeviceDao r3 = (BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin");
            return "RawBluetoothDevice";
        }

        public static List<af> queryAll(BluetoothDeviceDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(BluetoothDeviceDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static af queryById(BluetoothDeviceDao r2, long r3) {
            return (af) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), af.class, "com.obric.memorydata.plugin");
        }

        public static List<af> queryByIds(BluetoothDeviceDao r2, List<Long> r3) {
            BluetoothDeviceDao r4 = (BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static af queryByUUID(BluetoothDeviceDao r2, String r3) {
            BluetoothDeviceDao r4 = (BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (af) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), af.class, "com.obric.memorydata.plugin");
        }

        public static af queryOne(BluetoothDeviceDao r2) {
            return (af) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), af.class, "com.obric.memorydata.plugin");
        }

        public static List<af> queryWithLimitAndOffset(BluetoothDeviceDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((BluetoothDeviceDao) ZeusTransformUtils.wrapperContextForParams(r2, BluetoothDeviceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    af queryLastRecords(long r1, long r3);

    List<af> queryRecords(long r1, long r3);
}
