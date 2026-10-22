package ka;

import ha.c0;
import ha.d0;
import ha.w;

/* JADX INFO: loaded from: classes.dex */
public final class p<T> extends o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w<T> f9038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ha.o<T> f9039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ha.j f9040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oa.a<T> f9041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d0 f9042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p<T>.a f9043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile c0<T> f9045h;

    public final class a implements ha.v, ha.n {
    }

    public static final class b implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oa.a<?> f9046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9047b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Class<?> f9048m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final w<?> f9049n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final ha.o<?> f9050o;

        public b(Object r8, Class r10) {
            if ((r8 instanceof w) == false) goto L5;
            w<?> r11 = (w) r8;
        L6:
            this.f9049n = r11;
            if ((r8 instanceof ha.o) == false) goto L9;
            ha.o<?> r12 = (ha.o) r8;
        L10:
            this.f9050o = r12;
            if (r11 != null) goto L15;
            if (r12 != null) goto L15;
            boolean r13 = false;
        L16:
            l6.a.t(r13);
            this.f9046a = null;
            this.f9047b = false;
            this.f9048m = r10;
            return;
        L15:
            r13 = true;
            goto L16
        L9:
            r12 = null;
            goto L10
        L5:
            r11 = null;
            goto L6
        }

        @Override // ha.d0
        public final <T> c0<T> a(ha.j r10, oa.a<T> r11) {
            oa.a<?> r8 = this.f9046a;
            if (r8 != null) goto L5;
            boolean r12 = this.f9048m.isAssignableFrom(r11.getRawType());
        L14:
            if (r12 == true) goto L18;
            return null;
        L18:
            return new p(this.f9049n, this.f9050o, r10, r11, this, true);
        L5:
            if (r8.equals(r11) == false) goto L7;
        L12:
            r12 = true;
            goto L14
        L7:
            if (this.f9047b == true) goto L9;
        L11:
            r12 = false;
            goto L14
        L9:
            if (r8.getType() != r11.getRawType()) goto L11;
            goto L11
        }
    }

    public p(w<T> r8, ha.o<T> r10, ha.j r11, oa.a<T> r12, d0 r13, boolean r14) {
        this.f9043f = new a();
        this.f9038a = r8;
        this.f9039b = r10;
        this.f9040c = r11;
        this.f9041d = r12;
        this.f9042e = r13;
        this.f9044g = r14;
    }

    @Override // ha.c0
    public final T a(pa.a r8) {
        ha.o<T> r10 = this.f9039b;
        if (r10 == null) goto L5;
        ha.p r11 = l6.a.x0(r8);
        if (this.f9044g == false) goto L13;
        r11.getClass();
        if ((r11 instanceof ha.r) == false) goto L13;
        return null;
    L13:
        return r10.deserialize(r11, this.f9041d.getType(), this.f9043f);
    L5:
        return d().a(r8);
    }

    @Override // ha.c0
    public final void b(pa.c r8, T r10) {
        w<T> r11 = this.f9038a;
        if (r11 != null) goto L7;
        d().b(r8, r10);
        return;
    L7:
        if (this.f9044g == false) goto L11;
        if (r10 != null) goto L11;
        r8.z();
        return;
    L11:
        ha.p r12 = r11.serialize(r10, this.f9041d.getType(), this.f9043f);
        r.f9079z.b(r8, r12);
    }

    @Override // ka.o
    public final c0<T> c() {
        if (this.f9038a == null) goto L6;
        return this;
    L6:
        return d();
    }

    public final c0<T> d() {
        c0<T> r8 = this.f9045h;
        if (r8 != null) goto L7;
        c0<T> r10 = this.f9040c.g(this.f9042e, this.f9041d);
        this.f9045h = r10;
        return r10;
    L7:
        return r8;
    }
}
