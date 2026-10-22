package com.obric.memorydata.database.dao;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.dl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H'J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH'J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u0004H'J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H'J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\bH'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH'J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH'J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u0004H'J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH'J\u001e\u0010\u001a\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J&\u0010\u001b\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u001c\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\r\u001a\u00020\u000eH'J\b\u0010\u001e\u001a\u00020\u000eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/dao/MetaFullContentKeywordCopilotDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MetaFullContentKeywordCopilotEntity;", "delete", "", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "queryByRawDbIdAndEntityType", "", "rawDbId", "", "entityType", "queryByRawDbIdAndEntityTypeAndUid", "uid", "", "queryByRawDbIdsAndEntityType", "rawDbIds", "queryByRawDbIdsAndEntityTypeAndUid", "queryLegacyRowsByEntityType", "queryLegacyRows", "queryRowsByUid", "queryIdsByUids", "uids", "queryIdsByEntityTypeAndUids", "queryRawDbIdsByEntityType", "queryRawDbIdsByEntityTypeAndUid", "deleteByRawDbIds", "deleteByRawDbIdsAndUid", "updateUidByIds", "ids", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MetaFullContentKeywordCopilotDao extends BaseDao<dl> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MetaFullContentKeywordCopilotDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(MetaFullContentKeywordCopilotDao r2, List<Long> r3, int r4) {
            MetaFullContentKeywordCopilotDao r5 = (MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin");
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            return r5.deleteByRawDbIdsAndUid(r6, r4, "");
        }

        public static int deleteByRawDbIdsAndUid(MetaFullContentKeywordCopilotDao r12, List<Long> r13, int r14, String r15) {
            MetaFullContentKeywordCopilotDao r16 = (MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r12, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin");
            List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r17, "rawDbIds");
            Intrinsics.checkNotNullParameter(r15, "uid");
            if (r17.isEmpty() == false) goto L6;
            return 0;
        L6:
            return r16.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r16.getTableName() + " WHERE (type = " + r14 + ") AND (uid = ?) AND (rawDbId IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + "))", new String[]{r15}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MetaFullContentKeywordCopilotDao r2) {
            MetaFullContentKeywordCopilotDao r3 = (MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin");
            return "MetaFullContentKeywordCopilot";
        }

        public static List<dl> queryAll(MetaFullContentKeywordCopilotDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MetaFullContentKeywordCopilotDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static dl queryById(MetaFullContentKeywordCopilotDao r2, long r3) {
            return (dl) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), dl.class, "com.obric.memorydata.plugin");
        }

        public static List<dl> queryByIds(MetaFullContentKeywordCopilotDao r2, List<Long> r3) {
            MetaFullContentKeywordCopilotDao r4 = (MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static dl queryByUUID(MetaFullContentKeywordCopilotDao r2, String r3) {
            MetaFullContentKeywordCopilotDao r4 = (MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (dl) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), dl.class, "com.obric.memorydata.plugin");
        }

        public static dl queryOne(MetaFullContentKeywordCopilotDao r2) {
            return (dl) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), dl.class, "com.obric.memorydata.plugin");
        }

        public static List<dl> queryWithLimitAndOffset(MetaFullContentKeywordCopilotDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MetaFullContentKeywordCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaFullContentKeywordCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int delete(SupportSQLiteQuery r1);

    int deleteByRawDbIds(List<Long> r1, int r2);

    int deleteByRawDbIdsAndUid(List<Long> r1, int r2, String r3);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<dl> queryByRawDbIdAndEntityType(long r1, int r3);

    List<dl> queryByRawDbIdAndEntityTypeAndUid(long r1, int r3, String r4);

    List<dl> queryByRawDbIdsAndEntityType(List<Long> r1, int r2);

    List<dl> queryByRawDbIdsAndEntityTypeAndUid(List<Long> r1, int r2, String r3);

    List<Long> queryIdsByEntityTypeAndUids(int r1, List<String> r2);

    List<Long> queryIdsByUids(List<String> r1);

    List<dl> queryLegacyRows();

    List<dl> queryLegacyRowsByEntityType(int r1);

    List<Long> queryRawDbIdsByEntityType(int r1);

    List<Long> queryRawDbIdsByEntityTypeAndUid(int r1, String r2);

    List<dl> queryRowsByUid(String r1);

    int updateUidByIds(List<Long> r1, String r2);
}
