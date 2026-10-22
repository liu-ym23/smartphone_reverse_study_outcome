package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.bx;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/GeographyDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/GeographyEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface GeographyDao extends BaseDao<bx> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(GeographyDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(GeographyDao r2) {
            GeographyDao r3 = (GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin");
            return "RawGeography";
        }

        public static List<bx> queryAll(GeographyDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(GeographyDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static bx queryById(GeographyDao r2, long r3) {
            return (bx) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), bx.class, "com.obric.memorydata.plugin");
        }

        public static List<bx> queryByIds(GeographyDao r2, List<Long> r3) {
            GeographyDao r4 = (GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static bx queryByUUID(GeographyDao r2, String r3) {
            GeographyDao r4 = (GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bx) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), bx.class, "com.obric.memorydata.plugin");
        }

        public static bx queryOne(GeographyDao r2) {
            return (bx) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        }

        public static List<bx> queryWithLimitAndOffset(GeographyDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((GeographyDao) ZeusTransformUtils.wrapperContextForParams(r2, GeographyDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
