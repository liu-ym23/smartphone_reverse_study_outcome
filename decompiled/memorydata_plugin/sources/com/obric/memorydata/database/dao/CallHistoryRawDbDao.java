package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.Ensure;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.fq;
import com.obric.memorydata.database.model.a;
import com.obric.memorydata.database.model.c;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016JJ\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J0\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001f\u001a\u00020 H'J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u001f\u001a\u00020 H'J.\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u001c\u0010%\u001a\u0004\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/dao/CallHistoryRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "getTableName", "", "queryOldDataForContentTimeIndexPending", "Landroid/database/Cursor;", "querySourceNumberBackfillCandidates", "", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberBackfillCandidate;", "lastRawDbId", "", "pageSize", "", "querySourceNumberContentCandidates", "Lcom/obric/memorydata/database/model/CallHistorySourceNumberContentCandidate;", "queryByRawDbId", "rawDbId", "debugCountRowsForSourceNumberBackfill", "debugQueryRowsByEntityIdForSourceNumberBackfill", "entityId", "updateSourceNumberForBackfill", ObricMemoryConstants.KEY_PACKAGE_NAME, "sourceNumber", "hashCodeValue", "expectedModifyTime", "expectedHash", "expectedTimestamp", "debugUpdateSourceNumberPostCasDonationForBackfill", "timestamp", "rawQuerySourceNumberBackfillCandidates", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "rawQuerySourceNumberContentCandidates", "getLastCallTimeStampByPhoneNumbers", "Lkotlin/Pair;", "phoneNumbers", "getLastCallTimeStampByPhoneNumber", "phoneNumber", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CallHistoryRawDbDao extends IAppEntityRawDbDao<fq> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(CallHistoryRawDbDao r8, long r9, long r11, long r13, String r15) {
            CallHistoryRawDbDao r10 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int debugCountRowsForSourceNumberBackfill(CallHistoryRawDbDao r4) {
            CallHistoryRawDbDao r5 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r5.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM " + r5.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
            Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r6, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
            int r2 = 0;
            if (r0.moveToFirst() == false) goto L6;
            r2 = r0.getInt(0);     // Catch: Throwable -> L8
        L6:
            CloseableKt.closeFinally(r6, null);
            return r2;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            CloseableKt.closeFinally(r6, th);
            throw th;
        }

        public static List<fq> debugQueryRowsByEntityIdForSourceNumberBackfill(CallHistoryRawDbDao r5, String r6) {
            CallHistoryRawDbDao r7 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r5, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityId");
            return r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE entityId = ? ORDER BY id ASC", new Object[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static int debugUpdateSourceNumberPostCasDonationForBackfill(CallHistoryRawDbDao r5, long r6, String r8, String r9, String r10, long r11) {
            CallHistoryRawDbDao r7 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r5, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "entityId");
            Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r10, "sourceNumber");
            Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r7.updateByRawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("UPDATE " + r7.getTableName() + " SET source_number = ?, timestamp = ? WHERE id = ? AND entityId = ? AND packageName = ? RETURNING 1", new Object[]{r10, Long.valueOf(r11), Long.valueOf(r6), r8, r9}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
            int r13 = ((Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin")).getCount();     // Catch: Throwable -> L6
            CloseableKt.closeFinally(r12, null);
            return r13;
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);
            throw th;
        }

        public static int deleteAll(CallHistoryRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(CallHistoryRawDbDao r2, List<Long> r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(CallHistoryRawDbDao r2, String r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(CallHistoryRawDbDao r6, String r7, long r8, long r10) {
            CallHistoryRawDbDao r9 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(CallHistoryRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(CallHistoryRawDbDao r6, String r7, long r8, long r10) {
            CallHistoryRawDbDao r9 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        private static Long getLastCallTimeStampByPhoneNumber(CallHistoryRawDbDao r11, String r12, String r13) {
            CallHistoryRawDbDao r14 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r11, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L10:
            if (r1 == false) goto L19;
            return null;
        L19:
            fq r15 = (fq) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r14.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r14.getTableName() + " WHERE packageName = ? AND (telephones LIKE ?) ORDER BY createTime desc Limit 1", new String[]{r13, "%\"" + r12 + "\"%"}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), fq.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
            if (r15 == null) goto L21;
            return Long.valueOf(r15.getCreateTime());
        L21:
            return null;
        L16:
            e = move-exception;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CallHistoryRawDbDao", "getLastCallTimeStampByPhoneNumber error: " + e.getMessage(), null, 4, null);
            Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "CallHistoryRawDbDao getLastCallTimeStampByPhoneNumber error");
            return null;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L10
        }

        public static Pair<String, Long> getLastCallTimeStampByPhoneNumbers(CallHistoryRawDbDao r6, List<String> r7, String r8) {
            CallHistoryRawDbDao r9 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            Object r2 = null;
            if (r1 == false) goto L12;
            return null;
        L12:
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r12 = r11.iterator();
        L14:
            if (r12.hasNext() == false) goto L21;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
            Long r5 = getLastCallTimeStampByPhoneNumber(r9, r4, r8);
            if (r5 == null) goto L18;
            Pair r13 = new Pair(r4, r5);
        L19:
            if (r13 == null) goto L14;
            r3.add(r13);
            goto L14
        L18:
            r13 = null;
            goto L19
        L21:
            Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            if (r14.hasNext() == false) goto L34;
            r2 = r14.next();
            if (r14.hasNext() == false) goto L34;
            long r15 = ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue();
        L28:
            Object r16 = r14.next();
            long r17 = ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r16, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue();
            if (r15 >= r17) goto L32;
            r2 = r16;
            r15 = r17;
        L32:
            if (r14.hasNext() == true) goto L28;
        L34:
            return (Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin");
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }

        public static long getLastModifyTimeByPackageName(CallHistoryRawDbDao r2, String r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(CallHistoryRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(CallHistoryRawDbDao r2) {
            CallHistoryRawDbDao r3 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawCallHistoryEntity";
        }

        public static List<fq> queryAll(CallHistoryRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(CallHistoryRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<fq> queryByEntityId(CallHistoryRawDbDao r2, String r3, String r4) {
            CallHistoryRawDbDao r5 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<fq> queryByEntityIdList(CallHistoryRawDbDao r2, List<String> r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<fq> queryByEntityIdListAndPackageName(CallHistoryRawDbDao r2, List<String> r3, String r4) {
            CallHistoryRawDbDao r5 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fq queryById(CallHistoryRawDbDao r2, long r3) {
            return (fq) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fq.class, "com.obric.memorydata.plugin");
        }

        public static List<fq> queryByIdAndTimestamp(CallHistoryRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<fq> queryByIds(CallHistoryRawDbDao r2, List<Long> r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(CallHistoryRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            CallHistoryRawDbDao r7 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<fq> queryByPackageName(CallHistoryRawDbDao r2, String r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<fq> queryByPackageNameBeforeTimestampWithLimit(CallHistoryRawDbDao r7, String r8, long r9, int r11, long r12) {
            CallHistoryRawDbDao r10 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<fq> queryByPackageNameWithLimit(CallHistoryRawDbDao r2, String r3, int r4, long r5) {
            CallHistoryRawDbDao r6 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static fq queryByRawDbId(CallHistoryRawDbDao r4, long r5) {
            CallHistoryRawDbDao r6 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return (fq) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE id = ? LIMIT 1", new Object[]{Long.valueOf(r5)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), fq.class, "com.obric.memorydata.plugin");
        }

        public static fq queryByUUID(CallHistoryRawDbDao r2, String r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fq) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fq.class, "com.obric.memorydata.plugin");
        }

        public static Cursor queryOldDataForContentTimeIndexPending(CallHistoryRawDbDao r3) {
            CallHistoryRawDbDao r4 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r3, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return r4.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT id,createTime,timestamp FROM " + r4.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static fq queryOne(CallHistoryRawDbDao r2) {
            return (fq) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), fq.class, "com.obric.memorydata.plugin");
        }

        public static List<fq> queryRecentByPackageName(CallHistoryRawDbDao r2, String r3, long r4) {
            CallHistoryRawDbDao r5 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<a> querySourceNumberBackfillCandidates(CallHistoryRawDbDao r4, long r5, int r7) {
            CallHistoryRawDbDao r6 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return r6.rawQuerySourceNumberBackfillCandidates((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT id AS rawDbId, entityId, packageName, modifyTime AS expectedModifyTime, hashCodeValue AS expectedHash, timestamp AS expectedTimestamp FROM " + r6.getTableName() + " WHERE source_number IS NULL AND id > ? ORDER BY id ASC LIMIT ?", new Object[]{Long.valueOf(r5), Integer.valueOf(r7)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.model.b> querySourceNumberContentCandidates(CallHistoryRawDbDao r4, long r5, int r7) {
            CallHistoryRawDbDao r6 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return r6.rawQuerySourceNumberContentCandidates((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT id AS rawDbId, entityId, packageName, timestamp AS expectedTimestamp FROM " + r6.getTableName() + " WHERE source_number IS NOT NULL AND id > ? ORDER BY id ASC LIMIT ?", new Object[]{Long.valueOf(r5), Integer.valueOf(r7)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static List<fq> queryWithLimitAndOffset(CallHistoryRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(CallHistoryRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            CallHistoryRawDbDao r7 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static int updateSourceNumberForBackfill(CallHistoryRawDbDao r9, long r10, String r12, String r13, String r14, int r15, long r16, int r18, long r19) {
            CallHistoryRawDbDao r2 = (CallHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r9, CallHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "entityId");
            Intrinsics.checkNotNullParameter(r13, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(r2.updateByRawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("UPDATE " + r2.getTableName() + " SET source_number = ?, hashCodeValue = ? WHERE id = ? AND entityId = ? AND packageName = ? AND source_number IS NULL AND modifyTime = ? AND hashCodeValue = ? AND timestamp = ? RETURNING 1", new Object[]{r14, Integer.valueOf(r15), Long.valueOf(r10), r12, r13, Long.valueOf(r16), Integer.valueOf(r18), Long.valueOf(r19)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
            int r0 = ((Cursor) ZeusTransformUtils.preCheckCast(r1, Cursor.class, "com.obric.memorydata.plugin")).getCount();     // Catch: Throwable -> L6
            CloseableKt.closeFinally(r1, null);
            return r0;
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            CloseableKt.closeFinally(r1, th);
            throw th;
        }
    }

    int debugCountRowsForSourceNumberBackfill();

    List<fq> debugQueryRowsByEntityIdForSourceNumberBackfill(String r1);

    int debugUpdateSourceNumberPostCasDonationForBackfill(long r1, String r3, String r4, String r5, long r6);

    Pair<String, Long> getLastCallTimeStampByPhoneNumbers(List<String> r1, String r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    fq queryByRawDbId(long r1);

    Cursor queryOldDataForContentTimeIndexPending();

    List<a> querySourceNumberBackfillCandidates(long r1, int r3);

    List<com.obric.memorydata.database.model.b> querySourceNumberContentCandidates(long r1, int r3);

    List<a> rawQuerySourceNumberBackfillCandidates(SupportSQLiteQuery r1);

    List<com.obric.memorydata.database.model.b> rawQuerySourceNumberContentCandidates(SupportSQLiteQuery r1);

    int updateSourceNumberForBackfill(long r1, String r3, String r4, String r5, int r6, long r7, int r9, long r10);
}
