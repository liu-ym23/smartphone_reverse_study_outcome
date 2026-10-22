package ae;

import ge.p;
import he.i;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public static final class a {

        /* JADX INFO: renamed from: ae.f$a$a, reason: collision with other inner class name */
        public static final class C0003a extends j implements p<f, b, f> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0003a f353a = null;

            static {
                f353a = new C0003a();
            }

            public C0003a() {
                super(2);
            }

            @Override // ge.p
            public final f invoke(f r8, b r10) {
                f r11 = r8;
                b r12 = r10;
                i.f(r11, "acc");
                i.f(r12, "element");
                f r13 = r11.h0(r12.getKey());
                g r14 = g.f354a;
                if (r13 == r14) goto L15;
                int r15 = e.f351c;
                e.b r16 = e.b.f352a;
                e r17 = (e) r13.q0(r16);
                if (r17 != null) goto L9;
                ae.c r18 = new ae.c(r12, r13);
            L13:
                return r18;
            L9:
                f r19 = r13.h0(r16);
                if (r19 == r14) goto L14;
                r18 = new ae.c(r17, new ae.c(r12, r19));
                goto L13
            L14:
                return new ae.c(r17, r12);
            L15:
                return r12;
            }
        }

        public static f a(f r8, f r10) {
            i.f(r10, "context");
            if (r10 != g.f354a) goto L6;
            return r8;
        L6:
            return (f) r10.B(r8, C0003a.f353a);
        }
    }

    public interface b extends f {

        public static final class a {
            public static <R> R a(b r8, R r10, p<? super R, ? super b, ? extends R> r11) {
                i.f(r11, "operation");
                return r11.invoke(r10, r8);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b r8, c<E> r10) {
                i.f(r10, "key");
                if (i.a(r8.getKey(), r10) == true) goto L7;
                return null;
            L7:
                return r8;
            }

            public static f c(b r8, c<?> r10) {
                i.f(r10, "key");
                if (i.a(r8.getKey(), r10) == true) goto L5;
                return r8;
            L5:
                return g.f354a;
            }

            public static f d(b r8, f r10) {
                i.f(r10, "context");
                return a.a(r8, r10);
            }
        }

        c<?> getKey();
    }

    public interface c<E extends b> {
    }

    <R> R B(R r8, p<? super R, ? super b, ? extends R> r10);

    f C(f r8);

    f h0(c<?> r8);

    <E extends b> E q0(c<E> r8);
}
