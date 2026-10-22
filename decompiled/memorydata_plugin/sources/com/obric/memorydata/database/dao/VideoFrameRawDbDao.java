package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.entity.j;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\f\u001a\u00020\tH'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\f\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/dao/VideoFrameRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawVideoFrameEntity;", "Lcom/obric/memorydata/database/dao/AbstractVideoFrameRawDbDao;", "getTableName", "", "queryEntityIdsByPhotoEntityDbIdList", "", "photoDbIds", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "queryByPhotoEntityDbId", "photoEntityDbId", "featureTimeStamp", "queryAbstractVideoFrameEntity", "Lcom/obric/memorydata/database/entity/AbstractVideoFrameEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface VideoFrameRawDbDao extends AbstractVideoFrameRawDbDao, IAppEntityRawDbDao<hr> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(VideoFrameRawDbDao r8, long r9, long r11, long r13, String r15) {
            VideoFrameRawDbDao r10 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(VideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(VideoFrameRawDbDao r2, List<Long> r3) {
            VideoFrameRawDbDao r4 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(VideoFrameRawDbDao r2, String r3) {
            VideoFrameRawDbDao r4 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(VideoFrameRawDbDao r6, String r7, long r8, long r10) {
            VideoFrameRawDbDao r9 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(VideoFrameRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(VideoFrameRawDbDao r6, String r7, long r8, long r10) {
            VideoFrameRawDbDao r9 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(VideoFrameRawDbDao r2, String r3) {
            VideoFrameRawDbDao r4 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(VideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(VideoFrameRawDbDao r2) {
            VideoFrameRawDbDao r3 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawVideoFrameEntity";
        }

        public static List<j> queryAbstractVideoFrameEntity(VideoFrameRawDbDao r2, long r3) {
            return ((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin")).queryByPhotoEntityDbId(r3);
        }

        public static List<hr> queryAll(VideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(VideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<hr> queryByEntityId(VideoFrameRawDbDao r2, String r3, String r4) {
            VideoFrameRawDbDao r5 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<hr> queryByEntityIdList(VideoFrameRawDbDao r2, List<String> r3) {
            VideoFrameRawDbDao r4 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<hr> queryByEntityIdListAndPackageName(VideoFrameRawDbDao r2, List<String> r3, String r4) {
            VideoFrameRawDbDao r5 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static hr queryById(VideoFrameRawDbDao r2, long r3) {
            return (hr) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hr.class, "com.obric.memorydata.plugin");
        }

        public static List<hr> queryByIdAndTimestamp(VideoFrameRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<hr> queryByIds(VideoFrameRawDbDao r2, List<Long> r3) {
            VideoFrameRawDbDao r4 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(VideoFrameRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            VideoFrameRawDbDao r7 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<hr> queryByPackageName(VideoFrameRawDbDao r2, String r3) {
            VideoFrameRawDbDao r4 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<hr> queryByPackageNameBeforeTimestampWithLimit(VideoFrameRawDbDao r7, String r8, long r9, int r11, long r12) {
            VideoFrameRawDbDao r10 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<hr> queryByPackageNameWithLimit(VideoFrameRawDbDao r2, String r3, int r4, long r5) {
            VideoFrameRawDbDao r6 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static hr queryByUUID(VideoFrameRawDbDao r2, String r3) {
            VideoFrameRawDbDao r4 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (hr) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hr.class, "com.obric.memorydata.plugin");
        }

        public static List<String> queryEntityIdsByPhotoEntityDbIdList(VideoFrameRawDbDao r12, List<Long> r13, String r14) {
            VideoFrameRawDbDao r15 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r12, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "photoDbIds");
            Intrinsics.checkNotNullParameter(r14, ObricMemoryConstants.KEY_PACKAGE_NAME);
            if (r16.isEmpty() == true) goto L5;
            Cursor r17 = r15.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT entityId FROM RawVideoFrameEntity WHERE photoEntityDbId in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ") AND packageName = '" + r14 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            List<String> r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Closeable r19 = (Closeable) ZeusTransformUtils.preCheckCast(r17, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r19, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        L9:
            if (r0.moveToNext() == false) goto L11;
            String r1 = r0.getString(0);     // Catch: Throwable -> L14
            Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Throwable -> L14
            r18.add(r1);     // Catch: Throwable -> L14
            goto L9
        L11:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
            CloseableKt.closeFinally(r19, null);
            return r18;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            CloseableKt.closeFinally(r19, th);
            throw th;
        L5:
            return CollectionsKt.emptyList();
        }

        public static hr queryOne(VideoFrameRawDbDao r2) {
            return (hr) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), hr.class, "com.obric.memorydata.plugin");
        }

        public static List<hr> queryRecentByPackageName(VideoFrameRawDbDao r2, String r3, long r4) {
            VideoFrameRawDbDao r5 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<hr> queryWithLimitAndOffset(VideoFrameRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(VideoFrameRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            VideoFrameRawDbDao r7 = (VideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, VideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    @Override // com.obric.memorydata.database.dao.AbstractVideoFrameRawDbDao
    List<j> queryAbstractVideoFrameEntity(long r1);

    List<hr> queryByPhotoEntityDbId(long r1);

    List<hr> queryByPhotoEntityDbId(long r1, long r3);

    List<String> queryEntityIdsByPhotoEntityDbIdList(List<Long> r1, String r2);
}
