package com.obric.memorydata.database.dao;

import android.database.Cursor;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gy;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/NoteRecordingTextRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawFileTextDbDao;", "Lcom/obric/memorydata/database/entity/RawNoteRecordingTextEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface NoteRecordingTextRawDbDao extends IAppEntityRawFileTextDbDao<gy> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(NoteRecordingTextRawDbDao r8, long r9, long r11, long r13, String r15) {
            NoteRecordingTextRawDbDao r10 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawFileTextDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(NoteRecordingTextRawDbDao r2) {
            return IAppEntityRawFileTextDbDao.DefaultImpls.deleteAll((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByParentId(NoteRecordingTextRawDbDao r2, String r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "parentEntityId");
            return IAppEntityRawFileTextDbDao.DefaultImpls.deleteByParentId((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int deleteByRawDbIds(NoteRecordingTextRawDbDao r2, List<Long> r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawFileTextDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(NoteRecordingTextRawDbDao r2, String r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(NoteRecordingTextRawDbDao r6, String r7, long r8, long r10) {
            NoteRecordingTextRawDbDao r9 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(NoteRecordingTextRawDbDao r2, int r3, long r4) {
            return IAppEntityRawFileTextDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(NoteRecordingTextRawDbDao r6, String r7, long r8, long r10) {
            NoteRecordingTextRawDbDao r9 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(NoteRecordingTextRawDbDao r2, String r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(NoteRecordingTextRawDbDao r2) {
            return IAppEntityRawFileTextDbDao.DefaultImpls.getPackageNameList((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(NoteRecordingTextRawDbDao r2) {
            NoteRecordingTextRawDbDao r3 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawNoteRecordingTextEntity";
        }

        public static List<gy> queryAll(NoteRecordingTextRawDbDao r2) {
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryAll((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(NoteRecordingTextRawDbDao r2) {
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryAllCount((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<gy> queryByEntityId(NoteRecordingTextRawDbDao r2, String r3, String r4) {
            NoteRecordingTextRawDbDao r5 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByEntityId((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<gy> queryByEntityIdList(NoteRecordingTextRawDbDao r2, List<String> r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<gy> queryByEntityIdListAndPackageName(NoteRecordingTextRawDbDao r2, List<String> r3, String r4) {
            NoteRecordingTextRawDbDao r5 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static gy queryById(NoteRecordingTextRawDbDao r2, long r3) {
            return (gy) ZeusTransformUtils.preCheckCast(IAppEntityRawFileTextDbDao.DefaultImpls.queryById((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3), gy.class, "com.obric.memorydata.plugin");
        }

        public static List<gy> queryByIdAndTimestamp(NoteRecordingTextRawDbDao r2, long r3, long r5) {
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<gy> queryByIds(NoteRecordingTextRawDbDao r2, List<Long> r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByIds((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(NoteRecordingTextRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            NoteRecordingTextRawDbDao r7 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByPackageName((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<gy> queryByPackageName(NoteRecordingTextRawDbDao r2, String r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByPackageName((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<gy> queryByPackageNameBeforeTimestampWithLimit(NoteRecordingTextRawDbDao r7, String r8, long r9, int r11, long r12) {
            NoteRecordingTextRawDbDao r10 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<gy> queryByPackageNameWithLimit(NoteRecordingTextRawDbDao r2, String r3, int r4, long r5) {
            NoteRecordingTextRawDbDao r6 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<gy> queryByParentEntityId(NoteRecordingTextRawDbDao r2, String r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "parentEntityId");
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryByParentEntityId((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static gy queryByUUID(NoteRecordingTextRawDbDao r2, String r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (gy) ZeusTransformUtils.preCheckCast(IAppEntityRawFileTextDbDao.DefaultImpls.queryByUUID((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3), gy.class, "com.obric.memorydata.plugin");
        }

        public static List<String> queryEntityIdByParentEntityIds(NoteRecordingTextRawDbDao r2, List<String> r3) {
            NoteRecordingTextRawDbDao r4 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "parentEntityIds");
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryEntityIdByParentEntityIds((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static gy queryOne(NoteRecordingTextRawDbDao r2) {
            return (gy) ZeusTransformUtils.preCheckCast(IAppEntityRawFileTextDbDao.DefaultImpls.queryOne((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin")), gy.class, "com.obric.memorydata.plugin");
        }

        public static List<gy> queryRecentByPackageName(NoteRecordingTextRawDbDao r2, String r3, long r4) {
            NoteRecordingTextRawDbDao r5 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<gy> queryWithLimitAndOffset(NoteRecordingTextRawDbDao r2, int r3, int r4) {
            return IAppEntityRawFileTextDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast((NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(NoteRecordingTextRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            NoteRecordingTextRawDbDao r7 = (NoteRecordingTextRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, NoteRecordingTextRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawFileTextDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
