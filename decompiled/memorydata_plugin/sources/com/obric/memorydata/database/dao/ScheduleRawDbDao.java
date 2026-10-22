package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.hl;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/ScheduleRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawScheduleEntity;", "queryByIcsId", "", "icsId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "queryByIcsIdList", "icsIdList", "queryScheduleIdsByIcsIdList", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ScheduleRawDbDao extends IAppEntityRawDbDao<hl> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(ScheduleRawDbDao r8, long r9, long r11, long r13, String r15) {
            ScheduleRawDbDao r10 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(ScheduleRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(ScheduleRawDbDao r2, List<Long> r3) {
            ScheduleRawDbDao r4 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(ScheduleRawDbDao r2, String r3) {
            ScheduleRawDbDao r4 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(ScheduleRawDbDao r6, String r7, long r8, long r10) {
            ScheduleRawDbDao r9 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(ScheduleRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(ScheduleRawDbDao r6, String r7, long r8, long r10) {
            ScheduleRawDbDao r9 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(ScheduleRawDbDao r2, String r3) {
            ScheduleRawDbDao r4 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(ScheduleRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ScheduleRawDbDao r2) {
            ScheduleRawDbDao r3 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawScheduleEntity";
        }

        public static List<hl> queryAll(ScheduleRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ScheduleRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<hl> queryByEntityId(ScheduleRawDbDao r2, String r3, String r4) {
            ScheduleRawDbDao r5 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<hl> queryByEntityIdList(ScheduleRawDbDao r2, List<String> r3) {
            ScheduleRawDbDao r4 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<hl> queryByEntityIdListAndPackageName(ScheduleRawDbDao r2, List<String> r3, String r4) {
            ScheduleRawDbDao r5 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<hl> queryByIcsId(ScheduleRawDbDao r4, String r5, String r6) {
            ScheduleRawDbDao r7 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "icsId");
            Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            return CollectionsKt.emptyList();
        L10:
            return r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM RawScheduleEntity WHERE icsId = '" + r5 + "' AND packageName = '" + r6 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        L5:
            r0 = false;
            goto L6
        }

        public static List<hl> queryByIcsIdList(ScheduleRawDbDao r17, List<String> r18, String r19) {
            ScheduleRawDbDao r1 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r17, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "icsIdList");
            Intrinsics.checkNotNullParameter(r19, ObricMemoryConstants.KEY_PACKAGE_NAME);
            if (r3.isEmpty() == true) goto L5;
            StringBuilder r4 = new StringBuilder().append("SELECT * FROM RawScheduleEntity WHERE icsId in (");
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L11;
            r6.add('\'' + ((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) + '\'');
            goto L8
        L11:
            return r1.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r4.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append(") AND packageName = '").append(r19).append('\'').toString()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        L5:
            return CollectionsKt.emptyList();
        }

        public static hl queryById(ScheduleRawDbDao r2, long r3) {
            return (hl) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hl.class, "com.obric.memorydata.plugin");
        }

        public static List<hl> queryByIdAndTimestamp(ScheduleRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<hl> queryByIds(ScheduleRawDbDao r2, List<Long> r3) {
            ScheduleRawDbDao r4 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(ScheduleRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            ScheduleRawDbDao r7 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<hl> queryByPackageName(ScheduleRawDbDao r2, String r3) {
            ScheduleRawDbDao r4 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<hl> queryByPackageNameBeforeTimestampWithLimit(ScheduleRawDbDao r7, String r8, long r9, int r11, long r12) {
            ScheduleRawDbDao r10 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<hl> queryByPackageNameWithLimit(ScheduleRawDbDao r2, String r3, int r4, long r5) {
            ScheduleRawDbDao r6 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static hl queryByUUID(ScheduleRawDbDao r2, String r3) {
            ScheduleRawDbDao r4 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (hl) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hl.class, "com.obric.memorydata.plugin");
        }

        public static hl queryOne(ScheduleRawDbDao r2) {
            return (hl) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), hl.class, "com.obric.memorydata.plugin");
        }

        public static List<hl> queryRecentByPackageName(ScheduleRawDbDao r2, String r3, long r4) {
            ScheduleRawDbDao r5 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<String> queryScheduleIdsByIcsIdList(ScheduleRawDbDao r17, List<String> r18, String r19) {
            ScheduleRawDbDao r1 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r17, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "icsIdList");
            Intrinsics.checkNotNullParameter(r19, ObricMemoryConstants.KEY_PACKAGE_NAME);
            if (r3.isEmpty() == true) goto L5;
            StringBuilder r4 = new StringBuilder().append("SELECT entityId FROM RawScheduleEntity WHERE icsId in (");
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            r6.add('\'' + ((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) + '\'');
            goto L8
        L10:
            Cursor r0 = r1.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r4.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append(") AND packageName = '").append(r19).append('\'').toString()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r9 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        L13:
            if (r9.moveToNext() == false) goto L15;
            String r10 = r9.getString(0);     // Catch: Throwable -> L18
            Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");     // Catch: Throwable -> L18
            r2.add(r10);     // Catch: Throwable -> L18
            goto L13
        L15:
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
            CloseableKt.closeFinally(r8, null);
            return r2;
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            CloseableKt.closeFinally(r8, th);
            throw th;
        L5:
            return CollectionsKt.emptyList();
        }

        public static List<hl> queryWithLimitAndOffset(ScheduleRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(ScheduleRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            ScheduleRawDbDao r7 = (ScheduleRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ScheduleRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<hl> queryByIcsId(String r1, String r2);

    List<hl> queryByIcsIdList(List<String> r1, String r2);

    List<String> queryScheduleIdsByIcsIdList(List<String> r1, String r2);
}
