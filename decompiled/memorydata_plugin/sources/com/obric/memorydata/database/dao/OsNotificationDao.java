package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ec;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/dao/OsNotificationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/OsNotificationEntity;", "getTableName", "", "queryLast5Records", "", "startTimeStamp", "", "endTimeStamp", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface OsNotificationDao extends BaseDao<ec> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(OsNotificationDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(OsNotificationDao r2) {
            OsNotificationDao r3 = (OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin");
            return "RawOsNotification";
        }

        public static List<ec> queryAll(OsNotificationDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(OsNotificationDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ec queryById(OsNotificationDao r2, long r3) {
            return (ec) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ec.class, "com.obric.memorydata.plugin");
        }

        public static List<ec> queryByIds(OsNotificationDao r2, List<Long> r3) {
            OsNotificationDao r4 = (OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ec queryByUUID(OsNotificationDao r2, String r3) {
            OsNotificationDao r4 = (OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ec) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ec.class, "com.obric.memorydata.plugin");
        }

        public static ec queryOne(OsNotificationDao r2) {
            return (ec) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ec.class, "com.obric.memorydata.plugin");
        }

        public static List<ec> queryWithLimitAndOffset(OsNotificationDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((OsNotificationDao) ZeusTransformUtils.wrapperContextForParams(r2, OsNotificationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<ec> queryLast5Records(long r1, long r3);
}
