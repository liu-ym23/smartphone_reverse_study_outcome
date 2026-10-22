package com.obric.memorydata.memory.ui.list.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePolicy;", "", "<init>", "()V", "FIRST_ENTITY_ID", "", "recordComparator", "Ljava/util/Comparator;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "Lkotlin/Comparator;", "getRecordComparator", "()Ljava/util/Comparator;", "sourceCursor", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessSourceCursor;", "globalCursor", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineCursor;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;", "dayRange", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "sourceCursorBefore", LBSLightLocationTraceLogger.SORT, "", "records", "eventTimeMillis", "", "item", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "stableKey", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "memoryTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "entityId", "eventDate", "Ljava/time/LocalDate;", "zoneId", "Ljava/time/ZoneId;", "hourStart", "Ljava/time/ZonedDateTime;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f11287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Comparator<t> f11288b = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11289a = null;

        static {
            int[] r0 = new int[MemoryTab.values().length];
            r0[MemoryTab.OBSERVATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemoryTab.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11289a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f11290a;

        public c(Comparator r3) {
            this.f11290a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f11290a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((t) ZeusTransformUtils.preCheckCast(r2, t.class, "com.obric.memorydata.plugin")).a().getRank()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin")).a().getRank()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f11291a;

        public d(Comparator r3) {
            this.f11291a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f11291a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((t) ZeusTransformUtils.preCheckCast(r2, t.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f11287a = new s();
        f11288b = (Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin");
    }

    private s() {
    }

    public final long a(com.obric.memorydata.memory.ui.data.a r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L6;
        return ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getStartTimestamp();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L10;
        return ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getCreateTime();
    L10:
        throw new IllegalStateException(("Unsupported context-awareness memory item: " + r3.getType()).toString());
    }

    public final k a(p r12, ContextAwarenessTimelineSource r13, com.obric.memorydata.memory.ui.list.contextawareness.d r14) {
        Intrinsics.checkNotNullParameter(r13, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r14, "dayRange");
        if (r12 != null) goto L7;
        return new k(Long.MAX_VALUE, "\uffff", true, r14);
    L7:
        if (r13.getRank() >= r12.b()) goto L10;
        return new k(r12.a(), "", false, r14);
    L10:
        if (r13.getRank() != r12.b()) goto L13;
        return new k(r12.a(), r12.c(), false, r14);
    L13:
        return new k(r12.a(), "\uffff", true, r14);
    }

    public final v a(MemoryTab r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "memoryTab");
        Intrinsics.checkNotNullParameter(r5, "entityId");
        int r3 = a.f11289a[r4.ordinal()];
        if (r3 != 1) goto L5;
        ContextAwarenessTimelineSource r6 = ContextAwarenessTimelineSource.SCREEN_CONTENT;
    L10:
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        r5 = null;
    L13:
        if (r5 != null) goto L15;
        return null;
    L15:
        return new v(r6, r5);
    L5:
        if (r3 == 2) goto L7;
        return null;
    L7:
        r6 = ContextAwarenessTimelineSource.AMBIENT_AUDIO;
        goto L10
    }

    public final LocalDate a(long r1, ZoneId r3) {
        Intrinsics.checkNotNullParameter(r3, "zoneId");
        LocalDate r0 = Instant.ofEpochMilli(r1).atZone(r3).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r0, "toLocalDate(...)");
        return r0;
    }

    public final List<t> a(List<t> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "records");
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), f11288b);
    }

    public final k b(p r12, ContextAwarenessTimelineSource r13, com.obric.memorydata.memory.ui.list.contextawareness.d r14) {
        Intrinsics.checkNotNullParameter(r12, "globalCursor");
        Intrinsics.checkNotNullParameter(r13, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r14, "dayRange");
        if (r13.getRank() >= r12.b()) goto L6;
        return new k(r12.a(), "", true, r14);
    L6:
        if (r13.getRank() != r12.b()) goto L9;
        return new k(r12.a(), r12.c(), false, r14);
    L9:
        return new k(r12.a(), "\uffff", false, r14);
    }

    public final ZonedDateTime b(long r1, ZoneId r3) {
        Intrinsics.checkNotNullParameter(r3, "zoneId");
        ZonedDateTime r0 = Instant.ofEpochMilli(r1).atZone(r3).truncatedTo((TemporalUnit) ZeusTransformUtils.preCheckCast(ChronoUnit.HOURS, TemporalUnit.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "truncatedTo(...)");
        return r0;
    }
}
