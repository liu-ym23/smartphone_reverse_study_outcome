package td8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements c {
    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r1, xc8.b r2, xc8.b r3, List<xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return r4;
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }
}
