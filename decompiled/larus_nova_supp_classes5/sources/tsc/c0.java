package tsc;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kw8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c0 extends io.noties.markwon.html.tag.n {
    public final Map<String, a> a;
    public final boolean b;

    public c0(Map<String, a> r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // io.noties.markwon.html.tag.n, tsc.a0
    public final void a(lsc.m r2, v r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        Intrinsics.checkNotNullParameter(r3, "renderer");
        Intrinsics.checkNotNullParameter(r4, "tag");
        super.a(r2, r3, r4);
        int r5 = b.a;
        Object[] r6 = b.a(r4, this.a, this.b);
        lsc.y.f(r2.builder(), r6, r4.start(), r4.end());
    }
}
