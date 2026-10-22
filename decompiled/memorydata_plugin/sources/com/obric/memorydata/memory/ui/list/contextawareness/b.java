package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessCalendarPolicy;", "", "<init>", "()V", "buildWeeks", "", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "recordedDates", "", "Ljava/time/LocalDate;", "today", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11262a = null;

    static {
        f11262a = new b();
    }

    private b() {
    }

    private static final com.obric.memorydata.memory.ui.list.p a(List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "days");
        String r1 = ((com.obric.memorydata.memory.ui.list.n) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r5), com.obric.memorydata.memory.ui.list.n.class, "com.obric.memorydata.plugin")).a().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return new com.obric.memorydata.memory.ui.list.p(r5, r1);
    }

    private static final LocalDate a(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        return r2.plusDays(1);
    }

    private static final boolean a(LocalDate r2, LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "date");
        return !r3.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r2, ChronoLocalDate.class, "com.obric.memorydata.plugin"));
    }

    private static final com.obric.memorydata.memory.ui.list.n b(Set r2, LocalDate r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "date");
        return new com.obric.memorydata.memory.ui.list.n(r3, !r4.contains(r3));
    }

    public static /* synthetic */ com.obric.memorydata.memory.ui.list.p lambda$8LMG1jvrjYBaV4kytjLq7855AAY(List r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$JDD6vzieZZHUI9Me-NQ48SC_MVw, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.memory.ui.list.n m943lambda$JDD6vzieZZHUI9MeNQ48SC_MVw(Set r0, LocalDate r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ LocalDate lambda$NuWGYdo6Ae_Ct1XldRr90XUuDGY(LocalDate r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$h6SAorCXtwxVzThwTelKdauM3l8(LocalDate r0, LocalDate r1) {
        return a(r0, r1);
    }

    public final List<com.obric.memorydata.memory.ui.list.p> a(Set<LocalDate> r4, LocalDate r5) {
        final Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "recordedDates");
        Intrinsics.checkNotNullParameter(r5, "today");
        Set r6 = SetsKt.plus(r3, r5);
        Comparable r7 = CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
        if (r7 == null) goto L11;
        LocalDate r8 = (LocalDate) ZeusTransformUtils.preCheckCast(r7, LocalDate.class, "com.obric.memorydata.plugin");
        Comparable r9 = CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
        if (r9 == null) goto L9;
        LocalDate r10 = (LocalDate) ZeusTransformUtils.preCheckCast(r9, LocalDate.class, "com.obric.memorydata.plugin");
        LocalDate r11 = r8.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        final LocalDate r12 = r10.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        return SequencesKt.toList(SequencesKt.map(SequencesKt.chunked(SequencesKt.map(SequencesKt.takeWhile(SequencesKt.generateSequence(r11, $$Lambda$b$NuWGYdo6Ae_Ct1XldRr90XUuDGY.INSTANCE), new $$Lambda$b$h6SAorCXtwxVzThwTelKdauM3l8(r12)), new $$Lambda$b$JDD6vzieZZHUI9MeNQ48SC_MVw(r3)), 7), $$Lambda$b$8LMG1jvrjYBaV4kytjLq7855AAY.INSTANCE));
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
