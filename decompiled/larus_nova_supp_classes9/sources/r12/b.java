package r12;

import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements wy0.f {
    public static final b a = null;

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

    public b() {
    }

    static {
        a = new b();
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.mapOf(TuplesKt.to("format.sendGift", a.a));
    }

    public final Map<String, h<Object, ?>> c(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.a(r2);
    }

    public final Map<String, g<?, ?>> d(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.emptyMap();
    }

    public final Map<String, g<Object, ?>> f(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.b(r2);
    }
}
