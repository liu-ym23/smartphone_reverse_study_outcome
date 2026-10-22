package pe;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w0 extends w implements Closeable {

    public static final class a extends ae.b<w, w0> {

        /* JADX INFO: renamed from: pe.w0$a$a, reason: collision with other inner class name */
        public static final class C0137a extends he.j implements ge.l<ae.f.b, w0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0137a f10082a = null;

            static {
                f10082a = new C0137a();
            }

            public C0137a() {
                super(1);
            }

            @Override // ge.l
            public final w0 invoke(ae.f.b r8) {
                ae.f.b r10 = r8;
                if ((r10 instanceof w0) == true) goto L7;
                return null;
            L7:
                return (w0) r10;
            }
        }

        public a() {
            super(w.f10080b, C0137a.f10082a);
        }
    }

    static {
        new a();
    }

    public w0() {
    }
}
