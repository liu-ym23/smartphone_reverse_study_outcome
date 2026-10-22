package com.obric.memorydata.database.dao;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.Ensure;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u001e\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH'J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH'J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH'J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H'J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H'J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H'J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH'J,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H'J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H'J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\nH'J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bH'J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J&\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H'J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H'J \u0010#\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H'J&\u0010$\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H'J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H'J\u001e\u0010&\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH'J\u0018\u0010'\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH'J\u0018\u0010)\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH'J0\u0010*\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010,\u001a\u00020\bH'J(\u0010-\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\bH'J&\u00100\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J6\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0004H\u0016J\u0016\u00107\u001a\u00020\b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J\u0010\u00109\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'¨\u0006:"}, d2 = {"Lcom/obric/memorydata/database/dao/IndexPendingDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "getTableName", "", "queryWithRawDb", "", "rawDbId", "", "entityType", "", "queryCountWithRawDb", "queryCountWithRawDbIds", "rawDbIds", "queryWithRawDbIds", "queryPendingRawDbIds", "queryWithRawDbIdsAndColumn", "column", "queryWithRawDbAndColumn", "queryWithId", "ids", "queryByIdAndTimestamp", OaidModel.KEY_ID, "timestamp", "queryByRawDbIdsAndBuildType", "buildType", "queryByEntityTypeAndBuildType", "queryUnhandledEntity", "queryUnhandledEntityWithLimit", "limitCount", "minId", "queryIndexed", "queryUnIndexedEntity", "queryByColumnContent", "queryCountByEntityTypeAndColumn", "deleteByColumnContent", "deleteAllByBuildType", "deleteAllByEntityTypeAndBuildType", "deleteAllByRawDbIds", "deleteByRawDb", "deleteById", "deleteByIdAndTimestamp", "deleteForExecutionSettlement", "expectedTimestamp", "expectedRoundId", "updateRetrySchedule", "retryCount", "nextRetryAt", "queryByRawDbIdListAndColumnContentSize", "columnContent", "setStateByRawDbIdListAndEntityType", "", "preState", "state", "excludeBuildType", "getCountByBuildTypeList", "buildTypes", "getCountByEntityType", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IndexPendingDao extends BaseDao<cd> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(IndexPendingDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(IndexPendingDao r2) {
            IndexPendingDao r3 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin");
            return "AppEntityIndexPending";
        }

        public static List<cd> queryAll(IndexPendingDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(IndexPendingDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static cd queryById(IndexPendingDao r2, long r3) {
            return (cd) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), cd.class, "com.obric.memorydata.plugin");
        }

        public static List<cd> queryByIds(IndexPendingDao r2, List<Long> r3) {
            IndexPendingDao r4 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static long queryByRawDbIdListAndColumnContentSize(IndexPendingDao r18, List<Long> r19, String r20, int r21) {
            IndexPendingDao r1 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r18, IndexPendingDao.class, "com.obric.memorydata.plugin");
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "rawDbIds");
            Intrinsics.checkNotNullParameter(r20, "columnContent");
            if (r3.isEmpty() == false) goto L18;
            return 0;
        L18:
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Iterator r5 = r4.iterator();     // Catch: Exception -> L15
        L7:
            if (r5.hasNext() == false) goto L9;
            ((Number) ZeusTransformUtils.preCheckCast(r5.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Exception -> L15
            r7.add("?");     // Catch: Exception -> L15
            goto L7
        L9:
            String r6 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: Exception -> L15
            Object[] r0 = ArraysKt.plus(new String[]{r20}, new String[]{String.valueOf(r21)});     // Catch: Exception -> L15
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Iterator r10 = r8.iterator();     // Catch: Exception -> L15
        L11:
            if (r10.hasNext() == false) goto L13;
            r9.add(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r10.next(), Number.class, "com.obric.memorydata.plugin")).longValue()));     // Catch: Exception -> L15
            goto L11
        L13:
            return r1.rawQueryForLong((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM AppEntityIndexPending WHERE columnContent = ? AND entityType = ? AND rawDbId in (" + r6 + ')', (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r0, ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        L15:
            e = move-exception;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IndexPendingDao", "queryByRawDbIdListAndColumnContentSize error: " + e.getMessage(), null, 4, null);
            Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "IndexPendingDao queryByRawDbIdListAndColumnContentSize error");
            return 0;
        }

        public static cd queryByUUID(IndexPendingDao r2, String r3) {
            IndexPendingDao r4 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cd) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), cd.class, "com.obric.memorydata.plugin");
        }

        public static cd queryOne(IndexPendingDao r2) {
            return (cd) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), cd.class, "com.obric.memorydata.plugin");
        }

        public static List<cd> queryWithLimitAndOffset(IndexPendingDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static void setStateByRawDbIdListAndEntityType(IndexPendingDao r16, int r17, int r18, List<Long> r19, int r20, String r21) {
            IndexPendingDao r1 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r16, IndexPendingDao.class, "com.obric.memorydata.plugin");
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "rawDbIds");
            Intrinsics.checkNotNullParameter(r21, "excludeBuildType");
            if (r3.isEmpty() == false) goto L18;
            return;
        L18:
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Iterator r6 = r4.iterator();     // Catch: Exception -> L15
        L7:
            if (r6.hasNext() == false) goto L9;
            ((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Exception -> L15
            r5.add("?");     // Catch: Exception -> L15
            goto L7
        L9:
            String r7 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: Exception -> L15
            String[] r8 = {String.valueOf(r20)};     // Catch: Exception -> L15
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            Iterator r11 = r9.iterator();     // Catch: Exception -> L15
        L11:
            if (r11.hasNext() == false) goto L13;
            r10.add(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).longValue()));     // Catch: Exception -> L15
            goto L11
        L13:
            r1.rawQueryForLong((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("UPDATE `AppEntityIndexPending` SET `state` = " + r18 + " WHERE state = " + r17 + " AND entityType = ? AND rawDbId in (" + r7 + ") AND buildType != '" + r21 + '\'', (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r8, ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IndexPendingDao", "setStateByRawDbIdListAndEntityType error: " + e.getMessage(), null, 4, null);
            Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "IndexPendingDao setStateByRawDbIdListAndEntityType error");
        }
    }

    int deleteAllByBuildType(List<Long> r1, int r2, String r3);

    int deleteAllByEntityTypeAndBuildType(int r1, String r2);

    int deleteAllByRawDbIds(List<Long> r1, int r2);

    int deleteByColumnContent(long r1, int r3, String r4);

    int deleteById(long r1);

    int deleteByIdAndTimestamp(long r1, long r3);

    int deleteByRawDb(long r1, int r3);

    int deleteForExecutionSettlement(long r1, long r3, long r5, int r7, long r8);

    long getCountByBuildTypeList(List<String> r1);

    long getCountByEntityType(int r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<cd> queryByColumnContent(long r1, int r3, String r4);

    List<cd> queryByEntityTypeAndBuildType(int r1, String r2);

    cd queryByIdAndTimestamp(long r1, long r3);

    long queryByRawDbIdListAndColumnContentSize(List<Long> r1, String r2, int r3);

    List<cd> queryByRawDbIdsAndBuildType(List<Long> r1, int r2, String r3);

    long queryCountByEntityTypeAndColumn(int r1, String r2);

    long queryCountWithRawDb(long r1, int r3);

    long queryCountWithRawDbIds(List<Long> r1, int r2);

    List<cd> queryIndexed(long r1, int r3);

    List<Long> queryPendingRawDbIds(List<Long> r1, int r2);

    List<cd> queryUnIndexedEntity();

    List<cd> queryUnhandledEntity();

    List<cd> queryUnhandledEntity(int r1);

    List<cd> queryUnhandledEntityWithLimit(int r1, int r2, long r3);

    List<cd> queryWithId(List<Long> r1);

    List<cd> queryWithRawDb(long r1, int r3);

    List<cd> queryWithRawDbAndColumn(long r1, int r3, String r4);

    List<cd> queryWithRawDbIds(List<Long> r1, int r2);

    List<cd> queryWithRawDbIdsAndColumn(List<Long> r1, int r2, String r3);

    void setStateByRawDbIdListAndEntityType(int r1, int r2, List<Long> r3, int r4, String r5);

    int updateRetrySchedule(long r1, long r3, int r5, long r6);
}
