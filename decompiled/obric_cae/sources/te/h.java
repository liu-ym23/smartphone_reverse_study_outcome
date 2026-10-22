package te;

import ge.q;
import he.r;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<se.d<Object>, Object, ae.d<? super j>, Object> f12399a = null;

    public /* synthetic */ class a extends he.h implements q<se.d<? super Object>, Object, ae.d<? super j>, Object> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f12400s = null;

        static {
            f12400s = new a();
        }

        public a() {
            super(3, se.d.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // ge.q
        public final Object invoke(se.d<? super Object> r8, Object r10, ae.d<? super j> r11) {
            return r8.e(r10, r11);
        }
    }

    static {
        a r8 = a.f12400s;
        r.a(3, r8);
        f12399a = r8;
    }
}
