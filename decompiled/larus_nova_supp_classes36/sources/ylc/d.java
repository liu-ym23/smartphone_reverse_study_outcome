package ylc;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final int a;
    public final Set<String> b;

    public /* synthetic */ d() {
        this(20, SetsKt.emptySet());
    }

    public d(int r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "heartbeatKeyWhiteList");
        this.a = r2;
        this.b = r3;
    }
}
