package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ck;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H'¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/LocationAddressCacheDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/LocationAddressCacheEntity;", "getTableName", "", "queryValid", "latitudeE5", "", "longitudeE5", "localeTag", "resolverVersion", "now", "", "insertOrReplace", "entity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LocationAddressCacheDao extends BaseDao<ck> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(LocationAddressCacheDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(LocationAddressCacheDao r2) {
            LocationAddressCacheDao r3 = (LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin");
            return "LocationAddressCache";
        }

        public static List<ck> queryAll(LocationAddressCacheDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(LocationAddressCacheDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ck queryById(LocationAddressCacheDao r2, long r3) {
            return (ck) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ck.class, "com.obric.memorydata.plugin");
        }

        public static List<ck> queryByIds(LocationAddressCacheDao r2, List<Long> r3) {
            LocationAddressCacheDao r4 = (LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ck queryByUUID(LocationAddressCacheDao r2, String r3) {
            LocationAddressCacheDao r4 = (LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ck) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ck.class, "com.obric.memorydata.plugin");
        }

        public static ck queryOne(LocationAddressCacheDao r2) {
            return (ck) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ck.class, "com.obric.memorydata.plugin");
        }

        public static List<ck> queryWithLimitAndOffset(LocationAddressCacheDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((LocationAddressCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, LocationAddressCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insertOrReplace(ck r1);

    ck queryValid(int r1, int r2, String r3, int r4, long r5);
}
