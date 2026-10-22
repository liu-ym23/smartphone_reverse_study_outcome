package ec;

import io.reactivex.internal.schedulers.i;
import java.util.concurrent.Callable;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final p f8764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final p f8765b = null;

    /* JADX INFO: renamed from: ec.a$a, reason: collision with other inner class name */
    static final class C0164a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f8766a = null;

        static {
            f8766a = new io.reactivex.internal.schedulers.a();
        }
    }

    static final class b implements Callable<p> {
        b() {
        }

        public p a() {
            return C0164a.f8766a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ p call() {
            return a();
        }
    }

    static final class c implements Callable<p> {
        c() {
        }

        public p a() {
            return d.f8767a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ p call() {
            return a();
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f8767a = null;

        static {
            f8767a = new io.reactivex.internal.schedulers.c();
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f8768a = null;

        static {
            f8768a = new io.reactivex.internal.schedulers.d();
        }
    }

    static final class f implements Callable<p> {
        f() {
        }

        public p a() {
            return e.f8768a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ p call() {
            return a();
        }
    }

    static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f8769a = null;

        static {
            f8769a = new io.reactivex.internal.schedulers.h();
        }
    }

    static final class h implements Callable<p> {
        h() {
        }

        public p a() {
            return g.f8769a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ p call() {
            return a();
        }
    }

    static {
        dc.a.h(new h());
        f8764a = dc.a.e(new b());
        f8765b = dc.a.f(new c());
        i.f();
        dc.a.g(new f());
    }

    public static p a() {
        return dc.a.m(f8764a);
    }

    public static p b() {
        return dc.a.o(f8765b);
    }
}
