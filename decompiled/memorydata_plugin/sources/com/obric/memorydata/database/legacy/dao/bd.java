package com.obric.memorydata.database.legacy.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/dao/UserProfileMemoryDaoOld;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/legacy/entity/UserProfileMemoryEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface bd extends BaseDao<com.obric.memorydata.database.legacy.entity.an> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static com.obric.memorydata.database.legacy.entity.an a(bd r2, long r3) {
            return (com.obric.memorydata.database.legacy.entity.an) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.entity.an.class, "com.obric.memorydata.plugin");
        }

        public static com.obric.memorydata.database.legacy.entity.an a(bd r2, String r3) {
            bd r4 = (bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.legacy.entity.an) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.entity.an.class, "com.obric.memorydata.plugin");
        }

        public static String a(bd r2) {
            bd r3 = (bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin");
            return "UserProfileMemoryEntity";
        }

        public static List<com.obric.memorydata.database.legacy.entity.an> a(bd r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.legacy.entity.an> a(bd r2, List<Long> r3) {
            bd r4 = (bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.legacy.entity.an> b(bd r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(bd r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(bd r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.entity.an e(bd r2) {
            return (com.obric.memorydata.database.legacy.entity.an) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((bd) ZeusTransformUtils.wrapperContextForParams(r2, bd.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.legacy.entity.an.class, "com.obric.memorydata.plugin");
        }
    }
}
