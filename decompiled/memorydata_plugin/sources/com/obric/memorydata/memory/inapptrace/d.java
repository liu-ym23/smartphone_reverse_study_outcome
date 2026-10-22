package com.obric.memorydata.memory.inapptrace;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u001cJ\u001e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0005J#\u0010#\u001a\u0004\u0018\u00010\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010&\u001a\u00020\t¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J!\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u001cH\u0002J0\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00052\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c05H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceCollector;", "", "<init>", "()V", "TAG", "", "MAX_EVENTS_PER_ZIP", "", "MAX_BYTES_PER_ZIP", "", "MAX_DURATION_MS", "FINAL_ASSOCIATION_LOOKUP_MS", "PENDING_ASSOCIATION_TTL_MS", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "flushScheduler", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "flushGeneration", "pendingAssociations", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceCollector$PendingAssociation;", "writer", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceBatchFileWriter;", "getWriter", "()Lcom/obric/memorydata/memory/inapptrace/InAppTraceBatchFileWriter;", "writer$delegate", "Lkotlin/Lazy;", "offer", "", "json", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "scheduleForObservation", "observationId", "screenshotTimestamp", "flushRequestId", "remainingFinalizationDelay", "observationIds", "", "now", "(Ljava/util/Collection;J)Ljava/lang/Long;", "onFrameworkFlushCompleted", "completion", "Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;", "scheduleFinalAssociation", "bindPendingAssociations", InfoRequestQPSOptTraceLogger.REASON, "finalizeObservationId", "(Ljava/lang/String;Ljava/lang/Long;)V", "scheduleIdleFlush", "executeSafely", "", "operation", "onFailure", "Lkotlin/Function0;", "block", "PendingAssociation", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadPoolExecutor f10165b = null;
    private static final ScheduledThreadPoolExecutor c = null;
    private static volatile long d;
    private static final ConcurrentHashMap<Long, a> e = null;
    private static final Lazy f = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceCollector$PendingAssociation;", "", "screenshotTimestamp", "", "<init>", "(J)V", "getScreenshotTimestamp", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10166a;

        public a(long r1) {
            this.f10166a = r1;
        }

        public final long a() {
            return this.f10166a;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (this.f10166a == r8.f10166a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f10166a);
        }

        public String toString() {
            return "PendingAssociation(screenshotTimestamp=" + this.f10166a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), a.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), a.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10164a = new d();
        ThreadPoolExecutor r0 = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new ArrayBlockingQueue(64), BlockingQueue.class, "com.obric.memorydata.plugin"), $$Lambda$d$Dd91WGvvozxW_Q8MSb2Uew6ZSOQ.INSTANCE, (RejectedExecutionHandler) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor.AbortPolicy(), RejectedExecutionHandler.class, "com.obric.memorydata.plugin"));
        r0.allowCoreThreadTimeOut(true);
        f10165b = r0;
        ScheduledThreadPoolExecutor r1 = new ScheduledThreadPoolExecutor(1, $$Lambda$d$82vqmGaF3iGew4ZTAXZBRMba1Zg.INSTANCE);
        r1.setRemoveOnCancelPolicy(true);
        c = r1;
        e = new ConcurrentHashMap();
        f = LazyKt.lazy($$Lambda$d$sTXTiZhAIr10NPJtMiTJgVN1Jks.INSTANCE);
    }

    private d() {
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "in_app_trace_writer");
    }

    private static final Unit a(long r8) {
        if (e.containsKey(Long.valueOf(r8)) == false) goto L9;
        d r0 = f10164a;
        if (r0.b().a() == true) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "final flush failed observationId=" + r8, null, 4, null);
    L7:
        r0.a("final_lookup", Long.valueOf(r8));
    L9:
        return Unit.INSTANCE;
    }

    private static final Unit a(long r1, a r3) {
        e.remove(Long.valueOf(r1), r3);
        return Unit.INSTANCE;
    }

    private final void a(final long r8, long r10) {
        long r11 = e.f10167a.a(r10, System.currentTimeMillis(), 5000);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "final trace lookup scheduled observationId=" + r8 + " delayMs=" + r11, false, 4, null);
        c.schedule(new $$Lambda$d$5rN86kjy9z22JvyTN_IzFJ_hkBY(r8), r11, TimeUnit.MILLISECONDS);
    }

    public static final /* synthetic */ void a(d r0, com.obric.memorydata.memory.j r1) {
        r0.a(r1);
    }

    private final void a(final com.obric.memorydata.memory.j r7) {
        a(this, "complete framework flush", null, new $$Lambda$d$WKHDwFt77FYATBXFECwkVFzW5k8(r7), 2, null);
    }

    private final void a(String r22, Long r23) {
        long r0 = System.currentTimeMillis();
        Set<Map.Entry<Long, a>> r2 = e.entrySet();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-entries>(...)");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r4);
        Object r5 = r4.getKey();
        Intrinsics.checkNotNullExpressionValue(r5, "component1(...)");
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin");
        Object r7 = r4.getValue();
        Intrinsics.checkNotNullExpressionValue(r7, "component2(...)");
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
        if ((r0 - r8.a()) > 10000) goto L7;
        int r9 = i.a(i.f10176a, r6.longValue(), r8.a(), 0, 4, null);
        boolean r10 = Intrinsics.areEqual(r6, r23);
        if (r10 == false) goto L11;
        e.remove(r6, r8);
    L11:
        RunLog r11 = RunLog.INSTANCE;
        String r12 = "pending trace lookup reason=" + r22 + " observationId=" + r6.longValue() + " traceCount=" + r9 + " finalized=" + r10 + " screenshotTimestamp=" + r8.a();
        if (r9 <= 0) goto L14;
        boolean r13 = true;
    L15:
        r11.info("InAppTraceCollector", r12, r13);
        goto L4
    L14:
        r13 = false;
        goto L15
    L7:
        e.remove(r6, r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "pending trace association expired observationId=" + r6.longValue(), false, 4, null);
        goto L4
    }

    private static final void a(Function0 r3, String r4, Function0 r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(r6.invoke());     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L15;
        RunLog.INSTANCE.error("InAppTraceCollector", "in-app trace " + r4 + " failed safely", r9);
        if (r7 == null) goto L16;
        r7.invoke();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final boolean a(com.obric.memorydata.memory.inapptrace.a r1) {
        Intrinsics.checkNotNullParameter(r1, "completed");
        boolean r2 = i.f10176a.a(r1);
        if (r2 == false) goto L5;
        k.f10179a.a();
    L5:
        return r2;
    }

    static /* synthetic */ boolean a(d r1, String r2, Function0 r3, Function0 r4, int r5, Object r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = null;
    L6:
        return r1.a(r2, r7, r8);
    }

    private final boolean a(final String r5, Function0<Unit> r6, Function0<Unit> r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        f10165b.execute(new $$Lambda$d$gG0IHoewDN4O5PUF7cdRMhkrBNg(r9, r5, r8));     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L13;
        RunLog.INSTANCE.error("InAppTraceCollector", "schedule in-app trace " + r5 + " failed safely", r11);
        if (r8 == null) goto L13;
        r8.invoke();
    L13:
        if (Result.m1427isFailureimpl(r10) == false) goto L16;
        r10 = false;
    L16:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final c b() {
        return (c) ZeusTransformUtils.preCheckCast(f.getValue(), c.class, "com.obric.memorydata.plugin");
    }

    private static final Long b(long r7, long r9) {
        ConcurrentHashMap<Long, a> r0 = e;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.get(Long.valueOf(r9)), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r7 - r1.a()) <= 10000) goto L9;
    L7:
        r0.remove(Long.valueOf(r9), r1);
        return null;
    L9:
        long r3 = (r1.a() + 5000) - r7;
        if (r3 <= 0) goto L7;
        return Long.valueOf(r3);
    }

    private static final Thread b(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "in_app_trace_flush");
    }

    private static final Unit b(long r15, long r17, String r19) {
        d r13 = f10164a;
        if (r13.b().a() == true) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "flush trace for observation failed observationId=" + r15, null, 4, null);
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "initial trace lookup observationId=" + r15 + " traceCount=" + i.a(i.f10176a, r15, r17, 0, 4, null) + " screenshotTimestamp=" + r17, false, 4, null);
        if (com.obric.memorydata.memory.k.f10230a.a(r19, r15, r17, (Function1) ZeusTransformUtils.preCheckCast(new InAppTraceCollector$scheduleForObservation$2$requested$1(r13), Function1.class, "com.obric.memorydata.plugin")) == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "framework flush unavailable, use late lookup observationId=" + r15, null, 4, null);
        r13.a(r15, r17);
    L9:
        return Unit.INSTANCE;
    }

    private static final Unit b(com.obric.memorydata.memory.j r16) {
        ConcurrentHashMap<Long, a> r0 = e;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.get(Long.valueOf(r16.b())), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "ignore flush for finalized observation requestId=" + r16.a() + " observationId=" + r16.b(), null, 4, null);
    L6:
        return Unit.INSTANCE;
    L8:
        if (f10164a.b().a() == true) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "flush writer after framework completion failed observationId=" + r16.b(), null, 4, null);
    L10:
        Long r4 = Long.valueOf(r16.e());
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue();
        boolean r7 = true;
        if (r16.f() == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L21;
        long r6 = r4.longValue();
    L22:
        int r8 = i.f10176a.a(r16.b(), r16.c(), r6);
        r0.remove(Long.valueOf(r16.b()), r1);
        RunLog r2 = RunLog.INSTANCE;
        String r9 = "framework flush finalized requestId=" + r16.a() + " observationId=" + r16.b() + " result=" + r16.d() + " completionReceived=" + r16.f() + " watermark=" + r16.e() + " traceCount=" + r8;
        if (Intrinsics.areEqual(r16.d(), "ok") == false) goto L26;
        if (r8 <= 0) goto L26;
    L27:
        r2.info("InAppTraceCollector", r9, r7);
    L26:
        r7 = false;
        goto L27
    L21:
        r6 = r16.c() + 2000;
        goto L22
    L13:
        if (r5 <= 0) goto L15;
        r3 = true;
        goto L16
    }

    private static final Unit b(String r7) {
        d r0 = f10164a;
        if (r0.b().a(r7) == true) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "reject invalid in-app signal batch chars=" + r7.length(), null, 4, null);
    L7:
        return Unit.INSTANCE;
    L5:
        r0.c();
        goto L7
    }

    private static final void b(final long r6) {
        a(f10164a, "late associate observation", null, new $$Lambda$d$ckPgciGjSJ7xSijBjU8j4QIMTBY(r6), 2, null);
    }

    private final void c() {
        d++;
        final long r0 = d;
        c.schedule(new $$Lambda$d$OnQqWB0D_sUHFpEcjVGkmyEZldE(r0), 60000, TimeUnit.MILLISECONDS);
    }

    private static final void c(long r2) {
        if (r2 != d) goto L6;
        f10164a.a();
        return;
    }

    private static final c d() {
        int r2 = 1000;
        long r3 = 1048576;
        long r5 = 60000;
        Function0 r7 = null;
        return new c(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "in_app_trace/pending"), r2, r3, r5, r7, $$Lambda$d$KeFUNO85zFl92z64RF_4QJZtCnc.INSTANCE, 16, null);
    }

    private static final Unit e() {
        if (f10164a.b().a() == true) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceCollector", "flush in-app trace batch failed", null, 4, null);
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void lambda$5rN86kjy9z22JvyTN_IzFJ_hkBY(long r0) {
        b(r0);
    }

    /* JADX INFO: renamed from: lambda$6CcQJV1ylTv6p-twoP3t59fW35A, reason: not valid java name */
    public static /* synthetic */ Unit m704lambda$6CcQJV1ylTv6ptwoP3t59fW35A(long r0, a r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ Thread lambda$82vqmGaF3iGew4ZTAXZBRMba1Zg(Runnable r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$B-3xA5dwfy2rm9G3UpfAThtamVE, reason: not valid java name */
    public static /* synthetic */ Unit m705lambda$B3xA5dwfy2rm9G3UpfAThtamVE() {
        return e();
    }

    public static /* synthetic */ Long lambda$Ch1e89MDjZZKoTkRzrvGT38Lzi8(long r0, long r2) {
        return b(r0, r2);
    }

    public static /* synthetic */ Thread lambda$Dd91WGvvozxW_Q8MSb2Uew6ZSOQ(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$HOUvl_KWZEQhRGD3Xjia70U4dnE(String r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$KeFUNO85zFl92z64RF_4QJZtCnc(com.obric.memorydata.memory.inapptrace.a r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$OnQqWB0D_sUHFpEcjVGkmyEZldE(long r0) {
        c(r0);
    }

    public static /* synthetic */ Unit lambda$WKHDwFt77FYATBXFECwkVFzW5k8(com.obric.memorydata.memory.j r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$bRBo_Mrd03dwhqOMN4yT3zNd8_M(long r0, long r2, String r4) {
        return b(r0, r2, r4);
    }

    public static /* synthetic */ Unit lambda$ckPgciGjSJ7xSijBjU8j4QIMTBY(long r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$gG0IHoewDN4O5PUF7cdRMhkrBNg(Function0 r0, String r1, Function0 r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ c lambda$sTXTiZhAIr10NPJtMiTJgVN1Jks() {
        return d();
    }

    public final Long a(Collection<Long> r2, final long r3) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "observationIds");
        return (Long) ZeusTransformUtils.preCheckCast(SequencesKt.maxOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$d$Ch1e89MDjZZKoTkRzrvGT38Lzi8(r3))), Long.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
        a(this, ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, null, $$Lambda$d$B3xA5dwfy2rm9G3UpfAThtamVE.INSTANCE, 2, null);
    }

    public final void a(final long r9, final long r11, final String r13) {
        Intrinsics.checkNotNullParameter(r13, "flushRequestId");
        if (r9 > 0) goto L5;
        return;
    L5:
        if (r11 <= 0) goto L10;
        final a r0 = new a(r11);
        Long r1 = Long.valueOf(r9);
        ((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin")).put(r1, r0);
        a("associate observation", new $$Lambda$d$6CcQJV1ylTv6ptwoP3t59fW35A(r9, r0), new $$Lambda$d$bRBo_Mrd03dwhqOMN4yT3zNd8_M(r9, r11, r13));
        return;
    }

    public final void a(final String r8) {
        Intrinsics.checkNotNullParameter(r8, "json");
        a(this, "append", null, new $$Lambda$d$HOUvl_KWZEQhRGD3Xjia70U4dnE(r8), 2, null);
    }
}
