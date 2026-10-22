package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\f\u001a\u00020\nH'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H'¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H'J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H'J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0019H'J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0019H'J4\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!H§@¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0019H'J4\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!H§@¢\u0006\u0002\u0010#J'\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H'¢\u0006\u0002\u0010'JB\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!H§@¢\u0006\u0002\u0010)J&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H'JF\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!H§@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H'J>\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!H§@¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0019H'J\u001a\u00101\u001a\u0004\u0018\u00010\u00022\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u000204H'J\u001a\u00105\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020\u00042\u0006\u00103\u001a\u000204H'J\u001a\u00107\u001a\u0004\u0018\u00010\u00022\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u000204H'J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH'J%\u0010>\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020\u00042\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0016¢\u0006\u0002\u0010AJ\u0012\u0010B\u001a\u0004\u0018\u00010\u00022\u0006\u0010C\u001a\u00020\u0004H'J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J\u0010\u0010F\u001a\u00020!2\u0006\u0010C\u001a\u00020\u0004H'J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010I\u001a\u00020\nH'J\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J\b\u0010L\u001a\u00020MH\u0016¨\u0006N"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryEntityRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "getTableName", "", "getMemoryMetaInfoList", "", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "getAllMemoryCount", "Lkotlinx/coroutines/flow/Flow;", "", "getMemoryByType", "memoryType", "getCollectTypeMemoryCount", "getInfoTypeMemoryCount", "getInfoAllTypeMemoryCount", "getInfoOthersTypeMemoryCount", "excludeTags", "", "([Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getInfoSingleTypeMemoryCount", "type", "tagType", "getInfoSingleTagMemoryCount", "queryPagingSource", "Landroidx/paging/PagingSource;", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "getOrderTypeMemory", "getCollectTypeMemory", "getCollectTypeMemoryMetaInfo", "ids", "withSpecifiedRange", "", "idsIsEmpty", "(Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInfoAllTypeMemory", "getInfoAllTypeMemoryMetaInfo", "getInfoOthersTypeMemory", "([Ljava/lang/String;)Landroidx/paging/PagingSource;", "getInfoOthersTypeMemoryMetaInfo", "([Ljava/lang/String;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInfoSingleTypeMemory", "getInfoSingleTypeMemoryMetaInfo", "(ILjava/lang/String;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInfoSingleTagMemory", "getInfoSingleTagMemoryMetaInfo", "(Ljava/lang/String;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTypeMemory", "querySameOrderFlightMemoryBy", "flightNumber", "departureDate", "", "querySameOrderTrainMemoryBy", "trainNumber", "querySameOrderHotelMemoryBy", "hotelName", "checkInDate", "getAnniversaryMemory", "getTimeSensitiveMemory", "getLatestMemory", "queryWidgetMemory", "getSameMemory", "selection", "selectionArgs", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "queryByEntityId", "memoryEntityId", "queryByEntityIds", "memoryEntityIds", "exists", "getProactivePortraitMemory", "getProactivePortraitMemoryWithLimit", "limit", "getUUIDListByEntityIds", "entityIds", "queryOldDataForContentTimeIndexPending", "Landroid/database/Cursor;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryEntityRawDbDao extends IAppEntityRawDbDao<RawMemoryEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(MemoryEntityRawDbDao r8, long r9, long r11, long r13, String r15) {
            MemoryEntityRawDbDao r10 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(MemoryEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(MemoryEntityRawDbDao r2, List<Long> r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static /* synthetic */ Object getCollectTypeMemoryMetaInfo$default(MemoryEntityRawDbDao r2, List r3, boolean r4, boolean r5, Continuation r6, int r7, Object r8) {
            MemoryEntityRawDbDao r9 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r5 = r10.isEmpty();
        L8:
            return r9.getCollectTypeMemoryMetaInfo(r10, r4, r5, r11);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollectTypeMemoryMetaInfo");
        }

        public static int getCountByPackageName(MemoryEntityRawDbDao r2, String r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(MemoryEntityRawDbDao r6, String r7, long r8, long r10) {
            MemoryEntityRawDbDao r9 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(MemoryEntityRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(MemoryEntityRawDbDao r6, String r7, long r8, long r10) {
            MemoryEntityRawDbDao r9 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static /* synthetic */ Object getInfoAllTypeMemoryMetaInfo$default(MemoryEntityRawDbDao r2, List r3, boolean r4, boolean r5, Continuation r6, int r7, Object r8) {
            MemoryEntityRawDbDao r9 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r5 = r10.isEmpty();
        L8:
            return r9.getInfoAllTypeMemoryMetaInfo(r10, r4, r5, r11);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInfoAllTypeMemoryMetaInfo");
        }

        public static /* synthetic */ Object getInfoOthersTypeMemoryMetaInfo$default(MemoryEntityRawDbDao r8, String[] r9, List r10, boolean r11, boolean r12, Continuation r13, int r14, Object r15) {
            MemoryEntityRawDbDao r2 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 8) == 0) goto L8;
            r12 = r4.isEmpty();
        L8:
            return r2.getInfoOthersTypeMemoryMetaInfo(r9, r4, r11, r12, r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInfoOthersTypeMemoryMetaInfo");
        }

        public static /* synthetic */ Object getInfoSingleTagMemoryMetaInfo$default(MemoryEntityRawDbDao r8, String r9, List r10, boolean r11, boolean r12, Continuation r13, int r14, Object r15) {
            MemoryEntityRawDbDao r2 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 8) == 0) goto L8;
            r12 = r4.isEmpty();
        L8:
            return r2.getInfoSingleTagMemoryMetaInfo(r9, r4, r11, r12, r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInfoSingleTagMemoryMetaInfo");
        }

        public static /* synthetic */ Object getInfoSingleTypeMemoryMetaInfo$default(MemoryEntityRawDbDao r9, int r10, String r11, List r12, boolean r13, boolean r14, Continuation r15, int r16, Object r17) {
            MemoryEntityRawDbDao r2 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r9, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L11;
            if ((r16 & 16) == 0) goto L7;
            boolean r7 = r5.isEmpty();
        L9:
            return r2.getInfoSingleTypeMemoryMetaInfo(r10, r11, r5, r13, r7, r8);
        L7:
            r7 = r14;
            goto L9
        L11:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInfoSingleTypeMemoryMetaInfo");
        }

        public static long getLastModifyTimeByPackageName(MemoryEntityRawDbDao r2, String r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<RawMemoryEntity> getLatestMemory(MemoryEntityRawDbDao r8) {
            MemoryEntityRawDbDao r9 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            long r2 = System.currentTimeMillis();
            return r9.queryWidgetMemory((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM RawMemoryEntity WHERE (memoryType NOT IN (10001, 10004, 10003,  10006, 10002, 10302, 10301)  OR (memoryType = 10302 AND endTime IS NULL AND endDate IS NULL)) AND createTime >= " + (r2 - TimeUnit.DAYS.toMillis(3)) + " AND createTime <= " + r2 + " ORDER BY createTime DESC LIMIT 3"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static List<String> getPackageNameList(MemoryEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static RawMemoryEntity getSameMemory(MemoryEntityRawDbDao r4, String r5, String[] r6) {
            MemoryEntityRawDbDao r7 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "selection");
            Intrinsics.checkNotNullParameter(r6, "selectionArgs");
            return (RawMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM RawMemoryEntity WHERE " + r5 + " LIMIT 1", r6), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static String getTableName(MemoryEntityRawDbDao r2) {
            MemoryEntityRawDbDao r3 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawMemoryEntity";
        }

        public static List<RawMemoryEntity> getTimeSensitiveMemory(MemoryEntityRawDbDao r10) {
            MemoryEntityRawDbDao r11 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r10, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            long r2 = System.currentTimeMillis();
            return r11.queryWidgetMemory((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT *  FROM RawMemoryEntity  WHERE   memoryType IN (10001, 10004, 10003,   10006, 10002, 10005, 10302, 10301)\n  AND (    (memoryType IN (10001, 10004, 10003,   10006, 10002, 10005, 10301) AND COALESCE(startTime, startDate, createTime) >= " + r2 + " AND COALESCE(startTime, startDate, createTime) <= " + (TimeUnit.DAYS.toMillis(3) + r2) + ")\n    OR     (memoryType = 10302 AND (endTime IS NOT NULL OR endDate IS NOT NULL) AND      CASE        WHEN endTime IS NOT NULL THEN endTime       WHEN endDate IS NOT NULL THEN endDate       ELSE NULL     END >= " + r2 + " AND     CASE        WHEN endTime IS NOT NULL THEN endTime       WHEN endDate IS NOT NULL THEN endDate       ELSE NULL     END <= " + (r2 + TimeUnit.DAYS.toMillis(3)) + ")  ) ORDER BY   CASE     WHEN memoryType = 10302 THEN       CASE         WHEN endTime IS NOT NULL THEN endTime        WHEN endDate IS NOT NULL THEN endDate        ELSE NULL      END    ELSE COALESCE(startTime, startDate, createTime)  END ASC  LIMIT 3;"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static List<RawMemoryEntity> queryAll(MemoryEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryEntityRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<RawMemoryEntity> queryByEntityId(MemoryEntityRawDbDao r2, String r3, String r4) {
            MemoryEntityRawDbDao r5 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<RawMemoryEntity> queryByEntityIdList(MemoryEntityRawDbDao r2, List<String> r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<RawMemoryEntity> queryByEntityIdListAndPackageName(MemoryEntityRawDbDao r2, List<String> r3, String r4) {
            MemoryEntityRawDbDao r5 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static RawMemoryEntity queryById(MemoryEntityRawDbDao r2, long r3) {
            return (RawMemoryEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<RawMemoryEntity> queryByIdAndTimestamp(MemoryEntityRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<RawMemoryEntity> queryByIds(MemoryEntityRawDbDao r2, List<Long> r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(MemoryEntityRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            MemoryEntityRawDbDao r7 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<RawMemoryEntity> queryByPackageName(MemoryEntityRawDbDao r2, String r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<RawMemoryEntity> queryByPackageNameBeforeTimestampWithLimit(MemoryEntityRawDbDao r7, String r8, long r9, int r11, long r12) {
            MemoryEntityRawDbDao r10 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<RawMemoryEntity> queryByPackageNameWithLimit(MemoryEntityRawDbDao r2, String r3, int r4, long r5) {
            MemoryEntityRawDbDao r6 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static RawMemoryEntity queryByUUID(MemoryEntityRawDbDao r2, String r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (RawMemoryEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static Cursor queryOldDataForContentTimeIndexPending(MemoryEntityRawDbDao r3) {
            MemoryEntityRawDbDao r4 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r3, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            return r4.rawQueryForCursor((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT id,createTime,timestamp FROM " + r4.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static RawMemoryEntity queryOne(MemoryEntityRawDbDao r2) {
            return (RawMemoryEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<RawMemoryEntity> queryRecentByPackageName(MemoryEntityRawDbDao r2, String r3, long r4) {
            MemoryEntityRawDbDao r5 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<RawMemoryEntity> queryWithLimitAndOffset(MemoryEntityRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(MemoryEntityRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            MemoryEntityRawDbDao r7 = (MemoryEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    boolean exists(String r1);

    i<Integer> getAllMemoryCount();

    PagingSource<Integer, RawMemoryEntity> getAllTypeMemory();

    List<RawMemoryEntity> getAnniversaryMemory();

    PagingSource<Integer, RawMemoryEntity> getCollectTypeMemory();

    i<Integer> getCollectTypeMemoryCount();

    Object getCollectTypeMemoryMetaInfo(List<String> r1, boolean r2, boolean r3, Continuation<? super List<cu>> r4);

    PagingSource<Integer, RawMemoryEntity> getInfoAllTypeMemory();

    i<Integer> getInfoAllTypeMemoryCount();

    Object getInfoAllTypeMemoryMetaInfo(List<String> r1, boolean r2, boolean r3, Continuation<? super List<cu>> r4);

    PagingSource<Integer, RawMemoryEntity> getInfoOthersTypeMemory(String[] r1);

    i<Integer> getInfoOthersTypeMemoryCount(String[] r1);

    Object getInfoOthersTypeMemoryMetaInfo(String[] r1, List<String> r2, boolean r3, boolean r4, Continuation<? super List<cu>> r5);

    PagingSource<Integer, RawMemoryEntity> getInfoSingleTagMemory(String r1);

    i<Integer> getInfoSingleTagMemoryCount(String r1);

    Object getInfoSingleTagMemoryMetaInfo(String r1, List<String> r2, boolean r3, boolean r4, Continuation<? super List<cu>> r5);

    PagingSource<Integer, RawMemoryEntity> getInfoSingleTypeMemory(int r1, String r2);

    i<Integer> getInfoSingleTypeMemoryCount(int r1, String r2);

    Object getInfoSingleTypeMemoryMetaInfo(int r1, String r2, List<String> r3, boolean r4, boolean r5, Continuation<? super List<cu>> r6);

    i<Integer> getInfoTypeMemoryCount();

    List<RawMemoryEntity> getLatestMemory();

    List<RawMemoryEntity> getMemoryByType(int r1);

    List<cu> getMemoryMetaInfoList();

    PagingSource<Integer, RawMemoryEntity> getOrderTypeMemory();

    List<RawMemoryEntity> getProactivePortraitMemory();

    List<RawMemoryEntity> getProactivePortraitMemoryWithLimit(int r1);

    RawMemoryEntity getSameMemory(String r1, String[] r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<RawMemoryEntity> getTimeSensitiveMemory();

    List<String> getUUIDListByEntityIds(List<String> r1);

    RawMemoryEntity queryByEntityId(String r1);

    List<RawMemoryEntity> queryByEntityIds(List<String> r1);

    Cursor queryOldDataForContentTimeIndexPending();

    PagingSource<Integer, RawMemoryEntity> queryPagingSource(SupportSQLiteQuery r1);

    RawMemoryEntity querySameOrderFlightMemoryBy(String r1, long r2);

    RawMemoryEntity querySameOrderHotelMemoryBy(String r1, long r2);

    RawMemoryEntity querySameOrderTrainMemoryBy(String r1, long r2);

    List<RawMemoryEntity> queryWidgetMemory(SupportSQLiteQuery r1);
}
