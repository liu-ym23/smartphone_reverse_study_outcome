package com.obric.memorydata.memory.review.provider;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.database.entity.db;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001fH\u0016J*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020!0\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001fH\u0016J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020!0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010#\u001a\u00020$*\b\u0012\u0004\u0012\u00020$0\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackRepository;", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "localDataSource", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackLocalDataSource;", "remoteDataSource", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackRemoteDataSource;", "clock", "Lkotlin/Function0;", "", "rawObservationStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;", "audioTranscriptRepositoryFactory", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptRepository;", "<init>", "(Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackLocalDataSource;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackRemoteDataSource;Lkotlin/jvm/functions/Function0;Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;Lkotlin/jvm/functions/Function0;)V", "audioTranscriptRepository", "getAudioTranscriptRepository", "()Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptRepository;", "audioTranscriptRepository$delegate", "Lkotlin/Lazy;", LocationMonitorConst.SUBMIT, "Lcom/obric/memorydata/memory/review/model/MemoryReviewSubmitResult;", "feedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "queryStateMap", "", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "recordIds", "", "queryFeedbackMap", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "querySubmittedFeedbackMap", "pickLatestEntity", "Lcom/obric/memorydata/database/entity/MemoryReviewFeedbackEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ae implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ab f10403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ad f10404b;
    private final Function0<Long> c;
    private final al d;
    private final Function0<h> e;
    private final Lazy f;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryReviewModule f10405a;

        public a(MemoryReviewModule r1) {
            this.f10405a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r5, T r6) {
            if (Intrinsics.areEqual(((db) ZeusTransformUtils.preCheckCast(r6, db.class, "com.obric.memorydata.plugin")).c(), this.f10405a.getKey()) == false) goto L5;
            Object r7 = ZeusTransformUtils.preCheckCast(1, Comparable.class, "com.obric.memorydata.plugin");
        L6:
            Comparable r8 = (Comparable) r7;
            if (Intrinsics.areEqual(((db) ZeusTransformUtils.preCheckCast(r5, db.class, "com.obric.memorydata.plugin")).c(), this.f10405a.getKey()) == false) goto L9;
            Object r4 = ZeusTransformUtils.preCheckCast(1, Comparable.class, "com.obric.memorydata.plugin");
        L11:
            return ComparisonsKt.compareValues(r8, (Comparable) r4);
        L9:
            r4 = ZeusTransformUtils.preCheckCast(0, Comparable.class, "com.obric.memorydata.plugin");
            goto L11
        L5:
            r7 = ZeusTransformUtils.preCheckCast(0, Comparable.class, "com.obric.memorydata.plugin");
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f10406a;

        public b(Comparator r3) {
            this.f10406a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f10406a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((db) ZeusTransformUtils.preCheckCast(r5, db.class, "com.obric.memorydata.plugin")).k()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((db) ZeusTransformUtils.preCheckCast(r4, db.class, "com.obric.memorydata.plugin")).k()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    public ae() {
        this(null, null, null, null, null, 31, null);
    }

    public ae(ab r3, ad r4, Function0<Long> r5, al r6, Function0<h> r7) {
        ab r8 = (ab) ZeusTransformUtils.wrapperContextForParams(r3, ab.class, "com.obric.memorydata.plugin");
        ad r9 = (ad) ZeusTransformUtils.wrapperContextForParams(r4, ad.class, "com.obric.memorydata.plugin");
        Function0<Long> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        al r11 = (al) ZeusTransformUtils.wrapperContextForParams(r6, al.class, "com.obric.memorydata.plugin");
        Function0<h> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "localDataSource");
        Intrinsics.checkNotNullParameter(r9, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r10, "clock");
        Intrinsics.checkNotNullParameter(r11, "rawObservationStore");
        Intrinsics.checkNotNullParameter(r12, "audioTranscriptRepositoryFactory");
        this.f10403a = r8;
        this.f10404b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = LazyKt.lazy(r12);
    }

    public /* synthetic */ ae(ab r10, ad r11, Function0 r12, al r13, Function0 r14, int r15, DefaultConstructorMarker r16) {
        ab r0 = (ab) ZeusTransformUtils.wrapperContextForParams(r10, ab.class, "com.obric.memorydata.plugin");
        ad r2 = (ad) ZeusTransformUtils.wrapperContextForParams(r11, ad.class, "com.obric.memorydata.plugin");
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        al r4 = (al) ZeusTransformUtils.wrapperContextForParams(r13, al.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        if ((r15 & 1) == 0) goto L6;
        r0 = (ab) ZeusTransformUtils.preCheckCast(new t(null, 1, null), ab.class, "com.obric.memorydata.plugin");
    L6:
        if ((r15 & 2) == 0) goto L9;
        r2 = (ad) ZeusTransformUtils.preCheckCast(new av(null, 1, null), ad.class, "com.obric.memorydata.plugin");
    L9:
        if ((r15 & 4) == 0) goto L12;
        r3 = $$Lambda$ae$KDZDrb4rebKYlhz262IiJoOgiO8.INSTANCE;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r4 = (al) ZeusTransformUtils.preCheckCast(new ak(null, 1, null), al.class, "com.obric.memorydata.plugin");
    L15:
        if ((r15 & 16) == 0) goto L17;
        r5 = $$Lambda$ae$v8g7Lx182gwGYv0t5lzWveNgs.INSTANCE;
    L17:
        this(r0, r2, r3, r4, r5);
    }

    private final db a(List<db> r2, MemoryReviewModule r3) {
        return (db) ZeusTransformUtils.preCheckCast(CollectionsKt.first(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b((Comparator) ZeusTransformUtils.preCheckCast(new a(r3), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"))), db.class, "com.obric.memorydata.plugin");
    }

    private final h a() {
        return (h) ZeusTransformUtils.preCheckCast(this.f.getValue(), h.class, "com.obric.memorydata.plugin");
    }

    private static final long b() {
        return System.currentTimeMillis();
    }

    private static final h c() {
        return new h(null, 1, null);
    }

    public static /* synthetic */ long lambda$KDZDrb4rebKYlhz262IiJoOgiO8() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$v8g7L-x18-2gwGYv0t5lzWveNgs, reason: not valid java name */
    public static /* synthetic */ h m749lambda$v8g7Lx182gwGYv0t5lzWveNgs() {
        return c();
    }

    @Override // com.obric.memorydata.memory.review.provider.ah
    public com.obric.memorydata.memory.review.model.j a(com.obric.memorydata.memory.review.model.c r22) {
        String r10 = "submit memory review feedback failed";
        Intrinsics.checkNotNullParameter(r22, "feedback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        ae r12 = (ae) ZeusTransformUtils.preCheckCast(this, ae.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        long r8 = ((Number) ZeusTransformUtils.preCheckCast(r12.c.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L22
        com.obric.memorydata.memory.review.model.c r1 = ai.f10410a.a(r22, r12.a());     // Catch: Throwable -> L22
        com.obric.memorydata.memory.review.model.c r2 = ac.f10402a.a(r1, r12.d);     // Catch: Throwable -> L22
        an r3 = af.f10407a.a(r2, r8);     // Catch: Throwable -> L22
        r12.f10403a.insert(aa.f10401a.a(r22, r8, r3.a()));     // Catch: Throwable -> L22
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L6
        Object r5 = Result.m1421constructorimpl(r12.f10404b.a(r3));     // Catch: Throwable -> L6
    L8:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);     // Catch: Throwable -> L22
        if (r6 == null) goto L16;
        String r7 = r6.getMessage();     // Catch: Throwable -> L22
        if (r7 != null) goto L14;
        String r15 = "submit memory review feedback failed";
    L15:
        r5 = new am(false, r15, 0, null, null, 28, null);     // Catch: Throwable -> L22
        goto L16
    L14:
        r15 = r7;
    L16:
        am r9 = (am) ZeusTransformUtils.preCheckCast(r5, am.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r9.a() == false) goto L19;
        db r11 = aa.f10401a.a(r22, r8, r3.a(), "success", null, r8);     // Catch: Throwable -> L22
    L20:
        r12.f10403a.insert(r11);     // Catch: Throwable -> L22
        Object r13 = Result.m1421constructorimpl(new com.obric.memorydata.memory.review.model.j(r9.a(), r9.b()));     // Catch: Throwable -> L22
    L24:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L37;
        String r16 = r14.getMessage();
        if (r16 == null) goto L32;
        r10 = r16;
    L32:
        return new com.obric.memorydata.memory.review.model.j(false, r10);
    L37:
        return (com.obric.memorydata.memory.review.model.j) ZeusTransformUtils.preCheckCast(r13, com.obric.memorydata.memory.review.model.j.class, "com.obric.memorydata.plugin");
    L19:
        r11 = aa.f10401a.a(r22, r8, r3.a(), r9.b());     // Catch: Throwable -> L22
        goto L20
    L6:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L22
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.memory.review.provider.ah
    public Map<String, com.obric.memorydata.memory.review.model.d> a(MemoryReviewModule r8) {
        Intrinsics.checkNotNullParameter(r8, "module");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f10403a.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r8.getAcceptedKeys(), Iterable.class, "com.obric.memorydata.plugin")), MemoryReviewFeedbackState.SUBMITTED.getKey()), Iterable.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Object r3 = r2.next();
        String r4 = ((db) ZeusTransformUtils.preCheckCast(r3, db.class, "com.obric.memorydata.plugin")).b();
        Object r5 = r1.get(r4);
        if (r5 != null) goto L8;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r1.put(r4, r5);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).add(r3);
        goto L4
    L9:
        Map<String, com.obric.memorydata.memory.review.model.d> r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r1.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        Object r9 = r7.next();
        Object r10 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r9, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        List<db> r11 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r9, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin");
        r6.put(r10, aa.f10401a.b(a(r11, r8)));
        goto L11
    L13:
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.memory.review.provider.ah
    public Map<String, com.obric.memorydata.memory.review.model.d> a(MemoryReviewModule r7, List<String> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "module");
        Intrinsics.checkNotNullParameter(r9, "recordIds");
        if (r9.isEmpty() == true) goto L5;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(this.f10403a.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7.getAcceptedKeys(), Iterable.class, "com.obric.memorydata.plugin")), r9), Iterable.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Object r2 = r11.next();
        String r3 = ((db) ZeusTransformUtils.preCheckCast(r2, db.class, "com.obric.memorydata.plugin")).b();
        Object r4 = r0.get(r3);
        if (r4 != null) goto L12;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r0.put(r3, r4);
    L12:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r2);
        goto L8
    L13:
        Map<String, com.obric.memorydata.memory.review.model.d> r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r0.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r1.hasNext() == false) goto L17;
        Object r5 = r1.next();
        Object r6 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        List<db> r13 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin");
        r12.put(r6, aa.f10401a.b(a(r13, r7)));
        goto L15
    L17:
        return r12;
    L5:
        return MapsKt.emptyMap();
    }
}
