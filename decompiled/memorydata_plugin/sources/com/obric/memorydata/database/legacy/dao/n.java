package com.obric.memorydata.database.legacy.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.legacy.entity.BlockMemoryContentEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/dao/BlockMemoryContentDaoOld;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/legacy/entity/BlockMemoryContentEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface n extends BaseDao<BlockMemoryContentEntityOld> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static BlockMemoryContentEntityOld a(n r2, long r3) {
            return (BlockMemoryContentEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), BlockMemoryContentEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static BlockMemoryContentEntityOld a(n r2, String r3) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (BlockMemoryContentEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), BlockMemoryContentEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static String a(n r2) {
            n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            return "BlockMemoryContent";
        }

        public static List<BlockMemoryContentEntityOld> a(n r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<BlockMemoryContentEntityOld> a(n r2, List<Long> r3) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<BlockMemoryContentEntityOld> b(n r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(n r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(n r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static BlockMemoryContentEntityOld e(n r2) {
            return (BlockMemoryContentEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), BlockMemoryContentEntityOld.class, "com.obric.memorydata.plugin");
        }
    }
}
