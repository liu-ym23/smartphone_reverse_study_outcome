package pe;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public interface e1 extends ae.f.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f10007f = 0;

    public static final class a {
        public static /* synthetic */ void a(e1 r8) {
            r8.H(null);
        }

        public static /* synthetic */ o0 b(e1 r8, boolean r10, i1 r11, int r12) {
            boolean r13 = false;
            if ((r12 & 1) == 0) goto L6;
            r10 = false;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r13 = true;
        L9:
            return r8.J(r10, r13, r11);
        }
    }

    public static final class b implements ae.f.c<e1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f10008a = null;

        static {
            f10008a = new b();
        }
    }

    boolean G();

    void H(CancellationException r8);

    o0 J(boolean r8, boolean r10, ge.l<? super Throwable, xd.j> r11);

    boolean a();

    e1 getParent();

    o0 i(ge.l<? super Throwable, xd.j> r8);

    CancellationException k();

    boolean start();

    k x(j1 r8);
}
