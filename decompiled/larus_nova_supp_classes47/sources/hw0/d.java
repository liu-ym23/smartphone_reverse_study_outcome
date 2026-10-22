package hw0;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements wy0.f {
    public static final d a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e();
        }
    }

    public d() {
    }

    static {
        a = new d();
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.mapOf(TuplesKt.to("getMemAutoExchangeStatus", a.a));
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
