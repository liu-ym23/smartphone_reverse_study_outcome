package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.dq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/MovementStateDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MovementStateEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "queryLastRecord", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MovementStateDao extends BaseDao<dq> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MovementStateDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MovementStateDao r2) {
            MovementStateDao r3 = (MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin");
            return "RawMovementState";
        }

        public static List<dq> queryAll(MovementStateDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MovementStateDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static dq queryById(MovementStateDao r2, long r3) {
            return (dq) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), dq.class, "com.obric.memorydata.plugin");
        }

        public static List<dq> queryByIds(MovementStateDao r2, List<Long> r3) {
            MovementStateDao r4 = (MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static dq queryByUUID(MovementStateDao r2, String r3) {
            MovementStateDao r4 = (MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (dq) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), dq.class, "com.obric.memorydata.plugin");
        }

        public static dq queryOne(MovementStateDao r2) {
            return (dq) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), dq.class, "com.obric.memorydata.plugin");
        }

        public static List<dq> queryWithLimitAndOffset(MovementStateDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MovementStateDao) ZeusTransformUtils.wrapperContextForParams(r2, MovementStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    dq queryLastRecord();

    List<dq> queryRecords(long r1, long r3);
}
