package zu0;

import com.bytedance.android.scope.o;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements wy0.f, o {
    public Disposable a;
    public final vy0.c b;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new g();
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
            return new zu0.c();
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
            return new f();
        }
    }

    public final void onStart() {
        this.a = this.b.O3(this);
    }

    public final void onStop() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L5:
        r0.dispose();
    }

    public e(vy0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridService");
        this.b = r2;
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("reportProfitCheckTaskData", a.a), TuplesKt.to("getProfitReportConfig", b.a), TuplesKt.to("live.reenterRoom", c.a)});
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
