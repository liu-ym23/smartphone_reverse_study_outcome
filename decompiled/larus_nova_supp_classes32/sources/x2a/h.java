package x2a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.larus.platform.api.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final /* synthetic */ int p = 0;
    public final String a;
    public final Function1<String, x2a.a> b;
    public final Lazy c;
    public final String d;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public View k;
    public e l;
    public long m;
    public long n;
    public o o;

    public static final class a {
    }

    static {
    }

    public h() {
        throw null;
    }

    public final e1 c() {
        return (e1) this.c.getValue();
    }

    public final void d() {
        final o r2 = this.o;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.h == false) goto L27;
        r2.h = false;
        r2.e.removeCallbacks(r2.y);
        Choreographer r0 = r2.f;
        if (r0 == null) goto L10;
        r0.removeFrameCallback(r2.x);
    L10:
        r2.f = null;
        r2.d();
        final long r7 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r2.i, 0);
        final JSONObject r4 = r2.a().put("visible_duration_ms", r7).put("frame_count", r2.l.c);
        float r1 = r2.m;
        if (r1 <= 0.0f) goto L13;
        r4.put("max_refresh_rate", Float.valueOf(r1));
    L13:
        i r3 = r2.l;
        Long r9 = r3.a;
        if (r9 == null) goto L18;
        long r11 = r3.b - r9.longValue();
        if (r11 <= 0) goto L18;
        Double r10 = Double.valueOf((r3.c * 1.0E9d) / r11);
    L19:
        if (r10 == null) goto L21;
        r4.put("average_fps", r10.doubleValue());
    L21:
        final JSONObject r12 = r2.a().put("visible_duration_ms", r7);
        q r5 = r2.p;
        if (r5.a <= 0) goto L24;
        r12.put("average_process_cpu", r5.b()).put("peak_process_cpu", r2.p.c).put("average_main_thread_cpu", r2.q.b()).put("peak_main_thread_cpu", r2.q.c);
    L24:
        final Context r6 = r2.w;
        r2.w = null;
        o.a r8 = o.z;
        final Double r13 = r10;
        o.a.a().execute(new l(r6, r2, r13, r4, r12, r7));
        return;
    L18:
        r10 = null;
        goto L19
    }

    public final void f() {
        View r0 = this.k;
        e r1 = this.l;
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        if (r0.getViewTreeObserver().isAlive() == false) goto L8;
        FLogger.a.d("VoiceSettingPerfTracer", "remove first frame listener, implementation=" + this.a);
        r0.getViewTreeObserver().removeOnPreDrawListener(r1);
    L8:
        this.k = null;
        this.l = null;
    }

    public final void g() {
        if (this.f == false) goto L6;
        FLogger.a.d("VoiceSettingPerfTracer", "start ignored, already started, implementation=" + this.a);
        return;
    L6:
        FLogger r1 = FLogger.a;
        r1.d("VoiceSettingPerfTracer", "start trace, implementation=" + this.a + ", page=VoiceSetting_" + this.a + ", scene=" + this.d);
        this.f = true;
        this.m = SystemClock.elapsedRealtime();
        this.o = new o(this.a, this.m);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        e1 r5 = c();     // Catch: Throwable -> L18
        if (r5 == null) goto L10;
        r5.startTrace();     // Catch: Throwable -> L18
    L10:
        e1 r6 = c();     // Catch: Throwable -> L18
        if (r6 == null) goto L13;
        r6.c("open");     // Catch: Throwable -> L18
    L13:
        this.h = true;     // Catch: Throwable -> L18
        com.larus.platform.service.g.a.e(this.d);     // Catch: Throwable -> L18
        x2a.a r3 = (x2a.a) this.e.getValue();     // Catch: Throwable -> L18
        if (r3 == null) goto L16;
        r3.start();     // Catch: Throwable -> L18
    L16:
        r1.d("VoiceSettingPerfTracer", "start trace success, implementation=" + this.a);     // Catch: Throwable -> L18
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r2 = Result.exceptionOrNull-impl(r0);
        if (r2 == null) goto L26;
        FLogger.a.e("VoiceSettingPerfTracer", "start trace failed", r2);
        return;
    L26:
        return;
    L18:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public final void i() {
        d();
        if (this.f == true) goto L6;
        FLogger.a.d("VoiceSettingPerfTracer", "stop ignored, not started, implementation=" + this.a);
        return;
    L6:
        FLogger r1 = FLogger.a;
        r1.d("VoiceSettingPerfTracer", "stop trace, implementation=" + this.a + ", firstFrameReached=" + this.g + ", pageTraceEnded=" + this.j);
        f();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        b(this.g);     // Catch: Throwable -> L12
        x2a.a r4 = (x2a.a) this.e.getValue();     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        r4.stop();     // Catch: Throwable -> L12
    L10:
        com.larus.platform.service.g.a.g(this.d);     // Catch: Throwable -> L12
        r1.d("VoiceSettingPerfTracer", "stop trace success, implementation=" + this.a);     // Catch: Throwable -> L12
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r2 = Result.exceptionOrNull-impl(r0);
        if (r2 == null) goto L20;
        FLogger.a.e("VoiceSettingPerfTracer", "stop trace failed", r2);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "spanName");
        FLogger.a.d("VoiceSettingPerfTracer", "end span, implementation=" + this.a + ", span=" + r4);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        e1 r1 = c();     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.b(r4);     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L17;
        FLogger.a.e("VoiceSettingPerfTracer", "end span failed", r7);
        return;
    L17:
        return;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void b(boolean r5) {
        if (this.j == false) goto L6;
        FLogger.a.d("VoiceSettingPerfTracer", "finish page trace ignored, already ended, implementation=" + this.a);
        return;
    L6:
        FLogger.a.d("VoiceSettingPerfTracer", "finish page trace, implementation=" + this.a + ", success=" + r5 + ", firstFrameSpanStarted=" + this.i + ", openSpanStarted=" + this.h);
        if (this.i == false) goto L13;
        e1 r0 = c();
        if (r0 == null) goto L11;
        r0.b("first_frame");
    L11:
        this.i = false;
    L13:
        if (this.h == false) goto L18;
        e1 r1 = c();
        if (r1 == null) goto L17;
        r1.b("open");
    L17:
        this.h = false;
    L18:
        e1 r2 = c();
        if (r2 == null) goto L21;
        r2.a(r5 ? 1 : 0);
    L21:
        this.j = true;
    }

    public final void e(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        o r1 = this.o;
        if (r1 == null) goto L41;
        Intrinsics.checkNotNullParameter(r7, "view");
        if (r1.b == true) goto L7;
        return;
    L7:
        if (r1.g == true) goto L43;
        int r0 = 1;
        r1.g = true;
        r1.h = true;
        r1.i = SystemClock.elapsedRealtime();
        r1.n = !o.A.getAndSet(true);
        Display r2 = r7.getDisplay();
        Float r3 = null;
        if (r2 != null) goto L19;
        Object r4 = r7.getContext().getSystemService("window");
        if ((r4 instanceof WindowManager) == false) goto L14;
        WindowManager r5 = (WindowManager) r4;
    L15:
        if (r5 == null) goto L17;
        r2 = r5.getDefaultDisplay();
        goto L19
    L17:
        r2 = null;
        goto L19
    L14:
        r5 = null;
    L19:
        if (Build.VERSION.SDK_INT < 23) goto L37;
        if (r2 == null) goto L37;
        Display.Mode[] r6 = r2.getSupportedModes();
        if (r6 == null) goto L37;
        if (r6.length != 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L35;
        float r9 = r6[0].getRefreshRate();
        int r10 = ArraysKt.getLastIndex(r6);
        if (1 > r10) goto L34;
    L31:
        r9 = Math.max(r9, r6[r0].getRefreshRate());
        if (r0 == r10) goto L34;
        r0 = r0 + 1;
    L34:
        r3 = Float.valueOf(r9);
    L35:
        if (r3 == null) goto L37;
        float r11 = r3.floatValue();
    L38:
        r1.m = r11;
        r1.w = r7.getContext().getApplicationContext();
        r1.c();
        r1.y.run();
        Choreographer r12 = Choreographer.getInstance();
        r12.postFrameCallback(r1.x);
        r1.f = r12;
        return;
    L26:
        r8 = false;
    L37:
        r11 = 0.0f;
        goto L38
    L43:
        return;
    }

    public final void h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "spanName");
        FLogger.a.d("VoiceSettingPerfTracer", "start span, implementation=" + this.a + ", span=" + r4);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        e1 r1 = c();     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.c(r4);     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L17;
        FLogger.a.e("VoiceSettingPerfTracer", "start span failed", r7);
        return;
    L17:
        return;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.ViewTreeObserver$OnPreDrawListener, x2a.e] */
    public final void j(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        boolean r1 = true;
        if (this.g == false) goto L5;
    L9:
        FLogger r7 = FLogger.a;
        StringBuilder r0 = new StringBuilder("trace first frame ignored, implementation=");
        r0.append(this.a);
        r0.append(", firstFrameReached=");
        r0.append(this.g);
        r0.append(", hasListener=");
        if (this.l != null) goto L13;
        r1 = false;
    L13:
        r0.append(r1);
        r7.d("VoiceSettingPerfTracer", r0.toString());
        return;
    L5:
        if (this.l != null) goto L9;
        FLogger.a.d("VoiceSettingPerfTracer", "trace first frame start, implementation=" + this.a + ", view=" + r6.getClass().getSimpleName());
        this.k = r6;
        this.n = SystemClock.elapsedRealtime();
        h("first_frame");
        this.i = true;
        ?? r2 = new e(this);
        this.l = r2;
        r6.getViewTreeObserver().addOnPreDrawListener(r2);
    }

    public h(String r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
        this.c = LazyKt.lazy(new f(this));
        this.d = "VOICE_SETTING_".concat(r1);
        this.e = LazyKt.lazy(new g(this));
    }

    public final <T> T k(String r6, Function0<? extends T> r7) {
        Intrinsics.checkNotNullParameter(r6, "spanName");
        Intrinsics.checkNotNullParameter(r7, "block");
        FLogger r1 = FLogger.a;
        r1.d("VoiceSettingPerfTracer", "trace span enter, implementation=" + this.a + ", span=" + r6);
        h(r6);
        T r8 = (T) r7.invoke();
        a(r6);
        r1.d("VoiceSettingPerfTracer", "trace span exit, implementation=" + this.a + ", span=" + r6);
        return r8;
    L6:
        th = move-exception;
        a(r6);
        FLogger.a.d("VoiceSettingPerfTracer", "trace span exit, implementation=" + this.a + ", span=" + r6);
        throw th;
    }
}
