package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gb;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/DoubaoAccountEntityRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawDoubaoAccountEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DoubaoAccountEntityRawDbDao extends IAppEntityRawDbDao<gb> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(DoubaoAccountEntityRawDbDao r8, long r9, long r11, long r13, String r15) {
            DoubaoAccountEntityRawDbDao r10 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(DoubaoAccountEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(DoubaoAccountEntityRawDbDao r2, List<Long> r3) {
            DoubaoAccountEntityRawDbDao r4 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(DoubaoAccountEntityRawDbDao r2, String r3) {
            DoubaoAccountEntityRawDbDao r4 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(DoubaoAccountEntityRawDbDao r6, String r7, long r8, long r10) {
            DoubaoAccountEntityRawDbDao r9 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(DoubaoAccountEntityRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(DoubaoAccountEntityRawDbDao r6, String r7, long r8, long r10) {
            DoubaoAccountEntityRawDbDao r9 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(DoubaoAccountEntityRawDbDao r2, String r3) {
            DoubaoAccountEntityRawDbDao r4 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(DoubaoAccountEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(DoubaoAccountEntityRawDbDao r2) {
            DoubaoAccountEntityRawDbDao r3 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawDoubaoAccountEntity";
        }

        public static List<gb> queryAll(DoubaoAccountEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(DoubaoAccountEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<gb> queryByEntityId(DoubaoAccountEntityRawDbDao r2, String r3, String r4) {
            DoubaoAccountEntityRawDbDao r5 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<gb> queryByEntityIdList(DoubaoAccountEntityRawDbDao r2, List<String> r3) {
            DoubaoAccountEntityRawDbDao r4 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<gb> queryByEntityIdListAndPackageName(DoubaoAccountEntityRawDbDao r2, List<String> r3, String r4) {
            DoubaoAccountEntityRawDbDao r5 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static gb queryById(DoubaoAccountEntityRawDbDao r2, long r3) {
            return (gb) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gb.class, "com.obric.memorydata.plugin");
        }

        public static List<gb> queryByIdAndTimestamp(DoubaoAccountEntityRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<gb> queryByIds(DoubaoAccountEntityRawDbDao r2, List<Long> r3) {
            DoubaoAccountEntityRawDbDao r4 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(DoubaoAccountEntityRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            DoubaoAccountEntityRawDbDao r7 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<gb> queryByPackageName(DoubaoAccountEntityRawDbDao r2, String r3) {
            DoubaoAccountEntityRawDbDao r4 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<gb> queryByPackageNameBeforeTimestampWithLimit(DoubaoAccountEntityRawDbDao r7, String r8, long r9, int r11, long r12) {
            DoubaoAccountEntityRawDbDao r10 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<gb> queryByPackageNameWithLimit(DoubaoAccountEntityRawDbDao r2, String r3, int r4, long r5) {
            DoubaoAccountEntityRawDbDao r6 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static gb queryByUUID(DoubaoAccountEntityRawDbDao r2, String r3) {
            DoubaoAccountEntityRawDbDao r4 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (gb) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gb.class, "com.obric.memorydata.plugin");
        }

        public static gb queryOne(DoubaoAccountEntityRawDbDao r2) {
            return (gb) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), gb.class, "com.obric.memorydata.plugin");
        }

        public static List<gb> queryRecentByPackageName(DoubaoAccountEntityRawDbDao r2, String r3, long r4) {
            DoubaoAccountEntityRawDbDao r5 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<gb> queryWithLimitAndOffset(DoubaoAccountEntityRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(DoubaoAccountEntityRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            DoubaoAccountEntityRawDbDao r7 = (DoubaoAccountEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, DoubaoAccountEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
