package zib;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z5c.d0;
import z5c.e0;
import z5c.f0;
import z5c.g0;
import z5c.h0;
import z5c.n0;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static long a;
    public static long b;
    public static long c;
    public static boolean d;
    public static String e;

    public static final class a extends s5c.g {
        public static final a c = null;

        static {
            c = new a();
        }

        public a() {
            super("err_msg");
        }
    }

    /* JADX INFO: renamed from: zib.b$b, reason: collision with other inner class name */
    public static final class C0352b extends s5c.g {
        public static final C0352b c = null;

        static {
            c = new C0352b();
        }

        public C0352b() {
            super("is_single");
        }
    }

    public static final class c extends s5c.g {
        public static final c c = null;

        static {
            c = new c();
        }

        public c() {
            super("is_success");
        }
    }

    public static final class d extends s5c.g {
        public static final d c = null;

        static {
            c = new d();
        }

        public d() {
            super("log_extra");
        }
    }

    public static final class e extends s5c.g {
        public static final e c = null;

        static {
            c = new e();
        }

        public e() {
            super("refresh_interval");
        }
    }

    public static final class f extends s5c.g {
        public static final f c = null;

        static {
            c = new f();
        }

        public f() {
            super("source");
        }
    }

    public static final class g implements Runnable {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public static void a() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            s5c.a r1 = e.c.a(String.valueOf(b.c - b.b));     // Catch: Throwable -> L4
            s5c.a r2 = C0352b.c.a(String.valueOf(b.d));     // Catch: Throwable -> L4
            Statistics.sendEvent("forward_select_wrong", s5c.d.b.b(r1, f.c.a(b.e)).plus(r2).toJson());     // Catch: Throwable -> L4
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
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
    }

    public static final class h implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public h(boolean r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void a() {
            boolean r0 = this.a;
            long r1 = this.b;
            long r3 = this.c;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
            s5c.a r2 = e0.c.a(String.valueOf(r0));     // Catch: Throwable -> L5
            s5c.a r4 = h0.c.a(String.valueOf(r1));     // Catch: Throwable -> L5
            s5c.a r6 = d0.c.a(String.valueOf(r3));     // Catch: Throwable -> L5
            s5c.a r7 = f0.c.a("true");     // Catch: Throwable -> L5
            g0 r8 = g0.c;     // Catch: Throwable -> L5
            Log.i("FGUtils", "FG key: core.forward.common_data: " + com.ss.android.lark.forwardv3.utils.b.a("core.forward.common_data", false));     // Catch: Throwable -> L5
            Statistics.sendEvent("forward_data_time_profiler", s5c.d.b.b(r2, r4).plus(r6).plus(r7).plus(r8.a(String.valueOf(true))).toJson());     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
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
    }

    public static final class i implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public i(int r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            int r0 = this.a;
            String r1 = this.b;
            String r2 = this.c;
            String r3 = this.d;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
            s5c.a r5 = c.c.a("false");     // Catch: Throwable -> L12
            s5c.a r6 = n0.c.a(String.valueOf(r0));     // Catch: Throwable -> L12
            s5c.a r7 = z2.k.a(r1);     // Catch: Throwable -> L12
            a r8 = a.c;     // Catch: Throwable -> L12
            if (r2 != null) goto L7;
            r2 = "";
        L7:
            s5c.a r9 = r8.a(r2);     // Catch: Throwable -> L12
            d r10 = d.c;     // Catch: Throwable -> L12
            if (r3 != null) goto L10;
            r3 = "";
        L10:
            s5c.a r11 = r10.a(r3);     // Catch: Throwable -> L12
            Statistics.sendEvent("forward_send_result", s5c.d.b.b(r7, r5).plus(r6).plus(r11).plus(r9).toJson());     // Catch: Throwable -> L12
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
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
    }

    public b() {
    }

    static {
        d = true;
        e = "";
    }

    public static void b() {
        long r0 = a - c;
        if (1 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
    L13:
        Log.i("ForwardDataCostProfiler", "This operation is judged as normal.");
    L14:
        a = 0;
        b = 0;
        c = 0;
        return;
    L11:
        if ((System.currentTimeMillis() - a) >= 1000) goto L13;
        Log.i("ForwardDataCostProfiler", "This operation is judged as a wrong.");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(g.a);
        goto L14
    L5:
        if (r0 >= 300) goto L7;
        r1 = true;
        goto L9
    }

    public static void f() {
        Intrinsics.checkNotNullParameter(LocationHitPoint$ResultType.DEFAULT, "forwardScene");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new zib.d(LocationHitPoint$ResultType.DEFAULT));
    }

    public static void a(boolean r2, boolean r3) {
        a = System.currentTimeMillis();
        d = r2;
        if (r3 == false) goto L5;
        String r4 = "recent_forward";
    L6:
        e = r4;
        return;
    L5:
        r4 = "recent_visit";
        goto L6
    }

    public static void e(s5c.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "version");
        Intrinsics.checkNotNullParameter(r3, "scene");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new zib.c(r3, r2));
    }

    public static void c(boolean r8, long r9, long r11) {
        if (r8 == false) goto L4;
        b = System.currentTimeMillis();
    L5:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r8, r9, r11));
        return;
    L4:
        c = System.currentTimeMillis();
        goto L5
    }

    public static void d(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "forwardScene");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(r3, r2, r4, r5));
    }
}
