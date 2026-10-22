package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.al;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\bH'¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0006H'J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H'J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\u0004H'J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u001cH'J$\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0006H'J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060!H'J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\f0!H'JH\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010'\u001a\u00020(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010)\u001a\u00020(H§@¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u001cH'J$\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH'J>\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H'J>\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H'J\u001e\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH§@¢\u0006\u0002\u00109J.\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0018\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0<0\fH\u0097@¢\u0006\u0002\u0010=J4\u0010>\u001a\b\u0012\u0004\u0012\u00020%0\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(H§@¢\u0006\u0002\u0010?JD\u0010@\u001a\b\u0012\u0004\u0012\u00020%0\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010'\u001a\u00020(2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020(H§@¢\u0006\u0002\u0010CJ\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH'J\u0018\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\n\u001a\u00020\u0004H'J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016J&\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H'J6\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H'J6\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H'J6\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H'J\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u0017\u0010M\u001a\u0004\u0018\u00010\b2\u0006\u0010N\u001a\u00020\bH'¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00020\fH'J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00020\fH'J\b\u0010S\u001a\u00020TH'¨\u0006U"}, d2 = {"Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "getTableName", "", "deleteById", "", OaidModel.KEY_ID, "", "queryByEntityId", "entityId", "queryByEntityIds", "", "entityIds", "latestValidCreateTime", "()Ljava/lang/Long;", "queryExistingEntityIds", "queryExistingUuids", "uuids", "queryByProductType", "productType", "queryByProductTypeAfterId", "lastId", "limit", "getCollectMemoryWithRelevantByEntityIds", "Lcom/obric/memorydata/database/entity/EpisodicWithRelevantPojo;", "getCollectMemoryWithRelevantByEntityId", "getAllCollectMemoryWithRelevantPojo", "Landroidx/paging/PagingSource;", "getCollectMemoryWithRelevantPojoBySource", "sourcePackageName", "sourceProductType", "getAllCollectMemoryWithRelevantCount", "Lkotlinx/coroutines/flow/Flow;", "getCollectMemorySourceStats", "Lcom/obric/memorydata/database/entity/CollectMemorySourceStat;", "getCollectMemoryMetaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "ids", "withSpecifiedRange", "", "idsIsEmpty", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecommendMemory", "getAllRecommendMemoryByTimeRange", "beginTime", "endTime", "queryContextAwarenessScreenPage", "startTimeInclusive", "endTimeExclusive", "cursorTime", "cursorEntityId", "includeAllAtCursorTime", "queryContextAwarenessScreenPageBefore", "getMemoryCountByTimeRange", "begin", "end", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMemoryCountsByTimeRanges", "ranges", "Lkotlin/Pair;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllObservationMemoryMetaInfo", "(Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllObservationMemoryMetaInfoWithTimestamp", "startTimestamp", "endTimeStamp", "(Ljava/util/List;ZJJZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllObservationMemoryCount", "getEpisodicMemoryEntity", "getEpisodicMemoryEntityByEntities", "entityDbIds", "queryByTime", "queryScreenMemoryReviewPage", "queryAudioMemoryReviewPage", "queryCollectionMemoryReviewPage", "getUUIDListByEntityIds", "getScreenMemoryValidateDay", "maxTimeStamp", "(J)Ljava/lang/Long;", "getScreenMemoryDateList", "getAllMemory", "getAllMemoryForTracker", "resetSequence", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EpisodicMemoryDao extends IAppEntityRawDbDao<EpisodicMemoryEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(EpisodicMemoryDao r8, long r9, long r11, long r13, String r15) {
            EpisodicMemoryDao r10 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r8, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(EpisodicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(EpisodicMemoryDao r2, List<Long> r3) {
            EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static /* synthetic */ Object getAllObservationMemoryMetaInfo$default(EpisodicMemoryDao r2, List r3, boolean r4, boolean r5, Continuation r6, int r7, Object r8) {
            EpisodicMemoryDao r9 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r5 = r10.isEmpty();
        L8:
            return r9.getAllObservationMemoryMetaInfo(r10, r4, r5, r11);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllObservationMemoryMetaInfo");
        }

        public static /* synthetic */ Object getAllObservationMemoryMetaInfoWithTimestamp$default(EpisodicMemoryDao r11, List r12, boolean r13, long r14, long r16, boolean r18, Continuation r19, int r20, Object r21) {
            EpisodicMemoryDao r2 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r11, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
            if (r21 != null) goto L11;
            if ((r20 & 16) == 0) goto L7;
            boolean r9 = r3.isEmpty();
        L9:
            return r2.getAllObservationMemoryMetaInfoWithTimestamp(r3, r13, r14, r16, r9, r10);
        L7:
            r9 = r18;
            goto L9
        L11:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllObservationMemoryMetaInfoWithTimestamp");
        }

        public static /* synthetic */ Object getCollectMemoryMetaInfo$default(EpisodicMemoryDao r9, List r10, boolean r11, String r12, Integer r13, boolean r14, Continuation r15, int r16, Object r17) {
            EpisodicMemoryDao r2 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r9, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Continuation<? super List<cu>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L11;
            if ((r16 & 16) == 0) goto L7;
            boolean r7 = r3.isEmpty();
        L9:
            return r2.getCollectMemoryMetaInfo(r3, r11, r12, r13, r7, r8);
        L7:
            r7 = r14;
            goto L9
        L11:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollectMemoryMetaInfo");
        }

        public static int getCountByPackageName(EpisodicMemoryDao r2, String r3) {
            EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(EpisodicMemoryDao r6, String r7, long r8, long r10) {
            EpisodicMemoryDao r9 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r6, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(EpisodicMemoryDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<EpisodicMemoryEntity> getEpisodicMemoryEntityByEntities(EpisodicMemoryDao r12, List<String> r13) {
            EpisodicMemoryDao r14 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r12, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "entityDbIds");
            if (r15.isEmpty() == true) goto L5;
            StringBuilder r0 = new StringBuilder().append("SELECT * FROM ShortMemory WHERE category = 0 AND id in (");
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r4 = r2.iterator();
        L8:
            if (r4.hasNext() == false) goto L11;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
            r3.add('?');
            goto L8
        L11:
            return r14.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r0.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append(')').toString(), ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        L5:
            return CollectionsKt.emptyList();
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(EpisodicMemoryDao r6, String r7, long r8, long r10) {
            EpisodicMemoryDao r9 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r6, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(EpisodicMemoryDao r2, String r3) {
            EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00ee -> B:21:0x00f3). Please report as a decompilation issue!!! */
        public static Object getMemoryCountsByTimeRanges(EpisodicMemoryDao r12, List<Pair<Long, Long>> r13, Continuation<? super List<Integer>> r14) {
            EpisodicMemoryDao r15 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r12, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r17, AnonymousClass1.class) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r17, AnonymousClass1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r18 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$3, Collection.class, "com.obric.memorydata.plugin");
            Iterator r110 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$2, Iterator.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$1, Collection.class, "com.obric.memorydata.plugin");
            EpisodicMemoryDao r5 = (EpisodicMemoryDao) ZeusTransformUtils.preCheckCast(r0.L$0, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
            AnonymousClass1 r11 = r0;
            Iterator r1 = r110;
            EpisodicMemoryDao r111 = r5;
            Object r6 = r2;
            AnonymousClass1 r7 = r11;
        L21:
            r19.add(Boxing.boxInt(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue()));
            Iterator r112 = r1;
            r0 = r7;
            r19 = r4;
            r2 = r6;
        L16:
            if (r112.hasNext() == false) goto L23;
            Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(r112.next(), Pair.class, "com.obric.memorydata.plugin");
            long r9 = ((Number) ZeusTransformUtils.preCheckCast(r8.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();
            long r10 = ((Number) ZeusTransformUtils.preCheckCast(r8.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
            r0.L$0 = r111;
            r0.L$1 = r19;
            r0.L$2 = r112;
            r0.L$3 = r19;
            r0.label = 1;
            Object r20 = r111.getMemoryCountByTimeRange(r9, r10, r0);
            if (r20 != r2) goto L20;
            return r2;
        L20:
            r6 = r2;
            r7 = r0;
            r1 = r112;
            r18 = r20;
            r4 = r19;
            goto L21
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r18);
            Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
            Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r115 = r113.iterator();
            r111 = r15;
            r19 = r114;
            r112 = r115;
        L7:
            r0 = new AnonymousClass1(r17);
            goto L8
        }

        public static List<String> getPackageNameList(EpisodicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(EpisodicMemoryDao r2) {
            EpisodicMemoryDao r3 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            return "ShortMemory";
        }

        public static List<EpisodicMemoryEntity> queryAll(EpisodicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EpisodicMemoryDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static EpisodicMemoryEntity queryByEntityId(EpisodicMemoryDao r5, String r6) {
            EpisodicMemoryDao r7 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r5, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityId");
            return (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE entityId = ? LIMIT 1", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<EpisodicMemoryEntity> queryByEntityId(EpisodicMemoryDao r2, String r3, String r4) {
            EpisodicMemoryDao r5 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<EpisodicMemoryEntity> queryByEntityIdList(EpisodicMemoryDao r2, List<String> r3) {
            EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<EpisodicMemoryEntity> queryByEntityIdListAndPackageName(EpisodicMemoryDao r2, List<String> r3, String r4) {
            EpisodicMemoryDao r5 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static EpisodicMemoryEntity queryById(EpisodicMemoryDao r2, long r3) {
            return (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<EpisodicMemoryEntity> queryByIdAndTimestamp(EpisodicMemoryDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<EpisodicMemoryEntity> queryByIds(EpisodicMemoryDao r2, List<Long> r3) {
            EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(EpisodicMemoryDao r2, String[] r3, String r4, int r5, Long r6) {
            EpisodicMemoryDao r7 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<EpisodicMemoryEntity> queryByPackageName(EpisodicMemoryDao r2, String r3) {
            EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<EpisodicMemoryEntity> queryByPackageNameBeforeTimestampWithLimit(EpisodicMemoryDao r7, String r8, long r9, int r11, long r12) {
            EpisodicMemoryDao r10 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r7, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<EpisodicMemoryEntity> queryByPackageNameWithLimit(EpisodicMemoryDao r2, String r3, int r4, long r5) {
            EpisodicMemoryDao r6 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static EpisodicMemoryEntity queryByUUID(EpisodicMemoryDao r2, String r3) {
            EpisodicMemoryDao r4 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static EpisodicMemoryEntity queryOne(EpisodicMemoryDao r2) {
            return (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<EpisodicMemoryEntity> queryRecentByPackageName(EpisodicMemoryDao r2, String r3, long r4) {
            EpisodicMemoryDao r5 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<EpisodicMemoryEntity> queryWithLimitAndOffset(EpisodicMemoryDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(EpisodicMemoryDao r2, String r3, String r4, int r5, Integer r6) {
            EpisodicMemoryDao r7 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.database.dao.EpisodicMemoryDao$getMemoryCountsByTimeRanges$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.database.dao.EpisodicMemoryDao$DefaultImpls", f = "EpisodicMemoryDao.kt", i = {0, 0}, l = {229}, m = "getMemoryCountsByTimeRanges", n = {"$this", "destination$iv$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.getMemoryCountsByTimeRanges(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    int deleteById(long r1);

    i<Integer> getAllCollectMemoryWithRelevantCount();

    PagingSource<Integer, bt> getAllCollectMemoryWithRelevantPojo();

    List<EpisodicMemoryEntity> getAllMemory();

    List<EpisodicMemoryEntity> getAllMemoryForTracker();

    i<Integer> getAllObservationMemoryCount(long r1, long r3);

    Object getAllObservationMemoryMetaInfo(List<String> r1, boolean r2, boolean r3, Continuation<? super List<cu>> r4);

    Object getAllObservationMemoryMetaInfoWithTimestamp(List<String> r1, boolean r2, long r3, long r5, boolean r7, Continuation<? super List<cu>> r8);

    PagingSource<Integer, EpisodicMemoryEntity> getAllRecommendMemory();

    PagingSource<Integer, EpisodicMemoryEntity> getAllRecommendMemoryByTimeRange(long r1, long r3);

    Object getCollectMemoryMetaInfo(List<String> r1, boolean r2, String r3, Integer r4, boolean r5, Continuation<? super List<cu>> r6);

    i<List<al>> getCollectMemorySourceStats();

    bt getCollectMemoryWithRelevantByEntityId(String r1);

    List<bt> getCollectMemoryWithRelevantByEntityIds(List<String> r1);

    PagingSource<Integer, bt> getCollectMemoryWithRelevantPojoBySource(String r1, int r2);

    List<EpisodicMemoryEntity> getEpisodicMemoryEntity(String r1);

    List<EpisodicMemoryEntity> getEpisodicMemoryEntityByEntities(List<String> r1);

    Object getMemoryCountByTimeRange(long r1, long r3, Continuation<? super Integer> r5);

    Object getMemoryCountsByTimeRanges(List<Pair<Long, Long>> r1, Continuation<? super List<Integer>> r2);

    List<String> getScreenMemoryDateList();

    Long getScreenMemoryValidateDay(long r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<String> getUUIDListByEntityIds(List<String> r1);

    Long latestValidCreateTime();

    List<EpisodicMemoryEntity> queryAudioMemoryReviewPage(long r1, long r3, long r5, String r7, int r8);

    EpisodicMemoryEntity queryByEntityId(String r1);

    List<EpisodicMemoryEntity> queryByEntityIds(List<String> r1);

    List<EpisodicMemoryEntity> queryByProductType(int r1);

    List<EpisodicMemoryEntity> queryByProductTypeAfterId(int r1, long r2, int r4);

    List<EpisodicMemoryEntity> queryByTime(long r1, long r3, int r5);

    List<bt> queryCollectionMemoryReviewPage(long r1, long r3, long r5, String r7, int r8);

    List<EpisodicMemoryEntity> queryContextAwarenessScreenPage(long r1, long r3, long r5, String r7, int r8, int r9);

    List<EpisodicMemoryEntity> queryContextAwarenessScreenPageBefore(long r1, long r3, long r5, String r7, int r8, int r9);

    List<String> queryExistingEntityIds(List<String> r1);

    List<String> queryExistingUuids(List<String> r1);

    List<EpisodicMemoryEntity> queryScreenMemoryReviewPage(long r1, long r3, long r5, String r7, int r8);

    void resetSequence();
}
