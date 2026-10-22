package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f5860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.apm.trace.fps.b f5861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f5862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f5863f;

    public static final class a implements com.bytedance.apm.trace.fps.b.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5864a;

        a(c r10) {
            this.f5864a = r10;
        }

        @Override // com.bytedance.apm.trace.fps.b.g
        public void a(double r10) {
            d r11 = c.b(this.f5864a);
            if (r11 == null) goto L7;
            r11.q(r10);
            return;
        }
    }

    public static final class b implements com.bytedance.apm.trace.fps.b.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5865a;

        b(c r10) {
            this.f5865a = r10;
        }

        @Override // com.bytedance.apm.trace.fps.b.f
        public void a(JSONObject r17) {
            JSONObject r10 = r17;
            d r11 = c.b(this.f5865a);
            if (r11 != null) goto L5;
            return;
        L5:
            if (r10 != null) goto L7;
            return;
        L7:
            c r12 = this.f5865a;
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L33
            Iterator<String> r14 = r17.keys();     // Catch: Throwable -> L33
            double r15 = 0.0d;
            int r16 = 0;
            int r18 = 0;
            int r19 = 0;
            double r20 = 0.0d;
        L10:
            if (r14.hasNext() == false) goto L24;
            String r110 = r14.next();     // Catch: Throwable -> L31
            Intrinsics.checkNotNullExpressionValue(r110, "keyStr");     // Catch: Throwable -> L31
            int r111 = Integer.parseInt(r110);     // Catch: Throwable -> L31
            int r112 = r10.getInt(r110);     // Catch: Throwable -> L31
            if (r111 == 0) goto L13;
            if (r111 <= 0) goto L23;
            c r113 = r12;
            r15 = r15 + ((double) (r111 * r112));     // Catch: Throwable -> L31
            r20 = r20 + ((double) r112);     // Catch: Throwable -> L31
            if (r111 > 3) goto L20;
            r16 = r16 + r112;     // Catch: Throwable -> L31
        L18:
            r12 = r113;
            goto L23
        L20:
            if (r111 > 7) goto L22;
            r18 = r18 + r112;     // Catch: Throwable -> L31
            goto L18
        L22:
            r19 = r19 + r112;     // Catch: Throwable -> L31
        L23:
            r10 = r17;
            goto L10
        L13:
            r20 = r20 + ((double) r112);     // Catch: Throwable -> L31
        L31:
            th = th;
            r10 = r17;
        L34:
            Result.Companion r21 = Result.Companion;
            Object r22 = Result.m32constructorimpl(ResultKt.createFailure(th));
        L35:
            Throwable r23 = Result.m35exceptionOrNullimpl(r22);
            if (r23 == null) goto L49;
            e9.b.c("FPSSceneMonitor", "dropFrame: " + r10, r23);
            return;
        L49:
            return;
        L24:
            c r114 = r12;
            r11.m(g.f5882a.a(r15 / (r20 + r15)));     // Catch: Throwable -> L31
            r11.k(r16);     // Catch: Throwable -> L31
            r11.l(r18);     // Catch: Throwable -> L31
            r11.j(r19);     // Catch: Throwable -> L31
            StringBuilder r24 = new StringBuilder();     // Catch: Throwable -> L31
            r24.append("dropFrame: ");     // Catch: Throwable -> L31
            r10 = r17;
            r24.append(r10);     // Catch: Throwable -> L33
            e9.b.f("FPSSceneMonitor", r24.toString(), null, 4, null);     // Catch: Throwable -> L33
            e9.b.f("FPSSceneMonitor", "fpsCallBack: " + r11, null, 4, null);     // Catch: Throwable -> L33
            c9.g.f656l.a().s(c.c(r114), (float) r11.f(), com.obric.matrix.platform.sdk.ones.commonmonitor.fps.a.f5855a.b(r11));     // Catch: Throwable -> L33
            e r25 = c.a(r114);     // Catch: Throwable -> L33
            if (r25 == null) goto L29;
            r25.a(r11);     // Catch: Throwable -> L33
        L29:
            r11.g();     // Catch: Throwable -> L33
            c.d(r114, null);     // Catch: Throwable -> L33
            c.e(r114, 0);     // Catch: Throwable -> L33
            r22 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
        L33:
            th = th;
            goto L34
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.commonmonitor.fps.c$c, reason: collision with other inner class name */
    public static final class C0126c {
        private C0126c() {
        }

        public /* synthetic */ C0126c(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0126c(null);
    }

    public c(String r10, boolean r11, e r12) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        this.f5858a = r10;
        this.f5859b = r11;
        this.f5860c = r12;
        com.bytedance.apm.trace.fps.b r13 = new com.bytedance.apm.trace.fps.b(r10, r11);
        this.f5861d = r13;
        r13.L(new a(this));
        r13.J(new b(this));
    }

    public static final /* synthetic */ e a(c r10) {
        return r10.f5860c;
    }

    public static final /* synthetic */ d b(c r10) {
        return r10.f5862e;
    }

    public static final /* synthetic */ String c(c r10) {
        return r10.f5858a;
    }

    public static final /* synthetic */ void d(c r10, d r11) {
        r10.f5862e = r11;
    }

    public static final /* synthetic */ void e(c r10, long r11) {
        r10.f5863f = r11;
    }

    public final void f() {
        if (this.f5863f <= 0) goto L6;
        e9.b.k("FPSSceneMonitor", "start: already start", null, 4, null);
        return;
    L6:
        this.f5863f = SystemClock.elapsedRealtime();
        this.f5861d.M();
    }

    public final void g() {
        if (this.f5863f > 0) goto L6;
        e9.b.k("FPSSceneMonitor", "stop: not start", null, 4, null);
        return;
    L6:
        d r10 = d.f5866n.a();
        r10.n(SystemClock.elapsedRealtime() - this.f5863f);
        this.f5862e = r10;
        this.f5861d.Q();
        this.f5863f = 0;
    }
}
