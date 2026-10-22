package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.model.c;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J7\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0017J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH'¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH'J/\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\"J(\u0010#\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010'\u001a\u00020\u00122\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u000bH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u000bH\u0016J.\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u000bH\u0016J \u00103\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bH\u0016J&\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bH\u0016J\u001e\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00052\u0006\u0010:\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u000bH\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00052\u0006\u0010\u0019\u001a\u00020\u001aH'¨\u0006;"}, d2 = {"Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "Lcom/obric/memorydata/database/dao/BaseDao;", "queryByEntityId", "", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "queryByIdAndTimestamp", OaidModel.KEY_ID, "", "timestamp", "queryByPackageName", "Landroid/database/Cursor;", "projection", "", "pageLimit", "", "lastQueryId", "([Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;)Landroid/database/Cursor;", "queryByEntityIdList", "entityIds", "queryByEntityIdListAndPackageName", "getMaxValue", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Ljava/lang/Long;", "delete", "updateByRawQuery", "updatePoisonLabelIfContentHashMatches", "contentHash", "poisonLabel", "poisonLabelVersion", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)I", "backfillContentHashIfAbsent", "expectedModifyTime", "expectedTimestamp", "getLastModifyTimeByPackageName", "deleteByRawDbIds", "rawDbIds", "getCount", "getCountByPackageName", "getPackageNameList", "queryRecentByPackageName", "lastModifiedTime", "queryByPackageNameWithLimit", "limit", "minDbId", "queryByPackageNameBeforeTimestampWithLimit", "cleanBeforeTimestamp", "getCountByPackageNameWithTimeStamp", "startTimeStamp", "endTimeStamp", "getHashCodeListByPackageNameWithTimeStamp", "Lcom/obric/memorydata/database/model/EntityHashCodeResult;", "getEntitySimpleDataPaging", "Lcom/obric/memorydata/database/SimpleEntityData;", "pageSize", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppEntityRawDbDao<T extends d> extends BaseDao<T> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends d> int backfillContentHashIfAbsent(IAppEntityRawDbDao<T> r5, long r6, long r8, long r10, String r12) {
            IAppEntityRawDbDao r7 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "contentHash");
            Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r7.updateByRawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("UPDATE " + r7.getTableName() + " SET content_hash = ? WHERE id = ? AND modifyTime = ? AND timestamp = ? AND (content_hash IS NULL OR content_hash = '') RETURNING 1", new Object[]{r12, Long.valueOf(r6), Long.valueOf(r8), Long.valueOf(r10)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
            int r11 = ((Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin")).getCount();     // Catch: Throwable -> L6
            CloseableKt.closeFinally(r9, null);
            return r11;
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            CloseableKt.closeFinally(r9, th);
            throw th;
        }

        public static <T extends d> int deleteAll(IAppEntityRawDbDao<T> r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> int deleteByRawDbIds(IAppEntityRawDbDao<T> r11, List<Long> r12) {
            IAppEntityRawDbDao r13 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r11, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "rawDbIds");
            if (r14.isEmpty() == false) goto L6;
            return 0;
        L6:
            String r15 = "DELETE FROM " + r13.getTableName() + " WHERE id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')';
            RunLog.INSTANCE.debug("IAppEntityRawDbDao", "queryString: " + r15);
            int r16 = r13.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r15), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            RunLog.INSTANCE.debug("IAppEntityRawDbDao", "it: " + r16);
            return r16;
        }

        public static <T extends d> int getCountByPackageName(IAppEntityRawDbDao<T> r3, String r4) {
            IAppEntityRawDbDao r5 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return r5.getCount((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM " + r5.getTableName() + " WHERE packageName = '" + r4 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> int getCountByPackageNameWithTimeStamp(IAppEntityRawDbDao<T> r3, String r4, long r5, long r7) {
            IAppEntityRawDbDao r6 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return r6.getCount((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM " + r6.getTableName() + " WHERE packageName = '" + r4 + "' AND modifyTime >= " + r5 + " AND modifyTime <= " + r7), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> List<b> getEntitySimpleDataPaging(IAppEntityRawDbDao<T> r10, int r11, long r12) {
            IAppEntityRawDbDao r13 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Cursor r14 = r13.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT id,timestamp,createTime FROM " + r13.getTableName() + " WHERE id > " + r12 + " ORDER BY id ASC LIMIT " + r11), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            List<b> r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r14, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r17 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            int r18 = r14.getColumnIndex(OaidModel.KEY_ID);     // Catch: Throwable -> L13
            int r0 = r14.getColumnIndex("timestamp");     // Catch: Throwable -> L13
            int r1 = r14.getColumnIndex("createTime");     // Catch: Throwable -> L13
            if (r18 < 0) goto L10;
            if (r0 < 0) goto L10;
            if (r1 < 0) goto L10;
        L8:
            if (r14.moveToNext() == false) goto L10;
            r15.add(new b(r14.getLong(r18), r14.getLong(r0), r14.getLong(r1)));     // Catch: Throwable -> L13
        L10:
            Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L13
            CloseableKt.closeFinally(r16, null);
            return r15;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r16, th);
            throw th;
        }

        public static <T extends d> List<c> getHashCodeListByPackageNameWithTimeStamp(IAppEntityRawDbDao<T> r4, String r5, long r6, long r8) {
            IAppEntityRawDbDao r7 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return r7.getHashCodeListByPackageNameWithTimeStamp((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT entityId,hashCodeValue FROM " + r7.getTableName() + " WHERE packageName = '" + r5 + "' AND modifyTime >= " + r6 + " AND modifyTime <= " + r8), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> long getLastModifyTimeByPackageName(IAppEntityRawDbDao<T> r3, String r4) {
            IAppEntityRawDbDao r5 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Long r6 = r5.getMaxValue((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT MAX(modifyTime) AS max_modifyTime FROM " + r5.getTableName() + " WHERE packageName = '" + r4 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            if (r6 != null) goto L7;
            return 0;
        L7:
            return r6.longValue();
        }

        public static <T extends d> List<String> getPackageNameList(IAppEntityRawDbDao<T> r6) {
            IAppEntityRawDbDao r7 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Cursor r8 = r7.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT DISTINCT packageName FROM " + r7.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            int r4 = r8.getColumnIndex(ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L19
            if (r4 >= 0) goto L6;
        L16:
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
            CloseableKt.closeFinally(r2, null);
            return r0;
        L6:
            if (r8.moveToNext() == false) goto L16;
            String r5 = r8.getString(r4);     // Catch: Throwable -> L19
            CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            if (r10 != null) goto L10;
        L13:
            boolean r11 = true;
        L14:
            if (r11 == true) goto L6;
            r0.add(r5);     // Catch: Throwable -> L19
            goto L6
        L10:
            if (r10.length() == 0) goto L13;
            r11 = false;
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            CloseableKt.closeFinally(r2, th);
            throw th;
        }

        public static /* synthetic */ CharSequence lambda$0cgV_ivHWY0B3lEvSwLj6M43zMU(String r0) {
            return queryByEntityIdListAndPackageName$lambda$1(r0);
        }

        /* JADX INFO: renamed from: lambda$kAbkz4-Lfr1sI_0RtrNEtGhc-fE, reason: not valid java name */
        public static /* synthetic */ CharSequence m539lambda$kAbkz4Lfr1sI_0RtrNEtGhcfE(String r0) {
            return queryByEntityIdList$lambda$0(r0);
        }

        public static <T extends d> List<T> queryAll(IAppEntityRawDbDao<T> r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> int queryAllCount(IAppEntityRawDbDao<T> r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> List<T> queryByEntityId(IAppEntityRawDbDao<T> r4, String r5, String r6) {
            IAppEntityRawDbDao r7 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityId");
            Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return (List<T>) r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE entityId = '" + r5 + "' AND packageName = '" + r6 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static <T extends d> List<T> queryByEntityIdList(IAppEntityRawDbDao<T> r11, List<String> r12) {
            IAppEntityRawDbDao r13 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r11, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "entityIds");
            return (List<T>) r13.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r13.getTableName() + " WHERE entityId IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$IAppEntityRawDbDao$DefaultImpls$kAbkz4Lfr1sI_0RtrNEtGhcfE.INSTANCE, 24, null), (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        private static CharSequence queryByEntityIdList$lambda$0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static <T extends d> List<T> queryByEntityIdListAndPackageName(IAppEntityRawDbDao<T> r11, List<String> r12, String r13) {
            IAppEntityRawDbDao r14 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r11, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "entityIds");
            Intrinsics.checkNotNullParameter(r13, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return (List<T>) r14.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r14.getTableName() + " WHERE (entityId IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$IAppEntityRawDbDao$DefaultImpls$0cgV_ivHWY0B3lEvSwLj6M43zMU.INSTANCE, 24, null) + ") AND packageName = '" + r13 + '\'', (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        private static CharSequence queryByEntityIdListAndPackageName$lambda$1(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static <T extends d> T queryById(IAppEntityRawDbDao<T> r2, long r3) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), d.class, "com.obric.memorydata.plugin");
        }

        public static <T extends d> List<T> queryByIdAndTimestamp(IAppEntityRawDbDao<T> r4, long r5, long r7) {
            IAppEntityRawDbDao r6 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            return (List<T>) r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE id = " + r5 + " AND timestamp = " + r7), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> List<T> queryByIds(IAppEntityRawDbDao<T> r2, List<Long> r3) {
            IAppEntityRawDbDao r4 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <T extends d> Cursor queryByPackageName(IAppEntityRawDbDao<T> r11, String[] r12, String r13, int r14, Long r15) {
            IAppEntityRawDbDao r16 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r11, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "projection");
            String r17 = ArraysKt.joinToString$default(r12, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
            String r0 = "";
            if (r13 != null) goto L5;
            String r18 = "";
        L6:
            boolean r2 = true;
            if (r15 != null) goto L10;
            String r19 = "";
        L18:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L20;
            boolean r4 = true;
        L21:
            if (r4 == true) goto L23;
        L28:
            r0 = "WHERE";
        L30:
            return r16.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT " + r17 + " FROM " + r16.getTableName() + ' ' + r0 + ' ' + r18 + ' ' + r19 + " ORDER BY id ASC LIMIT " + r14), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        L23:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L26;
            r2 = false;
        L26:
            if (r2 == false) goto L28;
        L20:
            r4 = false;
            goto L21
        L10:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
            boolean r5 = true;
        L13:
            if (r5 == false) goto L15;
            StringBuilder r6 = new StringBuilder();
            String r7 = "AND id > ";
        L16:
            r19 = r6.append(r7).append(r15).toString();
            goto L18
        L15:
            r6 = new StringBuilder();
            r7 = "id > ";
            goto L16
        L12:
            r5 = false;
            goto L13
        L5:
            r18 = "packageName = '" + r13 + '\'';
            goto L6
        }

        public static <T extends d> List<T> queryByPackageName(IAppEntityRawDbDao<T> r4, String r5) {
            IAppEntityRawDbDao r6 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return (List<T>) r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE packageName = '" + r5 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> List<T> queryByPackageNameBeforeTimestampWithLimit(IAppEntityRawDbDao<T> r5, String r6, long r7, int r9, long r10) {
            IAppEntityRawDbDao r8 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return (List<T>) r8.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r8.getTableName() + " WHERE packageName = ? AND timestamp <= ? AND id > ? ORDER BY id ASC LIMIT ?", new Object[]{r6, Long.valueOf(r7), Long.valueOf(r10), Integer.valueOf(r9)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> List<T> queryByPackageNameWithLimit(IAppEntityRawDbDao<T> r4, String r5, int r6, long r7) {
            IAppEntityRawDbDao r8 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return (List<T>) r8.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r8.getTableName() + " WHERE packageName = '" + r5 + "' AND id > " + r7 + " ORDER BY id ASC LIMIT " + r6), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> T queryByUUID(IAppEntityRawDbDao<T> r2, String r3) {
            IAppEntityRawDbDao r4 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), d.class, "com.obric.memorydata.plugin");
        }

        public static <T extends d> T queryOne(IAppEntityRawDbDao<T> r2) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), d.class, "com.obric.memorydata.plugin");
        }

        public static <T extends d> List<T> queryRecentByPackageName(IAppEntityRawDbDao<T> r4, String r5, long r6) {
            IAppEntityRawDbDao r7 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return (List<T>) r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE packageName = '" + r5 + "' AND modifyTime > " + r6), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends d> List<T> queryWithLimitAndOffset(IAppEntityRawDbDao<T> r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static <T extends d> int updatePoisonLabelIfContentHashMatches(IAppEntityRawDbDao<T> r5, String r6, String r7, int r8, Integer r9) {
            IAppEntityRawDbDao r10 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityId");
            Intrinsics.checkNotNullParameter(r7, "contentHash");
            Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r10.updateByRawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("UPDATE " + r10.getTableName() + " SET poison_label = ?, poison_label_version = ? WHERE entityId = ? AND content_hash = ? AND (poison_label_version IS NULL OR (? IS NOT NULL AND poison_label_version <= ?)) RETURNING 1", new Object[]{Integer.valueOf(r8), r9, r6, r7, r9, r9}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
            int r12 = ((Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin")).getCount();     // Catch: Throwable -> L6
            CloseableKt.closeFinally(r11, null);
            return r12;
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            CloseableKt.closeFinally(r11, th);
            throw th;
        }
    }

    int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7);

    int delete(SupportSQLiteQuery r1);

    int deleteByRawDbIds(List<Long> r1);

    int getCount(SupportSQLiteQuery r1);

    int getCountByPackageName(String r1);

    int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4);

    List<b> getEntitySimpleDataPaging(int r1, long r2);

    List<c> getHashCodeListByPackageNameWithTimeStamp(SupportSQLiteQuery r1);

    List<c> getHashCodeListByPackageNameWithTimeStamp(String r1, long r2, long r4);

    long getLastModifyTimeByPackageName(String r1);

    Long getMaxValue(SupportSQLiteQuery r1);

    List<String> getPackageNameList();

    List<T> queryByEntityId(String r1, String r2);

    @Deprecated(message = "use queryByEntityIdListAndPackageName")
    List<T> queryByEntityIdList(List<String> r1);

    List<T> queryByEntityIdListAndPackageName(List<String> r1, String r2);

    List<T> queryByIdAndTimestamp(long r1, long r3);

    Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4);

    List<T> queryByPackageName(String r1);

    List<T> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5);

    List<T> queryByPackageNameWithLimit(String r1, int r2, long r3);

    List<T> queryRecentByPackageName(String r1, long r2);

    Cursor updateByRawQuery(SupportSQLiteQuery r1);

    int updatePoisonLabelIfContentHashMatches(String r1, String r2, int r3, Integer r4);
}
