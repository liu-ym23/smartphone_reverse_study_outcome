package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.hc;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/PhotoFaceRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawPhotoFaceEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PhotoFaceRawDbDao extends IAppEntityRawDbDao<hc> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(PhotoFaceRawDbDao r8, long r9, long r11, long r13, String r15) {
            PhotoFaceRawDbDao r10 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(PhotoFaceRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(PhotoFaceRawDbDao r2, List<Long> r3) {
            PhotoFaceRawDbDao r4 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(PhotoFaceRawDbDao r2, String r3) {
            PhotoFaceRawDbDao r4 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(PhotoFaceRawDbDao r6, String r7, long r8, long r10) {
            PhotoFaceRawDbDao r9 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(PhotoFaceRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(PhotoFaceRawDbDao r6, String r7, long r8, long r10) {
            PhotoFaceRawDbDao r9 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(PhotoFaceRawDbDao r2, String r3) {
            PhotoFaceRawDbDao r4 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(PhotoFaceRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PhotoFaceRawDbDao r2) {
            PhotoFaceRawDbDao r3 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawPhotoFaceEntity";
        }

        public static List<hc> queryAll(PhotoFaceRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(PhotoFaceRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<hc> queryByEntityId(PhotoFaceRawDbDao r2, String r3, String r4) {
            PhotoFaceRawDbDao r5 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<hc> queryByEntityIdList(PhotoFaceRawDbDao r2, List<String> r3) {
            PhotoFaceRawDbDao r4 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<hc> queryByEntityIdListAndPackageName(PhotoFaceRawDbDao r2, List<String> r3, String r4) {
            PhotoFaceRawDbDao r5 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static hc queryById(PhotoFaceRawDbDao r2, long r3) {
            return (hc) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hc.class, "com.obric.memorydata.plugin");
        }

        public static List<hc> queryByIdAndTimestamp(PhotoFaceRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<hc> queryByIds(PhotoFaceRawDbDao r2, List<Long> r3) {
            PhotoFaceRawDbDao r4 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(PhotoFaceRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            PhotoFaceRawDbDao r7 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<hc> queryByPackageName(PhotoFaceRawDbDao r2, String r3) {
            PhotoFaceRawDbDao r4 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<hc> queryByPackageNameBeforeTimestampWithLimit(PhotoFaceRawDbDao r7, String r8, long r9, int r11, long r12) {
            PhotoFaceRawDbDao r10 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<hc> queryByPackageNameWithLimit(PhotoFaceRawDbDao r2, String r3, int r4, long r5) {
            PhotoFaceRawDbDao r6 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static hc queryByUUID(PhotoFaceRawDbDao r2, String r3) {
            PhotoFaceRawDbDao r4 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (hc) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), hc.class, "com.obric.memorydata.plugin");
        }

        public static hc queryOne(PhotoFaceRawDbDao r2) {
            return (hc) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), hc.class, "com.obric.memorydata.plugin");
        }

        public static List<hc> queryRecentByPackageName(PhotoFaceRawDbDao r2, String r3, long r4) {
            PhotoFaceRawDbDao r5 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<hc> queryWithLimitAndOffset(PhotoFaceRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(PhotoFaceRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            PhotoFaceRawDbDao r7 = (PhotoFaceRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, PhotoFaceRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
