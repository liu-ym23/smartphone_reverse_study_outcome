package com.obric.memorydata.database.legacy.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryContentTimeDaoOld;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/legacy/entity/ShortMemoryContentTimeEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface p extends BaseDao<com.obric.memorydata.database.legacy.entity.ab> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static com.obric.memorydata.database.legacy.entity.ab a(p r2, long r3) {
            return (com.obric.memorydata.database.legacy.entity.ab) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.entity.ab.class, "com.obric.memorydata.plugin");
        }

        public static com.obric.memorydata.database.legacy.entity.ab a(p r2, String r3) {
            p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.legacy.entity.ab) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.entity.ab.class, "com.obric.memorydata.plugin");
        }

        public static String a(p r2) {
            p r3 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin");
            return "ShortMemoryContentTime";
        }

        public static List<com.obric.memorydata.database.legacy.entity.ab> a(p r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.legacy.entity.ab> a(p r2, List<Long> r3) {
            p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.legacy.entity.ab> b(p r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(p r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(p r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.entity.ab e(p r2) {
            return (com.obric.memorydata.database.legacy.entity.ab) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.legacy.entity.ab.class, "com.obric.memorydata.plugin");
        }
    }
}
