package io.reactivex.e;

import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.u;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final u f16703a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final u f16704b = null;
    static final u c = null;
    static final u d = null;
    static final u e = null;

    /* JADX INFO: renamed from: io.reactivex.e.a$a, reason: collision with other inner class name */
    static final class C0871a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final u f16705a = null;

        static {
            f16705a = new io.reactivex.internal.schedulers.a();
        }
    }

    static final class b implements Callable<u> {
        b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public u call() {
            return C0871a.f16705a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ u call() {
            return call();
        }
    }

    static final class c implements Callable<u> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public u call() {
            return d.f16706a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ u call() {
            return call();
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final u f16706a = null;

        static {
            f16706a = new io.reactivex.internal.schedulers.d();
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final u f16707a = null;

        static {
            f16707a = new io.reactivex.internal.schedulers.e();
        }
    }

    static final class f implements Callable<u> {
        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public u call() {
            return e.f16707a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ u call() {
            return call();
        }
    }

    static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final u f16708a = null;

        static {
            f16708a = new j();
        }
    }

    static final class h implements Callable<u> {
        h() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public u call() {
            return g.f16708a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ u call() {
            return call();
        }
    }

    static {
        f16703a = io.reactivex.d.a.d(new h());
        f16704b = io.reactivex.d.a.a(new b());
        c = io.reactivex.d.a.b(new c());
        d = k.c();
        e = io.reactivex.d.a.c(new f());
    }

    public static u a() {
        return io.reactivex.d.a.a(f16703a);
    }
}
