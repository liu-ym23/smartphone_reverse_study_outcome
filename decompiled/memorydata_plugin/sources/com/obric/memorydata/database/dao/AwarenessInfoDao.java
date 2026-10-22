package com.obric.memorydata.database.dao;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/AwarenessInfoDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/AwarenessInfoEntity;", "getTableName", "", "queryLatestByKey", "key", "deleteBeforeTimestamp", "", "before", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AwarenessInfoDao extends BaseDao<ac> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AwarenessInfoDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteBeforeTimestamp(AwarenessInfoDao r3, long r4) {
            return ((AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r3, AwarenessInfoDao.class, "com.obric.memorydata.plugin")).rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM AwarenessInfo WHERE timestamp < ?", new Long[]{Long.valueOf(r4)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AwarenessInfoDao r2) {
            AwarenessInfoDao r3 = (AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin");
            return "AwarenessInfo";
        }

        public static List<ac> queryAll(AwarenessInfoDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AwarenessInfoDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ac queryById(AwarenessInfoDao r2, long r3) {
            return (ac) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ac.class, "com.obric.memorydata.plugin");
        }

        public static List<ac> queryByIds(AwarenessInfoDao r2, List<Long> r3) {
            AwarenessInfoDao r4 = (AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ac queryByUUID(AwarenessInfoDao r2, String r3) {
            AwarenessInfoDao r4 = (AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ac) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ac.class, "com.obric.memorydata.plugin");
        }

        public static ac queryLatestByKey(AwarenessInfoDao r4, String r5) {
            AwarenessInfoDao r6 = (AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r4, AwarenessInfoDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "key");
            return (ac) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM AwarenessInfo WHERE `key` = ? ORDER BY timestamp DESC LIMIT 1", new String[]{r5}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), ac.class, "com.obric.memorydata.plugin");
        }

        public static ac queryOne(AwarenessInfoDao r2) {
            return (ac) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ac.class, "com.obric.memorydata.plugin");
        }

        public static List<ac> queryWithLimitAndOffset(AwarenessInfoDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AwarenessInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AwarenessInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteBeforeTimestamp(long r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    ac queryLatestByKey(String r1);
}
