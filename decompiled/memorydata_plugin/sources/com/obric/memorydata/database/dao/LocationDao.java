package com.obric.memorydata.database.dao;

import androidx.lifecycle.LiveData;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.cl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H'J\u0010\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH'J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH'J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/LocationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/LocationEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "queryLastRecord", "queryLastRecordLiveData", "Landroidx/lifecycle/LiveData;", "queryOnceRecordByEndTs", "queryFirstRecord", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LocationDao extends BaseDao<cl> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(LocationDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(LocationDao r2) {
            LocationDao r3 = (LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin");
            return "RawLocation";
        }

        public static List<cl> queryAll(LocationDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(LocationDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static cl queryById(LocationDao r2, long r3) {
            return (cl) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), cl.class, "com.obric.memorydata.plugin");
        }

        public static List<cl> queryByIds(LocationDao r2, List<Long> r3) {
            LocationDao r4 = (LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cl queryByUUID(LocationDao r2, String r3) {
            LocationDao r4 = (LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cl) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), cl.class, "com.obric.memorydata.plugin");
        }

        public static cl queryOne(LocationDao r2) {
            return (cl) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), cl.class, "com.obric.memorydata.plugin");
        }

        public static List<cl> queryWithLimitAndOffset(LocationDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((LocationDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    cl queryFirstRecord();

    cl queryLastRecord();

    cl queryLastRecord(long r1, long r3);

    LiveData<cl> queryLastRecordLiveData();

    cl queryOnceRecordByEndTs(long r1);

    List<cl> queryRecords(long r1, long r3);
}
