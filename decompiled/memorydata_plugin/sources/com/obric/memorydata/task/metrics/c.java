package com.obric.memorydata.task.metrics;

import com.bytedance.crash.entity.EventBody;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\bH\u0002J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010 \u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006,"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetricsCoordinator;", "", "store", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsStore;", "eventSink", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsEventSink;", "clock", "Lkotlin/Function0;", "", "onError", "Lkotlin/Function1;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "<init>", "(Lcom/obric/memorydata/task/metrics/IndexPowerMetricsStore;Lcom/obric/memorydata/task/metrics/IndexPowerMetricsEventSink;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "state", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsState;", "lastObservedAtMs", "Ljava/lang/Long;", "lastObservation", "Lcom/obric/memorydata/task/metrics/IndexPowerObservation;", "lastStateSavedAtMs", "observe", "commonSatisfied", "", "strictlySatisfied", "pendingTaskNames", "", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Collection;)V", "closeMostRecentUtcDay", "observedAtMs", "reportClosedWindow", "windowStartUtcMs", "accumulateUntil", "nowMs", "loadState", "saveState", EventBody.KEY_VALUE, "saveStateIfDue", "utcWindowStart", "timestampMs", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12941a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f12942b;
    private final e c;
    private final Function0<Long> d;
    private final Function1<RuntimeException, Unit> e;
    private h f;
    private Long g;
    private l h;
    private Long i;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetricsCoordinator$Companion;", "", "<init>", "()V", "EVENT_NAME", "", "FAST_INDEX_TASK_NAME", "SLOW_INDEX_TASK_NAME", "SCHEMA_VERSION", "", "DAY_DURATION_MS", "", "STATE_SAVE_INTERVAL_MS", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12941a = new a(null);
    }

    public c(j r3, e r4, Function0<Long> r5, Function1<? super RuntimeException, Unit> r6) {
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        Function0<Long> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function1<RuntimeException, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "store");
        Intrinsics.checkNotNullParameter(r8, "eventSink");
        Intrinsics.checkNotNullParameter(r9, "clock");
        Intrinsics.checkNotNullParameter(r10, "onError");
        this.f12942b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = a();
    }

    private final h a() {
        return d.a(this.f12942b.a());
    L4:
        e = move-exception;
        this.e.invoke(e);
        return new h(null, null, null, null, 15, null);
    }

    private final void a(long r7) {
        long r0 = d(r7);
        if (r0 >= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L5;
        return;
    L5:
        Long r4 = this.f.c();
        if (r4 != null) goto L8;
    L10:
        long r1 = r0 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        Long r2 = this.f.b();
        if (r2 == null) goto L13;
        long r3 = r2.longValue();
    L15:
        if (r1 <= r3) goto L18;
        a(r1, r7);
        return;
    L18:
        return;
    L13:
        r3 = Long.MIN_VALUE;
        goto L15
    L8:
        if (a(r4.longValue(), r7) == true) goto L10;
    }

    private final boolean a(long r21, long r23) {
        k r2 = (k) ZeusTransformUtils.preCheckCast(this.f.a().get(Long.valueOf(r21)), k.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L21;
        h r0 = h.a(this.f, null, null, Long.valueOf(r21), null, 11, null);
        this.f = r0;
        if (a(r0) == true) goto L7;
        return false;
    L7:
        long r7 = d.a(r21, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
        Iterator r1 = d.a(r2, r21, r7, r7).iterator();
    L9:
        if (r1.hasNext() == false) goto L21;
        com.obric.memorydata.task.metrics.a r3 = (com.obric.memorydata.task.metrics.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.task.metrics.a.class, "com.obric.memorydata.plugin");
        if (this.f.d().contains(r3.e()) == true) goto L9;
        if (this.c.report(r3) == false) goto L14;
        h r13 = this.f;
        h r4 = h.a(r13, null, null, null, SetsKt.plus(r13.d(), r3.e()), 7, null);
        this.f = r4;
        if (a(r4) == true) goto L9;
        return false;
    L14:
        return false;
    L18:
        e = move-exception;
        this.e.invoke(e);
        return false;
    L21:
        h r5 = this.f;
        Map<Long, k> r6 = r5.a();
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator<Map.Entry<Long, k>> r9 = r6.entrySet().iterator();
    L22:
        boolean r10 = true;
        if (r9.hasNext() == false) goto L30;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r11.getKey(), Number.class, "com.obric.memorydata.plugin")).longValue() > r21) goto L28;
        r10 = false;
    L28:
        if (r10 == false) goto L22;
        r8.put(r11.getKey(), r11.getValue());
        goto L22
    L30:
        h r12 = r5.a((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin"), Long.valueOf(r21), null, SetsKt.emptySet());
        if (a(r12) == true) goto L33;
        return false;
    L33:
        this.f = r12;
        this.i = Long.valueOf(r23);
        return true;
    }

    private final boolean a(h r2) {
        this.f12942b.a(r2);     // Catch: RuntimeException -> L4
        return true;
    L4:
        e = move-exception;
        this.e.invoke(e);
        return false;
    }

    private final void b(long r31) {
        Long r3 = this.g;
        l r4 = this.h;
        this.g = Long.valueOf(r31);
        if (r3 == null) goto L31;
        long r5 = r3.longValue();
        if (r4 != null) goto L8;
        return;
    L8:
        if (r31 > r5) goto L11;
        return;
    L11:
        if (r5 >= r31) goto L37;
        long r7 = d(r5);
        long r9 = Math.min(r31, d.a(r7, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS));
        if (r9 <= r5) goto L14;
        Long r6 = this.f.b();
        if (r6 == null) goto L18;
        long r11 = r6.longValue();
    L20:
        if (r7 <= r11) goto L30;
        Long r8 = this.f.c();
        if (r8 != null) goto L25;
    L26:
        k r10 = (k) ZeusTransformUtils.preCheckCast(this.f.a().get(Long.valueOf(r7)), k.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L29;
        r10 = new k(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    L29:
        h r12 = this.f;
        this.f = h.a(r12, MapsKt.plus(r12.a(), TuplesKt.to(Long.valueOf(r7), d.a(r10, r4, r9 - r5))), null, null, null, 14, null);
        goto L30
    L25:
        if (r7 != r8.longValue()) goto L26;
    L30:
        r5 = r9;
        goto L11
    L18:
        r11 = Long.MIN_VALUE;
        goto L20
    L14:
        return;
    L37:
        return;
    }

    private final void c(long r5) {
        Long r0 = this.i;
        if (r0 == null) goto L10;
        if (r5 < r0.longValue()) goto L10;
        if ((r5 - r0.longValue()) >= 300000) goto L10;
        return;
    L10:
        if (a(this.f) == false) goto L13;
        this.i = Long.valueOf(r5);
        return;
    }

    private final long d(long r3) {
        return Math.floorDiv(r3, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) * WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
    }

    public final synchronized void a(Boolean r9, Boolean r10, Collection<String> r11) {
        monitor-enter(this);
        Collection r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r11, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r12, "pendingTaskNames");     // Catch: Throwable -> L23
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(this.d.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L23
        b(r0);     // Catch: Throwable -> L23
        a(r0);     // Catch: Throwable -> L23
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        boolean r4 = true;
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L6;
    L5:
        boolean r3 = false;
    L12:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
    L14:
        r4 = false;
    L20:
        this.h = new l(r9, r10, r3, r4);     // Catch: Throwable -> L23
        c(r0);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L15:
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L23
    L17:
        if (r14.hasNext() == false) goto L14;
        if (Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME) == false) goto L17;
    L6:
        Iterator r5 = r2.iterator();     // Catch: Throwable -> L23
    L8:
        if (r5.hasNext() == false) goto L5;
        if (Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME) == false) goto L8;
        r3 = true;
    L23:
        th = move-exception;
        throw th;
    }
}
