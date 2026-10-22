package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gm;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H'¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryLocationRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawMemoryLocationEntity;", "getTableName", "", "queryOneRecord", "location", "pkgName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryLocationRawDbDao extends IAppEntityRawDbDao<gm> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(MemoryLocationRawDbDao r8, long r9, long r11, long r13, String r15) {
            MemoryLocationRawDbDao r10 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(MemoryLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(MemoryLocationRawDbDao r2, List<Long> r3) {
            MemoryLocationRawDbDao r4 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(MemoryLocationRawDbDao r2, String r3) {
            MemoryLocationRawDbDao r4 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(MemoryLocationRawDbDao r6, String r7, long r8, long r10) {
            MemoryLocationRawDbDao r9 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(MemoryLocationRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(MemoryLocationRawDbDao r6, String r7, long r8, long r10) {
            MemoryLocationRawDbDao r9 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(MemoryLocationRawDbDao r2, String r3) {
            MemoryLocationRawDbDao r4 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(MemoryLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemoryLocationRawDbDao r2) {
            MemoryLocationRawDbDao r3 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawMemoryLocationEntity";
        }

        public static List<gm> queryAll(MemoryLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<gm> queryByEntityId(MemoryLocationRawDbDao r2, String r3, String r4) {
            MemoryLocationRawDbDao r5 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<gm> queryByEntityIdList(MemoryLocationRawDbDao r2, List<String> r3) {
            MemoryLocationRawDbDao r4 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<gm> queryByEntityIdListAndPackageName(MemoryLocationRawDbDao r2, List<String> r3, String r4) {
            MemoryLocationRawDbDao r5 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static gm queryById(MemoryLocationRawDbDao r2, long r3) {
            return (gm) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gm.class, "com.obric.memorydata.plugin");
        }

        public static List<gm> queryByIdAndTimestamp(MemoryLocationRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<gm> queryByIds(MemoryLocationRawDbDao r2, List<Long> r3) {
            MemoryLocationRawDbDao r4 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(MemoryLocationRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            MemoryLocationRawDbDao r7 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<gm> queryByPackageName(MemoryLocationRawDbDao r2, String r3) {
            MemoryLocationRawDbDao r4 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<gm> queryByPackageNameBeforeTimestampWithLimit(MemoryLocationRawDbDao r7, String r8, long r9, int r11, long r12) {
            MemoryLocationRawDbDao r10 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<gm> queryByPackageNameWithLimit(MemoryLocationRawDbDao r2, String r3, int r4, long r5) {
            MemoryLocationRawDbDao r6 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static gm queryByUUID(MemoryLocationRawDbDao r2, String r3) {
            MemoryLocationRawDbDao r4 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (gm) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gm.class, "com.obric.memorydata.plugin");
        }

        public static gm queryOne(MemoryLocationRawDbDao r2) {
            return (gm) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), gm.class, "com.obric.memorydata.plugin");
        }

        public static List<gm> queryRecentByPackageName(MemoryLocationRawDbDao r2, String r3, long r4) {
            MemoryLocationRawDbDao r5 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<gm> queryWithLimitAndOffset(MemoryLocationRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(MemoryLocationRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            MemoryLocationRawDbDao r7 = (MemoryLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    gm queryOneRecord(String r1, String r2);
}
