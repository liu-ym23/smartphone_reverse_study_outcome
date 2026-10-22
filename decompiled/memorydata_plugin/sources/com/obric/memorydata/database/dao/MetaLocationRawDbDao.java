package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gq;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/dao/MetaLocationRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "getTableName", "", "queryAllDistinct", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MetaLocationRawDbDao extends IAppEntityRawDbDao<gq> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(MetaLocationRawDbDao r8, long r9, long r11, long r13, String r15) {
            MetaLocationRawDbDao r10 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(MetaLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(MetaLocationRawDbDao r2, List<Long> r3) {
            MetaLocationRawDbDao r4 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(MetaLocationRawDbDao r2, String r3) {
            MetaLocationRawDbDao r4 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(MetaLocationRawDbDao r6, String r7, long r8, long r10) {
            MetaLocationRawDbDao r9 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(MetaLocationRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(MetaLocationRawDbDao r6, String r7, long r8, long r10) {
            MetaLocationRawDbDao r9 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(MetaLocationRawDbDao r2, String r3) {
            MetaLocationRawDbDao r4 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(MetaLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MetaLocationRawDbDao r2) {
            MetaLocationRawDbDao r3 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawMetaLocationEntity";
        }

        public static List<gq> queryAll(MetaLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MetaLocationRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<gq> queryByEntityId(MetaLocationRawDbDao r2, String r3, String r4) {
            MetaLocationRawDbDao r5 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<gq> queryByEntityIdList(MetaLocationRawDbDao r2, List<String> r3) {
            MetaLocationRawDbDao r4 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<gq> queryByEntityIdListAndPackageName(MetaLocationRawDbDao r2, List<String> r3, String r4) {
            MetaLocationRawDbDao r5 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static gq queryById(MetaLocationRawDbDao r2, long r3) {
            return (gq) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gq.class, "com.obric.memorydata.plugin");
        }

        public static List<gq> queryByIdAndTimestamp(MetaLocationRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<gq> queryByIds(MetaLocationRawDbDao r2, List<Long> r3) {
            MetaLocationRawDbDao r4 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(MetaLocationRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            MetaLocationRawDbDao r7 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<gq> queryByPackageName(MetaLocationRawDbDao r2, String r3) {
            MetaLocationRawDbDao r4 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<gq> queryByPackageNameBeforeTimestampWithLimit(MetaLocationRawDbDao r7, String r8, long r9, int r11, long r12) {
            MetaLocationRawDbDao r10 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<gq> queryByPackageNameWithLimit(MetaLocationRawDbDao r2, String r3, int r4, long r5) {
            MetaLocationRawDbDao r6 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static gq queryByUUID(MetaLocationRawDbDao r2, String r3) {
            MetaLocationRawDbDao r4 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (gq) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gq.class, "com.obric.memorydata.plugin");
        }

        public static gq queryOne(MetaLocationRawDbDao r2) {
            return (gq) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), gq.class, "com.obric.memorydata.plugin");
        }

        public static List<gq> queryRecentByPackageName(MetaLocationRawDbDao r2, String r3, long r4) {
            MetaLocationRawDbDao r5 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<gq> queryWithLimitAndOffset(MetaLocationRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(MetaLocationRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            MetaLocationRawDbDao r7 = (MetaLocationRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MetaLocationRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<gq> queryAllDistinct();
}
