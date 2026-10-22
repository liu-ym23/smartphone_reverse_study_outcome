package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\r*\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u0004\u0018\u00010\t*\u00020\u001cH\u0002J\u001c\u0010\u001d\u001a\u00020\u0014*\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J:\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J0\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\"H\u0002J\u000e\u0010$\u001a\u0004\u0018\u00010\t*\u00020\u0016H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\tH\u0002J*\u0010'\u001a\u00020(2\n\u0010)\u001a\u00060*j\u0002`+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u00020\u0014H\u0002J\u0018\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0002J\u0018\u00103\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00104\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptRepository;", "", "dataSource", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptDataSource;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptDataSource;)V", "loadSnapshot", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSnapshot;", "recordId", "", "includeAudioUrls", "", "orderedRawObservationIds", "", "", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "parseRawObservationIds", "rawIds", "extractSegments", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSourceSegment;", "observation", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "evidenceIndex", "", "objectTexts", "Lorg/json/JSONArray;", "textOrNull", "Lorg/json/JSONObject;", "asSourceSegment", "segmentIndex", "buildSnapshot", "rawObservationIds", "rawObservationById", "", "resolveAudioUrls", "auditoryTaskId", "taskIdFromJson", "rawJson", "appendSegment", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "positionedSegments", "", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSegment;", "segment", "cappedByteCount", "current", "addition", "entityRevision", "refsDigest", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10455a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f10456b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptRepository$Companion;", "", "<init>", "()V", "KEY_TASK_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10455a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public h(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dataSource");
        this.f10456b = r4;
    }

    public /* synthetic */ h(f r8, int r9, DefaultConstructorMarker r10) {
        f r11 = (f) ZeusTransformUtils.wrapperContextForParams(r8, f.class, "com.obric.memorydata.plugin");
        if ((r9 & 1) == 0) goto L5;
        r11 = (f) ZeusTransformUtils.preCheckCast(new q(null, null, null, 7, null), f.class, "com.obric.memorydata.plugin");
    L5:
        this(r11);
    }

    private final long a(long r1, long r3) {
        return RangesKt.coerceAtMost(r1 + r3, 2147483647L);
    }

    private final k a(EpisodicMemoryEntity r24, List<Long> r25, Map<Long, RawObservationEntity> r26, boolean r27) {
        List<Long> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Map<Long, RawObservationEntity> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder();
        List<j> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r8 = false;
        int r9 = 0;
        int r10 = 0;
        long r11 = 0;
    L4:
        if (r5.hasNext() == false) goto L30;
        Object r14 = r5.next();
        int r15 = r9 + 1;
        if (r9 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        RawObservationEntity r6 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r3.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue())), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L11;
        List<l> r7 = a(r6, r9);
    L12:
        if (r7 != null) goto L14;
        r7 = CollectionsKt.emptyList();
    L14:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r12.hasNext() == false) goto L29;
        l r16 = (l) ZeusTransformUtils.preCheckCast(r12.next(), l.class, "com.obric.memorydata.plugin");
        if (r10 != 0) goto L20;
        long r17 = 0;
    L21:
        Iterator r18 = r5;
        Iterator r19 = r12;
        r11 = a(r11, r17 + i.b(r16.c()));
        if (r8 == false) goto L24;
    L26:
        if (r8 == true) goto L28;
        StringsKt.clear(r4);
        r13.clear();
        r8 = true;
    L28:
        r10 = r10 + 1;
        r5 = r18;
        r12 = r19;
        goto L16
    L24:
        if (r11 > 1048576) goto L26;
        a(r4, r13, r16);
        goto L28
    L20:
        r17 = 1;
        goto L21
    L29:
        r9 = r15;
        goto L4
    L11:
        r7 = null;
        goto L12
    L30:
        String r20 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "toString(...)");
        String r21 = i.a(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
        int r110 = (int) RangesKt.coerceAtMost(r11, 2147483647L);
        String r22 = r24.getEntityId();
        String r23 = a(r24, r21);
        if (r8 == false) goto L33;
        String r28 = i.a("too-large:" + r110);
    L34:
        String r111 = r28;
        if (r27 == false) goto L37;
        List<String> r0 = a(r1, r3);
    L39:
        return new k(r22, r23, r21, r111, r20, r110, r13, r0);
    L37:
        r0 = CollectionsKt.emptyList();
        goto L39
    L33:
        r28 = i.a(r20);
        goto L34
    }

    public static /* synthetic */ k a(h r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.a(r1, r2);
    }

    private final l a(String r1, int r2, int r3) {
        return new l(r2, r3, r1);
    }

    private final String a(EpisodicMemoryEntity r10, String r11) {
        Object[] r9 = new Object[11];
        r9[0] = Long.valueOf(r10.getId());
        r9[1] = r10.getEntityId();
        r9[2] = Long.valueOf(r10.getCreateTime());
        r9[3] = Long.valueOf(r10.getModifyTime());
        r9[4] = Long.valueOf(r10.getStartTimestamp());
        r9[5] = Long.valueOf(r10.getEndTimestamp());
        r9[6] = Integer.valueOf(r10.getProductType());
        r9[7] = r10.getTitle();
        r9[8] = r10.getContent();
        String r12 = r10.getLogId();
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        r9[9] = r12;
        r9[10] = r11;
        return i.a(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r9), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u001f", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    }

    private final String a(RawObservationEntity r3) {
        if (Intrinsics.areEqual(r3.getSource(), "auditory") == true) goto L6;
        return null;
    L6:
        String r0 = b(r3.getPayload());
        if (r0 == null) goto L9;
        return r0;
    L9:
        return b(r3.getMeta());
    }

    private final String a(JSONObject r3) {
        Object r2 = r3.opt(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L5;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L9;
        return null;
    L9:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        return null;
    L11:
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    private final List<Long> a(EpisodicMemoryEntity r6) {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r6.getSourceRawRefIds()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add((Long) ZeusTransformUtils.preCheckCast(r1.next(), Long.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r6.getImportantRawRefIds()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        r0.add((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.memorydata.plugin"));
        goto L8
    L11:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final List<l> a(RawObservationEntity r7, int r8) {
        Object r9 = new JSONObject(r7.getPayload()).opt("asr_result");
        int r1 = 0;
        if (ZeusTransformUtils.instanceOf(r9, JSONObject.class) == false) goto L11;
        String r10 = a((JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L8;
        l r6 = a(r10, r8, 0);
    L29:
        return CollectionsKt.listOfNotNull(r6);
    L8:
        r6 = null;
        goto L29
    L11:
        if (ZeusTransformUtils.instanceOf(r9, JSONArray.class) == false) goto L21;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(a((JSONArray) ZeusTransformUtils.preCheckCast(r9, JSONArray.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L30;
        Object r3 = r12.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        r0.add(a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r8, r1));
        r1 = r4;
        goto L14
    L30:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L21:
        return CollectionsKt.emptyList();
    L23:
        return CollectionsKt.emptyList();
    }

    private final List<Long> a(String r10) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        JSONArray r9 = new JSONArray(r10);     // Catch: JSONException -> L20
        List r11 = CollectionsKt.createListBuilder();     // Catch: JSONException -> L20
        int r1 = r9.length();     // Catch: JSONException -> L20
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L18;
        Long r4 = Long.valueOf(r9.optLong(r3, -1));     // Catch: JSONException -> L20
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L17;
        r11.add(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue()));     // Catch: JSONException -> L20
    L17:
        r3 = r3 + 1;     // Catch: JSONException -> L20
        goto L7
    L11:
        r5 = false;
        goto L12
    L18:
        return CollectionsKt.build(r11);
    L21:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<String> a(List<Long> r10, Map<Long, RawObservationEntity> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r0.add((RawObservationEntity) ZeusTransformUtils.preCheckCast(r13.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r15.next(), Number.class, "com.obric.memorydata.plugin")).longValue())), RawObservationEntity.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L9;
    L11:
        Iterator r18 = r17.iterator();
    L13:
        if (r18.hasNext() == false) goto L21;
        RawObservationEntity r1 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r18.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        String r2 = r1.getSource();
    L19:
        if (Intrinsics.areEqual(r2, "auditory") == false) goto L13;
        r3 = false;
        goto L21
    L17:
        r2 = null;
    L21:
        if (r3 == true) goto L23;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r19.iterator();
    L25:
        String r4 = "";
        if (r111.hasNext() == false) goto L35;
        RawObservationEntity r5 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r111.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L30;
        String r6 = a(r5);
    L31:
        if (r6 == null) goto L34;
        r4 = r6;
    L34:
        r110.add(r4);
        goto L25
    L30:
        r6 = null;
        goto L31
    L35:
        List r112 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
        Sequence r113 = SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(AudioMemoryTranscriptRepository$resolveAudioUrls$audioUrlsByTaskId$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")));
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r114 = r113.iterator();
    L37:
        if (r114.hasNext() == false) goto L45;
        Object r8 = r114.next();
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin");
        String r20 = this.f10456b.b((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"));
        if (r20 == null) goto L41;
        String r21 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L42:
        if (r21 != null) goto L44;
        r21 = "";
    L44:
        r9.put(r8, r21);
        goto L37
    L41:
        r21 = null;
        goto L42
    L45:
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin");
        Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.memorydata.plugin");
        Collection r116 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r117 = r115.iterator();
    L47:
        if (r117.hasNext() == false) goto L53;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.get((String) ZeusTransformUtils.preCheckCast(r117.next(), String.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L51;
        r23 = "";
    L51:
        r116.add(r23);
        goto L47
    L53:
        return (List) ZeusTransformUtils.preCheckCast(r116, List.class, "com.obric.memorydata.plugin");
    L23:
        return CollectionsKt.emptyList();
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
        goto L11
    }

    private final List<String> a(JSONArray r7) {
        List r0 = CollectionsKt.createListBuilder();
        int r1 = r7.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        Object r3 = r7.opt(r2);
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L7;
        JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L8:
        if (r4 == null) goto L12;
        String r5 = a(r4);
        if (r5 == null) goto L12;
        r0.add(r5);
    L12:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = null;
        goto L8
    L14:
        return CollectionsKt.build(r0);
    }

    private final void a(StringBuilder r3, List<j> r4, l r5) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        r3.append('\n');
    L8:
        int r7 = r3.length();
        r3.append(r5.c());
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(new j(r5.a(), r5.b(), r7, r3.length()));
        return;
    L5:
        r6 = false;
        goto L6
    }

    private final String b(String r3) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L13;
        return null;
    L13:
        String r2 = new JSONObject(r3).optString("task_id");     // Catch: JSONException -> L12
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");     // Catch: JSONException -> L12
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: JSONException -> L12
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
        return null;
    L11:
        return r4;
    L8:
        r5 = false;
    L16:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k a(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "recordId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return null;
    L5:
        EpisodicMemoryEntity r10 = this.f10456b.a(r8);
        if (r10 != null) goto L8;
    L21:
        return null;
    L8:
        if (r10.getProductType() != 1006) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r10 = null;
    L14:
        if (r10 == null) goto L21;
        List<Long> r1 = a(r10);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f10456b.a(r1), Iterable.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L20;
        Object r5 = r4.next();
        r3.put(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r5, RawObservationEntity.class, "com.obric.memorydata.plugin")).getId()), r5);
        goto L17
    L20:
        return a(r10, r1, r3, r9);
    L10:
        r0 = false;
        goto L11
    }
}
