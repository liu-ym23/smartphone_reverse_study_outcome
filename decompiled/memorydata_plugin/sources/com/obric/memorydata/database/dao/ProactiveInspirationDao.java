package com.obric.memorydata.database.dao;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.et;
import com.obric.memorydata.database.entity.ez;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\bH'J \u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H'J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\nH'J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0016J\"\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\n0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\nH'J4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH'J4\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0017J:\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH'J:\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0016J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u001e\u001a\u00020\bH'J$\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u001e\u001a\u00020\bH\u0017J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\nH'J\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'0*2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\nH'J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0016J\"\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\n0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\nH'J\"\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\n0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0016¨\u00061"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveInspirationDao;", "", "upsert", "", "entity", "Lcom/obric/memorydata/database/entity/ProactiveInspirationEntity;", "getById", "inspirationId", "", "listByRecommendId", "", "recommendId", "updateRecommendStatus", "", "recommendStatus", "updated", "", "updateIsDeleteBySubscriptionId", "subscriptionId", "isDelete", "", "listSeedRowsByIds", "rowIds", "listJoinedRowsByIds", "Lcom/obric/memorydata/database/dao/ProactiveInspirationRecommendationRow;", "observeAllDayHeadersByRecommendStatuses", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/memorydata/database/dao/ProactiveDayHeaderRow;", "recommendStatuses", "listDaySeedRowsByDayKey", "dayKey", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "listDayJoinedByDayKey", "observeDaySeedRowsByDayKey", "observeDayJoinedByDayKey", "listAllDaySeedRowsByDayKey", "listAllDayJoinedByDayKey", "listRecommendationsByIdsRaw", "Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", "recommendIds", "listRecommendationsByIds", "", "listBatchSeedSnapshotRowsByRecommendStatuses", "Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedSnapshotRow;", "listBatchSeedRowsByRecommendStatuses", "Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedRow;", "observeBatchSeedSnapshotRowsByRecommendStatuses", "observeBatchSeedRowsByRecommendStatuses", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveInspirationDao {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static List<ProactiveInspirationRecommendationRow> listAllDayJoinedByDayKey(ProactiveInspirationDao r2, List<Integer> r3, String r4) {
            ProactiveInspirationDao r5 = (ProactiveInspirationDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveInspirationDao.class, "com.obric.memorydata.plugin");
            List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "recommendStatuses");
            Intrinsics.checkNotNullParameter(r4, "dayKey");
            List<PreparedRecommendationResolution> r7 = ProactiveInspirationSnapshotResolverKt.prepareResolvedRecommendationRows(r5.listAllDaySeedRowsByDayKey(r6, r4));
            return ProactiveInspirationSnapshotResolverKt.resolveRecommendationRows(r7, r5.listRecommendationsByIds(ProactiveInspirationSnapshotResolverKt.collectFallbackRecommendationIds(r7)));
        }

        public static List<ProactiveInspirationBatchSeedRow> listBatchSeedRowsByRecommendStatuses(ProactiveInspirationDao r2, List<Integer> r3) {
            ProactiveInspirationDao r4 = (ProactiveInspirationDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveInspirationDao.class, "com.obric.memorydata.plugin");
            List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "recommendStatuses");
            List<PreparedBatchSeedResolution> r6 = ProactiveInspirationSnapshotResolverKt.prepareResolvedBatchSeedRows(r4.listBatchSeedSnapshotRowsByRecommendStatuses(r5));
            return ProactiveInspirationSnapshotResolverKt.resolveBatchSeedRows(r6, r4.listRecommendationsByIds(ProactiveInspirationSnapshotResolverKt.collectFallbackRecommendationIdsForBatchSeeds(r6)));
        }

        public static List<ProactiveInspirationRecommendationRow> listDayJoinedByDayKey(ProactiveInspirationDao r2, List<Integer> r3, String r4, int r5, int r6) {
            ProactiveInspirationDao r7 = (ProactiveInspirationDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveInspirationDao.class, "com.obric.memorydata.plugin");
            List<Integer> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "recommendStatuses");
            Intrinsics.checkNotNullParameter(r4, "dayKey");
            List<PreparedRecommendationResolution> r9 = ProactiveInspirationSnapshotResolverKt.prepareResolvedRecommendationRows(r7.listDaySeedRowsByDayKey(r8, r4, r5, r6));
            return ProactiveInspirationSnapshotResolverKt.resolveRecommendationRows(r9, r7.listRecommendationsByIds(ProactiveInspirationSnapshotResolverKt.collectFallbackRecommendationIds(r9)));
        }

        public static List<ProactiveInspirationRecommendationRow> listJoinedRowsByIds(ProactiveInspirationDao r2, List<Long> r3) {
            ProactiveInspirationDao r4 = (ProactiveInspirationDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveInspirationDao.class, "com.obric.memorydata.plugin");
            List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rowIds");
            if (r5.isEmpty() == true) goto L5;
            List<PreparedRecommendationResolution> r6 = ProactiveInspirationSnapshotResolverKt.prepareResolvedRecommendationRows(r4.listSeedRowsByIds(r5));
            return ProactiveInspirationSnapshotResolverKt.resolveRecommendationRows(r6, r4.listRecommendationsByIds(ProactiveInspirationSnapshotResolverKt.collectFallbackRecommendationIds(r6)));
        L5:
            return CollectionsKt.emptyList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Map<String, ez> listRecommendationsByIds(ProactiveInspirationDao r3, List<String> r4) {
            ProactiveInspirationDao r5 = (ProactiveInspirationDao) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveInspirationDao.class, "com.obric.memorydata.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "recommendIds");
            if (r6.isEmpty() == true) goto L5;
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5.listRecommendationsByIdsRaw(r6), Iterable.class, "com.obric.memorydata.plugin");
            Map<String, ez> r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
            Iterator r9 = r7.iterator();
        L8:
            if (r9.hasNext() == false) goto L10;
            Object r0 = r9.next();
            r8.put(((ez) ZeusTransformUtils.preCheckCast(r0, ez.class, "com.obric.memorydata.plugin")).a(), r0);
            goto L8
        L10:
            return r8;
        L5:
            return MapsKt.emptyMap();
        }

        public static i<List<ProactiveInspirationBatchSeedRow>> observeBatchSeedRowsByRecommendStatuses(ProactiveInspirationDao r2, List<Integer> r3) {
            final ProactiveInspirationDao r4 = (ProactiveInspirationDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveInspirationDao.class, "com.obric.memorydata.plugin");
            List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "recommendStatuses");
            final i<List<ProactiveInspirationBatchSeedSnapshotRow>> r6 = r4.observeBatchSeedSnapshotRowsByRecommendStatuses(r5);
            return (i) ZeusTransformUtils.preCheckCast(new ProactiveInspirationDao$DefaultImpls$observeBatchSeedRowsByRecommendStatuses$$inlined$map$1(r6, r4), i.class, "com.obric.memorydata.plugin");
        }

        public static i<List<ProactiveInspirationRecommendationRow>> observeDayJoinedByDayKey(ProactiveInspirationDao r2, List<Integer> r3, String r4, int r5, int r6) {
            final ProactiveInspirationDao r7 = (ProactiveInspirationDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveInspirationDao.class, "com.obric.memorydata.plugin");
            List<Integer> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "recommendStatuses");
            Intrinsics.checkNotNullParameter(r4, "dayKey");
            final i<List<et>> r9 = r7.observeDaySeedRowsByDayKey(r8, r4, r5, r6);
            return (i) ZeusTransformUtils.preCheckCast(new ProactiveInspirationDao$DefaultImpls$observeDayJoinedByDayKey$$inlined$map$1(r9, r7), i.class, "com.obric.memorydata.plugin");
        }
    }

    et getById(String r1);

    List<ProactiveInspirationRecommendationRow> listAllDayJoinedByDayKey(List<Integer> r1, String r2);

    List<et> listAllDaySeedRowsByDayKey(List<Integer> r1, String r2);

    List<ProactiveInspirationBatchSeedRow> listBatchSeedRowsByRecommendStatuses(List<Integer> r1);

    List<ProactiveInspirationBatchSeedSnapshotRow> listBatchSeedSnapshotRowsByRecommendStatuses(List<Integer> r1);

    List<et> listByRecommendId(String r1);

    List<ProactiveInspirationRecommendationRow> listDayJoinedByDayKey(List<Integer> r1, String r2, int r3, int r4);

    List<et> listDaySeedRowsByDayKey(List<Integer> r1, String r2, int r3, int r4);

    List<ProactiveInspirationRecommendationRow> listJoinedRowsByIds(List<Long> r1);

    Map<String, ez> listRecommendationsByIds(List<String> r1);

    List<ez> listRecommendationsByIdsRaw(List<String> r1);

    List<et> listSeedRowsByIds(List<Long> r1);

    i<List<ProactiveDayHeaderRow>> observeAllDayHeadersByRecommendStatuses(List<Integer> r1);

    i<List<ProactiveInspirationBatchSeedRow>> observeBatchSeedRowsByRecommendStatuses(List<Integer> r1);

    i<List<ProactiveInspirationBatchSeedSnapshotRow>> observeBatchSeedSnapshotRowsByRecommendStatuses(List<Integer> r1);

    i<List<ProactiveInspirationRecommendationRow>> observeDayJoinedByDayKey(List<Integer> r1, String r2, int r3, int r4);

    i<List<et>> observeDaySeedRowsByDayKey(List<Integer> r1, String r2, int r3, int r4);

    int updateIsDeleteBySubscriptionId(String r1, boolean r2, long r3);

    int updateRecommendStatus(String r1, int r2, long r3);

    void upsert(et r1);
}
