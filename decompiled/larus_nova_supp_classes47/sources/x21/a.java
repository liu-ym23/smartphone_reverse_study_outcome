package x21;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a implements x21.e {
    public final String a;

    /* JADX INFO: renamed from: x21.a$a, reason: collision with other inner class name */
    public static final class C0342a extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public C0342a(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("AnchorJoinToLink");
            this.b = r2;
        }
    }

    public static final class b extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public b(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("AnchorLeaveToLink");
            this.b = r2;
        }
    }

    public static final class c extends a {
        public final x21.h b;
        public final c5 c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.c(d());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.c(this.c, null, 2);
        }

        public final x21.h d() {
            return this.b;
        }

        public c(x21.h r2, c5 r3) {
            Intrinsics.checkNotNullParameter(r2, "pkInfo");
            Intrinsics.checkNotNullParameter(r3, "message");
            super("BattleOpen");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public d(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PenalTimeUpToLink");
            this.b = r2;
        }
    }

    public static final class e extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public e(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PkStandardEndReqFailedToLink");
            this.b = r2;
        }
    }

    public static final class f extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public f(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PkStandardEndToLink");
            this.b = r2;
        }
    }

    public static final class g extends a {
        public final x21.g b;
        public final c3 c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C0343b(d());
        }

        public final c3 d() {
            return this.c;
        }

        public final x21.g e() {
            return this.b;
        }

        public g(x21.g r2, c3 r3) {
            Intrinsics.checkNotNullParameter(r2, "penalInfo");
            Intrinsics.checkNotNullParameter(r3, "meta");
            super("PkStandardEndToPenal");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class h extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public h(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PkTimeOutReqFailedToLink");
            this.b = r2;
        }
    }

    public static final class i extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public i(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PkTimeOutToLink");
            this.b = r2;
        }
    }

    public static final class j extends a {
        public final x21.g b;
        public final c3 c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C0343b(d());
        }

        public final c3 d() {
            return this.c;
        }

        public final x21.g e() {
            return this.b;
        }

        public j(x21.g r2, c3 r3) {
            Intrinsics.checkNotNullParameter(r2, "penalInfo");
            Intrinsics.checkNotNullParameter(r3, "meta");
            super("PkTimeOutToPenal");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class k extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public k(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("QueryFailedBackToLink");
            this.b = r2;
        }
    }

    public static final class l extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public l(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("QueryReturnLink");
            this.b = r2;
        }
    }

    public static final class m extends a {
        public final x21.g b;
        public final c3 c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C0343b(d());
        }

        public final c3 d() {
            return this.c;
        }

        public final x21.g e() {
            return this.b;
        }

        public m(x21.g r2, c3 r3) {
            Intrinsics.checkNotNullParameter(r2, "penalInfo");
            Intrinsics.checkNotNullParameter(r3, "meta");
            super("QueryReturnPenal");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class n extends a {
        public final x21.h b;
        public final c3 c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.c(d());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.c(null, this.c, 1);
        }

        public final x21.h d() {
            return this.b;
        }

        public n(x21.h r2, c3 r3) {
            Intrinsics.checkNotNullParameter(r2, "pkInfo");
            Intrinsics.checkNotNullParameter(r3, "meta");
            super("QueryReturnPk");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class o extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public o(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("SecKillReqFailedToLink");
            this.b = r2;
        }
    }

    public static final class p extends a implements x21.i {
        public final x21.f b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.b;
        }

        public p(x21.f r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("SecKillToLink");
            this.b = r2;
        }
    }

    public static final class q extends a {
        public final x21.g b;
        public final c3 c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C0343b(d());
        }

        public final c3 d() {
            return this.c;
        }

        public final x21.g e() {
            return this.b;
        }

        public q(x21.g r2, c3 r3) {
            Intrinsics.checkNotNullParameter(r2, "penalInfo");
            Intrinsics.checkNotNullParameter(r3, "meta");
            super("SecKillToPenal");
            this.b = r2;
            this.c = r3;
        }
    }

    public a(String r1) {
        this.a = r1;
    }
}
