package com.obric.memorydata.memory.review.provider.a;

import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.memory.review.model.d;
import com.obric.memorydata.memory.review.model.f;
import com.obric.memorydata.memory.review.model.g;
import com.obric.memorydata.memory.review.model.h;
import com.obric.memorydata.memory.review.provider.ae;
import com.obric.memorydata.memory.review.provider.ah;
import com.obric.memorydata.memory.review.provider.n;
import com.obric.memorydata.memory.review.provider.p;
import com.obric.memorydata.memory.review.provider.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/audiomemory/AudioMemoryReviewProvider;", "Lcom/obric/memorydata/memory/review/provider/BaseMemoryReviewDataProvider;", "pageSource", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryReviewPageSource;", "feedbackStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/AudioMemoryReviewPageSource;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;)V", "getPage", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "queryLegacyCompletedFeedback", "", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "cursor", "Lcom/obric/memorydata/memory/review/model/MemoryReviewCursorValue;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0511a f10399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.memory.review.provider.a f10400b;
    private final ah c;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.review.provider.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/audiomemory/AudioMemoryReviewProvider$Companion;", "", "<init>", "()V", "FIRST_CURSOR_ENTITY_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0511a {
        private C0511a() {
        }

        public /* synthetic */ C0511a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10399a = new C0511a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public a(com.obric.memorydata.memory.review.provider.a r3, ah r4) {
        com.obric.memorydata.memory.review.provider.a r5 = (com.obric.memorydata.memory.review.provider.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.memory.review.provider.a.class, "com.obric.memorydata.plugin");
        ah r6 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "pageSource");
        Intrinsics.checkNotNullParameter(r6, "feedbackStore");
        super(MemoryReviewModule.AUDIO_MEMORY, r6);
        this.f10400b = r5;
        this.c = r6;
    }

    public /* synthetic */ a(com.obric.memorydata.memory.review.provider.a r10, ah r11, int r12, DefaultConstructorMarker r13) {
        com.obric.memorydata.memory.review.provider.a r14 = (com.obric.memorydata.memory.review.provider.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.memory.review.provider.a.class, "com.obric.memorydata.plugin");
        ah r15 = (ah) ZeusTransformUtils.wrapperContextForParams(r11, ah.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L6;
        r14 = (com.obric.memorydata.memory.review.provider.a) ZeusTransformUtils.preCheckCast(new p(null, 1, null), com.obric.memorydata.memory.review.provider.a.class, "com.obric.memorydata.plugin");
    L6:
        if ((r12 & 2) == 0) goto L8;
        r15 = (ah) ZeusTransformUtils.preCheckCast(new ae(null, null, null, null, null, 31, null), ah.class, "com.obric.memorydata.plugin");
    L8:
        this(r14, r15);
    }

    private final Map<String, d> a(g r7, com.obric.memorydata.memory.review.model.b r8) {
        if (r8 != null) goto L4;
        Map<String, d> r6 = this.c.a(a());
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator<Map.Entry<String, d>> r10 = r6.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.memory.review.provider.a.b.a((d) ZeusTransformUtils.preCheckCast(r0.getValue(), d.class, "com.obric.memorydata.plugin"), r7.c(), r7.d()) == false) goto L7;
        r9.put(r0.getKey(), r0.getValue());
        goto L7
    L12:
        return (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin");
    L4:
        return MapsKt.emptyMap();
    }

    @Override // com.obric.memorydata.memory.review.provider.n, com.obric.memorydata.memory.review.provider.z
    public f a(g r21) {
        Intrinsics.checkNotNullParameter(r21, Ext.KEY_REQUEST);
        int r2 = r21.e();
        com.obric.memorydata.memory.review.model.b r3 = com.obric.memorydata.memory.review.model.a.f10381a.a(r21.b());
        com.obric.memorydata.memory.review.provider.a r4 = this.f10400b;
        long r5 = r21.c();
        long r7 = r21.d();
        if (r3 == null) goto L5;
        long r9 = r3.b();
    L6:
        if (r3 == null) goto L9;
        String r11 = r3.c();
        if (r11 == null) goto L9;
    L10:
        List<EpisodicMemoryEntity> r6 = r4.a(r5, r7, r9, r11, r2 + 1);
        List r8 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), r2);
        ah r10 = this.c;
        MemoryReviewModule r12 = a();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r14.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r15.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L12
    L14:
        Map<String, d> r16 = r10.a(r12, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"));
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L16:
        if (r19.hasNext() == false) goto L23;
        EpisodicMemoryEntity r110 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r19.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        w r111 = w.f10473a;
        d r112 = (d) ZeusTransformUtils.preCheckCast(r16.get(r110.getEntityId()), d.class, "com.obric.memorydata.plugin");
        if (r112 == null) goto L21;
        MemoryReviewFeedbackState r113 = r112.a();
        if (r113 == null) goto L21;
    L22:
        r18.add(r111.a(r110, r113));
    L21:
        r113 = MemoryReviewFeedbackState.PENDING;
        goto L22
    L23:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        Map<String, d> r22 = a(r21, r3);
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, d>> r114 = r22.entrySet().iterator();
    L25:
        if (r114.hasNext() == false) goto L29;
        Map.Entry r115 = (Map.Entry) ZeusTransformUtils.preCheckCast(r114.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r116 = (String) ZeusTransformUtils.preCheckCast(r115.getKey(), String.class, "com.obric.memorydata.plugin");
        h r117 = com.obric.memorydata.memory.review.provider.a.b.a((d) ZeusTransformUtils.preCheckCast(r115.getValue(), d.class, "com.obric.memorydata.plugin"), r116);
        if (r117 == null) goto L25;
        r23.add(r117);
        goto L25
    L29:
        List r24 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin"));
        List<h> r118 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin"));
        Map<String, d> r119 = MapsKt.plus(r16, r22);
        if (r6.size() <= r2) goto L32;
        boolean r25 = true;
    L33:
        boolean r120 = r25;
        EpisodicMemoryEntity r26 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r8), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        f.a r121 = f.f10389a;
        MemoryReviewModule r122 = a();
        long r123 = r21.c();
        long r124 = r21.d();
        if (r120 == false) goto L37;
        if (r26 == null) goto L37;
        String r0 = com.obric.memorydata.memory.review.model.a.f10381a.a(r21.d(), r26.getModifyTime(), r26.getEntityId());
    L39:
        return r121.a(r122, r123, r124, r118, r119, r0, r120);
    L37:
        r0 = null;
        goto L39
    L32:
        r25 = false;
    L9:
        r11 = "\uffff";
        goto L10
    L5:
        r9 = Long.MAX_VALUE;
        goto L6
    }
}
