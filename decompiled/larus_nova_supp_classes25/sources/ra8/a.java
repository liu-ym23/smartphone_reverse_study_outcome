package ra8;

import android.content.Context;
import java.util.List;
import kc8.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static c b() {
        pd6.b r0 = c.a;
        c r1 = c.a(Reflection.getOrCreateKotlinClass(c.class));
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("BlockKit implementation is not installed".toString());
    }

    public static hk9.a a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return b().u2(r1);
    }

    public static void c(hk9.a r1) {
        Intrinsics.checkNotNullParameter(r1, "container");
        b().w(r1);
    }

    public static void e(hk9.a r1, List r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r2, "models");
        b().y0(r1, r2, r3);
    }

    public static void d(hk9.a r1, List r2, f r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r2, "blocks");
        Intrinsics.checkNotNullParameter(r3, "config");
        b().l0(r1, r2, r3, r4);
    }
}
