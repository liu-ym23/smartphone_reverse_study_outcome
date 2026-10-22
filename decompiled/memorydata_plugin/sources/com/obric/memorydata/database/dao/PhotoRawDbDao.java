package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/PhotoRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawPhotoEntity;", "getTableName", "", "getAllImageNames", "", "queryByName", ActivityLifecycle.NAME, "getCountByAlbumId", "", "albumId", "queryLatestByAlbumId", "queryOldDataForContentTimeIndexPending", "Landroid/database/Cursor;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PhotoRawDbDao extends IAppEntityRawDbDao<hb> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(PhotoRawDbDao r8, long r9, long r11, long r13, String r15) {
            PhotoRawDbDao r10 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(PhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(PhotoRawDbDao r2, List<Long> r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByAlbumId(PhotoRawDbDao r6, String r7) {
            PhotoRawDbDao r8 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "albumId");
            return r8.getCount((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM RawPhotoEntity WHERE inAlbum = ? OR inAlbum LIKE ? OR inAlbum LIKE ? OR inAlbum LIKE ?", new String[]{'[' + r7 + ']', '[' + r7 + ", %", "%, " + r7 + ", %", "%, " + r7 + ']'}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static int getCountByPackageName(PhotoRawDbDao r2, String r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(PhotoRawDbDao r6, String r7, long r8, long r10) {
            PhotoRawDbDao r9 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(PhotoRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(PhotoRawDbDao r6, String r7, long r8, long r10) {
            PhotoRawDbDao r9 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(PhotoRawDbDao r2, String r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(PhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PhotoRawDbDao r2) {
            PhotoRawDbDao r3 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawPhotoEntity";
        }

        public static List<hb> queryAll(PhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(PhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<hb> queryByEntityId(PhotoRawDbDao r2, String r3, String r4) {
            PhotoRawDbDao r5 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<hb> queryByEntityIdList(PhotoRawDbDao r2, List<String> r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<hb> queryByEntityIdListAndPackageName(PhotoRawDbDao r2, List<String> r3, String r4) {
            PhotoRawDbDao r5 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static hb queryById(PhotoRawDbDao r2, long r3) {
            return (hb) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hb.class, "com.obric.memorydata.plugin");
        }

        public static List<hb> queryByIdAndTimestamp(PhotoRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<hb> queryByIds(PhotoRawDbDao r2, List<Long> r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(PhotoRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            PhotoRawDbDao r7 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<hb> queryByPackageName(PhotoRawDbDao r2, String r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<hb> queryByPackageNameBeforeTimestampWithLimit(PhotoRawDbDao r7, String r8, long r9, int r11, long r12) {
            PhotoRawDbDao r10 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<hb> queryByPackageNameWithLimit(PhotoRawDbDao r2, String r3, int r4, long r5) {
            PhotoRawDbDao r6 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static hb queryByUUID(PhotoRawDbDao r2, String r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (hb) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hb.class, "com.obric.memorydata.plugin");
        }

        public static hb queryLatestByAlbumId(PhotoRawDbDao r6, String r7) {
            PhotoRawDbDao r8 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "albumId");
            return (hb) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r8.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM RawPhotoEntity WHERE inAlbum = ? OR inAlbum LIKE ? OR inAlbum LIKE ? OR inAlbum LIKE ? ORDER BY createTime DESC LIMIT 1", new String[]{'[' + r7 + ']', '[' + r7 + ", %", "%, " + r7 + ", %", "%, " + r7 + ']'}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), hb.class, "com.obric.memorydata.plugin");
        }

        public static Cursor queryOldDataForContentTimeIndexPending(PhotoRawDbDao r3) {
            PhotoRawDbDao r4 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r3, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            return r4.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT id, createTime, timestamp FROM " + r4.getTableName() + " WHERE caption IS NOT NULL AND caption != ''"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static hb queryOne(PhotoRawDbDao r2) {
            return (hb) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), hb.class, "com.obric.memorydata.plugin");
        }

        public static List<hb> queryRecentByPackageName(PhotoRawDbDao r2, String r3, long r4) {
            PhotoRawDbDao r5 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<hb> queryWithLimitAndOffset(PhotoRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(PhotoRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            PhotoRawDbDao r7 = (PhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    List<String> getAllImageNames();

    int getCountByAlbumId(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<hb> queryByName(String r1);

    hb queryLatestByAlbumId(String r1);

    Cursor queryOldDataForContentTimeIndexPending();
}
