package q61;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements b {
    public final cz.c a;
    public final Map<String, String> b;

    @Override // q61.b
    public final Map<String, String> getLogParams() {
        return this.b;
    }

    @Override // q61.b
    public final cz.c getScene() {
        return this.a;
    }

    public c(b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.c;
        this.b = r2.b;
    }
}
