package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ad;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/BatchChatDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/BatchChatEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BatchChatDao extends BaseDao<ad> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(BatchChatDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(BatchChatDao r2) {
            BatchChatDao r3 = (BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin");
            return "BatchChat";
        }

        public static List<ad> queryAll(BatchChatDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(BatchChatDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ad queryById(BatchChatDao r2, long r3) {
            return (ad) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ad.class, "com.obric.memorydata.plugin");
        }

        public static List<ad> queryByIds(BatchChatDao r2, List<Long> r3) {
            BatchChatDao r4 = (BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ad queryByUUID(BatchChatDao r2, String r3) {
            BatchChatDao r4 = (BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ad) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ad.class, "com.obric.memorydata.plugin");
        }

        public static ad queryOne(BatchChatDao r2) {
            return (ad) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ad.class, "com.obric.memorydata.plugin");
        }

        public static List<ad> queryWithLimitAndOffset(BatchChatDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((BatchChatDao) ZeusTransformUtils.wrapperContextForParams(r2, BatchChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
