package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gi;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/ICSProtocolEntityRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawICSProtocolEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICSProtocolEntityRawDbDao extends IAppEntityRawDbDao<gi> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(ICSProtocolEntityRawDbDao r8, long r9, long r11, long r13, String r15) {
            ICSProtocolEntityRawDbDao r10 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(ICSProtocolEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(ICSProtocolEntityRawDbDao r2, List<Long> r3) {
            ICSProtocolEntityRawDbDao r4 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(ICSProtocolEntityRawDbDao r2, String r3) {
            ICSProtocolEntityRawDbDao r4 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(ICSProtocolEntityRawDbDao r6, String r7, long r8, long r10) {
            ICSProtocolEntityRawDbDao r9 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(ICSProtocolEntityRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(ICSProtocolEntityRawDbDao r6, String r7, long r8, long r10) {
            ICSProtocolEntityRawDbDao r9 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(ICSProtocolEntityRawDbDao r2, String r3) {
            ICSProtocolEntityRawDbDao r4 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(ICSProtocolEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ICSProtocolEntityRawDbDao r2) {
            ICSProtocolEntityRawDbDao r3 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawICSProtocolEntity";
        }

        public static List<gi> queryAll(ICSProtocolEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ICSProtocolEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<gi> queryByEntityId(ICSProtocolEntityRawDbDao r2, String r3, String r4) {
            ICSProtocolEntityRawDbDao r5 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<gi> queryByEntityIdList(ICSProtocolEntityRawDbDao r2, List<String> r3) {
            ICSProtocolEntityRawDbDao r4 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<gi> queryByEntityIdListAndPackageName(ICSProtocolEntityRawDbDao r2, List<String> r3, String r4) {
            ICSProtocolEntityRawDbDao r5 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static gi queryById(ICSProtocolEntityRawDbDao r2, long r3) {
            return (gi) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gi.class, "com.obric.memorydata.plugin");
        }

        public static List<gi> queryByIdAndTimestamp(ICSProtocolEntityRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<gi> queryByIds(ICSProtocolEntityRawDbDao r2, List<Long> r3) {
            ICSProtocolEntityRawDbDao r4 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(ICSProtocolEntityRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            ICSProtocolEntityRawDbDao r7 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<gi> queryByPackageName(ICSProtocolEntityRawDbDao r2, String r3) {
            ICSProtocolEntityRawDbDao r4 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<gi> queryByPackageNameBeforeTimestampWithLimit(ICSProtocolEntityRawDbDao r7, String r8, long r9, int r11, long r12) {
            ICSProtocolEntityRawDbDao r10 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<gi> queryByPackageNameWithLimit(ICSProtocolEntityRawDbDao r2, String r3, int r4, long r5) {
            ICSProtocolEntityRawDbDao r6 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static gi queryByUUID(ICSProtocolEntityRawDbDao r2, String r3) {
            ICSProtocolEntityRawDbDao r4 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (gi) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gi.class, "com.obric.memorydata.plugin");
        }

        public static gi queryOne(ICSProtocolEntityRawDbDao r2) {
            return (gi) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), gi.class, "com.obric.memorydata.plugin");
        }

        public static List<gi> queryRecentByPackageName(ICSProtocolEntityRawDbDao r2, String r3, long r4) {
            ICSProtocolEntityRawDbDao r5 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<gi> queryWithLimitAndOffset(ICSProtocolEntityRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(ICSProtocolEntityRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            ICSProtocolEntityRawDbDao r7 = (ICSProtocolEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
