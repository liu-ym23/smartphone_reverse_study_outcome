package com.obric.aikernel.request.track;

import android.os.SystemClock;
import androidx.work.WorkRequest;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.m1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessRequestIntervalReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProcessRequestIntervalReporter f4861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4862b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f4863c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f4864d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final l0 f4865e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f4866f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f4867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicLong f4868h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Function0<Long> f4869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Function0<String> f4870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Function0<String> f4871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Function0<Long> f4872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Function0<Boolean> f4873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Function2<? super String, ? super Map<String, ? extends Object>, Unit> f4874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static Function1<? super Runnable, Unit> f4875o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f4876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f4877b;

        public a(long r10, long r11) {
            this.f4876a = r10;
            this.f4877b = r11;
        }

        public final long a() {
            return this.f4877b;
        }

        public final long b() {
            return this.f4876a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f4876a == r11.f4876a) goto L12;
            return false;
        L12:
            if (this.f4877b == r11.f4877b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f4876a) * 31) + Long.hashCode(this.f4877b);
        }

        public String toString() {
            return "IngressSnapshot(now=" + this.f4876a + ", intervalSinceLastRequestMs=" + this.f4877b + ')';
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class b extends AbstractCoroutineContextElement implements h0 {
        public b(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            AIKLog.INSTANCE.e("ProcReqIntervalTrack", "request interval async task failed", r11);
        }
    }

    static {
        ProcessRequestIntervalReporter r10 = new ProcessRequestIntervalReporter();
        f4861a = r10;
        LazyThreadSafetyMode r11 = LazyThreadSafetyMode.NONE;
        f4862b = LazyKt.lazy(r11, ProcessRequestIntervalReporter$cachedDefaultProcessName$2.INSTANCE);
        f4863c = LazyKt.lazy(r11, ProcessRequestIntervalReporter$cachedDefaultPackageName$2.INSTANCE);
        f4864d = LazyKt.lazy(r11, ProcessRequestIntervalReporter$cachedDefaultAppStartTime$2.INSTANCE);
        ExecutorService r12 = Executors.newSingleThreadExecutor(com.obric.aikernel.request.track.b.f4895c);
        Intrinsics.checkNotNullExpressionValue(r12, "newSingleThreadExecutor …IntervalTrack\")\n        }");
        f4865e = m0.a(m1.b(r12).plus(new k0("AIKReqIntervalTrack")).plus(new b(h0.f10523d)));
        f4866f = new Object();
        f4868h = new AtomicLong(0);
        f4869i = new ProcessRequestIntervalReporter$nowProvider$1(r10);
        f4870j = new ProcessRequestIntervalReporter$processNameProvider$1(r10);
        f4871k = new ProcessRequestIntervalReporter$packageNameProvider$1(r10);
        f4872l = new ProcessRequestIntervalReporter$appStartTimeProvider$1(r10);
        f4873m = new ProcessRequestIntervalReporter$childProcessImportantBindEnabledProvider$1(r10);
        f4874n = new ProcessRequestIntervalReporter$eventReporter$1(r10);
        f4875o = new ProcessRequestIntervalReporter$backgroundTaskRunner$1(r10);
    }

    private ProcessRequestIntervalReporter() {
    }

    public static /* synthetic */ Thread a(Runnable r10) {
        return j(r10);
    }

    public static /* synthetic */ void b(a r10, RequestParams r11) {
        x(r10, r11);
    }

    public static final /* synthetic */ long c(ProcessRequestIntervalReporter r10) {
        return r10.m();
    }

    public static final /* synthetic */ boolean d(ProcessRequestIntervalReporter r10) {
        return r10.n();
    }

    public static final /* synthetic */ void e(ProcessRequestIntervalReporter r10, String r11, Map r12) {
        r10.o(r11, r12);
    }

    public static final /* synthetic */ long f(ProcessRequestIntervalReporter r10) {
        return r10.p();
    }

    public static final /* synthetic */ String g(ProcessRequestIntervalReporter r10) {
        return r10.q();
    }

    public static final /* synthetic */ String h(ProcessRequestIntervalReporter r10) {
        return r10.r();
    }

    public static final /* synthetic */ void i(ProcessRequestIntervalReporter r10, Runnable r11) {
        r10.s(r11);
    }

    private static final Thread j(Runnable r10) {
        return new Thread(r10, "AIK-ReqIntervalTrack");
    }

    private final long m() {
        return t();
    }

    private final boolean n() {
        AIKernelConfig r10 = f7.a.f8866a.a();
        if (r10 == null) goto L8;
        if (r10.getChildProcessImportantBindEnabled() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private final void o(String r10, Map<String, ? extends Object> r11) {
        TrackerApi.INSTANCE.onEvent(r10, new JSONObject(r11));
    }

    private final long p() {
        return SystemClock.elapsedRealtime();
    }

    private final String q() {
        return u();
    }

    private final String r() {
        return v();
    }

    private final void s(Runnable r10) {
        h.d(f4865e, null, null, new ProcessRequestIntervalReporter$defaultRunBackgroundTask$1(r10, null), 3, null);
    }

    private final long t() {
        return ((Number) f4864d.getValue()).longValue();
    }

    private final String u() {
        return (String) f4863c.getValue();
    }

    private final String v() {
        return (String) f4862b.getValue();
    }

    private static final void x(a r10, RequestParams r11) {
        Intrinsics.checkNotNullParameter(r10, "$ingressSnapshot");
        Intrinsics.checkNotNullParameter(r11, "$params");
        ProcessRequestIntervalReporter r12 = f4861a;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L8
        if (r12.A(r10.b()) == true) goto L6;
        return;
    L6:
        Map<String, Object> r14 = r12.k(r11, r12.z(f4870j.invoke(), f4871k.invoke()), r10.a(), r10.b());     // Catch: Throwable -> L8
        f4874n.invoke("aik_process_request_interval", r14);     // Catch: Throwable -> L8
        Object r15 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r16 = Result.m35exceptionOrNullimpl(r15);
        if (r16 == null) goto L16;
        AIKLog.INSTANCE.e("ProcReqIntervalTrack", "request interval event report failed", r16);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final boolean A(long r10) {
        AtomicLong r11 = f4868h;
        long r12 = r11.get();
        if (r12 <= r10) goto L7;
        r11.set(r10);
        return true;
    L7:
        if (r12 > 0) goto L9;
    L12:
        r11.set(r10);
        return true;
    L9:
        if ((r10 - r12) >= VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L12;
        return false;
    }

    public final Map<String, Object> k(RequestParams r10, String r11, long r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "processRole");
        long r14 = RangesKt.coerceAtLeast(r13 - f4872l.invoke().longValue(), 0);
        Pair[] r15 = new Pair[12];
        r15[0] = TuplesKt.to("process_role", r11);
        r15[1] = TuplesKt.to("interval_since_last_request_ms", String.valueOf(r12));
        r15[2] = TuplesKt.to("interval_bucket", y(r12));
        String r16 = r10.getBackend().getString(IdlKeys.MethodName);
        String r17 = "";
        if (r16 != null) goto L5;
        r16 = "";
    L5:
        r15[3] = TuplesKt.to(EnsureReportData.METHOD, r16);
        String r18 = r10.getBackend().getString(IdlKeys.Args_ApiEntrance);
        if (r18 != null) goto L8;
        r18 = "";
    L8:
        r15[4] = TuplesKt.to("api_entrance", r18);
        String r19 = r10.getBackend().getString(IdlKeys.Args_BizName, null);
        if (r19 != null) goto L11;
        r19 = "";
    L11:
        r15[5] = TuplesKt.to("biz", r19);
        String r20 = r10.getBackend().getString(IdlKeys.Args_PackageName, null);
        if (r20 != null) goto L14;
        r20 = "";
    L14:
        r15[6] = TuplesKt.to(ITrackerApi.CALLER_PKG, r20);
        String r21 = r10.getSourcePackageName();
        if (r21 == null) goto L18;
        r17 = r21;
    L18:
        r15[7] = TuplesKt.to("source_pkg", r17);
        r15[8] = TuplesKt.to("request_priority", Integer.valueOf(r10.getPriority()));
        r15[9] = TuplesKt.to("process_uptime_ms", String.valueOf(r14));
        r15[10] = TuplesKt.to("child_process_important_bind_enabled", f4873m.invoke());
        r15[11] = TuplesKt.to("trace_id", r10.getTraceIdStr());
        return MapsKt.linkedMapOf(r15);
    }

    public final a l() {
        long r10 = RangesKt.coerceAtLeast(f4869i.invoke().longValue(), 0);
        long r11 = f4867g;
        f4867g = r10;
        if (r11 > 0) goto L5;
        return null;
    L5:
        if (r11 <= r10) goto L8;
        return null;
    L8:
        return new a(r10, r10 - r11);
    }

    public final void w(final RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Object r11 = f4866f;
        monitor-enter(r11);
        final a r12 = f4861a.l();     // Catch: Throwable -> L11
        if (r12 != null) goto L8;
        monitor-exit(r11);
        return;
    L8:
        f4875o.invoke(new com.obric.aikernel.request.track.a(r12, r10));     // Catch: Throwable -> L11
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r11);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final String y(long r10) {
        if (r10 > WorkRequest.MIN_BACKOFF_MILLIS) goto L6;
        return "<=10s";
    L6:
        if (r10 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) goto L9;
        return "<=30s";
    L9:
        if (r10 > VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L12;
        return "<=60s";
    L12:
        if (r10 > 300000) goto L15;
        return "<=5m";
    L15:
        if (r10 > 3600000) goto L17;
        return "<=1h";
    L17:
        return ">1h";
    }

    public final String z(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "processName");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        if (Intrinsics.areEqual(r10, r11) == false) goto L6;
        return "main";
    L6:
        if (StringsKt.endsWith$default(r10, ":infer", false, 2, null) == false) goto L9;
        return "infer";
    L9:
        if (StringsKt.endsWith$default(r10, ":llm", false, 2, null) == false) goto L13;
        return "llm";
    L13:
        return "main";
    }
}
