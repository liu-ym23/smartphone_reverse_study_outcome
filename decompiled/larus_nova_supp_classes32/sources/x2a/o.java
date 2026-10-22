package x2a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.view.Choreographer;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.im.FlowRuntime;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o {
    public static final AtomicBoolean A = null;
    public static final Lazy<ThreadPoolExecutor> B = null;
    public static final a z = null;
    public final long a;
    public final boolean b;
    public final String c;
    public final boolean d;
    public final Handler e;
    public Choreographer f;
    public boolean g;
    public boolean h;
    public long i;
    public Long j;
    public boolean k;
    public final i l;
    public float m;
    public boolean n;
    public b o;
    public final q p;
    public final q q;
    public final q r;
    public double s;
    public Double t;
    public Double u;
    public final AtomicBoolean v;
    public Context w;
    public final c x;
    public final d y;

    public static final class a {
        public static final /* synthetic */ ThreadPoolExecutor a() {
            return o.z.getResources();
        }

        private final ThreadPoolExecutor getResources() {
            return (ThreadPoolExecutor) o.B.getValue();
        }

        public a() {
        }
    }

    public static final class b {
        public final long a;
        public final long b;
        public final long c;

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
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r4 = this.c;
            return r2 + ((int) (r4 ^ (r4 >>> 32)));
        }

        public final String toString() {
            return "CpuSnapshot(wallNs=" + this.a + ", processMs=" + this.b + ", mainThreadNs=" + this.c + ')';
        }

        public b(long r1, long r3, long r5) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
        }
    }

    public static final class c implements Choreographer.FrameCallback {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r6) {
            o r0 = this.a;
            if (r0.h == true) goto L5;
            return;
        L5:
            i r1 = r0.l;
            if (r1.a != null) goto L9;
            r1.a = Long.valueOf(r6);
        L12:
            r1.b = r6;
        L13:
            Choreographer r7 = this.a.f;
            if (r7 == null) goto L17;
            r7.postFrameCallback(this);
            return;
        L17:
            return;
        L9:
            if (r6 <= r1.b) goto L13;
            r1.c++;
            goto L12
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ o a;

        public final void a() {
            o r0 = this.a;
            if (r0.h == true) goto L5;
            return;
        L5:
            r0.d();
            o r1 = this.a;
            final Context r2 = r1.w;
            if (r2 != null) goto L8;
        L10:
            this.a.e.postDelayed(this, 1000);
            return;
        L8:
            if (r1.v.compareAndSet(false, true) == false) goto L10;
            a r3 = o.z;
            ThreadPoolExecutor r4 = a.a();
            final o r5 = this.a;
            r4.execute(new p(r5, r2));
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(o r1) {
            this.a = r1;
        }
    }

    static {
        z = new a();
        A = new AtomicBoolean(false);
        B = LazyKt.lazy(new j());
    }

    public final JSONObject a() {
        return new JSONObject().put("page_implementation", this.c).put("is_compose_ab_enabled", this.d ? 1 : 0).put("is_prewarm_ab_enabled", 0).put("is_performance_monitor_enabled", 1).put("is_first_open_after_launch", this.n ? 1 : 0).put("performance_metrics_version", "android_v1").put("fps_measurement", "choreographer_visible_interval").put("memory_measurement", "process_pss").put("cpu_unit", "one_core_ratio").put("enter_timing", "on_pre_draw");
    }

    public final void c() {
        Long r0 = this.j;
        if (r0 == null) goto L11;
        long r1 = r0.longValue();
        if (this.g == true) goto L7;
        return;
    L7:
        if (this.k == true) goto L13;
        this.k = true;
        final JSONObject r2 = a().put("enter_duration_ms", RangesKt.coerceAtLeast(r1 - this.a, 0));
        a.a().execute(new k(this, r2));
        return;
    L13:
        return;
    }

    public final void d() {
        long r8 = SystemClock.elapsedRealtimeNanos();
        long r10 = Process.getElapsedCpuTime();
        long r12 = Debug.threadCpuTimeNanos();
        b r7 = new b(r8, r10, r12);
        b r0 = this.o;
        if (r0 == null) goto L12;
        long r9 = r8 - r0.a;
        if (r9 >= 100000000) goto L7;
        return;
    L7:
        long r1 = r0.b;
        if (r10 < r1) goto L12;
        if (r12 < r0.c) goto L12;
        double r4 = r9;
        this.p.a(((r10 - r1) * 1000000.0d) / r4);
        this.q.a((r12 - r0.c) / r4);
    L12:
        this.o = r7;
    }

    public final void e(Context r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        if (this.s != 0.0d) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        Object r8 = r7.getSystemService("activity");     // Catch: Throwable -> L23
        if ((r8 instanceof ActivityManager) == false) goto L10;
        ActivityManager r9 = (ActivityManager) r8;     // Catch: Throwable -> L23
    L11:
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L23
        if (r9 == null) goto L14;
        r9.getMemoryInfo(r2);     // Catch: Throwable -> L23
    L14:
        this.s = r2.totalMem / 1048576.0d;     // Catch: Throwable -> L23
        goto L15
    L10:
        r9 = null;
    L15:
        Debug.MemoryInfo r10 = new Debug.MemoryInfo();     // Catch: Throwable -> L23
        Debug.getMemoryInfo(r10);     // Catch: Throwable -> L23
        double r3 = ((double) r10.getTotalPss()) / 1024.0d;     // Catch: Throwable -> L23
        if (r3 > 0.0d) goto L18;
    L21:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L31;
        FLogger.a.e("VoiceSettingPerformance", "memory sample failed", r12);
        return;
    L31:
        return;
    L18:
        if (this.t != null) goto L20;
        this.t = Double.valueOf(r3);     // Catch: Throwable -> L23
    L20:
        this.u = Double.valueOf(r3);     // Catch: Throwable -> L23
        this.r.a(r3);     // Catch: Throwable -> L23
        goto L21
    L5:
        r1 = false;
    L23:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    public o(String r5, long r6) {
        String r0 = "{}";
        Intrinsics.checkNotNullParameter(r5, "implementation");
        this.a = r6;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L33
        Keva r8 = Keva.getRepo("voice_setting_performance_debug");     // Catch: Throwable -> L33
        g0 r3 = null;
        if (r8.contains("voice_setting_kmp_perf_opt") == false) goto L17;
        String r9 = r8.getString("voice_setting_kmp_perf_opt", "{}");     // Catch: Throwable -> L33
        if (r9 == null) goto L9;
        r0 = r9;
    L9:
        ouc.i r10 = ouc.a.d.e(r0);     // Catch: Throwable -> L33
        if ((r10 instanceof d0) == false) goto L12;
        d0 r11 = (d0) r10;     // Catch: Throwable -> L33
    L13:
        if (r11 == null) goto L16;
    L18:
        int r1 = x2a.d.a;     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r11, "config");     // Catch: Throwable -> L33
        Object r12 = r11.get("enable_monitor");     // Catch: Throwable -> L33
        if ((r12 instanceof g0) == false) goto L21;
        g0 r13 = (g0) r12;     // Catch: Throwable -> L33
    L22:
        if (r13 != null) goto L24;
    L30:
        boolean r14 = true;
    L31:
        Object r15 = Result.constructor-impl(Boolean.valueOf(r14));     // Catch: Throwable -> L33
    L35:
        Throwable r2 = Result.exceptionOrNull-impl(r15);
        if (r2 == null) goto L38;
        FLogger.a.e("VoiceSettingPerformance", "Unable to read monitor setting", r2);
    L38:
        Boolean r4 = Boolean.TRUE;
        if (Result.isFailure-impl(r15) == false) goto L41;
        r15 = r4;
    L41:
        this.b = ((Boolean) r15).booleanValue();
        if (Intrinsics.areEqual(r5, "kmp") == false) goto L44;
        String r16 = "compose";
    L45:
        this.c = r16;
        this.d = z2.a.enableKmpVoiceSetting();
        this.e = new Handler(Looper.getMainLooper());
        this.l = new i();
        this.p = new q();
        this.q = new q();
        this.r = new q();
        this.v = new AtomicBoolean(false);
        this.x = new c(this);
        this.y = new d(this);
        return;
    L44:
        r16 = "native";
        goto L45
    L24:
        if (r13.c() == true) goto L26;
        r3 = r13;
    L26:
        if (r3 == null) goto L30;
        Boolean r17 = ouc.k.f(r3);     // Catch: Throwable -> L33
        if (r17 == null) goto L30;
        r14 = r17.booleanValue();     // Catch: Throwable -> L33
        goto L31
    L21:
        r13 = null;
        goto L22
    L16:
        throw new IllegalArgumentException("Expected settings object".toString());     // Catch: Throwable -> L33
    L12:
        r11 = null;
        goto L13
    L17:
        r11 = FlowRuntime.b().b().e("voice_setting_kmp_perf_opt", new d0(MapsKt.emptyMap()), false);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }

    public static void b(String r2, JSONObject r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        com.larus.platform.service.o.a.reportEvent(r2, r3);     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        FLogger.a.e("VoiceSettingPerformance", "report failed: ".concat(r2), r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
