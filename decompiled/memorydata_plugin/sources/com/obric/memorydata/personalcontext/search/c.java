package com.obric.memorydata.personalcontext.search;

import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.capabilitykit.entity.search.SearchScoreParam;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002JJ\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170!2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\"H\u0002J(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170!2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0019H\u0002J<\u0010%\u001a\u00020&2\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntityMergeStrategy;", "", "<init>", "()V", "TAG", "", "IMAGE_VECTOR", "TEXT_VECTOR", "IMAGE_CLIP_HIGH", "", "STRATEGY_IMAGE_EMBEDDING_HIGH", "Lkotlin/Pair;", "getSTRATEGY_IMAGE_EMBEDDING_HIGH", "()Lkotlin/Pair;", "STRATEGY_IMAGE_EMBEDDING_VALUE", "STRATEGY_TEXT_EMBEDDING_HIGH", "STRATEGY_TEXT_EMBEDDING_MIDDLE", "SEMANTIC_KEYWORD_SET", "", "getSEMANTIC_KEYWORD_SET", "()Ljava/util/Set;", "mergeResultEntries", "", "Lcom/obric/memorydata/personalcontext/search/entity/SearchResultEntry;", "noneSemanticAllResultEntries", "", "semanticAllResultEntries", "limitCount", "", "filterDuplicateEntries", "entries", "zigzagMergeWithScore", "sortSemanticSearchResult", "", "", "zigzagMergeInner", "allResultEntries", "processResultEntries", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pair<Double, Double> f12307b = null;
    private static final Pair<Double, Double> c = null;
    private static final Pair<Double, Double> d = null;
    private static final Pair<Double, Double> e = null;
    private static final Set<String> f = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Double) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Double.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Double) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Double.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Double) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Double.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Double) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Double.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f12306a = new c();
        Double r1 = Double.valueOf(0.49d);
        Double r2 = Double.valueOf(0.53d);
        f12307b = new Pair(r1, r2);
        Double r3 = Double.valueOf(0.44d);
        Double r4 = Double.valueOf(0.4d);
        c = new Pair(r3, r4);
        d = new Pair(Double.valueOf(0.75d), r2);
        e = new Pair(Double.valueOf(0.6d), r4);
        f = SetsKt.setOf(new String[]{"AlarmEntity_switchStatus", "AlarmEntity_createTime", "AlarmEntity_type", "AlbumEntity_modifyTime", "AlbumEntity_type", "ContactEntity_gender", "ContactEntity_modifyTime", "ContactEntity_createTime", "ContactEntity_type", "MessageEntity_messageStatusType", "MessageEntity_gender", "MessageEntity_modifyTime", "MessageEntity_createTime", "MessageEntity_type", "NoteEntity_isFavorite", "NoteEntity_modifyTime", "NoteEntity_createTime", "NoteEntity_type", "CallHistoryEntity_callType", "CallHistoryEntity_isAIPickup", "CallHistoryEntity_modifyTime", "CallHistoryEntity_createTime", "CallHistoryEntity_type", "PhotoEntity_assetType", "PhotoEntity_isFavorite", "PhotoEntity_modifyTime", "PhotoEntity_createTime", "PhotoEntity_type", "FileEntity_modifyTime", "FileEntity_createTime", "FileEntity_type", "ScheduleEntity_modifyTime", "ScheduleEntity_createTime", "ScheduleEntity_type", "CountdownEntity_modifyTime", "CountdownEntity_createTime", "CountdownEntity_type", "RecordingEntity_modifyTime", "RecordingEntity_createTime", "RecordingEntity_type"});
    }

    private c() {
    }

    public static /* synthetic */ List a(c r1, Map r2, Map r3, int r4, int r5, Object r6) {
        Map<String, List<SearchResultEntry>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Map<String, List<SearchResultEntry>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = 50;
    L6:
        return r1.a(r7, r8, r4);
    }

    private final List<SearchResultEntry> a(List<SearchResultEntry> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        SearchResultEntry r2 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r10.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        Pair r3 = new Pair(Integer.valueOf(r2.getType()), Long.valueOf(r2.getId()));
        if (r9.contains(r3) == true) goto L4;
        r9.add(r3);
        r1.add(r2);
        goto L4
    L8:
        return r1;
    }

    private final List<SearchResultEntry> a(Map<String, ? extends List<SearchResultEntry>> r19) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = r0.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L25;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        SearchResultEntry r13 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r6.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        double r7 = 0.0d;
        boolean r15 = true;
    L10:
        if (r14.hasNext() == false) goto L23;
        InAppSearchEntityParam r9 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r14.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        SearchScoreParam r16 = r9.getScore();
        if (r16 == null) goto L14;
        String r17 = r16.getType();
    L16:
        if (Intrinsics.areEqual(r17, "image_vector") == true) goto L17;
        SearchScoreParam r10 = r9.getScore();
        if (r10 == null) goto L21;
        double r11 = r10.getValue();
    L22:
        r7 = Math.max(r7, r11);
        goto L10
    L21:
        r11 = 0.0d;
        goto L22
    L17:
        r15 = false;
        goto L10
    L14:
        r17 = null;
        goto L16
    L23:
        if (r15 == false) goto L7;
        r3.put(Double.valueOf(r7), r13);
        goto L7
    L25:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r3.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r8.iterator();
    L27:
        if (r20.hasNext() == false) goto L29;
        r18.add((SearchResultEntry) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin"));
        goto L27
    L29:
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Map r21 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.entrySet().iterator();
    L31:
        if (r1.hasNext() == false) goto L51;
        Map.Entry r22 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r24.hasNext() == false) goto L31;
        SearchResultEntry r25 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r24.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(r25.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r27 = false;
        double r110 = 0.0d;
    L37:
        if (r26.hasNext() == false) goto L49;
        InAppSearchEntityParam r111 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r26.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        SearchScoreParam r112 = r111.getScore();
        if (r112 == null) goto L41;
        String r113 = r112.getType();
    L43:
        if (Intrinsics.areEqual(r113, "image_vector") == false) goto L37;
        SearchScoreParam r28 = r111.getScore();
        if (r28 == null) goto L47;
        double r114 = r28.getValue();
    L48:
        r110 = Math.max(r110, r114);
        r27 = true;
        goto L37
    L47:
        r114 = 0.0d;
        goto L48
    L41:
        r113 = null;
        goto L43
    L49:
        if (r27 == false) goto L34;
        r21.put(Double.valueOf(r110), r25);
        goto L34
    L51:
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r21.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L53:
        if (r31.hasNext() == false) goto L55;
        r30.add((SearchResultEntry) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r31.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), SearchResultEntry.class, "com.obric.memorydata.plugin"));
        goto L53
    L55:
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return r2;
    }

    private final void a(Map<String, List<SearchResultEntry>> r20, Map<String, List<SearchResultEntry>> r21) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L39;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5.getValue(), List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L6:
        boolean r11 = true;
        if (r10.hasNext() == false) goto L37;
        SearchResultEntry r12 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r10.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        Pair r13 = new Pair(Long.valueOf(r12.getId()), Integer.valueOf(r12.getType()));
        if (r9.contains(r13) == true) goto L6;
        if (r0.containsKey(r6) == false) goto L34;
        List r14 = (List) ZeusTransformUtils.preCheckCast(r0.get(r6), List.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L32;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L17;
    L19:
        Iterator r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L18;
        SearchResultEntry r17 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r16.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        if (r17.getId() == r12.getId()) goto L25;
    L27:
        boolean r18 = false;
    L28:
        if (r18 == false) goto L21;
        boolean r19 = false;
    L30:
        if (r19 != true) goto L32;
    L33:
        if (r11 == true) goto L34;
    L35:
        r9.add(r13);
        goto L6
    L25:
        if (r17.getType() != r12.getType()) goto L27;
        r18 = true;
    L18:
        r19 = true;
        goto L30
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L19;
    L32:
        r11 = false;
    L34:
        r8.add(r12);
        goto L35
    L37:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L4;
        r3.put(r6, r8);
        goto L4
    L39:
        r2.clear();
        r2.putAll(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SearchResultEntry> b(Map<String, List<SearchResultEntry>> r14) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(d.f12308a.g(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(r13.get(r2.getFirst()), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        r15.add(new Pair(r3, r2.getSecond()));
        goto L4
    L8:
        List<SearchResultEntry> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int[] r4 = new int[r15.size()];
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r6 = 0;
    L10:
        if (r5.hasNext() == false) goto L12;
        r6 = r6 + ((List) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r5.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), List.class, "com.obric.memorydata.plugin")).size();
        goto L10
    L12:
        boolean r7 = true;
    L14:
        if (r16.size() >= r6) goto L36;
        if (r7 == false) goto L17;
        List r8 = r15;
    L18:
        Iterator r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L35;
        Pair r10 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(r10.component1(), List.class, "com.obric.memorydata.plugin");
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r10.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Iterator r17 = r15.iterator();
        int r18 = 0;
    L23:
        if (r17.hasNext() == false) goto L28;
        if (Intrinsics.areEqual(((Pair) ZeusTransformUtils.preCheckCast(r17.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), r11) == true) goto L29;
        r18 = r18 + 1;
    L29:
        int r19 = 0;
    L30:
        if (r19 >= r12) goto L20;
        if (r4[r18] >= r11.size()) goto L34;
        r16.add(r11.get(r4[r18]));
        r4[r18] = r4[r18] + 1;
    L34:
        r19 = r19 + 1;
        goto L30
    L28:
        r18 = -1;
        goto L29
    L35:
        r7 = !r7;
        goto L14
    L17:
        r8 = CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"));
        goto L18
    L36:
        return r16;
    }

    private final List<SearchResultEntry> b(Map<String, List<SearchResultEntry>> r27, Map<String, List<SearchResultEntry>> r28, int r29) {
        c this = this;
        Map<String, List<SearchResultEntry>> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(this.b(r2), Collection.class, "com.obric.memorydata.plugin"));
        if (r5.size() >= r29) goto L70;
        Map<String, ? extends List<SearchResultEntry>> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<SearchResultEntry>> r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<SearchResultEntry>> r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.util.c.f12363a.b() != EmbeddingState.USE_VLM) goto L7;
        boolean r9 = true;
    L8:
        Pair<Double, Double> r10 = d;
        if (r9 == false) goto L11;
        Double r11 = r10.getSecond();
    L12:
        double r12 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        Pair<Double, Double> r13 = e;
        if (r9 == false) goto L15;
        Double r14 = r13.getSecond();
    L16:
        double r15 = ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r9 == false) goto L19;
        Object r6 = ZeusTransformUtils.preCheckCast(f12307b.getSecond(), Number.class, "com.obric.memorydata.plugin");
    L20:
        double r16 = ((Number) r6).doubleValue();
        Pair<Double, Double> r17 = c;
        if (r9 == false) goto L23;
        Double r18 = r17.getSecond();
    L24:
        double r19 = ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        Iterator r20 = r4.entrySet().iterator();
    L26:
        if (r20.hasNext() == false) goto L68;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r20 = r20;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.getKey(), String.class, "com.obric.memorydata.plugin");
        List r23 = (List) ZeusTransformUtils.preCheckCast(r21.getValue(), List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r5 = r5;
        List r24 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L29:
        if (r25.hasNext() == false) goto L56;
        Iterator r26 = r25;
        SearchResultEntry r30 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r25.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        Iterator<InAppSearchEntityParam> r110 = r30.getInAppSearchParams().iterator();
    L32:
        if (r110.hasNext() == false) goto L55;
        r8 = r8;
        r110 = r110;
        SearchScoreParam r31 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r110.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r31 == null) goto L32;
        String r111 = r31.getType();
        Map<String, ? extends List<SearchResultEntry>> r210 = r7;
        if (Intrinsics.areEqual(r111, "text_vector") == false) goto L47;
        if (r31.getValue() < r12) goto L43;
    L40:
        Object r32 = ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin");
    L41:
        com.obric.memorydata.utils.f.a((Collection) r32, r30);
    L54:
        r7 = r210;
        goto L32
    L43:
        if (r31.getValue() < r15) goto L45;
    L44:
        r32 = ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin");
    L45:
        r32 = ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        goto L41
    L47:
        if (Intrinsics.areEqual(r111, "image_vector") == false) goto L54;
        if (r31.getValue() >= r16) goto L40;
        if (r31.getValue() < r19) goto L45;
    L55:
        r25 = r26;
        goto L29
    L56:
        Map<String, ? extends List<SearchResultEntry>> r211 = r7;
        Map<String, ? extends List<SearchResultEntry>> r212 = r8;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L60;
        r3.put(r22, r1);
    L60:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L62;
        r7 = r211;
        r7.put(r22, r24);
    L64:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L66;
        r8 = r212;
        r8.put(r22, r0);
        goto L26
    L66:
        r8 = r212;
        goto L26
    L62:
        r7 = r211;
        goto L64
    L68:
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(this.a(r3), Collection.class, "com.obric.memorydata.plugin"));
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(this.a(r7), Collection.class, "com.obric.memorydata.plugin"));
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(this.a(r8), Collection.class, "com.obric.memorydata.plugin"));
        goto L70
    L23:
        r18 = r17.getFirst();
        goto L24
    L19:
        r6 = ZeusTransformUtils.preCheckCast(f12307b.getFirst(), Number.class, "com.obric.memorydata.plugin");
        goto L20
    L15:
        r14 = r13.getFirst();
        goto L16
    L11:
        r11 = r10.getFirst();
        goto L12
    L7:
        r9 = false;
    L70:
        if (r5.size() > r29) goto L72;
        return r5;
    L72:
        return r5.subList(0, r29);
    }

    public final List<SearchResultEntry> a(Map<String, List<SearchResultEntry>> r8, Map<String, List<SearchResultEntry>> r9, int r10) {
        Map<String, List<SearchResultEntry>> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Map<String, List<SearchResultEntry>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "noneSemanticAllResultEntries");
        Intrinsics.checkNotNullParameter(r12, "semanticAllResultEntries");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityMergeStrategy", "noneSemanticAllResultEntries: " + u.a(r11), null, 4, null);
        a(r11, r12);
        return a(b(r11, r12, r10));
    }

    public final Pair<Double, Double> a() {
        return f12307b;
    }

    public final Set<String> b() {
        return f;
    }
}
