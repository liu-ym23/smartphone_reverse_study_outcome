package ae;

import he.i;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends f.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f351c = 0;

    public static final class a {
        public static <E extends f.b> E a(e r8, f.c<E> r10) {
            i.f(r10, "key");
            if ((r10 instanceof ae.b) == false) goto L10;
            ae.b r11 = (ae.b) r10;
            if (r11.a(r8.getKey()) == false) goto L15;
            E r12 = (E) r11.b(r8);
            if ((r12 instanceof f.b) == true) goto L9;
            return null;
        L9:
            return r12;
        L15:
            return null;
        L10:
            int r13 = e.f351c;
            if (b.f352a != r10) goto L14;
            i.d(r8, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return r8;
        L14:
            return null;
        }

        public static f b(e r8, f.c<?> r10) {
            i.f(r10, "key");
            boolean r11 = r10 instanceof ae.b;
            g r12 = g.f354a;
            if (r11 == false) goto L10;
            ae.b r13 = (ae.b) r10;
            if (r13.a(r8.getKey()) == true) goto L7;
            return r8;
        L7:
            if (r13.b(r8) != null) goto L9;
            return r8;
        L9:
            return r12;
        L10:
            int r14 = e.f351c;
            if (b.f352a == r10) goto L13;
            return r8;
        L13:
            return r12;
        }
    }

    public static final class b implements f.c<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f352a = null;

        static {
            f352a = new b();
        }
    }

    ue.g f0(d r8);

    void z(d<?> r8);
}
