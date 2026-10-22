package i01;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements h01.b {
    public Function1<? super Long, Boolean> a;

    public a() {
    }

    @Override // h01.b
    public final void a(Function1<? super Long, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2;
    }
}
