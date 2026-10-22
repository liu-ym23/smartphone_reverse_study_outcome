package ue;

import pe.t1;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b9.a f12627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12628b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12629c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f12630d = null;

    public static final class a extends he.j implements ge.p<Object, ae.f.b, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12631a = null;

        static {
            f12631a = new a();
        }

        public a() {
            super(2);
        }

        @Override // ge.p
        public final Object invoke(Object r8, ae.f.b r10) {
            ae.f.b r11 = r10;
            if ((r11 instanceof t1) == true) goto L5;
            return r8;
        L5:
            if ((r8 instanceof Integer) == false) goto L7;
            Integer r12 = (Integer) r8;
        L9:
            if (r12 == null) goto L11;
            int r13 = r12.intValue();
        L12:
            if (r13 != 0) goto L15;
            return r11;
        L15:
            return Integer.valueOf(r13 + 1);
        L11:
            r13 = 1;
            goto L12
        L7:
            r12 = null;
            goto L9
        }
    }

    public static final class b extends he.j implements ge.p<t1<?>, ae.f.b, t1<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12632a = null;

        static {
            f12632a = new b();
        }

        public b() {
            super(2);
        }

        @Override // ge.p
        public final t1<?> invoke(t1<?> r8, ae.f.b r10) {
            t1<?> r11 = r8;
            ae.f.b r12 = r10;
            if (r11 == null) goto L6;
            return r11;
        L6:
            if ((r12 instanceof t1) == false) goto L9;
            return (t1) r12;
        L9:
            return null;
        }
    }

    public static final class c extends he.j implements ge.p<z, ae.f.b, z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12633a = null;

        static {
            f12633a = new c();
        }

        public c() {
            super(2);
        }

        @Override // ge.p
        public final z invoke(z r8, ae.f.b r10) {
            z r11 = r8;
            ae.f.b r12 = r10;
            if ((r12 instanceof t1) == false) goto L5;
            t1<Object> r13 = (t1) r12;
            String r14 = r13.m0(r11.f12636a);
            int r15 = r11.f12639d;
            r11.f12637b[r15] = r14;
            r11.f12639d = r15 + 1;
            r11.f12638c[r15] = r13;
        L5:
            return r11;
        }
    }

    static {
        f12627a = new b9.a("NO_THREAD_ELEMENTS", 4);
        f12628b = a.f12631a;
        f12629c = b.f12632a;
        f12630d = c.f12633a;
    }

    public static final void a(ae.f r8, Object r10) {
        if (r10 != f12627a) goto L6;
        return;
    L6:
        if ((r10 instanceof z) == false) goto L13;
        z r11 = (z) r10;
        t1<Object>[] r12 = r11.f12638c;
        int r13 = r12.length - 1;
        if (r13 < 0) goto L16;
    L9:
        int r14 = r13 - 1;
        t1<Object> r15 = r12[r13];
        he.i.c(r15);
        r15.D(r11.f12637b[r13]);
        if (r14 < 0) goto L17;
        r13 = r14;
        goto L9
    L17:
        return;
    L16:
        return;
    L13:
        Object r16 = r8.B(null, f12629c);
        he.i.d(r16, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((t1) r16).D(r10);
    }

    public static final Object b(ae.f r8, Object r10) {
        if (r10 != null) goto L5;
        r10 = r8.B(0, f12628b);
        he.i.c(r10);
    L5:
        if (r10 != 0) goto L8;
        return f12627a;
    L8:
        if ((r10 instanceof Integer) == false) goto L11;
        return r8.B(new z(r8, ((Number) r10).intValue()), f12630d);
    L11:
        return ((t1) r10).m0(r8);
    }
}
