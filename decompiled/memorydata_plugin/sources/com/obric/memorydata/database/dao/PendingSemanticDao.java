package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.eg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/PendingSemanticDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/PendingSemantic;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PendingSemanticDao extends BaseDao<eg> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(PendingSemanticDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PendingSemanticDao r2) {
            PendingSemanticDao r3 = (PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin");
            return "PendingSemantic";
        }

        public static List<eg> queryAll(PendingSemanticDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(PendingSemanticDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static eg queryById(PendingSemanticDao r2, long r3) {
            return (eg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), eg.class, "com.obric.memorydata.plugin");
        }

        public static List<eg> queryByIds(PendingSemanticDao r2, List<Long> r3) {
            PendingSemanticDao r4 = (PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static eg queryByUUID(PendingSemanticDao r2, String r3) {
            PendingSemanticDao r4 = (PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (eg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), eg.class, "com.obric.memorydata.plugin");
        }

        public static eg queryOne(PendingSemanticDao r2) {
            return (eg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), eg.class, "com.obric.memorydata.plugin");
        }

        public static List<eg> queryWithLimitAndOffset(PendingSemanticDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((PendingSemanticDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingSemanticDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
