package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.f;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/IAppEntityRawFileTextDbDao;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "queryByParentEntityId", "", "parentEntityId", "", "queryEntityIdByParentEntityIds", "parentEntityIds", "deleteByParentId", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppEntityRawFileTextDbDao<T extends f> extends IAppEntityRawDbDao<T> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends f> int backfillContentHashIfAbsent(IAppEntityRawFileTextDbDao<T> r8, long r9, long r11, long r13, String r15) {
            IAppEntityRawFileTextDbDao r10 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r8, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static <T extends f> int deleteAll(IAppEntityRawFileTextDbDao<T> r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends f> int deleteByParentId(IAppEntityRawFileTextDbDao<T> r5, String r6) {
            IAppEntityRawFileTextDbDao r7 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r5, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "parentEntityId");
            return r7.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r7.getTableName() + " WHERE parentEntityId = ?", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends f> int deleteByRawDbIds(IAppEntityRawFileTextDbDao<T> r2, List<Long> r3) {
            IAppEntityRawFileTextDbDao r4 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <T extends f> int getCountByPackageName(IAppEntityRawFileTextDbDao<T> r2, String r3) {
            IAppEntityRawFileTextDbDao r4 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static <T extends f> int getCountByPackageNameWithTimeStamp(IAppEntityRawFileTextDbDao<T> r6, String r7, long r8, long r10) {
            IAppEntityRawFileTextDbDao r9 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r6, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static <T extends f> List<b> getEntitySimpleDataPaging(IAppEntityRawFileTextDbDao<T> r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static <T extends f> List<c> getHashCodeListByPackageNameWithTimeStamp(IAppEntityRawFileTextDbDao<T> r6, String r7, long r8, long r10) {
            IAppEntityRawFileTextDbDao r9 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r6, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static <T extends f> long getLastModifyTimeByPackageName(IAppEntityRawFileTextDbDao<T> r2, String r3) {
            IAppEntityRawFileTextDbDao r4 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static <T extends f> List<String> getPackageNameList(IAppEntityRawFileTextDbDao<T> r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: lambda$pSFgW-LzYoC9bS5M17NnBCGYXeg, reason: not valid java name */
        public static /* synthetic */ CharSequence m540lambda$pSFgWLzYoC9bS5M17NnBCGYXeg(String r0) {
            return queryEntityIdByParentEntityIds$lambda$0(r0);
        }

        public static <T extends f> List<T> queryAll(IAppEntityRawFileTextDbDao<T> r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends f> int queryAllCount(IAppEntityRawFileTextDbDao<T> r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends f> List<T> queryByEntityId(IAppEntityRawFileTextDbDao<T> r2, String r3, String r4) {
            IAppEntityRawFileTextDbDao r5 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static <T extends f> List<T> queryByEntityIdList(IAppEntityRawFileTextDbDao<T> r2, List<String> r3) {
            IAppEntityRawFileTextDbDao r4 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <T extends f> List<T> queryByEntityIdListAndPackageName(IAppEntityRawFileTextDbDao<T> r2, List<String> r3, String r4) {
            IAppEntityRawFileTextDbDao r5 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static <T extends f> T queryById(IAppEntityRawFileTextDbDao<T> r2, long r3) {
            return (T) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), f.class, "com.obric.memorydata.plugin");
        }

        public static <T extends f> List<T> queryByIdAndTimestamp(IAppEntityRawFileTextDbDao<T> r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static <T extends f> List<T> queryByIds(IAppEntityRawFileTextDbDao<T> r2, List<Long> r3) {
            IAppEntityRawFileTextDbDao r4 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <T extends f> Cursor queryByPackageName(IAppEntityRawFileTextDbDao<T> r2, String[] r3, String r4, int r5, Long r6) {
            IAppEntityRawFileTextDbDao r7 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static <T extends f> List<T> queryByPackageName(IAppEntityRawFileTextDbDao<T> r2, String r3) {
            IAppEntityRawFileTextDbDao r4 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static <T extends f> List<T> queryByPackageNameBeforeTimestampWithLimit(IAppEntityRawFileTextDbDao<T> r7, String r8, long r9, int r11, long r12) {
            IAppEntityRawFileTextDbDao r10 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r7, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static <T extends f> List<T> queryByPackageNameWithLimit(IAppEntityRawFileTextDbDao<T> r2, String r3, int r4, long r5) {
            IAppEntityRawFileTextDbDao r6 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static <T extends f> List<T> queryByParentEntityId(IAppEntityRawFileTextDbDao<T> r4, String r5) {
            IAppEntityRawFileTextDbDao r6 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "parentEntityId");
            return (List<T>) r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE parentEntityId = '" + r5 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends f> T queryByUUID(IAppEntityRawFileTextDbDao<T> r2, String r3) {
            IAppEntityRawFileTextDbDao r4 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (T) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), f.class, "com.obric.memorydata.plugin");
        }

        public static <T extends f> List<String> queryEntityIdByParentEntityIds(IAppEntityRawFileTextDbDao<T> r11, List<String> r12) {
            IAppEntityRawFileTextDbDao r13 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r11, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "parentEntityIds");
            if (r14.isEmpty() == true) goto L5;
            Cursor r15 = r13.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT entityId FROM " + r13.getTableName() + " WHERE parentEntityId IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$IAppEntityRawFileTextDbDao$DefaultImpls$pSFgWLzYoC9bS5M17NnBCGYXeg.INSTANCE, 24, null), ((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            List<String> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r17, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        L9:
            if (r1.moveToNext() == false) goto L11;
            String r2 = r1.getString(0);     // Catch: Throwable -> L14
            Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");     // Catch: Throwable -> L14
            r16.add(r2);     // Catch: Throwable -> L14
            goto L9
        L11:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
            CloseableKt.closeFinally(r17, null);
            return r16;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            CloseableKt.closeFinally(r17, th);
            throw th;
        L5:
            return CollectionsKt.emptyList();
        }

        private static CharSequence queryEntityIdByParentEntityIds$lambda$0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static <T extends f> T queryOne(IAppEntityRawFileTextDbDao<T> r2) {
            return (T) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), f.class, "com.obric.memorydata.plugin");
        }

        public static <T extends f> List<T> queryRecentByPackageName(IAppEntityRawFileTextDbDao<T> r2, String r3, long r4) {
            IAppEntityRawFileTextDbDao r5 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static <T extends f> List<T> queryWithLimitAndOffset(IAppEntityRawFileTextDbDao<T> r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static <T extends f> int updatePoisonLabelIfContentHashMatches(IAppEntityRawFileTextDbDao<T> r2, String r3, String r4, int r5, Integer r6) {
            IAppEntityRawFileTextDbDao r7 = (IAppEntityRawFileTextDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    int deleteByParentId(String r1);

    List<T> queryByParentEntityId(String r1);

    List<String> queryEntityIdByParentEntityIds(List<String> r1);
}
