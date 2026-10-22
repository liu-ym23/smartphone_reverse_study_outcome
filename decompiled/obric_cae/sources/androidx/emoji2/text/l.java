package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class l extends f.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1786d = null;

    public static class a {
    }

    public static class b implements f.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g0.f f1788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f1789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f1790d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Handler f1791e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f1792f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f1793g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public f.h f1794h;

        public b(Context r8, g0.f r10) {
            a r11 = l.f1786d;
            this.f1790d = new Object();
            t2.b.n(r8, "Context cannot be null");
            this.f1787a = r8.getApplicationContext();
            this.f1788b = r10;
            this.f1789c = r11;
        }

        @Override // androidx.emoji2.text.f.g
        public final void a(f.h r8) {
            Object r10 = this.f1790d;
            monitor-enter(r10);
            this.f1794h = r8;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            c();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public final void b() {
            Object r8 = this.f1790d;
            monitor-enter(r8);
            this.f1794h = null;     // Catch: Throwable -> L14
            Handler r10 = this.f1791e;     // Catch: Throwable -> L14
            if (r10 == null) goto L8;
            r10.removeCallbacks(null);     // Catch: Throwable -> L14
        L8:
            this.f1791e = null;     // Catch: Throwable -> L14
            ThreadPoolExecutor r11 = this.f1793g;     // Catch: Throwable -> L14
            if (r11 == null) goto L11;
            r11.shutdown();     // Catch: Throwable -> L14
        L11:
            this.f1792f = null;     // Catch: Throwable -> L14
            this.f1793g = null;     // Catch: Throwable -> L14
            monitor-exit(r8);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public final void c() {
            Object r8 = this.f1790d;
            monitor-enter(r8);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f1794h != null) goto L9;
            monitor-exit(r8);     // Catch: Throwable -> L14
            return;
        L9:
            if (this.f1792f != null) goto L11;
            androidx.emoji2.text.a r10 = new androidx.emoji2.text.a("emojiCompat", 0);     // Catch: Throwable -> L14
            ThreadPoolExecutor r11 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r10);     // Catch: Throwable -> L14
            r11.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L14
            this.f1793g = r11;     // Catch: Throwable -> L14
            this.f1792f = r11;     // Catch: Throwable -> L14
        L11:
            this.f1792f.execute(new androidx.activity.k(this, 2));     // Catch: Throwable -> L14
            monitor-exit(r8);     // Catch: Throwable -> L14
        }

        public final g0.m d() {
            a r8 = this.f1789c;     // Catch: PackageManager.NameNotFoundException -> L15
            Context r10 = this.f1787a;     // Catch: PackageManager.NameNotFoundException -> L15
            g0.f r11 = this.f1788b;     // Catch: PackageManager.NameNotFoundException -> L15
            r8.getClass();     // Catch: PackageManager.NameNotFoundException -> L15
            g0.l r12 = g0.e.a(r10, r11);     // Catch: PackageManager.NameNotFoundException -> L15
            int r13 = r12.f7526a;
            if (r13 != 0) goto L14;
            g0.m[] r14 = r12.f7527b;
            if (r14 == null) goto L12;
            if (r14.length == 0) goto L12;
            return r14[0];
        L12:
            throw new RuntimeException("fetchFonts failed (empty result)");
        L14:
            throw new RuntimeException(android.aimedia.a.c("fetchFonts failed (", r13, ")"));
        L15:
            e = move-exception;
            throw new RuntimeException("provider not found", e);
        }
    }

    static {
        f1786d = new a();
    }

    public l(Context r8, g0.f r10) {
        super(new b(r8, r10));
    }
}
