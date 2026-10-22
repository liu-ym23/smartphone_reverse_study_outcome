package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.bp;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0004H'¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryEntity;", "getTableName", "", "getEpisodicTopicMemoryEntity", "Lkotlinx/coroutines/flow/Flow;", "", "memoryId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EpisodicTopicMemoryDao extends IAppEntityRawDbDao<bp> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(EpisodicTopicMemoryDao r8, long r9, long r11, long r13, String r15) {
            EpisodicTopicMemoryDao r10 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r8, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(EpisodicTopicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(EpisodicTopicMemoryDao r2, List<Long> r3) {
            EpisodicTopicMemoryDao r4 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(EpisodicTopicMemoryDao r2, String r3) {
            EpisodicTopicMemoryDao r4 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(EpisodicTopicMemoryDao r6, String r7, long r8, long r10) {
            EpisodicTopicMemoryDao r9 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r6, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(EpisodicTopicMemoryDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(EpisodicTopicMemoryDao r6, String r7, long r8, long r10) {
            EpisodicTopicMemoryDao r9 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r6, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(EpisodicTopicMemoryDao r2, String r3) {
            EpisodicTopicMemoryDao r4 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(EpisodicTopicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(EpisodicTopicMemoryDao r2) {
            EpisodicTopicMemoryDao r3 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            return "EpisodicTopicMemory";
        }

        public static List<bp> queryAll(EpisodicTopicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EpisodicTopicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<bp> queryByEntityId(EpisodicTopicMemoryDao r2, String r3, String r4) {
            EpisodicTopicMemoryDao r5 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<bp> queryByEntityIdList(EpisodicTopicMemoryDao r2, List<String> r3) {
            EpisodicTopicMemoryDao r4 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<bp> queryByEntityIdListAndPackageName(EpisodicTopicMemoryDao r2, List<String> r3, String r4) {
            EpisodicTopicMemoryDao r5 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static bp queryById(EpisodicTopicMemoryDao r2, long r3) {
            return (bp) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), bp.class, "com.obric.memorydata.plugin");
        }

        public static List<bp> queryByIdAndTimestamp(EpisodicTopicMemoryDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<bp> queryByIds(EpisodicTopicMemoryDao r2, List<Long> r3) {
            EpisodicTopicMemoryDao r4 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(EpisodicTopicMemoryDao r2, String[] r3, String r4, int r5, Long r6) {
            EpisodicTopicMemoryDao r7 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<bp> queryByPackageName(EpisodicTopicMemoryDao r2, String r3) {
            EpisodicTopicMemoryDao r4 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<bp> queryByPackageNameBeforeTimestampWithLimit(EpisodicTopicMemoryDao r7, String r8, long r9, int r11, long r12) {
            EpisodicTopicMemoryDao r10 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r7, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<bp> queryByPackageNameWithLimit(EpisodicTopicMemoryDao r2, String r3, int r4, long r5) {
            EpisodicTopicMemoryDao r6 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static bp queryByUUID(EpisodicTopicMemoryDao r2, String r3) {
            EpisodicTopicMemoryDao r4 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bp) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), bp.class, "com.obric.memorydata.plugin");
        }

        public static bp queryOne(EpisodicTopicMemoryDao r2) {
            return (bp) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), bp.class, "com.obric.memorydata.plugin");
        }

        public static List<bp> queryRecentByPackageName(EpisodicTopicMemoryDao r2, String r3, long r4) {
            EpisodicTopicMemoryDao r5 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<bp> queryWithLimitAndOffset(EpisodicTopicMemoryDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(EpisodicTopicMemoryDao r2, String r3, String r4, int r5, Integer r6) {
            EpisodicTopicMemoryDao r7 = (EpisodicTopicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    i<List<bp>> getEpisodicTopicMemoryEntity(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
