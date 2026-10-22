package com.obric.memorydata.database.legacy.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.legacy.entity.MemoryBaseSceneEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\ba\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/dao/MemoryBaseSceneDaoOld;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/legacy/entity/MemoryBaseSceneEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface aa extends BaseDao<MemoryBaseSceneEntityOld> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static MemoryBaseSceneEntityOld a(aa r2, long r3) {
            return (MemoryBaseSceneEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryBaseSceneEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static MemoryBaseSceneEntityOld a(aa r2, String r3) {
            aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (MemoryBaseSceneEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryBaseSceneEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static String a(aa r2) {
            aa r3 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin");
            return "MemoryBaseScene";
        }

        public static List<MemoryBaseSceneEntityOld> a(aa r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<MemoryBaseSceneEntityOld> a(aa r2, List<Long> r3) {
            aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<MemoryBaseSceneEntityOld> b(aa r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(aa r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(aa r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static MemoryBaseSceneEntityOld e(aa r2) {
            return (MemoryBaseSceneEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), MemoryBaseSceneEntityOld.class, "com.obric.memorydata.plugin");
        }
    }
}
