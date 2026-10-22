package c59;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    public final List<i> a;
    public final List<e0> b;

    public n() {
        this(null);
    }

    public n(Object r3) {
        ArrayList r4 = new ArrayList();
        ArrayList r0 = new ArrayList();
        Intrinsics.checkNotNullParameter(r4, "aboveTabCards");
        Intrinsics.checkNotNullParameter(r0, "tabs");
        this.a = r4;
        this.b = r0;
    }
}
