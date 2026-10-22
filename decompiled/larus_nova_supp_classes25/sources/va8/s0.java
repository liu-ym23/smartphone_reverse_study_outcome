package va8;

import ic8.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s0 implements j0 {
    public final String a;

    public s0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
    }

    @Override // va8.j0
    public final String a(w r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        return this.a;
    }
}
