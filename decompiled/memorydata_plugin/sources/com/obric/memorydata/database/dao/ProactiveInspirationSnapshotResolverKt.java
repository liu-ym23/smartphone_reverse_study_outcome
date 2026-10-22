package com.obric.memorydata.database.dao;

import androidx.core.app.NotificationCompat;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.memorydata.database.entity.et;
import com.obric.memorydata.database.entity.ez;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u001a\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u001a\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u001a\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\u001a.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013\u001a.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013\u001a\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0014*\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u0014*\u00020\nH\u0002\u001a\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u0014*\u00020\u000eH\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001c"}, d2 = {"SNAPSHOT_RESOLVER_TAG", "", "snapshotResolverGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lcom/google/gson/Gson;", "prepareResolvedRecommendationRows", "", "Lcom/obric/memorydata/database/dao/PreparedRecommendationResolution;", "rows", "Lcom/obric/memorydata/database/entity/ProactiveInspirationEntity;", "collectFallbackRecommendationIds", "prepareResolvedBatchSeedRows", "Lcom/obric/memorydata/database/dao/PreparedBatchSeedResolution;", "Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedSnapshotRow;", "collectFallbackRecommendationIdsForBatchSeeds", "resolveRecommendationRows", "Lcom/obric/memorydata/database/dao/ProactiveInspirationRecommendationRow;", "fallbackRecommendations", "", "Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", "resolveBatchSeedRows", "Lcom/obric/memorydata/database/dao/ProactiveInspirationBatchSeedRow;", "toRecommendationSnapshotOrNull", "expectedRecommendId", "resolveSnapshotRecommendation", "toRecommendationRow", NotificationCompat.CATEGORY_RECOMMENDATION, "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProactiveInspirationSnapshotResolverKt {
    private static final String SNAPSHOT_RESOLVER_TAG = "ProactiveInspirationDao";
    private static final Gson snapshotResolverGson = null;

    static {
        snapshotResolverGson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Boolean.TYPE, Type.class, "com.obric.memorydata.plugin"), SnapshotBooleanDeserializer.INSTANCE).registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Boolean.TYPE, Type.class, "com.obric.memorydata.plugin"), SnapshotBooleanDeserializer.INSTANCE).create();
    }

    public static final List<String> collectFallbackRecommendationIds(List<PreparedRecommendationResolution> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "rows");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        PreparedRecommendationResolution r2 = (PreparedRecommendationResolution) ZeusTransformUtils.preCheckCast(r7.next(), PreparedRecommendationResolution.class, "com.obric.memorydata.plugin");
        if (r2.getSnapshotRecommendation() != null) goto L8;
        String r3 = r2.getInspiration().c();
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = null;
        goto L9
    L12:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static final List<String> collectFallbackRecommendationIdsForBatchSeeds(List<PreparedBatchSeedResolution> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "rows");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        PreparedBatchSeedResolution r2 = (PreparedBatchSeedResolution) ZeusTransformUtils.preCheckCast(r7.next(), PreparedBatchSeedResolution.class, "com.obric.memorydata.plugin");
        if (r2.getSnapshotRecommendation() != null) goto L8;
        String r3 = r2.getSeed().getRecommendId();
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = null;
        goto L9
    L12:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static final List<PreparedBatchSeedResolution> prepareResolvedBatchSeedRows(List<ProactiveInspirationBatchSeedSnapshotRow> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "rows");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        ProactiveInspirationBatchSeedSnapshotRow r2 = (ProactiveInspirationBatchSeedSnapshotRow) ZeusTransformUtils.preCheckCast(r8.next(), ProactiveInspirationBatchSeedSnapshotRow.class, "com.obric.memorydata.plugin");
        r0.add(new PreparedBatchSeedResolution(r2, resolveSnapshotRecommendation(r2)));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final List<PreparedRecommendationResolution> prepareResolvedRecommendationRows(List<et> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "rows");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        et r2 = (et) ZeusTransformUtils.preCheckCast(r8.next(), et.class, "com.obric.memorydata.plugin");
        r0.add(new PreparedRecommendationResolution(r2, resolveSnapshotRecommendation(r2)));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final List<ProactiveInspirationBatchSeedRow> resolveBatchSeedRows(List<PreparedBatchSeedResolution> r23, Map<String, ez> r24) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "rows");
        Intrinsics.checkNotNullParameter(r2, "fallbackRecommendations");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L4:
        if (r5.hasNext() == false) goto L17;
        PreparedBatchSeedResolution r9 = (PreparedBatchSeedResolution) ZeusTransformUtils.preCheckCast(r5.next(), PreparedBatchSeedResolution.class, "com.obric.memorydata.plugin");
        ez r10 = r9.getSnapshotRecommendation();
        if (r10 != null) goto L8;
        r10 = (ez) ZeusTransformUtils.preCheckCast(r2.get(r9.getSeed().getRecommendId()), ez.class, "com.obric.memorydata.plugin");
    L8:
        if (r10 != null) goto L11;
        r6 = r6 + 1;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SNAPSHOT_RESOLVER_TAG, "missing batchSeed fallback recommendId=" + r9.getSeed().getRecommendId(), null, 4, null);
        ProactiveInspirationBatchSeedRow r11 = null;
    L15:
        if (r11 == null) goto L4;
        r4.add(r11);
        goto L4
    L11:
        if (r9.getSnapshotRecommendation() == null) goto L13;
        r7 = r7 + 1;
    L14:
        r11 = new ProactiveInspirationBatchSeedRow(r9.getSeed().getInspirationRowId(), r9.getSeed().getInspirationUpdated(), r9.getSeed().getRecommendStatus(), r10.p(), r10.j(), r10.l());
        goto L15
    L13:
        r8 = r8 + 1;
        goto L14
    L17:
        List<ProactiveInspirationBatchSeedRow> r12 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        RunLog.INSTANCE.debug(SNAPSHOT_RESOLVER_TAG, "resolveBatchSeedRows total=" + r0.size() + " snapshotHit=" + r7 + " fallbackHit=" + r8 + " missing=" + r6);
    L20:
        return r12;
    }

    public static final List<ProactiveInspirationRecommendationRow> resolveRecommendationRows(List<PreparedRecommendationResolution> r14, Map<String, ez> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Map r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "rows");
        Intrinsics.checkNotNullParameter(r17, "fallbackRecommendations");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r1.hasNext() == false) goto L17;
        PreparedRecommendationResolution r6 = (PreparedRecommendationResolution) ZeusTransformUtils.preCheckCast(r1.next(), PreparedRecommendationResolution.class, "com.obric.memorydata.plugin");
        ez r7 = r6.getSnapshotRecommendation();
        if (r7 != null) goto L8;
        r7 = (ez) ZeusTransformUtils.preCheckCast(r17.get(r6.getInspiration().c()), ez.class, "com.obric.memorydata.plugin");
    L8:
        if (r7 != null) goto L11;
        r3 = r3 + 1;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SNAPSHOT_RESOLVER_TAG, "missing recommendation fallback recommendId=" + r6.getInspiration().c(), null, 4, null);
        ProactiveInspirationRecommendationRow r8 = null;
    L15:
        if (r8 == null) goto L4;
        r2.add(r8);
        goto L4
    L11:
        if (r6.getSnapshotRecommendation() == null) goto L13;
        r4 = r4 + 1;
    L14:
        r8 = toRecommendationRow(r6.getInspiration(), r7);
        goto L15
    L13:
        r5 = r5 + 1;
        goto L14
    L17:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        final Comparator r9 = (Comparator) ZeusTransformUtils.preCheckCast(new ProactiveInspirationSnapshotResolverKt$resolveRecommendationRows$$inlined$compareByDescending$1(), Comparator.class, "com.obric.memorydata.plugin");
        List<ProactiveInspirationRecommendationRow> r19 = CollectionsKt.sortedWith(r18, (Comparator) ZeusTransformUtils.preCheckCast(new ProactiveInspirationSnapshotResolverKt$resolveRecommendationRows$$inlined$thenByDescending$1(r9), Comparator.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SNAPSHOT_RESOLVER_TAG, "resolveRecommendationRows total=" + r16.size() + " snapshotHit=" + r4 + " fallbackHit=" + r5 + " missing=" + r3, false, 4, null);
    L20:
        return r19;
    }

    private static final ez resolveSnapshotRecommendation(ProactiveInspirationBatchSeedSnapshotRow r1) {
        return toRecommendationSnapshotOrNull(r1.getRecommendationSnapshot(), r1.getRecommendId());
    }

    private static final ez resolveSnapshotRecommendation(et r1) {
        return toRecommendationSnapshotOrNull(r1.g(), r1.c());
    }

    private static final ProactiveInspirationRecommendationRow toRecommendationRow(et r38, ez r39) {
        Object r2 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        String r1 = r38.g();     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        Long r3 = Long.valueOf(new JSONObject(r1).optLong("expire_at_ms", 0));     // Catch: Throwable -> L14
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
    L12:
        Object r5 = Result.m1421constructorimpl(r3);     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r5) == true) goto L21;
        r2 = r5;
    L21:
        return new ProactiveInspirationRecommendationRow(r38.a(), r39.a(), r39.b(), r38.h(), r38.i(), r38.j(), r38.k(), r38.l(), r38.d(), r38.e(), r38.f(), r39.c(), r39.d(), r39.e(), r39.f(), r39.g(), r39.h(), r39.i(), r39.j(), r39.k(), r39.o(), r39.p(), r39.l(), r39.m(), r39.n(), r39.getType(), (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin"));
    L8:
        r4 = false;
    L11:
        r3 = null;
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private static final ez toRecommendationSnapshotOrNull(String r8, String r9) {
        Object r0 = null;
        if (r8 == null) goto L5;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L32;
        return null;
    L32:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        ez r11 = (ez) ZeusTransformUtils.preCheckCast(snapshotResolverGson.fromJson(r10, ez.class), ez.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r11 == null) goto L21;
        boolean r3 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L16;
    L18:
        r3 = false;
    L19:
        if (r3 == false) goto L21;
    L22:
        Object r12 = Result.m1421constructorimpl(r11);     // Catch: Throwable -> L24
    L27:
        if (Result.m1424exceptionOrNullimpl(r12) != null) goto L29;
        r0 = r12;
    L31:
        return (ez) ZeusTransformUtils.preCheckCast(r0, ez.class, "com.obric.memorydata.plugin");
    L29:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SNAPSHOT_RESOLVER_TAG, "recommendationSnapshot parse failed recommendId=" + r9, null, 4, null);
        goto L31
    L16:
        if (Intrinsics.areEqual(r11.a(), r9) == false) goto L18;
    L21:
        r11 = null;
    L24:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    L5:
        r10 = null;
        goto L6
    }
}
