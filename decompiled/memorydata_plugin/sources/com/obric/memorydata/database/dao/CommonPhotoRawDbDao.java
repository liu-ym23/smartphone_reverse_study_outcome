package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.ft;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H'J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H'J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H'J\u001e\u0010\u000f\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0011\u001a\u00020\u0004H'¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/dao/CommonPhotoRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawCommonPhotoEntity;", "getTableName", "", "queryEntitiesByOriginalEntityAndColumn", "", "type", "", "entityId", "columnName", ObricMemoryConstants.KEY_PACKAGE_NAME, "queryEntitiesByOriginalEntity", "queryCaptionById", OaidModel.KEY_ID, "deleteByEntityIds", "deleteEntityIds", "deletePackageName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CommonPhotoRawDbDao extends IAppEntityRawDbDao<ft> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(CommonPhotoRawDbDao r8, long r9, long r11, long r13, String r15) {
            CommonPhotoRawDbDao r10 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(CommonPhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(CommonPhotoRawDbDao r2, List<Long> r3) {
            CommonPhotoRawDbDao r4 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(CommonPhotoRawDbDao r2, String r3) {
            CommonPhotoRawDbDao r4 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(CommonPhotoRawDbDao r6, String r7, long r8, long r10) {
            CommonPhotoRawDbDao r9 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(CommonPhotoRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(CommonPhotoRawDbDao r6, String r7, long r8, long r10) {
            CommonPhotoRawDbDao r9 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(CommonPhotoRawDbDao r2, String r3) {
            CommonPhotoRawDbDao r4 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(CommonPhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(CommonPhotoRawDbDao r2) {
            CommonPhotoRawDbDao r3 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawCommonPhotoEntity";
        }

        public static List<ft> queryAll(CommonPhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(CommonPhotoRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<ft> queryByEntityId(CommonPhotoRawDbDao r2, String r3, String r4) {
            CommonPhotoRawDbDao r5 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<ft> queryByEntityIdList(CommonPhotoRawDbDao r2, List<String> r3) {
            CommonPhotoRawDbDao r4 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<ft> queryByEntityIdListAndPackageName(CommonPhotoRawDbDao r2, List<String> r3, String r4) {
            CommonPhotoRawDbDao r5 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static ft queryById(CommonPhotoRawDbDao r2, long r3) {
            return (ft) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), ft.class, "com.obric.memorydata.plugin");
        }

        public static List<ft> queryByIdAndTimestamp(CommonPhotoRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<ft> queryByIds(CommonPhotoRawDbDao r2, List<Long> r3) {
            CommonPhotoRawDbDao r4 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(CommonPhotoRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            CommonPhotoRawDbDao r7 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<ft> queryByPackageName(CommonPhotoRawDbDao r2, String r3) {
            CommonPhotoRawDbDao r4 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<ft> queryByPackageNameBeforeTimestampWithLimit(CommonPhotoRawDbDao r7, String r8, long r9, int r11, long r12) {
            CommonPhotoRawDbDao r10 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<ft> queryByPackageNameWithLimit(CommonPhotoRawDbDao r2, String r3, int r4, long r5) {
            CommonPhotoRawDbDao r6 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static ft queryByUUID(CommonPhotoRawDbDao r2, String r3) {
            CommonPhotoRawDbDao r4 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ft) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), ft.class, "com.obric.memorydata.plugin");
        }

        public static ft queryOne(CommonPhotoRawDbDao r2) {
            return (ft) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), ft.class, "com.obric.memorydata.plugin");
        }

        public static List<ft> queryRecentByPackageName(CommonPhotoRawDbDao r2, String r3, long r4) {
            CommonPhotoRawDbDao r5 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<ft> queryWithLimitAndOffset(CommonPhotoRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(CommonPhotoRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            CommonPhotoRawDbDao r7 = (CommonPhotoRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    int deleteByEntityIds(List<String> r1, String r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    String queryCaptionById(String r1);

    List<ft> queryEntitiesByOriginalEntity(int r1, String r2, String r3);

    List<ft> queryEntitiesByOriginalEntityAndColumn(int r1, String r2, String r3, String r4);
}
