package r3a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.larus.platform.service.g2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.utils.SumArrayBlockingQueue;
import hq9.g3;
import hq9.q0;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import q3a.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements p {
    public final Fragment a;
    public final f b;
    public g3 c;
    public q0 d;
    public float e;
    public int f;
    public long g;
    public long h;
    public long i;
    public final SumArrayBlockingQueue j;
    public long k;
    public long l;
    public final Handler m;
    public final Object n;
    public long o;
    public long p;
    public boolean q;
    public boolean r;
    public n s;
    public final String t;

    public static final class a {
    }

    static {
    }

    @Override // q3a.p
    public final void a() {
    }

    @Override // q3a.p
    public final void n() {
    }

    @Override // q3a.p
    public final void g() {
        if (z2.a.enableVideoCaptureStartStatusAlignRtc() == false) goto L23;
        Object r0 = this.n;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.p != 0) goto L9;
        long r3 = 0;
    L11:
        monitor-exit(r0);
        if (b(null) == false) goto L23;
        if (r3 > 2000) goto L17;
        int r1 = 0;
    L18:
        FLogger.a.i("RealtimeCameraMonitor", "reportCameraStartStatus status=" + r1);
        com.larus.platform.service.o r4 = com.larus.platform.service.o.a;
        JSONObject r5 = new JSONObject();
        r5.put("status", r1);
        Unit r2 = Unit.INSTANCE;
        r4.reportEvent("flow_video_capture_start_status", r5);
        goto L23
    L17:
        r1 = 1;
        goto L18
    L9:
        r3 = SystemClock.elapsedRealtime() - this.p;
    L23:
        if (this.g == 0) goto L28;
        long r6 = SystemClock.elapsedRealtime() - this.g;
        com.larus.platform.service.o r7 = com.larus.platform.service.o.a;
        JSONObject r8 = new JSONObject();
        r8.put("duration", r6);
        r8.put("camera_type", "ve");
        Unit r9 = Unit.INSTANCE;
        r7.reportEvent("flow_video_capture_first_frame", r8);
        this.g = 0;
        return;
    }

    @Override // q3a.p
    public final void r() {
        this.i = System.currentTimeMillis();
        if (z2.a.enableVideoCaptureStartStatusAlignRtc() == true) goto L6;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("status", 0);
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("flow_video_capture_start_status", r1);
        return;
    }

    @Override // q3a.p
    public final String o() {
        return this.t;
    }

    public final boolean b(Long r7) {
        Object r0 = this.n;
        monitor-enter(r0);
        if (r7 == null) goto L12;
        long r2 = this.o;     // Catch: Throwable -> L24
        if (r7.longValue() == r2) goto L12;
        monitor-exit(r0);
        return false;
    L24:
        th = move-exception;
        throw th;
    L12:
        if (this.q == true) goto L14;
    L22:
        monitor-exit(r0);
        return false;
    L14:
        if (this.r == true) goto L22;
        this.r = true;     // Catch: Throwable -> L24
        this.q = false;     // Catch: Throwable -> L24
        n r1 = this.s;     // Catch: Throwable -> L24
        if (r1 == null) goto L19;
        this.m.removeCallbacks(r1);     // Catch: Throwable -> L24
    L19:
        this.s = null;     // Catch: Throwable -> L24
        monitor-exit(r0);
        return true;
    }

    public final void c(boolean r3) {
        this.g = SystemClock.elapsedRealtime();
        if (r3 == false) goto L5;
        e(false);
    L5:
        Fragment r4 = this.a;
        if (r4 == null) goto L10;
        Context r5 = r4.getContext();
        if (r5 == null) goto L10;
        g3 r6 = g2.a.b(r5);
    L11:
        this.c = r6;
        g2 r7 = g2.a;
        this.d = r7.d();
        this.e = r7.e();
        this.f = r7.a();
        this.k = 0;
        this.l = 0;
        this.h = 0;
        return;
    L10:
        r6 = null;
        goto L11
    }

    public final void d(String r4) {
        if (b(null) == false) goto L6;
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCameraMonitor", "report start status failed before first frame, source=".concat(r4));
        r0.i("RealtimeCameraMonitor", "reportCameraStartStatus status=1");
        com.larus.platform.service.o r5 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("status", 1);
        Unit r2 = Unit.INSTANCE;
        r5.reportEvent("flow_video_capture_start_status", r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Runnable, r3a.n] */
    public final void e(boolean r6) {
        if (z2.a.enableVideoCaptureStartStatusAlignRtc() == false) goto L23;
        Object r0 = this.n;
        monitor-enter(r0);
        if (r6 == false) goto L25;
    L15:
        n r7 = this.s;     // Catch: Throwable -> L13
        if (r7 == null) goto L18;
        this.m.removeCallbacks(r7);     // Catch: Throwable -> L13
    L18:
        this.s = null;     // Catch: Throwable -> L13
        this.o++;     // Catch: Throwable -> L13
        this.p = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        this.q = true;     // Catch: Throwable -> L13
        this.r = false;     // Catch: Throwable -> L13
        final long r1 = this.o;     // Catch: Throwable -> L13
        ?? r8 = new n(this, r1);     // Catch: Throwable -> L13
        this.s = r8;     // Catch: Throwable -> L13
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        this.m.postDelayed(r8, 2000);
    L13:
        th = move-exception;
        throw th;
    L25:
        if (this.q == false) goto L10;
    L11:
        monitor-exit(r0);
        goto L23
    L10:
        if (this.r == false) goto L15;
    L23:
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        JSONObject r3 = new JSONObject();
        Unit r4 = Unit.INSTANCE;
        r9.reportEvent("flow_video_capture_start", r3);
    }

    @Override // q3a.p
    public final void i(Map<String, ? extends Object> r21) {
        Intrinsics.checkNotNullParameter(r21, "captureParams");
        Intrinsics.checkNotNullParameter(r21, "captureParams");
        Number r3 = null;
        if (z2.a.enableVideoCaptureStartStatusAlignRtc() == false) goto L15;
        d("onCameraClosed");
        Object r2 = this.n;
        monitor-enter(r2);
        this.p = 0;     // Catch: Throwable -> L12
        this.q = false;     // Catch: Throwable -> L12
        this.r = false;     // Catch: Throwable -> L12
        n r7 = this.s;     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        this.m.removeCallbacks(r7);     // Catch: Throwable -> L12
    L9:
        this.s = null;     // Catch: Throwable -> L12
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r2);
    L12:
        th = move-exception;
        throw th;
    L15:
        Object r0 = r21.get("current_fps");
        if ((r0 instanceof Number) == false) goto L18;
        r3 = (Number) r0;
    L18:
        if (r3 == null) goto L20;
        float r1 = r3.floatValue();
    L21:
        double r9 = this.j.getSum() / (((double) this.j.size()) / 1.0d);
        double r10 = this.h / ((System.currentTimeMillis() - this.i) / ((long) 1000));
        g2 r4 = g2.a;
        int r11 = r4.a() - this.f;
        JSONObject r12 = new JSONObject();
        r12.put("current_fps", Float.valueOf(r1));
        r12.put("average_fps", r10);
        r12.put("total_frames", this.h);
        r12.put("average_latency", r9);
        r12.put("capture_start_time", this.i);
        r12.put("max_latency", this.l);
        r12.put("error_count", this.k);
        r12.put("battery_level_delta", r11);
        r12.put("camera_duration", System.currentTimeMillis() - this.i);
        float r5 = r4.e();
        Ref.FloatRef r6 = new Ref.FloatRef();
        Fragment r13 = this.a;
        float r14 = 8.0f;
        float r15 = 5.0f;
        float r16 = 10.0f;
        if (r13 == null) goto L43;
        Context r17 = r13.getContext();
        if (r17 == null) goto L43;
        g3 r18 = r4.b(r17);
        r12.put("is_memory_enable", true);
        long r19 = 1024;
        r12.put("memory_usage", (r18.a / r19) / r19);
        r12.put("cpu_usage", r4.d().a);
        r12.put("java_memory_usage", (r18.a / r19) / r19);
        r12.put("total_pss_memory", (r18.b / r19) / r19);
        r12.put("mobile_ram_memory", (r18.c / r19) / r19);
        r12.put("max_mobile_render_fps", r4.c());
        r12.put("temperature", Float.valueOf(r5));
        g3 r20 = this.c;
        if (r20 == null) goto L41;
        double r22 = ((r18.b - r20.b) / 1024.0d) / 1024.0d;
        r12.put("memory_usage_delta", r22);
        if (r22 > 50.0d) goto L31;
        float r23 = 10.0f;
    L40:
        float r24 = Float.valueOf(r23).floatValue();
    L42:
        r6.element = r24;
    L44:
        float r25 = this.e;
        if (r25 != 0.0f) goto L47;
        boolean r26 = true;
    L49:
        if (r26 == true) goto L64;
        float r27 = r5 - r25;
        r12.put("thermal_state_delta", Float.valueOf(r27));
        if (r27 > 3.0f) goto L55;
        r14 = 10.0f;
        goto L64
    L55:
        if (r27 <= 5.0f) goto L64;
        if (r27 > 8.0f) goto L61;
        r14 = 5.0f;
        goto L64
    L61:
        if (r27 > 12.0f) goto L63;
        r14 = 1.0f;
        goto L64
    L63:
        r14 = 0.0f;
    L64:
        q0 r28 = this.d;
        if (r28 == null) goto L79;
        float r29 = ((float) r4.d().a) - ((float) r28.a);
        r12.put("cpu_usage_delta", Float.valueOf(r29));
        double r30 = r29;
        if (r30 > 0.05d) goto L70;
        float r110 = 10.0f;
    L80:
        double r31 = ((float) r10) / this.b.b.c;
        if (r31 < 0.95d) goto L84;
        double r32 = r9;
        float r33 = 40.0f;
    L97:
        float r34 = (float) r32;
        if (r34 > 200.0f) goto L101;
        r15 = 20.0f;
    L110:
        long r35 = this.k;
        if (r35 > 0) goto L114;
    L120:
        float r36 = ((((r33 + r15) + r16) + r6.element) + r14) + r110;
        if (r36 < 90.0f) goto L124;
        String r37 = "excellent";
    L133:
        r12.put("total_score", Float.valueOf(r36)).put("fps_score", Float.valueOf(r33)).put("memory_score", Float.valueOf(r6.element)).put("latency_score", Float.valueOf(r15)).put("thermal_score", Float.valueOf(r14)).put("cpu_score", Float.valueOf(r110)).put("error_score", Float.valueOf(r16)).put("performance_level", r37);
        com.larus.platform.service.o.a.reportEvent("flow_video_capture_stop", r12);
        this.l = 0;
        this.i = 0;
        this.j.clear();
        this.h = 0;
        return;
    L124:
        if (r36 < 75.0f) goto L127;
        r37 = "good";
        goto L133
    L127:
        if (r36 < 60.0f) goto L130;
        r37 = "fair";
        goto L133
    L130:
        if (r36 < 40.0f) goto L132;
        r37 = "poor";
        goto L133
    L132:
        r37 = "critical";
        goto L133
    L114:
        if (r35 > 3) goto L117;
        r16 = 7.0f;
        goto L120
    L117:
        if (r35 > 10) goto L119;
        r16 = 3.0f;
        goto L120
    L119:
        r16 = 0.0f;
        goto L120
    L101:
        if (r34 > 500.0f) goto L104;
        r15 = 15.0f;
        goto L110
    L104:
        if (r34 > 1000.0f) goto L107;
        r15 = 10.0f;
        goto L110
    L107:
        if (r34 <= 2000.0f) goto L110;
        r15 = 0.0f;
        goto L110
    L84:
        if (r31 < 0.9d) goto L88;
        r33 = 35.0f;
    L86:
        r32 = r9;
        goto L97
    L88:
        if (r31 < 0.8d) goto L91;
        r33 = 30.0f;
        goto L86
    L91:
        if (r31 < 0.7d) goto L93;
        r32 = r9;
        r33 = 20.0f;
        goto L97
    L93:
        r32 = r9;
        if (r31 < 0.6d) goto L96;
        r33 = 10.0f;
        goto L97
    L96:
        r33 = 0.0f;
        goto L97
    L70:
        if (r30 <= 0.1d) goto L79;
        if (r30 > 0.2d) goto L76;
        r110 = 3.0f;
        goto L80
    L76:
        if (r30 > 0.3d) goto L78;
        r110 = 1.0f;
        goto L80
    L78:
        r110 = 0.0f;
    L79:
        r110 = 7.0f;
        goto L80
    L47:
        r26 = false;
        goto L49
    L31:
        if (r22 > 100.0d) goto L34;
        r23 = 8.0f;
        goto L40
    L34:
        if (r22 > 150.0d) goto L37;
        r23 = 5.0f;
        goto L40
    L37:
        if (r22 > 200.0d) goto L39;
        r23 = 1.0f;
        goto L40
    L39:
        r23 = 0.0f;
        goto L40
    L41:
        r24 = Float.valueOf(8.0f).floatValue();
    L43:
        r12.put("is_memory_enable", false);
        goto L44
    L20:
        r1 = -1.0f;
        goto L21
    }

    @Override // q3a.p
    public final void k(int r5) {
        if (z2.a.enableVideoCaptureStartStatusAlignRtc() == true) goto L6;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("status", 1);
        r1.put("camera_type", r5);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("flow_video_capture_start_status", r1);
        return;
    }

    @Override // q3a.p
    public final void l(s3a.b r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if ((r7 instanceof s3a.a) == false) goto L6;
        long r0 = SystemClock.elapsedRealtime() - (((s3a.a) r7).a.g / ((long) 1000));
        this.l = Math.max(this.l, r0);
        this.j.offerAndRemoveOldest(r0);
        return;
    }

    @Override // q3a.p
    public final void s(i r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        this.k++;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("context", r6.b);
        r1.put("timestamp", System.currentTimeMillis());
        r1.put("error_msg", r6.b);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("flow_video_capture_encounter_error", r1);
    }

    @Override // q3a.p
    public final void t(j r5) {
        Intrinsics.checkNotNullParameter(r5, "frame");
        this.h++;
    }

    public o(Fragment r2, f r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this.a = r2;
        this.b = r3;
        this.j = new SumArrayBlockingQueue(100);
        this.m = new Handler(Looper.getMainLooper());
        this.n = new Object();
        this.t = "RealtimeCameraMonitor";
    }

    @Override // q3a.p
    public final void h(l r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "oldState");
        Intrinsics.checkNotNullParameter(r3, "newState");
    }

    @Override // q3a.p
    public final void p(boolean r4, int r5) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("use_back", r4);
        r1.put("result_code", r5);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("flow_video_capture_switch", r1);
    }
}
