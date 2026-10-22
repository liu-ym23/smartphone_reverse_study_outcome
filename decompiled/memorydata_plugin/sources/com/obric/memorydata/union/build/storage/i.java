package com.obric.memorydata.union.build.storage;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.database.dao.SemanticRetractionReason;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a2\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001aF\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\rH\u0000\u001a \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0000\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001aJ\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0007\"\u0004\b\u0000\u0010\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00072\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00040\rH\u0000\u001a>\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010!\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0000\u001a\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0000\u001a)\u0010'\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00112\b\u0010)\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\u0010*\u001a4\u0010+\u001a\u00020,2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010.\u001a\u00020\u000bH\u0000\u001a\u0018\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0000\u001a\u001a\u00101\u001a\u00020%*\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u001a\u001e\u00102\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00103\u001a\u00020\bH\u0002¨\u00064"}, d2 = {"semanticDependencyFailure", "", "expected", "", "", "current", "currentSemanticTargets", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "existing", "migrationOperation", "", ChatMessage.TYPE_QUERY, "Lkotlin/Function1;", "normalizeSemanticProducerFields", "Lcom/obric/memorydata/union/build/storage/SemanticProducerFields;", "productType", "", "description", "confidence", "", "orderMigrationSources", "sources", "orderMigrationSourcesBy", ExifInterface.GPS_DIRECTION_TRUE, "createTime", "databaseId", "semanticPolicyFailure", "operation", "Lcom/obric/memorydata/union/build/storage/SemanticBatchOperation;", "targets", "Lcom/obric/memorydata/union/build/storage/SemanticPolicyTarget;", "expectedChangeSeqs", "allowProactiveWrite", "normalizeHotWords", "hotWords", "rejectMigrationOnlyControls", "", "payload", "resolveSemanticMigrationVersion", "requestedVersion", "existingVersion", "(ILjava/lang/Integer;Ljava/lang/Integer;)I", "calculateHotWordDiff", "Lcom/obric/memorydata/union/build/storage/HotWordDiff;", "requested", "preserveExisting", "buildSemanticEmbeddingContent", "keyPhrase", "aggregateLatestSourceMetadata", "mergedEvidenceIds", "entity", "memory_build_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class i {

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f13124a;

        public c(Function1 r3) {
            this.f13124a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            Function1 r2 = this.f13124a;
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r4), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r3), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f13125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f13126b;

        public d(Comparator r3, Function1 r4) {
            Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            this.f13125a = r5;
            this.f13126b = r6;
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r0 = this.f13125a.compare(r3, r4);
            if (r0 != 0) goto L7;
            Function1 r2 = this.f13126b;
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r4), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r3), Comparable.class, "com.obric.memorydata.plugin"));
        L7:
            return r0;
        }
    }

    public static final int a(int r4, Integer r5, Integer r6) {
        int r0 = 0;
        if (r6 == null) goto L5;
    L10:
        if (r5 != null) goto L15;
        if (r6 != null) goto L14;
        return 0;
    L14:
        return r6.intValue();
    L15:
        return r5.intValue();
    L5:
        if (SetsKt.setOf(new Integer[]{1001, 1003}).contains(Integer.valueOf(r4)) == false) goto L10;
        if (r5 == null) goto L9;
        r0 = r5.intValue();
    L9:
        return Math.max(r0, 1);
    }

    private static final long a(ip r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.getCreateTime();
    }

    public static final com.obric.memorydata.union.build.storage.a a(Map<Long, String> r8, List<String> r9, boolean r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "existing");
        Intrinsics.checkNotNullParameter(r12, "requested");
        List<String> r13 = b(r12);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r3 = r1.next();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Locale r7 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r7, "ROOT");
        String r5 = r6.toLowerCase(r7);
        Intrinsics.checkNotNullExpressionValue(r5, "toLowerCase(...)");
        r2.put(r5, r3);
        goto L4
    L6:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r11.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r4.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        Locale r17 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r17, "ROOT");
        String r18 = r16.toLowerCase(r17);
        Intrinsics.checkNotNullExpressionValue(r18, "toLowerCase(...)");
        r14.add(r18);
        goto L8
    L10:
        Set r19 = (Set) ZeusTransformUtils.preCheckCast(r14, Set.class, "com.obric.memorydata.plugin");
        if (r10 == false) goto L13;
        List r20 = CollectionsKt.emptyList();
    L20:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r21.iterator();
    L22:
        if (r22.hasNext() == false) goto L27;
        Object r23 = r22.next();
        String r24 = (String) ZeusTransformUtils.preCheckCast(r23, String.class, "com.obric.memorydata.plugin");
        Locale r25 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r25, "ROOT");
        String r26 = r24.toLowerCase(r25);
        Intrinsics.checkNotNullExpressionValue(r26, "toLowerCase(...)");
        if ((!r19.contains(r26)) == false) goto L22;
        r110.add(r23);
        goto L22
    L27:
        return new com.obric.memorydata.union.build.storage.a(r20, (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin"));
    L13:
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator r27 = r11.entrySet().iterator();
    L15:
        if (r27.hasNext() == false) goto L19;
        Map.Entry r28 = (Map.Entry) ZeusTransformUtils.preCheckCast(r27.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r29 = (String) ZeusTransformUtils.preCheckCast(r28.getValue(), String.class, "com.obric.memorydata.plugin");
        Locale r30 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r30, "ROOT");
        String r31 = r29.toLowerCase(r30);
        Intrinsics.checkNotNullExpressionValue(r31, "toLowerCase(...)");
        if ((!r2.containsKey(r31)) == false) goto L15;
        r111.put(r28.getKey(), r28.getValue());
        goto L15
    L19:
        r20 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r111, Map.class, "com.obric.memorydata.plugin")).keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L20
    }

    public static final r a(int r1, String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "description");
        if (r1 != 1003) goto L6;
        return new r("用户主动记忆", 4.0f);
    L6:
        return new r(r2, r3);
    }

    public static final String a(SemanticBatchOperation r10, List<q> r11, Map<String, Long> r12, boolean r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "operation");
        Intrinsics.checkNotNullParameter(r14, "targets");
        Intrinsics.checkNotNullParameter(r15, "expectedChangeSeqs");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r10.getEntityIds(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L3:
        boolean r4 = true;
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L3;
        r2.add(r3);
        goto L3
    L8:
        List r5 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L11;
    L13:
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L12;
        if ((!r15.containsKey((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"))) == false) goto L15;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
        return "TARGET_NOT_READ";
    L22:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L25;
    L27:
        Iterator r16 = r9.iterator();
    L29:
        if (r16.hasNext() == false) goto L26;
        if ((!r15.containsKey(((q) ZeusTransformUtils.preCheckCast(r16.next(), q.class, "com.obric.memorydata.plugin")).a())) == false) goto L29;
        boolean r17 = true;
    L33:
        if (r17 == false) goto L35;
        return "TARGET_NOT_READ";
    L35:
        String r18 = r10.getRequeueKeeperId();
        if (r18 == null) goto L60;
        if (Intrinsics.areEqual(r10.getOperateType(), "delete") == true) goto L40;
        return "INVALID_CONFLICT_KEEPER";
    L40:
        if (Intrinsics.areEqual(r10.getWritePurpose(), "conflict_resolution") == true) goto L42;
        return "INVALID_CONFLICT_KEEPER";
    L42:
        if (Intrinsics.areEqual(r10.getRetractionReason(), SemanticRetractionReason.CONFLICT_DISCARD) == true) goto L44;
        return "INVALID_CONFLICT_KEEPER";
    L44:
        if (r5.size() == 1) goto L46;
        return "INVALID_CONFLICT_KEEPER";
    L46:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L48;
        return "INVALID_CONFLICT_KEEPER";
    L48:
        if (r5.contains(r18) == false) goto L50;
        return "INVALID_CONFLICT_KEEPER";
    L50:
        if (r14.size() != 2) goto L137;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L53:
        if (r21.hasNext() == false) goto L56;
        r20.add(((q) ZeusTransformUtils.preCheckCast(r21.next(), q.class, "com.obric.memorydata.plugin")).a());
        goto L53
    L56:
        if (Intrinsics.areEqual(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"), r18), Iterable.class, "com.obric.memorydata.plugin"))) == true) goto L60;
        return "INVALID_CONFLICT_KEEPER";
    L137:
        return "INVALID_CONFLICT_KEEPER";
    L60:
        if (Intrinsics.areEqual(r10.getWritePurpose(), "conflict_resolution") == true) goto L62;
    L64:
        boolean r110 = false;
    L65:
        if (r13 == true) goto L86;
        if (r110 == true) goto L86;
        if (Intrinsics.areEqual(r10.getOperateType(), "delete") == false) goto L86;
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r111, Collection.class) == true) goto L72;
    L74:
        Iterator r112 = r111.iterator();
    L76:
        if (r112.hasNext() == false) goto L73;
        if (((q) ZeusTransformUtils.preCheckCast(r112.next(), q.class, "com.obric.memorydata.plugin")).b() != 1003) goto L80;
        boolean r113 = true;
    L81:
        if (r113 == false) goto L76;
        boolean r114 = true;
    L83:
        if (r114 == false) goto L86;
        return "PROACTIVE_WRITE_FORBIDDEN";
    L80:
        r113 = false;
    L73:
        r114 = false;
        goto L83
    L72:
        if (((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L74;
    L86:
        SemanticBatchEntityPayload r115 = r10.getEntity();
        if (Intrinsics.areEqual(r10.getOperateType(), "delete") == true) goto L113;
        if (r115 != null) goto L90;
        return null;
    L90:
        if (Intrinsics.areEqual(r10.getOperateType(), "insert") == true) goto L94;
        if (r115.getSemanticType() != null) goto L94;
    L97:
        String r116 = r115.getTagPath();
        if (r116 != null) goto L100;
        r116 = "";
    L100:
        String r117 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (Intrinsics.areEqual(r10.getOperateType(), "insert") == true) goto L105;
        if (r115.getTagPath() != null) goto L105;
        return null;
    L105:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L108;
        r4 = false;
    L108:
        if (r4 == false) goto L110;
        return "INVALID_CONTENT_SUBTYPE";
    L110:
        if (r117.length() <= 80) goto L142;
        return "INVALID_CONTENT_SUBTYPE";
    L142:
        return null;
    L94:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new String[]{"userinfo", "preference", "relationship"}), Iterable.class, "com.obric.memorydata.plugin"), r115.getSemanticType()) == true) goto L97;
        return "INVALID_CONTENT_TYPE";
    L113:
        return null;
    L62:
        if (Intrinsics.areEqual(r10.getOperateType(), "delete") == false) goto L64;
        r110 = true;
    L26:
        r17 = false;
        goto L33
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
    L12:
        r8 = false;
        goto L20
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
        goto L12
    }

    public static final String a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "keyPhrase");
        Intrinsics.checkNotNullParameter(r3, "description");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return r2;
    L6:
        return r2 + ',' + r3;
    }

    public static final /* synthetic */ String a(List r2, ip r3) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final String a(Map<String, Long> r9, Map<String, Long> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "expected");
        Intrinsics.checkNotNullParameter(r12, "current");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11.keySet(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if ((!r12.containsKey((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L17;
        return "TARGET_NOT_FOUND";
    L17:
        if (r11.isEmpty() == false) goto L19;
    L18:
        r3 = false;
    L30:
        if (r3 == false) goto L33;
        return "SEMANTIC_VERSION_CHANGED";
    L33:
        return null;
    L19:
        Iterator r13 = r11.entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L18;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        long r6 = ((Number) ZeusTransformUtils.preCheckCast(r4.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(r12.get(r5), Long.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L26;
    L27:
        boolean r8 = true;
    L29:
        if (r8 == false) goto L21;
    L26:
        if (r7.longValue() != r6) goto L27;
        r8 = false;
    L6:
        r2 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public static final List<ip> a(List<ip> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "sources");
        return a(r3, $$Lambda$i$XqBaczNjokFHDjCufEv9erT8b5M.INSTANCE, $$Lambda$i$Fxzx0d8Ec03pjciczOXiEXf4qA8.INSTANCE);
    }

    public static final <T> List<T> a(List<? extends T> r2, Function1<? super T, Long> r3, Function1<? super T, Long> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "sources");
        Intrinsics.checkNotNullParameter(r6, "createTime");
        Intrinsics.checkNotNullParameter(r7, "databaseId");
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new c(r6), Comparator.class, "com.obric.memorydata.plugin"), r7), Comparator.class, "com.obric.memorydata.plugin"));
    }

    public static final List<ip> a(List<ip> r5, boolean r6, Function1<? super List<String>, ? extends List<ip>> r7) {
        List<ip> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "existing");
        Intrinsics.checkNotNullParameter(r9, ChatMessage.TYPE_QUERY);
        if (r6 == false) goto L6;
        return r8;
    L6:
        if (r8.isEmpty() == true) goto L8;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        r0.add(((ip) ZeusTransformUtils.preCheckCast(r11.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L11
    L13:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r9.invoke((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        Object r1 = r14.next();
        r13.put(((ip) ZeusTransformUtils.preCheckCast(r1, ip.class, "com.obric.memorydata.plugin")).getEntityId(), r1);
        goto L15
    L17:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L19:
        if (r17.hasNext() == false) goto L26;
        Object r2 = r13.get(((ip) ZeusTransformUtils.preCheckCast(r17.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        if (r2 == null) goto L24;
        r16.add((ip) ZeusTransformUtils.preCheckCast(r2, ip.class, "com.obric.memorydata.plugin"));
        goto L19
    L24:
        throw new IllegalStateException("semantic target removed within batch".toString());
    L26:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    L8:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ void a(ip r2, List r3) {
        b(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "payload");
        JSONArray r11 = new JSONObject(r10).optJSONArray("operations");
        if (r11 != null) goto L5;
        r11 = new JSONArray();
    L5:
        List r0 = CollectionsKt.listOf(new String[]{"migration_operation", "migrationOperation", "reuse_source", "reuseSource", "write_retraction", "writeRetraction"});
        int r1 = r11.length();
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L25;
        JSONObject r4 = r11.optJSONObject(r3);
        if (r4 == null) goto L22;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        boolean r8 = true;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L13;
    L15:
        Iterator r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        if (r4.has((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L17;
        r8 = false;
    L21:
        if (r8 == true) goto L22;
        throw new IllegalArgumentException(("operation[" + r3 + "] contains migration-only controls").toString());
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
    L22:
        r3 = r3 + 1;
        goto L6
    }

    private static final long b(ip r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.getId();
    }

    private static final String b(List<ip> r8, ip r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        GsonUtil r0 = GsonUtil.INSTANCE;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L3:
        boolean r4 = true;
        List r6 = null;
        if (r12.hasNext() == false) goto L19;
        ip r3 = (ip) ZeusTransformUtils.preCheckCast(r12.next(), ip.class, "com.obric.memorydata.plugin");
        GsonUtil r7 = GsonUtil.INSTANCE;
        String r5 = r3.u();
        if (r5 != null) goto L8;
    L16:
        if (r6 != null) goto L18;
        r6 = CollectionsKt.emptyList();
    L18:
        CollectionsKt.addAll(r2, (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
        goto L3
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L11;
        r4 = false;
    L11:
        if (r4 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        r6 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r5, new b().getType()), List.class, "com.obric.memorydata.plugin");
        goto L16
    L19:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        GsonUtil r14 = GsonUtil.INSTANCE;
        String r15 = r9.u();
        if (r15 != null) goto L22;
    L30:
        if (r6 != null) goto L33;
        r6 = CollectionsKt.emptyList();
    L33:
        return r0.toJson(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r13, (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")));
    L22:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L25;
        r4 = false;
    L25:
        if (r4 == true) goto L28;
        r15 = null;
    L28:
        if (r15 == null) goto L30;
        r6 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r15, new a().getType()), List.class, "com.obric.memorydata.plugin");
        goto L30
    }

    public static final List<String> b(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "hotWords");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L15;
        Object r2 = r12.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
        r1.add(r2);
        goto L8
    L12:
        r3 = false;
        goto L13
    L15:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r14 = r13.iterator();
    L17:
        if (r14.hasNext() == false) goto L22;
        Object r6 = r14.next();
        String r15 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        Locale r16 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r16, "ROOT");
        String r17 = r15.toLowerCase(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "toLowerCase(...)");
        if (r4.add(r17) == false) goto L17;
        r5.add(r6);
        goto L17
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    }

    private static final void b(ip r9, List<ip> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        ip r0 = (ip) ZeusTransformUtils.preCheckCast(CollectionsKt.maxWithOrNull((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$i$26xS6exzx4KTfxmuXaVr7QSfr0.INSTANCE, $$Lambda$i$EnZwLa11__jR2s2ylaWrX64M.INSTANCE})), ip.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r2.hasNext() == false) goto L20;
        long r5 = ((ip) ZeusTransformUtils.preCheckCast(r2.next(), ip.class, "com.obric.memorydata.plugin")).getModifyTime();
    L9:
        if (r2.hasNext() == false) goto L13;
        long r7 = ((ip) ZeusTransformUtils.preCheckCast(r2.next(), ip.class, "com.obric.memorydata.plugin")).getModifyTime();
        if (r5 >= r7) goto L9;
        r5 = r7;
        goto L9
    L13:
        r9.a(r5);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r12.hasNext() == false) goto L17;
        r4 = r4 + ((ip) ZeusTransformUtils.preCheckCast(r12.next(), ip.class, "com.obric.memorydata.plugin")).h();
        goto L15
    L17:
        r9.a(r4);
        r9.b(r0.i());
        return;
    L20:
        throw new NoSuchElementException();
    }

    private static final Comparable c(ip r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r2.getCreateTime()), Comparable.class, "com.obric.memorydata.plugin");
    }

    private static final Comparable d(ip r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r2.getId()), Comparable.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$26xS6exzx4KTf-xmuXaVr7QSfr0, reason: not valid java name */
    public static /* synthetic */ Comparable m1237lambda$26xS6exzx4KTfxmuXaVr7QSfr0(ip r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$EnZwL-a11-__jR2s-2ylaWrX64M, reason: not valid java name */
    public static /* synthetic */ Comparable m1238lambda$EnZwLa11__jR2s2ylaWrX64M(ip r0) {
        return d(r0);
    }

    public static /* synthetic */ long lambda$Fxzx0d8Ec03pjciczOXiEXf4qA8(ip r2) {
        return b(r2);
    }

    public static /* synthetic */ long lambda$XqBaczNjokFHDjCufEv9erT8b5M(ip r2) {
        return a(r2);
    }
}
