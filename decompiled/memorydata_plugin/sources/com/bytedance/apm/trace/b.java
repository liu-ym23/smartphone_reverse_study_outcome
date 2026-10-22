package com.bytedance.apm.trace;

import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.data.pipeline.d;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.k;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f1439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1440b = false;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.b$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f1441a;

        @Override // java.lang.Runnable
        public void run() {
            if (k.a().c() == false) goto L6;
            LockMonitorManager.startLockDetect(this.f1441a);
            return;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1443b;
        private boolean c;
        private boolean d;

        /* JADX INFO: renamed from: com.bytedance.apm.trace.b$a$a, reason: collision with other inner class name */
        public static class C0093a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f1444a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f1445b;
            private boolean c;
            private boolean d;

            public C0093a() {
            }

            static /* synthetic */ boolean a(C0093a r0) {
                return r0.f1444a;
            }

            static /* synthetic */ boolean b(C0093a r0) {
                return r0.f1445b;
            }

            static /* synthetic */ boolean c(C0093a r0) {
                return r0.c;
            }

            static /* synthetic */ boolean d(C0093a r0) {
                return r0.d;
            }

            public a a() {
                return new a(this, null);
            }
        }

        private a(C0093a r2) {
            this.f1442a = C0093a.a(r2);
            this.f1443b = C0093a.b(r2);
            this.c = C0093a.c(r2);
            this.d = C0093a.d(r2);
        }

        /* synthetic */ a(C0093a r1, AnonymousClass1 r2) {
            this(r1);
        }

        public boolean a() {
            return this.f1443b;
        }

        public boolean b() {
            return this.c;
        }
    }

    static {
    }

    public static void a() {
        c r0 = new c("start_trace", "launch_stats");
        f1439a = r0;
        r0.b();
        if (com.bytedance.apm.b.g() == false) goto L8;
        boolean r1 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        f1440b = r1;
        if (r1 == false) goto L9;
        com.bytedance.apm.launch.evil.b.a();
        return;
    L9:
        return;
    }

    @Deprecated
    public static void a(int r1) {
        boolean r0 = true;
        if ((r1 & 1) != 0) goto L5;
    L8:
        d.a(r0);
        return;
    L5:
        if (com.bytedance.apm.launch.a.a().b().b() == true) goto L8;
        r0 = false;
        goto L8
    }

    public static void a(int r6, String r7, long r8) {
        a(r6, r7, r8, 0);
    }

    public static void a(int r8, String r9, long r10, long r12) {
        if (f1440b == false) goto L5;
        com.bytedance.apm.launch.evil.b.b();
    L5:
        c r1 = f1439a;
        if (r1 == null) goto L9;
        r1.a(r8, r9, r10, r12);
        return;
    }

    @Deprecated
    public static void a(long r0) {
        d.a(r0);
    }

    public static void a(String r1, String r2) {
        c r0 = f1439a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public static void b() {
        if (f1440b == false) goto L5;
        com.bytedance.apm.launch.evil.b.b();
    L5:
        c r0 = f1439a;
        if (r0 == null) goto L9;
        r0.c();
        f1439a = null;
        return;
    }

    public static void b(String r1, String r2) {
        c r0 = f1439a;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public static long c() {
        c r0 = f1439a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a();
    }
}
