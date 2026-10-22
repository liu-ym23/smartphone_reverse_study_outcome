package com.obric.memorydata.database.dao;

import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.Ensure;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.i;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0016J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J(\u0010\u001a\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0016\u0010\u001b\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "Lcom/obric/memorydata/database/dao/BaseDao;", "delete", "", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "queryByRawDbId", "", "rawDbId", "", "isEmpty", "", "queryByRawDbIds", "rawDbIds", "queryByRawDbIdAndColumns", "columnSet", "", "", "deleteByRawDbId", "deleteByRawDbIdAndColumns", "", "deleteByRawDbIds", "deleteByRawDbIdAndType", "entityType", "deleteByRawDbIdAndTypeColumns", "buildColumnGroup", "queryByRawDbIdListAndColumnContent", "rawDbColumn", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppEntityVectorCopilotDao<T extends i> extends BaseDao<T> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends i> String buildColumnGroup(IAppEntityVectorCopilotDao<T> r4, Set<String> r5) {
            IAppEntityVectorCopilotDao r6 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "columnSet");
            StringBuilder r8 = new StringBuilder();
            r8.append('(');
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            boolean r0 = false;
        L4:
            if (r9.hasNext() == false) goto L9;
            String r2 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
            if (r0 == false) goto L8;
            r8.append(',');
        L8:
            r8.append('\'');
            r8.append(r2);
            r8.append('\'');
            r0 = true;
            goto L4
        L9:
            r8.append(')');
            String r10 = r8.toString();
            Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
            return r10;
        }

        public static <T extends i> int deleteAll(IAppEntityVectorCopilotDao<T> r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> int deleteByRawDbId(IAppEntityVectorCopilotDao<T> r3, long r4) {
            IAppEntityVectorCopilotDao r5 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return r5.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName() + " WHERE rawDbId = ?", new Object[]{Long.valueOf(r4)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> void deleteByRawDbIdAndColumns(IAppEntityVectorCopilotDao<T> r3, long r4, Set<String> r6) {
            IAppEntityVectorCopilotDao r5 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L7;
            r5.deleteByRawDbId(r4);
            return;
        L7:
            if (r7.isEmpty() == false) goto L9;
            return;
        L9:
            r5.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName() + " WHERE rawDbId = ? AND rawDbColumn in " + r5.buildColumnGroup(r7), new Long[]{Long.valueOf(r4)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> void deleteByRawDbIdAndType(IAppEntityVectorCopilotDao<T> r3, long r4, int r6) {
            IAppEntityVectorCopilotDao r5 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            r5.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName() + " WHERE rawDbId = ? AND entityType = ?", new Object[]{Long.valueOf(r4), Integer.valueOf(r6)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> void deleteByRawDbIdAndTypeColumns(IAppEntityVectorCopilotDao<T> r3, long r4, int r6, Set<String> r7) {
            IAppEntityVectorCopilotDao r5 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L7;
            r5.deleteByRawDbIdAndType(r4, r6);
            return;
        L7:
            if (r8.isEmpty() == false) goto L9;
            return;
        L9:
            r5.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName() + " WHERE rawDbId = ? AND rawDbColumn in " + r5.buildColumnGroup(r8) + " AND entityType = ?", new Object[]{Long.valueOf(r4), Integer.valueOf(r6)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> int deleteByRawDbIds(IAppEntityVectorCopilotDao<T> r11, List<Long> r12) {
            IAppEntityVectorCopilotDao r13 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r11, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "rawDbIds");
            if (r14.isEmpty() == false) goto L7;
            return 0;
        L7:
            return r13.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r13.getTableName() + " WHERE rawDbId IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> boolean isEmpty(IAppEntityVectorCopilotDao<T> r4) {
            IAppEntityVectorCopilotDao r5 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            if (r5.rawQueryForLong((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM " + r5.getTableName() + " LIMIT 1"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public static <T extends i> List<T> queryAll(IAppEntityVectorCopilotDao<T> r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> int queryAllCount(IAppEntityVectorCopilotDao<T> r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> T queryById(IAppEntityVectorCopilotDao<T> r2, long r3) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), i.class, "com.obric.memorydata.plugin");
        }

        public static <T extends i> List<T> queryByIds(IAppEntityVectorCopilotDao<T> r2, List<Long> r3) {
            IAppEntityVectorCopilotDao r4 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <T extends i> List<T> queryByRawDbId(IAppEntityVectorCopilotDao<T> r4, long r5) {
            IAppEntityVectorCopilotDao r6 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return (List<T>) r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE rawDbId = " + r5 + " ORDER BY id ASC"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> List<T> queryByRawDbIdAndColumns(IAppEntityVectorCopilotDao<T> r4, long r5, Set<String> r7) {
            IAppEntityVectorCopilotDao r6 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L7;
            return r6.queryByRawDbId(r5);
        L7:
            if (r8.isEmpty() == false) goto L11;
            return CollectionsKt.emptyList();
        L11:
            return (List<T>) r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE rawDbId = " + r5 + " AND rawDbColumn in " + r6.buildColumnGroup(r8) + " ORDER BY id ASC"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> List<T> queryByRawDbIdListAndColumnContent(IAppEntityVectorCopilotDao<T> r13, List<Long> r14, String r15) {
            IAppEntityVectorCopilotDao r16 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r13, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r17, "rawDbIds");
            Intrinsics.checkNotNullParameter(r15, "rawDbColumn");
            if (r17.isEmpty() == true) goto L5;
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
            Iterator r1 = r0.iterator();     // Catch: Exception -> L16
        L8:
            if (r1.hasNext() == false) goto L10;
            ((Number) ZeusTransformUtils.preCheckCast(r1.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Exception -> L16
            r2.add("?");     // Catch: Exception -> L16
            goto L8
        L10:
            String r3 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: Exception -> L16
            String[] r4 = {r15};     // Catch: Exception -> L16
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
            Iterator r110 = r18.iterator();     // Catch: Exception -> L16
        L12:
            if (r110.hasNext() == false) goto L14;
            r19.add(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r110.next(), Number.class, "com.obric.memorydata.plugin")).longValue()));     // Catch: Exception -> L16
            goto L12
        L14:
            return (List<T>) r16.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r16.getTableName() + " WHERE rawDbColumn = ? AND rawDbId in (" + r3 + ')', (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r4, ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        L16:
            e = move-exception;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IAppEntityVectorCopilotDao", "queryByRawDbIdListAndColumnContent error: " + e.getMessage(), null, 4, null);
            Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "IAppEntityVectorCopilotDao queryByRawDbIdListAndColumnContent error");
            return CollectionsKt.emptyList();
        L5:
            return CollectionsKt.emptyList();
        }

        public static <T extends i> List<T> queryByRawDbIds(IAppEntityVectorCopilotDao<T> r12, List<Long> r13) {
            IAppEntityVectorCopilotDao r14 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r12, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "rawDbIds");
            if (r15.isEmpty() == false) goto L7;
            return CollectionsKt.emptyList();
        L7:
            return (List<T>) r14.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r14.getTableName() + " WHERE rawDbId IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ") ORDER BY id ASC"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends i> T queryByUUID(IAppEntityVectorCopilotDao<T> r2, String r3) {
            IAppEntityVectorCopilotDao r4 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), i.class, "com.obric.memorydata.plugin");
        }

        public static <T extends i> T queryOne(IAppEntityVectorCopilotDao<T> r2) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), i.class, "com.obric.memorydata.plugin");
        }

        public static <T extends i> List<T> queryWithLimitAndOffset(IAppEntityVectorCopilotDao<T> r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    String buildColumnGroup(Set<String> r1);

    int delete(SupportSQLiteQuery r1);

    int deleteByRawDbId(long r1);

    void deleteByRawDbIdAndColumns(long r1, Set<String> r3);

    void deleteByRawDbIdAndType(long r1, int r3);

    void deleteByRawDbIdAndTypeColumns(long r1, int r3, Set<String> r4);

    int deleteByRawDbIds(List<Long> r1);

    boolean isEmpty();

    List<T> queryByRawDbId(long r1);

    List<T> queryByRawDbIdAndColumns(long r1, Set<String> r3);

    List<T> queryByRawDbIdListAndColumnContent(List<Long> r1, String r2);

    List<T> queryByRawDbIds(List<Long> r1);
}
