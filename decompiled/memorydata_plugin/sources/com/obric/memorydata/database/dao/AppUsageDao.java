package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/AppUsageDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/AppUsageEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "packageList", "queryLastRecord", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AppUsageDao extends BaseDao<n> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AppUsageDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AppUsageDao r2) {
            AppUsageDao r3 = (AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin");
            return "app_usage_info";
        }

        public static List<n> queryAll(AppUsageDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AppUsageDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static n queryById(AppUsageDao r2, long r3) {
            return (n) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), n.class, "com.obric.memorydata.plugin");
        }

        public static List<n> queryByIds(AppUsageDao r2, List<Long> r3) {
            AppUsageDao r4 = (AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static n queryByUUID(AppUsageDao r2, String r3) {
            AppUsageDao r4 = (AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (n) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), n.class, "com.obric.memorydata.plugin");
        }

        public static n queryOne(AppUsageDao r2) {
            return (n) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), n.class, "com.obric.memorydata.plugin");
        }

        public static List<n> queryWithLimitAndOffset(AppUsageDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AppUsageDao) ZeusTransformUtils.wrapperContextForParams(r2, AppUsageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    n queryLastRecord(long r1, long r3);

    List<n> queryRecords(long r1, long r3);

    List<n> queryRecords(List<String> r1, long r2, long r4);
}
