package j01;

import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.live.revenue.platform.trace.api.TraceDSLMaker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@TraceDSLMaker
public final class e {
    public final o97.a a;

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a.h = r2;
    }

    public final void b(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "index");
        this.a.l = r2;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a.d = r2;
    }

    public final void d(ProductId r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        o97.a r0 = this.a;
        r0.e = r2.getString();
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a.g = r2;
    }

    public final void f(int r2) {
        o97.a r0 = this.a;
        r0.j = Integer.valueOf(r2);
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "step");
        this.a.f = r2;
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a.c = r2;
    }

    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a.i = r2;
    }

    public e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "businessType");
        this.a = new o97.a(r2, r3);
    }
}
