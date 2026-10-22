package com.obric.aikernel.request.track;

import android.os.SystemClock;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class VMStartupInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VMStartupInfo f4878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f4879b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f4880c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f4881d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lazy f4882e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f4883f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f4884g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f4885h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f4886i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Lazy f4887j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f4888k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Lazy f4889l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static long f4890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static long f4891n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f4892o;

    static {
        f4878a = new VMStartupInfo();
        f4879b = SystemClock.elapsedRealtime();
        f4880c = LazyKt.lazy(VMStartupInfo$timestampGetInferBinderStart$2.INSTANCE);
        f4881d = LazyKt.lazy(VMStartupInfo$timestampGetInferBinderEnd$2.INSTANCE);
        f4882e = LazyKt.lazy(VMStartupInfo$timestampRuntimeServiceStart$2.INSTANCE);
        f4883f = LazyKt.lazy(VMStartupInfo$timestampRuntimeServiceEnd$2.INSTANCE);
        f4884g = LazyKt.lazy(VMStartupInfo$timestampInferRuntimeStart$2.INSTANCE);
        f4885h = LazyKt.lazy(VMStartupInfo$timestampInferRuntimeEnd$2.INSTANCE);
        f4886i = LazyKt.lazy(VMStartupInfo$timestampRuntimeConfigBuilderStart$2.INSTANCE);
        f4887j = LazyKt.lazy(VMStartupInfo$timestampRuntimeConfigBuilderEnd$2.INSTANCE);
        f4888k = LazyKt.lazy(VMStartupInfo$timestampFbeStart$2.INSTANCE);
        f4889l = LazyKt.lazy(VMStartupInfo$timestampFbeEnd$2.INSTANCE);
    }

    private VMStartupInfo() {
    }

    public static final /* synthetic */ int a() {
        return f4892o;
    }

    public static final /* synthetic */ long b() {
        return f4891n;
    }

    public static final /* synthetic */ long c() {
        return f4890m;
    }

    public static /* synthetic */ void p(VMStartupInfo r10, int r11, long r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = SystemClock.elapsedRealtime();
    L5:
        r10.o(r11, r12);
    }

    public static /* synthetic */ void r(VMStartupInfo r10, long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = SystemClock.elapsedRealtime();
    L5:
        r10.q(r11);
    }

    private final void s() {
        long r10 = f4890m;
        if (r10 == 0) goto L13;
        long r11 = f4891n;
        if (r11 == 0) goto L14;
        long r12 = f4879b;
        long r13 = Math.max(r10, r11) - r12;
        if (r13 > 0) goto L11;
        AIKLog.INSTANCE.e("InferEntry", "Illegal start time " + r13 + " start:" + r12 + " vm:" + f4890m + " res:" + f4891n);
        return;
    L11:
        h.d(m0.a(z0.b()), null, null, new VMStartupInfo$report$1(r13, r12, null), 3, null);
        return;
    L14:
        return;
    }

    public final long d() {
        return f4879b;
    }

    public final long e() {
        return ((Number) f4889l.getValue()).longValue();
    }

    public final long f() {
        return ((Number) f4888k.getValue()).longValue();
    }

    public final long g() {
        return ((Number) f4881d.getValue()).longValue();
    }

    public final long h() {
        return ((Number) f4880c.getValue()).longValue();
    }

    public final long i() {
        return ((Number) f4885h.getValue()).longValue();
    }

    public final long j() {
        return ((Number) f4884g.getValue()).longValue();
    }

    public final long k() {
        return ((Number) f4887j.getValue()).longValue();
    }

    public final long l() {
        return ((Number) f4886i.getValue()).longValue();
    }

    public final long m() {
        return ((Number) f4883f.getValue()).longValue();
    }

    public final long n() {
        return ((Number) f4882e.getValue()).longValue();
    }

    public final synchronized void o(int r10, long r11) {
        monitor-enter(this);
        f4892o = r10;     // Catch: Throwable -> L6
        f4891n = r11;     // Catch: Throwable -> L6
        s();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void q(long r10) {
        monitor-enter(this);
        f4890m = r10;     // Catch: Throwable -> L6
        s();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
