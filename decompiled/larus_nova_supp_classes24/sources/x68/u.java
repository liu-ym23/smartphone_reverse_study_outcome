package x68;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.im.service.audio.y;
import com.larus.voicecall.impl.plugins.o2;
import com.larus.voicecall.impl.plugins.p2;
import com.larus.voicecall.impl.plugins.q2;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u {
    public static final AtomicBoolean G = null;
    public static final AtomicBoolean H = null;
    public final r A;
    public final w B;
    public final s C;
    public final f2a.d D;
    public String E;
    public boolean F;
    public final Context a;
    public final Function0<y> b;
    public final Function0<Boolean> c;
    public final Function1<String, Unit> d;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public long j;
    public long k;
    public long l;
    public tf9.b m;
    public String n;
    public long o;
    public long p;
    public final Map<String, Long> q;
    public boolean r;
    public final c s;
    public final c t;
    public da9.e u;
    public int v;
    public final Object w;
    public final AtomicBoolean x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b {
        public final long a;
        public final int b;
        public final long c;
        public final c d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
            long r3 = this.c;
            return ((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "PushDiagnosticsSnapshot(durationMs=" + this.a + ", targetFps=" + this.b + ", minPushFrameIntervalMs=" + this.c + ", stats=" + this.d + ')';
        }

        public b(long r2, int r4, long r5, c r7) {
            Intrinsics.checkNotNullParameter(r7, "stats");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r7;
        }
    }

    public static final class c {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public c() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r4 = this.c;
            int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            long r6 = this.d;
            int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
            long r8 = this.e;
            int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
            long r10 = this.f;
            int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
            long r12 = this.g;
            int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
            long r14 = this.h;
            return r13 + ((int) (r14 ^ (r14 >>> 32)));
        }

        public final String toString() {
            return "PushDiagnosticsStats(captureFrames=" + this.a + ", serviceNullDrops=" + this.b + ", realPushes=" + this.c + ", repeatedPushes=" + this.d + ", pushAttempts=" + this.e + ", pushFailures=" + this.f + ", pushDurationUs=" + this.g + ", maxPushDurationUs=" + this.h + ')';
        }

        public /* synthetic */ c(int r19) {
            this(0, 0, 0, 0, 0, 0, 0, 0);
        }

        public c(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r19) {
            this.a = r4;
            this.b = r6;
            this.c = r8;
            this.d = r10;
            this.e = r12;
            this.f = r14;
            this.g = r16;
            this.h = r19;
        }
    }

    static {
        G = new AtomicBoolean(false);
        H = new AtomicBoolean(false);
    }

    public final Handler a() {
        return (Handler) this.z.getValue();
    }

    public final void c() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.g == false) goto L7;
        return;
    L7:
        if (this.j <= 0) goto L77;
        Object r2 = this.w;
        monitor-enter(r2);
    L65:
        th = move-exception;
        throw th;
    L13:
        if ((SystemClock.elapsedRealtime() - this.k) >= this.j) goto L16;
        monitor-exit(r2);
        return;
    L16:
        tf9.b r0 = this.m;     // Catch: Throwable -> L65
        if (r0 != null) goto L20;
        monitor-exit(r2);
        return;
    L20:
        String r3 = this.n;     // Catch: Throwable -> L65
        if (r3 != null) goto L24;
        monitor-exit(r2);
        return;
    L24:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L65
        monitor-exit(r2);
        y r4 = (y) this.b.invoke();
        boolean r8 = false;
        if (r4 != null) goto L69;
        this.s.b++;
        this.t.b++;
        long r12 = SystemClock.elapsedRealtime();
        Long r5 = (Long) ((LinkedHashMap) this.q).get("screen_share_service_null");
        if (r5 == null) goto L31;
        long r14 = r5.longValue();
    L33:
        if (r14 != 0) goto L35;
    L37:
        this.q.put("screen_share_service_null", Long.valueOf(r12));
        r8 = true;
    L38:
        if (r8 == false) goto L73;
        Map r7 = MapsKt.mapOf(TuplesKt.to("isRepeatedFrame", Boolean.TRUE));
        f2a.c r9 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r9.c.d = "AVKitScreenManager";
        r9.c.b = CollectionsKt.listOf(r3);
        r9.f(new v("screen_share_service_null", r7));
        f2a.c.c(r9, null, 15);
        return;
    L73:
        return;
    L35:
        if ((r12 - r14) >= 30000) goto L37;
    L31:
        r14 = 0;
        goto L33
    L69:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L44
        d(r4, r3, r0, true);     // Catch: Throwable -> L44
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r10 = Result.exceptionOrNull-impl(r1);
        if (r10 == null) goto L74;
        long r15 = SystemClock.elapsedRealtime();
        Long r16 = (Long) ((LinkedHashMap) this.q).get("repeated_push_failure");
        if (r16 == null) goto L51;
        long r17 = r16.longValue();
    L53:
        if (r17 != 0) goto L55;
    L57:
        this.q.put("repeated_push_failure", Long.valueOf(r15));
        boolean r11 = true;
    L58:
        if (r11 == false) goto L75;
        Pair[] r19 = new Pair[2];
        r19[0] = TuplesKt.to("error", r10.getClass().getSimpleName());
        String r20 = r10.getMessage();
        if (r20 != null) goto L63;
        r20 = "";
    L63:
        r19[1] = TuplesKt.to("error_msg", r20);
        Map r21 = MapsKt.mapOf(r19);
        f2a.c r22 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r22.c.d = "AVKitScreenManager";
        r22.c.b = CollectionsKt.listOf(r3);
        r22.f(new v("repeated_push_failure", r21));
        f2a.c.c(r22, null, 15);
        return;
    L75:
        return;
    L55:
        if ((r15 - r17) >= 30000) goto L57;
        r11 = false;
        goto L58
    L51:
        r17 = 0;
        goto L53
    L74:
        return;
    L44:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    }

    public final void e() {
        f2a.c r0 = this.D.b("ScreenShareManagerRelease");
        r0.c.d = "AVKitScreenManager.release";
        String r1 = this.E;
        if (r1 == null) goto L5;
        List r2 = CollectionsKt.listOf(r1);
    L6:
        r0.c.b = r2;
        f2a.c.c(r0, null, 15);
        i();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        ((ba9.a) this.e.getValue()).release();     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void f() {
        if (this.i == true) goto L5;
        return;
    L5:
        double r2 = RangesKt.coerceAtLeast(this.v, 1);
        z68.c.a.getClass();
        Object r0 = z68.c.b;
        monitor-enter(r0);
        z68.a r4 = z68.c.d;     // Catch: Throwable -> L13
        monitor-exit(r0);
        if (r4 == null) goto L18;
        z68.c.g("flow_screen_share_capture_fps", MapsKt.mapOf(new Pair[]{TuplesKt.to("sample_interval_ms", Integer.valueOf(CommandStatus.DORA_TRACE)), TuplesKt.to("capture_fps", Double.valueOf(r2)), TuplesKt.to("output_fps", Double.valueOf(r2)), TuplesKt.to("profile", z68.c.e(r4.e, r4.f, r4.g)), TuplesKt.to("resolution", z68.c.k(r4.e, r4.f))}));
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void h() {
        if (this.j > 0) goto L5;
        return;
    L5:
        if (this.f == true) goto L7;
        return;
    L7:
        if (this.g == true) goto L13;
        a().removeCallbacks(this.A);
        a().postDelayed(this.A, this.j);
        return;
    }

    public final void i() {
        this.x.set(false);
        a().removeCallbacks(this.B);
        b(true);
    }

    public final void j() {
        if (this.j <= 0) goto L5;
    L6:
        a().removeCallbacks(this.A);
    L7:
        Object r0 = this.w;
        monitor-enter(r0);
        this.k = 0;     // Catch: Throwable -> L12
        this.l = 0;     // Catch: Throwable -> L12
        this.m = null;     // Catch: Throwable -> L12
        this.n = null;     // Catch: Throwable -> L12
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.m == null) goto L7;
        goto L6
    }

    public final void g() {
        a().removeCallbacks(this.C);
        if (this.i == true) goto L5;
        return;
    L5:
        a().postDelayed(this.C, 1000);
    }

    public final void b(boolean r37) {
        if (r37 == false) goto L6;
        this.x.set(false);
    L6:
        if (this.o != 0) goto L8;
    L22:
        b r11 = null;
    L23:
        if (r11 != null) goto L25;
        return;
    L25:
        c r2 = r11.d;
        long r5 = r2.c + r2.d;
        final Map r3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("durationMs", Long.valueOf(r11.a)), TuplesKt.to("targetFps", Integer.valueOf(r11.b)), TuplesKt.to("captureFrameCount", Long.valueOf(r2.a)), TuplesKt.to("captureFps", Double.valueOf((r2.a * 1000.0d) / r11.a)), TuplesKt.to("serviceNullDropCount", Long.valueOf(r2.b)), TuplesKt.to("realPushCount", Long.valueOf(r2.c)), TuplesKt.to("realPushFps", Double.valueOf((r2.c * 1000.0d) / r11.a)), TuplesKt.to("repeatedPushCount", Long.valueOf(r2.d)), TuplesKt.to("outputPushCount", Long.valueOf(r5)), TuplesKt.to("outputPushFps", Double.valueOf((r5 * 1000.0d) / r11.a)), TuplesKt.to("pushAttemptCount", Long.valueOf(r2.e)), TuplesKt.to("pushFailureCount", Long.valueOf(r2.f)), TuplesKt.to("avgPushDurationUs", Double.valueOf(r2.g / RangesKt.coerceAtLeast(r2.e, 1))), TuplesKt.to("maxPushDurationUs", Long.valueOf(r2.h)), TuplesKt.to("minPushFrameIntervalMs", Long.valueOf(r11.c))});
        f2a.d r4 = this.D;
        if (r37 == false) goto L28;
        String r6 = "ScreenSharePushDiagnosticsFinal";
    L29:
        f2a.c r7 = r4.b(r6);
        r7.c.d = "AVKitScreenManager.logDiagnosticsSummary";
        String r8 = this.E;
        if (r8 == null) goto L32;
        List r9 = CollectionsKt.listOf(r8);
    L33:
        r7.c.b = r9;
        r7.f(new x68.c(r3));
        f2a.c.c(r7, null, 15);
        return;
    L32:
        r9 = null;
        goto L33
    L28:
        r6 = "ScreenSharePushDiagnostics";
        goto L29
    L8:
        if (this.r == true) goto L22;
        long r10 = SystemClock.elapsedRealtime();
        if (r37 == false) goto L13;
        long r12 = this.o;
    L14:
        long r13 = RangesKt.coerceAtLeast(r10 - r12, 1);
        if (r37 == false) goto L17;
        c r14 = this.s;
    L18:
        r11 = new b(r13, this.v, this.j, new c(r14.a, r14.b, r14.c, r14.d, r14.e, r14.f, r14.g, r14.h));
        if (r37 == false) goto L21;
        this.r = true;
        goto L23
    L21:
        this.p = r10;
        c r15 = this.t;
        r15.a = 0;
        r15.b = 0;
        r15.c = 0;
        r15.d = 0;
        r15.e = 0;
        r15.f = 0;
        r15.g = 0;
        r15.h = 0;
        goto L23
    L17:
        r14 = this.t;
        goto L18
    L13:
        r12 = this.p;
        goto L14
    }

    public static tf9.b k(da9.b r13, boolean r14) {
        int r0 = com.larus.im.internal.delegate.w.n().a;
        int r1 = com.larus.im.internal.delegate.w.n().b;
        da9.a r2 = r13.g;
        return new tf9.b(r2.c, r2.a, r2.b, Math.min(r0, r1), Math.max(r0, r1), r13.e, 1000 * r13.b, r14);
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [x68.r] */
    /* JADX WARN: Type inference failed for: r3v14, types: [x68.s] */
    /* JADX WARN: Type inference failed for: r3v22, types: [x68.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [x68.t] */
    public u(Context r2, o2 r3, p2 r4, q2 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "screenShareServiceProvider");
        Intrinsics.checkNotNullParameter(r4, "useExternalCaptureProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        Lazy r6 = LazyKt.lazy(new o(this));
        this.e = r6;
        this.q = new LinkedHashMap();
        int r7 = 0;
        this.s = new c(r7);
        this.t = new c(r7);
        da9.e r8 = new da9.e(0);
        this.u = r8;
        this.v = r8.b;
        this.w = new Object();
        this.x = new AtomicBoolean(false);
        this.y = LazyKt.lazy(new p());
        this.z = LazyKt.lazy(new q(this));
        this.A = new r(this);
        this.B = new w(this);
        this.C = new s(this);
        this.D = new f2a.d("ScreenShare", "AVKit");
        if (G.compareAndSet(false, true) == false) goto L6;
        ca9.c r9 = ca9.b.a;
        ca9.b.a = new y68.d();
    L6:
        if (H.compareAndSet(false, true) == false) goto L8;
        fe9.j r10 = fe9.i.a;
        fe9.i.a = new y68.g();
    L8:
        ((ba9.a) r6.getValue()).c(new t(this));
        ((ba9.a) r6.getValue()).a(new x68.b(this));
    }

    public final void d(y r22, String r23, tf9.b r24, boolean r25) {
        tf9.b r0 = r24;
        Object r4 = this.w;
        monitor-enter(r4);
        if (r25 == false) goto L11;
        long r9 = SystemClock.elapsedRealtimeNanos() / 1000;     // Catch: Throwable -> L76
        long r11 = this.l;     // Catch: Throwable -> L76
        if (r9 > r11) goto L10;
        r9 = r11 + 1;     // Catch: Throwable -> L76
    L10:
        r0 = tf9.b.a(r0, r9, 63);     // Catch: Throwable -> L76
    L19:
        tf9.b r10 = r0;
        long r12 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L76
        r22.p(r10);     // Catch: Throwable -> L23 Exception -> L26
        long r13 = (SystemClock.elapsedRealtimeNanos() - r12) / 1000;     // Catch: Throwable -> L76
        e = null;
    L28:
        boolean r14 = true;
        if (e != null) goto L34;
        if (r25 == false) goto L32;
        long r15 = SystemClock.elapsedRealtime() - this.k;     // Catch: Throwable -> L76
    L33:
        z68.c r16 = z68.c.a;     // Catch: Throwable -> L76
        int r17 = r10.d;     // Catch: Throwable -> L76
        int r19 = r10.e;     // Catch: Throwable -> L76
        int r110 = RangesKt.coerceAtLeast(this.v, 1);     // Catch: Throwable -> L76
        r16.getClass();     // Catch: Throwable -> L76
        z68.c.d(r23, r17, r19, r110, r25);     // Catch: Throwable -> L76
        this.k = SystemClock.elapsedRealtime();     // Catch: Throwable -> L76
        this.l = r10.g;     // Catch: Throwable -> L76
        this.m = tf9.b.a(r10, 0, 127);     // Catch: Throwable -> L76
        this.n = r23;     // Catch: Throwable -> L76
    L35:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L76
        monitor-exit(r4);
        c r5 = this.s;
        r5.e++;
        this.t.e++;
        r5.g += r13;
        long r111 = r13;
        r5.h = Math.max(r5.h, r111);
        c r6 = this.t;
        r6.g += r111;
        r6.h = Math.max(r6.h, r111);
        if (e == null) goto L40;
        this.s.f++;
        this.t.f++;
    L44:
        if (r111 < 100000) goto L58;
        long r112 = SystemClock.elapsedRealtime();
        Long r21 = (Long) ((LinkedHashMap) this.q).get("slow_downstream_push");
        if (r21 == null) goto L48;
        long r113 = r21.longValue();
    L50:
        if (r113 != 0) goto L52;
    L54:
        this.q.put("slow_downstream_push", Long.valueOf(r112));
        boolean r26 = true;
    L55:
        if (r26 == false) goto L58;
        Map r27 = MapsKt.mapOf(new Pair[]{TuplesKt.to("pushDurationUs", Long.valueOf(r111)), TuplesKt.to("isRepeatedFrame", Boolean.valueOf(r25))});
        f2a.c r114 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r114.c.d = "AVKitScreenManager";
        r114.c.b = CollectionsKt.listOf(r23);
        r114.f(new v("slow_downstream_push", r27));
        f2a.c.c(r114, null, 15);
        goto L58
    L52:
        if ((r112 - r113) >= 30000) goto L54;
        r26 = false;
        goto L55
    L48:
        r113 = 0;
    L58:
        if (e != null) goto L75;
        if (r25 == false) goto L73;
        long r8 = SystemClock.elapsedRealtime();
        Long r3 = (Long) ((LinkedHashMap) this.q).get("repeated_frame_push");
        if (r3 == null) goto L63;
        long r115 = r3.longValue();
    L65:
        if (r115 != 0) goto L67;
    L69:
        this.q.put("repeated_frame_push", Long.valueOf(r8));
    L70:
        if (r14 == false) goto L73;
        Map r7 = MapsKt.mapOf(TuplesKt.to("sinceLastPushMs", Long.valueOf(r15)));
        f2a.c r29 = this.D.c("ScreenSharePushDiagnosticsAnomaly");
        r29.c.d = "AVKitScreenManager";
        r29.c.b = CollectionsKt.listOf(r23);
        r29.f(new v("repeated_frame_push", r7));
        f2a.c.c(r29, null, 15);
        goto L73
    L67:
        if ((r8 - r115) >= 30000) goto L69;
        r14 = false;
        goto L70
    L63:
        r115 = 0;
    L73:
        h();
        return;
    L75:
        throw e;
    L40:
        if (r25 == false) goto L42;
        this.s.d++;
        this.t.d++;
        goto L44
    L42:
        this.s.c++;
        this.t.c++;
        goto L44
    L32:
        r15 = 0;
        goto L33
    L34:
        r13 = r13;
        r15 = 0;
        goto L35
    L26:
        e = e;
        r13 = (SystemClock.elapsedRealtimeNanos() - r12) / 1000;     // Catch: Throwable -> L76
    L23:
        th = move-exception;
        long r30 = (SystemClock.elapsedRealtimeNanos() - r12) / 1000;     // Catch: Throwable -> L76
        throw th;     // Catch: Throwable -> L76
    L11:
        long r31 = r0.g;     // Catch: Throwable -> L76
        long r116 = this.l;     // Catch: Throwable -> L76
        if (r31 <= r116) goto L14;
        long r117 = r31;
    L16:
        if (r117 == r31) goto L19;
        r0 = tf9.b.a(r0, r117, 191);     // Catch: Throwable -> L76
        goto L19
    L14:
        r117 = r116 + 1;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        throw th;
    }
}
