package up9;

import kotlin.jvm.internal.Intrinsics;
import up9.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x<S extends j0> {
    public S a;

    public x() {
    }

    public final S a() {
        S r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("currentState");
        return null;
    L6:
        return r0;
    }
}
