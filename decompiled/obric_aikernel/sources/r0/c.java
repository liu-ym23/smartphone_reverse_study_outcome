package r0;

import androidx.annotation.RequiresApi;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f12517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12518b = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12520b;

        /* JADX INFO: renamed from: r0.c$a$a, reason: collision with other inner class name */
        public static class C0286a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f12521a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f12522b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f12523c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f12524d;

            public C0286a() {
            }

            static /* synthetic */ boolean a(C0286a r10) {
                return r10.f12521a;
            }

            static /* synthetic */ boolean b(C0286a r10) {
                return r10.f12522b;
            }

            static /* synthetic */ boolean c(C0286a r10) {
                return r10.f12523c;
            }

            static /* synthetic */ boolean d(C0286a r10) {
                return r10.f12524d;
            }

            public a e() {
                return new a(this, null);
            }
        }

        private a(C0286a r10) {
            C0286a.a(r10);
            this.f12519a = C0286a.b(r10);
            this.f12520b = C0286a.c(r10);
            C0286a.d(r10);
        }

        /* synthetic */ a(C0286a r10, b r11) {
            this(r10);
        }

        public boolean a() {
            return this.f12520b;
        }

        public boolean b() {
            return this.f12519a;
        }
    }

    static {
    }

    public static void a() {
        if (f12518b == false) goto L5;
        com.bytedance.apm.launch.evil.b.c();
    L5:
        e r10 = f12517a;
        if (r10 == null) goto L9;
        r10.d();
        f12517a = null;
        return;
    }

    public static void b(String r10, String r11) {
        e r12 = f12517a;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void c(int r10, String r11, long r12) {
        d(r10, r11, r12, 0);
    }

    public static void d(int r10, String r11, long r12, long r13) {
        if (f12518b == false) goto L5;
        com.bytedance.apm.launch.evil.b.c();
    L5:
        e r14 = f12517a;
        if (r14 == null) goto L9;
        r14.f(r10, r11, r12, r13);
        return;
    }

    public static long e() {
        e r10 = f12517a;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.h();
    }

    @Deprecated
    public static void f(int r10) {
        boolean r11 = true;
        if ((r10 & 1) != 0) goto L5;
    L8:
        x.d.I(r11);
        return;
    L5:
        if (c0.a.b().a().c() == true) goto L8;
        r11 = false;
        goto L8
    }

    @Deprecated
    public static void g(long r10) {
        x.d.J(r10);
    }

    public static void h(String r10, String r11) {
        e r12 = f12517a;
        if (r12 == null) goto L6;
        r12.l(r10, r11);
        return;
    }

    @RequiresApi(api = 18)
    public static void i() {
        e r10 = new e("start_trace", "launch_stats");
        f12517a = r10;
        r10.n();
        if (com.bytedance.apm.d.J() == false) goto L8;
        boolean r11 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        f12518b = r11;
        if (r11 == false) goto L9;
        com.bytedance.apm.launch.evil.b.b();
        return;
    L9:
        return;
    }
}
