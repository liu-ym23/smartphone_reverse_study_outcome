package com.bytedance.apm;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet<String> f997b;

    class a implements z3.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f998a;

        a(k r10) {
            this.f998a = r10;
        }

        @Override // z3.c.a
        public void a(Throwable r10, String r11) {
            if (k.a(this.f998a) == null) goto L6;
            k.a(this.f998a).a(r10, r11);
            return;
        }
    }

    public interface b {
        void a(Throwable r10, String r11);

        void ensureNotReachHere(String r10);

        void ensureNotReachHere(Throwable r10, String r11);
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f999a = null;

        static {
            f999a = new k(null);
        }

        static /* synthetic */ k a() {
            return f999a;
        }
    }

    private k() {
        this.f997b = new HashSet();
    }

    /* synthetic */ k(a r10) {
        this();
    }

    static /* synthetic */ b a(k r10) {
        return r10.f996a;
    }

    public static k e() {
        return c.a();
    }

    private void g() {
        z3.b.a().c(new a(this));
    }

    public void b(Throwable r10, String r11) {
        b r12 = this.f996a;     // Catch: Throwable -> L12
        if (r12 == null) goto L6;
        r12.a(r10, r11);     // Catch: Throwable -> L12
    L6:
        if (d.D() == true) goto L11;
        if (d.H() == true) goto L11;
        return;
    L11:
        throw new RuntimeException(r10);
    }

    public void c(String r10) {
        if (this.f996a == null) goto L8;
        if (this.f997b.contains(r10) == true) goto L8;
        this.f997b.add(r10);
        this.f996a.ensureNotReachHere("apm_" + r10);
    L8:
        if (d.D() == false) goto L11;
        Log.e("apm_", "ensureNotReachHere", new RuntimeException(r10));
        System.exit(1);
        return;
    }

    public void d(Throwable r10, String r11) {
        if (this.f996a == null) goto L8;
        if (this.f997b.contains(r11) == true) goto L8;
        this.f997b.add(r11);
        this.f996a.ensureNotReachHere(r10, "apm_" + r11);
    L8:
        if (d.D() == false) goto L11;
        r10.printStackTrace();
        return;
    }

    public void f(b r10) {
        this.f996a = r10;
        g();
    }
}
