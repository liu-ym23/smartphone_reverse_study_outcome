package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.paging.PagingSource;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH'J>\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H'J>\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H'J4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u001aJD\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH'J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\fH'J\u0012\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020\u0004H'J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'¨\u0006*"}, d2 = {"Lcom/obric/memorydata/database/dao/AuditoryRecordingRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "getTableName", "", "getAllRecordings", "Landroidx/paging/PagingSource;", "", "beginTime", "", "endTime", "queryContextAwarenessAudioPage", "", "startTimeInclusive", "endTimeExclusive", "cursorTime", "cursorEntityId", "includeAllAtCursorTime", "limit", "queryContextAwarenessAudioPageBefore", "getAllRecordingsMetaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "ids", "withSpecifiedRange", "", "idsIsEmpty", "(Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecordingsMetaInfoWithTimestamp", "startTimeStamp", "tomorrowStartTimeStamp", "(Ljava/util/List;ZJJZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecordingsCount", "Lkotlinx/coroutines/flow/Flow;", "startTimestamp", "endTimeStamp", "getAllRecordings2", "queryByEntityId", "audioMemoryId", "queryByEntityIds", "entityIds", "getUUIDListByEntityIds", "getAudioMemoryDateList", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AuditoryRecordingRawDbDao extends IAppEntityRawDbDao<fj> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(AuditoryRecordingRawDbDao r8, long r9, long r11, long r13, String r15) {
            AuditoryRecordingRawDbDao r10 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(AuditoryRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(AuditoryRecordingRawDbDao r2, List<Long> r3) {
            AuditoryRecordingRawDbDao r4 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static /* synthetic */ Object getAllRecordingsMetaInfo$default(AuditoryRecordingRawDbDao r2, List r3, boolean r4, boolean r5, Continuation r6, int r7, Object r8) {
            AuditoryRecordingRawDbDao r9 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r5 = r10.isEmpty();
        L8:
            return r9.getAllRecordingsMetaInfo(r10, r4, r5, r11);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllRecordingsMetaInfo");
        }

        public static /* synthetic */ Object getAllRecordingsMetaInfoWithTimestamp$default(AuditoryRecordingRawDbDao r11, List r12, boolean r13, long r14, long r16, boolean r18, Continuation r19, int r20, Object r21) {
            AuditoryRecordingRawDbDao r2 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r11, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
            if (r21 != null) goto L11;
            if ((r20 & 16) == 0) goto L7;
            boolean r9 = r3.isEmpty();
        L9:
            return r2.getAllRecordingsMetaInfoWithTimestamp(r3, r13, r14, r16, r9, r10);
        L7:
            r9 = r18;
            goto L9
        L11:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllRecordingsMetaInfoWithTimestamp");
        }

        public static int getCountByPackageName(AuditoryRecordingRawDbDao r2, String r3) {
            AuditoryRecordingRawDbDao r4 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(AuditoryRecordingRawDbDao r6, String r7, long r8, long r10) {
            AuditoryRecordingRawDbDao r9 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(AuditoryRecordingRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(AuditoryRecordingRawDbDao r6, String r7, long r8, long r10) {
            AuditoryRecordingRawDbDao r9 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(AuditoryRecordingRawDbDao r2, String r3) {
            AuditoryRecordingRawDbDao r4 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(AuditoryRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AuditoryRecordingRawDbDao r2) {
            AuditoryRecordingRawDbDao r3 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawAuditoryRecordingEntity";
        }

        public static List<fj> queryAll(AuditoryRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AuditoryRecordingRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<fj> queryByEntityId(AuditoryRecordingRawDbDao r2, String r3, String r4) {
            AuditoryRecordingRawDbDao r5 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<fj> queryByEntityIdList(AuditoryRecordingRawDbDao r2, List<String> r3) {
            AuditoryRecordingRawDbDao r4 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<fj> queryByEntityIdListAndPackageName(AuditoryRecordingRawDbDao r2, List<String> r3, String r4) {
            AuditoryRecordingRawDbDao r5 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fj queryById(AuditoryRecordingRawDbDao r2, long r3) {
            return (fj) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fj.class, "com.obric.memorydata.plugin");
        }

        public static List<fj> queryByIdAndTimestamp(AuditoryRecordingRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<fj> queryByIds(AuditoryRecordingRawDbDao r2, List<Long> r3) {
            AuditoryRecordingRawDbDao r4 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(AuditoryRecordingRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            AuditoryRecordingRawDbDao r7 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<fj> queryByPackageName(AuditoryRecordingRawDbDao r2, String r3) {
            AuditoryRecordingRawDbDao r4 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<fj> queryByPackageNameBeforeTimestampWithLimit(AuditoryRecordingRawDbDao r7, String r8, long r9, int r11, long r12) {
            AuditoryRecordingRawDbDao r10 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<fj> queryByPackageNameWithLimit(AuditoryRecordingRawDbDao r2, String r3, int r4, long r5) {
            AuditoryRecordingRawDbDao r6 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static fj queryByUUID(AuditoryRecordingRawDbDao r2, String r3) {
            AuditoryRecordingRawDbDao r4 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fj) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fj.class, "com.obric.memorydata.plugin");
        }

        public static fj queryOne(AuditoryRecordingRawDbDao r2) {
            return (fj) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), fj.class, "com.obric.memorydata.plugin");
        }

        public static List<fj> queryRecentByPackageName(AuditoryRecordingRawDbDao r2, String r3, long r4) {
            AuditoryRecordingRawDbDao r5 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<fj> queryWithLimitAndOffset(AuditoryRecordingRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(AuditoryRecordingRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            AuditoryRecordingRawDbDao r7 = (AuditoryRecordingRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    PagingSource<Integer, fj> getAllRecordings(long r1, long r3);

    List<fj> getAllRecordings2();

    i<Integer> getAllRecordingsCount(long r1, long r3);

    Object getAllRecordingsMetaInfo(List<String> r1, boolean r2, boolean r3, Continuation<? super List<cu>> r4);

    Object getAllRecordingsMetaInfoWithTimestamp(List<String> r1, boolean r2, long r3, long r5, boolean r7, Continuation<? super List<cu>> r8);

    List<String> getAudioMemoryDateList();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<String> getUUIDListByEntityIds(List<String> r1);

    fj queryByEntityId(String r1);

    List<fj> queryByEntityIds(List<String> r1);

    List<fj> queryContextAwarenessAudioPage(long r1, long r3, long r5, String r7, int r8, int r9);

    List<fj> queryContextAwarenessAudioPageBefore(long r1, long r3, long r5, String r7, int r8, int r9);
}
