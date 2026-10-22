package com.obric.memorydata.middleware.impl.npth;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0016\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0006H\u0002J$\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0018\u0010(\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEventReporter;", "", Scraps.STORAGE, "Lcom/obric/memorydata/middleware/impl/npth/CrashTeaEventStorage;", "dispatcher", "Lkotlin/Function2;", "", "", "clock", "Lkotlin/Function0;", "", "idGenerator", "failureLogger", "Lkotlin/Function1;", "<init>", "(Lcom/obric/memorydata/middleware/impl/npth/CrashTeaEventStorage;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "queueLock", "replayInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "reportFatal", "eventName", "paramsJson", "crashTimeMs", "replayPending", "createPendingEvent", "Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEvent;", "enqueue", "", "event", "loadReplaySnapshot", "", "nowMs", "dispatchReplaySnapshot", "events", "dispatchReplayEvent", "replayTimeMs", "dispatchFallback", "removeEvent", "dispatchedId", "retainActiveEvents", "replayDelayMs", "notifyFailure", "code", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11796a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f11797b;
    private final Function2<String, String, Unit> c;
    private final Function0<Long> d;
    private final Function0<String> e;
    private final Function1<String, Unit> f;
    private final Object g;
    private final AtomicBoolean h;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEventReporter$Companion;", "", "<init>", "()V", "MAX_PENDING_EVENT_COUNT", "", "PENDING_EVENT_TTL_MS", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11796a = new a(null);
    }

    public f(c r3, Function2<? super String, ? super String, Unit> r4, Function0<Long> r5, Function0<String> r6, Function1<? super String, Unit> r7) {
        Function2<String, String, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Function0<Long> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0<String> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, Scraps.STORAGE);
        Intrinsics.checkNotNullParameter(r8, "dispatcher");
        Intrinsics.checkNotNullParameter(r9, "clock");
        Intrinsics.checkNotNullParameter(r10, "idGenerator");
        Intrinsics.checkNotNullParameter(r11, "failureLogger");
        this.f11797b = r3;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = new Object();
        this.h = new AtomicBoolean(false);
    }

    public /* synthetic */ f(c r8, Function2 r9, Function0 r10, Function0 r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        Function2 r3 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Function0 r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        if ((r13 & 4) == 0) goto L5;
        r15 = (Function0) ZeusTransformUtils.preCheckCast(PendingCrashTeaEventReporter$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L5:
        Function0 r4 = r15;
        if ((r13 & 8) == 0) goto L8;
        Function0 r5 = $$Lambda$f$j1kx3ZQxva4H2RY7jggrgTwVJg.INSTANCE;
    L10:
        if ((r13 & 16) == 0) goto L12;
        Function1 r6 = $$Lambda$f$D2YYsVQcy7ma6ZU2P9zQ7Svco.INSTANCE;
    L13:
        this(r8, r3, r4, r5, r6);
        return;
    L12:
        r6 = r17;
        goto L13
    L8:
        r5 = r16;
        goto L10
    }

    private final long a(long r1, long r3) {
        if (r3 >= r1) goto L7;
        return 0;
    L7:
        return r3 - r1;
    }

    private final List<e> a(long r4) {
        Object r0 = this.g;
        monitor-enter(r0);
        g r1 = this.f11797b.a();     // Catch: Throwable -> L22
        List<e> r5 = CollectionsKt.takeLast(a(r1.a(), r4), 16);     // Catch: Throwable -> L22
        if (r1.b() == false) goto L7;
    L10:
        boolean r6 = true;
    L12:
        if (r1.b() == false) goto L14;
        b("pending_data_invalid");     // Catch: Throwable -> L22
    L14:
        if (r6 == true) goto L26;
    L20:
        monitor-exit(r0);
        return r5;
    L26:
    L19:
        b("pending_cleanup_failed");     // Catch: Throwable -> L22
        goto L20
    L16:
        if (this.f11797b.a(r5) == true) goto L20;
        b("pending_cleanup_failed");     // Catch: Throwable -> L19
    L7:
        if (Intrinsics.areEqual(r5, r1.a()) == false) goto L10;
        r6 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private final List<e> a(List<e> r7, long r8) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r6.iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        Object r1 = r10.next();
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.memorydata.plugin");
        if (r8 >= r2.d()) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L4;
        r9.add(r1);
        goto L4
    L8:
        if ((r8 - r2.d()) <= 691200000) goto L11;
        r3 = false;
        goto L12
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    }

    private final void a(e r5, long r6) {
        JSONObject r7 = new JSONObject(r5.c()).put("crash_event_id", r5.a()).put("crash_time_ms", r5.d()).put("report_mode", "replay").put("replay_time_ms", r6).put("replay_delay_ms", a(r5.d(), r6));     // Catch: Throwable -> L4
        Function2<String, String, Unit> r8 = this.c;     // Catch: Throwable -> L4
        String r0 = r5.b();     // Catch: Throwable -> L4
        String r9 = r7.toString();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");     // Catch: Throwable -> L4
        r8.invoke(r0, r9);     // Catch: Throwable -> L4
        a(r5.a());     // Catch: Throwable -> L4
        return;
    L4:
        b("replay_dispatch_failed");
    }

    private final void a(String r8) {
        Object r0 = this.g;     // Catch: Throwable -> L23
        monitor-enter(r0);     // Catch: Throwable -> L23
        g r1 = this.f11797b.a();     // Catch: Throwable -> L20
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1.a(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L20
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin")).a(), r8) == true) goto L6;
        r3.add(r5);     // Catch: Throwable -> L20
        goto L6
    L10:
        List<e> r9 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r1.b() == true) goto L15;
        if (Intrinsics.areEqual(r9, r1.a()) == false) goto L15;
    L17:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L15:
        if (this.f11797b.a(r9) == true) goto L17;
        b("pending_cleanup_failed");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        b("pending_cleanup_failed");
    }

    private final void a(String r3, String r4) {
        JSONObject r5 = new JSONObject(r4).put("report_mode", "direct_fallback");     // Catch: Throwable -> L4
        Function2<String, String, Unit> r0 = this.c;     // Catch: Throwable -> L4
        String r6 = r5.toString();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");     // Catch: Throwable -> L4
        r0.invoke(r3, r6);     // Catch: Throwable -> L4
        return;
    L4:
        b("direct_fallback_failed");
    }

    private final void a(List<e> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(this.d.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        a((e) ZeusTransformUtils.preCheckCast(r8.next(), e.class, "com.obric.memorydata.plugin"), r2);
        goto L7
    }

    private final boolean a(e r7) {
        Object r0 = this.g;
        monitor-enter(r0);
        g r1 = this.f11797b.a();     // Catch: Throwable -> L16
        if (r1.b() == false) goto L7;
        b("pending_data_invalid");     // Catch: Throwable -> L16
    L7:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(a(r1.a(), ((Number) ZeusTransformUtils.preCheckCast(this.d.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L16
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin")).a(), r7.a()) == true) goto L9;
        r3.add(r5);     // Catch: Throwable -> L16
        goto L9
    L13:
        List<e> r8 = CollectionsKt.takeLast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), r7), 16);     // Catch: Throwable -> L16
        boolean r6 = this.f11797b.a(r8);     // Catch: Throwable -> L16
        monitor-exit(r0);
        return r6;
    L16:
        th = move-exception;
        throw th;
    }

    private final e b(String r7, String r8, long r9) {
        if (b.a().contains(r7) == false) goto L7;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.e.invoke(), String.class, "com.obric.memorydata.plugin");
        JSONObject r6 = new JSONObject(r8).put("crash_event_id", r1).put("crash_time_ms", r9);
        r6.remove("report_mode");
        r6.remove("replay_time_ms");
        r6.remove("replay_delay_ms");
        String r3 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return new e(r1, r7, r3, r9);
    L7:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final String b() {
        return UUID.randomUUID().toString();
    }

    private final void b(String r1) {
        this.f.invoke(r1);     // Catch: Throwable -> L4
        return;
    }

    private static final Unit c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$D-2YYsVQcy7ma6Z-U2P9zQ7Svco, reason: not valid java name */
    public static /* synthetic */ Unit m1031lambda$D2YYsVQcy7ma6ZU2P9zQ7Svco(String r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$j1kx3ZQxva4H2R-Y7jggrgTwVJg, reason: not valid java name */
    public static /* synthetic */ String m1032lambda$j1kx3ZQxva4H2RY7jggrgTwVJg() {
        return b();
    }

    public final void a() {
        if (this.h.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        a(a(((Number) ZeusTransformUtils.preCheckCast(this.d.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue()));     // Catch: Throwable -> L7
    L8:
        this.h.set(false);
        return;
    L7:
        b("replay_load_failed");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.h.set(false);
        throw th;
    }

    public final void a(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "paramsJson");
        e r5 = b(r2, r3, r4);     // Catch: Throwable -> L8
        r3 = r5.c();     // Catch: Throwable -> L8
        if (a(r5) == false) goto L6;
        return;
    L6:
        b("pending_write_failed");     // Catch: Throwable -> L8
    L9:
        a(r2, r3);
        return;
    L8:
        b("pending_create_failed");
        goto L9
    }
}
