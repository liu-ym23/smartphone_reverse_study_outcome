package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.fv;
import com.obric.memorydata.database.entity.j;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/dao/CommonVideoFrameRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawCommonVideoFrameEntity;", "Lcom/obric/memorydata/database/dao/AbstractVideoFrameRawDbDao;", "getTableName", "", "queryByPhotoEntityDbId", "", "photoEntityDbId", "", "featureTimeStamp", "queryAbstractVideoFrameEntity", "Lcom/obric/memorydata/database/entity/AbstractVideoFrameEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CommonVideoFrameRawDbDao extends AbstractVideoFrameRawDbDao, IAppEntityRawDbDao<fv> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(CommonVideoFrameRawDbDao r8, long r9, long r11, long r13, String r15) {
            CommonVideoFrameRawDbDao r10 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(CommonVideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(CommonVideoFrameRawDbDao r2, List<Long> r3) {
            CommonVideoFrameRawDbDao r4 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(CommonVideoFrameRawDbDao r2, String r3) {
            CommonVideoFrameRawDbDao r4 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(CommonVideoFrameRawDbDao r6, String r7, long r8, long r10) {
            CommonVideoFrameRawDbDao r9 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(CommonVideoFrameRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(CommonVideoFrameRawDbDao r6, String r7, long r8, long r10) {
            CommonVideoFrameRawDbDao r9 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(CommonVideoFrameRawDbDao r2, String r3) {
            CommonVideoFrameRawDbDao r4 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(CommonVideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(CommonVideoFrameRawDbDao r2) {
            CommonVideoFrameRawDbDao r3 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawCommonVideoFrameEntity";
        }

        public static List<j> queryAbstractVideoFrameEntity(CommonVideoFrameRawDbDao r2, long r3) {
            return ((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin")).queryByPhotoEntityDbId(r3);
        }

        public static List<fv> queryAll(CommonVideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(CommonVideoFrameRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<fv> queryByEntityId(CommonVideoFrameRawDbDao r2, String r3, String r4) {
            CommonVideoFrameRawDbDao r5 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<fv> queryByEntityIdList(CommonVideoFrameRawDbDao r2, List<String> r3) {
            CommonVideoFrameRawDbDao r4 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<fv> queryByEntityIdListAndPackageName(CommonVideoFrameRawDbDao r2, List<String> r3, String r4) {
            CommonVideoFrameRawDbDao r5 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fv queryById(CommonVideoFrameRawDbDao r2, long r3) {
            return (fv) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fv.class, "com.obric.memorydata.plugin");
        }

        public static List<fv> queryByIdAndTimestamp(CommonVideoFrameRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<fv> queryByIds(CommonVideoFrameRawDbDao r2, List<Long> r3) {
            CommonVideoFrameRawDbDao r4 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(CommonVideoFrameRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            CommonVideoFrameRawDbDao r7 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<fv> queryByPackageName(CommonVideoFrameRawDbDao r2, String r3) {
            CommonVideoFrameRawDbDao r4 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<fv> queryByPackageNameBeforeTimestampWithLimit(CommonVideoFrameRawDbDao r7, String r8, long r9, int r11, long r12) {
            CommonVideoFrameRawDbDao r10 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<fv> queryByPackageNameWithLimit(CommonVideoFrameRawDbDao r2, String r3, int r4, long r5) {
            CommonVideoFrameRawDbDao r6 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static fv queryByUUID(CommonVideoFrameRawDbDao r2, String r3) {
            CommonVideoFrameRawDbDao r4 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fv) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fv.class, "com.obric.memorydata.plugin");
        }

        public static fv queryOne(CommonVideoFrameRawDbDao r2) {
            return (fv) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), fv.class, "com.obric.memorydata.plugin");
        }

        public static List<fv> queryRecentByPackageName(CommonVideoFrameRawDbDao r2, String r3, long r4) {
            CommonVideoFrameRawDbDao r5 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<fv> queryWithLimitAndOffset(CommonVideoFrameRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(CommonVideoFrameRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            CommonVideoFrameRawDbDao r7 = (CommonVideoFrameRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonVideoFrameRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    @Override // com.obric.memorydata.database.dao.AbstractVideoFrameRawDbDao
    List<j> queryAbstractVideoFrameEntity(long r1);

    List<fv> queryByPhotoEntityDbId(long r1);

    List<fv> queryByPhotoEntityDbId(long r1, long r3);
}
