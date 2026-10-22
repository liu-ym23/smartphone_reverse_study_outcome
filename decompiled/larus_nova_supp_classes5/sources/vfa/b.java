package vfa;

import com.larus.applog.api.IApplog;
import com.larus.im.f;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements f.a {
    public b() {
    }

    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        c.a.set(r6);
        IApplog.a.b("obric_frontier_require", com.larus.utils.f.c(new Pair[]{TuplesKt.to("action", "connect"), TuplesKt.to("reason", r6)}));
    }

    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        AtomicReference<String> r1 = c.a;
        c.a.set(r6);
        IApplog.a.b("obric_frontier_require", com.larus.utils.f.c(new Pair[]{TuplesKt.to("action", "disconnect"), TuplesKt.to("reason", r6)}));
    }
}
