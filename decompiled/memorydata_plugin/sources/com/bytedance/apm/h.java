package com.bytedance.apm;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f1320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet<String> f1321b;

    /* JADX INFO: renamed from: com.bytedance.apm.h$1, reason: invalid class name */
    class AnonymousClass1 implements com.bytedance.monitor.util.thread.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f1322a;

        @Override // com.bytedance.monitor.util.thread.c.a
        public void a(Throwable r2, String r3) {
            if (h.a(this.f1322a) == null) goto L6;
            h.a(this.f1322a).b(r2, r3);
            return;
        }
    }

    public interface a {
        void a(String r1);

        void a(Throwable r1, String r2);

        void b(Throwable r1, String r2);
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f1323a = null;

        static {
            f1323a = new h(null);
        }

        static /* synthetic */ h a() {
            return f1323a;
        }
    }

    private h() {
        this.f1321b = new HashSet();
    }

    /* synthetic */ h(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ a a(h r0) {
        return r0.f1320a;
    }

    public static h a() {
        return b.a();
    }

    public void a(String r3) {
        if (this.f1320a == null) goto L8;
        if (this.f1321b.contains(r3) == true) goto L8;
        this.f1321b.add(r3);
        this.f1320a.a("apm_" + r3);
    L8:
        if (com.bytedance.apm.b.k() == false) goto L11;
        Log.e("apm_", "ensureNotReachHere", new RuntimeException(r3));
        System.exit(1);
        return;
    }

    public void a(Throwable r3, String r4) {
        if (this.f1320a == null) goto L8;
        if (this.f1321b.contains(r4) == true) goto L8;
        this.f1321b.add(r4);
        this.f1320a.a(r3, "apm_" + r4);
    L8:
        if (com.bytedance.apm.b.k() == false) goto L11;
        r3.printStackTrace();
        return;
    }

    public void b(Throwable r1, String r2) {
        a r0 = this.f1320a;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        r0.b(r1, r2);     // Catch: Throwable -> L12
    L6:
        if (com.bytedance.apm.b.k() == true) goto L11;
        if (com.bytedance.apm.b.n() == true) goto L11;
        return;
    L11:
        throw new RuntimeException(r1);
    }
}
