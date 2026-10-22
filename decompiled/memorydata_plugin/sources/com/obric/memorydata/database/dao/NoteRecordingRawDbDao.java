package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gw;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/NoteRecordingRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawNoteRecordingEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface NoteRecordingRawDbDao extends IAppEntityRawDbDao<gw> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(NoteRecordingRawDbDao r8, long r9, long r11, long r13, String r15) {
            NoteRecordingRawDbDao r10 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(NoteRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(NoteRecordingRawDbDao r2, List<Long> r3) {
            NoteRecordingRawDbDao r4 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(NoteRecordingRawDbDao r2, String r3) {
            NoteRecordingRawDbDao r4 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(NoteRecordingRawDbDao r6, String r7, long r8, long r10) {
            NoteRecordingRawDbDao r9 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(NoteRecordingRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(NoteRecordingRawDbDao r6, String r7, long r8, long r10) {
            NoteRecordingRawDbDao r9 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(NoteRecordingRawDbDao r2, String r3) {
            NoteRecordingRawDbDao r4 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(NoteRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(NoteRecordingRawDbDao r2) {
            NoteRecordingRawDbDao r3 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawNoteRecordingEntity";
        }

        public static List<gw> queryAll(NoteRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(NoteRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<gw> queryByEntityId(NoteRecordingRawDbDao r2, String r3, String r4) {
            NoteRecordingRawDbDao r5 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<gw> queryByEntityIdList(NoteRecordingRawDbDao r2, List<String> r3) {
            NoteRecordingRawDbDao r4 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<gw> queryByEntityIdListAndPackageName(NoteRecordingRawDbDao r2, List<String> r3, String r4) {
            NoteRecordingRawDbDao r5 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static gw queryById(NoteRecordingRawDbDao r2, long r3) {
            return (gw) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gw.class, "com.obric.memorydata.plugin");
        }

        public static List<gw> queryByIdAndTimestamp(NoteRecordingRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<gw> queryByIds(NoteRecordingRawDbDao r2, List<Long> r3) {
            NoteRecordingRawDbDao r4 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(NoteRecordingRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            NoteRecordingRawDbDao r7 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<gw> queryByPackageName(NoteRecordingRawDbDao r2, String r3) {
            NoteRecordingRawDbDao r4 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<gw> queryByPackageNameBeforeTimestampWithLimit(NoteRecordingRawDbDao r7, String r8, long r9, int r11, long r12) {
            NoteRecordingRawDbDao r10 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<gw> queryByPackageNameWithLimit(NoteRecordingRawDbDao r2, String r3, int r4, long r5) {
            NoteRecordingRawDbDao r6 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static gw queryByUUID(NoteRecordingRawDbDao r2, String r3) {
            NoteRecordingRawDbDao r4 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (gw) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), gw.class, "com.obric.memorydata.plugin");
        }

        public static gw queryOne(NoteRecordingRawDbDao r2) {
            return (gw) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), gw.class, "com.obric.memorydata.plugin");
        }

        public static List<gw> queryRecentByPackageName(NoteRecordingRawDbDao r2, String r3, long r4) {
            NoteRecordingRawDbDao r5 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<gw> queryWithLimitAndOffset(NoteRecordingRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(NoteRecordingRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            NoteRecordingRawDbDao r7 = (NoteRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
