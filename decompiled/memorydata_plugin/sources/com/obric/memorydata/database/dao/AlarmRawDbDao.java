package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.AlarmSwitchStatus;
import com.obric.memorydata.database.entity.fe;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/dao/AlarmRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawAlarmEntity;", "getTableName", "", "queryBySwitchStatus", "", "switchStatus", "Lcom/obric/memorydata/database/entity/AlarmSwitchStatus;", ObricMemoryConstants.KEY_PACKAGE_NAME, "queryRepeatTypeFullContentMigrationData", "Lcom/obric/memorydata/database/SimpleEntityData;", "pageSize", "", "minDbId", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AlarmRawDbDao extends IAppEntityRawDbDao<fe> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(AlarmRawDbDao r8, long r9, long r11, long r13, String r15) {
            AlarmRawDbDao r10 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(AlarmRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(AlarmRawDbDao r2, List<Long> r3) {
            AlarmRawDbDao r4 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(AlarmRawDbDao r2, String r3) {
            AlarmRawDbDao r4 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(AlarmRawDbDao r6, String r7, long r8, long r10) {
            AlarmRawDbDao r9 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(AlarmRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(AlarmRawDbDao r6, String r7, long r8, long r10) {
            AlarmRawDbDao r9 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(AlarmRawDbDao r2, String r3) {
            AlarmRawDbDao r4 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(AlarmRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AlarmRawDbDao r2) {
            AlarmRawDbDao r3 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawAlarmEntity";
        }

        public static List<fe> queryAll(AlarmRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AlarmRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<fe> queryByEntityId(AlarmRawDbDao r2, String r3, String r4) {
            AlarmRawDbDao r5 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<fe> queryByEntityIdList(AlarmRawDbDao r2, List<String> r3) {
            AlarmRawDbDao r4 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<fe> queryByEntityIdListAndPackageName(AlarmRawDbDao r2, List<String> r3, String r4) {
            AlarmRawDbDao r5 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fe queryById(AlarmRawDbDao r2, long r3) {
            return (fe) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fe.class, "com.obric.memorydata.plugin");
        }

        public static List<fe> queryByIdAndTimestamp(AlarmRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<fe> queryByIds(AlarmRawDbDao r2, List<Long> r3) {
            AlarmRawDbDao r4 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(AlarmRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            AlarmRawDbDao r7 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<fe> queryByPackageName(AlarmRawDbDao r2, String r3) {
            AlarmRawDbDao r4 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<fe> queryByPackageNameBeforeTimestampWithLimit(AlarmRawDbDao r7, String r8, long r9, int r11, long r12) {
            AlarmRawDbDao r10 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<fe> queryByPackageNameWithLimit(AlarmRawDbDao r2, String r3, int r4, long r5) {
            AlarmRawDbDao r6 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<fe> queryBySwitchStatus(AlarmRawDbDao r4, AlarmSwitchStatus r5, String r6) {
            AlarmRawDbDao r7 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "switchStatus");
            Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE packageName = '" + r6 + "' AND switchStatus = '" + r5.name() + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static fe queryByUUID(AlarmRawDbDao r2, String r3) {
            AlarmRawDbDao r4 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fe) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fe.class, "com.obric.memorydata.plugin");
        }

        public static fe queryOne(AlarmRawDbDao r2) {
            return (fe) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), fe.class, "com.obric.memorydata.plugin");
        }

        public static List<fe> queryRecentByPackageName(AlarmRawDbDao r2, String r3, long r4) {
            AlarmRawDbDao r5 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<fe> queryWithLimitAndOffset(AlarmRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(AlarmRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            AlarmRawDbDao r7 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<fe> queryBySwitchStatus(AlarmSwitchStatus r1, String r2);

    List<b> queryRepeatTypeFullContentMigrationData(int r1, long r2);
}
