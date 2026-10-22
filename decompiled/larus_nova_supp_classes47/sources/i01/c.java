package i01;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements h01.d {
    public final b a;
    public final a b;

    public c() {
        this.a = new b();
        this.b = new a();
    }

    @Override // h01.d
    public final void a(Function1<? super h01.c, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.invoke(this.a);
    }

    @Override // h01.d
    public final void b(Function1<? super h01.b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.invoke(this.b);
    }
}
