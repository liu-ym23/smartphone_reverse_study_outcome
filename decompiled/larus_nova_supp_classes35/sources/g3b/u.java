package g3b;

import com.ss.android.lark.widget.EllipsizeFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements com.ss.android.lark.biz.im.api.message.params.l {
    public final /* synthetic */ g3b.a a;
    public final /* synthetic */ f b;
    public final /* synthetic */ d c;
    public final /* synthetic */ s d;
    public final /* synthetic */ n e;
    public final /* synthetic */ p f;
    public final boolean g;
    public final CharSequence h;

    public static final class a implements h, j, i, m, k, l {
        public final /* synthetic */ b a;
        public final /* synthetic */ g b;
        public final /* synthetic */ e c;
        public final /* synthetic */ t d;
        public final /* synthetic */ o e;
        public final /* synthetic */ q f;
        public boolean g;
        public CharSequence h;

        @Override // g3b.m
        public final void g() {
            this.d.getClass();
        }

        @Override // g3b.m
        public final void h() {
            this.d.getClass();
        }

        @Override // g3b.i
        public final void i() {
            this.c.getClass();
        }

        public final void l() {
            this.b.a = true;
        }

        @Override // g3b.j
        public final boolean a() {
            return this.b.b;
        }

        @Override // g3b.l
        public final z9b.b b() {
            return this.f.a;
        }

        @Override // g3b.h
        public final boolean c() {
            return this.a.a;
        }

        @Override // g3b.k
        public final z9b.a d() {
            return this.e.a;
        }

        @Override // g3b.j
        public final EllipsizeFrameLayout.a e() {
            return this.b.c;
        }

        @Override // g3b.h
        public final boolean f() {
            return this.a.b;
        }

        @Override // g3b.h
        public final z9b.c j() {
            return this.a.c;
        }

        @Override // g3b.j
        public final boolean k() {
            return this.b.a;
        }

        public a() {
            this.a = new b();
            this.b = new g();
            this.c = new e();
            this.d = new t();
            this.e = new o();
            this.f = new q();
        }

        public final void m(EllipsizeFrameLayout.a r3) {
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            g r1 = this.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r1.c = r3;
        }
    }

    public u(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = new g3b.a(r2);
        this.b = new f(r2);
        this.c = new d(r2);
        this.d = new s(r2);
        this.e = new n(r2);
        this.f = new p(r2);
        this.g = r2.g;
        this.h = r2.h;
    }
}
