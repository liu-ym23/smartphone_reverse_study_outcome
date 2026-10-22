package wu0;

import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.f;
import wy0.h;
import y6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements f {
    public static final b a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wu0.a();
        }
    }

    public b() {
    }

    static {
        a = new b();
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.mapOf(TuplesKt.to("live.update_fansclub_info", a.a));
    }

    @Override // wy0.d
    public final Map<String, h<Object, ?>> c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return f.a.a(r2);
    }

    @Override // wy0.f
    public final Map<String, g<?, ?>> d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, g<Object, ?>> f(c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return f.a.b(r2);
    }
}
