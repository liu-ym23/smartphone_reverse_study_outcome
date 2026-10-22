package tsc;

import java.util.Collection;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kw8.a;
import lsc.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class z extends io.noties.markwon.html.tag.i {
    public final Map<String, a> a;
    public final boolean b;

    @Override // tsc.a0
    public final Collection c() {
        return CollectionsKt.listOf("span");
    }

    public z(Map<String, a> r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r2, t r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "renderProps");
        Intrinsics.checkNotNullParameter(r4, "tag");
        int r5 = b.a;
        return b.a(r4, this.a, this.b);
    }
}
