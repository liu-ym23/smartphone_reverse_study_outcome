package uy1;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements wy0.f {
    public final /* synthetic */ g a;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new sy1.a(this.a.a.b);
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
            return new sy1.b();
        }
    }

    public f(g r1) {
        this.a = r1;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("changeGroupLiveContainerStatus", new a(this)), TuplesKt.to("revenue.hybridHidden", b.a)});
    }

    public final Map<String, wy0.h<Object, ?>> c(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.a(r2);
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> d(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.emptyMap();
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.b(r2);
    }
}
