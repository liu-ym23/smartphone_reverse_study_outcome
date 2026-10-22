package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\t\u001a\u00020\nH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AudioMemoryRepository;", "", "<init>", "()V", "MEMORY_STORAGE_KEY_AUDIO_SHOWN_MIN_TIMESTAMP", "", "getAudioMemoryDateList", "", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "refreshShownMinTimestamp", "", "getShownMinDate", "Ljava/time/LocalDate;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11171a = null;

    static {
        f11171a = new a();
    }

    private a() {
    }

    private static final n a(Set r2, LocalDate r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return new n(r3, !r4.contains(r3));
    }

    private static final p a(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "days");
        return new p(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), "");
    }

    private static final LocalDate a(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.plusDays(1);
    }

    private static final boolean a(LocalDate r2, LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r2.plusDays(1), ChronoLocalDate.class, "com.obric.memorydata.plugin"));
    }

    private static final n b(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return new n(r2, true);
    }

    private static final p b(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "days");
        return new p(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), "");
    }

    private final void b() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().d().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return;
    L5:
        long r2 = System.currentTimeMillis();
        long r10 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("audio_memory_shown_min_timestamp", 0);
        if (r10 < r2) goto L8;
    L9:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("audio_memory_shown_min_timestamp", r2);
        return;
    L8:
        if (r10 == 0) goto L9;
    }

    private static final boolean b(LocalDate r2, LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r2.plusDays(1), ChronoLocalDate.class, "com.obric.memorydata.plugin"));
    }

    private final LocalDate c() {
        long r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("audio_memory_shown_min_timestamp", 0);
        if (r4 != 0) goto L5;
        return null;
    L5:
        return Instant.ofEpochMilli(r4).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static final LocalDate c(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.plusDays(1);
    }

    /* JADX INFO: renamed from: lambda$3X-XHybsexj6o0WHJOF-On41PUU, reason: not valid java name */
    public static /* synthetic */ p m927lambda$3XXHybsexj6o0WHJOFOn41PUU(List r0) {
        return a(r0);
    }

    public static /* synthetic */ LocalDate lambda$9A49Fn2DD3hB10m6EwbCsgb_gP4(LocalDate r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$GQLda6sHTNVHjQBgOSAXddDY-RA, reason: not valid java name */
    public static /* synthetic */ p m928lambda$GQLda6sHTNVHjQBgOSAXddDYRA(List r0) {
        return b(r0);
    }

    public static /* synthetic */ LocalDate lambda$LRQOntqEfAqWIsxGhGgtwXXNIuY(LocalDate r0) {
        return c(r0);
    }

    public static /* synthetic */ n lambda$TFtWgdXiNiA09ZHRk4X94cZ32Y4(Set r0, LocalDate r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$XL_85brTR52yptj9_adq62ZQVhU(LocalDate r0, LocalDate r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ n lambda$hmIoswzRmPCavmFqv6AIVG2yNvw(LocalDate r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$qjgRUnceu85qEwUK6XETGCUJxEc(LocalDate r0, LocalDate r1) {
        return b(r0, r1);
    }

    public final List<p> a() {
        b();
        LocalDate r7 = c();
        List<String> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().getAudioMemoryDateList();
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        Date r5 = r1.parse((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L14;
        Instant r6 = r5.toInstant();
        if (r6 == null) goto L14;
        ZonedDateTime r8 = r6.atZone(ZoneId.systemDefault());
        if (r8 == null) goto L14;
        LocalDate r9 = r8.toLocalDate();
        if (r9 == null) goto L14;
    L15:
        r3.add(r9);
    L14:
        r9 = LocalDate.now();
        goto L15
    L16:
        final Set r10 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r10.isEmpty() == false) goto L25;
        LocalDate r11 = LocalDate.now();
        LocalDate r12 = r11.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        final LocalDate r13 = r11.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        if (r7 != null) goto L21;
    L23:
        Sequence r14 = SequencesKt.map(SequencesKt.takeWhile(SequencesKt.generateSequence(r12, $$Lambda$a$9A49Fn2DD3hB10m6EwbCsgb_gP4.INSTANCE), new $$Lambda$a$XL_85brTR52yptj9_adq62ZQVhU(r13)), $$Lambda$a$hmIoswzRmPCavmFqv6AIVG2yNvw.INSTANCE);
        Function1 r15 = $$Lambda$a$3XXHybsexj6o0WHJOFOn41PUU.INSTANCE;
    L44:
        return SequencesKt.toList(SequencesKt.chunked(r14, 7, r15));
    L21:
        if (r7.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r12, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == false) goto L23;
        r12 = r7.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        goto L23
    L25:
        LocalDate r16 = LocalDate.now();
        LocalDate r17 = (LocalDate) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), LocalDate.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L28;
        r17 = r16;
    L28:
        LocalDate r18 = (LocalDate) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), LocalDate.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L32;
        r18 = r16;
    L32:
        if (r17.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r16, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == false) goto L34;
        r17 = r16;
    L34:
        if (r7 != null) goto L36;
    L38:
        r7 = r17;
    L40:
        if (r18.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r16, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == true) goto L43;
        r16 = r18;
    L43:
        LocalDate r19 = r7.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        final LocalDate r20 = r16.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        r14 = SequencesKt.map(SequencesKt.takeWhile(SequencesKt.generateSequence(r19, $$Lambda$a$LRQOntqEfAqWIsxGhGgtwXXNIuY.INSTANCE), new $$Lambda$a$qjgRUnceu85qEwUK6XETGCUJxEc(r20)), new $$Lambda$a$TFtWgdXiNiA09ZHRk4X94cZ32Y4(r10));
        r15 = $$Lambda$a$GQLda6sHTNVHjQBgOSAXddDYRA.INSTANCE;
        goto L44
    L36:
        if (r17.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r7, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == false) goto L38;
        goto L38
    }
}
