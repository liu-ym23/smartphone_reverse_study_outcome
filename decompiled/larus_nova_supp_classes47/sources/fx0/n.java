package fx0;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements wy0.f {
    public static final n a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fx0.b();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p();
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fx0.f();
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new j();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fx0.a();
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ta0.b();
        }
    }

    public n() {
    }

    static {
        a = new n();
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("showIncomeExchangeDialog", a.a), TuplesKt.to("updateWalletInfo", b.a), TuplesKt.to("openCJCounter", c.a), TuplesKt.to("openRechargeWhenSwitchScreen", d.a), TuplesKt.to("openLiveRecharge", e.a), TuplesKt.to("dismissRechargeDialog", f.a), TuplesKt.to("revenue.notifyIncomeExchangeResult", g.a)});
    }

    @Override // wy0.d
    public final Map<String, wy0.h<Object, ?>> c(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.a(r2);
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> d(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.b(r2);
    }
}
