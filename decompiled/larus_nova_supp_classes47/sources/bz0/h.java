package bz0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements yy0.e {
    public final cq2.b a;

    public h(cq2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2;
    }

    @Override // yy0.e
    public final void a(Function1<? super yy0.f, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        r3.invoke(new i(this.a));
    }
}
