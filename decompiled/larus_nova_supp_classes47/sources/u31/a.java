package u31;

import b30.o;
import b30.p;
import b30.q;
import kc0.g;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements g {
    public a() {
    }

    public final void c() {
        Intrinsics.checkNotNullParameter("", "source");
        o r0 = new o("");
        b.a().post(r0);
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pos");
        q r0 = new q(r2);
        b.a().post(r0);
    }

    public final void d(boolean r2) {
        b30.g r3 = new b30.g(true);
        b.a().post(r3);
    }

    public final void b(int r2, int r3) {
        p r0 = new p(r2, r3);
        b.a().post(r0);
    }
}
