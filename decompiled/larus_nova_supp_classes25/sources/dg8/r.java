package dg8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r extends lsc.a {
    public r() {
    }

    public final String b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "markdown");
        return s.b.replace(r3, " - ");
    }
}
