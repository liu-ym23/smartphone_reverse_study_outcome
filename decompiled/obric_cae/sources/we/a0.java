package we;

import java.io.Closeable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f13114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f13115b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f13116m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f13117n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final p f13118o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q f13119p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final c0 f13120q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final a0 f13121r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final a0 f13122s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public final a0 f13123t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f13124u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f13125v;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public y f13126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public w f13127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public p f13130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public q.a f13131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public c0 f13132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public a0 f13133h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public a0 f13134i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public a0 f13135j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f13136k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f13137l;

        public a() {
            this.f13128c = -1;
            this.f13131f = new q.a();
        }

        public static void c(String r8, a0 r10) {
            if (r10.f13120q != null) goto L18;
            if (r10.f13121r != null) goto L16;
            if (r10.f13122s != null) goto L14;
            if (r10.f13123t != null) goto L12;
            return;
        L12:
            throw new IllegalArgumentException(r8.concat(".priorResponse != null"));
        L14:
            throw new IllegalArgumentException(r8.concat(".cacheResponse != null"));
        L16:
            throw new IllegalArgumentException(r8.concat(".networkResponse != null"));
        L18:
            throw new IllegalArgumentException(r8.concat(".body != null"));
        }

        public final void a(@Nullable c0 r8) {
            this.f13132g = r8;
        }

        public final a0 b() {
            if (this.f13126a == null) goto L19;
            if (this.f13127b == null) goto L17;
            if (this.f13128c < 0) goto L15;
            if (this.f13129d == null) goto L13;
            return new a0(this);
        L13:
            throw new IllegalStateException("message == null");
        L15:
            throw new IllegalStateException("code < 0: " + this.f13128c);
        L17:
            throw new IllegalStateException("protocol == null");
        L19:
            throw new IllegalStateException("request == null");
        }

        public final void d(@Nullable p r8) {
            this.f13130e = r8;
        }

        public final void e(long r8) {
            this.f13137l = r8;
        }

        public final void f(y r8) {
            this.f13126a = r8;
        }

        public final void g(long r8) {
            this.f13136k = r8;
        }

        public a(a0 r8) {
            this.f13128c = -1;
            this.f13126a = r8.f13114a;
            this.f13127b = r8.f13115b;
            this.f13128c = r8.f13116m;
            this.f13129d = r8.f13117n;
            this.f13130e = r8.f13118o;
            this.f13131f = r8.f13119p.g();
            this.f13132g = r8.f13120q;
            this.f13133h = r8.f13121r;
            this.f13134i = r8.f13122s;
            this.f13135j = r8.f13123t;
            this.f13136k = r8.f13124u;
            this.f13137l = r8.f13125v;
        }
    }

    public a0(a r8) {
        this.f13114a = r8.f13126a;
        this.f13115b = r8.f13127b;
        this.f13116m = r8.f13128c;
        this.f13117n = r8.f13129d;
        this.f13118o = r8.f13130e;
        q.a r10 = r8.f13131f;
        r10.getClass();
        this.f13119p = new q(r10);
        this.f13120q = r8.f13132g;
        this.f13121r = r8.f13133h;
        this.f13122s = r8.f13134i;
        this.f13123t = r8.f13135j;
        this.f13124u = r8.f13136k;
        this.f13125v = r8.f13137l;
    }

    @Nullable
    public final c0 a() {
        return this.f13120q;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c0 r8 = this.f13120q;
        if (r8 == null) goto L7;
        r8.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public final int i() {
        return this.f13116m;
    }

    @Nullable
    public final String k() {
        return n("Connection");
    }

    @Nullable
    public final String n(String r8) {
        String r10 = this.f13119p.d(r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10;
    }

    public final boolean r() {
        int r8 = this.f13116m;
        if (r8 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r8 >= 300) goto L7;
        return true;
    }

    public final String toString() {
        return "Response{protocol=" + this.f13115b + ", code=" + this.f13116m + ", message=" + this.f13117n + ", url=" + this.f13114a.f13337a + '}';
    }

    public final a v() {
        return new a(this);
    }

    public final y w() {
        return this.f13114a;
    }
}
