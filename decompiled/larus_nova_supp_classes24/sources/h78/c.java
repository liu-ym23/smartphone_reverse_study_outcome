package h78;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements b {
    public final List<String> a;

    public c(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "codes");
        this.a = r2;
    }

    @Override // h78.b
    public final boolean a(String r2) {
        if (this.a.contains(r2) == false) goto L5;
        return true;
    L5:
        return false;
    }
}
